/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import util.ConnexionJava;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author User
 */
public class PFEDAO {
    private final Connection connection;

    public PFEDAO() {
        connection = ConnexionJava.getConnection();
    }

    // ➕ Ajouter PFE + récupérer ID
    public int ajouterPFE(String titre, String description, int idEtud) {

        int idPfe = -1;
        String sql = "INSERT INTO pfe (titre, description, etat, id_etud) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps =
                     connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, titre);
            ps.setString(2, description);
            ps.setString(3, "En cours");
            ps.setInt(4, idEtud);
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) idPfe = rs.getInt(1);

        } catch (SQLException e) {
        }
        return idPfe;
    }

    // 🔗 Associer encadreur
    public void ajouterEncadreur(int idPfe, int idEncad) {

        String sql = "INSERT INTO encadrement (id_pfe, id_encad) VALUES (?, ?)";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, idPfe);
            ps.setInt(2, idEncad);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }

    // ✏️ Modifier PFE
    public void modifierPFE(int idPfe, String titre, String description, int idEtud) {

        String sql = "UPDATE pfe SET titre=?, description=?, id_etud=? WHERE id_pfe=?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, titre);
            ps.setString(2, description);
            ps.setInt(3, idEtud);
            ps.setInt(4, idPfe);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }

    // ❌ Supprimer PFE
    public void supprimerPFE(int idPfe) {

        try {
            connection.prepareStatement(
                    "DELETE FROM encadrement WHERE id_pfe=" + idPfe).executeUpdate();
            connection.prepareStatement(
                    "DELETE FROM pfe WHERE id_pfe=" + idPfe).executeUpdate();
        } catch (SQLException e) {
        }
    }

    // 📋 Lister PFEs avec jointures
    public List<Object[]> listerPFEs() {

        List<Object[]> list = new ArrayList<>();

        String sql =
                "SELECT p.id_pfe, p.titre, p.etat, " +
                "e.nom_etud, e.prenom_etud, e.classe " +
                "FROM pfe p JOIN etudiant e ON p.id_etud=e.id_etud";

        try (Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new Object[]{
                        rs.getInt("id_pfe"),
                        rs.getString("titre"),
                        rs.getString("etat"),
                        rs.getString("nom_etud") + " " + rs.getString("prenom_etud"),
                        rs.getString("classe")
                });
            }

        } catch (SQLException e) {
        }
        return list;
    }
    // 🔄 Changer l’état du PFE (ex: En cours → Soutenu) car le cahier dit :Après la soutenance, le PFE doit être mis à jour
      public void changerEtat(int idPfe, String nouvelEtat) {

    String sql = "UPDATE pfe SET etat=? WHERE id_pfe=?";

    try (PreparedStatement ps = connection.prepareStatement(sql)) {
        ps.setString(1, nouvelEtat);
        ps.setInt(2, idPfe);
        ps.executeUpdate();
    } catch (SQLException e) {
    }
}

    
      
}
