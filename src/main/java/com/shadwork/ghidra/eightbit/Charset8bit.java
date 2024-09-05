package com.shadwork.ghidra.eightbit;

import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

public class Charset8bit extends java.nio.charset.Charset {
    private char[] charmap;

    protected Charset8bit(String canonicalName, String[] aliases) {
        super(canonicalName, aliases);
    }

    public Charset8bit(String canonicalName, char[] charmap) {
        super(canonicalName, null);
        this.charmap = charmap;
    }

    @Override
    public boolean contains(java.nio.charset.Charset cs) {
        return name().equals(cs.name());
    }

    @Override
    public CharsetDecoder newDecoder() {
        return new Decoder(this);
    }

    @Override
    public CharsetEncoder newEncoder() {
        return new Encoder(this);
    }

    public char[] getCharmap() {
        return charmap;
    }

    public void setCharmap(char[] charmap) {
        this.charmap = charmap;
    }
}
