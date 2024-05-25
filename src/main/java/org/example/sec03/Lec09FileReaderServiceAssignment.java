package org.example.sec03;

import org.example.common.Util;
import org.example.sec03.assignment.FileReaderService;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Lec09FileReaderServiceAssignment {
    public static void main(String[] args) {
        FileReaderService service=new FileReaderService();
        Path path= Paths.get("src/main/resources/assignment/sec03/File01.txt");
        service.read(path)
                .subscribe(Util.subscriber());
    }
}
