package io.vertx.ext.sql;

import io.vertx.codegen.annotations.VertxGen;

import java.sql.ResultSet;

@VertxGen
public enum ResultSetConcurrency {

  READ_ONLY(ResultSet.CONCUR_READ_ONLY),
  UPDATABLE(ResultSet.CONCUR_UPDATABLE);

  private final int type;

  ResultSetConcurrency(int type) {
    this.type = type;
  }

  public int getType() {
    return type;
  }
}
