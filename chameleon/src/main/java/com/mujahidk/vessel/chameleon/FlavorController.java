package com.mujahidk.vessel.chameleon;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = { "/flavors/{id}", "/flavors/{id}/*" })
public class FlavorController {

	@GetMapping
	public ResponseEntity<String> httpGet(@PathVariable("id") String id) {
		return ResponseEntity.ok("response entity " + id);
	}

	@RequestMapping(method = { RequestMethod.POST, RequestMethod.PUT })
	public ResponseEntity<String> httpPostPut(@PathVariable("id") String id,
			@RequestBody String body) {
		return ResponseEntity.ok("response entity " + id);
	}
}
