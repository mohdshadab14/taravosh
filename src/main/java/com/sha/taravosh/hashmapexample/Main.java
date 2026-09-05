package com.sha.taravosh.hashmapexample;

import java.util.HashMap;
import java.util.Map;

public class Main {


    public static void main(String[] args) {

        String s = "asddsgfghwerewtghhsdd";


        HashMap<Character,Integer> map = new HashMap<>();



        char[] arr = s.toCharArray();

        for(int i=0; i<arr.length; i++){

            char key = arr[i];

            if(map.get(key)==null){
                map.put(key,1);
            }else{
                int value = map.get(key);
                value++;
                map.put(key,value);
            }
        }

        System.out.println(map);

    }

}
