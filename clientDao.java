package ProjetIng2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



import db.DBConnexion;


public class clientDao {
	
	public static boolean ajouterClient(Client client) throws InvalidClientException {
		
		validerClient.validerNomSoc(client.getNomSoc());
		validerClient.validerEmail(client.getEmail());
		validerClient.validerNumeroTel(client.getNumeroTel());
		
		String sql = " INSERT INTO client (idClient, nomSoc , adresse , telephone, email) VALUES (?,?,?,?,?) ";
		try (Connection c = DBConnexion.connect();
				PreparedStatement s = c.prepareStatement(sql)) {
			
			
			s.setString(1, client.getid_client());
			s.setString(2, client.getNomSoc());
			s.setString(3, client.getAdresse());
			s.setString(4, client.getNumeroTel());
			s.setString(5, client.getEmail());
			
			s.executeUpdate();
			return true ;
			
			
			
	
	}catch (SQLException E) {
		System.out.println("Erreur ajout : " + E.getMessage());
		return false;
	}
		
	

}
	public static boolean modifierClient(Client client ) throws InvalidClientException {
		
		validerClient.validerNomSoc(client.getNomSoc());
		validerClient.validerEmail(client.getEmail());
		validerClient.validerNumeroTel(client.getNumeroTel());
		
		String sql = "UPDATE client SET id_client = ?,NomSoc = ?,adresse = ?, telephone = ?, email = ?  ";
		try (Connection c = DBConnexion.connect();
				PreparedStatement s = c.prepareStatement(sql)){
			s.setString(1, client.getid_client());
			s.setString(2, client.getNomSoc());
			s.setString(3, client.getAdresse());
			s.setString(4, client.getNumeroTel());
			s.setString(5, client.getEmail());
			
			
			s.executeUpdate();
			return true ;
			
			
			
			} catch (SQLException E) {
				System.out.println("Erreur modification : "+ E.getMessage());
				return false;
			}
		
	}
	
	
	public static boolean supprimerClient (String id_client ) throws InvalidClientException {
		
		String sql = "DELETE FROM client WHERE id_client = ?";
		try (Connection c = DBConnexion.connect();
				PreparedStatement s = c.prepareStatement(sql)){
			s.setString(1, id_client);
			s.executeUpdate();
			return true ;
			
		}catch (SQLException E) {
			System.out.println("Erreur de suppression: "+ E.getMessage());
			return false;
		}
	}
	public static List<Client> getTous() {
        List<Client> liste = new ArrayList<>();
        String sql = "SELECT * FROM client";
        try (Connection conn = DBConnexion.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Client c = new Client(
                        rs.getString("id_client"),
                        rs.getString("NomSoc"),
                        rs.getString("adresse"),
                        rs.getString("telephone"),
                        rs.getString("email")
                );
                liste.add(c);
            }
        } catch (SQLException e) {
            System.out.println(" Erreur affichage : " + e.getMessage());
        }
        return liste;
    }
	
	
	
	
	

}
