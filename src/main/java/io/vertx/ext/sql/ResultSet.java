package io.vertx.ext.sql;

import io.vertx.codegen.annotations.VertxGen;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.sql.impl.ResultSetImpl;

import java.util.List;

/**
 * Represents the results of a SQL query.
 * <p>
 * It contains a list for the column names of the results, and a list of {@code JsonArray} - one for each row of the
 * results.
 *
 * @author <a href="http://tfox.org">Tim Fox</a>
 */
@VertxGen
public interface ResultSet {

  static ResultSet create(List<String> columnNames, List<JsonArray> results) {
    return new ResultSetImpl(columnNames, results);
  }

  @Deprecated
  List<JsonArray> getResults();

  /**
   * Get the results
   *
   * @return the results
   */
  List<JsonArray> results();

  @Deprecated
  List<String> getColumnNames();

  /**
   * Get the column names
   *
   * @return the column names
   */
  List<String> columnNames();

  /**
   * Get the rows - each row represented as a JsonObject where the keys are the column names and the values are
   * the column values.
   * <p>
   * Beware that it's legal for a query result in SQL to contain duplicate column names, in which case one will
   * overwrite the other if using this method. If that's the case use {@link #getResults} instead.
   *
   * @return  the rows represented as JSON object instances
   */
  List<JsonObject> getRows();

  /**
   * Return the number of rows in the result set
   *
   * @return the number of rows
   */
  int getNumRows();

  /**
   * Return the number of columns in the result set
   *
   * @return the number of columns
   */
  int getNumColumns();

}
