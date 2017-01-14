package io.vertx.ext.sql;

import io.vertx.codegen.annotations.VertxGen;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonArray;
import io.vertx.core.spi.concurrent.CompletableStage;
import io.vertx.core.streams.ReadStream;

import java.util.concurrent.CompletionStage;

/**
 * A ReadStream of Rows from the underlying RDBMS. This class follows the ReadStream semantics and will automatically
 * close the underlying resources if all returned rows are returned. For cases where the results are ignored before the
 * full processing of the returned rows is complete the close method **MUST** be called in order to release underlying
 * resources.
 *
 * The interface is minimal in order to support all SQL clients not just JDBC.
 */
@VertxGen
public interface SQLRowStream extends ReadStream<JsonArray> {

  /**
   * Will convert the column name to the json array index.
   *
   * @param name the column name
   * @return the json array index
   */
  int column(String name);

  /**
   * Event handler when a resultset is closed. This is useful to request for more results.
   * @param handler
   */
  SQLRowStream resultSetClosedHandler(Handler<Void> handler);

  /**
   * Request for more results if available
   */
  void moreResults();

  /**
   * Closes the stream/underlying cursor(s). The actual close happens asynchronously.
   */
  default CompletionStage<Void> close() {
    CompletableStage<Void> fut = CompletableStage.create();
    close(fut);
    return fut;
  }

  /**
   * Closes the stream/underlying cursor(s). The actual close happens asynchronously.
   *
   * @param handler called when the stream/underlying cursor(s) is(are) closed
   */
  void close(Handler<AsyncResult<Void>> handler);
}
