// File: src/main/java/com/wellsfargo/portfolio/entity/Client.java
package com.wellsfargo.portfolio.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "clients")
public class Client extends BaseEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private Long clientId;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "advisor_id", nullable = false)
    private Advisor advisor;
    
    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;
    
    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;
    
    @Column(name = "email", length = 100)
    private String email;
    
    @Column(name = "phone", length = 20)
    private String phone;
    
    @Column(name = "address", length = 200)
    private String address;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_birth")
    private Date dateOfBirth;
    
    @Column(name = "tax_id_encrypted", length = 255)
    private String taxIdEncrypted;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "onboarding_date")
    private Date onboardingDate;
    
    @Column(name = "status", length = 20)
    private String status;
    
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Account> accounts = new ArrayList<>();
    
    // Constructor
    public Client() {}
    
    public Client(Advisor advisor, String firstName, String lastName, String email, 
                  String phone, String address, Date dateOfBirth, String taxIdEncrypted) {
        this.advisor = advisor;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.taxIdEncrypted = taxIdEncrypted;
        this.onboardingDate = new Date();
        this.status = "ACTIVE";
    }
    
    // Getters and setters
    public Long getClientId() { return clientId; }
    
    public Advisor getAdvisor() { return advisor; }
    public void setAdvisor(Advisor advisor) { this.advisor = advisor; }
    
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    
    public Date getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(Date dateOfBirth) { this.dateOfBirth = dateOfBirth; }
    
    public String getTaxIdEncrypted() { return taxIdEncrypted; }
    public void setTaxIdEncrypted(String taxIdEncrypted) { this.taxIdEncrypted = taxIdEncrypted; }
    
    public Date getOnboardingDate() { return onboardingDate; }
    public void setOnboardingDate(Date onboardingDate) { this.onboardingDate = onboardingDate; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
    public List<Account> getAccounts() { return accounts; }
    public void setAccounts(List<Account> accounts) { this.accounts = accounts; }
}