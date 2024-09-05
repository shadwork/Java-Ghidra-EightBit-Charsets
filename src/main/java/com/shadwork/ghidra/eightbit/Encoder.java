package com.shadwork.ghidra.eightbit;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.util.Arrays;

public class Encoder extends CharsetEncoder {
    private char[] charmap;

    protected Encoder(Charset8bit cs) {
        super(cs, 1.0f, 1.0f);
        this.charmap = cs.getCharmap();
    }

    @Override
    protected CoderResult encodeLoop(CharBuffer in, ByteBuffer out) {
        while (in.hasRemaining()) {
            char c = in.get();
            int result = Arrays.binarySearch(charmap, c);
            if(result >= 0) {
                out.put((byte) result);
            }
        }
        return CoderResult.UNDERFLOW;
    }
}
