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

/**
 *
 * @author User
 */
public class  EcranPFEPanel extends JPanel {
   private final JTextField txtTitre;
    private final JTextArea txtDescription;
    private final JComboBox<Etudiant> cbEtudiant;
    private final JList<Encadreur> listEncad;
    private final JTable table;

    private final PFEDAO pfeDAO = new PFEDAO();
    private final EtudiantDAO etudDAO = new EtudiantDAO();
    private final EncadreurDAO encDAO = new EncadreurDAO();

    public EcranPFEPanel() {

        setLayout(new BorderLayout(10, 10));
        setBackground(new Color(245, 245, 245));

        /* ================= FORMULAIRE (GAUCHE) ================= */
        JPanel form = new JPanel();
        form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));
        form.setBackground(Color.WHITE);
        form.setBorder(BorderFactory.createTitledBorder("Informations PFE"));
        form.setPreferredSize(new Dimension(350, 0));

        txtTitre = new JTextField();
        txtDescription = new JTextArea(4, 20);
        txtDescription.setLineWrap(true);
        txtDescription.setWrapStyleWord(true);

        cbEtudiant = new JComboBox<>();
        for (Etudiant e : etudDAO.lister()) {
            cbEtudiant.addItem(e);
        }

        listEncad = new JList<>(encDAO.lister().toArray(new Encadreur[0]));
        listEncad.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        form.add(new JLabel("Titre"));
        form.add(txtTitre);
        form.add(Box.createVerticalStrut(8));

        form.add(new JLabel("Description"));
        form.add(new JScrollPane(txtDescription));
        form.add(Box.createVerticalStrut(8));

        form.add(new JLabel("Étudiant"));
        form.add(cbEtudiant);
        form.add(Box.createVerticalStrut(8));

        form.add(new JLabel("Encadreurs"));
        form.add(new JScrollPane(listEncad));

        add(form, BorderLayout.WEST);

        /* ================= TABLE ================= */
        table = new JTable();
        chargerTable();
        add(new JScrollPane(table), BorderLayout.CENTER);

        /* ================= BOUTONS ================= */
        JPanel actions = new JPanel();
        JButton btnAdd = styledButton("Ajouter", new Color(30, 136, 229));   // Bleu
        JButton btnUpdate = styledButton("Modifier", new Color(67, 160, 71)); // Vert
        JButton btnDelete = styledButton("Supprimer", new Color(229, 57, 53)); // Rouge
        actions.add(btnAdd);
        actions.add(btnUpdate);
        actions.add(btnDelete);
        add(actions, BorderLayout.SOUTH);

        /* ================= ACTIONS ================= */
        btnAdd.addActionListener(e -> ajouterPFE());
        btnUpdate.addActionListener(e -> modifierPFE());
        btnDelete.addActionListener(e -> supprimerPFE());

        // Sélection tableau → formulaire
        table.getSelectionModel().addListSelectionListener(e -> remplirFormulaireDepuisTable());
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
                new Object[]{"ID", "Titre", "État", "Étudiant", "Classe"}, 0
        );

        for (Object[] o : pfeDAO.listerPFEs()) {
            model.addRow(o);
        }
        table.setModel(model);

        table.setRowHeight(26);
        table.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        table.getTableHeader().setBackground(new Color(30, 136, 229));
        table.getTableHeader().setForeground(Color.WHITE);
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
    }

    private void ajouterPFE() {
        if (txtTitre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Titre obligatoire !");
            return;
        }

        Etudiant et = (Etudiant) cbEtudiant.getSelectedItem();
        if (et == null) return;

        int idPfe = pfeDAO.ajouterPFE(txtTitre.getText(), txtDescription.getText(), et.getIdEtud());
        if (idPfe == -1) {
            JOptionPane.showMessageDialog(this, "Erreur insertion PFE");
            return;
        }

        for (Encadreur en : listEncad.getSelectedValuesList()) {
            pfeDAO.ajouterEncadreur(idPfe, en.getIdEncad());
        }

        chargerTable();
        nettoyerFormulaire();
    }

    private void modifierPFE() {
        int row = table.getSelectedRow();
        if (row == -1) return;

        int idPfe = (int) table.getValueAt(row, 0);
        Etudiant et = (Etudiant) cbEtudiant.getSelectedItem();

        pfeDAO.modifierPFE(idPfe, txtTitre.getText(), txtDescription.getText(), et.getIdEtud());
        chargerTable();
    }

    private void supprimerPFE() {
        int row = table.getSelectedRow();
        if (row == -1) return;

        int id = (int) table.getValueAt(row, 0);
        pfeDAO.supprimerPFE(id);
        chargerTable();
    }

    private void remplirFormulaireDepuisTable() {
        int row = table.getSelectedRow();
        if (row == -1) return;

        txtTitre.setText(table.getValueAt(row, 1).toString());
        // Tu peux aussi remplir Étudiant et Encadreurs si besoin
    }

    private void nettoyerFormulaire() {
        txtTitre.setText("");
        txtDescription.setText("");
        listEncad.clearSelection();
    }

}





    

    
    
    

