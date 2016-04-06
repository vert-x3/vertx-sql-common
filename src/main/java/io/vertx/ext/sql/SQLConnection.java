/*
 * Copyright (c) 2011-2014 The original author or authors
 * ------------------------------------------------------
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Apache License v2.0 which accompanies this distribution.
 *
 *     The Eclipse Public License is available at
 *     http://www.eclipse.org/legal/epl-v10.html
 *
 *     The Apache License v2.0 is available at
 *     http://www.opensource.org/licenses/apache2.0.php
 *
 * You may elect to redistribute this code under either of these licenses.
 */

package io.vertx.ext.sql;

import io.vertx.codegen.annotations.Fluent;
import io.vertx.codegen.annotations.VertxGen;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonArray;

/**
 * Represents a connection to a SQL database
 *
 * @author <a href="mailto:nscavell@redhat.com">Nick Scavelli</a>
 */
@VertxGen
public interface SQLConnection extends AutoCloseable {

  /**
   * Sets the auto commit flag for this connection. True by default.
   *
   * @param autoCommit  the autoCommit flag, true by default.
   * @param resultHandler  the handler which is called once this operation completes.
   * @see java.sql.Connection#setAutoCommit(boolean)
   */
  @Fluent
  SQLConnection setAutoCommit(boolean autoCommit, Handler<AsyncResult<Void>> resultHandler);

  /**
   * Executes the given SQL statement
   *
   * @param sql  the SQL to execute. For example <code>CREATE TABLE IF EXISTS table ...</code>
   * @param resultHandler  the handler which is called once this operation completes.
   * @see java.sql.Statement#execute(String)
   */
  @Fluent
  SQLConnection execute(String sql, Handler<AsyncResult<Void>> resultHandler);

  /**
   * Executes the given SQL <code>SELECT</code> statement which returns the results of the query.
   *
   * @param sql  the SQL to execute. For example <code>SELECT * FROM table ...</code>.
   * @param resultHandler  the handler which is called once the operation completes. It will return a {@code ResultSet}.
   *
   * @see java.sql.Statement#executeQuery(String)
   * @see java.sql.PreparedStatement#executeQuery(String)
   */
  @Fluent
  SQLConnection query(String sql, Handler<AsyncResult<ResultSet>> resultHandler);

  /**
   * Executes the given SQL <code>SELECT</code> prepared statement which returns the results of the query.
   *
   * @param sql  the SQL to execute. For example <code>SELECT * FROM table ...</code>.
   * @param params  these are the parameters to fill the statement.
   * @param resultHandler  the handler which is called once the operation completes. It will return a {@code ResultSet}.
   *
   * @see java.sql.Statement#executeQuery(String)
   * @see java.sql.PreparedStatement#executeQuery(String)
   */
  @Fluent
  SQLConnection queryWithParams(String sql, JsonArray params, Handler<AsyncResult<ResultSet>> resultHandler);

  /**
   * Executes the given SQL statement which may be an <code>INSERT</code>, <code>UPDATE</code>, or <code>DELETE</code>
   * statement.
   *
   * @param sql  the SQL to execute. For example <code>INSERT INTO table ...</code>
   * @param resultHandler  the handler which is called once the operation completes.
   *
   * @see java.sql.Statement#executeUpdate(String)
   * @see java.sql.PreparedStatement#executeUpdate(String)
   */
  @Fluent
  SQLConnection update(String sql, Handler<AsyncResult<UpdateResult>> resultHandler);

  /**
   * Executes the given prepared statement which may be an <code>INSERT</code>, <code>UPDATE</code>, or <code>DELETE</code>
   * statement with the given parameters
   *
   * @param sql  the SQL to execute. For example <code>INSERT INTO table ...</code>
   * @param params  these are the parameters to fill the statement.
   * @param resultHandler  the handler which is called once the operation completes.
   *
   * @see java.sql.Statement#executeUpdate(String)
   * @see java.sql.PreparedStatement#executeUpdate(String)
   */
  @Fluent
  SQLConnection updateWithParams(String sql, JsonArray params, Handler<AsyncResult<UpdateResult>> resultHandler);

  /**
   * Calls the given SQL <code>PROCEDURE</code> which returns the result from the procedure.
   *
   * @param sql  the SQL to execute. For example <code>{call getEmpName (?, ?)}</code>.
   * @param resultHandler  the handler which is called once the operation completes. It will return a {@code ResultSet}.
   *
   * @see java.sql.CallableStatement#execute(String)
   */
  @Fluent
  SQLConnection call(String sql, Handler<AsyncResult<ResultSet>> resultHandler);

  /**
   * Calls the given SQL <code>PROCEDURE</code> which returns the result from the procedure.
   *
   * @param sql  the SQL to execute. For example <code>{call getEmpName (?, ?)}</code>.
   * @param params  these are the parameters to fill the statement.
   * @param outputs  these are the outputs to fill the statement.
   * @param resultHandler  the handler which is called once the operation completes. It will return a {@code ResultSet}.
   *
   * @see java.sql.CallableStatement#execute(String)
   */
  @Fluent
  SQLConnection callWithParams(String sql, JsonArray params, JsonArray outputs, Handler<AsyncResult<ResultSet>> resultHandler);

  /**
   * Closes the connection. Important to always close the connection when you are done so it's returned to the pool.
   *
   * @param handler the handler called when this operation completes.
   */
  void close(Handler<AsyncResult<Void>> handler);

  /**
   * Closes the connection. Important to always close the connection when you are done so it's returned to the pool.
   */
  void close();

  /**
   * Commits all changes made since the previous commit/rollback.
   *
   * @param handler the handler called when this operation completes.
   */
  @Fluent
  SQLConnection commit(Handler<AsyncResult<Void>> handler);

  /**
   * Rolls back all changes made since the previous commit/rollback.
   *
   * @param handler the handler called when this operation completes.
   */
  @Fluent
  SQLConnection rollback(Handler<AsyncResult<Void>> handler);

  /**
   * Attempts to change the transaction isolation level for this Connection object to the one given.
   *
   * The constants defined in the interface Connection are the possible transaction isolation levels.
   *
   * @param isolation the level of isolation
   * @param handler the handler called when this operation completes.
   */
  @Fluent
  SQLConnection setTransactionIsolation(TransactionIsolation isolation, Handler<AsyncResult<Void>> handler);

  /**
   * Attempts to return the transaction isolation level for this Connection object to the one given.
   *
   * @param handler the handler called when this operation completes.
   */
  @Fluent
  SQLConnection getTransactionIsolation(Handler<AsyncResult<TransactionIsolation>> handler);
}
