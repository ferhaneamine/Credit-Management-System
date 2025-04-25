package ProjetIng2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import db.DBConnexion;

public class CreanceDao {
	
	public static boolean ajouterCreance(Creance c) throws SQLException {
		String sql = " INSERT INTO client (id_creance, id_client , montantTotal , montantRestant, statut) VALUES (?,?,?,?,?) ";
		try (Connection co = DBConnexion.connect();
				PreparedStatement s = co.prepareStatement(sql)) {
			String id_creance = genererIdCreance();
			
			s.setString(1, id_creance);
			s.setString(2, c.getid_client());
			s.setDouble(3, c.getMontantTotal());
			s.setDouble(4, c.getMontantRestant());
			s.setString(2, c.getStatut());
			s.executeUpdate();
			return true;
		
			
			
		}catch (SQLException E) {
			System.out.println("Erreur d'ajout de creance"+ E.getMessage());
			return false ;
		}
	}
	
		
		 public static List<Creance> getCreancesByClient(String id_client) {
		        List<Creance> liste = new ArrayList<>();
		        String sql = "SELECT * FROM creance WHERE id_client = ?";
		        try (Connection conn = DBConnexion.connect();
		             PreparedStatement s = conn.prepareStatement(sql)) {

		            s.setString(1, id_client);
		            ResultSet rs = s.executeQuery();
		            while (rs.next()) {
		                Creance c = new Creance(
		                        rs.getString("id_creance"),
		                        rs.getString("id_client"),
		                        rs.getDouble("montantTotal"),
		                        rs.getDouble("montantRestant"),
		                        rs.getString("statut")
		                        
		                );
		               
		                liste.add(c);
		            }
		        } catch (SQLException e) {
		            System.out.println("Erreur récupération créances : " + e.getMessage());
		        }
		        return liste;
		    }
		 
		 public static List<Creance> getCreances() {
		        List<Creance> liste = new ArrayList<>();
		        String sql = "SELECT * FROM creance WHERE id_client = ?";
		        try (Connection conn = DBConnexion.connect();
		        		Statement s = conn.createStatement();

		            ResultSet rs = s.executeQuery(sql)){
		            while (rs.next()) {
		                Creance c = new Creance(
		                        rs.getString("id_creance"),
		                        rs.getString("id_client"),
		                        rs.getDouble("montantTotal"),
		                        rs.getDouble("montantRestant"),
		                        rs.getString("statut")
		                        
		                );
		                
		                liste.add(c);
		            }
		        } catch (SQLException e) {
		            System.out.println("Erreur récupération créances : " + e.getMessage());
		        }
		        return liste;
		    }
		 
		 public static boolean modifierStatutOuMontant(String id_creance, String statut, double montantRestant) {
		        String sql = "UPDATE creance SET statut = ?, montant_restant = ? WHERE id_creance = ?";
		        try (Connection conn = DBConnexion.connect();
		             PreparedStatement stmt = conn.prepareStatement(sql)) {

		            stmt.setString(1, statut);
		            stmt.setDouble(2, montantRestant);
		            stmt.setString(3, id_creance);
		            stmt.executeUpdate();
		            return true;

		        } catch (SQLException e) {
		            System.out.println("Erreur mise à jour statut/montant : " + e.getMessage());
		            return false;
		        }
		    }
		 
		 
		 public static boolean supprimerCreance(String id_creance) {
		        String sql = "DELETE FROM creance WHERE id_creance = ?";
		        try (Connection conn = DBConnexion.connect();
		             PreparedStatement stmt = conn.prepareStatement(sql)) {

		            stmt.setString(1, id_creance);
		            stmt.executeUpdate();
		            return true;

		        } catch (SQLException e) {
		            System.out.println("Erreur suppression créance : " + e.getMessage());
		            return false;
		        }
		    }
		 
	
	
	
	
	
	
	
	
	

	public static int avoirNombreCreance(String datePart) {
	    String sql = "SELECT COUNT(*) FROM creance WHERE id_creance LIKE ?";
	    try (Connection conn = DBConnexion.connect();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {

	        stmt.setString(1, "CR-" + datePart + "-%");
	        ResultSet rs = stmt.executeQuery();

	        if (rs.next()) return rs.getInt(1);

	    } catch (SQLException e) {
	        System.out.println("Erreur comptage créances : " + e.getMessage());
	    }
	    return 0;
	}
	
	
	
	
	
	
	
	
	
	public static String genererIdCreance() {
	    String datePart = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
	    int count = avoirNombreCreance(datePart) + 1;
	    String numero = String.format("%03d", count);
	    return "CR-" + datePart + "-" + numero;
	}

}
