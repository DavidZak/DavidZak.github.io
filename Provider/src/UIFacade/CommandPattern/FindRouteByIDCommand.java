package UIFacade.CommandPattern;

import UIFacade.CommandPattern.Command;
import UIFacade.UIFacade;

public class FindRouteByIDCommand implements Command {

    @Override
    public void execute() {
        System.out.println("id command");
    }
}
