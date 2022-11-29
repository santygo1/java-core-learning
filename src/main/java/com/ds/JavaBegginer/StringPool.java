package com.ds.JavaBegginer;

/**
 * @author Danil on 25.11.2022
 * @project JavaCoreLearning
 */
public class StringPool {
    public static void main(String[] args) {
        String firstString = "string";
        String secondString = "string 2";

        String substring = firstString.substring(0,6);

        // it works because java automatically founded string in string pool if it's exists
        // add "string" -> StringPool: {"string"}
        // add substring from string 2 which there is "string" -> StringPool: {"string"} it's already exists
        // so firstString and substring is linking on the same object in StringPool
        // and equaling by "==" returns true
        // but this method isn't recommended
        System.out.println(substring + "->" + (substring == firstString) + "<-" + firstString);

        // it's right
        System.out.println(substring + "->" + substring.equals(firstString) + "<-" + firstString);
    }
}
