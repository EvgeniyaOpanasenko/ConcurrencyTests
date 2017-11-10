package com.manTask;

/**
 * Created by User on 11/10/2017.
 */
public class Run {
    public static void main(String[] args) throws Exception {
        Man man = new Man("Kas", 40, true);
        Woman woman = new Woman("Eva");

        while (man.isGork()) {
            throw new Exception("There is no options but music");
        }
        man.happy(woman);
    }
}
