package br.unip.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
		frmProjectName.setTitle("Project Name");
		frmProjectName.setBounds(100, 100, 405, 267);
		frmProjectName.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProjectName.getContentPane().setLayout(null);
		
		JLabel lblLoginBiSystem = new JLabel("Login BI System");
		lblLoginBiSystem.setForeground(Color.BLACK);
		lblLoginBiSystem.setFont(new Font("Century Gothic", Font.BOLD, 23));
		lblLoginBiSystem.setBounds(10, 11, 369, 23);
		frmProjectName.getContentPane().add(lblLoginBiSystem);
		
		txt_user = new JTextField();
		txt_user.setText("admin");
		txt_user.setBounds(95, 81, 235, 20);
		frmProjectName.getContentPane().add(txt_user);
		txt_user.setColumns(10);
		
		JLabel lblUser = new JLabel("User:");
		lblUser.setBounds(95, 57, 46, 14);
		frmProjectName.getContentPane().add(lblUser);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(95, 112, 73, 14);
		frmProjectName.getContentPane().add(lblPassword);
		
		JButton btn_sign = new JButton("Sign In");
		btn_sign.setBounds(241, 183, 89, 23);
		frmProjectName.getContentPane().add(btn_sign);
		
		txt_password = new JPasswordField();
		txt_password.setBounds(95, 137, 235, 20);
		frmProjectName.getContentPane().add(txt_password);
		
		txt_password.setText("123");
		
		JLabel lblInf = new JLabel("User or Password Incorrect !");
		lblInf.setForeground(Color.RED);
		lblInf.setFont(new Font("Arial", Font.BOLD, 13));
		lblInf.setBounds(27, 186, 184, 14);
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
