package ru.dev.egoravdeev.moneytransferservice.util;

import org.springframework.beans.factory.annotation.Value;

import java.util.Random;

public class GenerateCode {

    @Value("${code.symbols:0123456789}")
    private static String symbolsString;

    @Value("${size.code:5}")
    private static int size;

    private final Random random;
    private final char[] buff;
    private final char[] symbols;

    public GenerateCode() {
        random = new Random();
        buff = new char[size];
        symbols = symbolsString.toCharArray();
    }


    public String getCode() {
        for (int i = 0; i < size; i++) {
            buff[i] = symbols[random.nextInt(size)];
        }

        return new String(buff);
    }
}
