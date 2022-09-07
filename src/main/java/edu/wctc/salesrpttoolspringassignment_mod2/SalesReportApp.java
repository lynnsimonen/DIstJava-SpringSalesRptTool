package edu.wctc.salesrpttoolspringassignment_mod2;

import edu.wctc.salesrpttoolspringassignment_mod2.iface.SalesInput;
import edu.wctc.salesrpttoolspringassignment_mod2.iface.SalesReport;
import edu.wctc.salesrpttoolspringassignment_mod2.iface.ShippingPolicy;
import edu.wctc.salesrpttoolspringassignment_mod2.impl.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//main and configuration all in one place instead of 2 classes
@ComponentScan("edu.wctc.salesrpttoolspringassignment_mod2")
public class SalesReportApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(SalesReportApp.class);
        context.refresh();

        ((CreateReport)context.getBean("createReport")).start();
    }

    @Bean
    public SalesInput salesInput() {
        return new SalesInput_Csv();
        //return new SalesInput_Manual();
    }

    @Bean
    public ShippingPolicy shippingPolicy() {
        //return new ShippingPolicy_Free();
        return new ShippingPolicy_TwentyFive();
    }

    @Bean
    public SalesReport salesReport() {
        return new SalesReport_Full();
        //return new SalesReport_Summary();
    }
}
