package com.bexs.viagem.model;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class ViagemTest {

    @Test
    public void addRoute(){
        Viagem viagem = getViagem();
        Assert.assertEquals(viagem.getVal(), BigDecimal.valueOf(125L));
    }

    private Viagem getViagem() {
        Viagem viagem = new Viagem();
        viagem.addRoute(new Route("A","B", BigDecimal.valueOf(100L)));
        viagem.addRoute(new Route("B","C", BigDecimal.valueOf(10L)));
        viagem.addRoute(new Route("C","A", BigDecimal.valueOf(15L)));
        return viagem;
    }

    @Test
    public void isTo(){
        Assert.assertTrue(getViagem().isTo("A"));
        Assert.assertFalse(getViagem().isTo("C"));
    }

    @Test
    public void toStringTest(){
        Assert.assertEquals("A - B - C - A > $125", getViagem().toString());
    }
}
