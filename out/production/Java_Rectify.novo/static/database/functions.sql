USE db_retifica;

CREATE TRIGGER tr_carsplit
    BEFORE INSERT ON tbl_labcarsplit FOR EACH ROW
    SET new.fkLabCar = (SELECT MAX(idCar)FROM tbl_labcar);


create trigger tr_matterester
    before insert on tbl_matterester for each row
    set new.fkMtEster = (select max(idEster)from tbl_makeester);

create trigger tr_reacester
    before insert on tbl_reactester for each row
    set new.fkRctEster =  (select max(idEster)from tbl_makeester);


create trigger tr_mattertrans
    before insert on tbl_mattertrans for each row
    set new.fkMtTrans =  (select max(idTrans)from tbl_maketrans);

create trigger tr_reacttrans
    before insert on tbl_reacttrans for each row
    set new.fkRctTrans =  (select max(idTrans)from tbl_maketrans);