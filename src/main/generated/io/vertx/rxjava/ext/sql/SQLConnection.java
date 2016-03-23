/*
 * Copyright 2014 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package io.vertx.rxjava.ext.sql;

import java.util.Map;
import io.vertx.lang.rxjava.InternalHelper;
import rx.Observable;
import io.vertx.core.json.JsonArray;
import io.vertx.ext.sql.UpdateResult;
import io.vertx.ext.sql.ResultSet;
import io.vertx.ext.sql.TransactionIsolation;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;

/**
 * Represents a connection to a SQL database
 *
 * <p/>
 * NOTE: This class has been automatically generated from the {@link io.vertx.ext.sql.SQLConnection original} non RX-ified interface using Vert.x codegen.
 */

public class SQLConnection {

  final io.vertx.ext.sql.SQLConnection delegate;

  public SQLConnection(io.vertx.ext.sql.SQLConnection delegate) {
    this.delegate = delegate;
  }

  public Object getDelegate() {
    return delegate;
  }

  /**
   * Sets the auto commit flag for this connection. True by default.
   * @param autoCommit the autoCommit flag, true by default.
   * @param resultHandler the handler which is called once this operation completes.
   * @return 
   */
  public SQLConnection setAutoCommit(boolean autoCommit, Handler<AsyncResult<Void>> resultHandler) { 
    this.delegate.setAutoCommit(autoCommit, resultHandler);
    return this;
  }

  /**
   * Sets the auto commit flag for this connection. True by default.
   * @param autoCommit the autoCommit flag, true by default.
   * @return 
   */
  public Observable<Void> setAutoCommitObservable(boolean autoCommit) { 
    io.vertx.rx.java.ObservableFuture<Void> resultHandler = io.vertx.rx.java.RxHelper.observableFuture();
    setAutoCommit(autoCommit, resultHandler.toHandler());
    return resultHandler;
  }

  /**
   * Executes the given SQL statement
   * @param sql the SQL to execute. For example <code>CREATE TABLE IF EXISTS table ...</code>
   * @param resultHandler the handler which is called once this operation completes.
   * @return 
   */
  public SQLConnection execute(String sql, Handler<AsyncResult<Void>> resultHandler) { 
    this.delegate.execute(sql, resultHandler);
    return this;
  }

  /**
   * Executes the given SQL statement
   * @param sql the SQL to execute. For example <code>CREATE TABLE IF EXISTS table ...</code>
   * @return 
   */
  public Observable<Void> executeObservable(String sql) { 
    io.vertx.rx.java.ObservableFuture<Void> resultHandler = io.vertx.rx.java.RxHelper.observableFuture();
    execute(sql, resultHandler.toHandler());
    return resultHandler;
  }

  /**
   * Executes the given SQL <code>SELECT</code> statement which returns the results of the query.
   * @param sql the SQL to execute. For example <code>SELECT * FROM table ...</code>.
   * @param resultHandler the handler which is called once the operation completes. It will return a <code>ResultSet</code>.
   * @return 
   */
  public SQLConnection query(String sql, Handler<AsyncResult<ResultSet>> resultHandler) { 
    this.delegate.query(sql, resultHandler);
    return this;
  }

  /**
   * Executes the given SQL <code>SELECT</code> statement which returns the results of the query.
   * @param sql the SQL to execute. For example <code>SELECT * FROM table ...</code>.
   * @return 
   */
  public Observable<ResultSet> queryObservable(String sql) { 
    io.vertx.rx.java.ObservableFuture<ResultSet> resultHandler = io.vertx.rx.java.RxHelper.observableFuture();
    query(sql, resultHandler.toHandler());
    return resultHandler;
  }

  /**
   * Executes the given SQL <code>SELECT</code> prepared statement which returns the results of the query.
   * @param sql the SQL to execute. For example <code>SELECT * FROM table ...</code>.
   * @param params these are the parameters to fill the statement.
   * @param resultHandler the handler which is called once the operation completes. It will return a <code>ResultSet</code>.
   * @return 
   */
  public SQLConnection queryWithParams(String sql, JsonArray params, Handler<AsyncResult<ResultSet>> resultHandler) { 
    this.delegate.queryWithParams(sql, params, resultHandler);
    return this;
  }

  /**
   * Executes the given SQL <code>SELECT</code> prepared statement which returns the results of the query.
   * @param sql the SQL to execute. For example <code>SELECT * FROM table ...</code>.
   * @param params these are the parameters to fill the statement.
   * @return 
   */
  public Observable<ResultSet> queryWithParamsObservable(String sql, JsonArray params) { 
    io.vertx.rx.java.ObservableFuture<ResultSet> resultHandler = io.vertx.rx.java.RxHelper.observableFuture();
    queryWithParams(sql, params, resultHandler.toHandler());
    return resultHandler;
  }

  /**
   * Executes the given SQL statement which may be an <code>INSERT</code>, <code>UPDATE</code>, or <code>DELETE</code>
   * statement.
   * @param sql the SQL to execute. For example <code>INSERT INTO table ...</code>
   * @param resultHandler the handler which is called once the operation completes.
   * @return 
   */
  public SQLConnection update(String sql, Handler<AsyncResult<UpdateResult>> resultHandler) { 
    this.delegate.update(sql, resultHandler);
    return this;
  }

  /**
   * Executes the given SQL statement which may be an <code>INSERT</code>, <code>UPDATE</code>, or <code>DELETE</code>
   * statement.
   * @param sql the SQL to execute. For example <code>INSERT INTO table ...</code>
   * @return 
   */
  public Observable<UpdateResult> updateObservable(String sql) { 
    io.vertx.rx.java.ObservableFuture<UpdateResult> resultHandler = io.vertx.rx.java.RxHelper.observableFuture();
    update(sql, resultHandler.toHandler());
    return resultHandler;
  }

  /**
   * Executes the given prepared statement which may be an <code>INSERT</code>, <code>UPDATE</code>, or <code>DELETE</code>
   * statement with the given parameters
   * @param sql the SQL to execute. For example <code>INSERT INTO table ...</code>
   * @param params these are the parameters to fill the statement.
   * @param resultHandler the handler which is called once the operation completes.
   * @return 
   */
  public SQLConnection updateWithParams(String sql, JsonArray params, Handler<AsyncResult<UpdateResult>> resultHandler) { 
    this.delegate.updateWithParams(sql, params, resultHandler);
    return this;
  }

  /**
   * Executes the given prepared statement which may be an <code>INSERT</code>, <code>UPDATE</code>, or <code>DELETE</code>
   * statement with the given parameters
   * @param sql the SQL to execute. For example <code>INSERT INTO table ...</code>
   * @param params these are the parameters to fill the statement.
   * @return 
   */
  public Observable<UpdateResult> updateWithParamsObservable(String sql, JsonArray params) { 
    io.vertx.rx.java.ObservableFuture<UpdateResult> resultHandler = io.vertx.rx.java.RxHelper.observableFuture();
    updateWithParams(sql, params, resultHandler.toHandler());
    return resultHandler;
  }

  /**
   * Calls the given SQL <code>PROCEDURE</code> which returns the result from the procedure.
   * @param sql the SQL to execute. For example <code>{call getEmpName (?, ?)}</code>.
   * @param resultHandler the handler which is called once the operation completes. It will return a <code>ResultSet</code>.
   * @return 
   */
  public SQLConnection call(String sql, Handler<AsyncResult<ResultSet>> resultHandler) { 
    this.delegate.call(sql, resultHandler);
    return this;
  }

  /**
   * Calls the given SQL <code>PROCEDURE</code> which returns the result from the procedure.
   * @param sql the SQL to execute. For example <code>{call getEmpName (?, ?)}</code>.
   * @return 
   */
  public Observable<ResultSet> callObservable(String sql) { 
    io.vertx.rx.java.ObservableFuture<ResultSet> resultHandler = io.vertx.rx.java.RxHelper.observableFuture();
    call(sql, resultHandler.toHandler());
    return resultHandler;
  }

  /**
   * Calls the given SQL <code>PROCEDURE</code> which returns the result from the procedure.
   * @param sql the SQL to execute. For example <code>{call getEmpName (?, ?)}</code>.
   * @param params these are the parameters to fill the statement.
   * @param outputs these are the outputs to fill the statement.
   * @param resultHandler the handler which is called once the operation completes. It will return a <code>ResultSet</code>.
   * @return 
   */
  public SQLConnection callWithParams(String sql, JsonArray params, JsonArray outputs, Handler<AsyncResult<ResultSet>> resultHandler) { 
    this.delegate.callWithParams(sql, params, outputs, resultHandler);
    return this;
  }

  /**
   * Calls the given SQL <code>PROCEDURE</code> which returns the result from the procedure.
   * @param sql the SQL to execute. For example <code>{call getEmpName (?, ?)}</code>.
   * @param params these are the parameters to fill the statement.
   * @param outputs these are the outputs to fill the statement.
   * @return 
   */
  public Observable<ResultSet> callWithParamsObservable(String sql, JsonArray params, JsonArray outputs) { 
    io.vertx.rx.java.ObservableFuture<ResultSet> resultHandler = io.vertx.rx.java.RxHelper.observableFuture();
    callWithParams(sql, params, outputs, resultHandler.toHandler());
    return resultHandler;
  }

  /**
   * Closes the connection. Important to always close the connection when you are done so it's returned to the pool.
   * @param handler the handler called when this operation completes.
   */
  public void close(Handler<AsyncResult<Void>> handler) { 
    this.delegate.close(handler);
  }

  /**
   * Closes the connection. Important to always close the connection when you are done so it's returned to the pool.
   * @return 
   */
  public Observable<Void> closeObservable() { 
    io.vertx.rx.java.ObservableFuture<Void> handler = io.vertx.rx.java.RxHelper.observableFuture();
    close(handler.toHandler());
    return handler;
  }

  /**
   * Closes the connection. Important to always close the connection when you are done so it's returned to the pool.
   */
  public void close() { 
    this.delegate.close();
  }

  /**
   * Commits all changes made since the previous commit/rollback.
   * @param handler the handler called when this operation completes.
   * @return 
   */
  public SQLConnection commit(Handler<AsyncResult<Void>> handler) { 
    this.delegate.commit(handler);
    return this;
  }

  /**
   * Commits all changes made since the previous commit/rollback.
   * @return 
   */
  public Observable<Void> commitObservable() { 
    io.vertx.rx.java.ObservableFuture<Void> handler = io.vertx.rx.java.RxHelper.observableFuture();
    commit(handler.toHandler());
    return handler;
  }

  /**
   * Rolls back all changes made since the previous commit/rollback.
   * @param handler the handler called when this operation completes.
   * @return 
   */
  public SQLConnection rollback(Handler<AsyncResult<Void>> handler) { 
    this.delegate.rollback(handler);
    return this;
  }

  /**
   * Rolls back all changes made since the previous commit/rollback.
   * @return 
   */
  public Observable<Void> rollbackObservable() { 
    io.vertx.rx.java.ObservableFuture<Void> handler = io.vertx.rx.java.RxHelper.observableFuture();
    rollback(handler.toHandler());
    return handler;
  }

  /**
   * Attempts to change the transaction isolation level for this Connection object to the one given.
   *
   * The constants defined in the interface Connection are the possible transaction isolation levels.
   * @param isolation the level of isolation
   * @return 
   */
  public SQLConnection setTransactionIsolation(TransactionIsolation isolation) { 
    this.delegate.setTransactionIsolation(isolation);
    return this;
  }

  /**
   * Attempts to return the transaction isolation level for this Connection object to the one given.
   * @return level of isolation
   */
  public TransactionIsolation getTransactionIsolation() { 
    TransactionIsolation ret = this.delegate.getTransactionIsolation();
    return ret;
  }


  public static SQLConnection newInstance(io.vertx.ext.sql.SQLConnection arg) {
    return arg != null ? new SQLConnection(arg) : null;
  }
}
