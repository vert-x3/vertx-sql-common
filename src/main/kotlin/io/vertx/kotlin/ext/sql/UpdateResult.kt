package io.vertx.kotlin.ext.sql

import io.vertx.ext.sql.UpdateResult

fun UpdateResult(
    keys: io.vertx.core.json.JsonArray? = null,
  updated: Int? = null): UpdateResult = io.vertx.ext.sql.UpdateResult().apply {

  if (keys != null) {
    this.keys = keys
  }

  if (updated != null) {
    this.updated = updated
  }

}

