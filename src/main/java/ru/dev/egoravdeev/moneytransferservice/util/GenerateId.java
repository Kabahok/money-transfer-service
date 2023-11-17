package ru.dev.egoravdeev.moneytransferservice.util;

public class GenerateId {
    public static int id = 0;

    public GenerateId() {}

    public String getId() {
        return String.valueOf(id++);
    }
}
