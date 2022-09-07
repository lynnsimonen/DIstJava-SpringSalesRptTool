package edu.wctc.salesrpttoolspringassignment_mod2.iface;

import edu.wctc.salesrpttoolspringassignment_mod2.Sale;

import java.util.List;

public interface ShippingPolicy {
    public void shippingCharge(Sale eachSale);
}

