package es.codeurjc.mca.practica_1_pruebas_ordinaria.event;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import es.codeurjc.mca.practica_1_pruebas_ordinaria.image.LocalImageService;
import es.codeurjc.mca.practica_1_pruebas_ordinaria.user.User;
import es.codeurjc.mca.practica_1_pruebas_ordinaria.user.UserService;

@SpringBootTest
@AutoConfigureMockMvc
public class EventUnitaryTest {

	@Autowired
    private MockMvc mvc;
	
	@MockBean
	private EventRepository eventRepository;

	@MockBean
	private UserService userService;

	@MockBean
	private LocalImageService localImageService;
	
	@Test
	public void getEventsTest() throws Exception {
		 
	    List<Event> events = new ArrayList<>();
		events.add(new Event());
		events.add(new Event());
	 
	    when(eventRepository.findAll()).thenReturn(events);
		
	    mvc.perform(get("/api/events/")
	    	      .contentType(MediaType.APPLICATION_JSON))
	    	      .andExpect(status().isOk())
	    	      .andExpect(jsonPath("$", hasSize(2)));		
	}

    @Test
    @WithMockUser(username = "Patxi", password = "pass", roles = "ORGANIZER")
	public void createEventTest() throws Exception {

		Event event = new Event();
		event.setId(1L);
		event.setName("Event1");

		when(userService.getMe()).thenReturn(new User("Patxi", "francisco.gortazar@urjc.es", "pass", User.ROLE_ORGANIZER));
		when(eventRepository.save(event)).thenReturn(event);

		String eventString = new ObjectMapper().writeValueAsString(event);

		mvc.perform(MockMvcRequestBuilders
	      .post("/api/events/")
	      .content(eventString)
	      .contentType(MediaType.APPLICATION_JSON)
	      .accept(MediaType.APPLICATION_JSON))
      	  .andExpect(status().isCreated());
    }


    @Test
    @WithMockUser(username = "admin", password = "pass", roles = "ADMIN")
	public void deleteEventTest() throws Exception {

		User user = new User("admin", "admin@urjc.es", "pass", User.ROLE_ADMIN);
		
		Event event = new Event();
		event.setId(1L);
		event.setName("Event1");
		event.setCreator(user);
		event.setImage("");

		when(userService.getMe()).thenReturn(user);
		when(eventRepository.findById(1L)).thenReturn(Optional.ofNullable(event));
		doNothing().when(localImageService).deleteImage("");

		mvc.perform(delete("/api/events/{id}", 1L) )
        	.andExpect(status().isOk());
    }


}