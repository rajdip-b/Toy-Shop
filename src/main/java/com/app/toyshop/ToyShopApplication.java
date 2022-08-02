package com.app.toyshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.app.toyshop.entity.Toy;
import com.app.toyshop.service.ToyService;

@SpringBootApplication
public class ToyShopApplication {

	@Autowired
	private ToyService toyService;

	public static void main(String[] args) {
		SpringApplication.run(ToyShopApplication.class, args);
	}

	@Bean
	public void createDummyData() {
		Toy toy1 = new Toy(null, "Doll", 23.56);
		Toy toy2 = new Toy(null, "Talking Tom", 74.62);
		Toy toy3 = new Toy(null, "Cycle", 145.56);
		Toy toy4 = new Toy(null, "Drawing Board", 89.51);
		Toy toy5 = new Toy(null, "Skipping Rope", 123.56);
		Toy toy6 = new Toy(null, "Yo-yo", 26.51);

		toyService.createToy(toy1);
		toyService.createToy(toy2);
		toyService.createToy(toy3);
		toyService.createToy(toy4);
		toyService.createToy(toy5);
		toyService.createToy(toy6);
	}

}
