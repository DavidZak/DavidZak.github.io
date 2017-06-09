package UIFacade;

import ApplicationFacade.ApplicationFacade;
import Helpers.ApplicationData.ApplicationDataContainer;
import Helpers.ConnectionData;
import Helpers.Exceptions.CustomIOException;
import Helpers.Exceptions.CustomJaxbException;
import Helpers.IPAddress;
import Helpers.ProjectFinalsContainer;
import Network.Network;
import PathElements.AbstractClasses.PathElement;
import PathElements.Classes.*;
import RouteProvider.PathFinders.MinimalCostPathFinder;
import RouteProvider.PathFinders.MinimalCountPathFinder;
import RouteProvider.PathFinders.MinimalTimePathFinder;
import RouteProvider.PathFinders.PathFinder;
import RouteProvider.RouteProvider;
import UIFacade.CommandParser.CommandParser;
import UIFacade.CommandPattern.*;
import sun.nio.ch.Net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.Provider;

public class UIInputCommandHelper {

    Command routeByIDCommand;
    Command routeByIPCommand;
    Command addNetworkCommand;
    Command addRouteProviderCommand;
    Command addPathElementCommand;
    Command removeNetworkCommand;
    Command removeRouteProviderCommand;
    Command removePathElementCommand;

    ApplicationDataContainer dataContainer;

    BufferedReader reader;
    CommandParser parser;

    UIInputCommandHelper() {
        dataContainer = ApplicationDataContainer.getInstance();
        dataContainer.readData();       //считываем данные из файла
        parser = new CommandParser();
        initReader();
    }

    void initReader() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void readChooseCommandNumberCommand() {   //метод для чтения выбора номера команды
        System.out.println(ProjectFinalsContainer.CHOOSE_COMMAND);
        boolean notANumber = false;

        String commandNumberString = readInput();
        try {
            int commandNumber = Integer.parseInt(commandNumberString);
            switch (commandNumber) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    readAddNetworkCommand();
                    break;
                case 2:
                    readRemoveNetworkCommand();
                    break;
                case 3:
                    readAddRouteProviderCommand();
                    break;
                case 4:
                    readRemoveRouteProviderCommand();
                    break;
                case 5:
                    readAddPathElementCommand();
                    break;
                case 6:
                    readRemovePathElementCommand();
                    break;
                case 7:
                    readGetRouteCommand();
                    break;
                default:
                    notANumber = true;
                    break;
            }
        } catch (NumberFormatException e) {
            notANumber = true;
        }
        while (notANumber) {
            System.out.println(ProjectFinalsContainer.INPUT_COMMAND_TRY_AGAIN);
            readChooseCommandNumberCommand();
        }
    }

    public void readAddNetworkCommand() {        //метод для чтения добавления новой сети
        System.out.println(ProjectFinalsContainer.NETWORK_ADDING_PROCESS);
        System.out.println(ProjectFinalsContainer.ENTER_NAME);
        System.out.println(ProjectFinalsContainer.GO_TO_MAIN_COMMAND);

        String inputString = readInput();
        if (inputString.equals("0"))
            readChooseCommandNumberCommand();

        while (!parser.checkNameRegExp(inputString)) {
            inputString = readInput();
            if (inputString.equals("0"))
                readChooseCommandNumberCommand();
        }

        Network network = new Network(inputString);

        ApplicationFacade facade = new ApplicationFacade(network);
        addNetworkCommand = new AddNetworkCommand(facade);
        addNetworkCommand.execute();
        readChooseCommandNumberCommand();
    }

    public void readAddRouteProviderCommand() {      //для добавления нового провайдера
        System.out.println(ProjectFinalsContainer.ROUTE_PROVIDER_ADDING_PROCESS);
        System.out.println(ProjectFinalsContainer.ENTER_NAME);
        System.out.println(ProjectFinalsContainer.GO_TO_MAIN_COMMAND);

        String inputString = readInput();
        if (inputString.equals("0"))
            readChooseCommandNumberCommand();

        while (!parser.checkNameRegExp(inputString)) {
            inputString = readInput();
            if (inputString.equals("0"))
                readChooseCommandNumberCommand();
        }

        RouteProvider provider = new RouteProvider(inputString);

        readAddPathFinder(provider);

        ApplicationFacade facade = new ApplicationFacade(provider);
        addRouteProviderCommand = new AddRouteProviderCommand(facade);
        addRouteProviderCommand.execute();
        readChooseCommandNumberCommand();
    }

    public void readAddPathFinder(RouteProvider provider) {     //добавление поисковика
        System.out.println(ProjectFinalsContainer.PATH_FINDER_ADDING_PROCESS);
        System.out.println(ProjectFinalsContainer.ENTER_NAME);

        String inputString = readInput();
        while (!parser.checkNameRegExp(inputString)) {
            inputString = readInput();
        }

        PathFinder pathFinder = null;

        readPathFinderType(provider, pathFinder, inputString);
    }

    //считать тип поисковика
    void readPathFinderType(RouteProvider provider, PathFinder pathFinder, String inputString) {
        System.out.println(ProjectFinalsContainer.CHOOSE_PATH_FINDER_TYPE);

        boolean notANumber = false;

        String commandNumberString = readInput();
        try {
            int commandNumber = Integer.parseInt(commandNumberString);
            switch (commandNumber) {
                case 1: {
                    pathFinder = new MinimalCostPathFinder(inputString);
                    provider.pathFinder=pathFinder;
                }
                break;
                case 2:{
                    pathFinder = new MinimalTimePathFinder(inputString);
                    provider.pathFinder=pathFinder;
                }
                    break;
                case 3:{
                    pathFinder = new MinimalCountPathFinder(inputString);
                    provider.pathFinder=pathFinder;
                }
                    break;
                default:
                    notANumber = true;
                    break;
            }
        } catch (NumberFormatException e) {
            notANumber = true;
        }
        while (notANumber) {
            System.out.println(ProjectFinalsContainer.INPUT_COMMAND_TRY_AGAIN);
            readPathFinderType(provider, pathFinder, inputString);
        }
    }

    public void readAddPathElementCommand() {        //для добавления нового элемента
        System.out.println(ProjectFinalsContainer.PATH_ELEMENT_ADDING_PROCESS);

        System.out.println(ProjectFinalsContainer.CHOOSE_NETWORK);

        String string = readInput();
        Network network = new Network(string);
        while (!dataContainer.applicationData.networks.contains(network)) {
            string = readInput();
            network = new Network(string);
        }

        System.out.println(ProjectFinalsContainer.CHOOSE_PATH_ELEMENT_TYPE);
        System.out.println(ProjectFinalsContainer.GO_TO_MAIN_COMMAND);

        boolean notANumber = false;

        PathElement pathElement = null;

        String commandNumberString = readInput();
        try {
            int commandNumber = Integer.parseInt(commandNumberString);
            switch (commandNumber) {
                case 0:
                    readChooseCommandNumberCommand();
                    break;
                case 1: {
                    pathElement = new Cable();
                    if (network.pathElements.size() > 0)
                        readConnectionData(pathElement);
                    ApplicationFacade facade = new ApplicationFacade(network, pathElement);
                    addPathElementCommand = new AddPathElementCommand(facade);
                    addPathElementCommand.execute();
                    readChooseCommandNumberCommand();
                }
                break;
                case 2: {
                    pathElement = new Hub();
                    if (network.pathElements.size() > 0)
                        readConnectionData(pathElement);
                    ApplicationFacade facade = new ApplicationFacade(network, pathElement);
                    addPathElementCommand = new AddPathElementCommand(facade);
                    addPathElementCommand.execute();
                    readChooseCommandNumberCommand();
                }
                break;
                case 3: {
                    pathElement = new PC();
                    readIP(pathElement);
                    if (network.pathElements.size() > 0)
                        readConnectionData(pathElement);
                    ApplicationFacade facade = new ApplicationFacade(network, pathElement);
                    addPathElementCommand = new AddPathElementCommand(facade);
                    addPathElementCommand.execute();
                    readChooseCommandNumberCommand();
                }
                break;
                case 4: {
                    pathElement = new FireWall();
                    readIP(pathElement);
                    if (network.pathElements.size() > 0)
                        readConnectionData(pathElement);
                    ApplicationFacade facade = new ApplicationFacade(network, pathElement);
                    addPathElementCommand = new AddPathElementCommand(facade);
                    addPathElementCommand.execute();
                    readChooseCommandNumberCommand();
                }
                break;
                case 5: {
                    pathElement = new FireWall();
                    readIP(pathElement);
                    if (network.pathElements.size() > 0)
                        readConnectionData(pathElement);
                    ApplicationFacade facade = new ApplicationFacade(network, pathElement);
                    addPathElementCommand = new AddPathElementCommand(facade);
                    addPathElementCommand.execute();
                    readChooseCommandNumberCommand();
                }
                break;
                case 6: {
                    pathElement = new Router();
                    readIP(pathElement);
                    if (network.pathElements.size() > 0)
                        readConnectionData(pathElement);
                    ApplicationFacade facade = new ApplicationFacade(network, pathElement);
                    addPathElementCommand = new AddPathElementCommand(facade);
                    addPathElementCommand.execute();
                    readChooseCommandNumberCommand();
                }
                break;
                default:
                    notANumber = true;
                    break;
            }
        } catch (NumberFormatException e) {
            notANumber = true;
        }
        while (notANumber) {
            System.out.println(ProjectFinalsContainer.INPUT_COMMAND_TRY_AGAIN);
            readAddPathElementCommand();
        }
    }

    void readIP(PathElement pathElement) {          //добавление IP
        System.out.println(ProjectFinalsContainer.ENTER_IP);
        String string = readInput();
        while (!parser.checkIPRegExp(string)) {
            string = readInput();
        }
        pathElement.IP = new IPAddress(string);
    }

    void readConnectionData(PathElement pathElement) {      //добавление связи
        System.out.println(ProjectFinalsContainer.INPUT_CONNECTION_DATA_PARAMETERS);
        System.out.println(ProjectFinalsContainer.GO_TO_MAIN_COMMAND);

        String string = readInput();

        if (string.equals("0"))
            return;

        String[] splits = string.split(" ");
        int id = Integer.parseInt(splits[0]);
        int cost = Integer.parseInt(splits[1]);
        int time = Integer.parseInt(splits[2]);
        ConnectionData connectionData = new ConnectionData(id, (double) cost, (double) time);
        pathElement.connections.add(connectionData);
        readConnectionData(pathElement);
    }

    public void readRemoveNetworkCommand() {     //для удаления сети
        System.out.println(ProjectFinalsContainer.NETWORK_REMOVING_PROCESS);
        System.out.println(ProjectFinalsContainer.ENTER_NAME);
        System.out.println(ProjectFinalsContainer.GO_TO_MAIN_COMMAND);

        String inputString = readInput();
        if (inputString.equals("0"))
            readChooseCommandNumberCommand();

        while (!parser.checkNameRegExp(inputString)) {
            inputString = readInput();
            if (inputString.equals("0"))
                readChooseCommandNumberCommand();
        }

        Network network = new Network(inputString);

        ApplicationFacade facade = new ApplicationFacade(network);
        removeNetworkCommand = new RemoveNetworkCommand(facade);
        removeNetworkCommand.execute();
        readChooseCommandNumberCommand();
    }       //удаление сети

    public void readRemoveRouteProviderCommand() {   //для удаления провайдера
        System.out.println(ProjectFinalsContainer.ROUTE_PROVIDER_REMOVING_PROCESS);
        System.out.println(ProjectFinalsContainer.ENTER_NAME);
        System.out.println(ProjectFinalsContainer.GO_TO_MAIN_COMMAND);

        String inputString = readInput();
        if (inputString.equals("0"))
            readChooseCommandNumberCommand();

        while (!parser.checkNameRegExp(inputString)) {
            inputString = readInput();
            if (inputString.equals("0"))
                readChooseCommandNumberCommand();
        }

        RouteProvider provider = new RouteProvider(inputString);

        ApplicationFacade facade = new ApplicationFacade(provider);
        removeRouteProviderCommand = new RemoveRouteProviderCommand(facade);
        removeRouteProviderCommand.execute();
        readChooseCommandNumberCommand();
    }       //удаление провайдера

    public void readRemovePathElementCommand() {     //для удаления элемента
        System.out.println(ProjectFinalsContainer.PATH_ELEMENT_REMOVING_PROCESS);
        System.out.println(ProjectFinalsContainer.CHOOSE_NETWORK);

        String string = readInput();
        Network network1 = new Network(string);
        while (!dataContainer.applicationData.networks.contains(network1)) {
            string = readInput();
        }

        Network network = dataContainer.getNetwork(string);

        readPathElementID(network);

    }

    void readPathElementID(Network network){        //чтение ID
        System.out.println(ProjectFinalsContainer.CHOOSE_PATH_ELEMENT_ID);

        String inputString = readInput();

        while (!parser.checkIDRegExp(inputString)) {
            inputString = readInput();
        }

        int ID = Integer.parseInt(inputString);
        System.out.println(network.pathElements);
        PathElement pathElement = network.pathElements.stream()
                .filter((element) -> element.ID == ID)
                .findFirst()
                .orElse(null);

        while (pathElement == null){
            readPathElementID(network);
        }

        ApplicationFacade facade = new ApplicationFacade(network, pathElement);
        removePathElementCommand = new RemovePathElementCommand(facade);
        removePathElementCommand.execute();
        readChooseCommandNumberCommand();
    }

    public void readGetRouteCommand() {      //для поиска пути

        System.out.println(ProjectFinalsContainer.INPUT_COMMAND);
        System.out.println(ProjectFinalsContainer.SELECT_COMMAND_HELPER);

        String inputString = readInput();
        if (inputString.equals("0")) {
            readChooseCommandNumberCommand();
            return;
        }
        parser.parseString(inputString);

        String[] parts = parser.getParts();     //делим строку с помощью парсера
        if (parts != null) {

            Network network = dataContainer.getNetwork(parts[1]);
            RouteProvider provider = dataContainer.getRouteProvider(parts[2]);

            if (network != null && provider != null) {

                ApplicationFacade facade = null;
                if (parser.checkIDRegExp(parts[3]) && parser.checkIDRegExp(parts[4])) {
                    facade = new ApplicationFacade(network, provider,
                            Integer.parseInt(parts[3]), Integer.parseInt(parts[4]));    //инициируем фасад приложения с данными из строки

                    routeByIDCommand = new RouteByIDCommand(facade);

                    routeByIDCommand.execute();

                    System.out.println(ProjectFinalsContainer.GO_TO_MAIN_COMMAND);
                    String input = readInput();
                    while (!input.equals("0")) {
                        input = readInput();
                    }
                    readChooseCommandNumberCommand();
                    return;
                }

                if (parser.checkIPRegExp(parts[3]) && parser.checkIPRegExp(parts[4])) {

                    facade = new ApplicationFacade(network, provider,
                            new IPAddress(parts[3]), new IPAddress(parts[4]));  //инициируем фасад приложения с данными из строки

                    routeByIPCommand = new RouteByIPCommand(facade);

                    routeByIPCommand.execute();

                    System.out.println(ProjectFinalsContainer.GO_TO_MAIN_COMMAND);
                    String input = readInput();
                    while (!input.equals("0")) {
                        input = readInput();
                    }

                    readChooseCommandNumberCommand();
                    return;
                }
            }
        }
        System.out.println(ProjectFinalsContainer.INPUT_COMMAND_TRY_AGAIN);     //неудача, предложим ввести команду еще раз
        readGetRouteCommand();
    }

    public String readInput() {     //считываем вводимые данные

        initReader();

        String inputString = null;

        try {

            inputString = reader.readLine();
            return inputString;
        } catch (IOException e) {
            new CustomIOException().getMessage();
        }
        return null;
    }
}
