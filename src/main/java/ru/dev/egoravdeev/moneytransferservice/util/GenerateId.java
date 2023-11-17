package ru.dev.egoravdeev.moneytransferservice.util;

public class GenerateId {
    public static int id = 0;

    public GenerateId() {}

    public int getId() {
        return id++;
    }
}
