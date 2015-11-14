package io.vertx.ext.sql.impl;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.sql.UpdateResult;

/**
 * Represents the result of an update/insert/delete operation on the database.
 * <p>
 * The number of rows updated is available with {@link UpdateResultImpl#getUpdated} and any generated
 * keys are available with {@link UpdateResultImpl#getKeys}.
 *
 * @author <a href="http://tfox.org">Tim Fox</a>
 */
public class UpdateResultImpl implements UpdateResult {

  private int updated;
  private JsonArray keys;

  /**
   * Default constructor
   */
  public UpdateResultImpl() {
  }

  /**
   * Copy constructor
   *
   * @param other  the result to copy
   */
  public UpdateResultImpl(UpdateResultImpl other) {
    this.updated = other.updated;
    this.keys = other.getKeys();
  }

  /**
   * Constructor from JSON
   *
   * @param json  the json
   */
  @SuppressWarnings("unchecked")
  public UpdateResultImpl(JsonObject json) {
    this.updated = json.getInteger("updated");
    keys = json.getJsonArray("keys");
  }

  /**
   * Constructor
   *
   * @param updated  number of rows updated
   * @param keys  any generated keys
   */
  public UpdateResultImpl(int updated, JsonArray keys) {
    this.updated = updated;
    this.keys = keys;
  }

  /**
   * Convert to JSON
   *
   * @return  the json
   */
  public JsonObject toJson() {
    JsonObject obj = new JsonObject();
    obj.put("updated", updated);
    obj.put("keys", keys);
    return obj;
  }

  /**
   * Get the number of rows updated
   *
   * @return number of rows updated
   */
  public int getUpdated() {
    return updated;
  }

  @Override
  public int updated() {
    return updated;
  }

  /**
   * Get any generated keys
   *
   * @return generated keys
   */
  public JsonArray getKeys() {
    return keys;
  }

  @Override
  public JsonArray keys() {
    return keys;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    UpdateResultImpl that = (UpdateResultImpl) o;

    if (updated != that.updated) return false;
    if (keys != null ? !keys.equals(that.keys) : that.keys != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = updated;
    result = 31 * result + (keys != null ? keys.hashCode() : 0);
    return result;
  }
}
