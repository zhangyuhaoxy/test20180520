package com.yuhao;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class xebiaApp {
	private final static Logger logger = LoggerFactory.getLogger(xebiaApp.class);

	public static void main(String[] args) throws IOException {
		InstructionFile instructionFile = new InstructionFile();
		instructionFile = readFile();
		Lawn lawn = instructionFile.getLawn();
		instructionFile.getLstInstruction().forEach(i -> {
			Mower resultMower = getResult(i, lawn);
			logger.info(resultMower.getX() + " " + resultMower.getY() + " " + resultMower.getOrientation());
		});
	}

	public static Mower getResult(Instruction i, Lawn lawn) {
		i.getInstruction().chars().forEach(c -> {
			if ('G' == c) {
				i.getMower().setOrientation(i.getMower().getOrientation().previous());
			} else if ('D' == c) {
				i.getMower().setOrientation(i.getMower().getOrientation().next());
			} else if ('A' == c) {
				if (OrientationEnum.N.equals(i.getMower().getOrientation())) {
					if (checkMowerInLawn(i.getMower().getX(), i.getMower().getY() + 1, lawn))
						i.getMower().setY(i.getMower().getY() + 1);
				} else if (OrientationEnum.S.equals(i.getMower().getOrientation())) {
					if (checkMowerInLawn(i.getMower().getX(), i.getMower().getY() - 1, lawn))
						i.getMower().setY(i.getMower().getY() - 1);
				} else if (OrientationEnum.E.equals(i.getMower().getOrientation())) {
					if (checkMowerInLawn(i.getMower().getX() + 1, i.getMower().getY(), lawn))
						i.getMower().setX(i.getMower().getX() + 1);
				} else if (OrientationEnum.W.equals(i.getMower().getOrientation())) {
					if (checkMowerInLawn(i.getMower().getX() - 1, i.getMower().getY(), lawn))
						i.getMower().setX(i.getMower().getX() - 1);
				}
			}
		});
		return i.getMower();
	}

	private static boolean checkMowerInLawn(int x, int y, Lawn lawn) {
		if ((0 <= x && x <= lawn.getLength()) && (0 <= y && y <= lawn.getWidth()))
			return true;
		return false;
	}

	private static InstructionFile readFile() throws IOException {
		InstructionFile instructionFile = new InstructionFile();

		try (BufferedReader br = new BufferedReader(
				new InputStreamReader(new FileInputStream("src/main/resources/fichier.txt")))) {
			String firstLine = br.readLine();
			if (firstLine != null) {
				String[] chars = firstLine.split(" ");
				instructionFile.setLawn(new Lawn(Integer.parseInt(chars[0]), Integer.parseInt(chars[1])));
			}
			String line = br.readLine();
			while (line != null) {
				String[] mowerChars = line.split(" ");
				Mower mower = new Mower(Integer.parseInt(mowerChars[0]), Integer.parseInt(mowerChars[1]),
						OrientationEnum.valueOf(mowerChars[2]));
				String instructionLine = br.readLine();
				if (instructionLine != null) {
					Instruction instruction = new Instruction(mower, instructionLine);
					instructionFile.getLstInstruction().add(instruction);
				}
				line = br.readLine();
			}
		}
		return instructionFile;

	}

}
