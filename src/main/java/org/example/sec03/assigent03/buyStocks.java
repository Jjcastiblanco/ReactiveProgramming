package org.example.sec03.assigent03;


import org.example.common.Util;
import org.example.sec03.assigent03.common.DefaultSubscriberImp;
import org.example.sec03.assigent03.client.ExternalServicesClient;


public class buyStocks {

    public static void main(String[] args) {

        var de = new DefaultSubscriberImp();

        var client = new ExternalServicesClient();
        client.getStocks()
                .subscribe(de);

        Util.sleepSeconds(20);
        //Alternative solution
    }

//        AtomicInteger amountInitial = new AtomicInteger(10000);
//        AtomicInteger stocks = new AtomicInteger();
//
//        var client = new ExternalServicesClient();
//        client.getStocks()
//                .filter(buyStocks -> amountInitial.get() > buyStocks)
//                .filter(buyStocks ->  buyStocks > 90)
//                .map(buyStocks -> {
//                    stocks.getAndIncrement();
//                    amountInitial.set(amountInitial.get() - buyStocks);
//                    return buyStocks;
//                })
//                .filter(buyStocks ->  buyStocks > 110 && stocks.get() > 0)
//                .map(buyStocks -> {
//                    amountInitial.set(stocks.get() * buyStocks + amountInitial.get());
//                    stocks.set(0);
//                    return buyStocks;
//                })
//                .subscribe(r -> System.out.println("Amount: " + amountInitial.get() + " Stocks: " + stocks.get()));
//
//
//        Util.sleepSeconds(20);
//    }




}
