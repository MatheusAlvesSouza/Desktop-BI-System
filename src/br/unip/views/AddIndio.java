package br.unip.views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddIndio extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldNome;
	private JTextField textFieldDtNasc;

	public void start() {
		try {
			AddIndio dialog = new AddIndio();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddIndio() {
		setAlwaysOnTop(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(AddIndio.class.getResource("/br/unip/assets/login.png")));
		setResizable(false);
		setModal(true);
		setTitle("\u00EDndios");
		setBounds(100, 100, 324, 217);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		JRadioButton rdbtnM = new JRadioButton("M");
		JRadioButton rdbtnF = new JRadioButton("F");
		ButtonGroup grupoGenero = new ButtonGroup();
		grupoGenero.add(rdbtnM);
		grupoGenero.add(rdbtnF);
		
		{
			JLabel lblReservaIndigena = new JLabel("Reserva Indigena:");
			lblReservaIndigena.setBounds(10, 11, 111, 14);
			contentPanel.add(lblReservaIndigena);
		}
		{
			JLabel lblNome = new JLabel("Nome:");
			lblNome.setBounds(10, 36, 46, 14);
			contentPanel.add(lblNome);
		}
		{
			JLabel lblSexo = new JLabel("Sexo:");
			lblSexo.setBounds(10, 61, 46, 14);
			contentPanel.add(lblSexo);
		}
		{
			JLabel lblDataDeNascimento = new JLabel("Data de Nascimento:");
			lblDataDeNascimento.setBounds(10, 86, 123, 14);
			contentPanel.add(lblDataDeNascimento);
		}
		{
			JComboBox comboBoxReserva = new JComboBox();
			comboBoxReserva.setBounds(131, 8, 164, 20);
			contentPanel.add(comboBoxReserva);
		}
		{
			textFieldNome = new JTextField();
			textFieldNome.setText("");
			textFieldNome.setBounds(130, 33, 164, 20);
			contentPanel.add(textFieldNome);
			textFieldNome.setColumns(10);
		}
		{
			
			rdbtnM.setSelected(true);
			rdbtnM.setBounds(177, 57, 46, 23);
			contentPanel.add(rdbtnM);
		}
		
		{
			
			rdbtnF.setBounds(225, 57, 48, 23);
			contentPanel.add(rdbtnF);
		}
		{
			textFieldDtNasc = new JTextField();
			textFieldDtNasc.setBounds(131, 83, 164, 20);
			contentPanel.add(textFieldDtNasc);
			textFieldDtNasc.setColumns(10);
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
