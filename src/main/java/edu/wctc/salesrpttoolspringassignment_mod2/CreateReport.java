package edu.wctc.salesrpttoolspringassignment_mod2;

import edu.wctc.salesrpttoolspringassignment_mod2.iface.SalesInput;
import edu.wctc.salesrpttoolspringassignment_mod2.iface.SalesReport;
import edu.wctc.salesrpttoolspringassignment_mod2.iface.ShippingPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CreateReport {
    private SalesInput in;
    private SalesReport report;
    private ShippingPolicy shipping;

    @Autowired
    public CreateReport(SalesInput in, SalesReport report, ShippingPolicy shipping) {
        this.in = in;
        this.report = report;
        this.shipping = shipping;

        System.out.println("Report App Created\n\n");
    }

    private List<Sale> sales = new ArrayList<>();

    public void start() {
        List<Sale> newSalesGroup = in.salesInput();

        for (Sale eachSale : newSalesGroup)
        shipping.shippingCharge(eachSale);
        report.displayReport(newSalesGroup);
    }
}
