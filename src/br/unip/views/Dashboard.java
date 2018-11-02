package br.unip.views;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JProgressBar;

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
		
		// JButton Insert / Add
		JButton btnInsert = new JButton("");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnInsert.setBounds(10, 10, 81, 41);
		panel.add(btnInsert);
		
		try {
			btnInsert.setIcon( 
				new ImageIcon(
					ImageIO.read(getClass().getResource("/br/unip/assets/add.png"))
			));
		} catch ( Exception e) {
			btnInsert.setText("Add");
		}
		
		// JButton List All
		JButton btnList = new JButton("");
		btnList.setBounds(101, 10, 81, 41);
		panel.add(btnList);
		
		try {
			btnList.setIcon( 
				new ImageIcon(
					ImageIO.read(getClass().getResource("/br/unip/assets/list.png"))
			));
		} catch ( Exception e) {
			btnList.setText("List All");
		}
		
		// JButton Search
		JButton btnSearch = new JButton("");
		btnSearch.setBounds(283, 10, 81, 41);
		panel.add(btnSearch);
		
		try {
			btnSearch.setIcon( 
				new ImageIcon(
					ImageIO.read(getClass().getResource("/br/unip/assets/search.png"))
			));
		} catch ( Exception e) {
			btnSearch.setText("Search");
		}
		
		// JButton Warn
		JButton btnWarn = new JButton("");
		btnWarn.setBounds(374, 10, 81, 41);
		panel.add(btnWarn);
		
		try {
			btnWarn.setIcon( 
				new ImageIcon(
					ImageIO.read(getClass().getResource("/br/unip/assets/warning.png"))
			));
		} catch ( Exception e) {
			btnWarn.setText("Warns");
		}
		
		// JButton Refresh
		JButton btnRefresh = new JButton("");
		btnRefresh.setBounds(192, 10, 81, 41);
		panel.add(btnRefresh);
		
		try {
			btnRefresh.setIcon( 
				new ImageIcon(
					ImageIO.read(getClass().getResource("/br/unip/assets/refresh.png"))
			));
		} catch ( Exception e) {
			btnRefresh.setText("Refresh");
		}
		
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.LIGHT_GRAY);
		desktopPane.setBounds(10, 83, 499, 246);
		frmDashboard.getContentPane().add(desktopPane);

	}
}
