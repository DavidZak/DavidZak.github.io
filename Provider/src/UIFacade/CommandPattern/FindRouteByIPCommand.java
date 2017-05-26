package UIFacade.CommandPattern;

import UIFacade.CommandPattern.Command;
import UIFacade.UIFacade;

public class FindRouteByIPCommand implements Command {

    @Override
    public void execute() {
        System.out.println("ip command");
    }
}
