package h4c.plantlife;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ApiErrorHandler {
	private Logger logger = LoggerFactory.getLogger(ApiErrorHandler.class);

	@ResponseBody
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.FORBIDDEN)
	PlantLifeError forbiddenExceptionHandler(Exception ex) {
		logger.error(ex.getMessage(), ex.getMessage());
		return new PlantLifeError(ex.getMessage());
	}
}
