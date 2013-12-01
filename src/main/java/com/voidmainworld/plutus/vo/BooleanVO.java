package com.voidmainworld.plutus.vo;

public class BooleanVO implements DataVOI {

	private static final long		serialVersionUID	= -3306537902519573164L;
	public static final BooleanVO	TRUE				= new BooleanVO(true);
	public static final BooleanVO	FALSE				= new BooleanVO(false);

	private boolean					check;

	private BooleanVO(boolean check) {
		super();
		this.check = check;
	}

	public boolean isCheck() {
		return check;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BooleanVO [check=").append(check).append("]");
		return builder.toString();
	}

}
