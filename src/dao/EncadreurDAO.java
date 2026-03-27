/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import model.Encadreur;
import util.ConnexionJava;
import java.sql.*;
import java.util.*;

/**
 *
 * @author User
 */
public class EncadreurDAO {
     private final Connection connection;

    public EncadreurDAO() {
        connection = ConnexionJava.getConnection();
    }

    // ➕ Ajouter
    public void ajouter(Encadreur e) {
        String sql = "INSERT INTO encad (nom_encad, prenom_encad, email_encad, grade) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, e.getNom());
            ps.setString(2, e.getPrenom());
            ps.setString(3, e.getEmail());
            ps.setString(4, e.getGrade());
            ps.executeUpdate();
            System.out.println("Encadreur ajouté avec succès ✅");
        } catch (SQLException ex) {
        }
    }

    // ✏ Modifier
    public void modifier(Encadreur e) {
        String sql = "UPDATE encad SET nom_encad=?, prenom_encad=?, email_encad=?, grade=? WHERE id_encad=?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, e.getNom());
            ps.setString(2, e.getPrenom());
            ps.setString(3, e.getEmail());
            ps.setString(4, e.getGrade());
            ps.setInt(5, e.getIdEncad());
            ps.executeUpdate();
            System.out.println("Encadreur modifié avec succès ✏");
        } catch (SQLException ex) {
        }
    }

    // ❌ Supprimer
    public void supprimer(int idEncad) {
        String sql = "DELETE FROM encad WHERE id_encad=?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, idEncad);
            ps.executeUpdate();
            System.out.println("Encadreur supprimé avec succès ❌");
        } catch (SQLException ex) {
        }
    }

    // 📋 Lister
    public List<Encadreur> lister() {
        List<Encadreur> liste = new ArrayList<>();
        String sql = "SELECT * FROM encad";

        try (Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Encadreur e = new Encadreur();
                e.setIdEncad(rs.getInt("id_encad"));
                e.setNom(rs.getString("nom_encad"));
                e.setPrenom(rs.getString("prenom_encad"));
                e.setEmail(rs.getString("email_encad"));
                e.setGrade(rs.getString("grade"));
                liste.add(e);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return liste;
    }
   }
