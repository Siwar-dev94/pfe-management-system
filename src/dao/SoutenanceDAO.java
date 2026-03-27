/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import model.Soutenance;
import util.ConnexionJava;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author User
 */
public class SoutenanceDAO {
       private final Connection connection;

    public SoutenanceDAO() {
        connection = ConnexionJava.getConnection();
    }

    // ➕ Programmer une soutenance
    public void programmerSoutenance(Soutenance s) {

        String sql = "INSERT INTO soutenance (date_sout, salle, note, id_pfe) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setDate(1, s.getDateSout());
            ps.setString(2, s.getSalle());
            ps.setDouble(3, s.getNote());
            ps.setInt(4, s.getIdPfe());
            ps.executeUpdate();

            // changer état du PFE
            new PFEDAO().changerEtat(s.getIdPfe(), "Soutenu");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 📋 Lister soutenances (pour JTable)
public List<Object[]> listerSoutenances() {

    List<Object[]> liste = new ArrayList<>();

    String sql =
        "SELECT s.id_sout, s.date_sout, s.salle, s.note, " +
        "p.titre, e.nom_etud, e.prenom_etud " +
        "FROM soutenance s " +
        "JOIN pfe p ON s.id_pfe = p.id_pfe " +
        "JOIN etudiant e ON p.id_etud = e.id_etud";

    try (Statement st = connection.createStatement();
         ResultSet rs = st.executeQuery(sql)) {

        while (rs.next()) {
            liste.add(new Object[]{
                rs.getInt("id_sout"),
                rs.getDate("date_sout"),
                rs.getString("salle"),
                rs.getDouble("note"),
                rs.getString("nom_etud") + " " + rs.getString("prenom_etud"),
                rs.getString("titre")
            });
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return liste;
}

}
