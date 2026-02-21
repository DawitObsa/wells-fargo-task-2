// File: src/main/java/com/wellsfargo/portfolio/entity/Account.java
package com.wellsfargo.portfolio.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "accounts")
public class Account extends BaseEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long accountId;
    
    @Column(name = "account_number", nullable = false, unique = true, length = 20)
    private String accountNumber;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;
    
    @Column(name = "account_type", nullable = false, length = 30)
    private String accountType;
    
    @Column(name = "account_status", nullable = false, length = 20)
    private String accountStatus;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "date_opened", nullable = false)
    private Date dateOpened;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "date_closed")
    private Date dateClosed;
    
    @Column(name = "cash_balance", precision = 19, scale = 4)
    private BigDecimal cashBalance;
    
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Holding> holdings = new ArrayList<>();
    
    // Constructor
    public Account() {}
    
    public Account(Client client, String accountNumber, String accountType, 
                   String accountStatus, Date dateOpened, BigDecimal cashBalance) {
        this.client = client;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.accountStatus = accountStatus;
        this.dateOpened = dateOpened;
        this.cashBalance = cashBalance;
    }
    
    // Getters and setters
    public Long getAccountId() { return accountId; }
    
    public String getAccountNumber() { return accountNumber; }
    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }
    
    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }
    
    public String getAccountType() { return accountType; }
    public void setAccountType(String accountType) { this.accountType = accountType; }
    
    public String getAccountStatus() { return accountStatus; }
    public void setAccountStatus(String accountStatus) { this.accountStatus = accountStatus; }
    
    public Date getDateOpened() { return dateOpened; }
    public void setDateOpened(Date dateOpened) { this.dateOpened = dateOpened; }
    
    public Date getDateClosed() { return dateClosed; }
    public void setDateClosed(Date dateClosed) { this.dateClosed = dateClosed; }
    
    public BigDecimal getCashBalance() { return cashBalance; }
    public void setCashBalance(BigDecimal cashBalance) { this.cashBalance = cashBalance; }
    
    public List<Holding> getHoldings() { return holdings; }
    public void setHoldings(List<Holding> holdings) { this.holdings = holdings; }
}