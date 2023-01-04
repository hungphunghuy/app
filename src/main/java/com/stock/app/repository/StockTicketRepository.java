package com.stock.app.repository;

import com.stock.app.model.StockTicket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockTicketRepository extends JpaRepository<StockTicket, Integer> {
}
