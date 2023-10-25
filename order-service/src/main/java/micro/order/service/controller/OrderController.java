package micro.order.service.controller;

import lombok.RequiredArgsConstructor;
import micro.order.service.data.Customer;
import micro.order.service.data.Product;
import micro.order.service.model.Order;
import micro.order.service.repository.OrderRepository;
import micro.order.service.repository.ProductItemRepository;
import micro.order.service.service.CustomerRestClientService;
import micro.order.service.service.InventoryRestClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private OrderRepository orderRepository;
    private ProductItemRepository productItemRepository;
    private CustomerRestClientService customerRestClientService;
    private InventoryRestClientService inventoryRestClientService;

    @GetMapping("/fullOrder/{id}")
    public Order getOrder(@PathVariable Long id) {
        Order order = orderRepository.findById(id).get();
        Customer customer = customerRestClientService.getCustomerbyId(order.getCustomerId());
        order.setCustomer(customer);
        order.getProductItems().forEach(pi->{
            Product product = inventoryRestClientService.getProductById(pi.getProductId());
            pi.setProduct(product);
        });
        return  order;
    }
}
