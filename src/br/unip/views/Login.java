package br.unip.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.Color;
import javax.swing.JPasswordField;

public class Login {

	private JFrame frmProjectName;
	private JTextField txt_user;
	private JPasswordField txt_password;
	private Dashboard dashboard = new Dashboard();
	
	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}
	
	public void start() {
		frmProjectName.setVisible(true);
	}
	
	public void close() {
		frmProjectName.dispose();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmProjectName = new JFrame();
		frmProjectName.setTitle("Native Human Project");
		frmProjectName.setBounds(100, 100, 559, 360);
		frmProjectName.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProjectName.getContentPane().setLayout(null);
		
		try {
			frmProjectName.setContentPane(new JLabel(new ImageIcon(
					ImageIO.read(getClass().getResource("/br/unip/assets/background-login.jpg"))
			)));
		} catch (IOException e1) {}
		
		JLabel lblLoginBiSystem;
		try {
			lblLoginBiSystem = new JLabel(new ImageIcon(
					ImageIO.read(getClass().getResource("/br/unip/assets/headdress.png"))
			));
			lblLoginBiSystem.setForeground(Color.BLACK);
			lblLoginBiSystem.setFont(new Font("Century Gothic", Font.BOLD, 23));
			lblLoginBiSystem.setBounds(24, 48, 184, 157);
			frmProjectName.getContentPane().add(lblLoginBiSystem);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		
		txt_user = new JTextField();
		txt_user.setText("admin");
		txt_user.setBounds(255, 87, 235, 20);
		frmProjectName.getContentPane().add(txt_user);
		txt_user.setColumns(10);
		
		JLabel lblUser = new JLabel("User:");
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUser.setForeground(Color.WHITE);
		lblUser.setBounds(255, 62, 46, 14);
		frmProjectName.getContentPane().add(lblUser);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPassword.setBounds(255, 118, 73, 14);
		frmProjectName.getContentPane().add(lblPassword);
		
		JButton btn_sign = new JButton("");
		btn_sign.setBounds(401, 239, 89, 53);
		frmProjectName.getContentPane().add(btn_sign);
		
		txt_password = new JPasswordField();
		txt_password.setBounds(255, 143, 235, 20);
		frmProjectName.getContentPane().add(txt_password);
		
		txt_password.setText("123");
		
		JLabel lblInf = new JLabel("User or Password Incorrect !");
		lblInf.setForeground(Color.RED);
		lblInf.setFont(new Font("Arial", Font.BOLD, 13));
		lblInf.setBounds(68, 257, 184, 14);
		frmProjectName.getContentPane().add(lblInf);
		
		lblInf.setVisible(false);
		
		btn_sign.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (txt_user.getText().equals("admin") && 
					txt_password.getText().equals("123")) {
					dashboard.start(); //Starts the dashboard
					close(); // Closed the currently frame
				} else {
					lblInf.setVisible(true);
				}
			}
		});
		
		try {
			btn_sign.setIcon( 
				new ImageIcon(
					ImageIO.read(getClass().getResource("/br/unip/assets/login.png"))
			));
			
			JPanel panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panel.setBounds(218, 41, 3, 164);
			frmProjectName.getContentPane().add(panel);
		} catch ( Exception e) {
			btn_sign.setText("Login");
		}
		
	
	}


	public JFrame getFrmProjectName() {
		return frmProjectName;
	}


	public JTextField getTextField() {
		return txt_user;
	}


	public JTextField getTextField_1() {
		return txt_password;
	}
}
