package com.tomoab.concurrency;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * falseSharingTest
 */
public class falseSharingTest {
    @Test
    public void falseSharingTestMain() throws Exception {
        // demonstrate false sharing impact on performance
        FalseSharing fs = new FalseSharing();
        fs.run();

    }
}