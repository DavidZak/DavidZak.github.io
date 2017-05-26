package UIFacade.CommandParser;

import Helpers.Exceptions.RouteNotFoundException;
import UIFacade.CommandPattern.Command;
import UIFacade.CommandPattern.FindRouteWithMinimalCostCommand;
import UIFacade.CommandPattern.FindRouteWithMinimalCountCommand;
import UIFacade.CommandPattern.FindRouteWithMinimalTimeCommand;

public class CommandParser {

    public void parseString(String stringToParse) throws RouteNotFoundException {

        String[] splitedParts=splitCommandString(stringToParse);

        if (splitedParts.length==5 && splitedParts[0].equals("route")){
            System.out.println("id parsed");
            if (splitedParts[2].equals("minCost"))
                new FindRouteWithMinimalCostCommand().getRouteByID(splitedParts);
            if (splitedParts[2].equals("minTime"))
                new FindRouteWithMinimalTimeCommand().getRouteByID(splitedParts);
            if (splitedParts[2].equals("minCount"))
                new FindRouteWithMinimalCountCommand().getRouteByID(splitedParts);
            return;
        }
        if (splitedParts.length==5 && splitedParts[0].equals("route-ip")){
            System.out.println("ip parsed");
            if (splitedParts[2].equals("minCost"))
                new FindRouteWithMinimalCostCommand().getRouteByIP(splitedParts);
            if (splitedParts[2].equals("minTime"))
                new FindRouteWithMinimalTimeCommand().getRouteByIP(splitedParts);
            if (splitedParts[2].equals("minCount"))
                new FindRouteWithMinimalCountCommand().getRouteByIP(splitedParts);
            return;
        }
        System.out.println("not parsed");
        return;
    }

    String[] splitCommandString(String inputString){
        String[] splits=inputString.split(" ");
        return splits;
    }
}
