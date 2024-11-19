package it.unibo.mvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 *
 */
public final class SimpleController implements Controller {
    private String currSettedString = null;
    private List<String> printHistory = new ArrayList<>();

    @Override
    public void setString(String stringToSet) {
        try {
            this.currSettedString = Objects.requireNonNull(stringToSet);
        } catch (NullPointerException e) {
            throw new NullPointerException();
        }
    }

    @Override
    public String getSettedString() {
        return currSettedString;
    }

    @Override
    public List<String> getPrintHistory() {
        return printHistory;
    }

    @Override
    public void printSettedString() {
        try {
            System.out.println(Objects.requireNonNull(currSettedString));
        } catch (NullPointerException e) {
            throw new IllegalStateException("String has not been setted");
        }
        this.printHistory.add(this.currSettedString);
        this.currSettedString = null;
    }
}
