package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * A very simple program using a graphical interface.
 *
 */
public final class SimpleGUI {
    private final JFrame frame = new JFrame();
    private static final int PROPORTION = 5;
    /**
     * Constructor.
     *
     * @param controller
     */
    public SimpleGUI(final Controller controller) {
        //initialized panel
        final JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        //initialized text area
        final JTextArea textArea = new JTextArea();
        panel.add(textArea, BorderLayout.CENTER);
        //initialized button
        final JButton saveButton = new JButton("Save");
        panel.add(saveButton, BorderLayout.SOUTH);
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*
         * Handlers
         */
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                try {
                    controller.write(textArea.getText());
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(panel, e1, "Error printing in the file", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
    /**
     * Starts the GUI created.
     */
    public void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }
    /**
     *
     * @param args ignored
     */
    public static void main(final String[] args) {
        final SimpleGUI simpleGUI = new SimpleGUI(new Controller());
        simpleGUI.display();
    }

}
