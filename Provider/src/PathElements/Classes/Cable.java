package PathElements.Classes;

import PathElements.AbstractClasses.PathElement;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "CableElement")
public class Cable extends PathElement {

    public Cable(){

    }

    public Cable(int ID) {
        super(ID);
    }
}
