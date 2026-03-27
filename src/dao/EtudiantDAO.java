/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import model.Etudiant;
import util.ConnexionJava;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author User
 */
public class EtudiantDAO {
      private final Connection connection;

    public EtudiantDAO() {
        connection = ConnexionJava.getConnection();
    }

    // 1️⃣ Ajouter un étudiant
    public void ajouter(Etudiant e) {
        String sql = "INSERT INTO etudiant (nom_etud, prenom_etud, email_etud, classe) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, e.getNom());
            ps.setString(2, e.getPrenom());
            ps.setString(3, e.getEmail());
            ps.setString(4, e.getClasse());

            ps.executeUpdate();
            System.out.println("Étudiant ajouté avec succès ✅");

        } catch (SQLException ex) {
        }
    }

    // 2️⃣ Modifier un étudiant
    public void modifier(Etudiant e) {
        String sql = "UPDATE etudiant SET nom_etud=?, prenom_etud=?, email_etud=?, classe=? WHERE id_etud=?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, e.getNom());
            ps.setString(2, e.getPrenom());
            ps.setString(3, e.getEmail());
            ps.setString(4, e.getClasse());
            ps.setInt(5, e.getIdEtud());

            ps.executeUpdate();
            System.out.println("Étudiant modifié avec succès ✏️");

        } catch (SQLException ex) {
        }
    }

    // 3️⃣ Supprimer un étudiant
    public void supprimer(int idEtudiant) {
        String sql = "DELETE FROM etudiant WHERE id_etud=?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, idEtudiant);
            ps.executeUpdate();
            System.out.println("Étudiant supprimé avec succès ❌");

        } catch (SQLException ex) {
        }
    }

    // 4️⃣ Lister tous les étudiants
    public List<Etudiant> lister() {
        List<Etudiant> liste = new ArrayList<>();
        String sql = "SELECT * FROM etudiant";

        try (Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Etudiant e = new Etudiant();
                e.setIdEtud(rs.getInt("id_etud"));
                e.setNom(rs.getString("nom_etud"));
                e.setPrenom(rs.getString("prenom_etud"));
                e.setEmail(rs.getString("email_etud"));
                e.setClasse(rs.getString("classe"));

                liste.add(e);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return liste;
    }
}
