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

/**
 * Represents the result of an update/insert/delete operation on the database.
 * <p>
 * The number of rows updated is available with {@link io.vertx.rxjava.ext.sql.UpdateResult#getUpdated} and any generated
 * keys are available with {@link io.vertx.rxjava.ext.sql.UpdateResult#getKeys}.
 *
 * <p/>
 * NOTE: This class has been automatically generated from the {@link io.vertx.ext.sql.UpdateResult original} non RX-ified interface using Vert.x codegen.
 */

public class UpdateResult {

  final io.vertx.ext.sql.UpdateResult delegate;

  public UpdateResult(io.vertx.ext.sql.UpdateResult delegate) {
    this.delegate = delegate;
  }

  public Object getDelegate() {
    return delegate;
  }

  public static UpdateResult create(int updated, JsonArray keys) { 
    UpdateResult ret= UpdateResult.newInstance(io.vertx.ext.sql.UpdateResult.create(updated, keys));
    return ret;
  }

  public int getUpdated() { 
    int ret = this.delegate.getUpdated();
    return ret;
  }

  /**
   * Get the number of rows updated
   * @return number of rows updated
   */
  public int updated() { 
    int ret = this.delegate.updated();
    return ret;
  }

  public JsonArray getKeys() { 
    JsonArray ret = this.delegate.getKeys();
    return ret;
  }

  /**
   * Get any generated keys
   * @return generated keys
   */
  public JsonArray keys() { 
    JsonArray ret = this.delegate.keys();
    return ret;
  }


  public static UpdateResult newInstance(io.vertx.ext.sql.UpdateResult arg) {
    return arg != null ? new UpdateResult(arg) : null;
  }
}
