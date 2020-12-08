package com.sfl.simplecafemanager.domain.entity.order;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProductInOrderId implements Serializable {

    @Column(name = "orders_id",nullable = false)
    private long ordersId;

    @Column(name = "product_id")
    private long productId;

    public ProductInOrderId() {
    }

    public ProductInOrderId(long ordersId, long productId){
        this.ordersId = ordersId;
        this.productId = productId;
    }

    public long getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(long ordersId) {
        this.ordersId = ordersId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductInOrderId that = (ProductInOrderId) o;
        return ordersId == that.ordersId &&
                productId == that.productId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ordersId, productId);
    }
}
