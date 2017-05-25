package UIFacade;

import javax.print.DocFlavor;

public class CommandParser {
    private String stringToParse;

    public String getStringToParse() {
        return stringToParse;
    }

    public void setStringToParse(String stringToParse) {
        this.stringToParse = stringToParse;
    }

    public CommandParser(String stringToParse){
        this.stringToParse=stringToParse;
        parseString(this.stringToParse);
    }

    public String parseString(String stringToParse){
        String[] splits=stringToParse.split(" ");
        if (splits.length==5){
            if (splits[0].equals("route")){
                new FindRouteByIDCommand().execute();
                return "ID route";
            }
            if (splits[0].equals("route-ip")){
                new FindRouteByIPCommand().execute();
                return "IP route";
            }
        }
        return "null route";
    }
}
