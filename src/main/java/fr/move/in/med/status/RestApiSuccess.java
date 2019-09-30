package fr.move.in.med.status;

/**
 * Classe représentant une réponse REST en succés
 * 
 * @author sebastienternisien
 *
 */
public class RestApiSuccess {
	
	private String code;

	private String message;

	public RestApiSuccess() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RestApiSuccess(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
