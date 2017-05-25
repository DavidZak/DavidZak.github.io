package Main;

import Network.Network;
import PathElements.Classes.Switch;
import PathElements.AbstractClasses.PathElement;
import UIFacade.UIFacade;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        UIFacade.getInstance().executeCommand("route 1 3 net cost");

    }
}
