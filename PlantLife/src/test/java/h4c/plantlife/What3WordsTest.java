package h4c.plantlife;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

public class What3WordsTest {

	@Test
	public void test() throws IOException {
		List<String> res = What3Words.w3w(51.1758057, 10.4541194);
		for (String string : res) {
			System.out.println(string);
		}
	}

}
