/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.sql.Date;
/**
 *
 * @author User
 */
public class Soutenance {
         private int idSout;
    private Date dateSout;
    private String salle;
    private double note;
    private int idPfe;

    public Soutenance() {
    }

    public int getIdSout() {
        return idSout;
    }

    public void setIdSout(int idSout) {
        this.idSout = idSout;
    }

    public Date getDateSout() {
        return dateSout;
    }

    public void setDateSout(Date dateSout) {
        this.dateSout = dateSout;
    }

    public String getSalle() {
        return salle;
    }

    public void setSalle(String salle) {
        this.salle = salle;
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }

    public int getIdPfe() {
        return idPfe;
    }

    public void setIdPfe(int idPfe) {
        this.idPfe = idPfe;
    }
}
