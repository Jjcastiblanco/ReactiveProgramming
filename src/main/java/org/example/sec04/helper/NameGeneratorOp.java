package org.example.sec04.helper;

import org.example.common.Util;
import reactor.core.publisher.FluxSink;

import java.util.function.Consumer;

public class NameGeneratorOp implements Consumer<FluxSink<String>> {


    private FluxSink<String> sink;
    private final Object lock = new Object();

    public void setSink(FluxSink<String> sink) {
        this.sink = sink;
    }


    @Override
    public void accept(FluxSink<String> stringFluxSink) {

        this.sink = stringFluxSink;

    }

    public void generate(){
        synchronized (lock) { // Sincronización
            if (sink != null) {
                sink.next(Util.faker().name().firstName());
            }
        }
    }
}
