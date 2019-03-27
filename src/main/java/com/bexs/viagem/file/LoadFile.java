package com.bexs.viagem.file;

import java.io.*;

/**
 * Singleton responsavel por carregar o arquivo para memoria.
 *
 */
public class LoadFile {

    private static File file;

    private LoadFile() {
    }

    public static File load(String fileName) {
        if (file == null) {

            if (fileName != null && !fileName.isEmpty()) {

                file = new File(fileName);
                return file;

            } else {
                throw new RuntimeException("file not specified");
            }

        } else {
            return file;
        }
    }

    public static File getFile(){
        return file;
    }

}
