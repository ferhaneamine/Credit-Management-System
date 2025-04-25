package ProjetIng2;



public class validerClient {
	public  static void validerNomSoc (String NomSoc) throws InvalidClientException {
		if (!NomSoc.matches("[A-Za-zÀ-ÿ\\s]+")) {
			throw new InvalidClientException("Le nom ne doit pas contenir de chiffre");
			
		}
	}
	
	
	
public  static void validerEmail (String email) throws InvalidClientException {
		 if (!email.matches("^[\\w.-]+@[\\w.-]+\\.\\w+$")) {
			throw new InvalidClientException("L'Email est invalide!");
			
	}
}
	
	
	public  static void validerNumeroTel (String numeroTel) throws InvalidClientException {
		if (!numeroTel.matches("\\d{10,15}")) {
			throw new InvalidClientException("Le numero de telephone est interdit");
			
		}
	}

}
