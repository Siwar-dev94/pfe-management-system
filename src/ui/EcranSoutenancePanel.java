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
public class EcranSoutenancePanel extends JPanel  {

    private final JTextField txtDate;
       private final JTextField txtSalle;
       private final JTextField txtNote;
    private final JComboBox<PFEItem> cbPFE;
    private final JTable table;

    private final SoutenanceDAO soutenanceDAO = new SoutenanceDAO();
    private final PFEDAO pfeDAO = new PFEDAO();

    public EcranSoutenancePanel() {

        setLayout(new BorderLayout(10, 10));
        setBackground(new Color(245, 245, 245));

        // 🔹 Formulaire en haut
        JPanel form = new JPanel();
        form.setBackground(Color.WHITE);
        form.setBorder(BorderFactory.createTitledBorder("Programmer Soutenance"));

        txtDate = new JTextField(10);
        txtSalle = new JTextField(10);
        txtNote = new JTextField(5);

        cbPFE = new JComboBox<>();
        chargerPFEs();

        JButton btnAdd = styledButton("Programmer", new Color(30, 136, 229));

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

        // 🔹 Table
        table = new JTable();
        chargerTable();
        add(new JScrollPane(table), BorderLayout.CENTER);

        // 🔹 Action bouton
        btnAdd.addActionListener(e -> programmerSoutenance());
    }

    // ---------------- Méthodes ----------------

    private JButton styledButton(String text, Color bg) {
        JButton btn = new JButton(text);
        btn.setBackground(bg);
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));
        return btn;
    }

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

        table.getTableHeader().setBackground(new Color(30, 136, 229));
        table.getTableHeader().setForeground(Color.WHITE);
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
    }

    private void chargerPFEs() {
        cbPFE.removeAllItems();
        for (Object[] o : pfeDAO.listerPFEs()) {
            cbPFE.addItem(new PFEItem((int) o[0], o[1].toString()));
        }
    }

    private void programmerSoutenance() {
        try {
            Soutenance s = new Soutenance();
            s.setDateSout(Date.valueOf(txtDate.getText()));
            s.setSalle(txtSalle.getText());
            s.setNote(Double.parseDouble(txtNote.getText()));
            s.setIdPfe(((PFEItem) cbPFE.getSelectedItem()).getId());

            soutenanceDAO.programmerSoutenance(s);
            chargerTable();
            nettoyerFormulaire();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erreur: " + ex.getMessage());
        }
    }

    private void nettoyerFormulaire() {
        txtDate.setText("");
        txtSalle.setText("");
        txtNote.setText("");
        cbPFE.setSelectedIndex(-1);
    }
}
