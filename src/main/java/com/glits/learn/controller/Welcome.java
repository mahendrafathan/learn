package com.glits.learn.controller;

import java.util.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.glits.learn.dto.WelcomeResp;

@RestController
@RequestMapping("api/v1/welcome")
public class Welcome {
	List<WelcomeResp> messages = new ArrayList<>();

	@GetMapping("/getall")
	public ResponseEntity<?> sayHi() {
		WelcomeResp response = new WelcomeResp();
		response.setMessage("Selamat Datang Di Aplikasi Pertama Saya");
		response.setDeveloper("Mahendra");

		return ResponseEntity.ok().body(response);
	}

	@GetMapping("/get/{name}")
	public ResponseEntity<?> getMessageName(@PathVariable("name") String name) {
		for (WelcomeResp message : messages) {
			if (message.getDeveloper().equals(name)) {
				return ResponseEntity.ok().body(message);
			}
		}
		return ResponseEntity.ok().body("Data Tidak Ditemukan");
	}

	@PostMapping(path = "/postMessage", consumes = "application/json")
	public ResponseEntity<?> addMessage(@RequestBody WelcomeResp payload) {
		messages.add(payload);
		return ResponseEntity.ok().body(messages);
	}

}
