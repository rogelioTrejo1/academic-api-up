package com.upa.academicapi;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@PropertySource("application.properties")
public class AcademicapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AcademicapiApplication.class, args);
	}

    /**
     * Generete a new conection to database on MySQL
     * @return database conection
     */
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/academic-api?serverTimezone=UTC");
        dataSource.setUsername("rogelio");
        dataSource.setPassword("matematicas_123");
        return dataSource;
    }

    /**
     * 
     * @return
     */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**/*")
                    .allowedOrigins("*")
                    .allowedMethods("GET", "POST", "PUT", "DELETE")
                    .maxAge(3600);
            }
        };
    }
}
