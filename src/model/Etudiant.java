/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author User
 */
public class Etudiant {
    private int idEtud;
    private String nom;
    private String prenom;
    private String email;
    private String classe;

    // getters & setters
    public int getIdEtud() {
        return idEtud;
    }

    public void setIdEtud(int idEtud) {
        this.idEtud = idEtud;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }
    @Override
    
    public String toString() {
    return nom + " " + prenom;
}

}
