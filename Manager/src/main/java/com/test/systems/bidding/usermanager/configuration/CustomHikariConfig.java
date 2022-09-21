package com.test.systems.bidding.usermanager.configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

//@Configuration
public class CustomHikariConfig extends HikariConfig {

    //@Bean
    //@ConfigurationProperties(prefix = "spring.datasource.hikari")
    public DataSource dataSource() {
        return DataSourceBuilder
                .create()
                .url("jdbc:mysql://localhost:3306/test")
                .username("root")
                .password("")
                .driverClassName("com.mysql.jdbc.Driver")
                .build();
    }

}
