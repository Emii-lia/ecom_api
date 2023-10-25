package micro.order.service.service;

import micro.order.service.data.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "inventory-service")
public interface InventoryRestClientService {
    @GetMapping("/productItem/{id}?projection=fullProduct")
    public Product getProductById(@PathVariable Long id);

    @GetMapping("/productItem?projection=fullProduct   AND inventory")
    public PagedModel<Product> getAllProducts();
}
