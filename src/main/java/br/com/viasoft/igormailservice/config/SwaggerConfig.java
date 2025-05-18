package br.com.viasoft.igormailservice.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

public class SwaggerConfig {

    @Getter
    @Setter
    @Component
    @ConfigurationProperties(prefix = "api.info")
    public static class ApiInfoProperties {
        private String title;
        private String description;
        private String version;
    }

    @Configuration
    public static class ApiInfoConfig {

        private final ApiInfoProperties infoProperties;

        public ApiInfoConfig(ApiInfoProperties infoProperties) {
            this.infoProperties=infoProperties;
        }

        @Bean
        public OpenAPI customOpenAPI() {
            return new OpenAPI().info(new Info()
                    .title(infoProperties.getTitle())
                    .version(infoProperties.getVersion())
                    .description(infoProperties.getDescription()));
        }
    }
}