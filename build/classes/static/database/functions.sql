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
    SET new.fkMtEster = (SELECT MAX(idEster)
                         FROM tbl_makeester);

CREATE TRIGGER tr_reacester
    BEFORE INSERT
    ON tbl_reactester
    FOR EACH ROW
    SET new.fkRctEster = (SELECT MAX(idEster)
                          FROM tbl_makeester);


CREATE TRIGGER tr_mattertrans
    BEFORE INSERT
    ON tbl_mattertrans
    FOR EACH ROW
    set new.fkMtTrans = (SELECT MAX(idTrans)
                         FROM tbl_maketrans);

CREATE TRIGGER tr_reacttrans
    BEFORE INSERT
    ON tbl_reacttrans
    FOR EACH ROW
    SET new.fkRctTrans = (SELECT MAX(idTrans)
                          FROM tbl_maketrans);