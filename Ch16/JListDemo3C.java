// JListDemo3C.java - Chapter 16 example.

// Copyright 2005 by Jacquie Barker - all rights reserved.

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*; 

public class JListDemo3C extends JFrame {
    // By placing the declaration of the JList here, as an attribute
    // of the class as a whole, we avoid problems with accessing it
    // from within the inner ListSelectionListener class below.
    private JList myList;

    public JListDemo3C() {
        super("Sample JList");
        Container contentPane = this.getContentPane();

        // Create a Collection of students.
        Student[] v = new Student[3];
        v[0] = new Student("123456789", "Joe Blow");
        v[1] = new Student("987654321", "Fred Schnurd");
        v[2] = new Student("000000000", "Englebert Humperdink");

        // Create a list based on this collection.  (By having
        // made myList an attribute of the JListDemo3C.
        // class as a whole, we avoid messing around with "final"
        // variable declarations.
        myList = new JList(v);
        contentPane.add(myList);

        // Add a listener to note when an item has been selected.
        ListSelectionListener lsl = new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                // When an item is selected (clicked!) in this 
                // list, display it at the command line.

                // To eliminate the "double display"
                // of this message, perform an initial
                // test.
                if (!myList.getValueIsAdjusting()) {
                    Student s = (Student) myList.getSelectedValue();
                    System.out.println("Selected " + s);
                }
            }
        };

        myList.addListSelectionListener(lsl);

        this.setSize(300, 100);  
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new JListDemo3C();
    }
}
