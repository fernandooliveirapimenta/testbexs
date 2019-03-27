package com.bexs.viagem.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * Representa a rota da vigem:
 * from,to,val
 * BRC,SCL,5
 * GRU,CDG,75
 * GRU,SCL,20
 * GRU,ORL,56
 * ORL,CDG,5
 * SCL,ORL,20
 * DE-PARA-VALOR
 */
public class Route implements Serializable {

    private String from; //de
    private String to; //para
    private BigDecimal val; //valor

    public Route() {}

    public Route(String from, String to, BigDecimal val) {
        if(from != null && !from.isEmpty()
                && to != null && !to.isEmpty()
                    && val != null) {
            this.from = from;
            this.to = to;
            this.val = val;
        } else {
            System.err.println("Invalid data");
        }

    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigDecimal getVal() {
        return val;
    }

    public void setVal(BigDecimal val) {
        this.val = val;
    }

    public String csv(){
        return from+","+to+","+val.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route = (Route) o;
        return from.equals(route.from) &&
                to.equals(route.to) &&
                val.equals(route.val);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to, val);
    }
}
