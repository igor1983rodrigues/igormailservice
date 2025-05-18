package br.com.viasoft.igormailservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@RestController
public class IgorMailServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(IgorMailServiceApplication.class, args);
	}
//
//	@GetMapping("/hello")
//	public String hello(@RequestParam(value = "name", defaultValue = "Brasil") String name) {
//		return String.format("Como voc&ecirc; est&aacute;, %s?", name);
//	}

}
