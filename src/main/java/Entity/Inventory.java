/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

/**
 *
 * @author ASUS
 */
@Entity
@NamedQueries({
    @NamedQuery(name="Inventory.GetChosenInventory", query="SELECT i FROM Inventory i WHERE i.id = :invID"),
    @NamedQuery(name="Inventory.Search", query="SELECT i FROM Inventory i WHERE UPPER(i.equipmentName) LIKE UPPER(:searchKeyword) escape '\\'"),
    @NamedQuery(name="Inventory.GetAvailableInventory", query="SELECT i FROM Inventory i WHERE i.status = 'available'")
})
public class Inventory implements Serializable {

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
    private String equipmentName;    
    @Basic
    private String equipmentDescription;    
    @Basic
    private String make;    
    @Basic
    private String model;    
    @Basic
    private String serialNumber;    
    @Basic
    private String accessories;    
    @Basic
    private String patReference;    
    @Basic
    private String battery;    
    @Basic
    private int total;    
    @Basic 
    private String status;
//    @Basic
//    private String currentUser;
    @OneToOne(targetEntity = RegisteredMember.class)
    private RegisteredMember currentUser;

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public String getEquipmentDescription() {
        return equipmentDescription;
    }

    public void setEquipmentDescription(String equipmentDescription) {
        this.equipmentDescription = equipmentDescription;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getAccessories() {
        return accessories;
    }

    public void setAccessories(String accessories) {
        this.accessories = accessories;
    }

    public String getPatReference() {
        return patReference;
    }

    public void setPatReference(String patReference) {
        this.patReference = patReference;
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public RegisteredMember getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(RegisteredMember currentUser) {
        this.currentUser = currentUser;
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
        if (!(object instanceof Inventory)) {
            return false;
        }
        Inventory other = (Inventory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Inventory[ id=" + id + " ]";
    }
    
}
