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
import io.vertx.codegen.annotations.ProxyClose;
import io.vertx.codegen.annotations.ProxyGen;
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
@ProxyGen
public interface SqlConnection {

  /**
   * Sets the auto commit flag for this connection. True by default.
   *
   * @param autoCommit  the autoCommit flag, true by default.
   * @param resultHandler  the handler which is called once this operation completes.
   * @see java.sql.Connection#setAutoCommit(boolean)
   */
  @Fluent
  SqlConnection setAutoCommit(boolean autoCommit, Handler<AsyncResult<Void>> resultHandler);

  /**
   * Executes the given SQL statement
   *
   * @param sql  the SQL to execute. For example <code>CREATE TABLE IF EXISTS table ...</code>
   * @param resultHandler  the handler which is called once this operation completes.
   * @see java.sql.Statement#execute(String)
   */
  @Fluent
  SqlConnection execute(String sql, Handler<AsyncResult<Void>> resultHandler);

  /**
   * Executes the given SQL <code>SELECT</code> statement which returns the results of the query.
   *
   * @param sql  the SQL to execute. For example <code>SELECT * FROM table ...</code>.
   * @param resultHandler  the handler which is called once the operation completes. It will return a ResultSet.
   *
   * @see java.sql.Statement#executeQuery(String)
   * @see java.sql.PreparedStatement#executeQuery(String)
   */
  @Fluent
  SqlConnection query(String sql, Handler<AsyncResult<ResultSet>> resultHandler);

  /**
   * Executes the given SQL <code>SELECT</code> prepared statement which returns the results of the query.
   *
   * @param sql  the SQL to execute. For example <code>SELECT * FROM table ...</code>.
   * @param params  these are the parameters to fill the statement.
   * @param resultHandler  the handler which is called once the operation completes. It will return a ResultSet.
   *
   * @see java.sql.Statement#executeQuery(String)
   * @see java.sql.PreparedStatement#executeQuery(String)
   */
  @Fluent
  SqlConnection queryWithParams(String sql, JsonArray params, Handler<AsyncResult<ResultSet>> resultHandler);

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
  SqlConnection update(String sql, Handler<AsyncResult<UpdateResult>> resultHandler);

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
  SqlConnection updateWithParams(String sql, JsonArray params, Handler<AsyncResult<UpdateResult>> resultHandler);

  /**
   * Closes the connection. Important to always close the connection when you are done so it's returned to the pool.
   *
   * @param handler the handler called when this operation completes.
   */
  @ProxyClose
  void close(Handler<AsyncResult<Void>> handler);

  /**
   * Commits all changes made since the previous commit/rollback.
   *
   * @param handler the handler called when this operation completes.
   */
  @Fluent
  SqlConnection commit(Handler<AsyncResult<Void>> handler);

  /**
   * Rolls back all changes made since the previous commit/rollback.
   *
   * @param handler the handler called when this operation completes.
   */
  @Fluent
  SqlConnection rollback(Handler<AsyncResult<Void>> handler);
}
