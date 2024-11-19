package it.unibo.mvc;

import java.util.Objects;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * A very simple program using a graphical interface.
 *
 */
public final class SimpleGUI {
    private final JFrame frame = new JFrame();

    public SimpleGUI(final Controller controller){
        //initializing main panel
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        //initializing text field
        final JTextField historyField = new JTextField("Print history is shown here");
        historyField.setEditable(false);
        panel1.add(historyField, BorderLayout.NORTH);
        //intializing text area
        final JTextArea textArea = new JTextArea("Write here...");
        panel1.add(textArea, BorderLayout.CENTER);
        //initializing Print button
        final JButton printButton = new JButton("Print");
        panel1.add(printButton, BorderLayout.SOUTH);
        //intializing History button
        final JButton historyButton = new JButton("Show history");
        panel1.add(historyButton, BorderLayout.SOUTH);
        //setting the frame
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*
         * Handlers
         */
        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.setString(textArea.getText());
                controller.printSettedString();
                textArea.setText("Write here...");
            }
        });
        historyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (String str : controller.getPrintHistory()) {
                    historyButton.setText(str);
                }
            }
        });
    }
}
