//make Java GUI in Swing
//make two sections - left and right . Left section contains three buttons - Register User, User Login, and Admin Login.
//Right section contains a search bar for movies and a list of movies.
//Make a search button that searches the csv file for movies that match the search bar.
//a drop down menu for the user to select the genre of the movie.
//an "Add To Cart" button that adds the movie to the cart.
//a "Remove From Cart" button that removes the movie from the cart.
//a "Checkout" button that takes the user to the checkout page.
//display the movies in the cart in a list.

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class MovieStore extends JFrame implements ActionListener {
    private JPanel contentPane;
    private JButton btnRegisterUser;
    private JButton btnUserLogin;
    private JButton btnAdminLogin;
    private JButton btnSearch;
    private JTextField txtSearch;
    private JList lstMovies;
    private JComboBox cmbGenre;
    private JButton btnAddToCart;
    private JButton btnRemoveFromCart;
    private JButton btnCheckout;
    private JLabel lblCart;
    private JList lstCart;
    private JButton btnClearCart;
    private JButton btnBack;
    private JButton btnLogout;


    public MovieStore() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 545, 556);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        btnRegisterUser = new JButton("Register User");
        btnRegisterUser.addActionListener(this);
        btnRegisterUser.setBounds(12, 12, 117, 23);
        contentPane.add(btnRegisterUser);

        btnUserLogin = new JButton("User Login");
        btnUserLogin.addActionListener(this);
        btnUserLogin.setBounds(12, 45, 117, 23);
        contentPane.add(btnUserLogin);

        btnAdminLogin = new JButton("Admin Login");
        btnAdminLogin.addActionListener(this);
        btnAdminLogin.setBounds(12, 78, 117, 23);
        contentPane.add(btnAdminLogin);

        btnSearch = new JButton("Search");
        btnSearch.addActionListener(this);
        btnSearch.setBounds(12, 116, 117, 23);
        contentPane.add(btnSearch);

        txtSearch = new JTextField();
        txtSearch.setBounds(12, 150, 117, 20);
        contentPane.add(txtSearch);
        txtSearch.setColumns(10);

        lstMovies = new JList();
        lstMovies.setBounds(12, 184, 117, 124);
        contentPane.add(lstMovies);

        cmbGenre = new JComboBox();
        cmbGenre.addItem("All");
        cmbGenre.addItem("Action");
        cmbGenre.addItem("Adventure");
        cmbGenre.addItem("Animation");
        cmbGenre.addItem("Biography");
        cmbGenre.addItem("Comedy");

        cmbGenre.setBounds(12, 330, 117, 20);
        contentPane.add(cmbGenre);

        btnAddToCart = new JButton("Add To Cart");
        btnAddToCart.addActionListener(this);
        btnAddToCart.setBounds(12, 374, 117, 23);
        contentPane.add(btnAddToCart);

        btnRemoveFromCart = new JButton("Remove From Cart");
        btnRemoveFromCart.addActionListener(this);
        btnRemoveFromCart.setBounds(12, 407, 117, 23);
        contentPane.add(btnRemoveFromCart);

        btnCheckout = new JButton("Checkout");
        btnCheckout.addActionListener(this);
        btnCheckout.setBounds(135, 407, 117, 23);
        contentPane.add(btnCheckout);

        lblCart = new JLabel("Cart");
        lblCart.setBounds(135, 12, 46, 14);
        contentPane.add(lblCart);

        lstCart = new JList();
        lstCart.setBounds(135, 45, 117, 124);
        contentPane.add(lstCart);

        btnClearCart = new JButton("Clear Cart");
        btnClearCart.addActionListener(this);
        btnClearCart.setBounds(135, 374, 117, 23);
        contentPane.add(btnClearCart);

        setVisible(true);
        displayMovies();
    }

    // method to display movie list, extract the movie names from movie.csv file in which first elements from a sentence seperated by commas is the movie title

    //getMoviesfromCSV method to get movie list from csv file
    private ArrayList<String> getMoviesfromCSV() {
        ArrayList<String> movies = new ArrayList<String>();
        try {
            File file = new File("movie.csv");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                movies.add(data[0]);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return movies;
    }

    //method to display movie list in list
    private void displayMovies() {
        ArrayList<String> movies = getMoviesfromCSV();
        lstMovies.setListData(movies.toArray());
        //lstMovies.setListData(getMoviesfromCSV());
    }

    // method to display movie list, extract the movie names from movie.csv file in which first elements from a sentence seperated by commas is the movie title

    //getMoviesfromCSV method to get movie list from csv file
    private ArrayList<String> getCartfromCSV() {
        ArrayList<String> cart = new ArrayList<String>();
        try {
            File file = new File("cart.csv");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                cart.add(data[0]);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cart;
    }

    ArrayList<String> cart = new ArrayList<String>();

    // method to display cart in list
    private void displayCart() {
        lstCart.setListData(cart.toArray());
    }

    //method to add movie to cart
    private void addToCart() {
        cart.add(lstMovies.getSelectedValue().toString());
        displayCart();
    }

    //method to remove movie from cart
    private void removeFromCart() {
        cart.remove(lstCart.getSelectedValue().toString());
        displayCart();
    }

    //method to clear cart
    private void clearCart() {
        cart.clear();
        displayCart();
    }


    // method to do search
    private void search() {
        //get the search text from txtSearch
        String search = txtSearch.getText();
        ArrayList<String> movies = getMoviesfromCSV();
        ArrayList<String> searchedMovies = new ArrayList<String>();
        for (String movie : movies) {
            if (movie.startsWith(search)) {
                searchedMovies.add(movie);
            }
        }
        lstMovies.setListData(searchedMovies.toArray());
    }



    private String username;
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnRegisterUser) {
            super1 r = new super1();
            username = r.getusername();
        }
        else if (e.getSource() == btnUserLogin) {
            new UserLoginSystem();
        }
        else if (e.getSource() == btnAdminLogin) {
            new UserLoginSystem();
        }
        else if (e.getSource() == btnSearch) {
            search();
        }
        else if (e.getSource() == btnAddToCart) {
            addToCart();
            displayCart();
            //display message to user
            JOptionPane.showMessageDialog(null, "Movie added to cart");
        }
        else if (e.getSource() == btnRemoveFromCart) {
            removeFromCart();
            displayCart();
            //display message to user
            JOptionPane.showMessageDialog(null, "Movie removed from cart");
        }
        else if (e.getSource() == btnCheckout) {
            OrderDetails t = new OrderDetails(username,"#1512452");
            t.getRandomMovie(cart);
        }
        else if (e.getSource() == btnClearCart) {
            clearCart();
            displayCart();
            //display message to user
            JOptionPane.showMessageDialog(null, "Cart cleared");
        }
    }

    public static void main(String[] args) {
        MovieStore r = new MovieStore();
    }

}