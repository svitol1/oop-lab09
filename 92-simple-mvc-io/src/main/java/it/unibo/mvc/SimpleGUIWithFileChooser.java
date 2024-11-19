package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * A very simple program using a graphical interface.
 *
 */
public final class SimpleGUIWithFileChooser {
    private final JFrame frame = new JFrame();
    private static final int PROPORTION = 5;

    /**
     * Constructor.
     *
     * @param controller
     */
    public SimpleGUIWithFileChooser(final Controller controller) {
        //initializing first panel
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        //initializing text field
        final JTextArea textArea = new JTextArea("inserisci testo");
        panel1.add(textArea, BorderLayout.CENTER);
        //initializing save button
        final JButton saveButton = new JButton("Save");
        panel1.add(saveButton, BorderLayout.SOUTH);
        //initializing second panel
        final JPanel innerpanel = new JPanel();
        panel1.add(innerpanel, BorderLayout.NORTH);
        //initializing text field for browsing
        final JTextArea browsingTextArea = new JTextArea(controller.getPath());
        browsingTextArea.setEditable(false);
        innerpanel.add(browsingTextArea, BorderLayout.CENTER);
        //initializing browse button
        final JButton browseButton = new JButton("Browse...");
        innerpanel.add(browseButton, BorderLayout.LINE_END);
        //setting frame
        frame.setContentPane(panel1);
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
                    JOptionPane.showMessageDialog(saveButton, e, "I/O error", JOptionPane.ERROR);
                }
            }
        });
        browseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                final JFileChooser fileChooser = new JFileChooser();
                if (fileChooser.showSaveDialog(innerpanel) == JFileChooser.APPROVE_OPTION) {
                    controller.setFile(fileChooser.getSelectedFile());
                    browsingTextArea.setText(controller.getPath());
                } else if (fileChooser.showSaveDialog(innerpanel) == JFileChooser.ERROR_OPTION) {
                    JOptionPane.showMessageDialog(innerpanel, e, "Error selecting the file", JOptionPane.ERROR_MESSAGE);
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
     * Starts the GUI with the file chooser.
     *
     * @param args
     */
    public static void main(final String[] args) {
        final var fileChooserGUI = new SimpleGUIWithFileChooser(new Controller());
        fileChooserGUI.display();
    }
}
