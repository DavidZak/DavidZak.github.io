package UIFacade;

import Helpers.Exceptions.RouteNotFoundException;
import Helpers.ProjectsStringsContainer;
import Network.Network;
import UIFacade.CommandParser.CommandParser;
import UIFacade.CommandPattern.Command;
import UIFacade.CommandPattern.RouteByIDCommand;

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
            System.out.println(ProjectsStringsContainer.IO_EXCEPTION_MESSAGE);
        }
        executeCommand(inputString);
    }

    private void executeCommand(String command) throws RouteNotFoundException {
        CommandParser parser = new CommandParser();
        parser.parseString(command);

        String[] parts = parser.getParts();
        if (parts != null) {
            int first=0;
            int second=0;
            try {
                first=Integer.parseInt(parts[3]);
                second=Integer.parseInt(parts[4]);
            } catch (NumberFormatException e){
                e.printStackTrace();
            }
            executeByID();
        }
    }
}
