package com.tomoab;

import org.junit.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

/**
 * ReadersWriters
 */
public class ReadersWriters {
    @Test
    public void doReadAllLines() {
        // use method to read all lines at once
        try {
            List<String> lines = Files.readAllLines(Paths.get("people.txt"));
            for (String s:lines)
                System.out.println(s);
        } catch (java.io.IOException e) {
            System.out.println("IOException");
            e.printStackTrace();
        }
    }

    @Test
    public void doNewBufferedReader() {
        // try with resources using java.nio methods
        try (BufferedReader br = Files.newBufferedReader(Paths.get("people.txt"))) {
            String s;
            while ((s = br.readLine()) != null)
                System.out.println(s);
        } catch (java.io.IOException e) {
            System.out.println("IOException");
            e.printStackTrace();
        }
    }

    @Test
    public void doWriteData() {

        String[] data = {"Line 1", "Line 2", "Line 3"};

        // try with resources and a buffer chain - buffered writer on top of file writer (which is deprecated)
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"))) {
            for (String d:data) {
                bw.write(d);
                bw.newLine();
            }
        } catch (java.io.IOException e) {
            System.out.println("IOException");
            e.printStackTrace();
        }
    }

    @Test
    public void doTryWithResources() {
        int length;
        char[] charBuff = new char[10];

        // try with resources to walk through string from file 10 chars at a time
        // note that FileReader is deprecated
        try (Reader fileReader = new FileReader("input.txt")) {
            while ((length = fileReader.read(charBuff)) >= 0) {
                for (int i = 0; i < length; i++)
                    System.out.print(charBuff[i]);
            }
        } catch (java.io.FileNotFoundException e) {
            System.out.println("input.txt not found");
        } catch (java.io.IOException e) {
            System.out.println("IOException");
            e.printStackTrace();
        }
    }

    @Test
    public void doStringReader() {
        int length;
        String s = randomAlphabetic(100);
        System.out.println(s);

        // read one char at a time from a random string using StringReader
        StringReader reader = new StringReader(s);
        char[] charBuff = new char[10];
        try {
            // read 10 bytes at a time from 'stream'
            while ((length = reader.read(charBuff)) >= 0)
                for (int i = 0; i < length; i++) {
                    // print char
                    System.out.print(charBuff[i]);
                }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();
    }

    @Test
    public void doInputStream() {
        String s = randomAlphabetic(100);
        System.out.println(s);

        // read one byte at a time from a random string using InputStream
        InputStream inputStream = new ByteArrayInputStream(s.getBytes());
        byte[] byteBuff = new byte[10];
        int length;
        try {
            // read 10 bytes at a time from 'stream'
            while ((length = inputStream.read(byteBuff)) >= 0)
                for (int i = 0; i < length; i++) {
                    // print byte val
                    System.out.print(byteBuff[i]);
                }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();
    }
}
