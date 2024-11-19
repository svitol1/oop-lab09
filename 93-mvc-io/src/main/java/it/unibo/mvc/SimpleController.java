package it.unibo.mvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * implements a simple I/O controller.
 *
 */
public final class SimpleController implements Controller {
    private String currSettedString;
    private final List<String> printHistory = new ArrayList<>();

    @Override
    public void setString(final String stringToSet) {
        this.currSettedString = Objects.requireNonNull(stringToSet);
    }

    @Override
    public String getSettedString() {
        return this.currSettedString;
    }

    @Override
    public List<String> getPrintHistory() {
        return new ArrayList<>(this.printHistory);
    }

    @Override
    public void printSettedString() {
        System.out.println(Objects.requireNonNull(this.currSettedString)); //NOPMD: just for exercise purpose.
        this.printHistory.add(this.currSettedString);
        this.currSettedString = null;
    }
}
