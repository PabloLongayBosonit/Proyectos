package com.sa2.ficheros.exceptions;

import net.bytebuddy.implementation.bytecode.Throw;

public class StorageFileNotFoundException extends StorageException{
    public StorageFileNotFoundException(String message) {
        super(message);
    }
    public StorageFileNotFoundException(String message, Throwable cause){
        super(message, cause);
    }
}
