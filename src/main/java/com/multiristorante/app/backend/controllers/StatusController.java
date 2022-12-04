package com.multiristorante.app.backend.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {
	
	@GetMapping("/error")
	public String error() {
		return "UUPPSSS";
	}
}
