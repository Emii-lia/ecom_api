package micro.inventory.service.model;

import org.springframework.data.rest.core.config.Projection;

import java.math.BigDecimal;

@Projection(name = "fullProduct", types = Product.class)
public interface ProductProjection {
    public Long getId();
    public String getName();
    public BigDecimal getPrice();
    public int getQuantity();
}
