package org.example.sec09;

import org.example.common.Util;
import org.example.sec09.helper.Copa;
import org.example.sec09.helper.Emirate;
import org.example.sec09.helper.Wingo;
import reactor.core.publisher.Flux;

public class Lec05MergeUseCase {



    public static void main(String[] args) {

        Copa copa = new Copa();
        Emirate emirate = new Emirate();
        Wingo wingo = new Wingo();

        Flux.merge(copa.getFlights(), emirate.getFlights(), wingo.getFlights())
                .subscribe(Util.subscriber("A"));

        Util.sleepSeconds(5);
    }
}
