package ja.mrthor.back.ctlproject;

import ja.mrthor.back.ctlproject.configuration.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
        FileStorageProperties.class
})
public class CtlProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CtlProjectApplication.class, args);
	}

}
