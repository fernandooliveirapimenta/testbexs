package com.bexs.viagem.dao;

import com.bexs.viagem.file.LoadFile;
import com.bexs.viagem.model.Route;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class RouteDAO {

    private static Set<Route> routes = new HashSet<>();

    private RouteDAO(){

    }

    private static void loadRoutes(){
        File file = LoadFile.getFile();

    }
}
