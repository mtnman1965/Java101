package com.tomoab.concurrency;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * falseSharingTest
 */
public class falseSharingTest {
    @Test
    @Ignore
    public void falseSharingTestMain() throws Exception {

        // demonstrate false sharing impact on performance
        // causes errors on linux?
        FalseSharing fs = new FalseSharing();
        fs.run();
    }
}