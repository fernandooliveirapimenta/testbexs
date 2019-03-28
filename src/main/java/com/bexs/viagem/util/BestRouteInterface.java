package com.bexs.viagem.util;

public interface BestRouteInterface {
    /**
     *
     * @param from = de
     * @param to = para
     * @return ex: GRU - BRC - SCL - ORL - CDG > $40
     */
    String calc(String from, String to);
}
