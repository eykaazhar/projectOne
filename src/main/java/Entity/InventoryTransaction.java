/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author ASUS
 */
@Entity
@NamedQueries({
    @NamedQuery(name="InventoryTransaction.GetChosenInventoryTransaction", query="SELECT i FROM InventoryTransaction i WHERE i.inventoryId.id = :invID"),
    @NamedQuery(name="InventoryTransaction.GetChosenRequestTransaction", query="SELECT i FROM InventoryTransaction i WHERE i.invtRequestId.id = :invReqID"),
    @NamedQuery(name="InventoryTransaction.GetAllInventoryTransaction", query="SELECT i FROM InventoryTransaction i WHERE i.transactionFor = 'Inventory'"),
    @NamedQuery(name="InventoryTransaction.GetAllRequestTransaction", query="SELECT i FROM InventoryTransaction i WHERE i.transactionFor = 'Request'"),
    @NamedQuery(name="InventoryTransaction.GetMemberTransaction", query="SELECT i FROM InventoryTransaction i WHERE i.memberId.id = :memberID")
})
public class InventoryTransaction implements Serializable {

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
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateIssued;  
    @Basic
    private String givenBy;    
    @Basic
    private String receivedBy;   
    @OneToOne(targetEntity = RegisteredMember.class)
    private RegisteredMember memberId;
    @OneToOne(targetEntity = Inventory.class)
    private Inventory inventoryId;
    @OneToOne(targetEntity = InventoryRequest.class)
    private InventoryRequest invtRequestId;
    @Basic
    private String assigner;
    @Basic
    private String transactionPurpose;
    @Basic
    private String transactionFor;
   

    public Date getDateIssued() {
        return dateIssued;
    }

    public void setDateIssued(Date dateIssued) {
        this.dateIssued = dateIssued;
    }

    public String getGivenBy() {
        return givenBy;
    }

    public void setGivenBy(String givenBy) {
        this.givenBy = givenBy;
    }

    public String getReceivedBy() {
        return receivedBy;
    }

    public void setReceivedBy(String receivedBy) {
        this.receivedBy = receivedBy;
    }

    public RegisteredMember getMemberId() {
        return memberId;
    }

    public void setMemberId(RegisteredMember memberId) {
        this.memberId = memberId;
    }

    public Inventory getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Inventory inventoryId) {
        this.inventoryId = inventoryId;
    }

    public String getAssigner() {
        return assigner;
    }

    public void setAssigner(String assigner) {
        this.assigner = assigner;
    }

    public String getTransactionPurpose() {
        return transactionPurpose;
    }

    public void setTransactionPurpose(String transactionPurpose) {
        this.transactionPurpose = transactionPurpose;
    }

    public InventoryRequest getInvtRequestId() {
        return invtRequestId;
    }

    public void setInvtRequestId(InventoryRequest invtRequestId) {
        this.invtRequestId = invtRequestId;
    }

    public String getTransactionFor() {
        return transactionFor;
    }

    public void setTransactionFor(String transactionFor) {
        this.transactionFor = transactionFor;
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
        if (!(object instanceof InventoryTransaction)) {
            return false;
        }
        InventoryTransaction other = (InventoryTransaction) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.InventoryTransaction[ id=" + id + " ]";
    }
    
}
