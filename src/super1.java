// java GUI code in swing

//Registration system using csv file check
//Register - Name,userNAME,email AND PASSWORD
//Address - Street number, street name,city, province, postal code
//// store all information in user.csv file with ","

// java GUI code in swing

//Registration system using csv file check
//Register - Name,Username,Email AND Password
//Address - Street number, street name,city, province, postal code
// All INDIVIDULA FIELD SHOULD BE ON NEW LINE
// store all information in user.csv file with ","

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class super1 extends JFrame implements ActionListener {
    JButton register, login, exit;
    JLabel name, username, email, password, streetnumber, streetname, city, province, postalcode;
    JTextField tname, tusername, temail, tpassword, tstreetnumber, tstreetname, tcity, tprovince, tpostalcode;
    String fileName = "user.csv";
    String line = "";
    String cvsSplitBy = ",";

    public super1() {
        super("Registration System");
        setLayout(new FlowLayout());
        setBounds(100, 100, 845, 456);

        register = new JButton("Register");
        register.addActionListener(this);
        add(register);

        login = new JButton("Login");
        login.addActionListener(this);
        add(login);

        exit = new JButton("Exit");
        exit.addActionListener(this);
        add(exit);

        name = new JLabel("Name");
        add(name);
        tname = new JTextField(20);
        add(tname);

        username = new JLabel("Username");
        add(username);
        tusername = new JTextField(20);
        add(tusername);

        email = new JLabel("Email");
        add(email);
        temail = new JTextField(20);
        add(temail);

        password = new JLabel("Password");
        add(password);
        tpassword = new JTextField(20);
        add(tpassword);

        streetnumber = new JLabel("Street Number");
        add(streetnumber);
        tstreetnumber = new JTextField(20);
        add(tstreetnumber);

        streetname = new JLabel("Street Name");
        add(streetname);
        tstreetname = new JTextField(20);
        add(tstreetname);

        city = new JLabel("City");
        add(city);
        tcity = new JTextField(20);
        add(tcity);

        province = new JLabel("Province");
        add(province);
        tprovince = new JTextField(20);
        add(tprovince);

        postalcode = new JLabel("Postal Code");
        add(postalcode);
        tpostalcode = new JTextField(20);
        add(tpostalcode);
        setVisible(true);

    }
    String un;

    public String getusername(){
        return un;
    }

    public void setusername(String name){
        un = name;
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == register) {
            try {

                FileWriter fw = new FileWriter("user.csv", true); //true will append to end of file

                BufferedWriter bw = new BufferedWriter(fw); //write to file using buffer

                String str1 = tname.getText(); //get text from each text field and store it in str1 for writing in csv file

                String str2 = tusername.getText();

                String str3 = temail.getText();

                String str4 = tpassword.getText();  //convert passchararray into string and store it in str4 for writing in csv file

                String str5 = tstreetnumber.getText();   //convert streetnumber from jtextfield into string and store it in str5 for writing in csv file

                String str6 = tstreetname.getText();    //convert streename from jtextfield into string and store it in str6 for writing in csv file

                String str7 = tcity .getText();  //convert city from jtextfield into string and store it in str7 for writing in csv file

                String str8 = tprovince.getText();  //convert province from jtextfield into string and store it in str8 for writing in csv file

                String str9 = tpostalcode.getText();  //convert postalcode from jtextfield into string and store it in str9 for writing in csv file

                String str10 = "";  //create str10 to store the date and time of registration

                Date date = new Date();  //get the current date and time

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");  //format the date and time

                str10 = sdf.format(date);  //store the formatted date and time in str10 for writing in csv file

                bw.write("\n" + str1 + "," + str2 + "," + str3 + "," + str4 + "," + str5 + "," + str6 + "," + str7 + "," + str8 + "," + str9 + "," + str10);  //write all the information to csv file

                bw.close();  //close the buffer writer

                fw.close();  //close the file writer

                JOptionPane.showMessageDialog(null, "Registration Successful");  //pop up message for successful registration

                dispose();  //close the window

            } catch (IOException ex) {

                ex.printStackTrace();

            }
        } else if (e.getSource() == login) {
            try {
                FileReader fr = new FileReader(fileName);
                BufferedReader br = new BufferedReader(fr);
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(cvsSplitBy);
                    if (data[1].equals(tusername.getText()) && data[3].equals(tpassword.getText())) {
                        JOptionPane.showMessageDialog(null, "Login Successful");
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null, "Login Failed");
                    }
                }
                br.close();
            } catch (IOException e1) {

            }
        } else if (e.getSource() == exit) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        super1 f = new super1();
        f.setSize(400, 400);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}