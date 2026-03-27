/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;
import dao.*;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author User
 */
public class AccueilPanel extends JPanel {
      public AccueilPanel() {
        setLayout(new BorderLayout());
        setOpaque(false);

        // Carte centrale
        JPanel card = new JPanel();
        card.setBackground(Color.WHITE);
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));

        JLabel title = new JLabel("Bienvenue");
        title.setFont(new Font("Segoe UI", Font.BOLD, 32));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subtitle = new JLabel("Application de gestion des Projets de Fin d'Étude");
        subtitle.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        subtitle.setForeground(Color.GRAY);
        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        card.add(title);
        card.add(Box.createVerticalStrut(10));
        card.add(subtitle);
        card.add(Box.createVerticalStrut(30));

        // ⭐ AJOUT DES STATS ICI
        card.add(statsPanel());

        add(card, BorderLayout.CENTER);
    }

    // ====== 👉 COLLE TON CODE ICI 👇 ======

    private JPanel statsPanel() {
        JPanel panel = new JPanel(new GridLayout(1, 4, 20, 0));
        panel.setOpaque(false);
       EtudiantDAO etDAO = new EtudiantDAO();
EncadreurDAO enDAO = new EncadreurDAO();
PFEDAO pfeDAO = new PFEDAO();
SoutenanceDAO soutDAO = new SoutenanceDAO();

panel.add(statCard("Étudiants",
        String.valueOf(etDAO.countEtudiants()),
        new Color(59,130,246)));

panel.add(statCard("Encadreurs",
        String.valueOf(enDAO.countEncadreurs()),
        new Color(16,185,129)));

panel.add(statCard("PFE",
        String.valueOf(pfeDAO.countPFE()),
        new Color(139,92,246)));

panel.add(statCard("Soutenances",
        String.valueOf(soutDAO.countSoutenances()),
        new Color(245,158,11)));


        return panel;
    }

    private JPanel statCard(String title, String value, Color color) {
        JPanel card = new JPanel();
        card.setBackground(Color.WHITE);
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel lblValue = new JLabel(value);
        lblValue.setFont(new Font("Segoe UI", Font.BOLD, 28));
        lblValue.setForeground(color);

        JLabel lblTitle = new JLabel(title);
        lblTitle.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblTitle.setForeground(Color.GRAY);

        card.add(lblValue);
        card.add(lblTitle);
        return card;
    }
}
