package h4c.plantlife;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.collect.Ordering;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Operation;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public ApiKey apiKey() {
		return new ApiKey("x-auth-token", "x-auth-token", "header");
	}

	@Bean
	public Docket docket() {
		Ordering<Operation> operationOrdering = new Ordering<Operation>() {
			@Override
			public int compare(Operation left, Operation right) {
				return left.getPosition() - right.getPosition();
			}
		};

		return new Docket(DocumentationType.SWAGGER_2) //
				.securitySchemes(Arrays.asList(apiKey())) //
				.operationOrdering(operationOrdering) //
				.select() //
				.apis(RequestHandlerSelectors.basePackage(PlantLifeApi.class.getPackage().getName())) //
				.paths(PathSelectors.any()) //
				.build().apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()//
				.title("Plant Life API")//
				.description("Plant Life in Hask 4 Climate.")//
				.contact(new Contact("Italo Borssatto", null, "italobb@gmail.com")) //
				.build();
	}
}