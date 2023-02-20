package village.farmer;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import village.farmer.entity.Role;
import village.farmer.repository.RoleRepository;

import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class FarmerApplication implements CommandLineRunner {

	@Autowired
	RoleRepository roleRepository;

	public static void main(String[] args) {
		SpringApplication.run(FarmerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		roleRepository.saveAll(Arrays.asList(
//				new Role(UUID.randomUUID(), "admin", new Date().toInstant(),new Date().toInstant()),
//				new Role(UUID.randomUUID(), "user", new Date().toInstant(), new Date().toInstant())
//		));
	}
	@Bean
	public ModelMapper modelMapper() {

		return new ModelMapper();

	}

}
