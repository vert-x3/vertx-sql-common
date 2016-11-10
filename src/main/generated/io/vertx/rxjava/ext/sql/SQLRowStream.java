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
import rx.Observable;
import io.vertx.core.json.JsonArray;
import io.vertx.rxjava.core.streams.ReadStream;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;

/**
 * A ReadStream of Rows from the underlying RDBMS. This class follows the ReadStream semantics and will automatically
 * close the underlying resources if all returned rows are returned. For cases where the results are ignored before the
 * full processing of the returned rows is complete the close method **MUST** be called in order to release underlying
 * resources.
 *
 * The interface is minimal in order to support all SQL clients not just JDBC.
 *
 * <p/>
 * NOTE: This class has been automatically generated from the {@link io.vertx.ext.sql.SQLRowStream original} non RX-ified interface using Vert.x codegen.
 */

public class SQLRowStream implements ReadStream<JsonArray> {

  final io.vertx.ext.sql.SQLRowStream delegate;

  public SQLRowStream(io.vertx.ext.sql.SQLRowStream delegate) {
    this.delegate = delegate;
  }

  public Object getDelegate() {
    return delegate;
  }

  private rx.Observable<JsonArray> observable;

  public synchronized rx.Observable<JsonArray> toObservable() {
    if (observable == null) {
      observable = io.vertx.rx.java.RxHelper.toObservable((io.vertx.core.streams.ReadStream<io.vertx.core.json.JsonArray>) this.getDelegate());
    }
    return observable;
  }

  public ReadStream<JsonArray> exceptionHandler(Handler<Throwable> arg0) { 
    ((io.vertx.core.streams.StreamBase) delegate).exceptionHandler(arg0);
    return this;
  }

  public ReadStream<JsonArray> handler(Handler<JsonArray> arg0) { 
    delegate.handler(arg0);
    return this;
  }

  public ReadStream<JsonArray> pause() { 
    delegate.pause();
    return this;
  }

  public ReadStream<JsonArray> resume() { 
    delegate.resume();
    return this;
  }

  public ReadStream<JsonArray> endHandler(Handler<Void> arg0) { 
    delegate.endHandler(arg0);
    return this;
  }

  /**
   * Will convert the column name to the json array index
   * @param name 
   * @return 
   */
  public int column(String name) { 
    int ret = delegate.column(name);
    return ret;
  }

  /**
   * Closes the stream/underlying cursor(s)
   * @param handler 
   */
  public void close(Handler<AsyncResult<Void>> handler) { 
    delegate.close(handler);
  }

  /**
   * Closes the stream/underlying cursor(s)
   * @return 
   */
  public Observable<Void> closeObservable() { 
    io.vertx.rx.java.ObservableFuture<Void> handler = io.vertx.rx.java.RxHelper.observableFuture();
    close(handler.toHandler());
    return handler;
  }


  public static SQLRowStream newInstance(io.vertx.ext.sql.SQLRowStream arg) {
    return arg != null ? new SQLRowStream(arg) : null;
  }
}
