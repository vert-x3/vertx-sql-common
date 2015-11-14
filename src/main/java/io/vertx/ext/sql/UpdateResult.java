package io.vertx.ext.sql;

import io.vertx.codegen.annotations.VertxGen;
import io.vertx.core.json.JsonArray;
import io.vertx.ext.sql.impl.UpdateResultImpl;

/**
 * Represents the result of an update/insert/delete operation on the database.
 * <p>
 * The number of rows updated is available with {@link io.vertx.ext.sql.UpdateResult#getUpdated} and any generated
 * keys are available with {@link io.vertx.ext.sql.UpdateResult#getKeys}.
 *
 * @author <a href="http://tfox.org">Tim Fox</a>
 */
@VertxGen
public interface UpdateResult {

  static UpdateResult create(int updated, JsonArray keys) {
    return new UpdateResultImpl(updated, keys);
  }

  @Deprecated
  int getUpdated();

  /**
   * Get the number of rows updated
   *
   * @return number of rows updated
   */
  int updated();

  @Deprecated
  JsonArray getKeys();

  /**
   * Get any generated keys
   *
   * @return generated keys
   */
  JsonArray keys();

}
