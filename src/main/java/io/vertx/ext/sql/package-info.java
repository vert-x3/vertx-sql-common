/**
 * == Vert.x Common SQL interface
 *
 * The common SQL interface is used to interact with Vert.x SQL services.
 *
 * You obtain a connection to the database via the service interface for the specific SQL service that you are using
 * (e.g. JDBC/MySQL/PostgreSQL).
 *
 * == The SQL Connection
 *
 * A connection to the database is represented by {@link io.vertx.ext.sql.SqlConnection}.
 *
 * === Auto-commit
 *
 * When you obtain a connection auto commit is set to `true`. This means that each operation you perform will effectively
 * execute in its own transaction.
 *
 * If you wish to perform multiple operations in a single transaction you should set auto commit to false with
 * {@link io.vertx.ext.sql.SqlConnection#setAutoCommit(boolean, io.vertx.core.Handler)}.
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
 * To execute a query use {@link io.vertx.ext.sql.SqlConnection#query(java.lang.String, io.vertx.core.Handler)}
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
 * === Prepared statement queries
 *
 * To execute a prepared statement query you can use
 * {@link io.vertx.ext.sql.SqlConnection#queryWithParams(java.lang.String, io.vertx.core.json.JsonArray, io.vertx.core.Handler)}.
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
 * To execute an operation which updates the database use {@link io.vertx.ext.sql.SqlConnection#update(java.lang.String, io.vertx.core.Handler)}.
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
 * {@link io.vertx.ext.sql.SqlConnection#updateWithParams(java.lang.String, io.vertx.core.json.JsonArray, io.vertx.core.Handler)}.
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
 * {@link io.vertx.ext.sql.SqlConnection#execute(java.lang.String, io.vertx.core.Handler)}.
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
 * To use transactions first set auto-commit to false with {@link io.vertx.ext.sql.SqlConnection#setAutoCommit(boolean, io.vertx.core.Handler)}.
 *
 * You then do your transactional operations and when you want to commit or rollback use
 * {@link io.vertx.ext.sql.SqlConnection#commit(io.vertx.core.Handler)} or
 * {@link io.vertx.ext.sql.SqlConnection#rollback(io.vertx.core.Handler)}.
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
 * When you've done with the connection you should return it to the pool with {@link io.vertx.ext.sql.SqlConnection#close(io.vertx.core.Handler)}.
 *
 */
@Document(fileName = "index.adoc")

@GenModule(name = "vertx-sql")
package io.vertx.ext.sql;

import io.vertx.codegen.annotations.GenModule;
import io.vertx.docgen.Document;