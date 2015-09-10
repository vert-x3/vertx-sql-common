/**
 * == Vert.x Common SQL interface
 *
 * The common SQL interface is used to interact with Vert.x SQL services.
 *
 * You obtain a connection to the database via the service interface for the specific SQL service that
 * you are using (e.g. JDBC/MySQL/PostgreSQL).
 *
 * To use this project, add the following dependency to the _dependencies_ section of your build descriptor:
 *
 * * Maven (in your `pom.xml`):
 *
 * [source,xml,subs="+attributes"]
 * ----
 * <dependency>
 *   <groupId>{maven-groupId}</groupId>
 *   <artifactId>{maven-artifactId}</artifactId>
 *   <version>{maven-version}</version>
 * </dependency>
 * ----
 *
 * * Gradle (in your `build.gradle` file):
 *
 * [source,groovy,subs="+attributes"]
 * ----
 * compile {maven-groupId}:{maven-artifactId}:{maven-version}
 * ----
 *
 * == The SQL Connection
 *
 * A connection to the database is represented by {@link io.vertx.ext.sql.SQLConnection}.
 *
 * === Auto-commit
 *
 * When you obtain a connection auto commit is set to `true`. This means that each operation you perform will effectively
 * execute in its own transaction.
 *
 * If you wish to perform multiple operations in a single transaction you should set auto commit to false with
 * {@link io.vertx.ext.sql.SQLConnection#setAutoCommit(boolean, io.vertx.core.Handler)}.
 *
 * When the operation is complete, the handler will be called:
 *
 * [source,java]
 * ----
 * {@link examples.Examples#example1}
 * ----
 *
 * === Executing queries
 *
 * To execute a query use {@link io.vertx.ext.sql.SQLConnection#query(java.lang.String, io.vertx.core.Handler)}
 *
 * The query string is raw SQL that is passed through without changes to the actual database.
 *
 * The handler will be called with the results, represented by {@link io.vertx.ext.sql.ResultSet} when the query has
 * been run.
 *
 * [source,java]
 * ----
 * {@link examples.Examples#example2}
 * ----
 *
 * The {@link io.vertx.ext.sql.ResultSet} instance represents the results of a query.
 *
 * The list of column names are available with {@link io.vertx.ext.sql.ResultSet#getColumnNames()}, and the actual results
 * available with {@link io.vertx.ext.sql.ResultSet#getResults()}
 *
 * The results are a list of {@link io.vertx.core.json.JsonArray} instances, one for each row of the results.
 *
 * [source,java]
 * ----
 * {@link examples.Examples#example3}
 * ----
 *
 * You can also retrieve the rows as a list of Json object instances with {@link io.vertx.ext.sql.ResultSet#getRows()} -
 * this can give you a somewhat simpler API to work with, but please be aware that SQL results can contain duplicate
 * column names - if that's the case you should use {@link io.vertx.ext.sql.ResultSet#getResults()} instead.
 *
 * Here's an example of iterating through the results as Json object instances:
 *
 * [source,java]
 * ----
 * {@link examples.Examples#example3__1}
 * ----
 *
 * === Prepared statement queries
 *
 * To execute a prepared statement query you can use
 * {@link io.vertx.ext.sql.SQLConnection#queryWithParams(java.lang.String, io.vertx.core.json.JsonArray, io.vertx.core.Handler)}.
 *
 * This takes the query, containing the parameter place holders, and a {@link io.vertx.core.json.JsonArray} or parameter
 * values.
 *
 * [source,java]
 * ----
 * {@link examples.Examples#example3_1}
 * ----
 *
 * === Executing INSERT, UPDATE or DELETE
 *
 * To execute an operation which updates the database use {@link io.vertx.ext.sql.SQLConnection#update(java.lang.String, io.vertx.core.Handler)}.
 *
 * The update string is raw SQL that is passed through without changes to the actual database.
 *
 * The handler will be called with the results, represented by {@link io.vertx.ext.sql.UpdateResult} when the update has
 * been run.
 *
 * The update result holds the number of rows updated with {@link io.vertx.ext.sql.UpdateResult#getUpdated()}, and
 * if the update generated keys, they are available with {@link io.vertx.ext.sql.UpdateResult#getKeys()}.
 *
 * [source,java]
 * ----
 * {@link examples.Examples#example3}
 * ----
 *
 * === Prepared statement updates
 *
 * To execute a prepared statement update you can use
 * {@link io.vertx.ext.sql.SQLConnection#updateWithParams(java.lang.String, io.vertx.core.json.JsonArray, io.vertx.core.Handler)}.
 *
 * This takes the update, containing the parameter place holders, and a {@link io.vertx.core.json.JsonArray} or parameter
 * values.
 *
 * [source,java]
 * ----
 * {@link examples.Examples#example5}
 * ----
 *
 * === Executing other operations
 *
 * To execute any other database operation, e.g. a `CREATE TABLE` you can use
 * {@link io.vertx.ext.sql.SQLConnection#execute(java.lang.String, io.vertx.core.Handler)}.
 *
 * The string is passed through without changes to the actual database. The handler is called when the operation
 * is complete
 *
 * [source,java]
 * ----
 * {@link examples.Examples#example6}
 * ----
 *
 * === Using transactions
 *
 * To use transactions first set auto-commit to false with {@link io.vertx.ext.sql.SQLConnection#setAutoCommit(boolean, io.vertx.core.Handler)}.
 *
 * You then do your transactional operations and when you want to commit or rollback use
 * {@link io.vertx.ext.sql.SQLConnection#commit(io.vertx.core.Handler)} or
 * {@link io.vertx.ext.sql.SQLConnection#rollback(io.vertx.core.Handler)}.
 *
 * Once the commit/rollback is complete the handler will be called and the next transaction will be automatically started.
 *
 * [source,java]
 * ----
 * {@link examples.Examples#example7}
 * ----
 *
 * === Closing connections
 *
 * When you've done with the connection you should return it to the pool with {@link io.vertx.ext.sql.SQLConnection#close(io.vertx.core.Handler)}.
 *
 */
@Document(fileName = "index.adoc")

@ModuleGen(name = "vertx-sql", groupPackage = "io.vertx")
package io.vertx.ext.sql;

import io.vertx.codegen.annotations.ModuleGen;
import io.vertx.docgen.Document;