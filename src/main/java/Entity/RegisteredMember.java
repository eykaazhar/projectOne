/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author ASUS
 */
@Entity
@NamedQueries({
    @NamedQuery(name="RegisteredMember.FindUser", query="SELECT r FROM RegisteredMember r WHERE r.username = :userName AND r.password = :password"),
    @NamedQuery(name="RegisteredMember.AllMember", query="SELECT m FROM RegisteredMember m WHERE m.memberType = 'Member'"),
    @NamedQuery(name="RegisteredMember.AllAdmin", query="SELECT a FROM RegisteredMember a WHERE a.memberType = 'Admin'"),
    @NamedQuery(name="RegisteredMember.FindUserByID", query="SELECT a FROM RegisteredMember a WHERE a.id = :memberID"),
    @NamedQuery(name="RegisteredMember.UnactiveUser", query="UPDATE RegisteredMember r SET r.memberStatus = :newStatus WHERE r.id = :memberID")
})

public class RegisteredMember implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    @Basic
    private String username;    
    @Basic
    private String password;
    @Basic
    private String email;
    @Basic 
    private String contactNumber;
    @Basic 
    private String memberType;
    @Basic
    private String firstName;
    @Basic
    private String lastName;
    @Basic
    private String faculty;
    @Basic
    private String memberStatus;
    
    @OneToMany(targetEntity = Inventory.class)
    @JoinColumn
    private List<Inventory> inventoryList;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getMemberStatus() {
        return memberStatus;
    }

    public void setMemberStatus(String memberStatus) {
        this.memberStatus = memberStatus;
    }

    public List<Inventory> getInventoryList() {
        return inventoryList;
    }

    public void setInventoryList(List<Inventory> inventoryList) {
        this.inventoryList = inventoryList;
    }
        

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RegisteredMember)) {
            return false;
        }
        RegisteredMember other = (RegisteredMember) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.RegisteredMember[ id=" + id + " ]";
    }
    
}
