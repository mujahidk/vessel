package com.mujahidk.vessel.chameleon.service;

import static org.junit.Assert.*;

import javax.script.ScriptException;
import javax.script.SimpleBindings;

import org.junit.Test;

public class GroovyEngineTest {

	@Test
	public void testEvaluate() throws ScriptException {

		GroovyEngine engine = new GroovyEngine();
		Object result = engine.evaluate("return 'Hello'", new SimpleBindings());
		assertEquals("Groovy script result expected.", "Hello", result);
	}

}
