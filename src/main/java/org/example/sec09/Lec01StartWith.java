package org.example.sec09;

import org.example.common.Util;
import org.example.sec09.helper.NameGenerator;

public class Lec01StartWith {

    public static void main(String[] args) {

        var nameGenerator = new NameGenerator();
        nameGenerator.generateName()
                .take(2)
                .subscribe(Util.subscriber("A"));

        nameGenerator.generateName()
                .take(2)
                .subscribe(Util.subscriber("B"));

        nameGenerator.generateName()
                .take(3)
                .subscribe(Util.subscriber("C"));

    }
}
