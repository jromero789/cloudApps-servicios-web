package es.codeurjc.mca.practica_1_pruebas_ordinaria.user; 

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static io.restassured.path.json.JsonPath.from;



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
    public void createUserCustomer() throws Exception {
        createUser("Customer");
    }

    @Test
    public void createUserOrganizer() throws Exception {
        createUser("Organizer");
    }

    @Test
    public void deleteUserCustomer() throws Exception {

        int id = createUser("Customer");

        given().
            auth().
                basic("admin", "pass").
		when().
			delete("/api/users/{id}", id).
		then().
			statusCode(204);
    }

    @Test
    public void deleteUserOrganizer() throws Exception {

        int id = createUser("Organizer");

        given().
            auth().
                basic("admin", "pass").
		when().
			delete("/api/users/{id}", id).
		then().
			statusCode(204);
    }


    private int createUser(String type) throws JSONException{
        JSONObject body = new JSONObject();
		body.put("name", "User0");
        body.put("email", "user0@a.com");
        body.put("password", "pass");

        Response response = 
            given().
                queryParam("type", type).
                contentType("application/json").
                body(body.toString()).
                auth().
                    basic("Michel", "pass").
            when().
                post("/api/users/").
            then().
                statusCode(201).
                extract().response();
		
		return from(response.getBody().asString()).get("id");
    }
}