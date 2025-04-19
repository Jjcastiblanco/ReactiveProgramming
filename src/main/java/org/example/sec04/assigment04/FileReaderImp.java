package org.example.sec04.assigment04;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.SynchronousSink;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public class FileReaderImp implements FileReaderService {

    public static final Logger log = LoggerFactory.getLogger(FileReaderImp.class);

    @Override
    public Flux<String> read(Path path) {
        return Flux.generate(
                () -> openFile(path),
                this::readFile,
                this::close

        );
    }

    private BufferedReader openFile(Path path) throws IOException {
        log.info("reading file: {}", path);
        return Files.newBufferedReader(path);
    }

    private BufferedReader readFile(BufferedReader reader, SynchronousSink<String> sink)  {
        String line;
        try {
            line = reader.readLine();
            log.info("reading line: {}", line);
            if(Objects.isNull(line)) {
                sink.complete();
            }else {
                sink.next(line);
            }
        } catch (IOException e) {
            sink.error(e);
        }

        return reader;
    }

    private void close(BufferedReader reader){
        try {
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
