package com.ds.JavaBegginer.serializing;

import java.io.*;

/**
 * @author Danil on 25.11.2022
 * @project JavaCoreLearning
 */
public class Main {

    public static void main(String[] args) {
        File file = new File("./src/main/java/com/ds/serializing/objectFile.bin");
        Person jack = initPerson("Jack", 25);
        Person daniel = initPerson("Daniel", 66);
        System.out.println("Before serializing:");
        System.out.println(jack);
        System.out.println(daniel);

        //write object
        writePersonToFile(file, jack);
        //read object
        Person objectReadingResult = readPersonFromFile(file);
        System.out.println("After serializing one person: ");
        System.out.println(objectReadingResult);

        /*
            Object array
         */
        Person[] persons = new Person[]{jack, daniel};
        writePersonArrayInFile(file, persons);

        System.out.println("Before serializing person arrays");
        Person[] arrayReadingResult = readPersonsArrayFromFile(file);
        for (Person person: arrayReadingResult){
            System.out.println(person);
        }
    }

    public static void writePersonToFile(File file, Person person) {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(file, false))) {
            oos.writeObject(person);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static Person readPersonFromFile(File file) {
        Person readingResult = null;

        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(file))) {
            readingResult = (Person) ois.readObject();
        } catch (IOException exception) {
            exception.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return readingResult;
    }

    public static void writePersonArrayInFile(File file, Person[] persons) {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(file, false))) {
            oos.writeInt(persons.length);
            for (Person person : persons) {
                oos.writeObject(person);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Person[] readPersonsArrayFromFile(File file) {
        Person[] readingResult = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            int arraySize = ois.readInt();
            readingResult = new Person[arraySize];
            for (int i = 0; i < readingResult.length; i++) {
                readingResult[i] = (Person)ois.readObject();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return readingResult;
    }

    public static Person initPerson(String name, int age) {
        Person person = new Person(name, age);
        Card sberBankCard = new Card("SberBank", 900 + age, 2202_9321_6731_2222L);
        person.getWallet().addCard(sberBankCard);
        person.getWallet().addCash(100);
        Card tinkoffCard = new Card("Tinkoff", 800 + age, 1240_8951_7542_2332L);
        person.getWallet().addCard(tinkoffCard);

        return person;
    }
}
