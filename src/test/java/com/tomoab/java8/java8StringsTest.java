package com.tomoab.java8;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

import static org.junit.Assert.*;

/**
 * java8StringsTest
 */
public class java8StringsTest {
    @Test
    public void java8StringsTestMain() throws Exception {
        // using + operator on strings is expensive because of multiple creations/deletions
        // StringBuffer is better, but is synchronized - can have performance issues
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("hello").append(" ").append("world");
        assertEquals(stringBuffer.toString(), "hello world");

        List<String> list = Arrays.asList("alpha", "beta", "gamma", "delta");

        // JDK 5 introduced StringBuilder
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        if (!list.isEmpty()) {
            builder.append(list.get(0));
            for (int i = 1; i < list.size(); i++) {
                builder.append(",").append(list.get(i));
            }
        }
        builder.append("]");
        assertEquals(builder.toString(), "[alpha,beta,gamma,delta]");

        // JDK 8 introduced StringJoiner, which is easier
        StringJoiner joiner = new StringJoiner(",", "[", "]");
        for (String e: list) {
            joiner.add(e);
        }
        assertEquals(joiner.toString(), "[alpha,beta,gamma,delta]");
    }
}