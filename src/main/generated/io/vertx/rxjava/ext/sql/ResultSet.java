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
import java.util.List;
import io.vertx.core.json.JsonObject;

/**
 * Represents the results of a SQL query.
 * <p>
 * It contains a list for the column names of the results, and a list of <code>JsonArray</code> - one for each row of the
 * results.
 *
 * <p/>
 * NOTE: This class has been automatically generated from the {@link io.vertx.ext.sql.ResultSet original} non RX-ified interface using Vert.x codegen.
 */

public class ResultSet {

  final io.vertx.ext.sql.ResultSet delegate;

  public ResultSet(io.vertx.ext.sql.ResultSet delegate) {
    this.delegate = delegate;
  }

  public Object getDelegate() {
    return delegate;
  }

  public static ResultSet create(List<String> columnNames, List<JsonArray> results) { 
    ResultSet ret= ResultSet.newInstance(io.vertx.ext.sql.ResultSet.create(columnNames, results));
    return ret;
  }

  public List<JsonArray> getResults() { 
    List<JsonArray> ret = this.delegate.getResults();
;
    return ret;
  }

  /**
   * Get the results
   * @return the results
   */
  public List<JsonArray> results() { 
    List<JsonArray> ret = this.delegate.results();
;
    return ret;
  }

  public List<String> getColumnNames() { 
    List<String> ret = this.delegate.getColumnNames();
;
    return ret;
  }

  /**
   * Get the column names
   * @return the column names
   */
  public List<String> columnNames() { 
    List<String> ret = this.delegate.columnNames();
;
    return ret;
  }

  public List<JsonObject> getRows() { 
    List<JsonObject> ret = this.delegate.getRows();
;
    return ret;
  }

  /**
   * Get the rows - each row represented as a JsonObject where the keys are the column names and the values are
   * the column values.
   * <p>
   * Beware that it's legal for a query result in SQL to contain duplicate column names, in which case one will
   * overwrite the other if using this method. If that's the case use {@link io.vertx.ext.sql.ResultSet} instead.
   * @return the rows represented as JSON object instances
   */
  public List<JsonObject> rows() { 
    List<JsonObject> ret = this.delegate.rows();
;
    return ret;
  }

  public int getNumRows() { 
    int ret = this.delegate.getNumRows();
    return ret;
  }

  /**
   * Return the number of rows in the result set
   * @return the number of rows
   */
  public int numRows() { 
    int ret = this.delegate.numRows();
    return ret;
  }

  public int getNumColumns() { 
    int ret = this.delegate.getNumColumns();
    return ret;
  }

  /**
   * Return the number of columns in the result set
   * @return the number of columns
   */
  public int numColumns() { 
    int ret = this.delegate.numColumns();
    return ret;
  }


  public static ResultSet newInstance(io.vertx.ext.sql.ResultSet arg) {
    return arg != null ? new ResultSet(arg) : null;
  }
}
