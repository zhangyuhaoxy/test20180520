package xebiaTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.yuhao.Instruction;
import com.yuhao.Lawn;
import com.yuhao.Mower;
import com.yuhao.OrientationEnum;
import com.yuhao.xebiaApp;

public class testUnit {

	@Test
	public void test1() {
		assertEquals(
				xebiaApp.getResult(new Instruction(new Mower(1, 2, OrientationEnum.N), "GAGAGAGAA"), new Lawn(5, 5)),
				new Mower(1, 3, OrientationEnum.N));
		assertEquals(
				xebiaApp.getResult(new Instruction(new Mower(3, 3, OrientationEnum.E), "AADAADADDA"), new Lawn(5, 5)),
				new Mower(5, 1, OrientationEnum.E));
	}
}
