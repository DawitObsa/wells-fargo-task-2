// File: src/main/java/com/wellsfargo/portfolio/entity/Advisor.java
package com.wellsfargo.portfolio.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "advisors")
public class Advisor extends BaseEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "advisor_id")
    private Long advisorId;
    
    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;
    
    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;
    
    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;
    
    @Column(name = "phone", length = 20)
    private String phone;
    
    @Column(name = "employee_id", nullable = false, unique = true, length = 20)
    private String employeeId;
    
    @Column(name = "office_branch", length = 100)
    private String officeBranch;
    
    @OneToMany(mappedBy = "advisor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Client> clients = new ArrayList<>();
    
    // Constructor
    public Advisor() {}
    
    public Advisor(String firstName, String lastName, String email, String phone, 
                   String employeeId, String officeBranch) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.employeeId = employeeId;
        this.officeBranch = officeBranch;
    }
    
    // Getters and setters
    public Long getAdvisorId() { return advisorId; }
    
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    
    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }
    
    public String getOfficeBranch() { return officeBranch; }
    public void setOfficeBranch(String officeBranch) { this.officeBranch = officeBranch; }
    
    public List<Client> getClients() { return clients; }
    public void setClients(List<Client> clients) { this.clients = clients; }
    
    // Helper methods
    public void addClient(Client client) {
        clients.add(client);
        client.setAdvisor(this);
    }
    
    public void removeClient(Client client) {
        clients.remove(client);
        client.setAdvisor(null);
    }
}