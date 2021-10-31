package com.streammovies.security;

public interface ICryptorPassword {
    String hash(String pwOrigin);
    boolean verifyPassword(String pwOrigin, String pwHash);
}
