package UIFacade.CommandParser;

import UIFacade.CommandPattern.Command;
import UIFacade.CommandPattern.FindRouteByIDCommand;
import UIFacade.CommandPattern.FindRouteByIPCommand;
import UIFacade.UIFacade;

public class CommandParser {

    public String parseString(String stringToParse){

        String result;
        String[] splitedParts=splitCommandString(stringToParse);

        if (splitedParts.length==5 && splitedParts[0].equals("route")){
            result="parsed(id)";
            return result;
        }
        if (splitedParts.length==5 && splitedParts[0].equals("route-ip")){
            result="parsed(ip)";
            return result;
        }
        result="not parsed";
        return result;
    }

    String[] splitCommandString(String inputString){
        String[] splits=inputString.split(" ");
        return splits;
    }
}
