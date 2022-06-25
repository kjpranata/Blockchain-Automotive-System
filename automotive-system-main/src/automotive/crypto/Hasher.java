/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automotive.crypto;

import java.security.*;
import java.security.SecureRandom;
import org.apache.commons.codec.binary.Hex;

/**
 *
 * @author renir
 */
public class Hasher {

    public static String hash(String data, String algo) {
        String hash = null;
        try {
            byte[] hashBytes;
            MessageDigest md = MessageDigest.getInstance(algo);
            // fetch data in byte array
            md.update(data.getBytes());
            //md.update(get(16));
            // generate hashBytes from MessageDigest
            hashBytes = md.digest();

            // Using base64, array to string
            //hash = Base64.getEncoder().encodeToString(hashBytes);
            hash = String.valueOf(Hex.encodeHex(hashBytes));

        } catch (NoSuchAlgorithmException e) {
        }
        return hash;
    }

    public static byte[] get(int bit) {
        SecureRandom sr = new SecureRandom();
        byte[] b = new byte[bit];
        sr.nextBytes(b);
        return b;
    }

}
