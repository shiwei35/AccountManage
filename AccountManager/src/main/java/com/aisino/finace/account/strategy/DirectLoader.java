package com.aisino.finace.account.strategy;

import java.security.SecureClassLoader;

/** Simple-minded loader for constructed classes. */
public class DirectLoader extends SecureClassLoader{
    protected DirectLoader() {
        super(DirectLoader.class.getClassLoader());
    }

    protected Class load(String name, byte[] data) {
        return super.defineClass(name, data, 0, data.length);
    }
}
