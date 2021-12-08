// User / Admin login system
// verify the username and password combination using user.csv file
// if successful login display message Welcome (username)
// else display message Incorrect Username or Password
// Create a link to add details



// THIS FILE CONTAINS USER AND ADMIN LOGIN SYSTEM



import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class UserLoginSystem extends JFrame{
    private JPanel contentPane;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private JButton btnAddDetails;




    // Admin name
    String Admin = "priya";



    public UserLoginSystem() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 377, 225);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setBounds(33, 28, 256, 14);
        contentPane.add(lblUsername);

        txtUsername = new JTextField();
        txtUsername.setColumns(10);
        txtUsername.setBounds(33, 44, 256, 20);
        contentPane.add(txtUsername);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBounds(33, 79, 256, 14);
        contentPane.add(lblPassword);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(33, 95, 256, 20);
        contentPane.add(txtPassword);

        btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String checkUsername = txtUsername.getText();
                String checkPassword = String.valueOf(txtPassword.getPassword());
                String fileUsername = "";
                int counter = 0;
                try {
                    BufferedReader br = new BufferedReader(new FileReader("user.csv"));
                    while((fileUsername = br.readLine())!=null) {
                        counter++;
                    }
                    br.close();

                    String filePassword = "";
                    br = new BufferedReader(new FileReader("user.csv"));
                    for(int i = 0; i < counter; i++) {
                        String userdetail = br.readLine();
                        fileUsername = userdetail.split(",")[1];
                        filePassword = userdetail.split(",")[3];
                        if(fileUsername.equals(checkUsername)) {
                            if(filePassword.equals(checkPassword)) {
                                JOptionPane.showMessageDialog(null, "Welcome " + checkUsername);
                                if (checkUsername.equals(Admin)){
                                    new addmoviedetails();
                                    JOptionPane.showMessageDialog(null, "Welcome Admin: " + checkUsername);
                                }
                                return;
                            } else {
                                JOptionPane.showMessageDialog(null, "Incorrect Username or Password");
                                return;
                            }
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Incorrect Username or Password");
                    br.close();
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    JOptionPane.showMessageDialog(null, "Incorrect Username or Password");
                    e1.printStackTrace();
                }
            }
        });
        btnLogin.setBounds(33, 133, 89, 23);
        contentPane.add(btnLogin);

        setVisible(true);
    }

    public static void main(String[] args) {
        UserLoginSystem r = new UserLoginSystem();
    }
}