package ru.dev.egoravdeev.moneytransferservice.util;

import org.springframework.beans.factory.annotation.Value;

import java.util.Random;

public class GenerateCode {

    @Value("${code.symbols:0123456789}")
    private String symbolsString;

    @Value("${size.code:5}")
    private int size;

    private final Random random;
    private char[] buff;
    private char[] symbols;

    public GenerateCode() {
        random = new Random();
    }


    public String getCode() {
        symbols = symbolsString.toCharArray();
        buff = new char[size];

        for (int i = 0; i < size; i++) {
            buff[i] = symbols[random.nextInt(size)];
        }

        return new String(buff);
    }
}
