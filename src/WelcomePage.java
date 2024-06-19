import javax.swing.*;
import java.awt.*;

public class WelcomePage {

    //Attributes
    JFrame frame = new JFrame();
    JLabel welcomeLabel = new JLabel("Password Accepted, Welcome");

    //Constructor
    WelcomePage(String userID) {

        welcomeLabel.setBounds(0,0,1000,35);
        welcomeLabel.setFont(new Font(null, Font.ITALIC, 25));
        welcomeLabel.setText("Hello " + userID); //Will display this msg plus UserID in the new window


        frame.add(welcomeLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setLayout(null);
        frame.setVisible(true);
    }


}
