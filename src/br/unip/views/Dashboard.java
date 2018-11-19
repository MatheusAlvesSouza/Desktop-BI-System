package br.unip.views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;

import br.unip.dao.*;

public class Dashboard {

	private JFrame frmDashboard;
	JLabel label_n_denuncias = new JLabel("0");
	JLabel label_n_reservas = new JLabel("0");
	JLabel label_n_indios = new JLabel("0");


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
		frmDashboard.setIconImage(Toolkit.getDefaultToolkit().getImage(Dashboard.class.getResource("/br/unip/assets/login.png")));
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
		
		btnInsert.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AddMenu addMenu = new AddMenu();
				addMenu.start();
			}
		});
		
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
		
		btnRefresh.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				getInfos();
				
			}
		});
		
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.LIGHT_GRAY);
		desktopPane.setBounds(10, 83, 499, 246);
		frmDashboard.getContentPane().add(desktopPane);
		
		JLabel lblReservasInd = new JLabel("Reservas Ind\u00EDgenas");
		lblReservasInd.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblReservasInd.setBounds(53, 122, 135, 35);
		desktopPane.add(lblReservasInd);
		
		JLabel lblndios = new JLabel("\u00CDndios");
		lblndios.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblndios.setBounds(237, 132, 46, 14);
		desktopPane.add(lblndios);
		
		JLabel lblDenncias = new JLabel("Den\u00FAncias");
		lblDenncias.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDenncias.setBounds(328, 132, 84, 14);
		desktopPane.add(lblDenncias);
		
		label_n_reservas.setForeground(Color.GREEN);
		label_n_reservas.setFont(new Font("OCR A Extended", Font.BOLD, 32));
		label_n_reservas.setBounds(104, 91, 57, 35);
		desktopPane.add(label_n_reservas);
		
		label_n_indios.setForeground(Color.GREEN);
		label_n_indios.setFont(new Font("OCR A Extended", Font.BOLD, 32));
		label_n_indios.setBounds(245, 91, 57, 35);
		desktopPane.add(label_n_indios);
		
		
		label_n_denuncias.setForeground(Color.RED);
		label_n_denuncias.setFont(new Font("OCR A Extended", Font.BOLD, 32));
		label_n_denuncias.setBounds(347, 91, 57, 35);
		desktopPane.add(label_n_denuncias);
		
		getInfos();
		
	}
	
	public void getInfos () {
		
		ReservaIndigenaDAO reservasDAO = new ReservaIndigenaDAO();
		DenunciaDesmatamentoDAO denunciasDAO = new DenunciaDesmatamentoDAO();
		IndioDAO indioDAO = new IndioDAO();
		
		
		label_n_reservas.setText((reservasDAO.listarReservas(0).size() + ""));
		label_n_indios.setText(indioDAO.listarIndios(0).size() + "");
		label_n_denuncias.setText(denunciasDAO.listarDenuncias(0).size() + "");
		
	}
}
