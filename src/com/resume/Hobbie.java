
package com.resume;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Import the existing HobbieDetails class
import com.resume.HobbieDetails;

public class Hobbie {
    private JFrame frame;
    private List<HobbieDetails> hobbies;
    private JPanel hobbiePanel;
    private JButton saveButton;

    public Hobbie() {
        hobbies = new ArrayList<>();
    }

    public void showHobbieForm() {
        frame = new JFrame("Hobbies");
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        hobbiePanel = new JPanel();
        hobbiePanel.setLayout(new BoxLayout(hobbiePanel, BoxLayout.Y_AXIS));

        addHobbieFields();

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        JButton addHobbieButton = new JButton("Add Another Hobbie");
        addHobbieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addHobbieFields();
            }
        });

        saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveHobbies();
                frame.dispose(); // Close the form after saving
            }
        });

        buttonPanel.add(addHobbieButton);
        buttonPanel.add(saveButton);

        frame.add(new JScrollPane(hobbiePanel), BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    private void addHobbieFields() {
        JPanel hobbieFieldsPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        hobbieFieldsPanel.setBorder(BorderFactory.createTitledBorder("Hobbie"));

        JTextField hobbieNameField = new JTextField();
        JTextField impactField = new JTextField();

        hobbieFieldsPanel.add(new JLabel("Hobbie Name:"));
        hobbieFieldsPanel.add(hobbieNameField);
        hobbieFieldsPanel.add(new JLabel("Impact:"));
        hobbieFieldsPanel.add(impactField);

        // Temporarily add empty details, will update when saving
        hobbies.add(new HobbieDetails("", ""));

        hobbiePanel.add(hobbieFieldsPanel);
        hobbiePanel.revalidate();
        hobbiePanel.repaint();
    }

    private void saveHobbies() {
        // Update the hobbies list with the current values from the fields
        hobbies.clear(); // Clear the list first
        for (Component component : hobbiePanel.getComponents()) {
            if (component instanceof JPanel) {
                JPanel panel = (JPanel) component;
                JTextField hobbieNameField = (JTextField) panel.getComponent(1);
                JTextField impactField = (JTextField) panel.getComponent(3);
                hobbies.add(new HobbieDetails(hobbieNameField.getText(), impactField.getText()));
            }
        }

        // Save hobbies to a text file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("hobbies.txt"))) {
            for (HobbieDetails details : hobbies) {
                writer.write("Hobbie: " + details.getHobbieName() + ", Impact: " + details.getImpact());
                writer.newLine();
            }
            JOptionPane.showMessageDialog(frame, "Hobbies saved successfully!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(frame, "Error saving hobbies: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<HobbieDetails> getHobbies() {
        return hobbies;
    }
}


/*
package com.resume;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Hobbie {
    private JFrame frame;
    private List<HobbieDetails> hobbies;
    private JPanel hobbiePanel;
    private JButton saveButton;

    public Hobbie() {
        hobbies = new ArrayList<>();
    }

    public void showHobbieForm() {
        frame = new JFrame("Hobbies");
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        hobbiePanel = new JPanel();
        hobbiePanel.setLayout(new BoxLayout(hobbiePanel, BoxLayout.Y_AXIS));

        addHobbieFields();

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        JButton addHobbieButton = new JButton("Add Another Hobbie");
        addHobbieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addHobbieFields();
            }
        });

        saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveHobbies();
                frame.dispose(); // Close the form after saving
            }
        });

        buttonPanel.add(addHobbieButton);
        buttonPanel.add(saveButton);

        frame.add(new JScrollPane(hobbiePanel), BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    private void addHobbieFields() {
        JPanel hobbieFieldsPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        hobbieFieldsPanel.setBorder(BorderFactory.createTitledBorder("Hobbie"));

        JTextField hobbieNameField = new JTextField();
        JTextField impactField = new JTextField();

        hobbieFieldsPanel.add(new JLabel("Hobbie Name:"));
        hobbieFieldsPanel.add(hobbieNameField);
        hobbieFieldsPanel.add(new JLabel("Impact:"));
        hobbieFieldsPanel.add(impactField);

        hobbies.add(new HobbieDetails(hobbieNameField.getText(), impactField.getText()));

        hobbiePanel.add(hobbieFieldsPanel);
        hobbiePanel.revalidate();
        hobbiePanel.repaint();
    }

    private void saveHobbies() 
    {
    	
    	hobbies.clear();
    	for (Component component : hobbiePanel.getComponents()) {
            if (component instanceof JPanel) {
                JPanel panel = (JPanel) component;
                JTextField hobbiesNameField = (JTextField) panel.getComponent(1);
                JTextField impactField = (JTextField) panel.getComponent(3);
                hobbies.add(new AchievementDetails(hobbiesNameField.getText(), impactField.getText()));
            }
        }
    	
        // Logic to save hobbies goes here
        // For example, you could display a message
        JOptionPane.showMessageDialog(frame, "Hobbies saved successfully!");
    }

    public List<HobbieDetails> getHobbies() {
        return hobbies;
    }
}
*/
