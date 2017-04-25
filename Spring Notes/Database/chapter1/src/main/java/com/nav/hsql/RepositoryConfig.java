package com.nav.hsql;

import javax.annotation.PreDestroy;
import javax.sql.DataSource;

import org.hsqldb.util.DatabaseManagerSwing;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
public class RepositoryConfig {
	
	private EmbeddedDatabase db;

	@Bean(name="dataSource")
	public DataSource datasource() {
		System.out.println("Setting up the database");
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase db = builder
				.setType(EmbeddedDatabaseType.HSQL)
				.addScript("com/nav/hsql/create-table.sql")
				.addScript("com/nav/hsql/insert.sql")
				.build();
		this.db = db;
		DatabaseManagerSwing.main(new String[] { "--url", "jdbc:hsqldb:mem:testdb", "--user", "sa", "--password", "" });
		return db;
	}
	
	@PreDestroy
	void destroy(){
		System.out.println("Shutting down the database");
		this.db.shutdown();
	}
}
