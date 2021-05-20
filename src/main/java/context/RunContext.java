package context;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents test run context storage which allows to save/get data and share it between test
 * cases/test classes during test run.
 * <p>
 * Example:
 * <code>RunContext.put("key", 123);<code/>
 * <code>RunContext.get("key", Integer.class);<code/>
 */
public final class RunContext {

  private static final Map<String, Object> context = new HashMap<>();

  private RunContext() {
  }

  public static void clearContext() {
    context.clear();
  }

  public static <T> T get(String key, Class<T> objectClass) {
    Object object = context.get(key);
    if (object == null) {
      throw new RuntimeException(String.format("Object with key [%s] not found.", key));
    }

    return objectClass.cast(object);
  }

  public static <T> void put(String key, T object) {
    context.put(key, object);
  }
}