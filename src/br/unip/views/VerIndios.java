package br.unip.views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.unip.dao.IndioDAO;
import br.unip.dao.ReservaIndigenaDAO;
import br.unip.models.Indio;
import br.unip.models.ReservaIndigena;

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VerIndios extends JDialog {

	private final JPanel contentPanel = new JPanel();
	String [] colunas = {"Id", "Nome", "Sexo", "Idade", "Data de Nascimento"};
	JTable tabela;
	DefaultTableModel model;
	private IndioDAO indioDAO = new IndioDAO();
	private ReservaIndigenaDAO reservaDAO = new ReservaIndigenaDAO();

	/**
	 * Launch the application.
	 */
	public void start(int idReserva) {
		try {
			VerIndios dialog = new VerIndios(idReserva);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VerIndios(int idReserva) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VerIndios.class.getResource("/br/unip/assets/login.png")));
		ReservaIndigena reservaIndigena = reservaDAO.getReserva(idReserva);
		setTitle("\u00CDndios da reserva " + reservaIndigena.getNome());
		setAlwaysOnTop(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			DefaultTableModel tableModel = new DefaultTableModel(colunas, 0) {
				@Override
				public boolean isCellEditable(int row, int col)
				{
				return false;
				}
			};

			tabela = new JTable(tableModel);
			JScrollPane scroll = new JScrollPane();
			scroll.setViewportView(tabela);
			getContentPane().add(scroll);
			
			model =  (DefaultTableModel) tabela.getModel();
			for (Indio indio: indioDAO.listarIndios(idReserva)) {
				String[] linha = new String[]{ indio.getId() + "", indio.getNome(), indio.getSexo(), indio.getIdade() + "",
						indio.getDtNasc()};
				model.addRow(linha);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				{
					JButton buttonExcluir = new JButton("Excluir Selecionado");
					buttonExcluir.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							int resposta = JOptionPane.showConfirmDialog(contentPanel, 
									"Ao excluir um índio, você esta dizendo que ele faleceu ou não pertence "
									+ "mais a reserva.", "Deseja realmente excluir?", JOptionPane.WARNING_MESSAGE);
						    //verfica se a resposta é verdadeira
						    if (resposta == JOptionPane.YES_OPTION) {
						    	int linha = tabela.getSelectedRow();
								 
								if( linha != -1){
									Indio indio = new Indio();
									indio.setId( Integer.parseInt((String) tabela.getValueAt(linha , 0)));
									indio.setIdReserva(idReserva);
									if (indioDAO.deleteIndio(indio)) {
										model.removeRow( linha );										
									}
								}
						      }			
						}
					});
					buttonExcluir.setActionCommand("OK");
					buttonPane.add(buttonExcluir);
				}
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}

}
