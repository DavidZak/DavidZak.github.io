package UIFacade;

import ApplicationFacade.ApplicationFacade;
import Helpers.ApplicationData.ApplicationDataContainer;
import Helpers.IPAddress;
import Helpers.ProjectFinalsContainer;
import Network.Network;
import RouteProvider.RouteProvider;
import UIFacade.CommandParser.CommandParser;
import UIFacade.CommandPattern.Command;
import UIFacade.CommandPattern.RouteByIDCommand;
import UIFacade.CommandPattern.RouteByIPCommand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UIFacade {

    ApplicationDataContainer dataContainer;

    Command routeByIDCommand;
    Command routeByIPCommand;

    public UIFacade() {
        dataContainer=ApplicationDataContainer.getInstance();
        dataContainer.readData();
    }

    public void executeByID() {
        routeByIDCommand.execute();
    }

    public void executeByIP() {
        routeByIPCommand.execute();
    }

    public void readInput() {
        dataContainer.showApplicationData();
        System.out.println(ProjectFinalsContainer.INPUT_COMMAND);
        System.out.println(ProjectFinalsContainer.SELECT_COMMAND_HELPER);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String inputString = null;
        try {
            inputString = bufferedReader.readLine();
        } catch (IOException e) {
            System.out.println(ProjectFinalsContainer.IO_EXCEPTION_MESSAGE);
        }
        executeCommand(inputString);
    }

    private void executeCommand(String command) {
        CommandParser parser = new CommandParser();
        parser.parseString(command);

        //ApplicationDataContainer data = ApplicationDataContainer.getInstance();
        //data.readData();
        //data.showApplicationData();

        String[] parts = parser.getParts();
        if (parts != null) {

            Network network = dataContainer.getNetwork(parts[1]);
            RouteProvider provider = dataContainer.getRouteProvider(parts[2]);

            System.out.println(network);
            System.out.println(provider);

            if (network!=null && provider!=null) {

                ApplicationFacade facade = null;
                if (parser.checkIDRegExp(parts[3]) && parser.checkIDRegExp(parts[4])) {
                    facade = new ApplicationFacade(network, provider,
                            Integer.parseInt(parts[3]), Integer.parseInt(parts[4]));

                    routeByIDCommand = new RouteByIDCommand(facade);

                    executeByID();

                    return;
                }

                if (parser.checkIPRegExp(parts[3]) && parser.checkIPRegExp(parts[4])) {

                    facade = new ApplicationFacade(network, provider,
                            new IPAddress(parts[3]), new IPAddress(parts[4]));

                    routeByIPCommand = new RouteByIPCommand(facade);

                    executeByIP();

                    return;
                }
            }
            System.out.println(ProjectFinalsContainer.INPUT_COMMAND_TRY_AGAIN);
            readInput();
        }
    }
}
