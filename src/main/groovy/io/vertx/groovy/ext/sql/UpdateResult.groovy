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
/**
 * Represents the result of an update/insert/delete operation on the database.
 * <p>
 * The number of rows updated is available with {@link io.vertx.groovy.ext.sql.UpdateResult#getUpdated} and any generated
 * keys are available with {@link io.vertx.groovy.ext.sql.UpdateResult#getKeys}.
*/
@CompileStatic
public class UpdateResult {
  private final def io.vertx.ext.sql.UpdateResult delegate;
  public UpdateResult(Object delegate) {
    this.delegate = (io.vertx.ext.sql.UpdateResult) delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  public static UpdateResult create(int updated, List<Object> keys) {
    def ret= InternalHelper.safeCreate(io.vertx.ext.sql.UpdateResult.create(updated, keys != null ? new io.vertx.core.json.JsonArray(keys) : null), io.vertx.groovy.ext.sql.UpdateResult.class);
    return ret;
  }
  public int getUpdated() {
    def ret = this.delegate.getUpdated();
    return ret;
  }
  /**
   * Get the number of rows updated
   * @return number of rows updated
   */
  public int updated() {
    def ret = this.delegate.updated();
    return ret;
  }
  public List<Object> getKeys() {
    def ret = (List<Object>)InternalHelper.wrapObject(this.delegate.getKeys());
    return ret;
  }
  /**
   * Get any generated keys
   * @return generated keys
   */
  public List<Object> keys() {
    def ret = (List<Object>)InternalHelper.wrapObject(this.delegate.keys());
    return ret;
  }
}
