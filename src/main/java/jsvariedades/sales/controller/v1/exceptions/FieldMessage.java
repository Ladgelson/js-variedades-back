package jsvariedades.sales.controller.v1.exceptions;

import java.io.Serializable;


public class FieldMessage implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String fieldName;
	private String msg;

	public FieldMessage(String fieldName, String msg) {
		this.fieldName = fieldName;
		this.msg = msg;
	}

	public FieldMessage() {
	}

	public String getFieldName() {
		return fieldName;
	}

	public FieldMessage setFieldName(String fieldName) {
		this.fieldName = fieldName;
		return this;
	}

	public String getMsg() {
		return msg;
	}

	public FieldMessage setMsg(String msg) {
		this.msg = msg;
		return this;
	}
}
