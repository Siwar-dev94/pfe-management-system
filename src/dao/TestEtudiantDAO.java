/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import model.Etudiant;

/**
 *
 * @author User
 */
public class TestEtudiantDAO {
      public static void main(String[] args) {

        EtudiantDAO dao = new EtudiantDAO();

        // ➕ Ajouter
        Etudiant e = new Etudiant();
        e.setNom("Sami");
        e.setPrenom("Ben Hassen");
        e.setEmail("ali@gmail.com");
        e.setClasse("3INFO");

        dao.ajouter(e);

        // 📋 Lister
        System.out.println("Liste des étudiants :");
        for (Etudiant et : dao.lister()) {
            System.out.println(et.getIdEtud() + " - " + et.getNom());
        }
    }
}
