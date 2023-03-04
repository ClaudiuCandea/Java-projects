package Bll.Validators;

/**
 * Interface for validate Object
 * @param <T> generic param
 */

public interface Validator <T> {

        /**
         * Method for validate Object
         * @param t object to be validate
         */
        public void validate(T t);
}
