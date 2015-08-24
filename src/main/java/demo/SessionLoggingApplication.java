package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;

@SpringBootApplication
public class SessionLoggingApplication {

	@Bean
	public HeaderHttpSessionStrategy headerHttpSessionStrategy() {
		return new HeaderHttpSessionStrategy();
	}

    public static void main(String[] args) {
        SpringApplication.run(SessionLoggingApplication.class, args);
    }
}
