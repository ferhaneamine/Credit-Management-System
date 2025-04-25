package ProjetIng2;

public class Client {
	private String id_client;
	private String NomSoc;
	private String Adresse;
	private String numeroTel;
	private String Email;
	
	public Client(String id_client,  String NomSoc , String adresse, String numeroTel, String email) {
		super();
		this.id_client = id_client;
		this.NomSoc = NomSoc;
		this.Adresse = adresse;
		this.numeroTel = numeroTel;
		this.Email = email;
	}

	public String getid_client() {
		return id_client;
	}

	public void setid_client(String id_client) {
		this.id_client = id_client;
	}

	


	public String getNomSoc() {
		return NomSoc;
	}

	public void setNomSoc(String NomSoc) {
		this.NomSoc = NomSoc;
	}

	public String getAdresse() {
		return Adresse;
	}

	public void setAdresse(String adresse) {
		Adresse = adresse;
	}

	public String getNumeroTel() {
		return numeroTel;
	}

	public void setNumeroTel(String numeroTel) {
		this.numeroTel = numeroTel;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

}
