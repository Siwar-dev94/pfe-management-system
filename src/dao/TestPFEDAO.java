/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author User
 */
public class TestPFEDAO {
  public static void main(String[] args) {

        PFEDAO dao = new PFEDAO();

        int idPfe = dao.ajouterPFE(
                "Plateforme de gestion des PFE",
                "Application Java Swing / MySQL",
                1
        );

        dao.ajouterEncadreur(idPfe, 1);
        dao.modifierPFE(idPfe, "PFE Modifié", "Description modifiée", 1);

        System.out.println("Liste des PFEs :");
        for (Object[] o : dao.listerPFEs()) {
            System.out.println(o[0] + " | " + o[1] + " | " + o[2]);
        }
    }   



}
