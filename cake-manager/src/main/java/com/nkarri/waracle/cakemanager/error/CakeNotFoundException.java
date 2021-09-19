package com.nkarri.waracle.cakemanager.error;

public class CakeNotFoundException extends RuntimeException {

    public CakeNotFoundException(Long id) {
        super("Could not find cake " + id);
    }
}
