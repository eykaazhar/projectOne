/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import Entity.InventoryRequest;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ASUS
 */
@Stateless
public class InventoryRequestFacade extends AbstractFacade<InventoryRequest> {

    @PersistenceContext(unitName = "eyka_PortEcoHouse_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InventoryRequestFacade() {
        super(InventoryRequest.class);
    }
    
}
