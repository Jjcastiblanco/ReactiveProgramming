package org.example.sec03;

import org.example.common.Util;
import org.example.sec03.client.ExternalServicesClient;

public class Lec08NonBlockingStrimingMessages {

    public static void main(String[] args) {
        var client = new ExternalServicesClient();
        client.getNames()
                .subscribe(Util.subscriber());

        Util.sleepSeconds(6);
    }
}
