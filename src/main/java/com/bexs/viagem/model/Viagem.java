package com.bexs.viagem.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * ex:  GRU - BRC - SCL - ORL - CDG > $40
 * routes lista com as rotas
 * val: somatoria do val das routes
 */
public class Viagem implements Serializable {

    private List<Route> routes = new ArrayList<>();
    private BigDecimal val = BigDecimal.ZERO;

    public Viagem() {}

    public void addRoute(Route route){
        this.val = this.val.add(route.getVal());
        this.routes.add(route);
    }

    public boolean isTo(String to){
        Route route = this.routes.get(this.routes.size() - 1);
        return route.getTo().equalsIgnoreCase(to);
    }

    public BigDecimal getVal() {
        return val;
    }

    public int connections(){
        return this.routes.size();
    }

    @Override
    public String toString() {
        StringBuilder toString = new StringBuilder();
        if(!this.routes.isEmpty()){
            for (int i = 0; i < this.routes.size() ; i++) {
                final Route route = this.routes.get(i);
                if(i == this.routes.size() - 1){
                    toString.append(route.getFrom()).append(" - ").append(route.getTo()).append(" > $").append(this.val.toString());
                } else {
                    toString.append(route.getFrom()).append(" - ");
                }

            }
        }
        return toString.toString();
    }
}
