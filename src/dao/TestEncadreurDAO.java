/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import model.Encadreur;


/**
 *
 * @author User
 */
public class TestEncadreurDAO {
 public static void main(String[] args) {

        EncadreurDAO dao = new EncadreurDAO();

        // ➕ AJOUTER
        Encadreur e = new Encadreur();
        e.setNom("Mohamed");
        e.setPrenom("Trabelsi");
        e.setEmail("m.trabelsi@gmail.com");
        e.setGrade("Professeur");

        dao.ajouter(e);

        // 📋 LISTER
        System.out.println("Liste des encadreurs :");
        for (Encadreur enc : dao.lister()) {
            System.out.println(enc.getIdEncad() + " - " + enc.getNom() + " " + enc.getPrenom());
        }

        // ✏ MODIFIER (exemple sur ID = 1)
        Encadreur eModif = new Encadreur();
        eModif.setIdEncad(1);
        eModif.setNom("Mohamed");
        eModif.setPrenom("Trabelsi");
        eModif.setEmail("m.trabelsi@univ.tn");
        eModif.setGrade("Maître Assistant");

        dao.modifier(eModif);

        // ❌ SUPPRIMER (exemple ID = 3)
        dao.supprimer(3);
    }
}
