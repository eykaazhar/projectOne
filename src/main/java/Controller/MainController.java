/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Business.BusinessException;
import Business.PortEcoBusiness;
import Entity.Booking;
import Entity.Facility;
import Entity.RegisteredMember;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.event.ValueChangeEvent;

/**
 *
 * @author ASUS
 */
@Named(value = "mainController")
@SessionScoped
public class MainController implements Serializable {

    //----- Entities used ---//
    Facility facilityID = new Facility();
    List<Facility> facilities = new ArrayList<Facility>();
    Facility newFacility = new Facility();
    Booking newBooking = new Booking();
    List<RegisteredMember> memberList = new ArrayList<RegisteredMember>();
    RegisteredMember newMember = new RegisteredMember();
    Facility selectFacility = new Facility();
    
    //------- List of local variables---//
    private String userId;
    private String userEmail;
    private Date currentDate;
    private Date dateStart;
    private Date dateEnd;
    private String userName;
    private String password;
    private String confrimPasword;
    private String email;
    
    private Long selectedFacilitId;
    private Boolean checkFacility;
    private Boolean checkUserLogin;
    private Boolean checkPassword;

    public Facility getFacilityID() {
        return facilityID;
    }

    public void setFacilityID(Facility facilityID) {
        this.facilityID = facilityID;
    }

    public List<Facility> getFacilities() {
        return facilities;
    }

    public void setFacilities(List<Facility> facilities) {
        this.facilities = facilities;
    }

    public Booking getNewBooking() {
        return newBooking;
    }

    public void setNewBooking(Booking newBooking) {
        this.newBooking = newBooking;
    }

    public List<RegisteredMember> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<RegisteredMember> memberList) {
        this.memberList = memberList;
    }

    public RegisteredMember getNewMember() {
        return newMember;
    }

    public void setNewMember(RegisteredMember newMember) {
        this.newMember = newMember;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfrimPasword() {
        return confrimPasword;
    }

    public void setConfrimPasword(String confrimPasword) {
        this.confrimPasword = confrimPasword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getSelectedFacilitId() {
        return selectedFacilitId;
    }

    public void setSelectedFacilitId(Long selectedFacilitId) {
        this.selectedFacilitId = selectedFacilitId;
    }

    public Boolean getCheckFacility() {
        return checkFacility;
    }

    public void setCheckFacility(Boolean checkFacility) {
        this.checkFacility = checkFacility;
    }

    public Boolean getCheckUserLogin() {
        return checkUserLogin;
    }

    public void setCheckUserLogin(Boolean checkUserLogin) {
        this.checkUserLogin = checkUserLogin;
    }

    public Boolean getCheckPassword() {
        return checkPassword;
    }

    public void setCheckPassword(Boolean checkPassword) {
        this.checkPassword = checkPassword;
    }

    public Facility getNewFacility() {
        return newFacility;
    }

    public void setNewFacility(Facility newFacility) {
        this.newFacility = newFacility;
    }

    public Facility getSelectFacility() {
        return selectFacility;
    }

    public void setSelectFacility(Facility selectFacility) {
        this.selectFacility = selectFacility;
    }
    
        
    // --- function is loaded everytime this java file is loaded ---//
    @PostConstruct
    public void onPageLoad(){
        //insertValueIntoFacilityDB();
        //insertValueIntoFacilityDB2();
        //insertValueIntoFacilityDB3();
        setCheckPassword(Boolean.FALSE);
        getAllFacilities();
    }
    
    @EJB
    private PortEcoBusiness pb;
    
    public void changeFcID(ValueChangeEvent e) throws BusinessException{
        System.out.println("changeFcID");
        if(e.getNewValue() != null){
            selectedFacilitId = (Long) e.getNewValue();
            setSelectedFacilitId(selectedFacilitId);
            setCheckFacility(true);
            setSelectFacility(pb.getFacilityWithId(selectedFacilitId));
        }else{
            setCheckFacility(false);
        }
    }
    public void insertValueIntoFacilityDB(){
        newFacility.setFacilityName("House");
        newFacility.setStatus("Available");
        pb.addNewFacility(getNewFacility());        
    }    
    
    public void insertValueIntoFacilityDB2(){
        newFacility.setFacilityName("Experimental Garden");
        newFacility.setStatus("Available");
        pb.addNewFacility(getNewFacility());
    }
    
    public void insertValueIntoFacilityDB3(){
        newFacility.setFacilityName("Control Room");
        newFacility.setStatus("Available");
        pb.addNewFacility(getNewFacility());
    }    
    
    public void getAllFacilities(){
        setFacilities(pb.getAllFacilities());
        System.out.println("Facility set : " + getFacilities().size());
    }
    
    public void saveBooking(){
        newBooking.setUserId(getUserId());
        newBooking.setUserEmail(getUserEmail());
        newBooking.setStatus("Not Accepted");
        newBooking.setFacilityID(getSelectedFacilitId());
        newBooking.setFacilityName(getSelectFacility().getFacilityName());
        pb.addNewBooking(newBooking);
        System.out.println("test");
    }
    
    public void registeredMember(){
        if(getPassword().equals(getConfrimPasword())){
            newMember.setUsername(getUserName());
            newMember.setPassword(getPassword());
            newMember.setEmail(getEmail());
            newMember.setMemberType("User");
            pb.addNewMember(newMember);
            setCheckPassword(Boolean.TRUE);
            setUserName("");
            setEmail("");
        }else{
            setCheckPassword(Boolean.FALSE);
        }
        
    }
    
    public String login(){
        setCheckUserLogin(pb.loginValidation(getUserName(), getPassword()));
        setUserName("");
        if(getCheckUserLogin()){
            return "bookingPage.xhtml";
        }
        else return "loginPage.xhtml";
    }

    public String goToHomepage(){
        return "homePage.xhtml";
    }
    
    public MainController() {
    }
    
}
