package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {
    private final static Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        LOG.trace("trace message");
        LOG.debug("debug message");
        LOG.info("info message");
        LOG.warn("warn message");
        LOG.error("error message");

        byte var1 = 127;
        short var2 = 42;
        int var3 = 123;
        long var4 = 256L;
        float var5 = 5.3F;
        double var6 = 12.6;
        boolean var7 = true;
        char var8 = 'g';
        LOG.debug(
                "var1 = {}, var2 = {}, var3 = {}, var4 = {}, var5 = {}, var6 = {}, var7 = {}, var8 = {}",
                var1, var2, var3, var4, var5, var6, var7, var8
        );
    }
}
