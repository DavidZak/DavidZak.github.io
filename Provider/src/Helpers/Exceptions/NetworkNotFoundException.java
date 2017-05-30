package Helpers.Exceptions;

import Helpers.ProjectsStringsContainer;

public class NetworkNotFoundException extends Exception {
    @Override
    public String getMessage() {
        return ProjectsStringsContainer.NETWORK_NOT_FOUND_EXCEPTION_MESSAGE;
    }
}
