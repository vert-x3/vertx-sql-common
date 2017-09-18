package io.vertx.ext.sql;

import io.vertx.codegen.annotations.Fluent;
import io.vertx.codegen.annotations.VertxGen;
import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonArray;

import java.util.List;

/**
 * Represents a SQL query interface to a database
 *
 * @author <a href="mailto:plopes@redhat.com">Paulo Lopes</a>
 */
@VertxGen(concrete = false)
public interface SQLQuery {

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
  SQLQuery query(String sql, Handler<AsyncResult<ResultSet>> resultHandler);

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
  SQLQuery queryWithParams(String sql, JsonArray params, Handler<AsyncResult<ResultSet>> resultHandler);

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
  default SQLQuery querySingle(String sql, Handler<AsyncResult<JsonArray>> handler) {
    return query(sql, execute -> {
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
  default SQLQuery querySingleWithParams(String sql, JsonArray arguments, Handler<AsyncResult<JsonArray>> handler) {
    return queryWithParams(sql, arguments, execute -> {
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
}
