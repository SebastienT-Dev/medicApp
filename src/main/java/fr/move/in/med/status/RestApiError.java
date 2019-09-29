package fr.move.in.med.status;

public class RestApiError {

	private String codeError;

	private String message;

	public RestApiError() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RestApiError(String codeError, String message) {
		super();
		this.codeError = codeError;
		this.message = message;
	}

	public String getCodeError() {
		return codeError;
	}

	public void setCodeError(String codeError) {
		this.codeError = codeError;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
