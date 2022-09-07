package edu.wctc.salesrpttoolspringassignment_mod2.impl;

import edu.wctc.salesrpttoolspringassignment_mod2.Sale;
import edu.wctc.salesrpttoolspringassignment_mod2.iface.ShippingPolicy;

public class ShippingPolicy_TwentyFive implements ShippingPolicy {
    @Override

    public void shippingCharge(Sale eachSale) {
        double newShipCharge = (Double.parseDouble(eachSale.getSalesAmount())+Double.parseDouble((eachSale.getSalesTax())))*.25;
        eachSale.setShippingCharge(String.valueOf(newShipCharge));
    }
}
