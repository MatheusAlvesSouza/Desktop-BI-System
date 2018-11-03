package br.unip.views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddReserva extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldNome;

	public void start() {
		try {
			AddReserva dialog = new AddReserva();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddReserva() {
		setModal(true);
		setAlwaysOnTop(true);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(AddReserva.class.getResource("/br/unip/assets/login.png")));
		setTitle("Reservas Ind\u00EDgenas");
		setBounds(100, 100, 188, 217);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblEstado = new JLabel("Estado:");
			lblEstado.setBounds(10, 26, 46, 14);
			contentPanel.add(lblEstado);
		}
		{
			JLabel lblCidade = new JLabel("Cidade:");
			lblCidade.setBounds(10, 66, 46, 14);
			contentPanel.add(lblCidade);
		}
		{
			JLabel lblNome = new JLabel("Nome:");
			lblNome.setBounds(10, 108, 46, 14);
			contentPanel.add(lblNome);
		}
		{
			JComboBox comboBoxEstado = new JComboBox();
			comboBoxEstado.setBounds(53, 23, 88, 20);
			contentPanel.add(comboBoxEstado);
		}
		{
			JComboBox comboBoxCidade = new JComboBox();
			comboBoxCidade.setBounds(53, 63, 88, 20);
			contentPanel.add(comboBoxCidade);
		}
		{
			textFieldNome = new JTextField();
			textFieldNome.setBounds(53, 105, 88, 20);
			contentPanel.add(textFieldNome);
			textFieldNome.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
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
