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
import Entity.Inventory;
import Entity.RegisteredMember;
import Session.InventoryFacade;
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
    @EJB
    private InventoryFacade invf;
    @EJB
    private BookingFacade bf;
    @EJB
    private RegisteredMemberFacade rmf;
    
    //-- get all facilities from database --//
    public List<Facility> getAllFacilities(){
        return ff.findAll();
    }    
    //-- add new facility into database --/
    public void addNewFacility(Facility f){
        ff.create(f);
    }    
    //-- get facility with given id --//
    public Facility getFacilityWithId(Long id) throws BusinessException{
        Facility f = ff.find(id);
        if (f == null) {
            throw new BusinessException("Facility does not exit");
        }
        
        return ff.find(id);
    }    
    //-- add new booking request into database --//
    public void addNewBooking(Booking b){
        bf.create(b);
    }
     //-- add new mmeber into database --//   
    public void addNewMember(RegisteredMember rm){
        rmf.create(rm);
    }
    //-- validate entered username and password --//
    public Boolean loginValidation(String userName, String password){        
        return rmf.checkLogin(userName, password);
    }
    //-- get login member details --//
    public RegisteredMember getLoginMember(String userName, String password){
        return rmf.getMember(userName, password);
    }
    //-- get registered member details by given id --//
    public RegisteredMember getMemberByID(Long memberID){
        return rmf.getMemberByID(memberID);
    }
    //-- get all member lists from database --//
    public List<RegisteredMember> getAllMemberList(){
        return rmf.getAllMember();
    }
    //-- get all admin lists from database --//
    public List<RegisteredMember> getAllAdminList(){
        return rmf.getAllAdmin();
    }
    //-- update existing member detail --//
    public void updateMember(RegisteredMember r){
        rmf.edit(r);
    }
    //-- get all active admin for email function --//
    public RegisteredMember getAdminPerson(){
        return rmf.getAdminActive();
    }
    //-- get all inventory list from database --//
    public List<Inventory> getAllInventoriesList(){
        return invf.findAll();
    }
    //-- get inventory by given id --//
    public Inventory getInventoryById(Long invId){
        return invf.getChosenInventory(invId);
    }
    //-- update existing inventory details --//
    public void updateInventory(Inventory invt){
        invf.edit(invt);
    }
    // get inventory list by the search keyword --//
    public List<Inventory> getInventorySearch(String searchKeyword){
        return invf.getSearchResult(searchKeyword);
    }
    //-- assign inventory to registered member --//
    public void saveAssignInvtToMember(Inventory i, RegisteredMember rm){
        invf.edit(i);
        rm = rmf.edit2(rm);
        rm.getInventoryList().add(i);
    }
    //-- save new inventory into database --//
    public void saveNewInventory(Inventory inv){
        invf.create(inv);
        
    }
    //-- get all available inventory --//
    public List<Inventory> getAllAvailableInventory(){
        return invf.getAvailableInventory();
    }
    
    public void returnEquipment(Inventory i, RegisteredMember r){
        invf.edit(i);
        r = rmf.edit2(r);
        r.getInventoryList().remove(i);
    }
    
}
