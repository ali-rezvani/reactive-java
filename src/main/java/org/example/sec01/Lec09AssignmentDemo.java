package org.example.sec01;

import org.example.common.Util;
import org.example.sec01.assignment.FileService;

public class Lec09AssignmentDemo {
    public static void main(String[] args) {
        FileService.read("File01.txt")
                .subscribe(Util.doOnNext(),
                        Util.doOnError(),
                        Util.donOnComplete());
        FileService.write("File03.txt","This is File03")
                .subscribe(Util.doOnNext(),
                        Util.doOnError(),
                        Util.donOnComplete());
        FileService.delete("File02.txt")
                .subscribe(Util.doOnNext(),
                        Util.doOnError(),
                        Util.donOnComplete());
    }
}
