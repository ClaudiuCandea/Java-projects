package Bll.Validators;

import Model.Client;

/**
 * Class for validating the age for a client
 */

public class AgeValidator implements Validator<Client> {

    private static final int MIN_AGE = 10;

    /**
     * Method for  validating the age for a client
     * @param t Client to be validate
     */
    public void validate(Client t) {

        if (t.getAge() < MIN_AGE) {
            throw new IllegalArgumentException("The Client Age limit is not respected!");
        }

    }
}
