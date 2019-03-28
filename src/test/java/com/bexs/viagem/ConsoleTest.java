package com.bexs.viagem;

import org.junit.Assert;
import org.junit.Test;

public class ConsoleTest {

    @Test
    public void isValid(){
        Console console = new Console(null);
        Assert.assertTrue(console.isValid("GRU-CDG"));
        Assert.assertTrue(console.isValid("FFF-CDG"));
        Assert.assertFalse(console.isValid("GRU--CDG"));
        Assert.assertFalse(console.isValid("GRU"));
        Assert.assertFalse(console.isValid("GRU-"));
        Assert.assertFalse(console.isValid("-"));
    }
}
