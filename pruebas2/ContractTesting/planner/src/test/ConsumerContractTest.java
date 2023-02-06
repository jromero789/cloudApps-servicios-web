
import au.com.dius.pact.consumer.MockServer;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import es.codeurjc.mastercloudapps.planner.models.LandscapeResponse;
import es.codeurjc.mastercloudapps.planner.service.PlannerService;

import com.example.pactjvmexample.consumer.model.Student;
import com.example.pactjvmexample.consumer.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static au.com.dius.pact.consumer.dsl.LambdaDsl.newJsonArrayMinLike;
import static au.com.dius.pact.consumer.dsl.LambdaDsl.newJsonBody;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith(PactConsumerTestExt.class)
class ConsumerContractTest {

    @Pact(consumer = "planner-consumer", provider = "topo-provider")
    public RequestResponsePact getTopo(PactDslWithProvider builder) {
        return builder.given("Get topo")
                .uponReceiving("get topo by city")
                .path("/api/topographicdetails/madrid")
                .method("GET")
                .willRespondWith()
                .status(200)
                .headers(Map.of("Content-Type", "application/json"))
                .body(newJsonBody(object -> {
                    object.stringType("id", "1");
                    object.stringType("landscape", "flat");
                }).build())
                .toPact();
    }

    @Pact(consumer = "planner-consumer", provider = "topo-provider")
    public RequestResponsePact noTopo(PactDslWithProvider builder) {
        return builder.given("City doesnt exist")
                .uponReceiving("get topo city doesnt exist")
                .path("/api/topographicdetails/madrid")
                .method("GET")
                .willRespondWith()
                .status(200)
                .headers(Map.of("Content-Type", "application/json"))
                .body("[]")
                .toPact();
    }

    @Test
    @PactTestFor(pactMethod = "getTopo")
    void getStudent_whenStudentExist(MockServer mockServer) {
        LandscapeResponse expected = Student.builder()
                .id("1")
                .landscape("flat")
                .build();

        RestTemplate restTemplate = new RestTemplateBuilder().rootUri(mockServer.getUrl()).build();
        LandscapeResponse landscape = new PlannerService(restTemplate);

        assertEquals(expected, landscape);
    }

    @Test
    @PactTestFor(pactMethod = "noTopo")
    void getStudents_whenNoStudentsExist(MockServer mockServer) {
        RestTemplate restTemplate = new RestTemplateBuilder().rootUri(mockServer.getUrl()).build();
        List<LandscapeResponse> landscapeResponses = new PlannerService(restTemplate);

        assertEquals(Collections.emptyList(), landscapeResponses);
    }

}
