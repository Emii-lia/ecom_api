package micro.order.service;

import micro.order.service.data.Customer;
import micro.order.service.data.Product;
import micro.order.service.model.Order;
import micro.order.service.model.OrderStatus;
import micro.order.service.model.ProductItem;
import micro.order.service.repository.OrderRepository;
import micro.order.service.repository.ProductItemRepository;
import micro.order.service.service.CustomerRestClientService;
import micro.order.service.service.InventoryRestClientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public abstract class OrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }

}
