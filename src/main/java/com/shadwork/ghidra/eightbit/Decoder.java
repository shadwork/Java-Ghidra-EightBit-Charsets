package com.shadwork.ghidra.eightbit;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;

public class Decoder extends CharsetDecoder {
    private char[] charmap;

    protected Decoder(Charset8bit cs) {
        super(cs, 1.0f, 1.0f);
        this.charmap = cs.getCharmap();
    }

    @Override
    protected CoderResult decodeLoop(ByteBuffer in, CharBuffer out) {
        while (in.hasRemaining()) {
            byte b = in.get();
            out.put(charmap[b & 0xff]);
        }
        return CoderResult.UNDERFLOW;
    }
}
