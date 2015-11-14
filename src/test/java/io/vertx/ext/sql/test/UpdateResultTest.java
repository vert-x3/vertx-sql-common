package io.vertx.ext.sql.test;

import io.vertx.core.json.JsonArray;
import io.vertx.ext.sql.UpdateResult;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author <a href="http://tfox.org">Tim Fox</a>
 */
public class UpdateResultTest {

  protected JsonArray keys;
  protected UpdateResult ur;
  protected int updated = 3;

  @Before
  public void before() {

    keys = new JsonArray(Arrays.asList("foo", "bar", "wibble"));
    ur = UpdateResult.create(updated, keys);
  }


  @Test
  public void testUpdateResult() {

    assertEquals(updated, ur.updated());
    assertEquals(keys.size(), ur.keys().size());
    assertEquals(keys, ur.keys());

  }
}
