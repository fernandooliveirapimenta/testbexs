package com.bexs.viagem.dao;

import com.bexs.viagem.file.LoadFile;
import com.bexs.viagem.model.Route;
import com.bexs.viagem.util.Constants;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Set;

public class RouteDAOTest {

    @Test
    public void routes(){
        final Set<Route> routes = getRouteDAO().routes();
        Assert.assertTrue(routes.size() > 0);
    }

    @Test
    public void save() throws IOException {
        int size = getRouteDAO().routes().size();
        getRouteDAO().save(new Route("FER","LTT", BigDecimal.valueOf(1000L)));
        int newSize = getRouteDAO().routes().size();
        Assert.assertTrue(newSize >=size);
    }

    private RouteDAO getRouteDAO() {
        LoadFile.load(Constants.FILE_NAME);
        return new RouteDAO(LoadFile.getFile());
    }
}
