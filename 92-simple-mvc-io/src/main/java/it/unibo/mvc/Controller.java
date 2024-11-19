package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {
    private File currFile;
    private static final String PATH = System.getProperty("user.home") + File.separator + "output.txt";
    /**
     * Constructor.
     */
    public Controller() {
        this.setFile(new File(PATH));
    }
    /**
     * sets the File passed as input as the current file.
     *
     * @param file
     */
    public final void setFile(final File file) {
        this.currFile = Objects.requireNonNull(file);
    }
    /**
     *
     * @return the current setted file.
     */
    public File getCurrFile() {
        return this.currFile;
    }
    /**
     *
     * @return the path of the current file in form of String.
     */
    public String getPath() {
        return this.currFile.getAbsolutePath();
    }
    /**
     * writes the Strign passed as input in the current file.
     *
     * @param str
     *
     * @throws IOException: cannot open or create current file.
     */
    public void write(final String str) throws IOException {
        final PrintStream ps = new PrintStream(this.currFile, StandardCharsets.UTF_8);
        ps.print(str);
        ps.close();
    }
}
