/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;
import dao.EtudiantDAO;
import model.Etudiant;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
/**
 *
 * @author User
 */
public class EtudiantPanel extends JPanel {
  private JTextField txtNom, txtPrenom, txtEmail, txtClasse;
    private JTable table;
    private EtudiantDAO dao = new EtudiantDAO();

    public EtudiantPanel() {
        setLayout(new BorderLayout(10,10));
        setBackground(new Color(245,245,245));

        // 🔹 Champs
        txtNom = new JTextField(10);
        txtPrenom = new JTextField(10);
        txtEmail = new JTextField(15);
        txtClasse = new JTextField(8);

        Font fieldFont = new Font("Segoe UI", Font.PLAIN, 13);
        txtNom.setFont(fieldFont);
        txtPrenom.setFont(fieldFont);
        txtEmail.setFont(fieldFont);
        txtClasse.setFont(fieldFont);

        txtNom.setBorder(BorderFactory.createLineBorder(new Color(200,200,200)));

        // 🔹 Boutons
        JButton btnAdd = styledButton("Ajouter", new Color(30,136,229));   // Bleu
        JButton btnUpdate = styledButton("Modifier", new Color(67,160,71)); // Vert
        JButton btnDelete = styledButton("Supprimer", new Color(229,57,53));   // Rouge

        // 🔹 Table
        table = new JTable();
        chargerTable();

        // 🟢 Ajouter
        btnAdd.addActionListener(e -> {
            Etudiant et = new Etudiant();
            et.setNom(txtNom.getText());
            et.setPrenom(txtPrenom.getText());
            et.setEmail(txtEmail.getText());
            et.setClasse(txtClasse.getText());
            dao.ajouter(et);
            chargerTable();
            viderChamps();
        });

        // ✏️ Modifier
        btnUpdate.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row != -1) {
                Etudiant et = new Etudiant();
                et.setIdEtud((int) table.getValueAt(row, 0));
                et.setNom(txtNom.getText());
                et.setPrenom(txtPrenom.getText());
                et.setEmail(txtEmail.getText());
                et.setClasse(txtClasse.getText());
                dao.modifier(et);
                chargerTable();
                viderChamps();
            } else {
                JOptionPane.showMessageDialog(this,
                        "Veuillez sélectionner un étudiant",
                        "Attention", JOptionPane.WARNING_MESSAGE);
            }
        });

        // ❌ Supprimer
        btnDelete.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row != -1) {
                int id = (int) table.getValueAt(row, 0);
                dao.supprimer(id);
                chargerTable();
                viderChamps();
            }
        });

        // 🔹 Remplir champs quand on clique sur la table
        table.getSelectionModel().addListSelectionListener(e -> {
            int row = table.getSelectedRow();
            if (row != -1) {
                txtNom.setText(table.getValueAt(row, 1).toString());
                txtPrenom.setText(table.getValueAt(row, 2).toString());
                txtEmail.setText(table.getValueAt(row, 3).toString());
                txtClasse.setText(table.getValueAt(row, 4).toString());
            }
        });

        // 🔹 Panel formulaire
        JPanel form = new JPanel(new GridLayout(3,4,10,10));
        form.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        form.setBackground(Color.WHITE);

        form.add(new JLabel("Nom"));
        form.add(txtNom);
        form.add(new JLabel("Prénom"));
        form.add(txtPrenom);
        form.add(new JLabel("Email"));
        form.add(txtEmail);
        form.add(new JLabel("Classe"));
        form.add(txtClasse);
        form.add(btnAdd);
        form.add(btnUpdate);
        form.add(btnDelete);

        add(form, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);
    }

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
                new Object[]{"ID", "Nom", "Prénom", "Email", "Classe"}, 0
        );
        for (Etudiant e : dao.lister()) {
            model.addRow(new Object[]{
                    e.getIdEtud(),
                    e.getNom(),
                    e.getPrenom(),
                    e.getEmail(),
                    e.getClasse()
            });
        }
        table.setModel(model);
        table.setRowHeight(26);
        table.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        table.getTableHeader().setBackground(new Color(30,136,229));
        table.getTableHeader().setForeground(Color.WHITE);
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
    }

    private void viderChamps() {
        txtNom.setText("");
        txtPrenom.setText("");
        txtEmail.setText("");
        txtClasse.setText("");
        table.clearSelection();
    }

}
