// java Well professional looking GUI code in swing

// Add order details bill page system
// Make random Order fake details list of {Current user, Movies, Due date, Return date, Principal Fee, Late Fee, Payment Status, Paid (Checkbox)}
// Display them as labels
// Pay with credit card
// Add credits
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OrderDetails extends JFrame {
    private JPanel contentPane;
    private JLabel lblMovie;
    private JLabel lblDueDate;
    private JLabel lblReturnDate;
    private JLabel lblPrincipalFee;
    private JLabel lblLateFee;
    private JLabel lblPaymentStatus;
    private JLabel lblPaid;
    private JLabel lblOrderId;
    private JLabel lblOrderIdValue;
    private JLabel lblUserId;
    private JLabel lblUserIdValue;
    private JLabel lblMovieId;
    private JLabel lblMovieIdValue;
    private JLabel lblDueDateValue;
    private JLabel lblReturnDateValue;
    private JLabel lblPrincipalFeeValue;
    private JLabel lblLateFeeValue;
    private JLabel lblPaymentStatusValue;
    private JLabel lblPaidValue;
    private JButton btnPay;
    private JButton btnBack;
    private JButton btnAddCreditCard;

    public OrderDetails(String userId, String orderId) {
        setTitle("Order Details");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 624, 472);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblOrderId = new JLabel("Order ID:");
        lblOrderId.setBounds(10, 11, 86, 14);
        contentPane.add(lblOrderId);

        lblOrderIdValue = new JLabel(orderId);
        lblOrderIdValue.setBounds(106, 11, 86, 14);
        contentPane.add(lblOrderIdValue);

        lblUserId = new JLabel("User ID:");
        lblUserId.setBounds(10, 36, 86, 14);
        contentPane.add(lblUserId);

        lblUserIdValue = new JLabel(userId);
        lblUserIdValue.setBounds(106, 36, 86, 14);
        contentPane.add(lblUserIdValue);

        lblMovie = new JLabel("Movie:");
        lblMovie.setBounds(10, 61, 86, 14);
        contentPane.add(lblMovie);

        lblMovieId = new JLabel("Movie ID:");
        lblMovieId.setBounds(10, 86, 86, 14);
        contentPane.add(lblMovieId);

        lblMovieIdValue = new JLabel("");
        lblMovieIdValue.setBounds(106, 86, 400, 14);
        contentPane.add(lblMovieIdValue);

        lblDueDate = new JLabel("Due Date:");
        lblDueDate.setBounds(10, 111, 86, 14);
        contentPane.add(lblDueDate);

        lblDueDateValue = new JLabel("");
        lblDueDateValue.setBounds(106, 111, 86, 14);
        contentPane.add(lblDueDateValue);

        lblReturnDate = new JLabel("Return Date:");
        lblReturnDate.setBounds(10, 136, 86, 14);
        contentPane.add(lblReturnDate);

        lblReturnDateValue = new JLabel("");
        lblReturnDateValue.setBounds(106, 136, 86, 14);
        contentPane.add(lblReturnDateValue);

        lblPrincipalFee = new JLabel("Principal Fee:");
        lblPrincipalFee.setBounds(10, 161, 86, 14);
        contentPane.add(lblPrincipalFee);

        lblPrincipalFeeValue = new JLabel("");
        lblPrincipalFeeValue.setBounds(106, 161, 86, 14);
        contentPane.add(lblPrincipalFeeValue);

        lblLateFee = new JLabel("Late Fee:");
        lblLateFee.setBounds(10, 186, 86, 14);
        contentPane.add(lblLateFee);

        lblLateFeeValue = new JLabel("");
        lblLateFeeValue.setBounds(106, 186, 86, 14);
        contentPane.add(lblLateFeeValue);

        lblPaymentStatus = new JLabel("Payment Status:");
        lblPaymentStatus.setBounds(10, 211, 86, 14);
        contentPane.add(lblPaymentStatus);

        lblPaymentStatusValue = new JLabel("");
        lblPaymentStatusValue.setBounds(106, 211, 86, 14);
        contentPane.add(lblPaymentStatusValue);

        lblPaid = new JLabel("Paid:");
        lblPaid.setBounds(10, 236, 86, 14);
        contentPane.add(lblPaid);

        lblPaidValue = new JLabel("");
        lblPaidValue.setBounds(106, 236, 86, 14);
        contentPane.add(lblPaidValue);

        btnPay = new JButton("Pay with credit card");
        btnPay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pay();
            }
        });
        btnPay.setBounds(10, 261, 160, 23);
        contentPane.add(btnPay);

        //Add credit card button when credit card is not found
        btnAddCreditCard = new JButton("Add credit card");
        btnAddCreditCard.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addCreditCard();
            }
        });
        btnAddCreditCard.setBounds(10, 261, 160, 23);
        contentPane.add(btnAddCreditCard);
        btnAddCreditCard.setVisible(true);

        btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                back();
            }
        });
        btnBack.setBounds(10, 300, 160, 23);
        contentPane.add(btnBack);

        lblOrderIdValue.setText(orderId);
        lblUserIdValue.setText(userId);
        lblReturnDateValue.setText(getRandomReturnDate());
        lblPrincipalFeeValue.setText(getRandomPrincipalFee());
        lblLateFeeValue.setText(getRandomLateFee());
        lblPaymentStatusValue.setText(getRandomPaymentStatus());
        lblPaidValue.setText(getRandomPaid());

        btnPay.setVisible(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        OrderDetails r = new OrderDetails("Ashwin", "15151");
    }

    public void getRandomMovie(ArrayList<String> movienames) {
        String moviename = "";
        for (int i=0;i< movienames.size();i++){
            moviename = moviename + movienames.get(i) + ", ";
        }
        lblMovieIdValue.setText(moviename);
    }

    public void getRandomDueDate(String duedate) {

        lblDueDateValue.setText(duedate);
    }

    private String getRandomReturnDate() {
        Random r = new Random();
        int randomNumber = r.nextInt(5);
        String[] returnDates = {"12/12/2019", "12/12/2019", "12/12/2019", "12/12/2019", "12/12/2019"};
        return returnDates[randomNumber];
    }

    private String getRandomPrincipalFee() {
        Random r = new Random();
        int randomNumber = r.nextInt(5);
        String[] principalFees = {"$0.00", "$1.00", "$2.00", "$3.00", "$4.00"};
        return principalFees[randomNumber];
    }

    private String getRandomLateFee() {
        Random r = new Random();
        int randomNumber = r.nextInt(5);
        String[] lateFees = {"$0.00", "$0.00", "$1.00", "$2.00", "$3.00"};
        return lateFees[randomNumber];
    }

    private String getRandomPaymentStatus() {
        Random r = new Random();
        int randomNumber = r.nextInt(5);
        String[] paymentStatuses = {"Pending", "Pending", "Pending", "Pending", "Pending"};
        return paymentStatuses[randomNumber];
    }

    private String getRandomPaid() {
        Random r = new Random();
        int randomNumber = r.nextInt(5);
        String[] paids = {"No", "No", "No", "No", "No"};
        return paids[randomNumber];
    }

    private void pay() {
        //Pay with credit card
        btnPay.setVisible(false);
        btnAddCreditCard.setVisible(true);
    }

    private void addCreditCard() {
        //Add credit card
        //JOptionPane.showMessageDialog(null, "This feature is not available yet");
        new addcreditcard();
    }

    private void back() {
        setVisible(false);
    }
}