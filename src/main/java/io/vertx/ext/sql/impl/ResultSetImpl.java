package io.vertx.ext.sql.impl;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the results of a SQL query.
 * <p>
 * It contains a list for the column names of the results, and a list of {@code JsonArray} - one for each row of the
 * results.
 *
 * @author <a href="http://tfox.org">Tim Fox</a>
 */
public class ResultSetImpl implements ResultSet {

  private List<String> columnNames;
  private List<JsonArray> results;
  private List<JsonObject> rows;

  /**
   * Default constructor
   */
  public ResultSetImpl() {
  }

  /**
   * Copy constructor
   *
   * @param other  result-set to copy
   */
  public ResultSetImpl(ResultSetImpl other) {
    this.columnNames = other.columnNames;
    this.results = other.results;
  }

  /**
   * Create a result-set
   *
   * @param columnNames  the column names
   * @param results  the results
   */
  public ResultSetImpl(List<String> columnNames, List<JsonArray> results) {
    this.columnNames = columnNames;
    this.results = results;
  }

  /**
   * Create a result-set from JSON
   *
   * @param json  the json
   */
  @SuppressWarnings("unchecked")
  public ResultSetImpl(JsonObject json) {
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

  @Override
  public List<JsonArray> results() {
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
  public List<String> columnNames() {
    return columnNames;
  }

  /**
   * Get the rows - each row represented as a JsonObject where the keys are the column names and the values are
   * the column values.
   * <p>
   * Beware that it's legal for a query result in SQL to contain duplicate column names, in which case one will
   * overwrite the other if using this method. If that's the case use {@link #getResults} instead.
   *
   * @return  the rows represented as JSON object instances
   */
  public List<JsonObject> getRows() {
    if (rows == null) {
      rows = new ArrayList<>(results.size());
      int cols = columnNames.size();
      for (JsonArray result: results) {
        JsonObject row = new JsonObject();
        for (int i = 0; i < cols; i++) {
          row.put(columnNames.get(i), result.getValue(i));
        }
        rows.add(row);
      }
    }
    return rows;
  }

  /**
   * Return the number of rows in the result set
   *
   * @return the number of rows
   */
  public int getNumRows() {
    return results.size();
  }

  /**
   * Return the number of columns in the result set
   *
   * @return the number of columns
   */
  public int getNumColumns() {
    return columnNames.size();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ResultSetImpl resultSet = (ResultSetImpl) o;

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
