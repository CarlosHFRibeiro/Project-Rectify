USE db_retifica;

CREATE TRIGGER tr_carsplit
    BEFORE INSERT
    ON tbl_labcarsplit
    FOR EACH ROW SET new.fkLabCar = (SELECT MAX(idCar)
                                     FROM tbl_labcar);

CREATE TRIGGER tr_matterester
    BEFORE INSERT
    ON tbl_matterester
    FOR EACH ROW
    set new.fkMtEster = (select max(idEster)
                         from tbl_makeester);

CREATE TRIGGER tr_reacester
    BEFORE INSERT
    ON tbl_reactester
    FOR EACH ROW
    set new.fkRctEster = (select max(idEster)
                          from tbl_makeester);
#
#
# create trigger tr_mattertrans
#     before insert on tbl_mattertrans for each row
#     set new.fkMtTrans =  (select max(idTrans)from tbl_maketrans);
#
# create trigger tr_reacttrans
#     before insert on tbl_reacttrans for each row
#     set new.fkRctTrans =  (select max(idTrans)from tbl_maketrans);