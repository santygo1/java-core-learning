package com.ds;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Danil on 25.11.2022
 * @project JavaCoreLearning
 */
public class Generics {

    public static void main(String[] args) {
         /*
          Before generic was created
         */
         List list = new ArrayList();

         // creating some different objects
         Something something = new Something();
         SomethingElse somethingElse = new SomethingElse();
         // input these objects in our list
        list.add(something);
        list.add(somethingElse);
        //now we have list with different types object
        //it makes some problems with checking type of returning object from list
        // for example when we need to downcast we must check type
        Object o = list.get(0);
        Something gettingFromList;
        if (o instanceof Something)
            gettingFromList = (Something) o;
        else
            System.out.println("Can't downcast this object");
        //How we can see it makes some problems, and we need to write many lines of code

        /*
        When Generics was created(Java 5)
         */
        List<Something> list2 = new ArrayList<Something>();
        list2.add(something);
//        list2.add(somethingElse); we can't add something that hasn't type Something
        gettingFromList = list2.get(0); // we can get item from list and don't care about downcasting

        /*
            In java 7 we can write generic class without type
         */
        List<Something> list3 = new ArrayList<>();
    }
}

class Something{
    public void doSomething(){}
}

class SomethingElse{
    public void doSomething(){}
}