package io.vertx.ext.sql;

import io.vertx.codegen.annotations.VertxGen;

import java.sql.ResultSet;

@VertxGen
public enum FetchDirection {

  FORWARD(ResultSet.FETCH_FORWARD),
  REVERSE(ResultSet.FETCH_REVERSE),
  UNKNOWN(ResultSet.FETCH_UNKNOWN);

  private final int type;

  FetchDirection(int type) {
    this.type = type;
  }

  public int getType() {
    return type;
  }
}
