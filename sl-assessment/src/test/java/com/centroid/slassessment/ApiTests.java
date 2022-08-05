package com.centroid.slassessment;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Surface level unit testing for Api. Ensure status is ok.
 * Not using a mock database to insert and check calculations, not using dfw_demo in case
 * of changes.
 */
@SpringBootTest
@AutoConfigureMockMvc
public class ApiTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void pipSumpPopTest() throws Exception {
        this.mockMvc.perform(get("/api/pip/sum/pop?latitude=33.045352&longitude=-96.781508&distance=2000"))
                .andExpect(status().isOk());
    }

    @Test
    public void pipAvgIncTest() throws Exception {
        this.mockMvc.perform(get("/api/pip/avg/inc?latitude=33.045352&longitude=-96.781508&distance=2000"))
                .andExpect(status().isOk());
    }

    @Test
    public void propAreaAvgIncTest() throws Exception {
        this.mockMvc.perform(get("/api/propArea/avg/inc?latitude=33.045352&longitude=-96.781508&distance=2000"))
                .andExpect(status().isOk());
    }

    @Test
    public void propAreaSumPopTest() throws Exception {
        this.mockMvc.perform(get("/api/propArea/sum/pop?latitude=33.045352&longitude=-96.781508&distance=2000"))
                .andExpect(status().isOk());
    }


}
