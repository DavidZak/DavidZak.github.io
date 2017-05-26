package UIFacade;

import Helpers.Exceptions.RouteNotFoundException;
import UIFacade.CommandParser.CommandParser;
import UIFacade.CommandPattern.FindRouteWithMinimalCostCommand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UIFacade {

    private static UIFacade instance;
    private UIFacade(){

    }

    public static UIFacade getInstance() {
        if (instance==null)
            instance=new UIFacade();
        return instance;
    }

    public void readInput() throws RouteNotFoundException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String inputString = null;
        try {
            inputString = bufferedReader.readLine();
        } catch (IOException e) {
            System.out.println("input exception");
            e.printStackTrace();
        }
        executeCommand(inputString);
    }

    public void executeCommand(String command) throws RouteNotFoundException {
        new CommandParser().parseString(command);
    }
}
