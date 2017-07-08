/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import Entity.RegisteredMember;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author ASUS
 */
@Stateless
public class RegisteredMemberFacade extends AbstractFacade<RegisteredMember> {

    @PersistenceContext(unitName = "eyka_PortEcoHouse_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public Boolean checkLogin(String username, String password){
        TypedQuery<RegisteredMember> Query=getEntityManager().createNamedQuery("RegisteredMember.FindUser", RegisteredMember.class);
        Query.setParameter("userName", username);
        Query.setParameter("password", password);
        if (Query.getResultList().isEmpty())
        {
            return Boolean.FALSE;
        }
        else
            return Boolean.TRUE;
    }

    public RegisteredMemberFacade() {
        super(RegisteredMember.class);
    }
    
}
