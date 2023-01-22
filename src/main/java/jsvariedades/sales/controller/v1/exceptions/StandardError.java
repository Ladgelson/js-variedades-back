package jsvariedades.sales.controller.v1.exceptions;

import java.time.LocalDateTime;

public class StandardError {
	
	private Integer status;
	private String msg;
	private LocalDateTime timeStamp;
	
	public StandardError(Integer status, String msg, LocalDateTime timeStamp) {
		super();
		this.status = status;
		this.msg = msg;
		this.timeStamp = timeStamp;
	}

	public Integer getStatus() {
		return status;
	}

	public StandardError setStatus(Integer status) {
		this.status = status;
		return this;
	}

	public String getMsg() {
		return msg;
	}

	public StandardError setMsg(String msg) {
		this.msg = msg;
		return this;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public StandardError setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
		return this;
	}
}
