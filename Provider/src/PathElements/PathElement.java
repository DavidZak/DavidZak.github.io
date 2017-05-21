package PathElements;

import java.util.List;

public interface PathElement {
    public double getTimeDelay();
    public double getCost();
    public List<PathElement> getConnections();
    public int hetID();
}
