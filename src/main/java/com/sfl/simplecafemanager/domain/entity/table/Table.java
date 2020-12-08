package com.sfl.simplecafemanager.domain.entity.table;

import com.sfl.simplecafemanager.util.PostgreSQLEnumType;
import com.sfl.simplecafemanager.domain.entity.order.Order;
import com.sfl.simplecafemanager.domain.entity.user.User;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.Set;

@Entity
@TypeDef(
        name = "table_type",
        typeClass = PostgreSQLEnumType.class
)
@javax.persistence.Table (name = "table", schema = "public")
public class Table {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User waiter;

    @Column(name = "table_type")
    @Type(type = "table_type")
    @Enumerated(EnumType.STRING)
    private TableType tableType;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "table")
    private Set<Order> orders;

    public Table() {
    }

    public Table(TableType tableType, User waiter, Set<Order> orders) {
        this.tableType = tableType;
        this.waiter = waiter;
        this.orders = orders;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TableType getTableType() {
        return tableType;
    }

    public void setTableStatus(TableType tableType) {
        this.tableType = tableType;
    }

    public User getWaiter() {
        return waiter;
    }

    public void setWaiter(User waiter) {
        this.waiter = waiter;
    }

    @Override
    public String toString() {
        return "Table{" +
                "id=" + id +
                ", waiter=" + waiter +
                ", tableType=" + tableType +
                '}';
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}
