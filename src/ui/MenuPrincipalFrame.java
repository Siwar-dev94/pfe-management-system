/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author User
 */
public class MenuPrincipalFrame extends JFrame{
    public MenuPrincipalFrame() {

        setTitle("Gestion des Projets de Fin d'Étude");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 🔹 Boutons
        JButton btnEtudiant = new JButton("Gestion Étudiants");
        JButton btnEncadreur = new JButton("Gestion Encadreurs");
        JButton btnPFE = new JButton("Gestion PFE");
        JButton btnSoutenance = new JButton("Gestion Soutenances");

        // 🔹 Actions
        btnEtudiant.addActionListener(e ->
                new EtudiantFrame().setVisible(true));

        btnEncadreur.addActionListener(e ->
                new EncadreurFrame().setVisible(true));

        btnPFE.addActionListener(e ->
                new EcranPFEFrame().setVisible(true));

        btnSoutenance.addActionListener(e ->
                new EcranSoutenanceFrame().setVisible(true));

        // 🔹 Layout
        setLayout(new GridLayout(2, 2, 10, 10));
        add(btnEtudiant);
        add(btnEncadreur);
        add(btnPFE);
        add(btnSoutenance);
    }
}
