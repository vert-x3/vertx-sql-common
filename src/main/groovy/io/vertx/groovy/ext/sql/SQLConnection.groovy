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
import java.util.List
import io.vertx.ext.sql.UpdateResult
import io.vertx.ext.sql.ResultSet
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
   * Batch simple SQL strings and execute the batch where the async result contains a array of Integers.
   * @param sqlStatements sql statement
   * @param handler the result handler
   * @return 
   */
  public SQLConnection batch(List<String> sqlStatements, Handler<AsyncResult<List<Integer>>> handler) {
    delegate.batch(sqlStatements != null ? (List)sqlStatements.collect({it}) : null, handler != null ? new Handler<AsyncResult<java.util.List<java.lang.Integer>>>() {
      public void handle(AsyncResult<java.util.List<java.lang.Integer>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(ar.result()));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
    return this;
  }
  /**
   * Batch a prepared statement with all entries from the args list. Each entry is a batch.
   * The operation completes with the execution of the batch where the async result contains a array of Integers.
   * @param sqlStatement sql statement
   * @param args the prepared statement arguments
   * @param handler the result handler
   * @return 
   */
  public SQLConnection batchWithParams(String sqlStatement, List<List<Object>> args, Handler<AsyncResult<List<Integer>>> handler) {
    delegate.batchWithParams(sqlStatement, args != null ? (List)args.collect({new io.vertx.core.json.JsonArray(it)}) : null, handler != null ? new Handler<AsyncResult<java.util.List<java.lang.Integer>>>() {
      public void handle(AsyncResult<java.util.List<java.lang.Integer>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(ar.result()));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
    return this;
  }
  /**
   * Batch a callable statement with all entries from the args list. Each entry is a batch.
   * The size of the lists inArgs and outArgs MUST be the equal.
   * The operation completes with the execution of the batch where the async result contains a array of Integers.
   * @param sqlStatement sql statement
   * @param inArgs the callable statement input arguments
   * @param outArgs the callable statement output arguments
   * @param handler the result handler
   * @return 
   */
  public SQLConnection batchCallableWithParams(String sqlStatement, List<List<Object>> inArgs, List<List<Object>> outArgs, Handler<AsyncResult<List<Integer>>> handler) {
    delegate.batchCallableWithParams(sqlStatement, inArgs != null ? (List)inArgs.collect({new io.vertx.core.json.JsonArray(it)}) : null, outArgs != null ? (List)outArgs.collect({new io.vertx.core.json.JsonArray(it)}) : null, handler != null ? new Handler<AsyncResult<java.util.List<java.lang.Integer>>>() {
      public void handle(AsyncResult<java.util.List<java.lang.Integer>> ar) {
        if (ar.succeeded()) {
          handler.handle(io.vertx.core.Future.succeededFuture(ar.result()));
        } else {
          handler.handle(io.vertx.core.Future.failedFuture(ar.cause()));
        }
      }
    } : null);
    return this;
  }
}
