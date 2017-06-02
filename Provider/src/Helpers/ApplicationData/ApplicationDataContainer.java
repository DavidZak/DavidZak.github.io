package Helpers.ApplicationData;

import Helpers.ProjectsStringsContainer;
import Network.Network;
import RouteProvider.RouteProvider;
import XMLParser.JaxbParser;
import XMLParser.Parser;

import javax.xml.bind.JAXBException;
import java.io.File;

public class ApplicationDataContainer {
    private static ApplicationDataContainer instance;

    private ApplicationDataContainer() {

    }

    public static ApplicationDataContainer getInstance() {
        if (instance == null)
            instance = new ApplicationDataContainer();
        return instance;
    }

    public ApplicationData applicationData=new ApplicationData();
    public Parser parser=new JaxbParser();

    public void addNetwork(Network network) {
        applicationData.networks.add(network);
        try {
            parser.saveObject(new File(ProjectsStringsContainer.FILE_PATH), applicationData);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public void addRouteProvider(RouteProvider provider) {
        applicationData.routeProviders.add(provider);
        try {
            parser.saveObject(new File(ProjectsStringsContainer.FILE_PATH), applicationData);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public void removeNetwork(Network network) {
        applicationData.networks.remove(network);
        try {
            parser.saveObject(new File(ProjectsStringsContainer.FILE_PATH), applicationData);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public void removeRouteProvider(RouteProvider provider) {
        applicationData.routeProviders.remove(provider);
        try {
            parser.saveObject(new File(ProjectsStringsContainer.FILE_PATH), applicationData);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public void readData() {
        try {
            applicationData = (ApplicationData) parser.getObject(new File(ProjectsStringsContainer.FILE_PATH), ApplicationData.class);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
