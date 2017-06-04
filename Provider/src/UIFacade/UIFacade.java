package UIFacade;

import Helpers.Exceptions.RouteNotFoundException;
import Helpers.ProjectFinalsContainer;
import UIFacade.CommandParser.CommandParser;
import UIFacade.CommandPattern.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UIFacade {

    Command routeByIDCommand;
    Command routeByIPCommand;

    public UIFacade(Command routeByIDCommand,Command routeByIPCommand) {
        this.routeByIDCommand = routeByIDCommand;
        this.routeByIPCommand = routeByIPCommand;
    }

    public void executeByID(){
        try {
            routeByIDCommand.execute();
        } catch (RouteNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void executeByIP(){
        try {
            routeByIPCommand.execute();
        } catch (RouteNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void readInput() throws RouteNotFoundException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String inputString = null;
        try {
            inputString = bufferedReader.readLine();
        } catch (IOException e) {
            System.out.println(ProjectFinalsContainer.IO_EXCEPTION_MESSAGE);
        }
        executeCommand(inputString);
    }

    private void executeCommand(String command) throws RouteNotFoundException {
        CommandParser parser = new CommandParser();
        parser.parseString(command);

        String[] parts = parser.getParts();
        if (parts != null) {
            if (parser.checkIDRegExp(parts[3]) && parser.checkIDRegExp(parts[4])){
                executeByID();
                return;
            }
            if (parser.checkIPRegExp(parts[3]) && parser.checkIPRegExp(parts[4])){
                executeByIP();
                return;
            }
            System.out.println("косяк, введите ещё!!!");
            readInput();
        }
    }
}
