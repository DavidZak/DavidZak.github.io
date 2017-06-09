package Helpers.Exceptions;

import Helpers.ProjectFinalsContainer;

import java.io.IOException;

public class CustomIOException extends IOException {
    public CustomIOException(){

    }

    @Override
    public String getMessage() {
        return ProjectFinalsContainer.IO_EXCEPTION_MESSAGE;
    }
}
