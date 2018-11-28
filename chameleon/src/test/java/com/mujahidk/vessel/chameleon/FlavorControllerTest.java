package com.mujahidk.vessel.chameleon;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class FlavorControllerTest {

	@Autowired
	private MockMvc mvc;

	@Test
	public void testHttpGet() throws Exception {
		mvc.perform(get("/flavors/something").contentType("text/html"))
				.andExpect(status().isOk())
				.andExpect(content().contentType("text/plain;charset=UTF-8"))
				.andExpect(content().string("Http Get Request for [id: something]"));
	}

	@Test
	public void testHttpPostPut() throws Exception {
		testHttpMethod(post("/flavors/something"));
		testHttpMethod(put("/flavors/something/plus"));
	}

	private void testHttpMethod(MockHttpServletRequestBuilder request) throws Exception {
		mvc.perform(request.content("post and put body").contentType("text/plain"))
				.andExpect(status().isOk())
				.andExpect(content().contentType("text/plain;charset=UTF-8"))
				.andExpect(content().string("Http Get Request for [id: something]"));
	}
}
