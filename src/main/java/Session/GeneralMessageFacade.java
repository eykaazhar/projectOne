/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import Entity.GeneralMessage;
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
public class GeneralMessageFacade extends AbstractFacade<GeneralMessage> {

    @PersistenceContext(unitName = "eyka_PortEcoHouse_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GeneralMessageFacade() {
        super(GeneralMessage.class);
    }
    
    public List<GeneralMessage> getMessage(){
        TypedQuery<GeneralMessage> Query = getEntityManager().createNamedQuery("GeneralMessage.getWaitingMessage", GeneralMessage.class);
        return Query.getResultList();
    }
    
}
