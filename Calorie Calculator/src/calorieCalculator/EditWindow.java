package calorieCalculator;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EditWindow {
	public static void editdsin() {
		JFrame frame = new JFrame();
		Font txt = new Font("Copperplate Gothic Bold", Font.PLAIN, 18);
		Font btn = new Font("Copperplate Gothic Bold", Font.BOLD, 20);
		JLabel back = new JLabel("<  BACK");
		back.setFont(btn);
		back.setForeground(Color.decode("#f9d6c4"));
		back.setBounds(25, 20, 100, 30);
		frame.add(back);
		JPanel panel = new JPanel();
		panel.setBounds(22, 23, 95, 25);
		panel.setBackground(Color.decode("#2a1d1f"));
		frame.add(panel);
		JLabel c = new JLabel("C");
		c.setFont(new Font("Castellar", Font.BOLD, 80));
		c.setForeground(Color.decode("#f9d6c4"));
		c.setBounds(150, 22, 80, 80);
		frame.add(c);
		JLabel alorie = new JLabel("ALORIE");
		alorie.setFont(new Font("Castellar", Font.BOLD, 30));
		alorie.setForeground(Color.decode("#f9d6c4"));
		alorie.setBounds(215, 28, 250, 30);
		frame.add(alorie);
		JLabel calc = new JLabel("ALCULATOR");
		calc.setFont(new Font("Castellar", Font.BOLD, 30));
		calc.setForeground(Color.decode("#f9d6c4"));
		calc.setBounds(215, 60, 250, 30);
		frame.add(calc);
		JLabel name = new JLabel("Item Name : ");
		name.setBounds(50, 135, 150, 30);
		name.setForeground(Color.decode("#f9d6c4"));
		name.setFont(txt);
		frame.add(name);
		JTextField nmField = new JTextField();
		nmField.setBounds(50, 175, 500, 30);
		nmField.setBackground(Color.decode("#f9d6c4"));
		nmField.setFont(new Font("Serif", Font.PLAIN, 15));
		frame.add(nmField);
		JLabel calorie = new JLabel("Calorie : ");
		calorie.setBounds(50, 235, 150, 30);
		calorie.setForeground(Color.decode("#f9d6c4"));
		calorie.setFont(txt);
		frame.add(calorie);
		JTextField crField = new JTextField();
		crField.setBounds(50, 275, 200, 30);
		crField.setBackground(Color.decode("#f9d6c4"));
		crField.setFont(new Font("Serif", Font.PLAIN, 15));
		frame.add(crField);
		JButton dt = new JButton("EDIT");
		dt.setBounds(75, 350, 200, 50);
		dt.setBackground(Color.decode("#f57b3d"));
		dt.setForeground(Color.WHITE);
		dt.setFont(btn);
		frame.add(dt);
		JButton dlt = new JButton("DELETE");
		dlt.setBounds(325, 350, 200, 50);
		dlt.setBackground(Color.decode("#f57b3d"));
		dlt.setForeground(Color.WHITE);
		dlt.setFont(btn);
		frame.add(dlt);
		JLabel wrng = new JLabel("!!CHANGES ONCE MADE CANNOT BE REVERTED!!");
		wrng.setBounds(45, 410, 550, 30);
		wrng.setForeground(Color.RED);
		wrng.setFont(txt);
		frame.add(wrng);
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Front.dsin();
			}
		});
		
		dt.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				try {
					dbEdit(nmField.getText(), Integer.parseInt(crField.getText()));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				nmField.setText("");
				crField.setText("");
			} 
		});
		
		dlt.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				try {
					dbDelete(nmField.getText());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				nmField.setText("");
				crField.setText("");
			} 
		});
		frame.setSize(600,450);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setUndecorated(true);
		frame.setLocationRelativeTo(null);  
		frame.setVisible(true);
		frame.setFocusable(true);
		frame.getContentPane().setBackground(Color.decode("#2a1d1f"));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void dbDelete(String name) throws SQLException {
		//ENTER PORT, DATABASE NAME, USER, PASSWORD.
		String str1 = "DELETE FROM items WHERE itemname = '"+name+"'";
		String url = "jdbc:mysql://localhost:port/dbname";
		String user = "user";
		String pass = "password";
		Connection con = DriverManager.getConnection(url, user, pass);
		Statement stm = con.createStatement();
		stm.executeUpdate(str1);
		con.close();
	}
	
	public static void dbEdit(String name, int calorie) throws SQLException {
		//ENTER PORT, DATABASE NAME, USER, PASSWORD.
		String str1 = "UPDATE items SET calories = " + calorie+ " WHERE itemname = '"+ name+ "'";
		String url = "jdbc:mysql://localhost:port/dbname";
		String user = "user";
		String pass = "password";
		Connection con = DriverManager.getConnection(url, user, pass);
		Statement stm = con.createStatement();
		stm.executeUpdate(str1);
		con.close();
	}
}
