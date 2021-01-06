USE db_rectify;

CREATE TRIGGER tr_truck_split
    BEFORE INSERT
    ON tbl_analyze_truck_split
    FOR EACH ROW SET new.fkAnalyzeTruck = (SELECT MAX(idAnalyzeTruck)
                                           FROM tbl_analyze_truck);

CREATE TRIGGER tr_matter_ester
    BEFORE INSERT
    ON tbl_matter_ester
    FOR EACH ROW
    SET new.fkMakeEster = (SELECT MAX(idMakeEster)
                           FROM tbl_make_ester);

CREATE TRIGGER tr_reacester
    BEFORE INSERT
    ON tbl_reaction_make_ester
    FOR EACH ROW
    SET new.fkMakeEster = (SELECT MAX(idMakeEster)
                           FROM tbl_make_ester);


CREATE TRIGGER tr_matter_biodiesel
    BEFORE INSERT
    ON tbl_matter_biodiesel
    FOR EACH ROW
    set new.fkMakeBiodiesel = (SELECT MAX(idMakeBiodiesel)
                               FROM tbl_make_biodiesel);

CREATE TRIGGER tr_react_biodiesel
    BEFORE INSERT
    ON tbl_reaction_biodiesel
    FOR EACH ROW
    SET new.fkMakeBiodiesel = (SELECT MAX(idMakeBiodiesel)
                               FROM tbl_make_biodiesel);