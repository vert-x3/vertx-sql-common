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
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

import java.util.List;

/**
 * A common asynchronous client interface for interacting with SQL compliant database
 *
 * @author <a href="mailto:emad.albloushi@gmail.com">Emad Alblueshi</a>
 */
@VertxGen
public interface SQLClient {

  /**
   * Returns a connection that can be used to perform SQL operations on. It's important to remember
   * to close the connection when you are done, so it is returned to the pool.
   *
   * @param handler the handler which is called when the <code>JdbcConnection</code> object is ready for use.
   */
  @Fluent
  SQLClient getConnection(Handler<AsyncResult<SQLConnection>> handler);

  /**
   * Close the client and release all resources.
   * Call the handler when close is complete.
   *
   * @param handler the handler that will be called when close is complete
   */
  void close(Handler<AsyncResult<Void>> handler);

  /**
   * Close the client
   */
  void close();

  /**
   * Execute a one shot SQL statement. This method will reduce the boilerplate code by getting a connection from the
   * pool (this object) and return it back after the execution.
   *
   * @param sql     the statement to execute
   * @param handler the result handler
   * @return self
   */
  @Fluent
  default SQLClient execute(String sql, Handler<AsyncResult<ResultSet>> handler) {
    getConnection(getConnection -> {
      if (getConnection.failed()) {
        handler.handle(Future.failedFuture(getConnection.cause()));
      } else {
        final SQLConnection conn = getConnection.result();

        conn.query(sql, query -> {
          if (query.failed()) {
            conn.close(close -> {
              if (close.failed()) {
                handler.handle(Future.failedFuture(close.cause()));
              } else {
                handler.handle(Future.failedFuture(query.cause()));
              }
            });
          } else {
            conn.close(close -> {
              if (close.failed()) {
                handler.handle(Future.failedFuture(close.cause()));
              } else {
                handler.handle(Future.succeededFuture(query.result()));
              }
            });
          }
        });
      }
    });
    return this;
  }

  /**
   * Execute a one shot SQL statement with arguments. This method will reduce the boilerplate code by getting a
   * connection from the pool (this object) and return it back after the execution.
   *
   * @param sql       the statement to execute
   * @param arguments the arguments to the statement
   * @param handler   the result handler
   * @return self
   */
  @Fluent
  default SQLClient execute(String sql, JsonArray arguments, Handler<AsyncResult<ResultSet>> handler) {
    getConnection(getConnection -> {
      if (getConnection.failed()) {
        handler.handle(Future.failedFuture(getConnection.cause()));
      } else {
        final SQLConnection conn = getConnection.result();

        conn.queryWithParams(sql, arguments, query -> {
          if (query.failed()) {
            conn.close(close -> {
              if (close.failed()) {
                handler.handle(Future.failedFuture(close.cause()));
              } else {
                handler.handle(Future.failedFuture(query.cause()));
              }
            });
          } else {
            conn.close(close -> {
              if (close.failed()) {
                handler.handle(Future.failedFuture(close.cause()));
              } else {
                handler.handle(Future.succeededFuture(query.result()));
              }
            });
          }
        });
      }
    });
    return this;
  }

  /**
   * Execute a one shot SQL statement that returns a single SQL row. This method will reduce the boilerplate code by
   * getting a connection from the pool (this object) and return it back after the execution. Only the first result
   * from the result set is returned.
   *
   * @param sql     the statement to execute
   * @param handler the result handler
   * @return self
   */
  @Fluent
  default SQLClient executeSingle(String sql, Handler<AsyncResult<JsonArray>> handler) {
    return execute(sql, execute -> {
      if (execute.failed()) {
        handler.handle(Future.failedFuture(execute.cause()));
      } else {
        final ResultSet rs = execute.result();
        if (rs == null) {
          handler.handle(Future.succeededFuture());
        } else {
          List<JsonArray> results = rs.getResults();
          if (results == null) {
            handler.handle(Future.succeededFuture());
          } else {
            handler.handle(Future.succeededFuture(results.get(0)));
          }
        }
      }
    });
  }

  /**
   * Execute a one shot SQL statement with arguments that returns a single SQL row. This method will reduce the
   * boilerplate code by getting a connection from the pool (this object) and return it back after the execution.
   * Only the first result from the result set is returned.
   *
   * @param sql       the statement to execute
   * @param arguments the arguments
   * @param handler   the result handler
   * @return self
   */
  @Fluent
  default SQLClient executeSingle(String sql, JsonArray arguments, Handler<AsyncResult<JsonArray>> handler) {
    return execute(sql, arguments, execute -> {
      if (execute.failed()) {
        handler.handle(Future.failedFuture(execute.cause()));
      } else {
        final ResultSet rs = execute.result();
        if (rs == null) {
          handler.handle(Future.succeededFuture());
        } else {
          List<JsonArray> results = rs.getResults();
          if (results == null) {
            handler.handle(Future.succeededFuture());
          } else {
            handler.handle(Future.succeededFuture(results.get(0)));
          }
        }
      }
    });
  }

  /**
   * Execute a one shot SQL statement that returns a single SQL row with column names. This method will reduce the
   * boilerplate code by getting a connection from the pool (this object) and return it back after the execution.
   * Only the first result from the result set is returned.
   *
   * @param sql                    the statement to execute
   * @param caseInsensitiveColumns return a case insensitive JSON
   * @param handler                the result handler
   * @return self
   */
  @Fluent
  default SQLClient executeSingleRow(String sql, boolean caseInsensitiveColumns, Handler<AsyncResult<JsonObject>> handler) {
    return execute(sql, execute -> {
      if (execute.failed()) {
        handler.handle(Future.failedFuture(execute.cause()));
      } else {
        final ResultSet rs = execute.result();
        if (rs == null) {
          handler.handle(Future.succeededFuture());
        } else {
          List<JsonObject> results = rs.getRows(caseInsensitiveColumns);
          if (results == null) {
            handler.handle(Future.succeededFuture());
          } else {
            handler.handle(Future.succeededFuture(results.get(0)));
          }
        }
      }
    });
  }

  /**
   * Execute a one shot SQL statement that returns a single SQL row with column names. This method will reduce the
   * boilerplate code by getting a connection from the pool (this object) and return it back after the execution.
   * Only the first result from the result set is returned.
   *
   * @param sql     the statement to execute
   * @param handler the result handler
   * @return self
   */
  @Fluent
  default SQLClient executeSingleRow(String sql, Handler<AsyncResult<JsonObject>> handler) {
    return executeSingleRow(sql, false, handler);
  }

  /**
   * Execute a one shot SQL statement that returns a single SQL row with column names. This method will reduce the
   * boilerplate code by getting a connection from the pool (this object) and return it back after the execution.
   * Only the first result from the result set is returned.
   *
   * @param sql       the statement to execute
   * @param arguments the arguments to the query
   * @param caseInsensitiveColumns return a case insensitive JSON
   * @param handler   the result handler
   * @return self
   */
  @Fluent
  default SQLClient executeSingleRow(String sql, JsonArray arguments, boolean caseInsensitiveColumns, Handler<AsyncResult<JsonObject>> handler) {
    return execute(sql, arguments, execute -> {
      if (execute.failed()) {
        handler.handle(Future.failedFuture(execute.cause()));
      } else {
        final ResultSet rs = execute.result();
        if (rs == null) {
          handler.handle(Future.succeededFuture());
        } else {
          List<JsonObject> results = rs.getRows(caseInsensitiveColumns);
          if (results == null) {
            handler.handle(Future.succeededFuture());
          } else {
            handler.handle(Future.succeededFuture(results.get(0)));
          }
        }
      }
    });
  }

  /**
   * Execute a one shot SQL statement that returns a single SQL row with column names. This method will reduce the
   * boilerplate code by getting a connection from the pool (this object) and return it back after the execution.
   * Only the first result from the result set is returned.
   *
   * @param sql       the statement to execute
   * @param arguments the arguments to the query
   * @param handler   the result handler
   * @return self
   */
  @Fluent
  default SQLClient executeSingleRow(String sql, JsonArray arguments, Handler<AsyncResult<JsonObject>> handler) {
    return executeSingleRow(sql, arguments, false, handler);
  }
}
