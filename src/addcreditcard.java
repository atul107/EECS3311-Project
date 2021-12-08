// addcreditcard.java
// Add credit card page system
// textfields Credit Card holder, credit card number, credit card expiration date, credit card cvv
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addcreditcard extends JFrame {
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JButton btnAddCreditCard;
    private JButton btnBack;
    private JLabel lblCreditCardHolder;
    private JLabel lblCreditCardNumber;
    private JLabel lblCreditCardExpirationDate;
    private JLabel lblCreditCardCvv;

    public static void main(String[] args) {
        addcreditcard r = new addcreditcard();
    }

    public addcreditcard() {
        setTitle("Add Credit Card");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 345, 200);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblCreditCardHolder = new JLabel("Card Holder:");
        lblCreditCardHolder.setBounds(10, 11, 86, 14);
        contentPane.add(lblCreditCardHolder);

        lblCreditCardNumber = new JLabel("Card Number:");
        lblCreditCardNumber.setBounds(10, 36, 86, 14);
        contentPane.add(lblCreditCardNumber);

        lblCreditCardExpirationDate = new JLabel("Expiry:");
        lblCreditCardExpirationDate.setBounds(10, 61, 122, 14);
        contentPane.add(lblCreditCardExpirationDate);

        lblCreditCardCvv = new JLabel("CVV:");
        lblCreditCardCvv.setBounds(10, 86, 86, 14);
        contentPane.add(lblCreditCardCvv);

        textField = new JTextField();
        textField.setBounds(106, 8, 86, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(106, 33, 86, 20);
        contentPane.add(textField_1);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(106, 58, 86, 20);
        contentPane.add(textField_2);

        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(106, 83, 86, 20);
        contentPane.add(textField_3);

        btnAddCreditCard = new JButton("Add");
        btnAddCreditCard.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addCreditCard();
            }
        });
        btnAddCreditCard.setBounds(10, 128, 89, 23);
        contentPane.add(btnAddCreditCard);

        btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                back();
            }
        });
        btnBack.setBounds(106, 128, 89, 23);
        contentPane.add(btnBack);
        setVisible(true);
    }

    private void addCreditCard() {
        JOptionPane.showMessageDialog(null, "Credit card added");
    }

    private void back() {
        dispose();
    }
}