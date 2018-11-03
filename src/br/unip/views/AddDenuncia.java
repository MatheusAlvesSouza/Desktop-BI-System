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
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddDenuncia extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldTitulo;

	public void start() {
		try {
			AddDenuncia dialog = new AddDenuncia();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Create the dialog.
	 */
	public AddDenuncia() {
		setAlwaysOnTop(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(AddDenuncia.class.getResource("/br/unip/assets/login.png")));
		setModal(true);
		setTitle("Den\u00FAncias");
		setBounds(100, 100, 253, 299);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblEstado = new JLabel("Estado:");
			lblEstado.setBounds(10, 11, 46, 14);
			contentPanel.add(lblEstado);
		}
		{
			JLabel lblCidade = new JLabel("Cidade:");
			lblCidade.setBounds(10, 36, 46, 14);
			contentPanel.add(lblCidade);
		}
		{
			JLabel lblTitulo = new JLabel("Titulo:");
			lblTitulo.setBounds(10, 73, 46, 14);
			contentPanel.add(lblTitulo);
		}
		{
			JLabel lblDescricao = new JLabel("Descrica\u00E7\u00E3o:");
			lblDescricao.setBounds(10, 111, 86, 14);
			contentPanel.add(lblDescricao);
		}
		{
			JComboBox comboBoxEstado = new JComboBox();
			comboBoxEstado.setBounds(96, 8, 121, 20);
			contentPanel.add(comboBoxEstado);
		}
		{
			JComboBox comboBoxCidade = new JComboBox();
			comboBoxCidade.setBounds(96, 33, 121, 20);
			contentPanel.add(comboBoxCidade);
		}
		{
			textFieldTitulo = new JTextField();
			textFieldTitulo.setBounds(96, 70, 121, 20);
			contentPanel.add(textFieldTitulo);
			textFieldTitulo.setColumns(10);
		}
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(96, 111, 126, 94);
		contentPanel.add(textPane);
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
