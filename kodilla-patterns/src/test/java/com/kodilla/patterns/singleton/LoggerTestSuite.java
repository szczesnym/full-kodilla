package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.Test;

public class LoggerTestSuite {
    @Test
    public void testGetLAstLog() {
       //Given
        Logger sutLogger = Logger.getInstance();
        //When
        sutLogger.log("First log");
       //
        Assert.assertEquals("First log", sutLogger.getLastLog());
    }
}
