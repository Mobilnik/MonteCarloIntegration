package ru.iauli;

//has period 2^64 = 1,85 * 10^19
public class XORShiftRandom {
    private long last;

    public XORShiftRandom() {
        this(System.currentTimeMillis());
    }

    public XORShiftRandom(long seed) {
        this.last = seed;
    }

    public long nextLong(long max) {
        last ^= (last << 21);
        last ^= (last >>> 35);
        last ^= (last << 4);
        long out = last % max;
        return (out < 0) ? -out : out;
    }
}