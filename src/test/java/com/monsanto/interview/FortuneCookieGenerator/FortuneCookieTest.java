package com.monsanto.interview.FortuneCookieGenerator;

import java.io.IOException;

import javax.servlet.ServletContext;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = FortuneCookieGeneratorApplication.class)
@WebAppConfiguration
public class FortuneCookieTest {

	@Autowired
	private WebApplicationContext wac;
	
	private MockMvc mockMvc;
	@Before
	public void setup() throws Exception {
	    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}
	
	@Test
	public void controllerContextTest() {
	    ServletContext servletContext = wac.getServletContext();
	     
	    Assert.assertNotNull(servletContext);
	    Assert.assertTrue(servletContext instanceof MockServletContext);
	    Assert.assertNotNull(wac.getBean("fortuneCookieController"));
	}
	

    @Test
    public void blockerIssueTest() throws Exception {
        final MvcResult mvcResult1 = this.mockMvc.perform(MockMvcRequestBuilders
        		.get("/generateFortuneCookie?client=Barney&company=SuperStore")).andReturn();
        final MvcResult mvcResult2 = this.mockMvc.perform(MockMvcRequestBuilders
        		.get("/generateFortuneCookie?client=Sarah&company=MegaMarket")).andReturn();
        
		ObjectMapper mapper = new ObjectMapper();
		String fcMsg1 = "",fcMsg2 = "";
		
        try {
			FortuneCookie fc1 = mapper.readValue(
					mvcResult1.getResponse().getContentAsString(), FortuneCookie.class);
			
			FortuneCookie fc2 = mapper.readValue(
					mvcResult2.getResponse().getContentAsString(), FortuneCookie.class);
					
			fcMsg1 = fc1.getMessage();
			fcMsg2 = fc2.getMessage();
			
			System.out.println("Cookie 1 message: " + fcMsg1 + "\n" +
								"Cookie 2 message: " + fcMsg2 + "\n");
			
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        Assert.assertNotEquals(fcMsg1, fcMsg2);
        
    }
	

}
