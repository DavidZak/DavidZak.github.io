package UIFacade.CommandParser;

import Helpers.ProjectFinalsContainer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandParser {    //парсер введенной команды

    private String[] parts;     //разбитые части команды

    public void parseString(String stringToParse) {

        String[] splitedParts = splitCommandString(stringToParse);

        for (int i = 0; i < splitedParts.length; i++) {
            System.out.println(splitedParts[i]);
        }

        if (splitedParts.length == 5 && (splitedParts[0].equals("route") || splitedParts[0].equals("route-ip"))) {
            this.parts = splitedParts;
            return;
        }

        System.out.println(ProjectFinalsContainer.PARSING_FAILED);
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

    public boolean checkIDRegExp(String string){        //проверка на соответствие ID
        Pattern p = Pattern.compile("^[0-9]\\d*$");
        Matcher m = p.matcher(string);
        return m.matches();
    }

    public boolean checkIPRegExp(String string){        //проверка на соответствие IP
        Pattern p = Pattern.compile("((25[0-5]|2[0-4]\\d|[01]?\\d\\d?)\\.){3}(25[0-5]|2[0-4]\\d|[01]?\\d\\d?)");
        Matcher m = p.matcher(string);
        return m.matches();
    }

    public boolean checkNameRegExp(String playerNameString) {
        Pattern p = Pattern.compile("^[A-Z][a-z]+$");
        Matcher m = p.matcher(playerNameString);
        return m.matches();
    }
}
