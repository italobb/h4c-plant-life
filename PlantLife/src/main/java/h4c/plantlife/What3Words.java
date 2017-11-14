package h4c.plantlife;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.IOUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import h4c.plantlife.w3w.What3WordsResponse;

public class What3Words {
	private final static String APIKEY = "VH9BH3CX";

	public static List<String> w3w(Double lat, Double lng) throws IOException {
		URL url = new URL("https://api.what3words.com/v2/reverse?coords=" + lat + "%2C" + lng + "&key=" + APIKEY
				+ "&lang=en&format=json&display=full");
		String result = IOUtils.toString(url.openStream());
		ObjectMapper mapper = new ObjectMapper();
		What3WordsResponse w3w = mapper.readValue(result, What3WordsResponse.class);

		String[] words = w3w.getWords().split("\\.", 3);
		return Arrays.asList(words);
	}
}
