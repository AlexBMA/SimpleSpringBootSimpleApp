package com.example.carservice;

import com.example.carservice.services.AuthenticationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CarRestTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testAuthentication() throws Exception {
        // Testing authentication with correct credentials
        /*this.mockMvc.perform(post("/login")
                .content("{\"username\":\"admin\", \"password\":\"admin\"}")).
                andDo(print()).andExpect(status().isOk());
        */

        //AuthenticationService.createToken("admin");

        //String token= "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTU1MTU2NTMzMH0.G6PtRYb-g3A0H6EJl80aIxWPMrpzsgIU60Vz777BULJzN1g4uRVBqw80zSPpqDxYL-IhLTMIH95qeLNAz06YUw";
        String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTU1MTU2OTc1Mn0.kdCXoU8hQ76ejriQIla70lN9kFAs6WnAUwK3OIzp7Ffm1-Wo2Mkj4eRLvznaqsiA-YguWDWmE75Br4ab2qj3VA";
        String PREFIX = "Bearer";
        token = AuthenticationService.createToken("admin");

        this.mockMvc.perform(post("/login")
                        .content("{\"username\":\"admin\", \"password\":\"admin\"}")
                        .header("Authorization",token))
                        .andDo(print()).andExpect(status().isOk());

        /*
        System.out.println("HERE AFTER FIRST TEST");
        // Testing authentication with wrong credentials
        this.mockMvc.perform(post("/login")
                .content("{\"username\":\"admin\", \"password\":\"wrongpwd\"}")).
                andDo(print()).andExpect(status().is4xxClientError());
        */
    }
}
