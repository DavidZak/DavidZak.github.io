package Helpers.Exceptions;

import Helpers.ProjectsStringsContainer;

public class ProviderNotFoundException extends Exception {

    @Override
    public String getMessage() {
        return ProjectsStringsContainer.PROVIDER_NOT_FOUND_EXCEPTION_MESSAGE;
    }
}
