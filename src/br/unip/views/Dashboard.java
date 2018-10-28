package br.unip.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;

public class Dashboard {

	private JFrame frmDashboard;

	/**
	 * Create the application.
	 */
	public Dashboard() {
		initialize();
	}
	
	public void start() {
		frmDashboard.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDashboard = new JFrame();
		frmDashboard.setTitle("Dashboard");
		frmDashboard.setResizable(false);
		frmDashboard.setAlwaysOnTop(true);
		frmDashboard.setBounds(100, 100, 525, 368);
		frmDashboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDashboard.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(10, 11, 499, 61);
		frmDashboard.getContentPane().add(panel);
		panel.setLayout(null);
		
		Button btnInsert = new Button("Add");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnInsert.setBounds(10, 10, 81, 41);
		panel.add(btnInsert);
		
		Button btnList = new Button("List All");
		btnList.setBounds(123, 10, 81, 41);
		panel.add(btnList);
		
		Button btnSearch = new Button("Search");
		btnSearch.setBounds(301, 10, 81, 41);
		panel.add(btnSearch);
		
		Button btnWarn = new Button("Warns");
		btnWarn.setBounds(408, 10, 81, 41);
		panel.add(btnWarn);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.LIGHT_GRAY);
		desktopPane.setBounds(10, 83, 499, 246);
		frmDashboard.getContentPane().add(desktopPane);
	}
}
