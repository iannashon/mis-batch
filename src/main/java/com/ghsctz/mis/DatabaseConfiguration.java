package com.ghsctz.mis;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;


@Configuration
public class DatabaseConfiguration {

    @Primary
    @Bean(name = "reportDb")
    @ConfigurationProperties(prefix = "spring.report")
    public DataSource reportDataSource() {
        final SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriver(new org.postgresql.Driver());
        dataSource.setUrl("jdbc:postgresql:open_lmis_report");
        dataSource.setUsername("postgres");
        dataSource.setPassword("p@ssw0rd");
        return dataSource;
    }

    @Bean(name = "reportJdbcTemplate")
    public JdbcTemplate reportJdbcTemplate(@Qualifier("reportDb") DataSource dsReport) {
        return new JdbcTemplate(dsReport);
    }


    @Bean(name = "openlmisDb")
    @ConfigurationProperties(prefix = "spring.openlmis")
    public DataSource opelmisDataSource() {
        final SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriver(new org.postgresql.Driver());
        dataSource.setUrl("jdbc:postgresql:open_lmis");
        dataSource.setUsername("postgres");
        dataSource.setPassword("p@ssw0rd");
        return dataSource;
    }

    @Bean(name = "openlmisJdbcTemplate")
    public JdbcTemplate openlmisJdbcTemplate(@Qualifier("openlmisDb") DataSource dsOpenlmis) {
        return new JdbcTemplate(dsOpenlmis);
    }

//    @Bean
//    public BatchDatabaseInitializer batchDatabaseInitializer(final BatchProperties properties,
//                                                             @Qualifier("scdfDb") final DataSource dataSource,
//                                                             final ResourceLoader resourceLoader) {
//        return new BatchDatabaseInitializer(dataSource, resourceLoader, properties);
//    }
}
