package com.bexs.viagem.util;

import com.bexs.viagem.dao.RouteDAO;
import com.bexs.viagem.file.LoadFile;
import org.junit.Assert;
import org.junit.Test;

public class BestRouteImplTest {

    @Test
    public void calc(){
        LoadFile.load(Constants.FILE_NAME);
        BestRouteInterface bestRouteInterface = new BestRouteImpl(new RouteDAO(LoadFile.getFile()));
        final String calc = bestRouteInterface.calc("GRU", "CDG");
        Assert.assertEquals("GRU - BRC - SCL - ORL - CDG > $40.0", calc);
    }
}
