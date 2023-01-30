package es.codeurjc.mca.practica_1_pruebas_ordinaria.event; 

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EventE2eTest {

    @LocalServerPort
    int port;
    
    @BeforeEach
        public void setUp() {
        RestAssured.port = port;
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.baseURI = "https://localhost:"+port;
    }

    @Test
    public void createEvent() throws Exception {
            
        given().
			contentType("application/json").
			body("{\"description\":\"des0\",\"name\":\"name0\" }").
            auth().
                basic("Patxi", "pass").
		when().
			post("/api/events/").
		then().
			statusCode(201);
        
    }
}