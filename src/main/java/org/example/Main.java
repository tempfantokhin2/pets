package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

    }

    public static Pet[] makePets() {
        Pet[] pets = new Pet[3];
        pets[0] = new KotLeta("test");
        pets[1] = new FlyingCat("1");
        pets[2] = new FlyingCat("2");
        return pets;
    }
}