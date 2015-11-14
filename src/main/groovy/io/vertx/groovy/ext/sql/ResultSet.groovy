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
import java.util.List
import io.vertx.core.json.JsonObject
/**
 * Represents the results of a SQL query.
 * <p>
 * It contains a list for the column names of the results, and a list of <code>JsonArray</code> - one for each row of the
 * results.
*/
@CompileStatic
public class ResultSet {
  private final def io.vertx.ext.sql.ResultSet delegate;
  public ResultSet(Object delegate) {
    this.delegate = (io.vertx.ext.sql.ResultSet) delegate;
  }
  public Object getDelegate() {
    return delegate;
  }
  public static ResultSet create(List<String> columnNames, List<List<Object>> results) {
    def ret= InternalHelper.safeCreate(io.vertx.ext.sql.ResultSet.create(columnNames, results.collect({underpants -> new JsonArray(underpants)})), io.vertx.groovy.ext.sql.ResultSet.class);
    return ret;
  }
  public List<List<Object>> getResults() {
    def ret = this.delegate.getResults()?.collect({underpants -> InternalHelper.wrapObject(underpants)});
    return ret;
  }
  /**
   * Get the results
   * @return the results
   */
  public List<List<Object>> results() {
    def ret = this.delegate.results()?.collect({underpants -> InternalHelper.wrapObject(underpants)});
    return ret;
  }
  public List<String> getColumnNames() {
    def ret = this.delegate.getColumnNames();
    return ret;
  }
  /**
   * Get the column names
   * @return the column names
   */
  public List<String> columnNames() {
    def ret = this.delegate.columnNames();
    return ret;
  }
  public List<Map<String, Object>> getRows() {
    def ret = this.delegate.getRows()?.collect({underpants -> InternalHelper.wrapObject(underpants)});
    return ret;
  }
  /**
   * Get the rows - each row represented as a JsonObject where the keys are the column names and the values are
   * the column values.
   * <p>
   * Beware that it's legal for a query result in SQL to contain duplicate column names, in which case one will
   * overwrite the other if using this method. If that's the case use {@link io.vertx.groovy.ext.sql.ResultSet#getResults} instead.
   * @return the rows represented as JSON object instances
   */
  public List<Map<String, Object>> rows() {
    def ret = this.delegate.rows()?.collect({underpants -> InternalHelper.wrapObject(underpants)});
    return ret;
  }
  public int getNumRows() {
    def ret = this.delegate.getNumRows();
    return ret;
  }
  /**
   * Return the number of rows in the result set
   * @return the number of rows
   */
  public int numRows() {
    def ret = this.delegate.numRows();
    return ret;
  }
  public int getNumColumns() {
    def ret = this.delegate.getNumColumns();
    return ret;
  }
  /**
   * Return the number of columns in the result set
   * @return the number of columns
   */
  public int numColumns() {
    def ret = this.delegate.numColumns();
    return ret;
  }
}
