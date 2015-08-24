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

import org.slf4j.MDC;
import org.slf4j.Marker;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.turbo.TurboFilter;
import ch.qos.logback.core.spi.FilterReply;

/**
 * @author Rob Winch
 *
 */
public class MDCTurboFilter extends TurboFilter {

	/* (non-Javadoc)
	 * @see ch.qos.logback.classic.turbo.TurboFilter#decide(org.slf4j.Marker, ch.qos.logback.classic.Logger, ch.qos.logback.classic.Level, java.lang.String, java.lang.Object[], java.lang.Throwable)
	 */
	@Override
	public FilterReply decide(Marker marker, Logger logger, Level level, String format, Object[] params, Throwable t) {
		String mdcLogLevel = MDC.get(LoggingKey.LOGGING_KEY);
		if(mdcLogLevel == null) {
			return FilterReply.NEUTRAL;
		}

		Level newLevel = Level.valueOf(mdcLogLevel);
		if(level.isGreaterOrEqual(newLevel)) {
			return FilterReply.ACCEPT;
		}
		return FilterReply.NEUTRAL;
	}
}
