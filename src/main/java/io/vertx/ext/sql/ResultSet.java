package io.vertx.ext.sql;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

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
@DataObject(generateConverter = true)
public class ResultSet {

  private List<String> columnNames;
  private List<JsonArray> results;
  private List<JsonObject> rows;
  private JsonArray output;
  // chainned result sets
  private ResultSet next;

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
    this.output = other.output;
    this.next = other.next;
  }

  /**
   * Create a result-set
   *
   * @param columnNames  the column names
   * @param results  the results
   */
  public ResultSet(List<String> columnNames, List<JsonArray> results, ResultSet next) {
    this.columnNames = columnNames;
    this.results = results;
    this.next = next;
  }

  /**
   * Create a result-set from JSON
   *
   * @param json  the json
   */
  @SuppressWarnings("unchecked")
  public ResultSet(JsonObject json) {
    ResultSetConverter.fromJson(json, this);
  }

  /**
   * Convert to JSON
   *
   * @return json object
   */
  public JsonObject toJson() {
    JsonObject obj = new JsonObject();
    ResultSetConverter.toJson(this, obj);
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

  public ResultSet setResults(List<JsonArray> results) {
    this.results = results;
    return this;
  }

  /**
   * Get the registered outputs
   *
   * @return the outputs
   */
  public JsonArray getOutput() {
    return output;
  }

  public ResultSet setOutput(JsonArray output) {
    this.output = output;
    return this;
  }

  /**
   * Get the column names
   *
   * @return the column names
   */
  public List<String> getColumnNames() {
    return columnNames;
  }

  public ResultSet setColumnNames(List<String> columnNames) {
    this.columnNames = columnNames;
    return this;
  }

  /**
   * Get the next result set
   *
   * @return the next resultset
   */
  public ResultSet getNext() {
    return next;
  }

  public ResultSet setNext(ResultSet next) {
    this.next = next;
    return this;
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

    ResultSet resultSet = (ResultSet) o;

    if (columnNames != null ? !columnNames.equals(resultSet.columnNames) : resultSet.columnNames != null) return false;
    if (results != null ? !results.equals(resultSet.results) : resultSet.results != null) return false;
    if (next != null ? !next.equals(resultSet.next) : resultSet.next != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = columnNames != null ? columnNames.hashCode() : 0;
    result = 31 * result + (results != null ? results.hashCode() : 0);
    result = 31 * result + (next != null ? next.hashCode() : 0);
    return result;
  }
}
