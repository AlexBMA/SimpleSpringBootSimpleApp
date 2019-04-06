package com.example.carservice;

import com.example.carservice.controller.CarController;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarServiceApplicationTests {

	@Autowired
	private CarController controller;

	@Test
	@Ignore
	public void contextLoads() {
		assertThat(controller).isNotNull();
	}

}
