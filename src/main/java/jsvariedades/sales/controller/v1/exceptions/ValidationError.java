package jsvariedades.sales.controller.v1.exceptions;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError{
	
	private List<FieldMessage> erros = new ArrayList<>();

	public ValidationError(Integer status, String msg, LocalDateTime timeStamp) {
		super(status, msg, timeStamp);
	}
	
	public void addError(String field, String name) {
		erros.add(new FieldMessage(field,name));
	}

	public List<FieldMessage> getErros() {
		return erros;
	}
}
