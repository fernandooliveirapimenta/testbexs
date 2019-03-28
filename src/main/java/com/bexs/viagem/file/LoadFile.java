package com.bexs.viagem.file;

import java.io.*;

/**
 * Responsavel por carregar o arquivo para memoria.
 */
public class LoadFile {

    private static File file;

    private LoadFile() {
    }

    public static void load(String fileName) {
        if (fileName != null && !fileName.isEmpty()) {
            file = new File(fileName);
        } else {
            throw new RuntimeException("file not specified");
        }
    }

    public static File getFile(){
        return file;
    }

}
