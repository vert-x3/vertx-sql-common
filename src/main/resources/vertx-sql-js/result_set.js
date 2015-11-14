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

/** @module vertx-sql-js/result_set */
var utils = require('vertx-js/util/utils');

var io = Packages.io;
var JsonObject = io.vertx.core.json.JsonObject;
var JResultSet = io.vertx.ext.sql.ResultSet;

/**
 Represents the results of a SQL query.
 <p>
 @class
*/
var ResultSet = function(j_val) {

  var j_resultSet = j_val;
  var that = this;

  /**

   @public

   @return {Array.<todo>}
   */
  this.getResults = function() {
    var __args = arguments;
    if (__args.length === 0) {
      return utils.convReturnListSetJson(j_resultSet["getResults()"]());
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**
   Get the results

   @public

   @return {Array.<todo>} the results
   */
  this.results = function() {
    var __args = arguments;
    if (__args.length === 0) {
      return utils.convReturnListSetJson(j_resultSet["results()"]());
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public

   @return {Array.<string>}
   */
  this.getColumnNames = function() {
    var __args = arguments;
    if (__args.length === 0) {
      return j_resultSet["getColumnNames()"]();
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**
   Get the column names

   @public

   @return {Array.<string>} the column names
   */
  this.columnNames = function() {
    var __args = arguments;
    if (__args.length === 0) {
      return j_resultSet["columnNames()"]();
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public

   @return {Array.<Object>}
   */
  this.getRows = function() {
    var __args = arguments;
    if (__args.length === 0) {
      return utils.convReturnListSetJson(j_resultSet["getRows()"]());
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**
   Get the rows - each row represented as a JsonObject where the keys are the column names and the values are
   the column values.
   <p>
   Beware that it's legal for a query result in SQL to contain duplicate column names, in which case one will
   overwrite the other if using this method. If that's the case use {@link ResultSet#getResults} instead.

   @public

   @return {Array.<Object>} the rows represented as JSON object instances
   */
  this.rows = function() {
    var __args = arguments;
    if (__args.length === 0) {
      return utils.convReturnListSetJson(j_resultSet["rows()"]());
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public

   @return {number}
   */
  this.getNumRows = function() {
    var __args = arguments;
    if (__args.length === 0) {
      return j_resultSet["getNumRows()"]();
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**
   Return the number of rows in the result set

   @public

   @return {number} the number of rows
   */
  this.numRows = function() {
    var __args = arguments;
    if (__args.length === 0) {
      return j_resultSet["numRows()"]();
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public

   @return {number}
   */
  this.getNumColumns = function() {
    var __args = arguments;
    if (__args.length === 0) {
      return j_resultSet["getNumColumns()"]();
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**
   Return the number of columns in the result set

   @public

   @return {number} the number of columns
   */
  this.numColumns = function() {
    var __args = arguments;
    if (__args.length === 0) {
      return j_resultSet["numColumns()"]();
    } else throw new TypeError('function invoked with invalid arguments');
  };

  // A reference to the underlying Java delegate
  // NOTE! This is an internal API and must not be used in user code.
  // If you rely on this property your code is likely to break if we change it / remove it without warning.
  this._jdel = j_resultSet;
};

/**

 @memberof module:vertx-sql-js/result_set
 @param columnNames {Array.<string>} 
 @param results {Array.<todo>} 
 @return {ResultSet}
 */
ResultSet.create = function(columnNames, results) {
  var __args = arguments;
  if (__args.length === 2 && typeof __args[0] === 'object' && __args[0] instanceof Array && typeof __args[1] === 'object' && __args[1] instanceof Array) {
    return utils.convReturnVertxGen(JResultSet["create(java.util.List,java.util.List)"](columnNames, utils.convParamListJsonArray(results)), ResultSet);
  } else throw new TypeError('function invoked with invalid arguments');
};

// We export the Constructor function
module.exports = ResultSet;