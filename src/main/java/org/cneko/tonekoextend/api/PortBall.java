package org.cneko.tonekoextend.api;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
public class PortBall {
    private static Map<String,Boolean> portBall = new ConcurrentHashMap<>();
    public static boolean getStatus(String name) {
        return portBall.get(name);
    }

    public static void setStatus(String name,boolean status) {
        portBall.put(name,status);
    }
}
