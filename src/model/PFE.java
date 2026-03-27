/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author User
 */
public class PFE {
    
    private int idPfe;
    private String titre;
    private String description;
    private String etat;
    private Date dateSoutenance;

    // Relations
    private Etudiant etudiant;
    private List<Encadreur> encadreurs;

    public PFE() {
    }

    public PFE(int idPfe, String titre, String description, String etat, Date dateSoutenance) {
        this.idPfe = idPfe;
        this.titre = titre;
        this.description = description;
        this.etat = etat;
        this.dateSoutenance = dateSoutenance;
    }

    public int getIdPfe() {
        return idPfe;
    }

    public void setIdPfe(int idPfe) {
        this.idPfe = idPfe;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Date getDateSoutenance() {
        return dateSoutenance;
    }

    public void setDateSoutenance(Date dateSoutenance) {
        this.dateSoutenance = dateSoutenance;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public List<Encadreur> getEncadreurs() {
        return encadreurs;
    }

    public void setEncadreurs(List<Encadreur> encadreurs) {
        this.encadreurs = encadreurs;
    }
}
