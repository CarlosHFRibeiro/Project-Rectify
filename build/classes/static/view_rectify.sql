use db_retifica;
CREATE OR REPLACE VIEW view_charge AS
    SELECT 
        idCharge,
        noteCharge,
        ticketCharge,
        burdenCharge,
        literCharge,
        nameTank,
        nameProvider,
        nameProduct,
        fkLabCharge,
        nameDriver,
        boardCharge,
        DATE_FORMAT(dtOfCharge, '%d/%m/%Y') AS dtOfCharge,
        DATE_FORMAT(dtUpCharge, '%d/%m/%Y') AS dtUpCharge,
        hrOfCharge,
        hrUpCharge,
        acidCar,
        trashCar,
        soapCar,
        densCar,
        obsCharge
    FROM
        tbl_charge
        JOIN tbl_product ON fkProductCharge = idProduct
        JOIN tbl_tank ON fkTankCharge = idTank
        JOIN tbl_provider ON fkProviderCharge = idProvider
        JOIN tbl_driver ON fkDriverCharge = idDriver
        JOIN tbl_labcar ON fkLabCharge = idCar
        LEFT JOIN tbl_obscharge ON idCharge = fkObsCharge;



CREATE OR REPLACE VIEW view_dcharge AS
    SELECT 
        idDcharge,
        noteDcharge,
        ticketDcharge,
        burdenDcharge,
        literDcharge,
        nameTank,
        nameProvider,
        nameProduct,
        fkLabDcharge,
        nameDriver,
        boardDcharge,
        DATE_FORMAT(dtOfDcharge, '%d/%m/%Y') AS dtOfDcharge,
        DATE_FORMAT(dtUpDcharge, '%d/%m/%Y') AS dtUpDcharge,
        hrOfDcharge,
        hrUpDcharge,
        acidCar,
        trashCar,
        soapCar,
        densCar,
        obsDcharge
    FROM
        tbl_discharge
        JOIN tbl_product ON fkProductDcharge = idProduct
        JOIN tbl_tank ON fkTankDcharge = idTank
        JOIN tbl_provider ON fkProviderDcharge = idProvider
        JOIN tbl_driver ON fkDriverDcharge = idDriver
        JOIN tbl_labcar ON fkLabDcharge = idCar
        LEFT JOIN tbl_obsdcharge ON idDcharge = fkObsDcharge;



CREATE OR REPLACE VIEW view_labbio AS
    SELECT 
        idBio,
        acidBio,
        densBio,
        dens20Bio,
        tempBio,
        factorBio,
        DATE_FORMAT(dtBio, '%d/%m/%Y') AS dtBio,
        htBio
    FROM
        tbl_labbio;



CREATE OR REPLACE VIEW view_labcar AS
    SELECT 
        idCar,
        trashCar,
        fkCollectCar,
        acidCar,
        soapCar,
        densCar,
        DATE_FORMAT(dtCar, '%d/%m/%Y') AS dtCar,
        htCar,
        sourceCollect,
        fkLabSplit
    FROM
        tbl_labcar
        JOIN tbl_collect ON fkCollectCar = idCollect
        LEFT JOIN tbl_labcarsplit ON fkLabCar = idCar;



CREATE OR REPLACE VIEW view_labsplit AS
    SELECT 
        idSplit,
        oilSplit,
        sludgeSplit,
        glycerinSplit,
        trashSplit,
        DATE_FORMAT(dtSplit, '%d/%m/%Y') AS dtSplit,
        htSplit
    FROM
        tbl_labsplit;



CREATE OR REPLACE VIEW view_labtank AS
    SELECT 
        idTq,
        trashTq,
        acidTq,
        soapTq,
        DATE_FORMAT(dtTq, '%d/%m/%Y') AS dtTq,
        htTq,
        nameTank
    FROM
        tbl_labtank
        JOIN tbl_tank ON fkTankTq = idTank;



CREATE OR REPLACE VIEW view_stkfull AS
    SELECT 
        nameProduct, 
        literStkPd, 
        percentStkPd, 
        dtStkPd
    FROM
        tbl_stockproduct
            JOIN
        tbl_product ON fkProductStkPd = idProduct;



CREATE OR REPLACE VIEW view_stktq AS
    SELECT 
        DATE_FORMAT(dtStkTq, '%d/%m/%Y') AS dtStkTq,
        nameTank,
        nameProduct,
        literStkTq,
        fkProductStkTq
    FROM
        tbl_stocktank
            JOIN
        tbl_tank ON fkTankStkTq = idTank
            JOIN
        tbl_product ON fkProductStkTq = idProduct;
        
        
CREATE OR REPLACE VIEW view_seal AS
    SELECT 
        nameProvider,
        saleSeal,
        clientSeal,
        factorySeal,
        brSeal,
        DATE_FORMAT(dtSeal, '%d/%m/%Y') AS dtSeal
    FROM db_retifica.tbl_seal
            JOIN
        tbl_provider ON fkProviderSeal = idProvider;

CREATE OR REPLACE VIEW view_labCar AS
    SELECT
        idCar ,
        trashCar ,
        fkCollectCar,
        acidCar,
        soapCar,
        densCar,
        DATE_FORMAT(dtCar, '%d/%m/%Y') as dtCar,
        htCar,
        sourceCollect,
        fkLabSplit
    FROM
        db_retifica.tbl_labcar
            INNER JOIN
        tbl_collect ON fkCollectCar = idCollect
            LEFT JOIN
        tbl_labcarsplit ON fkLabCar = idCar;

CREATE OR REPLACE VIEW view_labsplit AS
    SELECT
        idSplit,
        oilSplit,
        sludgeSplit,
        glycerinSplit,
        trashSplit,
        DATE_FORMAT(dtSplit, '%d/%m/%Y') AS dtSplit,
        htSplit
    FROM
        tbl_labsplit;

CREATE OR REPLACE VIEW view_labBio AS
    SELECT
        idBio,
        acidBio,
        densBio,
        dens20Bio,
        tempBio,
        factorBio,
        DATE_FORMAT(dtBio, '%d/%m/%Y') AS dtBio,
        htBio
    FROM
        db_retifica.tbl_labbio;

CREATE OR REPLACE VIEW view_labTank AS
    SELECT
        idTq,
        trashTq,
        acidTq,
        soapTq,
        DATE_FORMAT(dtTq, '%d/%m/%Y') AS dtTq,
        htTq,
        nameTank
    FROM
        db_retifica.tbl_labtank
            JOIN
        tbl_tank ON fkTankTq = idTank;

