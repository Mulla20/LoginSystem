import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
public class UserLogin implements ActionListener {

    //Attributes
    JFrame frame = new JFrame();
    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");
    JTextField userIDField = new JTextField();//displays given text field (user id text)
    JPasswordField userPasswordField = new JPasswordField();//displays given text field
    JLabel userIDLabel = new JLabel("UserID: ");//takes actual user input
    JLabel userPasswordLabel = new JLabel("Password: ");//takes actual user input
    JLabel messageLabel = new JLabel();

    //New HashMap
    HashMap<String,String> loginInfo = new HashMap<String, String>(); //created new login info HM. to make global for multi class uses

    //Constructor
    UserLogin(HashMap<String,String> loginInfoOriginal ){//need to create another HM lets call it the original as argument for use of making a copy for the above HM to make global on all classes

            //Copied Global HashMap
            loginInfo = loginInfoOriginal; //this will make a copy of the hashtable, that is globally available to our login page

            //User ID Display
            userIDLabel.setBounds(100,100,75,25);
            userPasswordLabel.setBounds(100,150,75,25);

            //Message Display
            messageLabel.setBounds(125,250,250,35);//Set bounds of message label
            messageLabel.setFont(new Font("Times New Roman", Font.ITALIC, 30));//set font

            //User ID/ Password Input (Box)
            userIDField.setBounds(175,100,200,25);//Field in which UserID will be typed
            userPasswordField.setBounds(175,150,200,25);//Field in which password will be typed

            //Login Button action sequence
            loginButton.setBounds(175, 200, 100, 20);
            loginButton.addActionListener(this);

            //Reset Button action sequence
            resetButton.setBounds(275, 200, 100, 20);
            resetButton.addActionListener(this);

            frame.add(userIDLabel);//order in which components are added to the Frame is order in which I worked to set up the components
            frame.add(userPasswordLabel);
            frame.add(messageLabel);
            frame.add(userIDField);
            frame.add(userPasswordField);
            frame.add(loginButton);
            frame.add(resetButton);

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600,600);
            frame.setLayout(null);
            frame.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        //Action for ResetButton
        if(e.getSource()==resetButton){
            userIDField.setText("");//when the reset button is pressed, the userIDFIELD is reset or goes blank
            userPasswordField.setText("");////when the reset button is pressed, the userPasswordFIELD is reset or goes blank
        }

        //Action for LoginButton
        if(e.getSource()==loginButton){

            String UserID = userIDField.getText(); //Use the gerText() method to get string in the User ID field
            String UserPassword = String.valueOf(userPasswordField.getPassword()); //Because we use the JPasswordField, we use the
            // .valueOf method to convert the password input we type in, convert it to string and store it in var. PassWord_Input.

            //Verify UserID and UserPassword
            if(loginInfo.containsKey(UserID)){//checks if the hashtable has the UserID you typed in as input using (containsKey() method), perform the body.
                if(loginInfo.get(UserID).equals(UserPassword)){ //if the UserID and U.Password are equal then credentials are validated.
                    messageLabel.setForeground(Color.green);// Display green on foreground to indicate valid input
                    messageLabel.setText("Login Successful");//Display text with successful login
                    frame.dispose();//Will get rid of user login page/frame after successful login

                    //Create instance of Welcome Page to Launch after successful input
                    WelcomePage welcomePage = new WelcomePage(UserID);// Will dynamically display your user ID name when you successfully log in.

                }
                else{//In case password is wrong
                    messageLabel.setForeground(Color.red);// Display red on foreground to indicate unsuccessful password input
                    messageLabel.setText("Login UnSuccessful");//Display text with UnSuccessful password login
                }
            }
            else{//in case UserID is wrong/not found
                messageLabel.setForeground(Color.red);// Display red on foreground to indicate unsuccessful User input
                messageLabel.setText("Username Not Found");//Display text with UnSuccessful UserLogin
            }
        }

    }
}
