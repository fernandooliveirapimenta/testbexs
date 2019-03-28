package com.bexs.viagem.util;

import com.bexs.viagem.dao.RouteDAO;
import com.bexs.viagem.model.Route;
import com.bexs.viagem.model.Viagem;

import java.util.*;

/**
 * Implementacao da logica do desafio, retorna a rota mais barata independente de conexoes.
 */
public class BestRouteImpl implements BestRouteInterface {

    private RouteDAO routeDAO;

    public BestRouteImpl(RouteDAO routeDAO){
        this.routeDAO = routeDAO;
    }

    @Override
    public String calc(String from, String to) {
        final Set<Route> routes = routeDAO.routes();
        if(!isValid(routes,from,to)){
            return "Invalid route: (" + from + "-" + to + ")";
        }
        Map<String, List<Route>> index = toMap(routes);
        final List<Viagem> viagens = this.collectRoutes(from, index);
        Viagem lowestPrice = lowestPrice(to, viagens);
        return lowestPrice.toString();
    }


    /**
     * Percorre a lista de viagens e retorna a viagem com o menor preco.
     */
    private Viagem lowestPrice(String to, List<Viagem> viagens) {
        Viagem lowestPrice = null;
        for (Viagem v: viagens){
            if(v.isTo(to)) {
                if(lowestPrice == null) {
                    lowestPrice = v;
                }
                // logica para encontrar o menor preco
                if(v.getVal().compareTo(lowestPrice.getVal()) < 0
                        || (v.getVal().compareTo(lowestPrice.getVal()) == 0 && v.connections() < lowestPrice.connections()) ) {

                    lowestPrice = v;
                }
            }
        }

        if(lowestPrice == null) {
            throw new RuntimeException("failed");
        }
        return lowestPrice;
    }

    /**
     * Valida se existe from ou to no Set de routes
     */
    private boolean isValid(Set<Route> routes, String from, String to){

        boolean fromValid = false;
        boolean toValid = false;

        for (Route route: routes){
            if(route.getFrom().equalsIgnoreCase(from)){
                fromValid = true;
            }
            if(route.getTo().equalsIgnoreCase(to)){
                toValid = true;
            }
        }
        return fromValid && toValid;
    }

    /**
     * @param routes todas as rotas do arquivo
     * @return ex [[GRU, [{GRU,CDG,20}]]
     */
    private Map<String, List<Route>> toMap(Set<Route> routes) {
        Map<String, List<Route>> index = new HashMap<>();
        for (Route route: routes){
            List<Route> val = index.get(route.getFrom());
            if(val == null) {
                val = new ArrayList<>();
                val.add(route);
                index.put(route.getFrom(), val);
            } else {
                val.add(route);
            }
        }
        return index;
    }

    /**
     * Monta lista de @{@link Viagem} que é possivel fazer apartir do from,
     * ex: from = GRU , percorre o map da key{GRU} montando a lista de viagens.
     */
    private List<Viagem> collectRoutes(String from, Map<String, List<Route>> index){
        List<Viagem> collectRoutes = new ArrayList<>();
        final List<Route> fromRoutes = index.get(from.toUpperCase());
        for (Route routeFrom: fromRoutes){
            Viagem viagem = new Viagem();
            viagem.addRoute(routeFrom);
            final List<Route> routesTo = index.get(routeFrom.getTo());
            if(routesTo != null) {
                openNodes(routesTo, index, viagem);
            }
            collectRoutes.add(viagem);
        }
        return collectRoutes;
    }

    /**
     *  Metodo recusivo para montar a viagem com as rotas
     */
    private void openNodes(List<Route> routesReduce, Map<String, List<Route>> index, Viagem viagem) {
        for (Route routeTo: routesReduce){
            viagem.addRoute(routeTo);
            final List<Route> routesTo = index.get(routeTo.getTo());
            if(routesTo == null) {
                return;
            }
            openNodes(routesTo,index,viagem);
        }
    }

}
