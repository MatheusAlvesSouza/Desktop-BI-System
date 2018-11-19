package br.unip.views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.unip.dao.CidadeDAO;
import br.unip.dao.EstadoDAO;
import br.unip.dao.ReservaIndigenaDAO;
import br.unip.models.Cidade;
import br.unip.models.Estado;
import br.unip.models.ReservaIndigena;
import br.unip.utils.ComboItem;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class AddReserva extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldNome;
	JComboBox comboBoxEstado = new JComboBox();
	JComboBox comboBoxCidade = new JComboBox();
	CidadeDAO cidadeDAO = new CidadeDAO();
	ReservaIndigenaDAO reservaDAO = new ReservaIndigenaDAO();

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
			
			comboBoxEstado.setBounds(53, 23, 88, 20);
			
			EstadoDAO estadoDAO = new EstadoDAO();
			ArrayList<Estado> estados = estadoDAO.listarEstados(1);
			
			for( Estado estado : estados) {
				comboBoxEstado.addItem(new ComboItem(estado.getNome(), estado.getId()));
			}
			
			atualizaCidade();
			comboBoxEstado.addItemListener( new ItemListener() {
				
				@Override
				public void itemStateChanged(ItemEvent e) {
					atualizaCidade();
				}
			});
			contentPanel.add(comboBoxEstado);
		}
		{
			
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
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Object item = comboBoxCidade.getSelectedItem();
						int idCidade = ((ComboItem)item).getValue();
						ReservaIndigena reserva = new ReservaIndigena();
						reserva.setIdCidade(idCidade);
						reserva.setNome(textFieldNome.getText());
						if (reservaDAO.adicionar(reserva)) {
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
	
	public void atualizaCidade() {
		Object item = comboBoxEstado.getSelectedItem();
		int idEstado = ((ComboItem)item).getValue();
		ArrayList<Cidade> cidades = cidadeDAO.listarCidades(idEstado);
		comboBoxCidade.removeAllItems();
		for( Cidade cidade : cidades) {
			comboBoxCidade.addItem(new ComboItem(cidade.getNome(), cidade.getId()));
		}
	}

}
