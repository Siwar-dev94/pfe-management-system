/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;
import dao.*;
import model.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Date;
/**
 *
 * @author User
 */
public class EcranSoutenanceFrame extends JFrame  {
      private JTextField txtDate, txtSalle, txtNote;
    private JComboBox<PFEItem> cbPFE;
    private final JTable table;

    private SoutenanceDAO soutenanceDAO = new SoutenanceDAO();
    private final PFEDAO pfeDAO = new PFEDAO();
    
    
    
     
    // ✅ CONSTRUCTEUR (TRÈS IMPORTANT)
    public EcranSoutenanceFrame() {

        setTitle("Gestion des Soutenances");
        setSize(900, 400);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(245,245,245));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // 🔹 Champs
        txtDate = new JTextField(10);
        txtSalle = new JTextField(10);
        txtNote = new JTextField(5);

        cbPFE = new JComboBox<>();
        chargerPFEs();

        JButton btnAdd = new JButton("Programmer");
         
        // 🔹 Table
        table = new JTable();
        chargerTable();

        // 🔹 Action bouton
        btnAdd.addActionListener(e -> {
            Soutenance s = new Soutenance();
            s.setDateSout(Date.valueOf(txtDate.getText()));
            s.setSalle(txtSalle.getText());
            s.setNote(Double.parseDouble(txtNote.getText()));
            s.setIdPfe(((PFEItem) cbPFE.getSelectedItem()).getId());

            soutenanceDAO.programmerSoutenance(s);
            chargerTable();
        });

        // 🔹 Formulaire
       JPanel form = new JPanel();
form.setBackground(Color.WHITE);
form.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        form.add(new JLabel("Date (yyyy-mm-dd)"));
        form.add(txtDate);
        form.add(new JLabel("Salle"));
        form.add(txtSalle);
        form.add(new JLabel("Note"));
        form.add(txtNote);
        form.add(new JLabel("PFE"));
        form.add(cbPFE);
        form.add(btnAdd);

        add(form, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    // 📋 Charger table soutenances
    private void chargerTable() {

        DefaultTableModel model = new DefaultTableModel(
                new Object[]{"ID", "Date", "Salle", "Note", "Étudiant", "PFE"}, 0
        );

        for (Object[] row : soutenanceDAO.listerSoutenances()) {
            model.addRow(row);
        }

        table.setModel(model);
        
        table.setRowHeight(26);
table.setFont(new Font("Segoe UI", Font.PLAIN, 13));

table.getTableHeader().setBackground(new Color(30,136,229));
table.getTableHeader().setForeground(Color.WHITE);
table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));

    }

    // 📌 Charger PFEs dans ComboBox
    private void chargerPFEs() {
        for (Object[] o : pfeDAO.listerPFEs()) {
            cbPFE.addItem(new PFEItem((int) o[0], o[1].toString()));
        }
    }
}
