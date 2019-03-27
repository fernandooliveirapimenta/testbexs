package com.bexs.viagem.file;

import java.io.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Responsavel por efetuar a leitura do arquivo
 */
public class ReadFile {

    public Set<String> read(File file) {

        Set<String> result = new HashSet<>();
        String line;

        try {

            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                if(!line.isEmpty()){
                    result.add(line);
                }
            }

            bufferedReader.close();
            return result;
        }
        catch(Exception ex) {
            throw new RuntimeException("Error reading file");
        }

    }
}
