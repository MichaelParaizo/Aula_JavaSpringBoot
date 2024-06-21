package com.devsuperior.aulafirst.services;

import com.devsuperior.aulafirst.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private ShippingService shippingService;

    public double total(Order order){

        double percentual = order.getBasic() * (order.getDiscount() / 100);

      return order.getBasic()- percentual + shippingService.shipment(order);
    }

}
