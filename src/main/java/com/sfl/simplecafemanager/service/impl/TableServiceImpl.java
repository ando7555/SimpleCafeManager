package com.sfl.simplecafemanager.service.impl;

import com.sfl.simplecafemanager.domain.entity.order.Order;
import com.sfl.simplecafemanager.domain.entity.table.Table;
import com.sfl.simplecafemanager.domain.repository.TableRepository;
import com.sfl.simplecafemanager.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TableServiceImpl implements com.sfl.simplecafemanager.service.TableService {

    private final TableRepository tableRepository;

    @Autowired
    public TableServiceImpl(TableRepository tableRepository) {
        this.tableRepository = tableRepository;
    }

    @Override
    public Table saveTable(com.sfl.simplecafemanager.domain.entity.table.Table table){
        return tableRepository.save(table);
    }

    @Override
    public Table getTableById(long id){
        return tableRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource not found for this id " + id));
    }

    @Override
    public List<Table> getAllTables(){
        return tableRepository.findAll();
    }

    @Override
    public Table updateTable(Table table){
        long id = table.getId();
        Optional<Table> optionalTable = tableRepository.findById(id);
        if (optionalTable.isPresent()) {
            return tableRepository.save(table);
        }
        throw new ResourceNotFoundException("Resource not found for this id " + id);
    }
}
