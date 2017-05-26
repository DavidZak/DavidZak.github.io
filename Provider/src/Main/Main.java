package Main;

import Helpers.Exceptions.RouteNotFoundException;
import Network.Network;
import PathElements.Classes.Switch;
import PathElements.AbstractClasses.PathElement;
import UIFacade.UIFacade;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws RouteNotFoundException {

        UIFacade.getInstance().readInput();

    }
}
