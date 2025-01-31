package it.unibo.mvc;

import java.util.List;

/**
 * simple controller responsible of I/O access.
 * It considers only the standard output, and it is able to print on it.
 */
public interface Controller {

    /**
     * Sets the next string to print.
     *
     * @param stringToSet the string to set.
     *
     * @throws NullPointerException if the string passed as input in null.
     */
    void setString(String stringToSet);

    /**
     * @return The next string to print
     */
    String getSettedString();

    /**
     *
     * @return A List<String> with all the past strings that were printed.
     */
    List<String> getPrintHistory();

    /**
     * Prints the current setted string in the STDOUT.
     *
     * @throws IllegalStateException if the string is not set.
     */
    void printSettedString();
}
