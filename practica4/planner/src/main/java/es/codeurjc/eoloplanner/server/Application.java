/*
 * Copyright 2002-2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package es.codeurjc.eoloplanner.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import es.codeurjc.eoloplanner.server.model.EoloPlant;
import es.codeurjc.eoloplanner.server.service.EoloPlantCreatorService;

import java.util.concurrent.ExecutionException;
import java.util.function.Consumer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableAsync
public class Application {

	@Autowired
	private EoloPlantCreatorService eoloPlantCreator;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	
	@Bean
	public Consumer<EoloPlant> createconsumer() {
		return eoloPlant -> {
			System.out.println("Create: " + eoloPlant.getCity());
			try {
				eoloPlantCreator.createEoloPlant(eoloPlant);
			} catch (ExecutionException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
	}

}
