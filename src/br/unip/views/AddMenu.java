package br.unip.views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class AddMenu extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	public void start() {
		try {
			AddMenu dialog = new AddMenu();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Create the dialog.
	 */
	public AddMenu() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AddMenu.class.getResource("/br/unip/assets/login.png")));
		setTitle("Menu de Inser\u00E7\u00F5es");
		setResizable(false);
		setAlwaysOnTop(true);
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JButton btnCity = new JButton("Cidade");
		btnCity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddCidade addCidade = new AddCidade();
				dispose();
				addCidade.start();
			}
		});
		btnCity.setBounds(81, 53, 89, 38);
		contentPanel.add(btnCity);
		
		JButton btnReserve = new JButton("Reserva");
		btnReserve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddReserva addReserva = new AddReserva();
				dispose();
				addReserva.start();
			}
		});
		btnReserve.setBounds(81, 121, 89, 38);
		contentPanel.add(btnReserve);
		
		JButton btnNative = new JButton("\u00CDndio");
		btnNative.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddIndio addIndio = new AddIndio();
				dispose();
				addIndio.start();
			}
		});
		btnNative.setBounds(268, 53, 89, 38);
		contentPanel.add(btnNative);
		
		JButton btnWarn = new JButton("Den\u00FAncia");
		btnWarn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddDenuncia addDenuncia = new AddDenuncia();
				dispose();
				addDenuncia.start();
			}
		});
		btnWarn.setBounds(268, 121, 89, 38);
		contentPanel.add(btnWarn);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton backButton = new JButton("Voltar");
				backButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				backButton.setActionCommand("Cancel");
				buttonPane.add(backButton);
			}
		}
	}
}
