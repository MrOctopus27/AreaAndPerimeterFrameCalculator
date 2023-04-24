/*
 * Author: Kevin Alvarado	
 * Date: 11/15/2022
 * 
 * Description: This program find the area and perimeter of a recatngle based on the length and the width of the object.
 */

package murach.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
//import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import murach.business.Rectangle;

@SuppressWarnings("serial")
public class AreaAndPerimeterFrame extends JFrame {

    // TODO: Add instance variables for text fields and buttons4
	
	 private JTextField lengthLabel;
	    private JTextField widthLabel;
	    private JTextField areaLabel;
	    private JTextField perimeterLabel;
	    private JButton compute;
	    private JButton reset;
		
    public AreaAndPerimeterFrame() {
        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException |
                IllegalAccessException | UnsupportedLookAndFeelException e) {
            System.out.println(e);
        }
        initComponents();
        setTitle("Area and Perimeter Calculator");
        // I added this
        //setSize(400, 280);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setVisible(true);

    }

    private void initComponents() {
        //TODO: Implement code
    	
    	 lengthLabel = new JTextField();
         widthLabel = new JTextField();
         areaLabel = new JTextField();
         perimeterLabel = new JTextField();

         areaLabel.setEditable(false);
         perimeterLabel.setEditable(false);

         Dimension dim = new Dimension(220, 30);
         lengthLabel.setPreferredSize(dim);
         widthLabel.setPreferredSize(dim);
         areaLabel.setPreferredSize(dim);
         perimeterLabel.setPreferredSize(dim);
         lengthLabel.setMinimumSize(dim);
         widthLabel.setMinimumSize(dim);
         areaLabel.setMinimumSize(dim);
         perimeterLabel.setMinimumSize(dim);

         compute = new JButton("Compute");
         reset = new JButton("Reset");

         compute.addActionListener((ActionEven) -> {
             computeButtonClicked();
         });
         reset.addActionListener((ActionEven) -> {
             resetButtonClicked();
         });

         JPanel numberPanel = new JPanel();
         numberPanel.setLayout(new GridBagLayout());
         numberPanel.add(new JLabel("Length:"),
                 getConstraints(0, 0, GridBagConstraints.LINE_END));
         numberPanel.add(lengthLabel,
                 getConstraints(1, 0, GridBagConstraints.LINE_START));
         numberPanel.add(new JLabel("Width:"),
                 getConstraints(0, 1, GridBagConstraints.LINE_END));
         numberPanel.add(widthLabel,
                 getConstraints(1, 1, GridBagConstraints.LINE_START));
         numberPanel.add(new JLabel("Area:"),
                 getConstraints(0, 2, GridBagConstraints.LINE_END));
         numberPanel.add(areaLabel,
                 getConstraints(1, 2, GridBagConstraints.LINE_START));
         numberPanel.add(new JLabel("Perimeter:"),
                 getConstraints(0, 3, GridBagConstraints.LINE_END));
         numberPanel.add(perimeterLabel,
                 getConstraints(1, 3, GridBagConstraints.LINE_START));
         add(numberPanel, BorderLayout.CENTER);

         // JButton panel
         JPanel buttonPanel = new JPanel();
         buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
         buttonPanel.add(compute);
         buttonPanel.add(reset);
         add(buttonPanel, BorderLayout.SOUTH);

         pack();
    	
    }

    // Helper method to return GridBagConstraints objects
    private GridBagConstraints getConstraints(int x, int y, int anchor) {
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 0, 5);
        c.gridx = x;
        c.gridy = y;
        c.anchor = anchor;
        return c;
    }

    private void computeButtonClicked() {
        // TODO: Implement code      
    
    double length, width;
    
    try {
    length = Double.parseDouble(lengthLabel.getText());
    width = Double.parseDouble(widthLabel.getText());
    
    Rectangle r = new Rectangle(length, width);
    areaLabel.setText(r.getAreaNumberFormat());
    perimeterLabel.setText(r.getPerimeterNumberFormat());
    } catch (NumberFormatException numberFormatException) {
    	JOptionPane.showMessageDialog(this,
                "The length or width is an invalid number. Please try again.",
                "Invalid Number", JOptionPane.ERROR_MESSAGE);
    }
    
    }

    private void resetButtonClicked() {
        // TODO: Implement code
    	 lengthLabel.setText("");
         widthLabel.setText("");
         areaLabel.setText("");
         perimeterLabel.setText("");
    }
}
