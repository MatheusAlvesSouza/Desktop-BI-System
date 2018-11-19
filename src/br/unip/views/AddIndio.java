package br.unip.views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import br.unip.dao.IndioDAO;
import br.unip.dao.ReservaIndigenaDAO;
import br.unip.models.Estado;
import br.unip.models.Indio;
import br.unip.models.ReservaIndigena;
import br.unip.utils.ComboItem;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class AddIndio extends JDialog {

	private final JPanel contentPanel = new JPanel();
	JComboBox comboBoxReserva = new JComboBox();
	private JTextField textFieldNome;
	private JTextField textFieldDtNasc;
	private ReservaIndigenaDAO reservaDAO = new ReservaIndigenaDAO();
	private IndioDAO indioDAO = new IndioDAO();

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
			
			comboBoxReserva.setBounds(131, 8, 164, 20);
			
			ArrayList<ReservaIndigena> reservas = reservaDAO.listarReservas(0);
			for( ReservaIndigena reserva : reservas) {
				comboBoxReserva.addItem(new ComboItem(reserva.getNome(), reserva.getId()));
			}
			
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
			textFieldDtNasc = new JFormattedTextField();
			textFieldDtNasc.setBounds(131, 83, 164, 20);
			
			MaskFormatter formater = new MaskFormatter(); 
			try {
				formater.setMask("####-##-##");
			} catch (ParseException e) {} 
			formater.install((JFormattedTextField) textFieldDtNasc);
			
			
			contentPanel.add(textFieldDtNasc);
			textFieldDtNasc.setColumns(10);
		}
		{
			JLabel lblAaaammdd = new JLabel("AAAA-MM-DD");
			lblAaaammdd.setForeground(Color.LIGHT_GRAY);
			lblAaaammdd.setBounds(131, 104, 123, 14);
			contentPanel.add(lblAaaammdd);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Indio indio = new Indio();
						Object item = comboBoxReserva.getSelectedItem();
						int idReserva = ((ComboItem)item).getValue();
						indio.setIdReserva(idReserva);
						indio.setNome(textFieldNome.getText());
						indio.setDtNasc(textFieldDtNasc.getText());
						if (rdbtnF.isSelected()) {
							indio.setSexo("F");
						} else {
							indio.setSexo("M");
						}
						
						if (indioDAO.adicionar(indio)) {
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
