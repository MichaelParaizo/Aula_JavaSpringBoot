package com.devsuperior.aulafirst;

import com.devsuperior.aulafirst.entities.Order;
import com.devsuperior.aulafirst.services.OrderService;
import com.devsuperior.aulafirst.services.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class AulafirstApplication implements CommandLineRunner {

	@Autowired
	private OrderService orderService;
	@Autowired
	private ShippingService shippingService;

	public AulafirstApplication() {
	}

	public static void main(String[] args) {

		SpringApplication.run(AulafirstApplication.class, args);


	}

	@Override
	public void run(String... args) throws Exception {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Digite código do pedido: ");
		Integer code = sc.nextInt();
		System.out.printf("Digite o valor básico: ");
		Double basic = sc.nextDouble();
		System.out.printf("Desconto: ");
		Double discount = sc.nextDouble();

		Order order = new Order(code,basic,discount);
		System.out.println("Pedido código: " + code);
		System.out.println("Valor total: R$ " + String.format("%.2f",orderService.total(order)));

		sc.close();
	}
}
