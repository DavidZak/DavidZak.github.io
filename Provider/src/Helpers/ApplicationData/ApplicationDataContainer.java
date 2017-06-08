package Helpers.ApplicationData;

import Helpers.ProjectFinalsContainer;
import Network.Network;
import PathElements.AbstractClasses.PathElement;
import RouteProvider.PathFinders.PathFinder;
import RouteProvider.RouteProvider;
import XMLParser.JaxbParser;
import XMLParser.Parser;

import javax.xml.bind.JAXBException;
import java.io.File;

public class ApplicationDataContainer {     //класс для манипуляции с данными (синглтон)

    private static ApplicationDataContainer instance;

    private ApplicationDataContainer() {

    }

    public static ApplicationDataContainer getInstance() {
        if (instance == null)
            instance = new ApplicationDataContainer();
        return instance;
    }

    public ApplicationData applicationData = new ApplicationData();
    public Parser parser = new JaxbParser();

    public void showApplicationData() {
        System.out.println(applicationData);
    }

    public void addPathElement(Network network, PathElement element) {
        if (!applicationData.networks.contains(network))
            return;

        if (network.pathElements.contains(element))
            return;

        element.ID = getNetwork(network.networkName).pathElements.size();
        network.pathElements.add(element);
        removeNetwork(network);
        addNetwork(network);
        try {
            parser.saveObject(new File(ProjectFinalsContainer.FILE_PATH), applicationData);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public void removePathElement(Network network, PathElement element) {
        if (!applicationData.networks.contains(network))
            return;

        if (!network.pathElements.contains(element))
            return;

        network.pathElements.remove(element);
        removeNetwork(network);
        addNetwork(network);
        try {
            parser.saveObject(new File(ProjectFinalsContainer.FILE_PATH), applicationData);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public void addNetwork(Network network) {
        if (applicationData.networks.contains(network)) {
            return;
        }
        network.id = applicationData.networks.size();
        applicationData.networks.add(network);
        try {
            parser.saveObject(new File(ProjectFinalsContainer.FILE_PATH), applicationData);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public void addRouteProvider(RouteProvider provider) {
        if (applicationData.routeProviders.contains(provider)) {
            return;
        }
        applicationData.routeProviders.add(provider);
        try {
            parser.saveObject(new File(ProjectFinalsContainer.FILE_PATH), applicationData);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public void addPathFinder(RouteProvider provider, PathFinder pathFinder) {
        if (!applicationData.routeProviders.contains(provider)){
            return;
        }
        applicationData.routeProviders.remove(provider);
        provider.pathFinder=pathFinder;
        applicationData.routeProviders.add(provider);
        try {
            parser.saveObject(new File(ProjectFinalsContainer.FILE_PATH), applicationData);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }


    public Network getNetwork(String name) {
        Network network = new Network(name);
        for (Network network1 : applicationData.networks) {
            if (network1.equals(network))
                return network1;
        }
        return null;
    }

    public RouteProvider getRouteProvider(String name) {
        RouteProvider provider = new RouteProvider(name);
        for (RouteProvider provider1 : applicationData.routeProviders) {
            if (provider1.equals(provider))
                return provider1;
        }
        return null;
    }

    public void removeNetwork(Network network) {
        applicationData.networks.remove(network);
        try {
            parser.saveObject(new File(ProjectFinalsContainer.FILE_PATH), applicationData);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public void removeRouteProvider(RouteProvider provider) {
        applicationData.routeProviders.remove(provider);
        try {
            parser.saveObject(new File(ProjectFinalsContainer.FILE_PATH), applicationData);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public void readData() {
        try {
            applicationData = (ApplicationData) parser.getObject(new File(ProjectFinalsContainer.FILE_PATH), ApplicationData.class);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
