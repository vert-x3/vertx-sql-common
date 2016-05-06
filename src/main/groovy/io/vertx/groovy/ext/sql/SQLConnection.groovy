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

package io.vertx.groovy.ext.sql;
import groovy.transform.CompileStatic
import io.vertx.lang.groovy.InternalHelper
import io.vertx.core.json.JsonObject
import io.vertx.core.json.JsonArray
import io.vertx.ext.sql.UpdateResult
import io.vertx.ext.sql.ResultSet
import io.vertx.ext.sql.TransactionIsolation
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
/**
 * Represents a connection to a SQL database
*/
@CompileStatic
public class SQLConnection {
  private final def io.vertx.ext.sql.SQLConnection delegate;
  public SQLConnection(Object delegate) {
    this.delegate = (io.vertx.ext.sql.SQLConnection) delegate;
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
    delegate.setAutoCommit(autoCommit, resultHandler);
    return this;
  }
  /**
   * Executes the given SQL statement
   * @param sql the SQL to execute. For example <code>CREATE TABLE IF EXISTS table ...</code>
   * @param resultHandler the handler which is called once this operation completes.
   * @return 
   */
  public SQLConnection execute(String sql, Handler<AsyncResult<Void>> resultHandler) {
    delegate.execute(sql, resultHandler);
    return this;
  }
  /**
   * Executes the given SQL <code>SELECT</code> statement which returns the results of the query.
   * @param sql the SQL to execute. For example <code>SELECT * FROM table ...</code>.
   * @param resultHandler the handler which is called once the operation completes. It will return a <code>ResultSet</code>.
   * @return 
   */
  public SQLConnection query(String sql, Handler<AsyncResult<Map<String, Object>>> resultHandler) {
    delegate.query(sql, resultHandler != null ? new Handler<AsyncResult<io.vertx.ext.sql.ResultSet>>() {
      public void handle(AsyncResult<io.vertx.ext.sql.ResultSet> ar) {
        if (ar.succeeded()) {
          resultHandler.handle(io.vertx.core.Future.succeededFuture((Map<String, Object>)InternalHelper.wrapObject(ar.result()?.toJson())));
        } else {
          resultHandler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
    return this;
  }
  /**
   * Executes the given SQL <code>SELECT</code> prepared statement which returns the results of the query.
   * @param sql the SQL to execute. For example <code>SELECT * FROM table ...</code>.
   * @param params these are the parameters to fill the statement.
   * @param resultHandler the handler which is called once the operation completes. It will return a <code>ResultSet</code>.
   * @return 
   */
  public SQLConnection queryWithParams(String sql, List<Object> params, Handler<AsyncResult<Map<String, Object>>> resultHandler) {
    delegate.queryWithParams(sql, params != null ? new io.vertx.core.json.JsonArray(params) : null, resultHandler != null ? new Handler<AsyncResult<io.vertx.ext.sql.ResultSet>>() {
      public void handle(AsyncResult<io.vertx.ext.sql.ResultSet> ar) {
        if (ar.succeeded()) {
          resultHandler.handle(io.vertx.core.Future.succeededFuture((Map<String, Object>)InternalHelper.wrapObject(ar.result()?.toJson())));
        } else {
          resultHandler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
    return this;
  }
  /**
   * Executes the given SQL statement which may be an <code>INSERT</code>, <code>UPDATE</code>, or <code>DELETE</code>
   * statement.
   * @param sql the SQL to execute. For example <code>INSERT INTO table ...</code>
   * @param resultHandler the handler which is called once the operation completes.
   * @return 
   */
  public SQLConnection update(String sql, Handler<AsyncResult<Map<String, Object>>> resultHandler) {
    delegate.update(sql, resultHandler != null ? new Handler<AsyncResult<io.vertx.ext.sql.UpdateResult>>() {
      public void handle(AsyncResult<io.vertx.ext.sql.UpdateResult> ar) {
        if (ar.succeeded()) {
          resultHandler.handle(io.vertx.core.Future.succeededFuture((Map<String, Object>)InternalHelper.wrapObject(ar.result()?.toJson())));
        } else {
          resultHandler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
    return this;
  }
  /**
   * Executes the given prepared statement which may be an <code>INSERT</code>, <code>UPDATE</code>, or <code>DELETE</code>
   * statement with the given parameters
   * @param sql the SQL to execute. For example <code>INSERT INTO table ...</code>
   * @param params these are the parameters to fill the statement.
   * @param resultHandler the handler which is called once the operation completes.
   * @return 
   */
  public SQLConnection updateWithParams(String sql, List<Object> params, Handler<AsyncResult<Map<String, Object>>> resultHandler) {
    delegate.updateWithParams(sql, params != null ? new io.vertx.core.json.JsonArray(params) : null, resultHandler != null ? new Handler<AsyncResult<io.vertx.ext.sql.UpdateResult>>() {
      public void handle(AsyncResult<io.vertx.ext.sql.UpdateResult> ar) {
        if (ar.succeeded()) {
          resultHandler.handle(io.vertx.core.Future.succeededFuture((Map<String, Object>)InternalHelper.wrapObject(ar.result()?.toJson())));
        } else {
          resultHandler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
    return this;
  }
  /**
   * Calls the given SQL <code>PROCEDURE</code> which returns the result from the procedure.
   * @param sql the SQL to execute. For example <code>{call getEmpName (?, ?)}</code>.
   * @param resultHandler the handler which is called once the operation completes. It will return a <code>ResultSet</code>.
   * @return 
   */
  public SQLConnection call(String sql, Handler<AsyncResult<Map<String, Object>>> resultHandler) {
    delegate.call(sql, resultHandler != null ? new Handler<AsyncResult<io.vertx.ext.sql.ResultSet>>() {
      public void handle(AsyncResult<io.vertx.ext.sql.ResultSet> ar) {
        if (ar.succeeded()) {
          resultHandler.handle(io.vertx.core.Future.succeededFuture((Map<String, Object>)InternalHelper.wrapObject(ar.result()?.toJson())));
        } else {
          resultHandler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
    return this;
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
   * @param sql the SQL to execute. For example <code>{call getEmpName (?, ?)}</code>.
   * @param params these are the parameters to fill the statement.
   * @param outputs these are the outputs to fill the statement.
   * @param resultHandler the handler which is called once the operation completes. It will return a <code>ResultSet</code>.
   * @return 
   */
  public SQLConnection callWithParams(String sql, List<Object> params, List<Object> outputs, Handler<AsyncResult<Map<String, Object>>> resultHandler) {
    delegate.callWithParams(sql, params != null ? new io.vertx.core.json.JsonArray(params) : null, outputs != null ? new io.vertx.core.json.JsonArray(outputs) : null, resultHandler != null ? new Handler<AsyncResult<io.vertx.ext.sql.ResultSet>>() {
      public void handle(AsyncResult<io.vertx.ext.sql.ResultSet> ar) {
        if (ar.succeeded()) {
          resultHandler.handle(io.vertx.core.Future.succeededFuture((Map<String, Object>)InternalHelper.wrapObject(ar.result()?.toJson())));
        } else {
          resultHandler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
    return this;
  }
  /**
   * Closes the connection. Important to always close the connection when you are done so it's returned to the pool.
   * @param handler the handler called when this operation completes.
   */
  public void close(Handler<AsyncResult<Void>> handler) {
    delegate.close(handler);
  }
  /**
   * Closes the connection. Important to always close the connection when you are done so it's returned to the pool.
   */
  public void close() {
    delegate.close();
  }
  /**
   * Commits all changes made since the previous commit/rollback.
   * @param handler the handler called when this operation completes.
   * @return 
   */
  public SQLConnection commit(Handler<AsyncResult<Void>> handler) {
    delegate.commit(handler);
    return this;
  }
  /**
   * Rolls back all changes made since the previous commit/rollback.
   * @param handler the handler called when this operation completes.
   * @return 
   */
  public SQLConnection rollback(Handler<AsyncResult<Void>> handler) {
    delegate.rollback(handler);
    return this;
  }
  /**
   * Sets a connection wide query timeout.
   *
   * It can be over written at any time and becomes active on the next query call.
   * @param timeoutInSeconds the max amount of seconds the query can take to execute.
   * @return 
   */
  public SQLConnection setQueryTimeout(int timeoutInSeconds) {
    delegate.setQueryTimeout(timeoutInSeconds);
    return this;
  }
  /**
   * Attempts to change the transaction isolation level for this Connection object to the one given.
   *
   * The constants defined in the interface Connection are the possible transaction isolation levels.
   * @param isolation the level of isolation
   * @param handler the handler called when this operation completes.
   * @return 
   */
  public SQLConnection setTransactionIsolation(TransactionIsolation isolation, Handler<AsyncResult<Void>> handler) {
    delegate.setTransactionIsolation(isolation, handler);
    return this;
  }
  /**
   * Attempts to return the transaction isolation level for this Connection object to the one given.
   * @param handler the handler called when this operation completes.
   * @return 
   */
  public SQLConnection getTransactionIsolation(Handler<AsyncResult<TransactionIsolation>> handler) {
    delegate.getTransactionIsolation(handler);
    return this;
  }
}
