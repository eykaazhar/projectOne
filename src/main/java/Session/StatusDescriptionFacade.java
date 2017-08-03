/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import Entity.StatusDescription;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ASUS
 */
@Stateless
public class StatusDescriptionFacade extends AbstractFacade<StatusDescription> {

    @PersistenceContext(unitName = "eyka_PortEcoHouse_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StatusDescriptionFacade() {
        super(StatusDescription.class);
    }
    
}
