package PathElements.Classes;

import PathElements.Interfaces.PassiveElement;
import PathElements.Interfaces.PathElement;

import java.util.List;

public class Cable implements PassiveElement {
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
}
