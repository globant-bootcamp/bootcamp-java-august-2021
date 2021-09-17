package com.globant.springBootProject.utils;

public class Constants {

    public enum ResponseConstants {
        SUCCESS("Successful"),
        FAILURE("Unsuccessful");

        private String description;

        // addConstructor
        ResponseConstants(final String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
}
