package village.farmer.configuration;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
@Configuration
//@SecurityScheme(type = SecuritySchemeType.APIKEY, name = "Authorization", in = SecuritySchemeIn.HEADER)
public class SwaggerConfigurations {
    @Bean
    public OpenAPI publicApi() {
        return new OpenAPI()
                .servers(new ArrayList<Server>() {{
                    add(new Server().url("http://localhost:9000"));
                }})
                .paths(null)
//                .addSecurityItem(new SecurityRequirement().addList("Authorization"))
                .info(new Info()
                        .title("Farmer API")
                        .description("Farmer API Documentation for Village Farmer Project by Village Developer Team")
                        .version("1.0.0"));

    }
}
