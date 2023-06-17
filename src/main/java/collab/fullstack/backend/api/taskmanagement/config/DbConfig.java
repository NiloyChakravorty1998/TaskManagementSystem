package collab.fullstack.backend.api.taskmanagement.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class DbConfig {
        @Value("${spring.datasource.url}")
        private String dbUrl;

        @Value("${spring.datasource.username}")
        private String dbUsername;

        @Value("${spring.datasource.password}")
        private String dbPassword;

        @Value("${spring.datasource.driver-class-name}")
        private String dbDriverClassName;

        @Primary
        @Bean
        public  Connection getConnection() throws SQLException {
            System.out.println("Inside getConnection method for :" +dbUrl);
            try {
                Class.forName(dbDriverClassName);
                return DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            return null;
        }
    }


