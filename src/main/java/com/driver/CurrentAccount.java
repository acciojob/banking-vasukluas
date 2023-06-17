package com.driver;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance,double minBalance ,String tradeLicenseId) throws Exception {
        super(name,balance,minBalance);
        this.tradeLicenseId=tradeLicenseId;

        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception

    }

    public void validateLicenseId() throws Exception, ValidLicenseGenerationException {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        StringBuilder validLicenseId = new StringBuilder(tradeLicenseId);
        int length = tradeLicenseId.length();

        for (int i = 1; i < length; i += 2) {
            if (tradeLicenseId.charAt(i) == tradeLicenseId.charAt(i - 1)) {
                // Rearrange characters to create a valid license Id
                for (int j = i + 1; j < length; j++) {
                    if (tradeLicenseId.charAt(j) != tradeLicenseId.charAt(i - 1)) {
                        char temp = validLicenseId.charAt(i);
                        validLicenseId.setCharAt(i, validLicenseId.charAt(j));
                        validLicenseId.setCharAt(j, temp);
                        break;
                    }
                }

                if (tradeLicenseId.charAt(i) == tradeLicenseId.charAt(i - 1)) {
                    throw new ValidLicenseGenerationException("Valid License cannot be generated");
                }
            }
        }

        tradeLicenseId = validLicenseId.toString();
    }

}
