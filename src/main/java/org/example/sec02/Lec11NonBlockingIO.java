package org.example.sec02;

import org.example.common.Util;
import org.example.sec02.client.ExternalServicesClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lec11NonBlockingIO {

    public static final Logger log = LoggerFactory.getLogger(Lec11NonBlockingIO.class);
    public static void main(String[] args) {

        var client = new ExternalServicesClient();

        log.info("Start");

        for (int i = 1; i <= 100; i++) {
            client.getProductName(i)
                    .subscribe(Util.subscriber());
        }


        Util.sleepSeconds(2);

    }
}
