package io.vertx.ext.sql;

import io.vertx.codegen.annotations.VertxGen;

import java.sql.ResultSet;

@VertxGen
public enum ResultSetType {
  FORWARD_ONLY(ResultSet.TYPE_FORWARD_ONLY),
  SCROLL_INSENSITIVE(ResultSet.TYPE_SCROLL_INSENSITIVE),
  SCROLL_SENSITIVE(ResultSet.TYPE_SCROLL_SENSITIVE);

  private final int type;

  ResultSetType(int type) {
    this.type = type;
  }

  public int getType() {
    return type;
  }
}
