package com.voidmainworld.plutus.vo;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class BaseResponseVO implements Serializable {

	private static final long	serialVersionUID	= -1508757406355302060L;

	private boolean				success;
	private int					code;
	private DataVOI				data;
	private ErrorVO				error;

	public BaseResponseVO(boolean success, int code, DataVOI data) {
		super();
		this.success = success;
		this.code = code;
		this.data = data;
	}

	public BaseResponseVO(boolean success, int code, ErrorVO error) {
		super();
		this.success = success;
		this.code = code;
		this.error = error;
	}

	public BaseResponseVO(DataVOI data) {
		this(true, 200, data);
	}

	public BaseResponseVO(ErrorVO error) {
		this(false, 500, error);
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public DataVOI getData() {
		return data;
	}

	public void setData(DataVOI data) {
		this.error = null;
		this.data = data;
	}

	public ErrorVO getError() {
		return error;
	}

	public void setError(ErrorVO error) {
		this.data = null;
		this.error = error;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder
				.append("BaseResponseVO [success=")
				.append(success)
				.append(", code=")
				.append(code)
				.append(", data=")
				.append(data)
				.append(", error=")
				.append(error)
				.append("]");
		return builder.toString();
	}

}
