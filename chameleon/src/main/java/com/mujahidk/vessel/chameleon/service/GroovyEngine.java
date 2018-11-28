package com.mujahidk.vessel.chameleon.service;

import javax.script.Bindings;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class GroovyEngine {

	private final static Logger logger = LoggerFactory
			.getLogger(GroovyEngine.class);

	private final ScriptEngine engine;
	private final boolean available;

	public GroovyEngine() {
		engine = new ScriptEngineManager().getEngineByName("groovy");
		available = (engine != null);
	}

	public Object evaluate(String script, Bindings bindings)
			throws ScriptException {
		if (isAvailable()) {
			return engine.eval(script, bindings);
		} else {
			logger.warn("Groovy scripting engine is not available.");
			return null;
		}

	}

	public boolean isAvailable() {
		return available;
	}
}
