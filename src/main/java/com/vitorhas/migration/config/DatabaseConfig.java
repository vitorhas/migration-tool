package com.vitorhas.migration.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    @Bean(name="h2db")
    @ConfigurationProperties(prefix="spring.ds_h2")
    @Primary
    public DataSource h2DataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "sqlserverdb")
    @ConfigurationProperties(prefix = "spring.ds_sqlserver")
    public DataSource sqlserverDataSource() {
        return  DataSourceBuilder.create().build();
    }

    @Bean(name = "sqlserverJdbcTemplate")
    public JdbcTemplate sqlserverJdbcTemplate(@Qualifier("sqlserverdb")
                                                      DataSource dssqlserver) {
        return new JdbcTemplate(dssqlserver);
    }
}

