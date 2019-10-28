package com.design.pattern.FactoryMethod;

/**
 * @Author: kk
 * @Date: 2019-10-21 19:37
 * @Description:
 */
public class Main {
    public static void main(String[] args) {

        VolvoFactory volvoFactory = new VolvoFactory();
        volvoFactory.product().show();;

        BMWFactory bmwFactory = new BMWFactory();
        bmwFactory.product().show();

        HondaFactory hondaFactory = new HondaFactory();
        hondaFactory.product().show();
    }
}
