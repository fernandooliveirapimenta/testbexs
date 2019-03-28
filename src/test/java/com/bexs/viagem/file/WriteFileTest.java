package com.bexs.viagem.file;

import com.bexs.viagem.util.Constants;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class WriteFileTest {

    @Test
    public void writeNewLine() throws IOException {
        LoadFile.load(Constants.FILE_NAME);
        ReadFile readFile = new ReadFile();
        int size = readFile.read(LoadFile.getFile()).size();
        WriteFile writeFile = new WriteFile();
        writeFile.writeNewLine("GRU,FAR,500", LoadFile.getFile());
        int newSize = readFile.read(LoadFile.getFile()).size();
        Assert.assertTrue(newSize >= size);
    }
}
