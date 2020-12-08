package com.sfl.simplecafemanager.domain.entity.order;

import com.sfl.simplecafemanager.util.PostgreSQLEnumType;
import com.sfl.simplecafemanager.domain.entity.table.Table;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Set;


@Entity
@TypeDef(
        name = "order_status",
        typeClass = PostgreSQLEnumType.class
)
@javax.persistence.Table (name = "order", schema = "public")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    @Type(type = "order_status")
    @Column(name = "order_status")
    private OrderStatus orderStatus;

    @ManyToOne
    @JoinColumn(name = "table_id")
    private Table table;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "order")
    private Set<ProductInOrder> productInOrderSet;

    public Order() {
    }

    public Order(OrderStatus orderStatus, com.sfl.simplecafemanager.domain.entity.table.Table table, Set<ProductInOrder> productInOrderSet) {
        this.orderStatus = orderStatus;
        this.table = table;
        this.productInOrderSet = productInOrderSet;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public com.sfl.simplecafemanager.domain.entity.table.Table getTable() {
        return table;
    }

    public void setTable(com.sfl.simplecafemanager.domain.entity.table.Table table) {
        this.table = table;
    }

    public Set<ProductInOrder> getProductInOrderSet() {
        return productInOrderSet;
    }

    public void setProductInOrderSet(Set<ProductInOrder> productInOrderSet) {
        this.productInOrderSet = productInOrderSet;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderStatus=" + orderStatus +
                ", orderTable=" + table +
                '}';
    }
}
