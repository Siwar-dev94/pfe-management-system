/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import model.Soutenance;
import java.sql.Date;

/**
 *
 * @author User
 */
public class TestSoutenanceDAO {
   
   public static void main(String[] args) {

        SoutenanceDAO dao = new SoutenanceDAO();

        // Test ajout
        Soutenance s = new Soutenance();
        s.setDateSout(Date.valueOf("2025-07-15"));
        s.setSalle("Salle A12");
        s.setNote(14.5);
        s.setIdPfe(3);

        dao.programmerSoutenance(s);

        // Test listing
        System.out.println("📋 Liste des soutenances :");
        for (Object[] o : dao.listerSoutenances()) {
            System.out.println(
                o[0] + " | " + o[1] + " | " + o[2] +
                " | Note: " + o[3] +
                " | Étudiant: " + o[4] +
                " | PFE: " + o[5]
            );
        }
    }
}
