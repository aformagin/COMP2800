package Labs.Lab03;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Shape2 {

        // execute application
        public static void main(String[] args)
        {
// create frame for Shapes2JPanel
            JFrame frame = new JFrame("Drawing 2D Shapes");
            frame.setLayout(new BorderLayout());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Lab03 shapes2JPanel = new Lab03();
            JPanel panel2 = new JPanel();
            JButton button = new JButton("Toggle");
            panel2.add(button);
            frame.add(panel2, BorderLayout.SOUTH);
            frame.add(shapes2JPanel, BorderLayout.CENTER);
            frame.setBackground(Color.WHITE);
            frame.setSize(500, 500);
            frame.setVisible(true);

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    shapes2JPanel.changeDir();
                }
            });
        }

}
