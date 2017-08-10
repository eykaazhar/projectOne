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
    @NamedQuery(name="InventoryRequest.GetMemberRequest", query="SELECT i FROM InventoryRequest i WHERE i.memberId.id = :memberID"),
    @NamedQuery(name="InventoryRequest.GetAcceptedRequest", query="SELECT i FROM InventoryRequest i WHERE i.status = 'Accepted'")
})

public class InventoryRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(targetEntity = Inventory.class)
    private Inventory firstInventoryId;
    @OneToOne(targetEntity = Inventory.class)
    private Inventory secondInventoryId;
    @OneToOne(targetEntity = Inventory.class)
    private Inventory thirdInventoryId;
    @OneToOne(targetEntity = RegisteredMember.class)
    private RegisteredMember memberId;
    
    @Basic
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateIssued;    
    @Basic
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateBorrowed;    
    @Basic
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateReturned;    
    @Basic
    private String status;
    @Basic 
    private Boolean memberAgreement;
    @Basic
    private String givenOut;
    @Basic
    private String returnedBy;
    @Basic
    private String remarks;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Inventory getFirstInventoryId() {
        return firstInventoryId;
    }

    public void setFirstInventoryId(Inventory firstInventoryId) {
        this.firstInventoryId = firstInventoryId;
    }

    public Inventory getSecondInventoryId() {
        return secondInventoryId;
    }

    public void setSecondInventoryId(Inventory secondInventoryId) {
        this.secondInventoryId = secondInventoryId;
    }

    public Inventory getThirdInventoryId() {
        return thirdInventoryId;
    }

    public void setThirdInventoryId(Inventory thirdInventoryId) {
        this.thirdInventoryId = thirdInventoryId;
    }

    public RegisteredMember getMemberId() {
        return memberId;
    }

    public void setMemberId(RegisteredMember memberId) {
        this.memberId = memberId;
    }

    public Date getDateIssued() {
        return dateIssued;
    }

    public void setDateIssued(Date dateIssued) {
        this.dateIssued = dateIssued;
    }

    public Date getDateBorrowed() {
        return dateBorrowed;
    }

    public void setDateBorrowed(Date dateBorrowed) {
        this.dateBorrowed = dateBorrowed;
    }

    public Date getDateReturned() {
        return dateReturned;
    }

    public void setDateReturned(Date dateReturned) {
        this.dateReturned = dateReturned;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getMemberAgreement() {
        return memberAgreement;
    }

    public void setMemberAgreement(Boolean memberAgreement) {
        this.memberAgreement = memberAgreement;
    }

    public String getGivenOut() {
        return givenOut;
    }

    public void setGivenOut(String givenOut) {
        this.givenOut = givenOut;
    }

    public String getReturnedBy() {
        return returnedBy;
    }

    public void setReturnedBy(String returnedBy) {
        this.returnedBy = returnedBy;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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
        if (!(object instanceof InventoryRequest)) {
            return false;
        }
        InventoryRequest other = (InventoryRequest) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.InventoryRequest[ id=" + id + " ]";
    }
    
}
