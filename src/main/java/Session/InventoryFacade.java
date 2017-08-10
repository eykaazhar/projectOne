/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import Entity.Inventory;
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
public class InventoryFacade extends AbstractFacade<Inventory> {

    @PersistenceContext(unitName = "eyka_PortEcoHouse_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InventoryFacade() {
        super(Inventory.class);
    }
    
    public Inventory getChosenInventory(Long invID){
        TypedQuery<Inventory> Query=getEntityManager().createNamedQuery("Inventory.GetChosenInventory", Inventory.class);
        Query.setParameter("invID", invID);
        return Query.getSingleResult();
    }
    
    public List<Inventory> getSearchResult(String searchKeyword){
        TypedQuery<Inventory> Query=getEntityManager().createNamedQuery("Inventory.Search", Inventory.class);
        Query.setParameter("searchKeyword", searchKeyword);
        return Query.getResultList();
    }
    
    public List<Inventory> getAvailableInventory(){
        TypedQuery<Inventory> Query = getEntityManager().createNamedQuery("Inventory.GetAvailableInventory", Inventory.class);
        return Query.getResultList();
    }
    
    public List<Inventory> getMemberInventory(Long memberID){
        TypedQuery<Inventory> Query=getEntityManager().createNamedQuery("Inventory.GetMemberInventory", Inventory.class);
        Query.setParameter("memberID", memberID);
        return Query.getResultList();
    }
}
