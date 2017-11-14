package h4c.plantlife;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class PlantLifeApplication {

	@Autowired
	public void setupMapper(ObjectMapper mapper) {
		mapper.setSerializationInclusion(Include.NON_NULL);
	}

	public static void main(String[] args) {
		SpringApplication.run(PlantLifeApplication.class, args);
	}
}
