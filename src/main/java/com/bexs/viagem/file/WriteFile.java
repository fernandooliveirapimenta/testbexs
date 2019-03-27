package com.bexs.viagem.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Responsavel por realizar escritas no arquivo
 */
public class WriteFile {

    public void writeNewLine(String val, File file) throws IOException {
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(file,true));
        buffWrite.write(val);
        buffWrite.close();
    }
}
