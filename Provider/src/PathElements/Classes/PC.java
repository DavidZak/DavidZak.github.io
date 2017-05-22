package PathElements.Classes;

import Helpers.IPAdress;
import PathElements.Interfaces.ActiveElement;
import PathElements.Interfaces.PathElement;

import java.util.List;

public class PC implements ActiveElement{
    @Override
    public double getTimeDelay() {
        return 0;
    }

    @Override
    public double getCost() {
        return 0;
    }

    @Override
    public List<PathElement> getConnections() {
        return null;
    }

    @Override
    public int hetID() {
        return 0;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public IPAdress getIP() {
        return null;
    }
}
