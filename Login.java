import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
public class Login extends JFrame {
private JPanel contentPane;
private JTextField txtUsername;
private JPasswordField passwordField;
/**
* Launch the application.
*/
public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
Login frame = new Login();
frame.setVisible(true);
} catch (Exception e) {
e.printStackTrace();
}
}
});
}
/**
* Create the frame.
*/
public Login() {
setTitle("Hospital Management System");
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(100, 100, 300, 300);
contentPane = new JPanel();
contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
setContentPane(contentPane);
contentPane.setLayout(null);

ImageIcon(this.getClass().getResource("/image.PNG")).getImage();
JLabel lblNewLabel = new JLabel("Welcome to St. Hopkins Hospital!");
lblNewLabel.setForeground(new Color(255, 0, 0));
lblNewLabel.setFont(new Font("Vijaya", Font.BOLD, 18));
lblNewLabel.setBounds(10, 11, 214, 23);
contentPane.add(lblNewLabel);
JLabel lblUsername = new JLabel("Username :");
lblUsername.setFont(new Font("Tahoma", Font.BOLD, 11));
lblUsername.setForeground(new Color(255, 255, 255));
lblUsername.setBounds(102, 89, 68, 14);
contentPane.add(lblUsername);
txtUsername = new JTextField();
txtUsername.setBounds(170, 86, 86, 20);
contentPane.add(txtUsername);
txtUsername.setColumns(10);
JLabel lblPassword = new JLabel("Password :");
lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
lblPassword.setForeground(new Color(255, 255, 255));
lblPassword.setBounds(103, 139, 67, 14);
contentPane.add(lblPassword);
passwordField = new JPasswordField();
passwordField.setBounds(171, 136, 85, 20);
contentPane.add(passwordField);
JButton btnLogin = new JButton("Login");
btnLogin.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent arg0) {
if(txtUsername.getText().equals("admin") &&
passwordField.getText().equals("123") ){
Menu menu = new Menu();
menu.setVisible(true);
}
else {
JOptionPane.showMessageDialog(contentPane,
"Invalid username or password! Try again.");
}
}});
btnLogin.setBounds(185, 228, 89, 23);
contentPane.add(btnLogin);
JLabel lblNewLabel_1 = new JLabel("New label");
lblNewLabel_1.setIcon(new
ImageIcon("C:\\Users\\Casper\\Desktop\\image.PNG"));
lblNewLabel_1.setBounds(0, 0, 284, 262);
contentPane.add(lblNewLabel_1);
}
}
