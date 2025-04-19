package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class registerAccount {
	
	public static boolean register(String username, String password) {
        String sql = "INSERT INTO admin (username, password) VALUES (?, ?)";
        try (Connection c = DBConnexion.connect();
             PreparedStatement s = c.prepareStatement(sql)) {
            s.setString(1, username);
            s.setString(2, password);
            s.executeUpdate();
            return true;
        } catch (SQLException e) {
            
            return false;
        }
    }

    public static int login(String username, String password) {
        String sql = "SELECT id_utilisateur FROM utilisateur WHERE username = ? AND mot_de_passe = ?";
        try (Connection c = DBConnexion.connect();
             PreparedStatement s = c.prepareStatement(sql)) {
            s.setString(1, username);
            s.setString(2, password);
            ResultSet rs = s.executeQuery();
            
            
            if (rs.next()) {
            	return rs.getInt("id_utilisateur");
            }
        } catch (SQLException e) {
            
            System.out.println("Erreur Login : " + e.getMessage());
        }
        return -1;
    }
	
	
	
	


}
