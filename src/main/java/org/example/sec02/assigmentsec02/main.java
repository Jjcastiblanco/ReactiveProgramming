package org.example.sec02.assigmentsec02;

public class main {


    public static void main(String[] args) {

        FileService fileService = new FileServiceImpl();
        fileService.readFile("src/main/resources/assigment/01/fileone.txt")
                .subscribe(content -> System.out.println("Content: " + content),
                        err -> System.out.println("error "  + err.getMessage()),
                        () -> {});
    }
}
