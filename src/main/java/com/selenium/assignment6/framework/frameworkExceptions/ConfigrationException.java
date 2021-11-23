package com.selenium.assignment6.framework.frameworkExceptions;

public class ConfigrationException extends RuntimeException{

    String exceptiomMessage;
    String cause;

    public ConfigrationException(String message){
        this.cause=message;
    }

    public String toString(){
        exceptiomMessage="Error in configration file. Please check the file for any errors or invalid input";
        exceptiomMessage += "Exception occured due to: " + cause;
        return exceptiomMessage;
    }
}
