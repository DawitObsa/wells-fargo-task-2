// File: src/main/java/com/wellsfargo/portfolio/entity/Security.java
package com.wellsfargo.portfolio.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "securities")
public class Security extends BaseEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "security_id")
    private Long securityId;
    
    @Column(name = "symbol", nullable = false, unique = true, length = 10)
    private String symbol;
    
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    
    @Column(name = "category", length = 50)
    private String category;
    
    @Column(name = "exchange", length = 50)
    private String exchange;
    
    @Column(name = "currency", length = 3)
    private String currency;
    
    @Column(name = "current_price", precision = 19, scale = 4)
    private BigDecimal currentPrice;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "last_price_update")
    private Date lastPriceUpdate;
    
    @OneToMany(mappedBy = "security", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Holding> holdings = new ArrayList<>();
    
    // Constructor
    public Security() {}
    
    public Security(String symbol, String name, String category, String exchange, 
                    String currency, BigDecimal currentPrice) {
        this.symbol = symbol;
        this.name = name;
        this.category = category;
        this.exchange = exchange;
        this.currency = currency;
        this.currentPrice = currentPrice;
        this.lastPriceUpdate = new Date();
    }
    
    // Getters and setters
    public Long getSecurityId() { return securityId; }
    
    public String getSymbol() { return symbol; }
    public void setSymbol(String symbol) { this.symbol = symbol; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    
    public String getExchange() { return exchange; }
    public void setExchange(String exchange) { this.exchange = exchange; }
    
    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }
    
    public BigDecimal getCurrentPrice() { return currentPrice; }
    public void setCurrentPrice(BigDecimal currentPrice) { 
        this.currentPrice = currentPrice; 
        this.lastPriceUpdate = new Date();
    }
    
    public Date getLastPriceUpdate() { return lastPriceUpdate; }
    public void setLastPriceUpdate(Date lastPriceUpdate) { this.lastPriceUpdate = lastPriceUpdate; }
    
    public List<Holding> getHoldings() { return holdings; }
    public void setHoldings(List<Holding> holdings) { this.holdings = holdings; }
}