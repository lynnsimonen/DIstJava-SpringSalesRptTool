package edu.wctc.salesrpttoolspringassignment_mod2.impl;

import edu.wctc.salesrpttoolspringassignment_mod2.Sale;
import edu.wctc.salesrpttoolspringassignment_mod2.iface.ShippingPolicy;

import java.util.List;

public class ShippingPolicy_Free implements ShippingPolicy {
    @Override
    public void shippingCharge(Sale eachSale) {
        double newShipCharge = (Double.parseDouble(eachSale.getSalesAmount())+Double.parseDouble((eachSale.getSalesTax())))*0;
        eachSale.setShippingCharge(String.valueOf(newShipCharge));
        }
}
