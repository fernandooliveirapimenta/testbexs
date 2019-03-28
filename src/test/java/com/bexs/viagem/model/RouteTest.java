package com.bexs.viagem.model;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class RouteTest {

    @Test
    public void csv(){
        Route route = new Route("GRU","CDG", BigDecimal.valueOf(50L));
        Assert.assertEquals("GRU,CDG,50", route.csv());
    }
}
