package com.yuhao;

public class Instruction {
	private Mower mower;
	private String instruction;

	public Instruction() {
		super();
	}

	public Instruction(Mower mower, String instruction) {
		super();
		this.mower = mower;
		this.instruction = instruction;
	}

	public Mower getMower() {
		return mower;
	}

	public void setMower(Mower mower) {
		this.mower = mower;
	}

	public String getInstruction() {
		return instruction;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

}
