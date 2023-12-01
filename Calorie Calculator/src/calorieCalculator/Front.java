package calorieCalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;


@SuppressWarnings("serial")
public class Front extends JFrame {
	
	public static void dsin() {
		JFrame frame = new JFrame();
		Font bt = new Font("Copperplate Gothic Bold", Font.BOLD, 20);
		JLabel x = new JLabel("X");
		x.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 30));
		x.setForeground(Color.decode("#f9d6c4"));
		x.setBounds(560, 15, 30, 30);
		frame.add(x);
		JPanel panel = new JPanel();
		panel.setBounds(558, 19, 25, 25);
		panel.setBackground(Color.decode("#2a1d1f"));
		frame.add(panel);
		JLabel c = new JLabel("C");
		c.setFont(new Font("Castellar", Font.BOLD, 80));
		c.setForeground(Color.decode("#f9d6c4"));
		c.setBounds(150, 22, 80, 80);
		frame.add(c);
		JLabel calorie = new JLabel("ALORIE");
		calorie.setFont(new Font("Castellar", Font.BOLD, 30));
		calorie.setForeground(Color.decode("#f9d6c4"));
		calorie.setBounds(215, 28, 250, 30);
		frame.add(calorie);
		JLabel calc = new JLabel("ALCULATOR");
		calc.setFont(new Font("Castellar", Font.BOLD, 30));
		calc.setForeground(Color.decode("#f9d6c4"));
		calc.setBounds(215, 60, 250, 30);
		frame.add(calc);
		JButton search = new JButton("SEARCH");
		search.setBackground(Color.decode("#f57b3d"));
		search.setForeground(Color.WHITE);
		search.setBounds(175, 150, 250, 50);
		search.setFont(bt);
		frame.add(search);
		JButton add = new JButton("ADD");
		add.setBounds(175, 250, 250, 50);
		add.setBackground(Color.decode("#f57b3d"));
		add.setForeground(Color.WHITE);
		add.setFont(bt);
		frame.add(add);
		JButton edit = new JButton("EDIT");
		edit.setBackground(Color.decode("#f57b3d"));
		edit.setForeground(Color.WHITE);
		edit.setFont(bt);
		edit.setBounds(175, 350, 250, 50);
		frame.add(edit);
		panel.addMouseListener(new MouseAdapter() {
	        @Override
	        public void mouseClicked(MouseEvent e) {
	        	frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
	        }
	    });
		
		search.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				SearchWindow.srchdsin();
			} 
		});
		
		edit.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				EditWindow.editdsin();
			} 
		});
		
		add.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				AddWindow.adddsin();
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
}
