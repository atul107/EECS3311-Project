//Add movie details (Admin panel)
//Admin can remove and add movies
// edit already added movies details
// add movie details - Title, Category(Dropdown), Cast, Directors, Release date, Description, Status, Availability (Indicator)
// add movie button and delete movie button
//save the movie and details in a movie.csv file
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class addmoviedetails extends JFrame{
    private JPanel contentPane;
    private JTextField txtTitle;
    private JTextField txtCategory;
    private JTextField txtCast;
    private JTextField txtDirector;
    private JTextField txtReleaseDate;
    private JTextArea txtDescription;
    private JTextField txtStatus;
    private JButton btnAdd;
    private JButton btnDelete;
    private JRadioButton rbAvailable;
    private JRadioButton rbNotAvailable;
    private String[] option = {"Sci-Fi", "Adventure", "Drama", "Comedy"};

    public static void main(String[] args) {
        addmoviedetails r = new addmoviedetails();
    }

    public addmoviedetails() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 566, 555);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitle = new JLabel("Title:");
        lblTitle.setBounds(32, 29, 46, 14);
        contentPane.add(lblTitle);

        txtTitle = new JTextField();
        txtTitle.setColumns(10);
        txtTitle.setBounds(32, 45, 195, 20);
        contentPane.add(txtTitle);

        JLabel lblCategory = new JLabel("Category:");
        lblCategory.setBounds(32, 87, 59, 14);
        contentPane.add(lblCategory);

        JComboBox comboBox = new JComboBox(option);
        comboBox.setBounds(32, 111, 216, 20);
        contentPane.add(comboBox);

        JLabel lblCast = new JLabel("Cast:");
        lblCast.setBounds(32, 141, 46, 14);
        contentPane.add(lblCast);

        txtCast = new JTextField();
        txtCast.setColumns(10);
        txtCast.setBounds(32, 157, 292, 20);
        contentPane.add(txtCast);

        JLabel lblDirector = new JLabel("Director:");
        lblDirector.setBounds(32, 192, 59, 14);
        contentPane.add(lblDirector);

        txtDirector = new JTextField();
        txtDirector.setColumns(10);
        txtDirector.setBounds(32, 208, 190, 20);
        contentPane.add(txtDirector);

        JLabel lblReleaseDate = new JLabel("Release Date:");
        lblReleaseDate.setBounds(32, 238, 90, 14);
        contentPane.add(lblReleaseDate);

        txtReleaseDate = new JTextField();
        txtReleaseDate.setColumns(10);
        txtReleaseDate.setBounds(32, 254, 190, 20);
        contentPane.add(txtReleaseDate);

        JLabel lblDescription = new JLabel("Description:");
        lblDescription.setBounds(32, 286, 72, 14);
        contentPane.add(lblDescription);

        txtDescription = new JTextArea();
        txtDescription.setLineWrap(true);
        txtDescription.setWrapStyleWord(true);
        txtDescription.setBounds(32, 302, 292, 148);
        contentPane.add(txtDescription);

        btnAdd = new JButton("Add");
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                String Title = txtTitle.getText();
                String Category = (String)comboBox.getSelectedItem();
                String Cast = txtCast.getText();
                String Director = txtDirector.getText();
                String ReleaseDate = txtReleaseDate.getText();
                String Description = txtDescription.getText();
                String Status;
                if(rbAvailable.isSelected())
                    Status = "Available";
                else
                    Status = "Not Available";
                System.out.println(Title + " " + Category + " " + Cast + " " + Director + " " + ReleaseDate + " " + Description + " " + Status);
                try {
                    addMovie(Title, Category, Cast, Director, ReleaseDate, Description, Status);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        btnAdd.setBounds(32, 444, 89, 23);
        contentPane.add(btnAdd);

        btnDelete = new JButton("Delete");
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                txtTitle.setText("");
                comboBox.setSelectedIndex(-1);
                txtCast.setText("");
                txtDirector.setText("");
                txtReleaseDate.setText("");
                txtDescription.setText("");
                rbAvailable.setSelected(false);
                rbNotAvailable.setSelected(false);
            }
        });
        btnDelete.setBounds(213, 444, 89, 23);
        contentPane.add(btnDelete);

        rbAvailable = new JRadioButton("Available");
        rbAvailable.setBounds(32, 397, 109, 23);
        contentPane.add(rbAvailable);

        rbNotAvailable = new JRadioButton("Not Available");
        rbNotAvailable.setBounds(128, 397, 109, 23);
        contentPane.add(rbNotAvailable);
        setVisible(true);
    }

    public static void addMovie(String Title, String Category, String Cast, String Director, String ReleaseDate, String Description, String Status) throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter("movie.csv", true));
        writer.append(Title);
        writer.append(",");
        writer.append(Category);
        writer.append(",");
        writer.append(Cast);
        writer.append(",");
        writer.append(Director);
        writer.append(",");
        writer.append(ReleaseDate);
        writer.append(",");
        writer.append(Description);
        writer.append(",");
        writer.append(Status);
        writer.append("\n");
        writer.close();
        JOptionPane.showMessageDialog(null, "Movie added to movie.csv");
    }
}