import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
public class MainPage extends JFrame {
private JPanel contentPane;
private JTable table;
private JButton btnNewAppoint;
private JButton btnExit;
private JButton btnUpdate;
private JButton btnDelete2;
private JButton btnBack;
private JTextField textField;
private JLabel lblFilter;
/**
* Launch the application.
*/
public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
MainPage frame = new MainPage();
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
public MainPage() {
setTitle("Show Appointment");
setBackground(new Color(255, 228, 225));
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(100, 100, 570, 413);
contentPane = new JPanel();
contentPane.setBackground(new Color(255, 250, 250));
contentPane.setForeground(Color.WHITE);
contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
setContentPane(contentPane);
contentPane.setLayout(null);
JScrollPane scrollPane = new JScrollPane();
scrollPane.setBounds(10, 90, 517, 225);
contentPane.add(scrollPane);
final DefaultTableModel model = new DefaultTableModel();
model.setColumnIdentifiers(new String[]{"ID","Name","Surname","Contact
Number", "Age", "Gender", "Blood Group","Desired Service", "Info"});
DBConnection db = new DBConnection();
ResultSet res = null;
try {
res = db.getResultSet();
} catch (SQLException e1) {
// TODO Auto-generated catch block
e1.printStackTrace();
}
try {
while(res.next()){
Object [] temp_row = new Object
[res.getMetaData().getColumnCount()];
for (int i = 0; i < temp_row.length; i++) {
temp_row[i] = res.getObject(i+1);
}
model.addRow(temp_row);
}
} catch (SQLException e1) {
// TODO Auto-generated catch block
e1.printStackTrace();
}
final TableRowSorter<TableModel> sorter= new
TableRowSorter<TableModel>(model);
DefaultTableCellRenderer center = new DefaultTableCellRenderer();
center.setHorizontalAlignment(JLabel.CENTER);
table = new JTable();
table.setModel(model);
table.setDefaultRenderer(String.class, center);
table.setRowSorter(sorter);
for (int i=0; i<model.getColumnCount(); i++){
table.getColumnModel().getColumn(0).setCellRenderer(center);
}
scrollPane.setViewportView(table);
textField = new JTextField();
textField.addKeyListener(new KeyAdapter() {
@Override
public void keyReleased(KeyEvent e) {
sorter.setRowFilter(RowFilter.regexFilter("(?i)"+
textField.getText()));
}
});
textField.setBounds(57, 38, 107, 20);
contentPane.add(textField);
textField.setColumns(10);
JButton btnDelete = new JButton("Delete");
btnDelete.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent arg0) {
DBConnection db = new DBConnection();
int [] rows = table.getSelectedRows();
for (int i = 0; i < rows.length; i++) {
try {
db.deletePat(table.getValueAt(rows[i]-i,
0));
model.removeRow(rows[i]-i);
} catch (SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
} }});
btnDelete.setBounds(438, 56, 89, 23);
contentPane.add(btnDelete);
btnBack = new JButton("Back");
btnBack.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
dispose();
}
});
btnBack.setBounds(438, 341, 89, 23);
contentPane.add(btnBack);
lblFilter = new JLabel("Filter/Sort");
lblFilter.setBounds(10, 21, 58, 14);
contentPane.add(lblFilter);
}
}
Appointment
package Homework;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class Appointment extends JFrame {
private JPanel contentPane;
private JTextField txtID;
private JTextField txtName;
private JTextField txtSurname;
private JTextField txtContact;
private JTextField txtInfo;
/**
* Launch the application.
*/
public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
Appointment frame = new Appointment();
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
public Appointment() {
setTitle("New Appointment");
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(100, 100, 450, 438);
contentPane = new JPanel();
contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
contentPane.setBorder(javax.swing.BorderFactory.createTitledBorder("Patient Detail's"));
setContentPane(contentPane);
contentPane.setLayout(null);
JButton btnBack = new JButton("Back");
btnBack.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
dispose();
}
});
btnBack.setBounds(321, 354, 89, 23);
contentPane.add(btnBack);
JLabel lblID = new JLabel("Patient ID :");
lblID.setFont(new Font("Tahoma", Font.BOLD, 11));
lblID.setBounds(20, 24, 75, 14);
contentPane.add(lblID);
txtID = new JTextField();
txtID.setBounds(112, 21, 109, 20);
contentPane.add(txtID);
txtID.setColumns(10);
JLabel lblName = new JLabel("Name :");
lblName.setFont(new Font("Tahoma", Font.BOLD, 11));
lblName.setBounds(20, 55, 56, 14);
contentPane.add(lblName);
txtName = new JTextField();
txtName.setBounds(112, 52, 109, 20);
contentPane.add(txtName);
txtName.setColumns(10);
JLabel lblSurname = new JLabel("Surname :");
lblSurname.setFont(new Font("Tahoma", Font.BOLD, 11));
lblSurname.setBounds(20, 86, 75, 14);
contentPane.add(lblSurname);
txtSurname = new JTextField();
txtSurname.setBounds(112, 83, 109, 20);
contentPane.add(txtSurname);
txtSurname.setColumns(10);
JLabel lblContact = new JLabel("Contact No :");
lblContact.setFont(new Font("Tahoma", Font.BOLD, 11));
lblContact.setBounds(20, 119, 75, 14);
contentPane.add(lblContact);
txtContact = new JTextField();
txtContact.setBounds(112, 116, 109, 20);
contentPane.add(txtContact);
txtContact.setColumns(10);
JLabel lblAge = new JLabel("Age :");
lblAge.setFont(new Font("Tahoma", Font.BOLD, 11));
lblAge.setBounds(20, 151, 46, 14);
contentPane.add(lblAge);
final JComboBox cbAge = new JComboBox();
cbAge.setBounds(112, 147, 50, 22);
contentPane.add(cbAge);
for(int i = 0; i<= 100;i++) {
cbAge.addItem(i+"");
}
JLabel lblGender = new JLabel("Gender :");
lblGender.setFont(new Font("Tahoma", Font.BOLD, 11));
lblGender.setBounds(20, 194, 56, 14);
contentPane.add(lblGender);
JRadioButton rdbtnFemale = new JRadioButton("Female");
rdbtnFemale.setBounds(115, 190, 66, 23);
contentPane.add(rdbtnFemale);
rdbtnFemale.setActionCommand("Female");
JRadioButton rdbtnMale = new JRadioButton("Male");
rdbtnMale.setBounds(183, 190, 109, 23);
contentPane.add(rdbtnMale);
rdbtnMale.setActionCommand("Male");
final ButtonGroup gender = new ButtonGroup();
gender.add(rdbtnMale);
gender.add(rdbtnFemale);
JLabel lblBlood = new JLabel("Blood Group :");
lblBlood.setFont(new Font("Tahoma", Font.BOLD, 11));
lblBlood.setBounds(20, 232, 89, 14);
contentPane.add(lblBlood);
final JComboBox cbBlood = new JComboBox();
cbBlood.setToolTipText("");
cbBlood.setBounds(112, 228, 56, 22);
cbBlood.addItem("0+");
cbBlood.addItem("0-");
cbBlood.addItem("A+");
cbBlood.addItem("A-");
cbBlood.addItem("B+");
cbBlood.addItem("B-");
cbBlood.addItem("AB+");
cbBlood.addItem("AB-");
contentPane.add(cbBlood);
JLabel lblService = new JLabel("Desired Service :");
lblService.setFont(new Font("Tahoma", Font.BOLD, 11));
lblService.setBounds(20, 274, 103, 14);
contentPane.add(lblService);
final JComboBox cbService = new JComboBox();
cbService.setModel(new DefaultComboBoxModel(new String[] {"Adult
Endocrinology", "Cardiology ", "Dermatology", "General Surgery", "Infectious Disease",
"Neurology", "Oncology", "Pediatrics", "Psychiatry", "Radiology", "Urology", "Women's
Care"}));
cbService.setBounds(133, 270, 129, 22);
contentPane.add(cbService);
JLabel lblInfo = new JLabel("Info :");
lblInfo.setFont(new Font("Tahoma", Font.BOLD, 11));
lblInfo.setBounds(20, 326, 46, 14);
contentPane.add(lblInfo);
txtInfo = new JTextField();
txtInfo.setBounds(68, 326, 175, 55);
contentPane.add(txtInfo);
txtInfo.setColumns(10);
final DefaultTableModel model = new DefaultTableModel();
JButton btnSave = new JButton("Save");
btnSave.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
Patient pat = new Patient();
pat.idpatient = Integer.parseInt(txtID.getText());
pat.name = txtName.getText();
pat.surname = txtSurname.getText();
pat.contact = Integer.parseInt(txtContact.getText());
pat.age = Integer.parseInt(cbAge.getSelectedItem().toString());
pat.gender = gender.getSelection().getActionCommand();
pat.blood = cbBlood.getSelectedItem().toString();
pat.service = cbService.getSelectedItem().toString();
pat.info = txtInfo.getText();
DBConnection db = new DBConnection();
try {
db.getConnection();
db.newPatient(pat);
} catch (SQLException e2) {
// TODO Auto-generated catch block
e2.printStackTrace();
}
try {
ResultSet res = db.getResultSet();
model.setRowCount(0);
int col = res.getMetaData().getColumnCount();
while(res.next()){
Object[] row_temp = new Object[col];
for (int i = 1; i <= row_temp.length; i++) {
row_temp[i-1]= res.getObject(i);
}
model.addRow(row_temp);
}
} catch (SQLException e1) {
// TODO Auto-generated catch block
e1.printStackTrace();
}
JOptionPane.showMessageDialog(null, "Successfully
Saved!");
}
});
btnSave.setBounds(321, 322, 89, 23);
contentPane.add(btnSave);
}
}
