package com.streammovies.security;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

public class BCryptPassword implements ICryptorPassword {

    private final static int CRYPT_ROUND = 6;

    @Override
    public String hash(String pwOrigin) {
        return BCrypt.hashpw(pwOrigin, BCrypt.gensalt(CRYPT_ROUND));
    }

    @Override
    public boolean verifyPassword(String pwOrigin, String pwHash) {
        return BCrypt.checkpw(pwOrigin, pwHash);
    }


}
