package io.vertx.ext.sql;

import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonArray;

import java.util.List;

/**
 * @author <a href="mailto:ruslan.sennov@gmail.com">Ruslan Sennov</a>
 */
class RowStreamWrapper implements SQLRowStream {

  private final SQLConnection connection;
  private final SQLRowStream rowStream;

  RowStreamWrapper(SQLConnection connection, SQLRowStream rowStream) {
    this.connection = connection;
    this.rowStream = rowStream;
  }

  private void closeConnection(Handler<AsyncResult<Void>> handler) {
    connection.close(handler);
  }

  @Override
  public SQLRowStream exceptionHandler(Handler<Throwable> handler) {
    rowStream.exceptionHandler(h1 -> closeConnection(h2 -> handler.handle(h1)));
    return this;
  }

  @Override
  public SQLRowStream handler(Handler<JsonArray> handler) {
    rowStream.handler(handler);
    return this;
  }

  @Override
  public SQLRowStream pause() {
    rowStream.pause();
    return this;
  }

  @Override
  public SQLRowStream resume() {
    rowStream.resume();
    return this;
  }

  @Override
  public SQLRowStream endHandler(Handler<Void> endHandler) {
    rowStream.endHandler(h1 -> closeConnection(h2 -> endHandler.handle(h1)));
    return this;
  }

  @Override
  public int column(String name) {
    return rowStream.column(name);
  }

  @Override
  public List<String> columns() {
    return rowStream.columns();
  }

  @Override
  public SQLRowStream resultSetClosedHandler(Handler<Void> handler) {
    rowStream.resultSetClosedHandler(handler);
    return this;
  }

  @Override
  public void moreResults() {
    rowStream.moreResults();
  }

  @Override
  public void close() {
    rowStream.close();
  }

  @Override
  public void close(Handler<AsyncResult<Void>> handler) {
    rowStream.close(h1 -> closeConnection(h2 -> handler.handle(h1)));
  }
}
