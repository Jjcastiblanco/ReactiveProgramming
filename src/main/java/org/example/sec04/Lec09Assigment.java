package org.example.sec04;

import org.example.common.Util;
import org.example.sec04.assigment04.FileReaderImp;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Lec09Assigment {



    public static void main(String[] args) {

        var path = Path.of("src/main/resources/assigment/01/fileone.txt");
        var fileReaderService = new FileReaderImp();
        fileReaderService.read(path)
                .subscribe(Util.subscriber());
    }
}
