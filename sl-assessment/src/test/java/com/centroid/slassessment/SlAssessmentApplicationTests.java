package com.centroid.slassessment;

import static org.assertj.core.api.Assertions.assertThat;

import com.centroid.slassessment.controller.CensusPolygonController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SlAssessmentApplicationTests {

	@Autowired private CensusPolygonController controller;

	@Test
	void contextLoads() throws Exception{
		assertThat(controller).isNotNull();
	}

}
