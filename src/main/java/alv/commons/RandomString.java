package alv.commons;

import java.security.SecureRandom;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;

class RandomString {

    /**
     * Generate a random string.
     */
    public String nextString() {
        for (int idx = 0; idx < buf.length; ++idx)
            buf[idx] = symbols[random.nextInt(symbols.length)];
        return new String(buf);
    }

    private static final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static final String lower = upper.toLowerCase(Locale.ROOT);

    private static final String digits = "0123456789";

    private static final String alpha = upper + lower;

    private static final String alphanum = upper + lower + digits;

    private final Random random;

    private final char[] symbols;

    private final char[] buf;

    public RandomString(int length, Random random, boolean useDigits) {
        if (length < 1) throw new IllegalArgumentException();
        this.random = Objects.requireNonNull(random);

        if (useDigits) {
            this.symbols = alphanum.toCharArray();
        } else {
            this.symbols = alpha.toCharArray();
        }

        this.buf = new char[length];
    }

    public RandomString(int length, boolean useDigits) {
        this(length, new SecureRandom(), useDigits);
    }



    public RandomString(int length) {
        this(length, true);
    }

    public RandomString() {
        this(21, true);
    }

}