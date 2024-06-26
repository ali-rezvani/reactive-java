package org.example.sec02.helper;

import org.example.common.Util;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class NameGenerator {

    public static List<String> getNames(int count){
        List<String> list=new ArrayList<>(count);
        for (int i=1;i<=count;i++){
            list.add(getName());
        }
        return list;
    }

    public static Flux<String> getFluxNames(int count){
        return Flux.range(1,count)
                .map(i->getName());
    }
    private static String getName(){
        System.out.println("Generating name..");
        Util.sleep(1);
        return Util.faker().name().fullName();
    }
}
