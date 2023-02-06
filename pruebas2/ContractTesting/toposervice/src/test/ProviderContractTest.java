
import au.com.dius.pact.provider.PactVerifyProvider;
import au.com.dius.pact.provider.junit5.MessageTestTarget;
import au.com.dius.pact.provider.junit5.PactVerificationContext;
import au.com.dius.pact.provider.junitsupport.Consumer;
import au.com.dius.pact.provider.junitsupport.Provider;
import au.com.dius.pact.provider.junitsupport.loader.PactBroker;
import au.com.dius.pact.provider.spring.junit5.PactVerificationSpringProvider;
import es.codeurjc.mastercloudapps.topo.controller.TopoController;
import es.codeurjc.mastercloudapps.topo.model.City;
import es.codeurjc.mastercloudapps.topo.service.TopoService;

import com.example.pactjvmexample.provider.model.Student;
import com.example.pactjvmexample.provider.model.StudentMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;

@Provider("topo-provider")
@Consumer("planner-consumer")
@PactBroker
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ProviderContractTest {

    @InjectMocks
    private TopoController topoController;

    @Mock
    private TopoService topoService;

    @BeforeEach
    void setUp(PactVerificationContext context) {
        Mockito.reset(topoService);

        MockMvcTestTarget testTarget = new MockMvcTestTarget();
        testTarget.setControllers(topoController);
        context.setTarget(testTarget);
    }

    @TestTemplate
    @ExtendWith(PactVerificationSpringProvider.class)
    void verifyPact(PactVerificationContext context) {
        context.verifyInteraction();
    }

    @State("Topo 1 exists")
    public void topo1Exists() {
        when(topoService.findById("1")).thenReturn(Optional.of(createFakeTopo("1")));
    }

    @State("No topo exist")
    public void noTopoExist() {
        when(topoService.findAll()).thenReturn(Collections.emptyList());
    }

    private City createFakeTopo(String s) {
        Faker faker = new Faker();
        return City.builder()
                .id(s)
                .landscape(faker.landscape())
                .build();
    }
}


