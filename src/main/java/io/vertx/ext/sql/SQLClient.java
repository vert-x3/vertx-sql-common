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

/**
 * A common asynchronous client interface for interacting with SQL compliant database
 *
 * @author <a href="mailto:emad.albloushi@gmail.com">Emad Alblueshi</a>
 */
@VertxGen
public interface SQLClient extends SQLQuery {

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
  @Override
  default SQLClient query(String sql, Handler<AsyncResult<ResultSet>> handler) {
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
  @Override
  default SQLClient queryWithParams(String sql, JsonArray arguments, Handler<AsyncResult<ResultSet>> handler) {
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
}
