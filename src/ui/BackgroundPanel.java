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

   
/**
 *
 * @author User
 */
public class BackgroundPanel extends JPanel{
     private final Image image;

    public BackgroundPanel(String imagePath) {
        image = new ImageIcon(getClass().getResource(imagePath)).getImage();
        setLayout(new CardLayout());
    }

   @Override
 protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(image, 0, 0, getWidth(), getHeight(), this);

    // Overlay blanc semi-transparent
    g.setColor(new Color(255, 255, 255, 170));
    g.fillRect(0, 0, getWidth(), getHeight());
}
}

