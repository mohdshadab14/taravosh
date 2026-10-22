package com.sha.taravosh.service;


import java.util.ArrayList;
import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        String email = "new@gmail.com";
        String domain = email.substring(email.lastIndexOf("@") + 1).toLowerCase();
        System.out.println("domain---   "+domain);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("testemail@gmail.com");
        arrayList.add("rahul@outlook.com");
        arrayList.add("rima@hotmail.com");
        arrayList.add("harish@outlook.com");
        arrayList.add("Ekta@gmail.com");

        HashMap<String, ArrayList<String>> map = new HashMap<>();
        //iterate the list to construct the MAP
        for(String s:arrayList){
            String domainName = s.substring(s.lastIndexOf("@") + 1).toLowerCase();
            if(map.containsKey(domainName)){
                ///true key already domain exists - value also exists - get the value from the map key
                ArrayList<String> result = map.get(domainName);
                result.add(s);
            }else{
                //first time unique key + PUT
                ArrayList<String> emailArrayList = new ArrayList<>();
                emailArrayList.add(s);
                map.put(domainName,emailArrayList);
            }
           /*
           {
                    "gmail":["testemail@gmail.com"],
                    "outlook":["rahul@outlook.com"],
                    "hotmail":["rima@hotmail.com"]
            }
             */
        }
        System.out.println("MAP.   "+ map.toString());




    }
}
