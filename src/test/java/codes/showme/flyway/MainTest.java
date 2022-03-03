package codes.showme.flyway;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.output.MigrateResult;
import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Test;
import org.testcontainers.containers.PostgreSQLContainer;

public class MainTest {

    @ClassRule
    public static PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer("postgres:12.8")
            .withDatabaseName("integration-tests-db")
            .withUsername("sa")
            .withPassword("sa");

    @Test
    public void testMain() {
        Flyway flyway = Flyway.configure()
                .locations("sqls")
                .dataSource(postgreSQLContainer.getJdbcUrl(),
                postgreSQLContainer.getUsername(), postgreSQLContainer.getPassword()).load();
        MigrateResult migrate = flyway.migrate();
        Assert.assertEquals(1, migrate.migrationsExecuted);
        Assert.assertTrue(migrate.success);
    }

}
