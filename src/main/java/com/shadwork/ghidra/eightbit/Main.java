package com.shadwork.ghidra.eightbit;

import java.nio.charset.Charset;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        System.out.println("Ghidra extension for 8-bit charset support. Place jar in patch/Ghidra/ folder and restart Ghidra.");
        System.out.println("Available charsets:");
        Provider8bit provider = new Provider8bit();
        for (Iterator<Charset> it = provider.charsets(); it.hasNext(); ) {
            Charset charset = it.next();
            System.out.println(" - ".concat(charset.name()));
        }
    }
}
