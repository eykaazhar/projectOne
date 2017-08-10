/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;


import Entity.InventoryTransaction;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author ASUS
 */
@Stateless
public class InventoryTransactionFacade extends AbstractFacade<InventoryTransaction> {

    @PersistenceContext(unitName = "eyka_PortEcoHouse_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InventoryTransactionFacade() {
        super(InventoryTransaction.class);
    }  
    
    public List<InventoryTransaction> getChosenInvtTransaction(Long ivtID){
        TypedQuery<InventoryTransaction> Query=getEntityManager().createNamedQuery("InventoryTransaction.GetChosenInventoryTransaction", InventoryTransaction.class);
        Query.setParameter("invID", ivtID);
        return Query.getResultList();
    }
    
    public List<InventoryTransaction> getAllInvtTransaction(){
        TypedQuery<InventoryTransaction> Query=getEntityManager().createNamedQuery("InventoryTransaction.GetAllInventoryTransaction", InventoryTransaction.class);
        return Query.getResultList();
    }
    
    public List<InventoryTransaction> getChosenRequestTransaction(Long reqID){
        TypedQuery<InventoryTransaction> Query=getEntityManager().createNamedQuery("InventoryTransaction.GetChosenRequestTransaction", InventoryTransaction.class);
        Query.setParameter("invReqID", reqID);
        return Query.getResultList();
    }
    
    public List<InventoryTransaction> getAllReqTransaction(){
        TypedQuery<InventoryTransaction> Query=getEntityManager().createNamedQuery("InventoryTransaction.GetAllRequestTransaction", InventoryTransaction.class);
        return Query.getResultList();
    }
    
    public List<InventoryTransaction> getMemberTransaction(Long memberID){
        TypedQuery<InventoryTransaction> Query=getEntityManager().createNamedQuery("InventoryTransaction.GetMemberTransaction", InventoryTransaction.class);
        Query.setParameter("memberID", memberID);
        return Query.getResultList();
    }
    
    
}
