package com.sfl.simplecafemanager.service;

import com.sfl.simplecafemanager.domain.entity.table.Table;

import java.util.List;

public interface TableService {
    Table saveTable(Table table);

    Table getTableById(long id);

    List<Table> getAllTables();

    Table updateTable(Table table);
}
