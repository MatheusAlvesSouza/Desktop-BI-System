package br.unip.views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.unip.dao.CidadeDAO;
import br.unip.dao.EstadoDAO;
import br.unip.models.Cidade;
import br.unip.models.Estado;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import br.unip.utils.*;

public class AddCidade extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textCidade;
	private CidadeDAO cidadeDAO = new CidadeDAO();

	public void start() {
		try {
			AddCidade dialog = new AddCidade();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddCidade() {
		setModal(true);
		setAlwaysOnTop(true);
		setResizable(false);
		setTitle("Cidades");
		setIconImage(Toolkit.getDefaultToolkit().getImage(AddCidade.class.getResource("/br/unip/assets/login.png")));
		setBounds(100, 100, 222, 153);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(10, 11, 46, 14);
		contentPanel.add(lblEstado);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(10, 36, 46, 14);
		contentPanel.add(lblCidade);
		
		textCidade = new JTextField();
		textCidade.setBounds(89, 33, 105, 20);
		contentPanel.add(textCidade);
		textCidade.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		
		EstadoDAO estadoDAO = new EstadoDAO();
		ArrayList<Estado> estados = estadoDAO.listarEstados(1);
		
		for( Estado estado : estados) {
			comboBox.addItem(new ComboItem(estado.getNome(), estado.getId()));
		}
		
		comboBox.setBounds(89, 8, 105, 20);
		contentPanel.add(comboBox);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Object item = comboBox.getSelectedItem();
						int idEstado = ((ComboItem)item).getValue();
						
						Cidade cidade = new Cidade();
						cidade.setIdEstado(idEstado);
						cidade.setNome(textCidade.getText());
						if(cidadeDAO.adicionar(cidade)) {
							dispose();
						}
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
