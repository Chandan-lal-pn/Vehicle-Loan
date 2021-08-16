commit;
create table vehicle_model_pg(
    model_id NUMBER(10) PRIMARY KEY,
    vehicle_type VARCHAR2(20),
    vehicle_company_name VARCHAR2(30),
    model_name VARCHAR2(30) not null,
    ex_showroom_price NUMBER(15),
    on_road_price NUMBER(15),
    depcription VARCHAR(200)
);

create table cust_basic_details_pg(
    cust_id NUMBER(10) PRIMARY KEY,
    first_name VARCHAR2(20),
    last_name VARCHAR2(30),
    dob date,
    age NUMBER(2),
    gender VARCHAR2(10),
    mobile VARCHAR2(15) UNIQUE NOT NULL,
    email_id VARCHAR2(30) UNIQUE,
    login_password VARCHAR2(20) NOT NULL,
    residence_address VARCHAR2(100),
    residence_state VARCHAR2(20),
    residence_city VARCHAR2(20),
    pin_code VARCHAR2(10),
    nationality VARCHAR2(20),
    employer_name VARCHAR2(50),
    type_of_employment VARCHAR2(50),
    salary_pa NUMBER(15),
    existing_emis_count NUMBER(2),
    existing_emis_amount NUMBER(10)
);
COMMIT;

create table cust_identity_details_pg(
    cust_identity_id NUMBER(10) PRIMARY KEY,
    cust_id NUMBER(10),
    identity_type VARCHAR2(30),
    identity_id VARCHAR2(20) UNIQUE NOT NULL,
    FOREIGN KEY(cust_id) REFERENCES cust_basic_details_pg(cust_id)
);

create table loan_amounts_pg(
    loan_type_id NUMBER(10) PRIMARY KEY,
    loan_type VARCHAR2(20),
    min_price_range NUMBER(15),
    max_price_range NUMBER(15),
    interest_rate NUMBER(2),
    processing_fee NUMBER(10),
    min_sal_req_pa NUMBER(15)
);

create table application_det_pg(
    application_id NUMBER(10) PRIMARY KEY,
    model_id NUMBER(10),
    loan_type_id NUMBER(10),
    cust_id NUMBER(10),
    application_status VARCHAR2(10),
    emi_amount NUMBER(15),
    no_of_emis NUMBER(10),
    loan_amount NUMBER(15),
    loan_tenure_MON NUMBER(10),
    vehicle_chassis_no VARCHAR2(50),
    witness_name VARCHAR2(50),
    description VARCHAR2(200),
    FOREIGN KEY(cust_id) REFERENCES cust_basic_details_pg(cust_id),
    FOREIGN KEY(model_id) REFERENCES vehicle_model_pg(model_id),
    FOREIGN KEY(loan_type_id) REFERENCES loan_amounts_pg(loan_type_id)
);

create table loan_payment_det_pg(
    loan_payment_id NUMBER(10) PRIMARY KEY,
    application_id NUMBER(10),
    approval_date DATE DEFAULT (sysdate),
    emis_filled NUMBER(5),
    emis_left NUMBER(5),
    amount_done NUMBER(15),
    amount_left NUMBER(15),
    next_due DATE,
    FOREIGN KEY(application_id) REFERENCES application_det_pg(application_id)
);

ALTER TABLE loan_payment_det_pg
ADD BYadmin_id NUMBER(10);

ALTER TABLE loan_payment_det_pg
ADD CONSTRAINT FK_AuthorizeBY_admin
FOREIGN KEY (BYadmin_id) REFERENCES admin_details(admin_id);

create table emi_transaction_pg(
    emi_id NUMBER(10) PRIMARY KEY,
    loan_payment_id NUMBER(10),
    emi_number NUMBER(10),
    transaction_datetime TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    trancation_amount NUMBER(10),
    FOREIGN KEY(loan_payment_id) REFERENCES loan_payment_det_pg(loan_payment_id)
);

ALTER TABLE emi_transaction_pg
DROP COLUMN trancation_amount;

ALTER TABLE emi_transaction_pg
ADD transaction_amount NUMBER(10);

create table admin_details(
    admin_id NUMBER(10) PRIMARY KEY,
    admin_username VARCHAR2(20),
    admin_userid VARCHAR2(20),
    admin_password VARCHAR2(20)
);

COMMIT;
ALTER TABLE vehicle_model_pg DROP COLUMN depcription;
ALTER TABLE vehicle_model_pg ADD depcription VARCHAR2(200);
desc vehicle_model_pg;

--------------------------------------------------------INSERT-QUERY-------------------------------------------------

---------------------------ADMIN_DETAILS---------------------------------

insert into   admin_details(admin_id, admin_username,admin_userid,admin_password) values('001','admin','0001','admin123');
insert into   admin_details(admin_id, admin_username,admin_userid,admin_password) values('002','admin1','0002','admin1234');


---------------------------VEHICLE_MODEL_PG---------------------------------

insert into vehicle_model_pg values ('10001','2Wheeleer','Honda','activa','75564','87445','watryu');

insert into vehicle_model_pg values ('10002','4Wheeleer','Honda','amaze','58741','67445','watryu');

insert into vehicle_model_pg values ('10003','2Wheeleer','Hero','maestro','65574','77445','watryu');

insert into vehicle_model_pg values ('10004','4Wheeleer','Suzuki','swift','85514','97445','watryu');

insert into vehicle_model_pg values ('10005','2Wheeleer','Honda','activa','90064','99495','watryu');

insert into vehicle_model_pg values ('10006','2Wheeleer','TVS','Jupiter','84557','97458','watryu');

insert into vehicle_model_pg values ('10007','4Wheeleer','Suzuki','brezza','788741','867445','watryu');

insert into vehicle_model_pg values ('10008','2Wheeleer','Hero','Passion','85574','97445','watryu');

insert into vehicle_model_pg values ('10009','4Wheeleer','Tata','Nexon','855514','107445','watryu');

insert into vehicle_model_pg values ('10010','2Wheeleer','Bajaj','Pulsar 150','98554','101521','watryu');




-----------------------------CUST_BASIC_DETAILS_PG----------------------------------
insert into cust_basic_details_pg values ('20001','James','Brady',TO_DATE('1989-12-09','YYYY-MM-DD'),'51','M','7896541230','James@mail.com','OXAAY2DR','cDYNRKIotXZK'
,'Alabama','Alaba','817725','American','LTI','Permanent','241093','1','5049');

insert into cust_basic_details_pg values ('20002','Mary ','Flynn',TO_DATE('1976-06-21','YYYY-MM-DD'),'50','F','8648376906','mary@mail.com','47HQbbje','IPO-hFd-IyH-MOw'
,'Alaska','Alaska','975755','American','LNT','Permanent','398705','0','2737');

insert into cust_basic_details_pg values ('20003',' Robert','Mills',TO_DATE('1971-07-21','YYYY-MM-DD'),'45','M','8792499492','robert@mail.com','feGWCZrP','fHH-qQe-LjL-HxW'
,'Arizona','Arizona','856186','American','TCS','Temporary','264190','0','1822');

insert into cust_basic_details_pg values ('20004','John','Whittle',TO_DATE('1996-08-01','YYYY-MM-DD'),'32','M','6221849698','john@mail.com','bjXNCLtu','qCI-Atd-Nut-zFa'
,'Arkansas','Arkansas','620595','American','INFOSYS','Permanent','124574','0','7509');

insert into cust_basic_details_pg values ('20005','Patricia','Gibbs',TO_DATE('1989-05-29','YYYY-MM-DD'),'52','F','7337620049','patricia@mail.com','jA71EKu7','CZD-tbF-iYi-AQC'
,'California','California','426619','American','LTI','Temporary','119661','0','5862');

insert into cust_basic_details_pg values ('20006','Ruke','Jannie',TO_DATE('1999-02-09','YYYY-MM-DD'),'22','M','8745214574','Ruke@mail.com','Flat 102','cDYNRKIotXZK'
,'Maharastra','Pune','445301','Indian','Oracle','employee','351485','2','10232');

insert into cust_basic_details_pg values ('20007','Jack','Messi',TO_DATE('1995-01-09','YYYY-MM-DD'),'25','M','8444214574','Jack@mail.com','Flat 201','cDYNRKIotXZK'
,'Maharastra','Mumbai','441101','Indian','Google','employee','845000','0','0');

-----------------------------CUST_IDENTITY_DETAILS_PG----------------------------------
insert into cust_identity_details_pg values('30001','20001','PAN CARD','90001');

insert into cust_identity_details_pg values('30002','20002','AADHAR CARD','90002');

insert into cust_identity_details_pg values('30003','20003','PAN CARD','90003');

insert into cust_identity_details_pg values('30004','20004','PAN CARD','90004');

insert into cust_identity_details_pg values('30005','20005','AADHAR CARD','90005');

insert into cust_identity_details_pg values('30006','20002','PAN CARD','78547');

insert into cust_identity_details_pg values('30007','20001','AADHAR CARD','854714');

insert into cust_identity_details_pg values('30008','20007','AADHAR CARD','741257');

insert into cust_identity_details_pg values('30009','20006','AADHAR CARD','444477');

insert into cust_identity_details_pg values('30010','20003','AADHAR CARD','878777');


-----------------------------LOAN_AMOUNTS_PG----------------------------------
insert into loan_amounts_pg values('40001',	'2Wheeler',	'442823',	'1448303',	'5'	,'6148',	'6.5');

insert into loan_amounts_pg values('40002'	,'4Wheeler'	,'151287'	,'1361365'	,'6'	,'6413'	,'5');

insert into loan_amounts_pg values('40003'	,'2Wheeler'	,'274615'	,'1717829'	,'4'	,'3182'	,'5');

insert into loan_amounts_pg values('40004'	,'4Wheeler'	,'1883965'	,'639516'	,'2'	,'15731'	,'8');

insert into loan_amounts_pg values('40005'	,'2Wheeler'	,'325338'	,'305032'	,'3'	,'19113'	,'6.5');

-----------------------------EMI_TRANSACTION_PG----------------------------------

INSERT INTO emi_transaction_pg(emi_id, loan_payment_id, emi_number, transaction_amount) VALUES('700011','70001','80000','111' );
INSERT INTO emi_transaction_pg(emi_id, loan_payment_id, emi_number, transaction_amount) VALUES('700012','70001','112','80000' );
INSERT INTO emi_transaction_pg(emi_id, loan_payment_id, emi_number, transaction_amount) VALUES('700013','70001','113','80000' );
INSERT INTO emi_transaction_pg(emi_id, loan_payment_id, emi_number, transaction_amount) VALUES('700021','70002','121','650' );
INSERT INTO emi_transaction_pg(emi_id, loan_payment_id, emi_number, transaction_amount) VALUES('700022','70002','122','650' );





-----------------------------APPLICATION_DET_PG----------------------------------

insert into application_det_pg values('111',	'10001',	'40001'	,'20001',	'pending'	,'80000'	,'20'	,'885646'		,'24'	,'98616515332accf',	'Joshua Tardif'	,	'eeasfsfsjusbsfdsfvsyufkbsgukf'	);

insert into application_det_pg values('112',	'10002',	'40002'	,'20002',	'approved'	,'4000'	,'24'	,'302574'		,'36'	,'56515151474jhvjh',	'Lisa Ratchford'	,	'runfdnffdnfd  svsdgs sddvgs dsvh'	);

insert into application_det_pg values('113',	'10003',	'40003'	,'20003',	'pending'	,'250104'	,'30'	,'549230'		,'48'	,'9561514846hbhbk',	'Margaret Wiffen'	,	'eeasfsfsjusbsfdsfvsyufkbsgukf'	);

insert into application_det_pg values('114',	'10004',	'40004'	,'20004',	'approved'	,'650'	,'28'	,'3767930'		,'12'	,'9845661651khhbkk',	'Christopher Anderson'	,	'runfdnffdnfd  svsdgs sddvgs dsvh'	);

insert into application_det_pg values('115',	'10005',	'40005'	,'20005',	'pending'	,'6464'	,'246'	,'650676'		,'60'	,'4653154561jgvjvkhv',	'Susan Jones'	,	'eeasfsfsjusbsfdsfvsyufkbsgukf'	);


-----------------------------LOAN_PAYMENT_DET_PG----------------------------------

INSERT INTO loan_payment_det_pg (loan_payment_id, application_id, emis_filled,emis_left, amount_done, amount_left, next_due, byadmin_id ) VALUES(70001, 112,11,13,55000, 75000,TO_DATE('2021-06-01','YYYY-MM-DD'), 001);

INSERT INTO loan_payment_det_pg (loan_payment_id, application_id, emis_filled,emis_left, amount_done, amount_left, next_due, byadmin_id ) VALUES(70003, 114,1,35,10000, 350000,TO_DATE('2021-06-01','YYYY-MM-DD'), 001);

COMMIT;
-------------------------------------------------------SELECT-QUERY------------------------------------------------------------

    --------------------------------vehicle_model_pg------------------------------------
    select * from vehicle_model_pg;
    select * from vehicle_model_pg where vehicle_type='2Wheeleer';
    select * from vehicle_model_pg where vehicle_company_name='xyz';
    select * from vehicle_model_pg where ex_showroom_price between 11111 AND 22222;
    select * from vehicle_model_pg where on_road_price between 11111 AND 22222;
    
    
    --------------------------------CUST_BASIC_DETAILS_PG------------------------------------
    select * from cust_basic_details_pg;
    select * from cust_basic_details_pg where NATIONALITY='Indian';
    select * from cust_basic_details_pg where salary_pa>50000;
    select first_name,salary_pa-existing_emis_amount as net_salaryPA from cust_basic_details_pg;
    select i.identity_type,i.identity_id,c.first_name from cust_identity_details_pg i join cust_basic_details_pg c using(cust_id) WHERE i.identity_type='AADHAR CARD';
    
    --------------------------------LOAN_AMOUNTS_PG------------------------------------
    select * from loan_amounts_pg;
    select * from loan_amounts_pg where min_price_range>300000 AND max_price_range<1000000;
    select * from loan_amounts_pg where interest_rate between 2 AND 4;
    select * from loan_amounts_pg WHERE min_sal_req_pa>10000;
    
    
    --------------------------------APPLICATION_DET_PG------------------------------------
    select * from application_det_pg;
    select c.first_name,a.application_status,v.vehicle_company_name,v.model_name,l.loan_type from 
    APPLICATION_DET_PG a join vehicle_model_pg v on(a.model_id=v.model_id)
    join cust_basic_details_pg c on(a.cust_id = c.cust_id)
    join loan_amounts_pg l on(a.loan_type_id = l.loan_type_id);
    
    --------------------------------LOAN_PAYMENT_DET_PG------------------------------------
    
    select * from LOAN_PAYMENT_DET_PG;
    select p.approval_date,p.emis_left,c.first_name,a.application_status,v.vehicle_company_name,v.model_name,l.loan_type from 
    LOAN_PAYMENT_DET_PG p join APPLICATION_DET_PG a ON(p.application_id=a.application_id) 
    join vehicle_model_pg v on(a.model_id=v.model_id)
    join cust_basic_details_pg c on(a.cust_id = c.cust_id)
    join loan_amounts_pg l on(a.loan_type_id = l.loan_type_id);
    
    --------------------------------EMI_TRANSACTION_PG----------------------------------------
    
    select * from EMI_TRANSACTION_PG where loan_payment_id=70001;
    select e.emi_number,e.loan_payment_id,e.transaction_datetime,e.transaction_amount,c.first_name,v.model_name,p.next_due from
    EMI_TRANSACTION_PG e join loan_payment_det_pg p on(e.loan_payment_id = p.loan_payment_id)
    join APPLICATION_DET_PG a ON(p.application_id=a.application_id)
    join vehicle_model_pg v on(a.model_id=v.model_id)
    join cust_basic_details_pg c on(a.cust_id = c.cust_id);
    
	
	
	
	
COMMIT;
-----------------------------------------------------------DELETE-QUERY-------------------------------------------------
delete from vehicle_model_pg where model_id = 101;
delete  from cust_basic_details_pg where cust_id = 20001;


COMMIT;
-----------------------------------------------------------UPDATE-QUERY-------------------------------------------------
UPDATE vehicle_model_pg SET on_road_price = 50000 WHERE model_id=10001;

COMMIT;