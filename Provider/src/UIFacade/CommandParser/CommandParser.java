package UIFacade.CommandParser;

import Helpers.Exceptions.RouteNotFoundException;
import UIFacade.CommandPattern.RouteWithMinimalCostCommand;

public class CommandParser {

    public void parseString(String stringToParse) throws RouteNotFoundException {

        String[] splitedParts = splitCommandString(stringToParse);
        for (int i = 0; i < splitedParts.length; i++) {
            System.out.println(splitedParts[i]);
        }

        if (splitedParts.length == 5 && splitedParts[0].equals("route")) {
            new RouteWithMinimalCostCommand(splitedParts[1], splitedParts[2], splitedParts[3], splitedParts[4]).execute();
            return;
        }
        if (splitedParts.length == 5 && splitedParts[0].equals("route-ip")) {

        }
        System.out.println("not parsed");
        return;
    }

    String[] splitCommandString(String inputString) {
        String[] splits = inputString.split(" ");
        return splits;
    }
}
