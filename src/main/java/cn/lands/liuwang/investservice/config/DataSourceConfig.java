package cn.lands.liuwang.investservice.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean(name = "rewardDataSource")
    @Primary
    @Qualifier("rewardDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.reward")
    public DataSource rewardDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "rewardJdbcTemplate")
    public JdbcTemplate rewardJdbcTemplate(@Qualifier("rewardDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
