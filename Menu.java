package Homework;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Menu extends JFrame {
private JPanel contentPane;
/**
* Launch the application.
*/
public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
Menu frame = new Menu();
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
public Menu() {
setTitle("Menu");
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(100, 100, 342, 300);
contentPane = new JPanel();
contentPane.setBackground(Color.WHITE);
contentPane.setForeground(Color.WHITE);
contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
setContentPane(contentPane);
contentPane.setLayout(null);
JButton btnShow = new JButton("Show Appointments");
btnShow.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
MainPage main = new MainPage();
main.setVisible(true);
}
});
btnShow.setFont(new Font("Tahoma", Font.PLAIN, 11));
btnShow.setForeground(new Color(0, 0, 0));
btnShow.setBackground(new Color(240, 255, 240));
btnShow.setBounds(99, 72, 137, 42);
contentPane.add(btnShow);
JButton btnNewAppointment = new JButton("New Appointment");
btnNewAppointment.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
Appointment appointment = new Appointment();
appointment.setVisible(true);
}
});
btnNewAppointment.setFont(new Font("Tahoma", Font.PLAIN, 11));
btnNewAppointment.setBackground(new Color(240, 255, 240));
btnNewAppointment.setBounds(99, 157, 137, 42);
contentPane.add(btnNewAppointment);
JButton btnExit = new JButton("Exit");
btnExit.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
int a = JOptionPane.showConfirmDialog(null, "Do you really
want to Logout?", "Select", JOptionPane.YES_NO_OPTION);
if(a==0) {
setVisible(false);
new Login().setVisible(true);
} }});
btnExit.setBackground(new Color(240, 255, 240));
btnExit.setBounds(233, 235, 89, 23);
contentPane.add(btnExit);
JLabel lblNewLabel = new JLabel("New label");
lblNewLabel.setIcon(new
ImageIcon("C:\\Users\\Casper\\Desktop\\imagee.jpg"));
lblNewLabel.setBounds(0, 0, 326, 262);
contentPane.add(lblNewLabel);
}
}
