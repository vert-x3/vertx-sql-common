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

/** @module vertx-sql-js/sql_row_stream */
var utils = require('vertx-js/util/utils');
var ReadStream = require('vertx-js/read_stream');

var io = Packages.io;
var JsonObject = io.vertx.core.json.JsonObject;
var JSQLRowStream = Java.type('io.vertx.ext.sql.SQLRowStream');

/**
 A ReadStream of Rows from the underlying RDBMS. This class follows the ReadStream semantics and will automatically
 close the underlying resources if all returned rows are returned. For cases where the results are ignored before the
 full processing of the returned rows is complete the close method **MUST** be called in order to release underlying
 resources.

 The interface is minimal in order to support all SQL clients not just JDBC.

 @class
*/
var SQLRowStream = function(j_val) {

  var j_sQLRowStream = j_val;
  var that = this;
  ReadStream.call(this, j_val);

  /**

   @public
   @param arg0 {function} 
   @return {ReadStream}
   */
  this.exceptionHandler = function(arg0) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] === 'function') {
      j_sQLRowStream["exceptionHandler(io.vertx.core.Handler)"](function(jVal) {
      arg0(utils.convReturnThrowable(jVal));
    });
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param arg0 {function} 
   @return {ReadStream}
   */
  this.handler = function(arg0) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] === 'function') {
      j_sQLRowStream["handler(io.vertx.core.Handler)"](function(jVal) {
      arg0(utils.convReturnJson(jVal));
    });
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public

   @return {ReadStream}
   */
  this.pause = function() {
    var __args = arguments;
    if (__args.length === 0) {
      j_sQLRowStream["pause()"]();
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public

   @return {ReadStream}
   */
  this.resume = function() {
    var __args = arguments;
    if (__args.length === 0) {
      j_sQLRowStream["resume()"]();
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param arg0 {function} 
   @return {ReadStream}
   */
  this.endHandler = function(arg0) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] === 'function') {
      j_sQLRowStream["endHandler(io.vertx.core.Handler)"](arg0);
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**
   Will convert the column name to the json array index.

   @public
   @param name {string} the column name 
   @return {number} the json array index
   */
  this.column = function(name) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] === 'string') {
      return j_sQLRowStream["column(java.lang.String)"](name);
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**
   Event handler when a resultset is closed. This is useful to request for more results.

   @public
   @param handler {function} 
   @return {SQLRowStream}
   */
  this.resultSetClosedHandler = function(handler) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] === 'function') {
      return utils.convReturnVertxGen(SQLRowStream, j_sQLRowStream["resultSetClosedHandler(io.vertx.core.Handler)"](handler));
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**
   Request for more results if available

   @public

   */
  this.moreResults = function() {
    var __args = arguments;
    if (__args.length === 0) {
      j_sQLRowStream["moreResults()"]();
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**
   Closes the stream/underlying cursor(s). The actual close happens asynchronously.

   @public
   @param handler {function} called when the stream/underlying cursor(s) is(are) closed 
   */
  this.close = function() {
    var __args = arguments;
    if (__args.length === 0) {
      j_sQLRowStream["close()"]();
    }  else if (__args.length === 1 && typeof __args[0] === 'function') {
      j_sQLRowStream["close(io.vertx.core.Handler)"](function(ar) {
      if (ar.succeeded()) {
        __args[0](null, null);
      } else {
        __args[0](null, ar.cause());
      }
    });
    } else throw new TypeError('function invoked with invalid arguments');
  };

  // A reference to the underlying Java delegate
  // NOTE! This is an internal API and must not be used in user code.
  // If you rely on this property your code is likely to break if we change it / remove it without warning.
  this._jdel = j_sQLRowStream;
};

SQLRowStream._jclass = utils.getJavaClass("io.vertx.ext.sql.SQLRowStream");
SQLRowStream._jtype = {
  accept: function(obj) {
    return SQLRowStream._jclass.isInstance(obj._jdel);
  },
  wrap: function(jdel) {
    var obj = Object.create(SQLRowStream.prototype, {});
    SQLRowStream.apply(obj, arguments);
    return obj;
  },
  unwrap: function(obj) {
    return obj._jdel;
  }
};
SQLRowStream._create = function(jdel) {
  var obj = Object.create(SQLRowStream.prototype, {});
  SQLRowStream.apply(obj, arguments);
  return obj;
}
module.exports = SQLRowStream;