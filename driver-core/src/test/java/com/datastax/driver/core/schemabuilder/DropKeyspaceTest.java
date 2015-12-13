package com.datastax.driver.core.schemabuilder;

import org.testng.annotations.Test;

import static com.datastax.driver.core.schemabuilder.SchemaBuilder.dropKeyspace;
import static org.assertj.core.api.Assertions.assertThat;

public class DropKeyspaceTest {

    @Test(groups = "unit")
    public void should_drop_keyspace() throws Exception {
        //When
        SchemaStatement statement = dropKeyspace("test");

        //Then
        assertThat(statement.getQueryString()).isEqualTo("DROP KEYSPACE test");
    }

    @Test(groups = "unit")
    public void should_drop_keyspace_if_exists() throws Exception {
        //When
        SchemaStatement statement = dropKeyspace("test").ifExists();

        //Then
        assertThat(statement.getQueryString()).isEqualTo("DROP KEYSPACE IF EXISTS test");
    }
}
