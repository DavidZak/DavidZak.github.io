package Helpers.Exceptions;

import Helpers.ProjectFinalsContainer;

public class RouteNotFoundException extends Exception {
    @Override
    public String getMessage() {
        return ProjectFinalsContainer.ROUTE_NOT_FOUND_EXCEPTION_MESSAGE;
    }
}
