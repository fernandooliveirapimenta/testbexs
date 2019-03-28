package com.bexs.viagem.dao;

import com.bexs.viagem.file.ReadFile;
import com.bexs.viagem.file.WriteFile;
import com.bexs.viagem.model.Route;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Set;
import java.util.stream.Collectors;

public class RouteDAO {

    private WriteFile write;
    private File file;
    private ReadFile reader;

    public RouteDAO(File file){
        this.file = file;
        this.reader = new ReadFile();
        this.write = new WriteFile();
    }

    public Set<Route> routes(){
       Set<String> read = reader.read(file);
       return read
               .stream()
               .map(line -> line.split(","))
               .filter(split -> split.length == 3)
               .map(split -> new Route(split[0], split[1], BigDecimal.valueOf(Double.parseDouble(split[2]))))
               .collect(Collectors.toSet());

    }

    public void save(Route route) throws IOException {
        if(route.getTo() != null
                && route.getFrom() != null
                    && route.getVal() != null
                        && !this.routes().contains(route)) {
            write.writeNewLine(route.csv(),file);
        }
    }
}
