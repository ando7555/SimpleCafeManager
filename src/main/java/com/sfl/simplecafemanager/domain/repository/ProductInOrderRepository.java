package com.sfl.simplecafemanager.domain.repository;

import com.sfl.simplecafemanager.domain.entity.order.ProductInOrder;
import com.sfl.simplecafemanager.domain.entity.order.ProductInOrderId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductInOrderRepository extends JpaRepository<ProductInOrder, ProductInOrderId> {
}
