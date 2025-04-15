// src/utils/Logger.java
package utils;

import java.util.ArrayList;
import java.util.List;

public class Logger {
    private static Logger instance;
    private List<String> logs;

    private Logger() {
        logs = new ArrayList<>();
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String handler, String message) {
        String log = "[" + handler + "] " + message;
        logs.add(log);
    }

    public void printLogs() {
        System.out.println("\n--- Log History ---");
        for (String log : logs) {
            System.out.println(log);
        }
    }
}