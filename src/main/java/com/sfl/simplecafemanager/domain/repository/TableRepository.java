package com.sfl.simplecafemanager.domain.repository;

import com.sfl.simplecafemanager.domain.entity.table.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableRepository extends JpaRepository<Table,Long> {
}
