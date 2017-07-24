/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import javax.ejb.Stateless;
import Session.BookingFacade;
import Session.FacilityFacade;
import Session.RegisteredMemberFacade;
import Entity.Booking;
import Entity.Facility;
import Entity.RegisteredMember;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author ASUS
 */
@Stateless
public class PortEcoBusiness {

    @EJB
    private FacilityFacade ff;
    
    //-- get all facilities from database --//
    public List<Facility> getAllFacilities(){
        return ff.findAll();
    }
    
    //-- add new facility into database --/
    public void addNewFacility(Facility f){
        ff.create(f);
    }
    
    public Facility getFacilityWithId(Long id) throws BusinessException{
        Facility f = ff.find(id);
        if (f == null) {
            throw new BusinessException("Facility does not exit");
        }
        
        return ff.find(id);
    }
    
    @EJB
    private BookingFacade bf;
    
    public void addNewBooking(Booking b){
        bf.create(b);
    }
    
    @EJB
    private RegisteredMemberFacade rmf;
    
    public void addNewMember(RegisteredMember rm){
        rmf.create(rm);
    }
    
    public Boolean loginValidation(String userName, String password){        
        return rmf.checkLogin(userName, password);
    }
    
    public RegisteredMember getLoginMember(String userName, String password){
        return rmf.getMember(userName, password);
    }
    
    public List<RegisteredMember> getAllMemberList(){
        return rmf.getAllMember();
    }
    
    public List<RegisteredMember> getAllAdminList(){
        return rmf.getAllAdmin();
    }
    
    public void updateMember(RegisteredMember r){
        rmf.edit(r);
    }
    
    public RegisteredMember getAdminPerson(){
        return rmf.getAdminActive();
    }
    
    
    
}
