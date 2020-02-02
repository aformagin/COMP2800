package Assignments.Assignment2;

import javax.swing.*;
import java.awt.*;

public class OptionsPanel extends JPanel {
    JComboBox<String> optionBox;
    JLabel instructionsDraw, instructionsDelete, instructionsMove;

    public OptionsPanel(){
        setPreferredSize(new Dimension(100, 100));
        setLayout(new GridLayout(4, 0));
        optionBox = new JComboBox<>();
        optionBox.addItem("Draw");
        optionBox.addItem("Delete");
        optionBox.addItem("Move");
        instructionsDraw = new JLabel ("Draw - Click point 1 and 2 and a line will be created");
        instructionsDelete = new JLabel("Delete - Click near the CENTER of the line to delete");
        instructionsMove = new JLabel("Move - Click and drag the line to move around the screen");
        add(instructionsDraw);
        add(instructionsDelete);
        add(instructionsMove);
        add(optionBox);

    }

    public String getBox(){
        return optionBox.getSelectedItem().toString();
    }
}
