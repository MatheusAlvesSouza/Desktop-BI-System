package br.unip.views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.unip.dao.ReservaIndigenaDAO;
import br.unip.models.ReservaIndigena;
import br.unip.utils.ComboItem;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SelecionarReserva extends JDialog {

	JComboBox comboBoxReserva = new JComboBox();
	private final JPanel contentPanel = new JPanel();
	private ReservaIndigenaDAO reservaDAO = new ReservaIndigenaDAO();

	/**
	 * Launch the application.
	 */
	public static void start() {
		try {
			SelecionarReserva dialog = new SelecionarReserva();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SelecionarReserva() {
		setModal(true);
		setResizable(false);
		setTitle("Selecione a Reserva Ind\u00EDgena");
		setIconImage(Toolkit.getDefaultToolkit().getImage(SelecionarReserva.class.getResource("/br/unip/assets/login.png")));
		setAlwaysOnTop(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			
			comboBoxReserva.setBounds(87, 92, 253, 20);
			for (ReservaIndigena reserva : reservaDAO.listarReservas(0)) {
				comboBoxReserva.addItem(new ComboItem(reserva.getNome(), reserva.getId()));
			}
			contentPanel.add(comboBoxReserva);
		}
		
		JLabel lblSelecioneAReserva = new JLabel("Selecione a Reserva Ind\u00EDgena:");
		lblSelecioneAReserva.setBounds(87, 77, 253, 14);
		contentPanel.add(lblSelecioneAReserva);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Object item = comboBoxReserva.getSelectedItem();
						int idReserva = ((ComboItem)item).getValue();
						dispose();
						VerIndios verIndios = new VerIndios(idReserva);
						verIndios.start(idReserva);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
