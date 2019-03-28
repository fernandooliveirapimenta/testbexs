package com.bexs.viagem;

import com.bexs.viagem.util.BestRouteInterface;

import java.util.Scanner;

public class Console {

    private BestRouteInterface bestRoute;

    Console(BestRouteInterface bestRoute){
        this.bestRoute = bestRoute;
    }

    void init(){
       while (true){
     		Scanner scanner= new Scanner(System.in);
			String route;
			System.out.print("please enter the route: ");
			route = scanner.nextLine();
			if(isValid(route)) {
                final String[] split = route.split("-");
                final String calc = this.bestRoute.calc(split[0], split[1]);
                System.out.println("best route: "+ calc);
            } else {
                System.out.println("Invalid route");
            }
       }
    }

    public boolean isValid(String route){
       return route !=null && !route.isEmpty() && route.contains("-") && route.split("-").length == 2;
    }
}
