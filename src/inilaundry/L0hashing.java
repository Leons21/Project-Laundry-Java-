/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inilaundry;

import at.favre.lib.crypto.bcrypt.BCrypt;
import at.favre.lib.bytes.Bytes;

/**
 *
 * @author HP
 */
public class L0hashing {
    public String bcryptHashing(String password) {
        return BCrypt.withDefaults().hashToString(12, password.toCharArray());
    }

    public boolean bcryptVerify(String password, String hash) {
        BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), hash);
        return result.verified;
    }
}
