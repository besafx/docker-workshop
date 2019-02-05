package com.flairstech.app;

import static org.junit.Assert.assertEquals;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MainTests {

	private final static Logger LOG = LoggerFactory.getLogger(MainTests.class);

	@Autowired
	private MockMvc mvc;

	@Test
	@Transactional
	public void testIFCountryExist() throws Exception {
		LOG.info("TESTING IF COUNTRY EXIST");
		MvcResult mvcResult = mvc
				.perform(MockMvcRequestBuilders.get("/AFG")
				.accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();
		
		LOG.info(mvcResult.getResponse().getContentAsString());

		int status = mvcResult.getResponse().getStatus();
		
		LOG.info("Status:" + status);
		
		assertEquals(200, status);
	}
	
	@Test
	@Transactional
	public void testIFCountryNotExist() throws Exception {
		LOG.info("TESTING IF COUNTRY NOT EXIST");
		MvcResult mvcResult = mvc
				.perform(MockMvcRequestBuilders.get("/DUMY")
				.accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();
		
		LOG.info(mvcResult.getResponse().getContentAsString());

		int status = mvcResult.getResponse().getStatus();
		
		LOG.info("Status:" + status);
		
		assertEquals(500, status);
	}

}
