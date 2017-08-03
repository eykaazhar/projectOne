INSERT INTO FACILITY(ID, FACILITYNAME, STATUS) VALUES(1, 'House','available');
INSERT INTO FACILITY(ID, FACILITYNAME, STATUS) VALUES(2, 'Control Room', 'available');
INSERT INTO FACILITY(ID, FACILITYNAME, STATUS) VALUES(3, 'Experimental Garden', 'available');

INSERT INTO REGISTEREDMEMBER(ID, EMAIL, USERNAME, FIRSTNAME, PASSWORD, MEMBERTYPE) VALUES(-1,'member@gmail.com', '123456', 'Syafiqah', 'password', 'member');
INSERT INTO REGISTEREDMEMBER(ID, EMAIL, USERNAME, FIRSTNAME, PASSWORD, MEMBERTYPE) VALUES(-2,'member@gmail.com', '123457', 'Akihito', 'password', 'member');
INSERT INTO REGISTEREDMEMBER(ID, EMAIL, USERNAME, FIRSTNAME, PASSWORD, MEMBERTYPE) VALUES(-3,'admin@gmail.com', 'admin', 'Admin', 'password', 'admin');

INSERT INTO STATUSDESCRIPTION(ID,STATUSDES, STATUSLABEL) VALUES(-1, 'admin', 'Administrator');
INSERT INTO STATUSDESCRIPTION(ID,STATUSDES, STATUSLABEL) VALUES(-2, 'member', 'Member');
INSERT INTO STATUSDESCRIPTION(ID,STATUSDES, STATUSLABEL) VALUES(-3, 'active', 'Active');
INSERT INTO STATUSDESCRIPTION(ID,STATUSDES, STATUSLABEL) VALUES(-4, 'unactive', 'Unactive');
INSERT INTO STATUSDESCRIPTION(ID,STATUSDES, STATUSLABEL) VALUES(-5, 'available', 'Available');
INSERT INTO STATUSDESCRIPTION(ID,STATUSDES, STATUSLABEL) VALUES(-6, 'unavailable', 'Unavailable');
INSERT INTO STATUSDESCRIPTION(ID,STATUSDES, STATUSLABEL) VALUES(-7, 'accepted', 'Accepted');
INSERT INTO STATUSDESCRIPTION(ID,STATUSDES, STATUSLABEL) VALUES(-8, 'notAccepted', 'Not Accepted');
INSERT INTO STATUSDESCRIPTION(ID,STATUSDES, STATUSLABEL) VALUES(-9, 'processed', 'Processed');
INSERT INTO STATUSDESCRIPTION(ID,STATUSDES, STATUSLABEL) VALUES(-10, 'notProcessed', 'Not yet To be Processed');

INSERT INTO INVENTORY(ID, EQUIPMENTNAME, MAKE, MODEL, SERIALNUMBER, ACCESSORIES, PATREFERENCE, BATTERY, STATUS) 
VALUES(-1, 'FLIR Thermal Imaging Camera', 'FLIR T420bx', 'T62108667', '62108667', 'Flight Case; 2x batteries & charger; cables; documentation CD; 4GB SD HC memory card', '2a 2b(USB)', 'Flir', 'available');

INSERT INTO INVENTORY(ID, EQUIPMENTNAME, MAKE, MODEL, SERIALNUMBER, ACCESSORIES, PATREFERENCE, BATTERY, STATUS) 
VALUES(-2, 'FLIR Thermal Imaging Camera', 'Testo', '880-3', '1715573', 'Flight Case; 2x batteries & charger; cables; 27mm f1.0lens; documentation CD; 1GB SD HC memory card; tripod bracker', '1', 'Testo', 'available');

INSERT INTO INVENTORY(ID, EQUIPMENTNAME, MAKE, MODEL, SERIALNUMBER, ACCESSORIES, PATREFERENCE, BATTERY, STATUS) 
VALUES(-3, 'EXTECH Moisture Meter', 'Extech', 'MO297', '130321267', 'Carry case; hygrometer cap; external pin probe; user manual', '', '9v', 'available');

INSERT INTO INVENTORY(ID, EQUIPMENTNAME, MAKE, MODEL, SERIALNUMBER, ACCESSORIES, PATREFERENCE, BATTERY, STATUS) 
VALUES(-4, 'TESTO Handled Logger', 'Testo', '720', '02805843', '(Probes listed separately)', '', '9v', 'available');

INSERT INTO INVENTORY(ID, EQUIPMENTNAME, MAKE, MODEL, SERIALNUMBER, ACCESSORIES, PATREFERENCE, BATTERY, STATUS) 
VALUES(-5, 'TESTO NTC Air Probe', 'Testo', '06131712', '02805843', '(Use with Testo 720)', '', 'N/A', 'available');

INSERT INTO INVENTORY(ID, EQUIPMENTNAME, MAKE, MODEL, SERIALNUMBER, ACCESSORIES, PATREFERENCE, BATTERY, STATUS) 
VALUES(-6, 'TESTO NTC Surface Probe', 'Testo', '06131712', '02805843', '(Use with Testo 720)', '', 'N/A', 'available');

INSERT INTO INVENTORY(ID, EQUIPMENTNAME, MAKE, MODEL, SERIALNUMBER, ACCESSORIES, PATREFERENCE, BATTERY, STATUS) 
VALUES(-7, 'VAISALA Handled Humicap', 'Vaisala', 'HM40', 'K2840001', 'HMP 113 Probe listed separately; User manual', '', '2xAA', 'available');

INSERT INTO INVENTORY(ID, EQUIPMENTNAME, MAKE, MODEL, SERIALNUMBER, ACCESSORIES, PATREFERENCE, BATTERY, STATUS) 
VALUES(-8, 'VAISALA Humicap Probe', 'Vaisala', 'HMP113', 'K2730001', '(Use with HM40)', '', 'N/A', 'available');

INSERT INTO INVENTORY(ID, EQUIPMENTNAME, MAKE, MODEL, SERIALNUMBER, ACCESSORIES, PATREFERENCE, BATTERY, STATUS) 
VALUES(-9, 'TSI Airflow Handled Anemometer', 'Airflow', 'LCA501', 'LCA5014', 'Flight Case; User manual', '', '2xAA', 'available');