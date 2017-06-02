package UIFacade.CommandParser;

import Helpers.Exceptions.RouteNotFoundException;
import UIFacade.CommandPattern.Command;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public boolean checkIDRegExp(String string){
        Pattern p = Pattern.compile("^[1-9]\\d*$");
        Matcher m = p.matcher(string);
        return m.matches();
    }

    public boolean checkIPRegExp(String string){
        Pattern p = Pattern.compile("((25[0-5]|2[0-4]\\d|[01]?\\d\\d?)\\.){3}(25[0-5]|2[0-4]\\d|[01]?\\d\\d?)");
        Matcher m = p.matcher(string);
        return m.matches();
    }
}
