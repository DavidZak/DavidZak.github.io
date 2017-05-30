package UIFacade;

import Helpers.Exceptions.RouteNotFoundException;
import Helpers.ProjectsStringsContainer;
import UIFacade.CommandParser.CommandParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UIFacade {

    private static UIFacade instance;

    private UIFacade() {

    }

    public static UIFacade getInstance() {
        if (instance == null)
            instance = new UIFacade();
        return instance;
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
        new CommandParser().parseString(command);
    }
}
