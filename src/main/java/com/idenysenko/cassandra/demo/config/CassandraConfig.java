package com.idenysenko.cassandra.demo.config;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.QueryLogger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification;

import java.util.Collections;
import java.util.List;

@Configuration
public class CassandraConfig extends AbstractCassandraConfiguration {

    @Value("${spring.data.cassandra.keyspace-name}")
    private String keyspace;

    @Override
    public SchemaAction getSchemaAction() {
        return SchemaAction.CREATE_IF_NOT_EXISTS;
    }

    @Override
    protected List<CreateKeyspaceSpecification> getKeyspaceCreations() {
        return Collections.singletonList(
                CreateKeyspaceSpecification.createKeyspace(keyspace).ifNotExists()
        );
    }

    @Override
    protected String getKeyspaceName() {
        return keyspace;
    }

    @Override
    public String[] getEntityBasePackages() {
        return new String[]{"com.idenysenko.cassandra.demo.entity"};
    }

    @Override
    protected Cluster getRequiredCluster() {
        QueryLogger queryLogger = QueryLogger.builder().build();
        return super.getRequiredCluster().register(queryLogger);
    }
}
