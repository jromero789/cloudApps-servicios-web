package es.codeurjc.mca.practica_1_pruebas_ordinaria.ticket; 

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TicketE2eTest {

    @LocalServerPort
    int port;
    
    @BeforeEach
        public void setUp() {
        RestAssured.port = port;
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.baseURI = "https://localhost:"+port;
    }
    
    @Test
    public void createTicket() throws Exception {
        given().
			contentType("application/json").
			body("{\"id\":\"1L\" }").
            auth().
                basic("Michel", "pass").
		when().
			post("/api/tickets/" ).
		then().
			statusCode(201);

        // TODO: Find why BAD_REQUEST, Check aforo increases
    }

    @Test
    public void deleteTicket() throws Exception {

        given().
        contentType("application/json").
        body("{\"id\":\"1L\" }").
        auth().
            basic("Michel", "pass").
        when().
            delete("/api/tickets/{id}", 1L).
        then().
            statusCode(201);

        // TODO: Can't find 1L. Check aforo decreases
    }
}