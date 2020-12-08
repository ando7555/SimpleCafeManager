package com.sfl.simplecafemanager.domain.entity.product;

import com.sfl.simplecafemanager.domain.entity.order.ProductInOrder;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@javax.persistence.Table (name = "product", schema = "public")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "field name is required")
    @Column(name = "name")
    private String name;

    @Min(value = 0, message = "price must be great than 0")
    @Column(name = "price")
    private BigDecimal price;

    @OneToOne(mappedBy = "product")
    private ProductInOrder productInOrder;

    public Product() {
    }

    public Product(BigDecimal price, ProductInOrder productInOrder, String name) {
        this.price = price;
        this.productInOrder = productInOrder;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public ProductInOrder getProductInOrder() {
        return productInOrder;
    }

    public void setProductInOrder(ProductInOrder productInOrder) {
        this.productInOrder = productInOrder;
    }

    public String getName() {
        return name;
    }

    public void setName(String title) {
        this.name = title;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
