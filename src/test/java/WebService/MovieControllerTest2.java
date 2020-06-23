package WebService;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import WebService.controller.MovieController;

// dependency annotations used to configure test class 
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MovieControllerTest2 {

	// Arranging Setup (variables and annotations for testing)

	/*
	 * though not considered unit testing... instantiated MockMvc to mock HTTP
	 * request without running the controller on a server(researched online)
	 */
	@Autowired
	private MockMvc mockMvc;

	// Created instance of MovieController and inject Mocks into movieController
	@InjectMocks
	@Autowired
	private MovieController movieController;

	// Builds object before test are run
	@Before
	public void setup() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(movieController).build();
	}

	// Act - testing the methods in Controller class

	// testing searchByTitle in MovieController
	@Test
	public void testController() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.request(HttpMethod.GET, "/omdb/searchByTitle"))
				.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON)).andReturn();

	}

	// testing searchById in MovieController
	@Test
	public void testController2() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.request(HttpMethod.GET, "/omdb/searchById"))
				.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON)).andReturn();

		//testing assertions
		assert (movieController != null);
		assert(movieController.searchByTitle("") != null);
		assert(movieController.searchById("") != null);
	}

}
