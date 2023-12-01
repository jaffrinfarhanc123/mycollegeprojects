package calorieCalculator;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class SearchWindow {
	
	private static DefaultTableModel model;
	
	public static void srchdsin() {
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
		JLabel search = new JLabel("Search : ");
		search.setBounds(50, 135, 150, 30);
		search.setForeground(Color.decode("#f9d6c4"));
		search.setFont(txt);
		frame.add(search);
		JTextField srField = new JTextField();
		srField.setBounds(150, 135, 400, 30);
		srField.setText("");
		srField.setBackground(Color.decode("#f9d6c4"));
		srField.setFont(new Font("Serif", Font.PLAIN, 15));
		frame.add(srField);     
		JTable table=new JTable();
		model = (DefaultTableModel)table.getModel();
		table.setBackground(Color.decode("#f9d6c4"));
		model.addColumn("ITEM NAME");
		model.addColumn("CALORIES");
		tblupdt("");
		table.getColumnModel().getColumn(0).setPreferredWidth(225);
		JScrollPane scPane=new JScrollPane(table);
		scPane.setBounds(50, 180, 500, 225);
		frame.add(scPane);
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Front.dsin();
			}
		});
		
		srField.addKeyListener(new KeyAdapter() {
		      public void keyReleased(KeyEvent e) {
		        JTextField textField = (JTextField) e.getSource();
		        String text = textField.getText();
		        tblupdt(text);
		      }

		      public void keyTyped(KeyEvent e) {
		      }

		      public void keyPressed(KeyEvent e) {
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
	
	public static void tblupdt(String str) {
		try {
			ResultSet res = dbSearch(str);
			int rowCount = model.getRowCount();
			int i;
			for (i = rowCount - 1; i >= 0; i--)
			    model.removeRow(i);
			for(i=0; res.next(); i++) {
				model.addRow(new Object[0]);
		        model.setValueAt(res.getString("itemname"), i, 0);
		        model.setValueAt(res.getInt("calories"), i, 1);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	public static ResultSet dbSearch(String name) throws SQLException {
		//ENTER PORT, DATABASE NAME, USER, PASSWORD.
		String str1 = "SELECT * FROM items WHERE itemname like '%" +name +"%'";
		String url = "jdbc:mysql://localhost:port/dbname";
		String user = "user";
		String pass = "password";
		Connection con = DriverManager.getConnection(url, user, pass);
		Statement stm = con.createStatement();
		ResultSet rst = stm.executeQuery(str1);
		return rst;
	}
}
