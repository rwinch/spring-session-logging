/*
 * Copyright 2002-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package demo;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SessionController {
	private final Logger LOGGER = LoggerFactory.getLogger(getClass());

	@RequestMapping("/")
	public String hello() {

		LOGGER.debug("hi debug");
		return "Hello\n";
	}

	@RequestMapping("/logging")
	public String logging(@RequestParam(defaultValue="false") boolean enable, HttpSession session) {
		if(enable) {
			session.setAttribute(LoggingKey.LOGGING_KEY, "true");
		} else {
			session.removeAttribute(LoggingKey.LOGGING_KEY);
		}
		return enable + "\n";
	}
}