USE db_rectify;

CREATE OR REPLACE VIEW view_analyze_tank AS
SELECT acidityTank,
       dateAnalyzeTank,
       idAnalyzeTank,
       nameTank,
       saponityTank,
       timeAnalyzeTank,
       trashTank
FROM tbl_analyze_tank
         JOIN
     tbl_tank ON fkTank = idTank
ORDER BY idAnalyzeTank DESC;

CREATE OR REPLACE VIEW view_analyze_truck AS
SELECT acidityTruck,
       collect,
       dateAnalyzeTruck,
       densityTruck,
       idAnalyzeTruck,
       nameProduct,
       saponityTruck,
       timeAnalyzeTruck,
       trashTruck
FROM tbl_analyze_truck
         JOIN tbl_product ON idProduct = fkProduct
ORDER BY idAnalyzeTruck DESC;

CREATE OR REPLACE VIEW view_sample AS
SELECT auctionNumber,
       clientSample,
       dateSampleCollection,
       factorySample,
       idSample,
       nameProvider,
       petrobrasSample
FROM tbl_sample
         JOIN
     tbl_provider ON fkProvider = idProvider
ORDER BY idSample DESC;

CREATE OR REPLACE VIEW view_stock_tank AS
SELECT dateStockTank,
       literProduct,
       nameProduct,
       nameTank
FROM tbl_stock_tank
         JOIN
     tbl_tank ON fkTank = idTank
         JOIN
     tbl_product ON fkProduct = idProduct;

CREATE OR REPLACE VIEW view_stock_product AS
SELECT dateStockProduct,
       literProduct,
       nameProduct,
       percentProduct
FROM tbl_stock_product
         JOIN
     tbl_product ON fkProduct = idProduct;

CREATE OR REPLACE VIEW view_charge AS
SELECT acidityTruck,
       burdenCharge,
       carPlateCharge,
       cnhDriver,
       dateEntryCharge,
       dateExitCharge,
       densityProduct,
       fkAnalyzeTruck,
       idCharge,
       literCharge,
       nameTank,
       nameProvider,
       nameProduct,
       nameDriver,
       noteCharge,
       ticketCharge,
       timeEntryCharge,
       timeExitCharge,
       trashTruck,
       saponityTruck
FROM tbl_charge
         JOIN tbl_product ON fkProduct = idProduct
         JOIN tbl_tank ON fkTank = idTank
         JOIN tbl_provider ON fkProvider = idProvider
         JOIN tbl_driver ON fkDriver = idDriver
         JOIN tbl_analyze_truck tl on fkAnalyzeTruck = idAnalyzeTruck;

CREATE OR REPLACE VIEW view_dcharge AS
SELECT acidityTruck,
       burdenDcharge,
       carPlateDcharge,
       cnhDriver,
       dateEntryDcharge,
       dateExitDcharge,
       densityProduct,
       fkAnalyzeTruck,
       idDcharge,
       literDcharge,
       nameTank,
       nameProvider,
       nameProduct,
       nameDriver,
       noteDcharge,
       ticketDcharge,
       timeEntryDcharge,
       timeExitDcharge,
       trashTruck,
       saponityTruck
FROM tbl_discharge
         JOIN tbl_product ON fkProduct = idProduct
         JOIN tbl_tank ON fkTank = idTank
         JOIN tbl_provider ON fkProvider = idProvider
         JOIN tbl_driver ON fkDriver = idDriver
         JOIN tbl_analyze_truck ON fkAnalyzeTruck = idAnalyzeTruck;

CREATE OR REPLACE VIEW view_make_ester AS
select amountMatterMakeEster,
       dateMakeEster,
       idMakeEster,
       nameTank,
       producedMakeEster,
       trashMakeEster
from tbl_make_ester
         join tbl_tank on idTank = fkTank;

CREATE OR REPLACE VIEW view_matter_ester AS
SELECT fkMakeEster,
       idMatterEster,
       literMatterEster,
       nameProduct
FROM tbl_matter_ester tm
         JOIN tbl_product tp on idProduct = fkProduct;


CREATE OR REPLACE VIEW view_reaction_ester AS
SELECT dateReaction,
       methanolPure,
       methanolRecover,
       sulfuricAcid,
       timeFinal,
       timeStart,
       fkMakeEster,
       labInit.acidityTank   AS acidityInitial,
       labInit.saponityTank  AS saponityInitial,
       labInit.trashTank     AS trashInitial,
       labFinal.acidityTank  AS acidityFinal,
       labFinal.saponityTank AS saponityFinal,
       labFinal.trashTank    AS trashFinal
FROM tbl_reaction_make_ester
         join tbl_analyze_tank labInit on fkInitialAnalysys = labInit.idAnalyzeTank
         join tbl_analyze_tank labFinal on fkFinalAnalysis = labFinal.idAnalyzeTank;

CREATE OR REPLACE VIEW view_make_biodiesel AS
select amountMatterMakeBiodiesel,
       dateMakeBiodiesel,
       idMakeBiodiesel,
       nameTank,
       producedMakeBiodiesel,
       trashMakeBiodiesel
from tbl_make_biodiesel
         join tbl_tank tt on idTank = fkTank;

CREATE OR REPLACE VIEW view_matter_biodiesel AS
SELECT fkMakeBiodiesel,
       idMatterBiodiesel,
       literMatterBiodiesel,
       nameProduct
FROM tbl_matter_biodiesel tm
         JOIN tbl_product tp on idProduct = fkProduct;


CREATE OR REPLACE VIEW view_reaction_biodiesel AS
SELECT acidityTank,
       dateReactionMakeBiodiesel,
       fkMakeBiodiesel,
       methanolMakeBiodiesel,
       methylateMakeBiodiesel,
       saponityTank,
       timeFinal,
       timeStart,
       trashTank
FROM tbl_reaction_biodiesel
         join tbl_analyze_tank on fkAnalyzeTank = idAnalyzeTank;

CREATE OR REPLACE view view_sum_product AS
SELECT SUM(literProduct) AS sumLiter, fkProduct
FROM tbl_stock_tank;