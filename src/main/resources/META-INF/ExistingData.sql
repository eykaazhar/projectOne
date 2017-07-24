INSERT INTO FACILITY(ID, FACILITYNAME, STATUS) VALUES(1, 'House','Available');
INSERT INTO FACILITY(ID, FACILITYNAME, STATUS) VALUES(2, 'Control Room', 'Available');
INSERT INTO FACILITY(ID, FACILITYNAME, STATUS) VALUES(3, 'Experimental Garden', 'Available');

INSERT INTO REGISTEREDMEMBER(ID, EMAIL, USERNAME, FIRSTNAME, PASSWORD, MEMBERTYPE) VALUES(1,'admin@gmail.com', 'admin', 'Admin', 'password', 'admin');

INSERT INTO INVENTORY(ID, EQUIPMENTNAME, MAKE, MODEL, SERIALNUMBER, ACCESSORIES, PATREFERENCES, BATTERY) 
VALUES(-1, 'FLIR Thermal Imaging Camera', 'FLIR T420bx', 'T62108667', '62108667', 'Flight Case; 2x batteries & charger; cables; documentation CD; 4GB SD HC memory card', '2a 2b(USB)', 'Flir');

INSERT INTO INVENTORY(ID, EQUIPMENTNAME, MAKE, MODEL, SERIALNUMBER, ACCESSORIES, PATREFERENCES, BATTERY) 
VALUES(-2, 'FLIR Thermal Imaging Camera', 'Testo', '880-3', '1715573', 'Flight Case; 2x batteries & charger; cables; 27mm f1.0lens; documentation CD; 1GB SD HC memory card; tripod bracker', '1', 'Testo');

INSERT INTO INVENTORY(ID, EQUIPMENTNAME, MAKE, MODEL, SERIALNUMBER, ACCESSORIES, PATREFERENCES, BATTERY) 
VALUES(-3, 'EXTECH Moisture Meter', 'Extech', 'MO297', '130321267', 'Carry case; hygrometer cap; external pin probe; user manual', '', '9v');

INSERT INTO INVENTORY(ID, EQUIPMENTNAME, MAKE, MODEL, SERIALNUMBER, ACCESSORIES, PATREFERENCES, BATTERY) 
VALUES(-4, 'TESTO Handled Logger', 'Testo', '720', '02805843', '(Probes listed separately)', '', '9v');

INSERT INTO INVENTORY(ID, EQUIPMENTNAME, MAKE, MODEL, SERIALNUMBER, ACCESSORIES, PATREFERENCES, BATTERY) 
VALUES(-5, 'TESTO NTC Air Probe', 'Testo', '06131712', '02805843', '(Use with Testo 720)', '', 'N/A');

INSERT INTO INVENTORY(ID, EQUIPMENTNAME, MAKE, MODEL, SERIALNUMBER, ACCESSORIES, PATREFERENCES, BATTERY) 
VALUES(-6, 'TESTO NTC Surface Probe', 'Testo', '06131712', '02805843', '(Use with Testo 720)', '', 'N/A');

INSERT INTO INVENTORY(ID, EQUIPMENTNAME, MAKE, MODEL, SERIALNUMBER, ACCESSORIES, PATREFERENCES, BATTERY) 
VALUES(-7, 'VAISALA Handled Humicap', 'Vaisala', 'HM40', 'K2840001', 'HMP 113 Probe listed separately; User manual', '', '2xAA');

INSERT INTO INVENTORY(ID, EQUIPMENTNAME, MAKE, MODEL, SERIALNUMBER, ACCESSORIES, PATREFERENCES, BATTERY) 
VALUES(-8, 'VAISALA Humicap Probe', 'Vaisala', 'HMP113', 'K2730001', '(Use with HM40)', '', 'N/A');

INSERT INTO INVENTORY(ID, EQUIPMENTNAME, MAKE, MODEL, SERIALNUMBER, ACCESSORIES, PATREFERENCES, BATTERY) 
VALUES(-9, 'TSI Airflow Handled Anemometer', 'Airflow', 'LCA501', 'LCA5014', 'Flight Case; User manual', '', '2xAA');