package fr.move.in.med.exceptions;

import javax.persistence.PersistenceException;

import org.dozer.MappingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import fr.move.in.med.status.RestApiError;

@ControllerAdvice
public class HandlerException {
	
	@ExceptionHandler({PersistenceException.class})
    public final ResponseEntity<RestApiError> handleHibernateException(Exception ex, WebRequest request) {
		return new ResponseEntity<RestApiError>(new RestApiError(HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Une erreur en relation avec la base de données c'est produite"), HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
	@ExceptionHandler({MappingException.class})
    public final ResponseEntity<RestApiError> handleDozerMapperException(Exception ex, WebRequest request) {
		return new ResponseEntity<RestApiError>(new RestApiError(HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Une erreur de mapping des objets JAVA a eu lieu"), HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
	@ExceptionHandler({IllegalStateException.class})
    public final ResponseEntity<RestApiError> handleIllegal(Exception ex, WebRequest request) {
		return new ResponseEntity<RestApiError>(new RestApiError(HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Invocation ou une utilisation inapproprié d'une méthode JAVA"), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
