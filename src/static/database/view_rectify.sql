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
SELECT saleSeal FROM tbl_seal;

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
    SELECT
        nameProduct,
        literStkPd,
        percentStkPd,
        dtStkPd
    FROM
        tbl_stockproduct
            JOIN
        tbl_product ON fkProductStkPd = idProduct;

# CREATE OR REPLACE VIEW view_maketrans AS
# SELECT mt.idTrans,tr.dtRctTrans,mt.reactTrans,tt.nameTank,mt.producedTrans,mt.trashTrans FROM tbl_maketrans mt
# join tbl_reacttrans tr on mt.idTrans = tr.fkRctTrans
# join tbl_tank tt on tt.idTank = mt.fkTankTrans


# CREATE OR REPLACE VIEW view_charge AS
#     SELECT
#         idCharge,
#         noteCharge,
#         ticketCharge,
#         burdenCharge,
#         literCharge,
#         nameTank,
#         nameProvider,
#         nameProduct,
#         fkLabCharge,
#         nameDriver,
#         boardCharge,
#         dtOfCharge,
#         dtUpCharge,
#         hrOfCharge,
#         hrUpCharge,
#         acidCar,
#         trashCar,
#         soapCar,
#         densityCar,
#         obsCharge
#     FROM
#         tbl_charge
#         JOIN tbl_product ON fkProductCharge = idProduct
#         JOIN tbl_tank ON fkTankCharge = idTank
#         JOIN tbl_provider ON fkProviderCharge = idProvider
#         JOIN tbl_driver ON fkDriverCharge = idDriver
#         JOIN tbl_labcar ON fkLabCharge = idCar
#         LEFT JOIN tbl_obscharge ON idCharge = fkObsCharge;
#
#
#
# CREATE OR REPLACE VIEW view_dcharge AS
#     SELECT
#         idDcharge,
#         noteDcharge,
#         ticketDcharge,
#         burdenDcharge,
#         literDcharge,
#         nameTank,
#         nameProvider,
#         nameProduct,
#         fkLabDcharge,
#         nameDriver,
#         boardDcharge,
#         dtOfDcharge,
#         dtUpDcharge,
#         hrOfDcharge,
#         hrUpDcharge,
#         acidCar,
#         trashCar,
#         soapCar,
#         densityCar,
#         obsDcharge
#     FROM
#         tbl_discharge
#         JOIN tbl_product ON fkProductDcharge = idProduct
#         JOIN tbl_tank ON fkTankDcharge = idTank
#         JOIN tbl_provider ON fkProviderDcharge = idProvider
#         JOIN tbl_driver ON fkDriverDcharge = idDriver
#         JOIN tbl_labcar ON fkLabDcharge = idCar
#         LEFT JOIN tbl_obsdcharge ON idDcharge = fkObsDcharge;
#
#
#
# CREATE OR REPLACE VIEW view_labbio AS
#     SELECT
#         idBio,
#         acidBio,
#         densityBio,
#         density20Bio,
#         tempBio,
#         factorBio,
#         dtBio
#     FROM
#         tbl_labbio;
#
#
#
#

#
#

#
#
#
#
#
#

#
# CREATE OR REPLACE VIEW view_labCar AS
#     SELECT
#         idCar ,
#         trashCar ,
#         collectCar,
#         acidCar,
#         soapCar,
#         densityCar,
#         dtCar,
#         fkLabSplit
#     FROM
#         db_retifica.tbl_labcar
#             LEFT JOIN
#         tbl_labcarsplit ON fkLabCar = idCar;
#
#
#
