package calorieCalculator;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.sql.*;

@SuppressWarnings("serial")
public class AddWindow extends JFrame{
	
	public static void adddsin() {
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
		JButton submit = new JButton("SUBMIT");
		submit.setBounds(75, 350, 200, 50);
		submit.setBackground(Color.decode("#f57b3d"));
		submit.setForeground(Color.WHITE);
		submit.setFont(btn);
		frame.add(submit);
		JButton clear = new JButton("CLEAR");
		clear.setBounds(325, 350, 200, 50);
		clear.setBackground(Color.decode("#f57b3d"));
		clear.setForeground(Color.WHITE);
		clear.setFont(btn);
		frame.add(clear);
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Front.dsin();
			}
		});
		
		clear.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				nmField.setText("");
				crField.setText("");
			} 
		});
		
		submit.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				try {
					dbManage(nmField.getText(), Integer.parseInt(crField.getText()));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				nmField.setText("");
				crField.setText("");
				nmField.requestFocus();
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
	
	public static void dbManage(String str, int cal) throws SQLException {
		//ENTER PORT, DATABASE NAME, USER, PASSWORD.
		String str1 = "INSERT INTO items VALUES('"+str+"', "+cal+")";
		String url = "jdbc:mysql://localhost:port/dbname";
		String user = "user";
		String pass = "password";
		Connection con = DriverManager.getConnection(url, user, pass);
		Statement stm = con.createStatement();
		stm.executeUpdate(str1);
		System.out.println(str1+";");
		con.close();
	}
}
