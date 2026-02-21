// File: src/main/java/com/wellsfargo/portfolio/entity/Holding.java
package com.wellsfargo.portfolio.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "holdings")
public class Holding extends BaseEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "holding_id")
    private Long holdingId;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "security_id", nullable = false)
    private Security security;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "purchase_date", nullable = false)
    private Date purchaseDate;
    
    @Column(name = "purchase_price", nullable = false, precision = 19, scale = 4)
    private BigDecimal purchasePrice;
    
    @Column(name = "quantity", nullable = false)
    private Integer quantity;
    
    @Column(name = "current_value", precision = 19, scale = 4)
    private BigDecimal currentValue;
    
    // Constructor
    public Holding() {}
    
    public Holding(Client client, Account account, Security security, Date purchaseDate, 
                   BigDecimal purchasePrice, Integer quantity) {
        this.client = client;
        this.account = account;
        this.security = security;
        this.purchaseDate = purchaseDate;
        this.purchasePrice = purchasePrice;
        this.quantity = quantity;
        calculateCurrentValue();
    }
    
    // Business method
    public void calculateCurrentValue() {
        if (security != null && security.getCurrentPrice() != null && quantity != null) {
            this.currentValue = security.getCurrentPrice().multiply(new BigDecimal(quantity));
        }
    }
    
    // Getters and setters
    public Long getHoldingId() { return holdingId; }
    
    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }
    
    public Account getAccount() { return account; }
    public void setAccount(Account account) { this.account = account; }
    
    public Security getSecurity() { return security; }
    public void setSecurity(Security security) { 
        this.security = security; 
        calculateCurrentValue();
    }
    
    public Date getPurchaseDate() { return purchaseDate; }
    public void setPurchaseDate(Date purchaseDate) { this.purchaseDate = purchaseDate; }
    
    public BigDecimal getPurchasePrice() { return purchasePrice; }
    public void setPurchasePrice(BigDecimal purchasePrice) { this.purchasePrice = purchasePrice; }
    
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { 
        this.quantity = quantity; 
        calculateCurrentValue();
    }
    
    public BigDecimal getCurrentValue() { return currentValue; }
    public void setCurrentValue(BigDecimal currentValue) { this.currentValue = currentValue; }
}