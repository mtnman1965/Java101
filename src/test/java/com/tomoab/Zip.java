package com.tomoab;

import org.junit.Ignore;
import org.junit.Test;

import java.net.URI;
import java.nio.file.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Zip
 */
public class Zip {
    @Test
    public void doReadZip() {
        // TODO: open existing zip and recurse file structure printing out file details

    }

    @Test
    @Ignore
    public void doWriteZip() {
        // create a new zip
        Map<String, String> providerProps = new HashMap<>();
        providerProps.put("create", "true");
        Path zipPath = FileSystems.getDefault().getPath("input.zip");

        try {
            // create the zip
            URI zipURI = new URI("jar:file", zipPath.toUri().getPath(), null);
            FileSystem zipFS = FileSystems.newFileSystem(zipURI, providerProps);

            // copy input file to the zip
            Path srcFile = Paths.get("input.txt");
            Path destFile = zipFS.getPath("/zippedinput.txt");
            Path newPath = Files.copy(srcFile, destFile);
            System.out.println("new path = " + newPath.getFileName());

            // NEVER GOT THIS TO WORK - ZIP FILE DOESN'T CONTAIN TEXT FILE

        } catch (java.net.URISyntaxException e) {
            System.out.println("URISyntaxException");
            e.printStackTrace();
        } catch (java.io.IOException e) {
            System.out.println("IOException");
            e.printStackTrace();
        }
    }
}
