package Helpers.Exceptions;

import Helpers.ProjectsStringsContainer;

public class RouteNotFoundException extends Exception {
    @Override
    public String getMessage() {
        return ProjectsStringsContainer.ROUTE_NOT_FOUND_EXCEPTION_MESSAGE;
    }
}
