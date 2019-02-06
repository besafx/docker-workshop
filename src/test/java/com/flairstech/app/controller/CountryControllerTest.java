package com.flairstech.app.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.flairstech.app.Main;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Main.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CountryControllerTest {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext wac;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	@Test
	public void testIFCountryCodeNotExist() throws Exception {
		MvcResult mvcResult = mockMvc
				.perform(MockMvcRequestBuilders.get("/")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print()).andReturn();

		assertEquals(404, mvcResult.getResponse().getStatus());
	}

	@Test
	public void testIFCountryExist() throws Exception {
		MvcResult mvcResult = mockMvc
				.perform(MockMvcRequestBuilders.get("/USA")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print()).andReturn();

		assertEquals(200, mvcResult.getResponse().getStatus());
	}

	@Test
	public void testIFCountryNotExist() throws Exception {
		MvcResult mvcResult = mockMvc
				.perform(MockMvcRequestBuilders.get("/DUMY")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print()).andReturn();

		assertEquals(500, mvcResult.getResponse().getStatus());
	}

}
