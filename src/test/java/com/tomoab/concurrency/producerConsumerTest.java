package com.tomoab.concurrency;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * producerConsumerTest
 */
public class producerConsumerTest {
    @Test
    @Ignore
    public void doProduceConsume() throws Exception {
        // first, no sync (not thread safe)
        ProducerConsumer pc = new ProducerConsumer();
        pc.doProduceConsume(false);

        // then thread safe
        ProducerConsumer pcSync = new ProducerConsumer();
        pcSync.doProduceConsume(true);
    }
}