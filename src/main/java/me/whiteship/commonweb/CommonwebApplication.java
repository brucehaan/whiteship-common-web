package me.whiteship.commonweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "accountAuditAware")
public class CommonwebApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommonwebApplication.class, args);
    }

}
