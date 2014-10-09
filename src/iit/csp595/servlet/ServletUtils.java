package iit.csp595.servlet;

public final class ServletUtils {

  private static final String DELIM = ",";

  private ServletUtils() {

  }

  public static int toInt(String s) {
    return toInt(s, -1);
  }

  public static int toInt(String s, int def) {
    try {
      return (s != null ? Integer.parseInt(s) : def);
    } catch (NumberFormatException e) {
      return def;
    }
  }

  public static long toLong(String s, long def) {
    try {
      return (s != null ? Long.parseLong(s) : def);
    } catch (NumberFormatException e) {
      return def;
    }
  }

  public static long[] toLong(String s) {
    long[] result;
    if (s == null) {
      result = new long[] {-1L};
    } else {
      String[] split = s.split(DELIM);
      result = new long[split.length];
      for (int i = 0; i < split.length; i++) {
        result[i] = toLong(split[i], -1);
      }
    }
    return result;
  }
}
