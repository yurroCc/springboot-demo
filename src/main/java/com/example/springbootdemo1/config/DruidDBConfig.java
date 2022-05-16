package com.example.springbootdemo1.config;

// 使用@Configuration标注，表示这是一个配置管理类

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
public class DruidDBConfig {

        // 因为spring boot是默认开启了资源过滤的
        // 所以这里的配置，都会自动从application.properties配置文件中加载出来，设置到这个@Configuration类中
        @Value("${spring.datasource.url}")
        private String dbUrl;
        @Value("${spring.datasource.username}")
        private String username;
        @Value("${spring.datasource.password}")
        private String password;
        @Value("${spring.datasource.driver-class-name}")
        private String driverClassName;
        @Value("${spring.datasource.druid.initial-size}")
        private int initialSize;
        @Value("${spring.datasource.druid.min-idle}")
        private int minIdle;
        @Value("${spring.datasource.druid.max-active}")
        private int maxActive;
        @Value("${spring.datasource.druid.max-wait}")
        private int maxWait;
        @Value("${spring.datasource.druid.time-between-eviction-runs-millis}")
        private int timeBetweenEvictionRunsMillis;
        @Value("${spring.datasource.druid.min-evictable-idle-time-millis}")
        private int minEvictableIdleTimeMillis;
        @Value("${spring.datasource.druid.validation-query}")
        private String validationQuery;
        @Value("${spring.datasource.druid.test-while-idle}")
        private boolean testWhileIdle;
        @Value("${spring.datasource.druid.testOnBorrow}")
        private boolean testOnBorrow;
        @Value("${spring.datasource.druid.testOnReturn}")
        private boolean testOnReturn;
        @Value("${spring.datasource.druid.poolPreparedStatements}")
        private boolean poolPreparedStatements;
        @Value("${spring.datasource.druid.maxPoolPreparedStatementPerConnectionSize}")
        private int maxPoolPreparedStatementPerConnectionSize;
        @Value("${spring.datasource.druid.filters}")
        private String filters;
        @Value("{spring.datasource.druid.connectionProperties}")
        private String connectionProperties;

        // 在这个配置类中，直接基于配置信息，创建出了一个bean
        // 这个bean就是一个DataSource
        // 这个DataSource bean就会被纳入spring容器的管理范围之内
        @Bean
        @Primary
        public DataSource dataSource() {
                // 这里就是用外部加载进来的配置信息，创建出来一个Druid连接池
                DruidDataSource datasource = new DruidDataSource();
                datasource.setUrl(this.dbUrl);
                datasource.setUsername(username);
                datasource.setPassword(password);
                datasource.setDriverClassName(driverClassName);

                //configuration  
                datasource.setInitialSize(initialSize);
                datasource.setMinIdle(minIdle);
                datasource.setMaxActive(maxActive);
                datasource.setMaxWait(maxWait);
                datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
                datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
                datasource.setValidationQuery(validationQuery);
                datasource.setTestWhileIdle(testWhileIdle);
                datasource.setTestOnBorrow(testOnBorrow);
                datasource.setTestOnReturn(testOnReturn);
                datasource.setPoolPreparedStatements(poolPreparedStatements);
                datasource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
                try {
                        datasource.setFilters(filters);
                } catch (SQLException e) {
                        e.printStackTrace();
                }
                datasource.setConnectionProperties(connectionProperties);

                return datasource;
        }
}
