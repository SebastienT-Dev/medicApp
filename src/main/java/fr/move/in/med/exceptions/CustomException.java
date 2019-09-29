package fr.move.in.med.exceptions;

public class CustomException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 162477281563171685L;
	
	private String message;
	
	private String codeError;

	public CustomException(String message, String codeError) {
		super(message);
		this.message = message;
		this.codeError = codeError;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCodeError() {
		return codeError;
	}

	public void setCodeError(String codeError) {
		this.codeError = codeError;
	}

}
