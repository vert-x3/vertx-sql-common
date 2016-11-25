package io.vertx.kotlin.ext.sql

import io.vertx.ext.sql.ResultSet

fun ResultSet(
    columnNames: List<String>? = null,
  output: io.vertx.core.json.JsonArray? = null,
  results: List<io.vertx.core.json.JsonArray>? = null): ResultSet = io.vertx.ext.sql.ResultSet().apply {

  if (columnNames != null) {
    this.columnNames = columnNames
  }

  if (output != null) {
    this.output = output
  }

  if (results != null) {
    this.results = results
  }

}

