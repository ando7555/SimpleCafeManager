package com.sfl.simplecafemanager.domain.entity.order;

import com.sfl.simplecafemanager.domain.entity.product.Product;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@javax.persistence.Table(name = "product_in_order",schema = "public")
public class ProductInOrder{

    @EmbeddedId
    private ProductInOrderId id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "orders_id", referencedColumnName = "id",insertable=false, updatable=false)
    private Order order;

    @OneToOne
    @JoinColumn(name = "product_id",referencedColumnName = "id", insertable=false, updatable=false)
    private Product product;

    @Column(name = "amount")
    private BigDecimal amount;

    public ProductInOrder(BigDecimal amount, Order order, Product product) {
        this.amount = amount;
        this.order = order;
        this.product = product;
    }

    public ProductInOrder() {
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Order getProductOrder() {
        return order;
    }

    public Order getOrder() {
        return order;
    }

    public void setProductOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "ProductInOrder{" +
                "amount=" + amount +
                ", order=" + order +
                ", product=" + product +
                '}';
    }
}
