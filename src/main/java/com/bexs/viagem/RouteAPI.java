package com.bexs.viagem;

import com.bexs.viagem.dao.RouteDAO;
import com.bexs.viagem.file.LoadFile;
import com.bexs.viagem.model.Route;
import com.bexs.viagem.util.BestRouteImpl;
import com.bexs.viagem.util.BestRouteInterface;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequestMapping(value = "/api/route")
public class RouteAPI {

    @GetMapping(value = "/{from}/{to}")
    public String bestRoute(@PathVariable String from, @PathVariable String to) {
       BestRouteInterface bestRouteInterface = new BestRouteImpl(new RouteDAO(LoadFile.getFile()));
       return bestRouteInterface.calc(from,to);
    }

    @PostMapping
    public void addNewRoute(@RequestBody Route route) throws IOException {
        RouteDAO dao = new RouteDAO(LoadFile.getFile());
        dao.save(route);
    }
}
