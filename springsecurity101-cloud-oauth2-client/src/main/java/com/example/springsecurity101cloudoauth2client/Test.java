package com.example.springsecurity101cloudoauth2client;

import org.springframework.core.io.InputStreamResource;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.security.KeyPair;

public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(
                new InputStreamResource(new FileInputStream("/Users/wangjiankai/IdeaProjects/wangjiankai/springsecurity101-cloud-oauth2-server/src/main/resources/mytest.jks")),
                "mypass".toCharArray());
        KeyPair keyPair = keyStoreKeyFactory.getKeyPair("mytest");
        System.out.println(keyPair.getPublic());
        System.out.println(keyPair.getPrivate().getAlgorithm());
        String verifierKey = "-----BEGIN PUBLIC KEY-----\n" + new String(
                Base64.encode( keyPair.getPublic().getEncoded() )
        )
                + "\n-----END PUBLIC KEY-----";
        System.out.println(verifierKey);
    }
}