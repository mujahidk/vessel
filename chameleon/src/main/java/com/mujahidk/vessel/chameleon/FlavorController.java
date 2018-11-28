package com.mujahidk.vessel.chameleon;

import javax.script.ScriptException;
import javax.script.SimpleBindings;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mujahidk.vessel.chameleon.service.GroovyEngine;

@Controller
@RequestMapping(value = { "/flavors/{id}", "/flavors/{id}/*" })
public class FlavorController {

	private final static Logger logger = LoggerFactory
			.getLogger(FlavorController.class);
	private final GroovyEngine engine;

	@Autowired
	public FlavorController(GroovyEngine engine) {
		this.engine = engine;
	}

	@GetMapping
	public ResponseEntity<String> httpGet(@PathVariable("id") String id) {
		ResponseEntity<String> response;
		try {
			final String script = "return \"Http Get Request for [id: ${requestId}]\"";

			SimpleBindings bindings = new SimpleBindings();
			bindings.put("requestId", id);

			Object result = engine.evaluate(script, bindings);
			String responseText = result == null ? "nothing got done"
					: result.toString();

			response = ResponseEntity.ok(responseText);
		} catch (ScriptException ex) {
			logger.error("Error processing the get request [id: {}].", id, ex);

			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("There was an exception processing your requst.");
		}

		return response;
	}

	@RequestMapping(method = { RequestMethod.POST, RequestMethod.PUT })
	public ResponseEntity<String> httpPostPut(@PathVariable("id") String id,
			@RequestBody String body) {
		return httpGet(id);
	}
}
