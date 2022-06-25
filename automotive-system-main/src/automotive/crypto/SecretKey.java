/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package automotive.crypto;

import java.security.Key;
import java.util.Arrays;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author renir
 */
public class SecretKey {
    
    private static final String ALGORITHM = "AES";
    
    private final static String SECRET_CHARS = "4ut0mot1v3";
    
    public static Key create() {
        return new SecretKeySpec(Arrays.copyOf(SECRET_CHARS.getBytes(), 16), ALGORITHM);
    }
}
