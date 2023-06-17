package com.driver;

public class ValidLicenseGenerationException extends Throwable {
    public ValidLicenseGenerationException(String valid_license_cannot_be_generated) {
        super(valid_license_cannot_be_generated);
    }
}
