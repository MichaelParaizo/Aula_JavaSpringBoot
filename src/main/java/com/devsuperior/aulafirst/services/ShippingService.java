package com.devsuperior.aulafirst.services;

import com.devsuperior.aulafirst.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {


    public double shipment (Order order){

         double descont = 0.0;

        if( order.getBasic() < 100){

          descont = 20.00;

        }else if (order.getBasic() >= 100 && order.getBasic() <=200){

            descont = 12.00;

        }

        else {

            descont = 0.0;
        }

        return descont;

    }
}
