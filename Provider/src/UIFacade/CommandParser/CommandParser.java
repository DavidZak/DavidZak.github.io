package UIFacade.CommandParser;

import Helpers.Exceptions.RouteNotFoundException;
import UIFacade.CommandPattern.Command;

public class CommandParser {

    private String[] parts;

    public void parseString(String stringToParse) throws RouteNotFoundException {

        String[] splitedParts = splitCommandString(stringToParse);
        for (int i = 0; i < splitedParts.length; i++) {
            System.out.println(splitedParts[i]);
        }

        if (splitedParts.length == 5 && splitedParts[0].equals("route")) {
            this.parts = splitedParts;
            return;
        }

        if (splitedParts.length == 5 && splitedParts[0].equals("route-ip")) {
            this.parts = splitedParts;
            return;
        }

        System.out.println("not parsed");
        return;
    }

    String[] splitCommandString(String inputString) {
        String[] splits = inputString.split(" ");
        return splits;
    }

    public String[] getParts() {
        return parts;
    }

    public void setParts(String[] parts) {
        this.parts = parts;
    }
}
