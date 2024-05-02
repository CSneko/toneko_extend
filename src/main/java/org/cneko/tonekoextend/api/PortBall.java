package org.cneko.tonekoextend.api;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
public class PortBall {
    private static Map<String,Boolean> portBall = new ConcurrentHashMap<>();
public static boolean getStatus(String name) {
  if (!portBall.containsKey(name)) {
    return false; // Default behavior for missing key
  }
  Boolean value = portBall.get(name);
  return value != null ? value : false; // Handle null value explicitly
}

    public static void setStatus(String name,boolean status) {
        portBall.put(name,status);
    }
}
