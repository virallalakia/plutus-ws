package com.voidmainworld.plutus.vo;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ErrorVO implements Serializable {

	private static final long	serialVersionUID	= -3306537902519573164L;

	/* client errors */
	public static final ErrorVO	ERROR400			= new ErrorVO(400, "Bad Request");
	public static final ErrorVO	ERROR401			= new ErrorVO(401, "Unauthorized");
	public static final ErrorVO	ERROR402			= new ErrorVO(402, "Payment Required");
	public static final ErrorVO	ERROR403			= new ErrorVO(403, "Forbidden");
	public static final ErrorVO	ERROR404			= new ErrorVO(404, "Not Found");

	/* server errors */
	public static final ErrorVO	ERROR500			= new ErrorVO(500, "Internal Server Error");
	public static final ErrorVO	ERROR501			= new ErrorVO(501, "Not Implemented");
	public static final ErrorVO	ERROR502			= new ErrorVO(502, "Bad Gateway");
	public static final ErrorVO	ERROR503			= new ErrorVO(503, "Service Unavailable");

	private int					code;
	private String				message;

	private ErrorVO(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ErrorVO [code=").append(code).append(", message=").append(message).append("]");
		return builder.toString();
	}

}
