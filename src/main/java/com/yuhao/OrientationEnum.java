package com.yuhao;

public enum OrientationEnum {
	N("N"), E("E"), S("S"), W("W");
	private String name;
	private static OrientationEnum[] vals = values();

	private OrientationEnum(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public OrientationEnum next() {
		return vals[(this.ordinal() + 1) % vals.length];
	}

	public OrientationEnum previous() {
		return vals[(this.ordinal() + vals.length - 2) % vals.length];
	}

}
