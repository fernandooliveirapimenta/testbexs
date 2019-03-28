package com.bexs.viagem.file;

import com.bexs.viagem.util.Constants;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;

public class LoadFileTest {

    @Test
    public void loadTrue(){
        LoadFile.load(Constants.FILE_NAME);
        final File file = LoadFile.getFile();
        Assert.assertTrue(file.exists());
    }

    @Test
    public void loadFalse(){
        LoadFile.load("notfound.csv");
        final File file = LoadFile.getFile();
        Assert.assertFalse(file.exists());
    }
}
