USE db_retifica;

CREATE OR REPLACE VIEW view_labtank AS
SELECT idTq, trashTq, acidTq, soapTq, dtTq, hrTq, nameTank
FROM tbl_labtank
         JOIN
     tbl_tank ON fkTankTq = idTank
ORDER BY idTq DESC;

CREATE OR REPLACE VIEW view_seal AS
SELECT idSeal, nameProvider, saleSeal, clientSeal, factorySeal, brSeal, dtSeal
FROM db_retifica.tbl_seal
         JOIN
     tbl_provider ON fkProviderSeal = idProvider
ORDER BY idSeal DESC;

CREATE OR REPLACE VIEW view_sale AS
SELECT saleSeal
FROM tbl_seal;

CREATE OR REPLACE VIEW view_stocktank AS
SELECT dtStkTq,
       nameTank,
       nameProduct,
       literStkTq
FROM tbl_stocktank
         JOIN
     tbl_tank ON fkTankStkTq = idTank
         JOIN
     tbl_product ON fkProductStkTq = idProduct;

CREATE OR REPLACE VIEW view_stkProduct AS
SELECT nameProduct,
       literStkPd,
       percentStkPd,
       dtStkPd
FROM tbl_stockproduct
         JOIN
     tbl_product ON fkProductStkPd = idProduct;

CREATE OR REPLACE VIEW view_charge AS
SELECT idCharge,
       noteCharge,
       ticketCharge,
       burdenCharge,
       literCharge,
       nameTank,
       nameProvider,
       nameProduct,
       fkLabCharge,
       nameDriver,
       cnhDriver,
       boardCharge,
       dtOfCharge,
       dtUpCharge,
       hrOfCharge,
       hrUpCharge,
       acidCar,
       trashCar,
       soapCar,
       densityCar
FROM tbl_charge
         JOIN tbl_product ON fkProductCharge = idProduct
         JOIN tbl_tank ON fkTankCharge = idTank
         JOIN tbl_provider ON fkProviderCharge = idProvider
         JOIN tbl_driver ON fkDriverCharge = idDriver
         JOIN tbl_analyzeTruck ON fkLabCharge = idCar;

CREATE OR REPLACE VIEW view_dcharge AS
SELECT idDcharge,
       noteDcharge,
       ticketDcharge,
       burdenDcharge,
       literDcharge,
       nameTank,
       nameProvider,
       nameProduct,
       fkLabDcharge,
       nameDriver,
       cnhDriver,
       boardDcharge,
       dtOfDcharge,
       dtUpDcharge,
       hrOfDcharge,
       hrUpDcharge,
       acidCar,
       trashCar,
       soapCar,
       densityCar
FROM tbl_discharge
         JOIN tbl_product ON fkProductDcharge = idProduct
         JOIN tbl_tank ON fkTankDcharge = idTank
         JOIN tbl_provider ON fkProviderDcharge = idProvider
         JOIN tbl_driver ON fkDriverDcharge = idDriver
         JOIN tbl_analyzeTruck ON fkLabDcharge = idCar;

CREATE OR REPLACE VIEW view_makeester AS
select me.idEster,
       me.amountEster,
       me.producedEster,
       me.trashEster,
       me.dtEster,
       tt.nameTank
from (db_retifica.tbl_makeester me
         join db_retifica.tbl_tank tt on (tt.idTank = me.fkTankEster));

CREATE OR REPLACE VIEW view_matterester AS
SELECT tm.idMtEster, tm.literMtEster, tm.fkMtEster, tp.nameProduct
FROM tbl_matterester tm
         JOIN tbl_product tp on tp.idProduct = tm.fkProductMtEster;


CREATE OR REPLACE VIEW view_reactester AS
SELECT tr.dtRctEster
     , tr.pureRctEster
     , tr.recoverRctEster
     , tr.sulfuricRctEster
     , tr.hrFinalRctEster
     , tr.hrStartRctEster
     , tr.fkRctEster
     , ts.acidTq  as acidInitial
     , ts.soapTq  as soapInitial
     , ts.trashTq as trashInitial
     , tf.acidTq  as acidFinal
     , tf.soapTq  as soapFinal
     , tf.trashTq as trashFinal
FROM tbl_reactester tr
         join tbl_labtank ts on ts.idTq = tr.fkLabStartRctEster
         join tbl_labtank tf on tf.idTq = tr.fkLabFinalRctEster;

CREATE OR REPLACE VIEW view_maketrans AS
select me.idTrans,
       me.amountTrans,
       me.producedTrans,
       me.trashTrans,
       me.dtTrans,
       tt.nameTank
from (db_retifica.tbl_maketrans me
         join db_retifica.tbl_tank tt on (tt.idTank = me.fkTankTrans));

# CREATE OR REPLACE VIEW view_matterester AS
# SELECT tm.idMtEster, tm.literMtEster, tm.fkMtEster, tp.nameProduct
# FROM tbl_matterester tm
#          JOIN tbl_product tp on tp.idProduct = tm.fkProductMtEster;
#
#
# CREATE OR REPLACE VIEW view_reactester AS
# SELECT tr.dtRctEster
#      , tr.pureRctEster
#      , tr.recoverRctEster
#      , tr.sulfuricRctEster
#      , tr.hrFinalRctEster
#      , tr.hrStartRctEster
#      , tr.fkRctEster
#      , ts.acidTq as acidInitial
#      , ts.soapTq as soapInitial
#      , ts.trashTq as trashInitial
#      , tf.acidTq as acidFinal
#      , tf.soapTq as soapFinal
#      , tf.trashTq as trashFinal
# FROM tbl_reactester tr
#          join tbl_labtank ts on ts.idTq = tr.fkLabStartRctEster
#          join tbl_labtank tf on tf.idTq = tr.fkLabFinalRctEster;