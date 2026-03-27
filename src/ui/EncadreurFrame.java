/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;
import dao.EncadreurDAO;
import model.Encadreur;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
/**
 *
 * @author User
 */
public class EncadreurFrame extends JFrame {
      JTextField txtNom, txtPrenom, txtGrade, txtEmail;
    JTable table;
    EncadreurDAO dao = new EncadreurDAO();

    
    
   private JButton styledButton(String text, Color bg) {
        JButton btn = new JButton(text);
        btn.setBackground(bg);
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));
        return btn;
    }
   
   
   
    
    public EncadreurFrame() {

        setTitle("Gestion des Encadreurs");
        setSize(700, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(245,245,245));
        
        
        txtNom = new JTextField(10);
        txtPrenom = new JTextField(10);
        txtGrade = new JTextField(10);
        txtEmail = new JTextField(15);

       JButton btnAdd = styledButton("Ajouter", new Color(30,136,229));   // Bleu
        JButton btnUpdate = styledButton("Modifier", new Color(67,160,71)); // Vert
        JButton btnDelete = styledButton("Supprimer", new Color(229,57,53));   // Rouge

        table = new JTable();
        chargerTable();

        // ➕ Ajouter
        btnAdd.addActionListener(e -> {
            Encadreur en = new Encadreur();
            en.setNom(txtNom.getText());
            en.setPrenom(txtPrenom.getText());
            en.setGrade(txtGrade.getText());
            en.setEmail(txtEmail.getText());
            dao.ajouter(en);
            chargerTable();
            viderChamps();
        });

        // ✏ Modifier
        btnUpdate.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row != -1) {
                Encadreur en = new Encadreur();
                en.setIdEncad((int) table.getValueAt(row, 0));
                en.setNom(txtNom.getText());
                en.setPrenom(txtPrenom.getText());
                en.setGrade(txtGrade.getText());
                en.setEmail(txtEmail.getText());
                dao.modifier(en);
                chargerTable();
                viderChamps();
            } else {
                JOptionPane.showMessageDialog(this, "Sélectionnez un encadreur !");
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
            } else {
                JOptionPane.showMessageDialog(this, "Sélectionnez un encadreur !");
            }
        });

        // 📌 Sélection JTable → champs
        table.getSelectionModel().addListSelectionListener(e -> {
            int row = table.getSelectedRow();
            if (row != -1) {
                txtNom.setText(table.getValueAt(row, 1).toString());
                txtPrenom.setText(table.getValueAt(row, 2).toString());
                txtGrade.setText(table.getValueAt(row, 3).toString());
                txtEmail.setText(table.getValueAt(row, 4).toString());
            }
        });

        // 🧱 Formulaire
        JPanel form = new JPanel(new GridLayout(2, 5, 5, 5));
        form.setBackground(Color.WHITE);
        form.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        form.add(new JLabel("Nom"));
        form.add(new JLabel("Prénom"));
        form.add(new JLabel("Grade"));
        form.add(new JLabel("Email"));
        form.add(new JLabel("Actions"));

        form.add(txtNom);
        form.add(txtPrenom);
        form.add(txtGrade);
        form.add(txtEmail);

        JPanel actions = new JPanel();
        actions.add(btnAdd);
        actions.add(btnUpdate);
        actions.add(btnDelete);
        form.add(actions);

        add(form, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    // 📋 Charger JTable
    private void chargerTable() {
        DefaultTableModel model = new DefaultTableModel(
                new Object[]{"ID", "Nom", "Prénom", "Grade", "Email"}, 0);

        for (Encadreur e : dao.lister()) {
            model.addRow(new Object[]{
                    e.getIdEncad(),
                    e.getNom(),
                    e.getPrenom(),
                    e.getGrade(),
                    e.getEmail()
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
        txtGrade.setText("");
        txtEmail.setText("");
    }
    
    

}
