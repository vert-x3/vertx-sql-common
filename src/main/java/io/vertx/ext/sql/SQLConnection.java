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
import io.vertx.core.spi.concurrent.CompletableStage;

import java.util.List;
import java.util.concurrent.CompletionStage;

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

  default CompletionStage<Void> setAutoCommit(boolean autoCommit) {
    CompletableStage<Void> fut = CompletableStage.create();
    setAutoCommit(autoCommit, fut);
    return fut;
  }

  /**
   * Executes the given SQL statement
   *
   * @param sql  the SQL to execute. For example <code>CREATE TABLE IF EXISTS table ...</code>
   * @param resultHandler  the handler which is called once this operation completes.
   * @see java.sql.Statement#execute(String)
   */
  @Fluent
  SQLConnection execute(String sql, Handler<AsyncResult<Void>> resultHandler);

  default CompletionStage<Void> execute(String sql) {
    CompletableStage<Void> fut = CompletableStage.create();
    execute(sql, fut);
    return fut;
  }

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

  default CompletionStage<ResultSet> query(String sql) {
    CompletableStage<ResultSet> fut = CompletableStage.create();
    query(sql, fut);
    return fut;
  }

  /**
   * Executes the given SQL <code>SELECT</code> statement which returns the results of the query as a read stream.
   *
   * @param sql  the SQL to execute. For example <code>SELECT * FROM table ...</code>.
   * @param handler  the handler which is called once the operation completes. It will return a {@code SQLRowStream}.
   *
   * @see java.sql.Statement#executeQuery(String)
   * @see java.sql.PreparedStatement#executeQuery(String)
   */
  @Fluent
  SQLConnection queryStream(String sql, Handler<AsyncResult<SQLRowStream>> handler);

  default CompletionStage<SQLRowStream> queryStream(String sql) {
    CompletableStage<SQLRowStream> fut = CompletableStage.create();
    queryStream(sql, fut);
    return fut;
  };

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

  default CompletionStage<ResultSet> queryWithParams(String sql, JsonArray params) {
    CompletableStage<ResultSet> fut = CompletableStage.create();
    queryWithParams(sql, params, fut);
    return fut;
  }

  /**
   * Executes the given SQL <code>SELECT</code> statement which returns the results of the query as a read stream.
   *
   * @param sql  the SQL to execute. For example <code>SELECT * FROM table ...</code>.
   * @param params  these are the parameters to fill the statement.
   * @param handler  the handler which is called once the operation completes. It will return a {@code SQLRowStream}.
   *
   * @see java.sql.Statement#executeQuery(String)
   * @see java.sql.PreparedStatement#executeQuery(String)
   */
  @Fluent
  SQLConnection queryStreamWithParams(String sql, JsonArray params, Handler<AsyncResult<SQLRowStream>> handler);

  default CompletionStage<SQLRowStream> queryStreamWithParams(String sql, JsonArray params) {
    CompletableStage<SQLRowStream> fut = CompletableStage.create();
    queryStreamWithParams(sql, params, fut);
    return fut;
  }

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

  default CompletionStage<UpdateResult> update(String sql) {
    CompletableStage<UpdateResult> fut = CompletableStage.create();
    update(sql, fut);
    return fut;
  }

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

  default CompletionStage<UpdateResult> updateWithParams(String sql, JsonArray params) {
    CompletableStage<UpdateResult> fut = CompletableStage.create();
    updateWithParams(sql, params, fut);
    return fut;
  }

  /**
   * Calls the given SQL <code>PROCEDURE</code> which returns the result from the procedure.
   *
   * @param sql  the SQL to execute. For example <code>{call getEmpName}</code>.
   * @param resultHandler  the handler which is called once the operation completes. It will return a {@code ResultSet}.
   *
   * @see java.sql.CallableStatement#execute(String)
   */
  @Fluent
  SQLConnection call(String sql, Handler<AsyncResult<ResultSet>> resultHandler);

  default CompletionStage<ResultSet> call(String sql) {
    CompletableStage<ResultSet> fut = CompletableStage.create();
    call(sql, fut);
    return fut;
  }

  /**
   * Calls the given SQL <code>PROCEDURE</code> which returns the result from the procedure.
   *
   * The index of params and outputs are important for both arrays, for example when dealing with a prodecure that
   * takes the first 2 arguments as input values and the 3 arg as an output then the arrays should be like:
   *
   * <pre>
   *   params = [VALUE1, VALUE2, null]
   *   outputs = [null, null, "VARCHAR"]
   * </pre>
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

  default CompletionStage<ResultSet> callWithParams(String sql, JsonArray params, JsonArray outputs) {
    CompletableStage<ResultSet> fut = CompletableStage.create();
    callWithParams(sql, params, outputs, fut);
    return fut;
  }

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

  default CompletionStage<Void> commit() {
    CompletableStage<Void> fut = CompletableStage.create();
    close(fut);
    return fut;
  }

  /**
   * Rolls back all changes made since the previous commit/rollback.
   *
   * @param handler the handler called when this operation completes.
   */
  @Fluent
  SQLConnection rollback(Handler<AsyncResult<Void>> handler);

  default CompletionStage<Void> rollback() {
    CompletableStage<Void> fut = CompletableStage.create();
    rollback(fut);
    return fut;
  }


  /**
   * Sets a connection wide query timeout.
   *
   * It can be over written at any time and becomes active on the next query call.
   *
   * @param timeoutInSeconds the max amount of seconds the query can take to execute.
   */
  @Fluent
  SQLConnection setQueryTimeout(int timeoutInSeconds);

  /**
   * Batch simple SQL strings and execute the batch where the async result contains a array of Integers.
   *
   * @param sqlStatements sql statement
   * @param handler the result handler
   */
  @Fluent
  SQLConnection batch(List<String> sqlStatements, Handler<AsyncResult<List<Integer>>> handler);

  default CompletionStage<List<Integer>> batch(List<String> sqlStatements) {
    CompletableStage<List<Integer>> fut = CompletableStage.create();
    batch(sqlStatements, fut);
    return fut;
  }

  /**
   * Batch a prepared statement with all entries from the args list. Each entry is a batch.
   * The operation completes with the execution of the batch where the async result contains a array of Integers.
   *
   * @param sqlStatement sql statement
   * @param args the prepared statement arguments
   * @param handler the result handler
   */
  @Fluent
  SQLConnection batchWithParams(String sqlStatement, List<JsonArray> args, Handler<AsyncResult<List<Integer>>> handler);

  default CompletionStage<List<Integer>> batchWithParams(String sqlStatement, List<JsonArray> args) {
    CompletableStage<List<Integer>> fut = CompletableStage.create();
    batchWithParams(sqlStatement, args, fut);
    return fut;
  }

  /**
   * Batch a callable statement with all entries from the args list. Each entry is a batch.
   * The size of the lists inArgs and outArgs MUST be the equal.
   * The operation completes with the execution of the batch where the async result contains a array of Integers.
   *
   * @param sqlStatement sql statement
   * @param inArgs the callable statement input arguments
   * @param outArgs the callable statement output arguments
   * @param handler the result handler
   */
  @Fluent
  SQLConnection batchCallableWithParams(String sqlStatement, List<JsonArray> inArgs, List<JsonArray> outArgs, Handler<AsyncResult<List<Integer>>> handler);

  default CompletionStage<List<Integer>> batchCallableWithParams(String sqlStatement, List<JsonArray> inArgs, List<JsonArray> outArgs) {
    CompletableStage<List<Integer>> fut = CompletableStage.create();
    batchCallableWithParams(sqlStatement, inArgs, outArgs, fut);
    return fut;
  }

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

  default CompletionStage<Void> setTransactionIsolation(TransactionIsolation isolation) {
    CompletableStage<Void> fut = CompletableStage.create();
    setTransactionIsolation(isolation, fut);
    return fut;
  }

  /**
   * Attempts to return the transaction isolation level for this Connection object to the one given.
   *
   * @param handler the handler called when this operation completes.
   */
  @Fluent
  SQLConnection getTransactionIsolation(Handler<AsyncResult<TransactionIsolation>> handler);

  default CompletionStage<TransactionIsolation> getTransactionIsolation() {
    CompletableStage<TransactionIsolation> fut = CompletableStage.create();
    getTransactionIsolation(fut);
    return fut;
  }
}
