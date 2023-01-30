package es.codeurjc.mca.practica_1_pruebas_ordinaria.user; 

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserE2eTest {

    @LocalServerPort
    int port;
    
    @BeforeEach
        public void setUp() {
        RestAssured.port = port;
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.baseURI = "https://localhost:"+port;
    }

    @Test
    public void createUser() throws Exception {
        given().
			contentType("application/json").
			body("{\"name\":\"nameOrganizer\" }").
            auth().
                basic("Patxi", "pass").
		when().
			post("/api/users/").
		then().
			statusCode(201);
    
        // TODO: Find why BAD_REQUEST. Check create organizer or client
    }
    
    @Test
    public void deleteUser() throws Exception {

        given().
			contentType("application/json").
			body("{\"name\":\"nameOrganizer\" }").
            auth().
                basic("Patxi", "pass").
		when().
			delete("/api/users/{id}", 1L).
		then().
			statusCode(201);
        // TODO: Can't find 1L. Check delete organizer or client
    }
}