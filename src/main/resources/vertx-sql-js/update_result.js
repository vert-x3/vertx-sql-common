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

/** @module vertx-sql-js/update_result */
var utils = require('vertx-js/util/utils');

var io = Packages.io;
var JsonObject = io.vertx.core.json.JsonObject;
var JUpdateResult = io.vertx.ext.sql.UpdateResult;

/**
 Represents the result of an update/insert/delete operation on the database.
 <p>
 @class
*/
var UpdateResult = function(j_val) {

  var j_updateResult = j_val;
  var that = this;

  /**

   @public

   @return {number}
   */
  this.getUpdated = function() {
    var __args = arguments;
    if (__args.length === 0) {
      return j_updateResult["getUpdated()"]();
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**
   Get the number of rows updated

   @public

   @return {number} number of rows updated
   */
  this.updated = function() {
    var __args = arguments;
    if (__args.length === 0) {
      return j_updateResult["updated()"]();
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public

   @return {todo}
   */
  this.getKeys = function() {
    var __args = arguments;
    if (__args.length === 0) {
      return utils.convReturnJson(j_updateResult["getKeys()"]());
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**
   Get any generated keys

   @public

   @return {todo} generated keys
   */
  this.keys = function() {
    var __args = arguments;
    if (__args.length === 0) {
      return utils.convReturnJson(j_updateResult["keys()"]());
    } else throw new TypeError('function invoked with invalid arguments');
  };

  // A reference to the underlying Java delegate
  // NOTE! This is an internal API and must not be used in user code.
  // If you rely on this property your code is likely to break if we change it / remove it without warning.
  this._jdel = j_updateResult;
};

/**

 @memberof module:vertx-sql-js/update_result
 @param updated {number} 
 @param keys {todo} 
 @return {UpdateResult}
 */
UpdateResult.create = function(updated, keys) {
  var __args = arguments;
  if (__args.length === 2 && typeof __args[0] ==='number' && typeof __args[1] === 'object' && __args[1] instanceof Array) {
    return utils.convReturnVertxGen(JUpdateResult["create(int,io.vertx.core.json.JsonArray)"](updated, utils.convParamJsonArray(keys)), UpdateResult);
  } else throw new TypeError('function invoked with invalid arguments');
};

// We export the Constructor function
module.exports = UpdateResult;