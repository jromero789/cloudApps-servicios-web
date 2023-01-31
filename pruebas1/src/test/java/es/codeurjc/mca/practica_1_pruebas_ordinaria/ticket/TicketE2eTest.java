package es.codeurjc.mca.practica_1_pruebas_ordinaria.ticket; 

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.path.json.JsonPath.from;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


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

		int id = createEventAndGetId();

        given().
            queryParam("eventId", id).
            auth().
                basic("Michel", "pass").
        when().
            post("/api/tickets/" ).
        then().
            statusCode(201).
            body("event.current_capacity", equalTo(1));
		
    }

    @Test
    public void deleteTicket() throws Exception {

        int id = createEventAndGetId();

        // Create
        Response response = 
            given().
                queryParam("eventId", id).
                auth().
                    basic("Michel", "pass").
            when().
                post("/api/tickets/" ).
            then().
                statusCode(201).
                body("event.current_capacity", equalTo(1)).
                extract().response();
		
		int idTicket = from(response.getBody().asString()).get("id");

        // Delete
        given().
            auth().
                basic("Michel", "pass").
        when().
            delete("/api/tickets/{id}", idTicket).
        then().
            statusCode(200);
            
    }


    private int createEventAndGetId() throws JSONException{
        
        JSONObject body = new JSONObject();

		body.put("name", "Evento0");
		body.put("max_capacity", 10);
        
        Response response = 
            given().
                contentType("application/json").
                body(body.toString()).
                auth().
                    basic("Patxi", "pass").
            when().
                post("/api/events/").
            then().
                statusCode(201).
                extract().response();
		
		return from(response.getBody().asString()).get("id");
    }

}