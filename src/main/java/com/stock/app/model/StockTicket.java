package com.stock.app.model;

import com.stock.app.dto.StockTicketDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "stock_ticket")
@Entity
public class StockTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "stock_name", unique = true)
    private String stockName;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "last_updated")
    private LocalDateTime lastUpdated;

    public StockTicket(StockTicketDTO stockTicketDTO) {
        LocalDateTime currenDate = LocalDateTime.now();
        this.stockName = stockTicketDTO.getStockName();
        createdDate = currenDate;
        lastUpdated = currenDate;
    }
}
