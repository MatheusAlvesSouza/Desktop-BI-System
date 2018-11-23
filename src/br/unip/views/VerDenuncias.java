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

import br.unip.dao.DenunciaDesmatamentoDAO;
import br.unip.dao.IndioDAO;
import br.unip.dao.ReservaIndigenaDAO;
import br.unip.models.DenunciaDesmatamento;
import br.unip.models.Indio;
import br.unip.models.ReservaIndigena;

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VerDenuncias extends JDialog {

	private final JPanel contentPanel = new JPanel();
	String [] colunas = {"Id", "Tipo", "Cidade", "Data"};
	JTable tabela;
	DefaultTableModel model;
	private DenunciaDesmatamentoDAO denunciaDAO = new DenunciaDesmatamentoDAO();

	/**
	 * Launch the application.
	 */
	public void start() {
		try {
			VerDenuncias dialog = new VerDenuncias();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VerDenuncias() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VerDenuncias.class.getResource("/br/unip/assets/login.png")));
		setTitle("Denuncias");
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
			for (DenunciaDesmatamento denuncia: denunciaDAO.listarDenuncias(0)) {
				String[] linha = new String[]{ denuncia.getId() + "", denuncia.getNome(), denuncia.getCidade(), denuncia.getData()};
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
					JButton buttonExcluir = new JButton("Finalizar Selecionado");
					buttonExcluir.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							int resposta = JOptionPane.showConfirmDialog(contentPanel, 
									"Ao finalizar uma denúncia ela não aparecerá mais no quadro de alertas. "
									, "Deseja realmente finalizar?", JOptionPane.WARNING_MESSAGE);
						    //verfica se a resposta é verdadeira
						    if (resposta == JOptionPane.YES_OPTION) {
						    	int linha = tabela.getSelectedRow();
								 
								if( linha != -1){
									if(denunciaDAO.fechar(Integer.parseInt((String) tabela.getValueAt(linha , 0)))) {
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
