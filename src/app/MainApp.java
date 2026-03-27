/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import ui.MenuPrincipalFrame;
/**
 *
 * @author User
 */
public class MainApp {
    
   public static void main(String[] args) {
       
       try {
    UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
} catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
}

       
        new MenuPrincipalFrame().setVisible(true);
    }
   
 

}
