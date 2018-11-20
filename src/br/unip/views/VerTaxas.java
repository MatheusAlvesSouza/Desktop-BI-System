package br.unip.views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.unip.dao.AnaliseDAO;
import br.unip.models.Analise;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VerTaxas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	String [] colunas = {"Nome da Reserva","Estado","Cidade", "População", "Taxa Natalidade", "Taxa Mortalidade", "Denúnicas na Região"};
	private JTable table;
	private AnaliseDAO analiseDAO = new AnaliseDAO();

	public void start() {
		try {
			VerTaxas dialog = new VerTaxas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Create the dialog.
	 */
	public VerTaxas() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VerTaxas.class.getResource("/br/unip/assets/login.png")));
		setTitle("An\u00E1lise de Dados");
		setAlwaysOnTop(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		DefaultTableModel tableModel = new DefaultTableModel(colunas, 0) {
			@Override
			public boolean isCellEditable(int row, int col)
			{
			return false;
			}
		};

		JTable tabela = new JTable(tableModel);
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(tabela);
		getContentPane().add(scroll);
		
		DefaultTableModel model =  (DefaultTableModel) tabela.getModel();
		ArrayList<Analise> analises = analiseDAO.listar();
		for(Analise analise : analises) {
			
			String[] linha = new String[]{ analise.getReserva() , analise.getEstado(), analise.getCidade() , analise.getPopulacao() + "",
					analise.getNatalidade() + "%", analise.getMortalidade() + "%", analise.getDenuncias() + ""};
			model.addRow(linha);
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
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
}
