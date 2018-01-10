package com.pfonseca.erp.repository;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import com.github.javafaker.Faker;
import com.pfonseca.erp.domain.Contact;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class ContactRepositoryTest {

	@Autowired
	private WebApplicationContext webapp;

	private MockMvc restMvc;
	
	@Autowired
    private FilterChainProxy springSecurityFilterChain;

	@Autowired
	private ContactRepository contactRepository;

	@Before
	@Transactional
	public void setup() {
		Faker faker = new Faker();

		Contact person = new Contact();
		person.setName(faker.name().fullName());

		contactRepository.save(person);

		restMvc = MockMvcBuilders.webAppContextSetup(webapp).addFilter(springSecurityFilterChain).build();
		
	}

	@Test
	public void resourceLoads() throws Exception {
		
		SecurityContextHolder.getContext().setAuthentication(new TestingAuthenticationToken(null, null));

		ResultActions resultActions = restMvc.perform(get("/contacts/")
				.header("Authorization", "Bearer " + "aaasasasasasa")).andDo(print());

//		resultActions.andExpect(status().isOk()).andExpect(content().string("hello"));

	}

}
