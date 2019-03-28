package com.bexs.viagem.file;

import com.bexs.viagem.util.Constants;
import org.junit.Assert;
import org.junit.Test;

import java.util.Set;

public class ReadFileTest {

    @Test
    public void read(){
       LoadFile.load(Constants.FILE_NAME);
       ReadFile readFile = new ReadFile();
       final Set<String> read = readFile.read(LoadFile.getFile());
       Assert.assertTrue(read.size() > 0);
    }
}
