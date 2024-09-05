import com.shadwork.ghidra.eightbit.Charset8bit;
import com.shadwork.ghidra.eightbit.Tables;
import org.junit.jupiter.api.Test;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SinclairZX80 {

    @Test
    void testSinclairZX80LowerPart() {
        Charset8bit charset = new Charset8bit("EightBit-Sinclair-ZX80", Tables.SinclairZX80);
        CharsetDecoder decoder = charset.newDecoder();
        CharsetEncoder encoder = charset.newEncoder();
        ByteBuffer in = ByteBuffer.wrap(new byte[] { 0x20, 0x21, 0x22, 0x23, 0x24, 0x25, 0x26, 0x27, 0x28, 0x29, 0x2a, 0x2b, 0x2c, 0x2d, 0x2e, 0x2f });
        CharBuffer out = CharBuffer.allocate(16);
        decoder.decode(in, out, true);
        out.flip();
        assertEquals("456789ABCDEFGHIJ", out.toString());
    }

    @Test
    void testSinclairZX80HigherPart() {
        Charset8bit charset = new Charset8bit("EightBit-Sinclair-ZX80", Tables.SinclairZX80);
        CharsetDecoder decoder = charset.newDecoder();
        CharsetEncoder encoder = charset.newEncoder();
        ByteBuffer in = ByteBuffer.wrap(new byte[] { (byte)0xA0,(byte)0xA1,(byte)0xA2,(byte)0xA3,(byte)0xA4,(byte)0xA5,(byte)0xA6,(byte)0xA7,(byte)0xA8,(byte)0xA9,(byte)0xAA,(byte)0xAB,(byte)0xAC,(byte)0xAD,(byte)0xAE,(byte)0xAF });
        CharBuffer out = CharBuffer.allocate(16);
        decoder.decode(in, out, true);
        out.flip();
        assertEquals("456789ABCDEFGHIJ", out.toString());
    }
}
