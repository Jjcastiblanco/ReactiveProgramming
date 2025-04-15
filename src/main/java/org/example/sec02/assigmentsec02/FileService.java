package org.example.sec02.assigmentsec02;

import reactor.core.publisher.Mono;

public interface FileService {

    Mono<String> readFile(String fileName);
    Mono<String> writeFile(String fileName, String content);
    Mono<Void> deleteFile(String fileName);
}
