package Helpers.Exceptions;

import Helpers.ProjectFinalsContainer;

import javax.xml.bind.JAXBException;

public class CustomJaxbException extends JAXBException {

    public CustomJaxbException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return ProjectFinalsContainer.JAXB_EXCEPTION_MESSAGE;
    }
}
