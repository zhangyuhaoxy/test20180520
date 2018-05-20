package com.yuhao;

import java.util.ArrayList;
import java.util.List;

public class InstructionFile {
	private Lawn lawn;
	private List<Instruction> lstInstruction = new ArrayList<>();

	public Lawn getLawn() {
		return lawn;
	}

	public void setLawn(Lawn lawn) {
		this.lawn = lawn;
	}

	public List<Instruction> getLstInstruction() {
		return lstInstruction;
	}

	public void setLstInstruction(List<Instruction> lstInstruction) {
		this.lstInstruction = lstInstruction;
	}

}
