package com.ds.JavaCollectionsFramework;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Danil on 29.11.2022
 * @project JavaCoreLearning
 */
public class Maps {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>(); // неупорядоченное множество пар(entry) ключ-значение
        //init map
        map.put(2,"string 2");
        map.put(1000, "String 100");
        map.put(542, "String 542");
        map.put(421, "String 400");

        System.out.println(map);

        map = new LinkedHashMap<>(map); //Сохраняет последовательность
        map.put(664, "sdas");
        map.put(321,"sda2");
        System.out.println(map);

        map = new TreeMap<>(map);
        System.out.println(map);

        //Обход
        for(Map.Entry<Integer, String> entry : map.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
