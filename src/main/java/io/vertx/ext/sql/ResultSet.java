package io.vertx.ext.sql;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

import java.util.List;

/**
 * Represents the results of a SQL query.
 * <p>
 * It contains a list for the column names of the results, and a list of {@code JsonArray} - one for each row of the
 * results.
 *
 * @author <a href="http://tfox.org">Tim Fox</a>
 */
@DataObject
public class ResultSet {

  private List<String> columnNames;
  private List<JsonArray> results;

  /**
   * Default constructor
   */
  public ResultSet() {
  }

  /**
   * Copy constructor
   *
   * @param other  result-set to copy
   */
  public ResultSet(ResultSet other) {
    this.columnNames = other.columnNames;
    this.results = other.results;
  }

  /**
   * Create a result-set
   *
   * @param columnNames  the column names
   * @param results  the results
   */
  public ResultSet(List<String> columnNames, List<JsonArray> results) {
    this.columnNames = columnNames;
    this.results = results;
  }

  /**
   * Create a result-set from JSON
   *
   * @param json  the json
   */
  @SuppressWarnings("unchecked")
  public ResultSet(JsonObject json) {
    JsonArray arr = json.getJsonArray("columnNames");
    if (arr != null) {
      this.columnNames = arr.getList();
    }
    arr = json.getJsonArray("results");
    if (arr != null) {
      results = arr.getList();
    }
  }

  /**
   * Convert to JSON
   *
   * @return json object
   */
  public JsonObject toJson() {
    JsonObject obj = new JsonObject();
    obj.put("columnNames", new JsonArray(columnNames));
    obj.put("results", new JsonArray(results));
    return obj;
  }

  /**
   * Get the results
   *
   * @return the results
   */
  public List<JsonArray> getResults() {
    return results;
  }

  /**
   * Get the column names
   *
   * @return the column names
   */
  public List<String> getColumnNames() {
    return columnNames;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ResultSet resultSet = (ResultSet) o;

    if (columnNames != null ? !columnNames.equals(resultSet.columnNames) : resultSet.columnNames != null) return false;
    if (results != null ? !results.equals(resultSet.results) : resultSet.results != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = columnNames != null ? columnNames.hashCode() : 0;
    result = 31 * result + (results != null ? results.hashCode() : 0);
    return result;
  }
}
