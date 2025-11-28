package ihm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dtos.EmployeDto;
import repositories.EmployeRepository;
import services.EmployeServiceImpl;
import services.IEmployeService;

import java.awt.Window.Type;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Fenetre extends JFrame {
	
	private static IEmployeService service = new EmployeServiceImpl(new EmployeRepository());
	private static JScrollPane scrollPane;
	private static JTable table;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtNom;
	private JTextField txtPrenom;
	private JTextField txtSalaire;
	private JButton btnAjouter;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fenetre frame = new Fenetre();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	
	public static void remplir() throws Exception {
		String[] colonnes = {"Id", "Nom", "Prénom", "Salaire"};
		List<EmployeDto> all = service.getAll();
		
		Object[][] lignes = new Object[all.size()][4];
		for (int i = 0; i < all.size(); i++) {
			lignes[i][0] = all.get(i).getId();
			lignes[i][1] = all.get(i).getNom();
			lignes[i][2] = all.get(i).getPrenom();
			lignes[i][3] = all.get(i).getSalaire();
		}
		
		table = new JTable(lignes, colonnes);
		
		//Masquer l'id dans table
		table.removeColumn(table.getColumnModel().getColumn(0));
		
		//Affecter la table au scrollPane
		scrollPane.setViewportView(table);
	}
	
	public void clear() {
		txtId.setText("");
		txtNom.setText("");
		txtPrenom.setText("");
		txtSalaire.setText("");
		btnAjouter.setText("Ajouter");
	}
	
	public Fenetre() throws Exception {
		setType(Type.UTILITY);
		setTitle("Fenêtre principale");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 843, 634);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Fichier");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Quitter");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(79, 67, 330, 315);
		contentPane.add(panel);
		panel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 11, 285, 293);
		panel.add(scrollPane);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//récupérer l'id de la ligne sélectionnée
				int ligne = table.getSelectedRow();
				if(ligne != -1) {
				int id = (int)table.getModel().getValueAt(ligne, 0);
				try {
					service.delete(id);
					remplir();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erreur: "+e1.getMessage());
				}
			}else {
				JOptionPane.showMessageDialog(null, "Aucune ligne sélectionnée......");
			}
			}
		});
		btnSupprimer.setBounds(78, 399, 100, 23);
		contentPane.add(btnSupprimer);
		
		JButton btnEditer = new JButton("Editer");
		btnEditer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//récupérer l'id de la ligne sélectionnée
				int ligne = table.getSelectedRow();
				if(ligne != -1) {
				int id = (int)table.getModel().getValueAt(ligne, 0);
				try {
					EmployeDto dto = service.getById(id);
					txtId.setText(String.valueOf(dto.getId()));
					txtNom.setText(dto.getNom());
					txtPrenom.setText(dto.getPrenom());
					txtSalaire.setText(String.valueOf(dto.getSalaire()));
					btnAjouter.setText("Modifier");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erreur: "+e1.getMessage());
				}
			}else {
				JOptionPane.showMessageDialog(null, "Aucune ligne sélectionnée......");
			}
			}
			
		});
		btnEditer.setBounds(320, 399, 89, 23);
		contentPane.add(btnEditer);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(462, 67, 336, 315);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		txtId = new JTextField();
		txtId.setEnabled(false);
		txtId.setBounds(144, 36, 119, 20);
		panel_1.add(txtId);
		txtId.setColumns(10);
		
		txtNom = new JTextField();
		txtNom.setColumns(10);
		txtNom.setBounds(144, 76, 119, 20);
		panel_1.add(txtNom);
		
		txtPrenom = new JTextField();
		txtPrenom.setColumns(10);
		txtPrenom.setBounds(144, 123, 119, 20);
		panel_1.add(txtPrenom);
		
		txtSalaire = new JTextField();
		txtSalaire.setColumns(10);
		txtSalaire.setBounds(144, 172, 119, 20);
		panel_1.add(txtSalaire);
		
		JLabel lblNewLabel = new JLabel("Id:");
		lblNewLabel.setBounds(60, 39, 46, 14);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nom:");
		lblNewLabel_1.setBounds(60, 79, 46, 14);
		panel_1.add(lblNewLabel_1);
		
		JLabel txtLabelprenom = new JLabel("Prénom:");
		txtLabelprenom.setBounds(60, 126, 56, 14);
		panel_1.add(txtLabelprenom);
		
		JLabel lblNewLabel_3 = new JLabel("Salaire:");
		lblNewLabel_3.setBounds(60, 175, 46, 14);
		panel_1.add(lblNewLabel_3);
		
		btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EmployeDto dto = new EmployeDto(0, txtNom.getText(), txtPrenom.getText(), Double.parseDouble(txtSalaire.getText()));
				try {
					if(btnAjouter.getText().equals("Ajouter")) {
						service.insert(dto);
					}else {
						dto.setId(Integer.parseInt(txtId.getText()));
						service.update(dto);
					}
					remplir();
					clear();
					JOptionPane.showMessageDialog(null, "Database MAJ.......");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erreur: "+e1.getMessage());
				}
			}

			
		});
		btnAjouter.setBounds(162, 232, 89, 23);
		panel_1.add(btnAjouter);
		
		
		remplir();

	}
}
