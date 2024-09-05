package com.shadwork.ghidra.eightbit;

import java.nio.charset.Charset;
import java.nio.charset.spi.CharsetProvider;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Provider8bit extends CharsetProvider {

    Map<String, Charset> charsetMap = new HashMap<>();
    Charset8bit coder;

    public Provider8bit() {
        super();
        coder = new Charset8bit("EightBit-Sinclair-ZX81", Tables.SinclairZX81);
        charsetMap.put(coder.name(), coder);
        coder = new Charset8bit("EightBit-Sinclair-ZX80", Tables.SinclairZX80);
        charsetMap.put(coder.name(), coder);
        coder = new Charset8bit("EightBit-Commodore-64U", Tables.Commodore64U);
        charsetMap.put(coder.name(), coder);
        coder = new Charset8bit("EightBit-Commodore-64S", Tables.Commodore64S);
        charsetMap.put(coder.name(), coder);
    }

    @Override
    public Iterator<Charset> charsets() {
        return charsetMap.values().iterator();
    }

    @Override
    public Charset charsetForName(String charsetName) {
        return charsetMap.get(charsetName);
    }
}
