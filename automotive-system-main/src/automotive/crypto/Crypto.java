/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package automotive.crypto;

import java.security.Key;
import javax.crypto.Cipher;

/**
 *
 * @author renir
 */
public abstract class Crypto {

    protected Cipher cipher;

    public Crypto(String algorithm) {
        try {
            cipher = Cipher.getInstance(algorithm);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public abstract String encrypt(String data, Key key) throws Exception;

    public abstract String decrypt(String cipherTxt, Key key) throws Exception;

}
