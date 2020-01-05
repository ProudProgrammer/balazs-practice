package org.gaborbalazs.practice.sandbox.encryption;

import java.nio.charset.Charset;

/*
 Sha512Crypt.java

 Created: 18 December 2007

 Java Port By: James Ratcliff, falazar@arlut.utexas.edu

 This class implements the new generation, scalable, SHA512-based
 Unix 'crypt' algorithm developed by a group of engineers from Red
 Hat, Sun, IBM, and HP for common use in the Unix and Linux
 /etc/shadow files.

 The Linux glibc library (starting at version 2.7) includes support
 for validating passwords hashed using this algorithm.

 The algorithm itself was released into the Public Domain by Ulrich
 Drepper <drepper@redhat.com>.  A discussion of the rationale and
 development of this algorithm is at

 http://people.redhat.com/drepper/sha-crypt.html

 and the specification and a sample C language implementation is at

 http://people.redhat.com/drepper/SHA-crypt.txt

 This Java Port is  

 Copyright (c) 2008-2012 The University of Texas at Austin.

 All rights reserved.

 Redistribution and use in source and binary form are permitted
 provided that distributions retain this entire copyright notice
 and comment. Neither the name of the University nor the names of
 its contributors may be used to endorse or promote products
 derived from this software without specific prior written
 permission. THIS SOFTWARE IS PROVIDED "AS IS" AND WITHOUT ANY
 EXPRESS OR IMPLIED WARRANTIES, INCLUDING, WITHOUT LIMITATION, THE
 IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A
 PARTICULAR PURPOSE.

 */

import java.security.MessageDigest;
import java.security.SecureRandom;

/*------------------------------------------------------------------------------
 class
 Sha512Crypt

 ------------------------------------------------------------------------------*/

/**
 * This class defines a method, {@link Sha512Crypt#Sha512Crypt(java.lang.String, java.lang.String, int) Sha512_crypt()},
 * which takes a password and a salt string and generates a Sha512 encrypted password entry.
 * 
 * This class implements the new generation, scalable, SHA512-based Unix 'crypt' algorithm developed by a group of
 * engineers from Red Hat, Sun, IBM, and HP for common use in the Unix and Linux /etc/shadow files.
 * 
 * The Linux glibc library (starting at version 2.7) includes support for validating passwords hashed using this
 * algorithm.
 * 
 * The algorithm itself was released into the Public Domain by Ulrich Drepper &lt;drepper@redhat.com&gt;. A discussion
 * of the rationale and development of this algorithm is at
 * 
 * http://people.redhat.com/drepper/sha-crypt.html
 * 
 * and the specification and a sample C language implementation is at
 * 
 * http://people.redhat.com/drepper/SHA-crypt.txt
 */

public final class Sha512Crypt {

    static private final String SHA512_SALT_PREFIX = "$6$";

    static private final String SHA512_ROUNDS_PREFIX = "rounds=";

    static private final int SALT_LEN_MAX = 16;

    static private final int ROUNDS_DEFAULT = 5000;

    static private final int ROUNDS_MIN = 1000;

    static private final int ROUNDS_MAX = 999999999;

    static private final String SALTCHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

    static private final String ITOA64 = "./0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    static private MessageDigest getSHA512() {
        try {
            return MessageDigest.getInstance("SHA-512");
        } catch (java.security.NoSuchAlgorithmException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * This method actually generates an Sha512 crypted password hash from a plaintext password and a salt.
     * 
     * <p>
     * The resulting string will be in the form '$6$&lt;rounds=n&gt;$&lt;salt&gt;$&lt;hashed mess&gt;
     * </p>
     * 
     * @param keyStr
     *            Plaintext password
     * 
     * @param saltStr
     *            An encoded salt/roundes which will be consulted to determine the salt and round count, if not null
     * 
     * @param roundsCount
     *            If this value is not 0, this many rounds will used to generate the hash text.
     * 
     * @return The Sha512 Unix Crypt hash text for the keyStr
     */

    public static final String sha512Crypt(String keyStr, String saltStr, int roundsCount) {
        MessageDigest ctx = getSHA512();
        MessageDigest altCtx = getSHA512();

        byte[] altResult;
        byte[] tempResult;
        byte[] pBytes = null;
        byte[] sBytes = null;
        int cnt, cnt2;
        int rounds = ROUNDS_DEFAULT; // Default number of rounds.
        StringBuilder buffer;
        boolean includeRoundCount = false;

        /* -- */

        if (saltStr != null) {
            if (saltStr.startsWith(SHA512_SALT_PREFIX)) {
                saltStr = saltStr.substring(SHA512_SALT_PREFIX.length());
            }

            if (saltStr.startsWith(SHA512_ROUNDS_PREFIX)) {
                String num = saltStr.substring(SHA512_ROUNDS_PREFIX.length(), saltStr.indexOf('$'));
                int srounds = Integer.parseInt(num);
                saltStr = saltStr.substring(saltStr.indexOf('$') + 1);
                rounds = Math.max(ROUNDS_MIN, Math.min(srounds, ROUNDS_MAX));
                includeRoundCount = true;
            }

            // gnu libc's crypt(3) implementation allows the salt to end
            // in $ which is then ignored.

            if (saltStr.endsWith("$")) {
                saltStr = saltStr.substring(0, saltStr.length() - 1);
            }

            // Az elozo resz nem az igazi...
            if (saltStr.contains("$")) {
                saltStr = saltStr.substring(0, saltStr.indexOf("$"));
            }

            if (saltStr.length() > SALT_LEN_MAX) {
                saltStr = saltStr.substring(0, SALT_LEN_MAX);
            }
        } else {
            SecureRandom randgen = new java.security.SecureRandom();
            StringBuilder saltBuf = new StringBuilder();

            while (saltBuf.length() < 16) {
                int index = (int) (randgen.nextFloat() * SALTCHARS.length());
                saltBuf.append(SALTCHARS.substring(index, index + 1));
            }

            saltStr = saltBuf.toString();
        }

        if (roundsCount != 0) {
            rounds = Math.max(ROUNDS_MIN, Math.min(roundsCount, ROUNDS_MAX));
        }

        byte[] key = keyStr.getBytes(Charset.forName("UTF-8"));
        byte[] salt = saltStr.getBytes(Charset.forName("UTF-8"));

        ctx.reset();
        ctx.update(key, 0, key.length);
        ctx.update(salt, 0, salt.length);

        altCtx.reset();
        altCtx.update(key, 0, key.length);
        altCtx.update(salt, 0, salt.length);
        altCtx.update(key, 0, key.length);

        altResult = altCtx.digest();

        for (cnt = key.length; cnt > 64; cnt -= 64) {
            ctx.update(altResult, 0, 64);
        }

        ctx.update(altResult, 0, cnt);

        for (cnt = key.length; cnt > 0; cnt >>= 1) {
            if ((cnt & 1) != 0) {
                ctx.update(altResult, 0, 64);
            } else {
                ctx.update(key, 0, key.length);
            }
        }

        altResult = ctx.digest();

        altCtx.reset();

        for (cnt = 0; cnt < key.length; ++cnt) {
            altCtx.update(key, 0, key.length);
        }

        tempResult = altCtx.digest();

        pBytes = new byte[key.length];

        for (cnt2 = 0, cnt = pBytes.length; cnt >= 64; cnt -= 64) {
            System.arraycopy(tempResult, 0, pBytes, cnt2, 64);
            cnt2 += 64;
        }

        System.arraycopy(tempResult, 0, pBytes, cnt2, cnt);

        altCtx.reset();

        for (cnt = 0; cnt < 16 + (altResult[0] & 0xFF); ++cnt) {
            altCtx.update(salt, 0, salt.length);
        }

        tempResult = altCtx.digest();

        sBytes = new byte[salt.length];

        for (cnt2 = 0, cnt = sBytes.length; cnt >= 64; cnt -= 64) {
            System.arraycopy(tempResult, 0, sBytes, cnt2, 64);
            cnt2 += 64;
        }

        System.arraycopy(tempResult, 0, sBytes, cnt2, cnt);

        /*
         * Repeatedly run the collected hash value through SHA512 to burn CPU cycles.
         */

        for (cnt = 0; cnt < rounds; ++cnt) {
            ctx.reset();

            if ((cnt & 1) != 0) {
                ctx.update(pBytes, 0, key.length);
            } else {
                ctx.update(altResult, 0, 64);
            }

            if (cnt % 3 != 0) {
                ctx.update(sBytes, 0, salt.length);
            }

            if (cnt % 7 != 0) {
                ctx.update(pBytes, 0, key.length);
            }

            if ((cnt & 1) != 0) {
                ctx.update(altResult, 0, 64);
            } else {
                ctx.update(pBytes, 0, key.length);
            }

            altResult = ctx.digest();
        }

        buffer = new StringBuilder(SHA512_SALT_PREFIX);

        if (includeRoundCount || rounds != ROUNDS_DEFAULT) {
            buffer.append(SHA512_ROUNDS_PREFIX);
            buffer.append(rounds);
            buffer.append("$");
        }

        buffer.append(saltStr);
        buffer.append("$");

        buffer.append(b64From24bit(altResult[0], altResult[21], altResult[42], 4));
        buffer.append(b64From24bit(altResult[22], altResult[43], altResult[1], 4));
        buffer.append(b64From24bit(altResult[44], altResult[2], altResult[23], 4));
        buffer.append(b64From24bit(altResult[3], altResult[24], altResult[45], 4));
        buffer.append(b64From24bit(altResult[25], altResult[46], altResult[4], 4));
        buffer.append(b64From24bit(altResult[47], altResult[5], altResult[26], 4));
        buffer.append(b64From24bit(altResult[6], altResult[27], altResult[48], 4));
        buffer.append(b64From24bit(altResult[28], altResult[49], altResult[7], 4));
        buffer.append(b64From24bit(altResult[50], altResult[8], altResult[29], 4));
        buffer.append(b64From24bit(altResult[9], altResult[30], altResult[51], 4));
        buffer.append(b64From24bit(altResult[31], altResult[52], altResult[10], 4));
        buffer.append(b64From24bit(altResult[53], altResult[11], altResult[32], 4));
        buffer.append(b64From24bit(altResult[12], altResult[33], altResult[54], 4));
        buffer.append(b64From24bit(altResult[34], altResult[55], altResult[13], 4));
        buffer.append(b64From24bit(altResult[56], altResult[14], altResult[35], 4));
        buffer.append(b64From24bit(altResult[15], altResult[36], altResult[57], 4));
        buffer.append(b64From24bit(altResult[37], altResult[58], altResult[16], 4));
        buffer.append(b64From24bit(altResult[59], altResult[17], altResult[38], 4));
        buffer.append(b64From24bit(altResult[18], altResult[39], altResult[60], 4));
        buffer.append(b64From24bit(altResult[40], altResult[61], altResult[19], 4));
        buffer.append(b64From24bit(altResult[62], altResult[20], altResult[41], 4));
        buffer.append(b64From24bit((byte) 0x00, (byte) 0x00, altResult[63], 2));

        /*
         * Clear the buffer for the intermediate result so that people attaching to processes or reading core dumps
         * cannot get any information.
         */

        ctx.reset();

        return buffer.toString();
    }

    private static final String b64From24bit(byte b2, byte b1, byte b0, int size) {
        int v = ((((int) b2) & 0xFF) << 16) | ((((int) b1) & 0xFF) << 8) | ((int) b0 & 0xff);

        StringBuilder result = new StringBuilder();

        while (--size >= 0) {
            result.append(ITOA64.charAt((int) (v & 0x3f)));
            v >>>= 6;
        }

        return result.toString();
    }

    /**
     * This method tests a plaintext password against a SHA512 Unix Crypt'ed hash and returns true if the password
     * matches the hash.
     * 
     * @param plaintextPass
     *            The plaintext password text to test.
     * @param sha512CryptText
     *            The hash text we're testing against. We'll extract the salt and the round count from this String.
     */

    static public final boolean verifyPassword(String plaintextPass, String sha512CryptText) {
        if (sha512CryptText.startsWith("$6$")) {
            return sha512CryptText.equals(sha512Crypt(plaintextPass, sha512CryptText, 0));
        } else {
            throw new RuntimeException("Bad sha512CryptText");
        }
    }

    /**
     * <p>
     * Returns true if sha512CryptText is a valid Sha512Crypt hashtext, false if not.
     * </p>
     */

    public static final boolean verifyHashTextFormat(String sha512CryptText) {
        if (!sha512CryptText.startsWith(SHA512_SALT_PREFIX)) {
            return false;
        }

        sha512CryptText = sha512CryptText.substring(SHA512_SALT_PREFIX.length());

        if (sha512CryptText.startsWith(SHA512_ROUNDS_PREFIX)) {
            String num = sha512CryptText.substring(SHA512_ROUNDS_PREFIX.length(), sha512CryptText.indexOf('$'));

            try {
                Integer.parseInt(num);
            } catch (NumberFormatException ex) {
                return false;
            }

            sha512CryptText = sha512CryptText.substring(sha512CryptText.indexOf('$') + 1);
        }

        if (sha512CryptText.indexOf('$') > (SALT_LEN_MAX + 1)) {
            return false;
        }

        sha512CryptText = sha512CryptText.substring(sha512CryptText.indexOf('$') + 1);

        for (int i = 0; i < sha512CryptText.length(); i++) {
            if (ITOA64.indexOf(sha512CryptText.charAt(i)) == -1) {
                return false;
            }
        }

        return true;
    }

}
