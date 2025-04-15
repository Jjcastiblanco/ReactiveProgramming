package org.example.sec02.assigmentsec02;

import reactor.core.publisher.Mono;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileServiceImpl implements FileService {
    @Override
    public Mono<String> readFile(String fileName) {
        Path path = Paths.get(fileName);
        return Mono.fromCallable(()-> Files.readString(path));
    }

    @Override
    public Mono<String> writeFile(String fileName, String content) {
        return null;
    }

    @Override
    public Mono<Void> deleteFile(String fileName) {
        return null;
    }


}
