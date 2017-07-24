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
import java.util.Properties;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.event.ValueChangeEvent;


import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

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
    List<RegisteredMember> adminList = new ArrayList<RegisteredMember>();
    RegisteredMember newMember = new RegisteredMember();
    Facility selectFacility = new Facility();
    RegisteredMember loginMember = new RegisteredMember();
    RegisteredMember editMember = new RegisteredMember();
    RegisteredMember adminActive = new RegisteredMember();
    
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
    private String firstName;
    private String lastName;
    private String loginUsername;
    private String loginPassword;
    private String purpose;
    private String message;
    private String emailSubject;
    private String emailMessage;
    private String faculty;
    
    private Long selectedFacilitId;
    private Boolean checkFacility;
    private Boolean checkUserLogin;
    private Boolean checkPassword = Boolean.TRUE;
    private Boolean memberEditable = Boolean.FALSE;
    private String selectedMemberType;
    private Boolean editPassword = Boolean.FALSE;
    private Boolean registrationStatus = Boolean.FALSE;

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

    public List<RegisteredMember> getAdminList() {
        return adminList;
    }

    public void setAdminList(List<RegisteredMember> adminList) {
        this.adminList = adminList;
    }

    public String getSelectedMemberType() {
        return selectedMemberType;
    }

    public void setSelectedMemberType(String selectedMemberType) {
        this.selectedMemberType = selectedMemberType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public RegisteredMember getLoginMember() {
        return loginMember;
    }

    public void setLoginMember(RegisteredMember loginMember) {
        this.loginMember = loginMember;
    }

    public Boolean getMemberEditable() {
        return memberEditable;
    }

    public void setMemberEditable(Boolean memberEditable) {
        this.memberEditable = memberEditable;
    }

    public Boolean getEditPassword() {
        return editPassword;
    }

    public void setEditPassword(Boolean editPassword) {
        this.editPassword = editPassword;
    }    

    public Boolean getRegistrationStatus() {
        return registrationStatus;
    }

    public void setRegistrationStatus(Boolean registrationStatus) {
        this.registrationStatus = registrationStatus;
    }

    public RegisteredMember getEditMember() {
        return editMember;
    }

    public void setEditMember(RegisteredMember editMember) {
        this.editMember = editMember;
    }

    public String getLoginUsername() {
        return loginUsername;
    }

    public void setLoginUsername(String loginUsername) {
        this.loginUsername = loginUsername;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getEmailSubject() {
        return emailSubject;
    }

    public void setEmailSubject(String emailSubject) {
        this.emailSubject = emailSubject;
    }

    public String getEmailMessage() {
        return emailMessage;
    }

    public void setEmailMessage(String emailMessage) {
        this.emailMessage = emailMessage;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public RegisteredMember getAdminActive() {
        return adminActive;
    }

    public void setAdminActive(RegisteredMember adminActive) {
        this.adminActive = adminActive;
    }   
    
    @EJB
    private PortEcoBusiness pb;   
    // --- function is loaded everytime this java file is loaded ---//
    @PostConstruct
    public void onPageLoad(){
//        insertValueIntoFacilityDB();
//        insertValueIntoFacilityDB2();
//        insertValueIntoFacilityDB3();
        setCheckPassword(Boolean.TRUE);
        setRegistrationStatus(Boolean.FALSE);
        getAllFacilities();
        getAllAdmin();
        getAllMember();
        setAdminActive(pb.getAdminPerson());
        System.out.println("admin size: " + getAdminActive().getMemberType());
    }
    
    public void changeMemberType(ValueChangeEvent e) throws BusinessException{
        if(e.getNewValue() != null){
            selectedMemberType = (String) e.getNewValue();
            setSelectedMemberType(selectedMemberType);
        }else{
            setSelectedMemberType("");
        }        
    }
    
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
    
    public void getAllMember(){
        setMemberList(pb.getAllMemberList());
    }
    
    public void getAllAdmin(){
        setAdminList(pb.getAllAdminList());
    }
    
    public void saveBooking(){
        newBooking.setUserId(getUserId());
        newBooking.setUserEmail(getUserEmail());
        newBooking.setStatus("Not Accepted");
        newBooking.setFacility(getSelectFacility());
        newBooking.setFacilityName(getSelectFacility().getFacilityName());
        newBooking.setFirstName(getFirstName());
        newBooking.setLastName(getLastName());
//        newBooking.setDateFrom(getDateStart());
//        newBooking.setDateUntil(getDateEnd());
        newBooking.setFaculty(getFaculty());
        newBooking.setPurpose(getPurpose());
        newBooking.setMessage(getMessage());
        pb.addNewBooking(newBooking);
        System.out.println("test");
        bookingEmailSetting();
        sendEmail(getAdminActive().getEmail());
        setUserId("");
        setUserName("");
        setUserEmail("");
        setFaculty("");
        setFirstName("");
        setLastName("");
        setPurpose("");
        setMessage("");
    }
    
    public void registeredMember(){
        if(getPassword().equals(getConfrimPasword())){
            newMember.setUsername(getUserName());
            newMember.setPassword(getPassword());
            newMember.setEmail(getEmail());
            newMember.setMemberType(getSelectedMemberType());
            pb.addNewMember(newMember);
            setCheckPassword(Boolean.TRUE);
            System.out.println("email: " + getEmail());
            registerEmailSetting();
            sendEmail(getEmail());
            setUserName("");
            setEmail("");
            setSelectedMemberType("");
            if(getSelectedMemberType().equals("admin")){
                getAdminList();
            }else{
                getMemberList();
            }
            setRegistrationStatus(Boolean.TRUE);            
        }else{
            setCheckPassword(Boolean.FALSE);
            setRegistrationStatus(Boolean.FALSE);
        }
    }
    
    public String login(){
        String nextPage;
        setCheckUserLogin(pb.loginValidation(getLoginUsername(), getLoginPassword()));
        System.out.println(getLoginUsername()+ " and " + getLoginPassword());
        if(getCheckUserLogin()){
            setLoginMember(pb.getLoginMember(getLoginUsername(), getLoginPassword()));
            if(getLoginMember().getMemberType().equals("member")){
                nextPage = "memberPage.xhtml?faces-redirect=true";
                System.out.println("test1");
            }else{
                nextPage = "adminPage.xhtml?faces-redirect=true";
                System.out.println("test2");
            }
        }
        else nextPage = "loginPage.xhtml?faces-redirect=true";
        setUserName(""); 
        
        System.out.println("test3");
        return nextPage;
    }
    
    public String logout(){
        setUserName("");
        return "homePage.xhtml?faces-redirect=true";
    }

    public String goToHomepage(){
        return "homePage.xhtml?faces-redirect=true";
    }
    
    public String goToRegistrationPage(){
        return "registrationPage.xhtml?faces-redirect=true";
    }
    
    public String goToBookingPage(){
        return "bookingPage.xhtml?faces-redirect=true";
    }
    
    public void editMemberDetail(){
        setMemberEditable(Boolean.TRUE);
    }
    public String saveMemberDetail(){
        if(getConfrimPasword().equals(getLoginMember().getPassword())){
            pb.updateMember(getLoginMember());
            setMemberEditable(Boolean.FALSE);
            setCheckPassword(Boolean.TRUE);
        }else{
            setCheckPassword(Boolean.FALSE);
        }        
        return "memberPage.xhtml?faces-redirect=true";
    }
    
    public String saveEditMemberDetail(){
        pb.updateMember(getLoginMember());
        setMemberEditable(Boolean.FALSE);
        setCheckPassword(Boolean.TRUE);
        return "memberPage.xhtml?faces-redirect=true";
    }
    public String saveMemberPassword(){
        if(getConfrimPasword().equals(getLoginMember().getPassword())){
            pb.updateMember(getLoginMember());
            setCheckPassword(Boolean.TRUE);
        }else{
            setCheckPassword(Boolean.FALSE);
        }   
        return "memberPage.xhtml?faces-redirect=true";
    }
    
    public void saveAdminMemberDetail(){       
        pb.updateMember(getEditMember());
    }
    
    public String cancelPasswordEdit(){
        setConfrimPasword("");
        setEditPassword(Boolean.FALSE);
        return "memberPage.xhtml?faces-redirect=true";
    }
    
    public String cancelMemberEdit(){
        setMemberEditable(Boolean.FALSE);
        return "memberPage.xhtml?faces-redirect=true";
    }
    
    public void editPasswordFunction(){
        setEditPassword(Boolean.TRUE);
    }
    
    public void selectedEditMember(RegisteredMember rm){
        setEditMember(rm);
        setSelectedMemberType(rm.getMemberType());
    }
    
    /** All of these code for email function are retrieved from mkyong.com    **/
    public void sendEmail(String email){
        System.out.println("here done");
        final String username = "up835895@myport.ac.uk";
        final String password = "14februari";        

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        Session session = Session.getInstance(props, new GMailAuthenticator(username, password));
        try {

                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("up835895@myport.ac.uk"));
                message.setRecipients(Message.RecipientType.TO,
                        InternetAddress.parse(email));
                message.setSubject(getEmailSubject());
                message.setText(getEmailMessage());

                Transport.send(message);

                System.out.println("Done..Email Sent");

        } catch (MessagingException e) {
                throw new RuntimeException(e);
        }
    }
    
    class GMailAuthenticator extends Authenticator {
        String user;
        String pw;
        public GMailAuthenticator (String username, String password)
        {
           super();
           this.user = username;
           this.pw = password;
        }
     
        @Override
        public PasswordAuthentication getPasswordAuthentication()
        {
           return new PasswordAuthentication(user, pw);
        }
    }
    
    public void registerEmailSetting(){
        final String portEcoLink = "http://localhost:8080/PortEcoHouse/faces/loginPage.xhtml";
        setEmailSubject("Registered Member For Port-Eco House System");
        setEmailMessage("Dear user, "
                        + "\n\n This email is to infrom you that you are now a registered member for Port-Eco House System. Below are the login details to your account. Please complete your details once your login to the new system. \n"
                        + "\n Username: " + getUserName() + "\n Password: " + getPassword()
                        + "\n You can login from this link : " + portEcoLink
                        + "\n\n Hope you will enjoy our services."
                        + "\n Regards,"
                        + "\n Port-Eco House managemenet teams");
    }
    
    
    public void bookingEmailSetting(){
    final String portEcoLink = "http://localhost:8080/PortEcoHouse/faces/loginPage.xhtml";       
        setEmailSubject("Port-Eco House Facility Booking Request");
        setEmailMessage("Dear admin, "
                        + "\n\n This email is to infrom you that you are now a user have made a booking request. Below is the user details regarding the matters: \n"
                        + "\n User Id: " + getUserId() 
                        + "\n Name: " + getFirstName() + " " + getLastName()
                        + "\n Faculty: " + getFaculty()
                        + "\n Email: " + getEmail()
                        + "\n Purpose: " + getPurpose()
                        + "\n Message: " + getMessage()
                        + "\n You can login from this link to manage the booking request : " + portEcoLink
                        + "\n\n Regards,"
                        + "\n Port-Eco House managemenet teams");
    }
    
    public MainController() {
    }
    
}
