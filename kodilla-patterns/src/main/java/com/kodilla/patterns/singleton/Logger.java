package com.kodilla.patterns.singleton;

public class Logger {
    private String lastLog = "";
    private static Logger loggerInstance = null;

    private Logger() {
    }

    public void log(String log) {
        lastLog = log;
        System.out.println("Log: [" + log + "]");
    }

    public String getLastLog() {
        return lastLog;
    }

    public static Logger getInstance() {
        synchronized(Logger.class) {
            if (loggerInstance == null) {
                loggerInstance = new Logger();
            }
        }
        return loggerInstance;
    }
}
