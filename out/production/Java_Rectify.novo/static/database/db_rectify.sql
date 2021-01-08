DROP DATABASE IF EXISTS `db_rectify`;
CREATE SCHEMA IF NOT EXISTS `db_rectify`;
USE `db_rectify`;

DROP TABLE IF EXISTS `tbl_tank`;
CREATE TABLE IF NOT EXISTS `tbl_tank`
(
    idTank       INT         NOT NULL AUTO_INCREMENT,
    capacityTank INT         NOT NULL,
    nameTank     VARCHAR(35) NOT NULL,
    PRIMARY KEY (idTank),
    CONSTRAINT `NOME_TANQUE` UNIQUE (nameTank)
);

DROP TABLE IF EXISTS `tbl_provider`;
CREATE TABLE IF NOT EXISTS `tbl_provider`
(
    idProvider    INT         NOT NULL AUTO_INCREMENT,
    cnpjProvider  CHAR(14)    NOT NULL,
    nameProvider  VARCHAR(35) NOT NULL,
    phoneProvider CHAR(11)    NOT NULL,
    PRIMARY KEY (idProvider),
    CONSTRAINT `CNPJ_FONECEDOR` UNIQUE (cnpjProvider)
);
DROP TABLE IF EXISTS `tbl_product`;
CREATE TABLE IF NOT EXISTS `tbl_product`
(
    idProduct      INT         NOT NULL AUTO_INCREMENT,
    densityProduct DOUBLE      NOT NULL,
    nameProduct    VARCHAR(35) NOT NULL,
    PRIMARY KEY (idProduct),
    CONSTRAINT `NOME_PRODUTO` UNIQUE (nameProduct)
);

DROP TABLE IF EXISTS tbl_analyze_split;
CREATE TABLE IF NOT EXISTS tbl_analyze_split
(
    idAnalyzeSplit        INT    NOT NULL AUTO_INCREMENT,
    fattyAcidPercentSplit DOUBLE NOT NULL DEFAULT 0,
    glycerinPercentSplit  DOUBLE NOT NULL DEFAULT 0,
    sludgePercentSplit    DOUBLE NOT NULL DEFAULT 0,
    trashPercentSplit     DOUBLE NOT NULL DEFAULT 0,
    dateAnalyzeSplit      DATE   NOT NULL DEFAULT (CURRENT_DATE()),
    timeAnalyzeSplit      TIME   NOT NULL DEFAULT (CURRENT_TIME()),
    PRIMARY KEY (idAnalyzeSplit)
);

DROP TABLE IF EXISTS `tbl_driver`;
CREATE TABLE IF NOT EXISTS `tbl_driver`
(
    idDriver   INT          NOT NULL AUTO_INCREMENT,
    cnhDriver  CHAR(11)     NOT NULL,
    nameDriver VARCHAR(255) NOT NULL,
    PRIMARY KEY (idDriver),
    CONSTRAINT `CNH_MOTORISTA` UNIQUE (cnhDriver)
);

DROP TABLE IF EXISTS tbl_analyze_truck;
CREATE TABLE IF NOT EXISTS tbl_analyze_truck
(
    idAnalyzeTruck   INT    NOT NULL AUTO_INCREMENT,
    collect          INT    NOT NULL,
    fkProduct        INT    NOT NULL,
    trashTruck       INT    NOT NULL DEFAULT 0,
    acidityTruck     DOUBLE NOT NULL DEFAULT 0,
    densityTruck     DOUBLE NOT NULL,
    saponityTruck    DOUBLE NOT NULL DEFAULT 0,
    dateAnalyzeTruck DATE   NOT NULL DEFAULT (CURRENT_DATE()),
    timeAnalyzeTruck TIME   NOT NULL DEFAULT (CURRENT_TIME()),
    PRIMARY KEY (idAnalyzeTruck),
    CONSTRAINT `FK_PRODUTO_ANALISADO` FOREIGN KEY (fkProduct)
        REFERENCES tbl_product (idProduct)
);

DROP TABLE IF EXISTS `tbl_analyze_truck_split`;
CREATE TABLE IF NOT EXISTS tbl_analyze_truck_split
(
    idAnalyzeTruckSplit INT NOT NULL AUTO_INCREMENT,
    fkAnalyzeSplit      INT NOT NULL,
    fkAnalyzeTruck      INT NOT NULL,
    PRIMARY KEY (idAnalyzeTruckSplit),
    CONSTRAINT `FK_ANALISE_CAMINHAO` FOREIGN KEY (fkAnalyzeTruck)
        REFERENCES tbl_analyze_truck (idAnalyzeTruck),
    CONSTRAINT `FK_TRIDECANTE` FOREIGN KEY (fkAnalyzeSplit)
        REFERENCES tbl_analyze_split (idAnalyzeSplit)
);

DROP TABLE IF EXISTS tbl_analyze_biodiesel;
CREATE TABLE IF NOT EXISTS tbl_analyze_biodiesel
(
    idAnalyzeBiodiesel        INT    NOT NULL AUTO_INCREMENT,
    acidityBiodiesel          DOUBLE NOT NULL DEFAULT 0,
    densityBiodiesel          DOUBLE NOT NULL,
    densityBiodiesel20Degress DOUBLE NOT NULL,
    correctionFactorBiodiesel DOUBLE NOT NULL,
    temperatureBiodiesel      DOUBLE NOT NULL,
    dateAnalyzeBiodiesel      DATE   NOT NULL DEFAULT (CURRENT_DATE()),
    timeAnalyzeBiodiesel      TIME   NOT NULL DEFAULT (CURRENT_TIME()),
    PRIMARY KEY (idAnalyzeBiodiesel)
);

DROP TABLE IF EXISTS tbl_analyze_tank;
CREATE TABLE IF NOT EXISTS tbl_analyze_tank
(
    idAnalyzeTank   INT    NOT NULL AUTO_INCREMENT,
    trashTank       INT    NOT NULL DEFAULT 0,
    fkTank          INT    NOT NULL,
    acidityTank     DOUBLE NOT NULL DEFAULT 0,
    saponityTank    DOUBLE NOT NULL DEFAULT 0,
    dateAnalyzeTank DATE   NOT NULL DEFAULT (CURRENT_DATE()),
    timeAnalyzeTank TIME   NOT NULL DEFAULT (CURRENT_TIME()),
    PRIMARY KEY (idAnalyzeTank),
    CONSTRAINT `FK_TANQUE_ANALISADO` FOREIGN KEY (fkTank)
        REFERENCES `tbl_Tank` (idTank)
);

DROP TABLE IF EXISTS `tbl_charge`;
CREATE TABLE IF NOT EXISTS `tbl_charge`
(
    idCharge        INT     NOT NULL AUTO_INCREMENT,
    burdenCharge    INT     NOT NULL,
    literCharge     INT     NOT NULL,
    noteCharge      INT     NOT NULL,
    ticketCharge    INT     NOT NULL,
    fkTank          INT     NOT NULL,
    fkProvider      INT     NOT NULL,
    fkProduct       INT     NOT NULL,
    fkAnalyzeTruck  INT     NOT NULL,
    fkDriver        INT     NOT NULL,
    carPlateCharge  CHAR(7) NOT NULL,
    dateEntryCharge DATE    NOT NULL,
    dateExitCharge  DATE    NOT NULL,
    timeEntryCharge TIME    NOT NULL,
    timeExitCharge  TIME    NOT NULL,
    PRIMARY KEY (idCharge),
    CONSTRAINT `FK_TANQUE_CARGA` FOREIGN KEY (fkTank)
        REFERENCES `tbl_tank` (idTank),
    CONSTRAINT `FK_COMPRADOR` FOREIGN KEY (fkProvider)
        REFERENCES `tbl_provider` (idProvider),
    CONSTRAINT `FK_PRODUTO_CARGA` FOREIGN KEY (fkProduct)
        REFERENCES `tbl_product` (idProduct),
    CONSTRAINT `FK_MOTORISTA_CARGA` FOREIGN KEY (fkDriver)
        REFERENCES tbl_driver (idDriver),
    CONSTRAINT `FK_AANALISE_CARGA` FOREIGN KEY (fkAnalyzeTruck)
        REFERENCES tbl_analyze_truck (idAnalyzeTruck)
);

DROP TABLE IF EXISTS `tbl_discharge`;
CREATE TABLE IF NOT EXISTS `tbl_discharge`
(
    idDcharge        INT     NOT NULL AUTO_INCREMENT,
    burdenDcharge    INT     NOT NULL,
    literDcharge     INT     NOT NULL,
    noteDcharge      INT     NOT NULL,
    ticketDcharge    INT     NOT NULL,
    fkTank           INT     NOT NULL,
    fkProvider       INT     NOT NULL,
    fkProduct        INT     NOT NULL,
    fkAnalyzeTruck   INT     NOT NULL,
    fkDriver         INT     NOT NULL,
    carPlateDcharge  CHAR(7) NOT NULL,
    dateEntryDcharge DATE    NOT NULL,
    dateExitDcharge  DATE    NOT NULL,
    timeEntryDcharge TIME    NOT NULL,
    timeExitDcharge  TIME    NOT NULL,
    PRIMARY KEY (idDcharge),
    CONSTRAINT `FK_TANQUE_DESCARGA` FOREIGN KEY (fkTank)
        REFERENCES `tbl_tank` (idTank),
    CONSTRAINT `FK_FORNECEDOR` FOREIGN KEY (fkProvider)
        REFERENCES `tbl_provider` (idProvider),
    CONSTRAINT `FK_PRODUTO_DESCARGA` FOREIGN KEY (fkProduct)
        REFERENCES `tbl_product` (idProduct),
    CONSTRAINT `FK_MOTORISTA_DESCARGA` FOREIGN KEY (fkDriver)
        REFERENCES tbl_driver (idDriver),
    CONSTRAINT `FK_ANALISE_DESCARGA` FOREIGN KEY (fkAnalyzeTruck)
        REFERENCES tbl_analyze_truck (idAnalyzeTruck)
);

DROP TABLE IF EXISTS tbl_stock_tank;
CREATE TABLE IF NOT EXISTS tbl_stock_tank
(
    idStockTank   INT  NOT NULL AUTO_INCREMENT,
    fkTank        INT  NOT NULL,
    fkProduct     INT  NOT NULL,
    literProduct  INT  NOT NULL,
    dateStockTank DATE NOT NULL DEFAULT (curdate()),
    PRIMARY KEY (idStockTank),
    CONSTRAINT `FK_TANQUE_ESTOQUE` FOREIGN KEY (fkTank)
        REFERENCES tbl_tank (idTank),
    CONSTRAINT `FK_PRODUTO_TANQUE` FOREIGN KEY (fkProduct)
        REFERENCES tbl_product (idProduct)
);

DROP TABLE IF EXISTS `tbl_stock_product`;
CREATE TABLE IF NOT EXISTS tbl_stock_product
(
    idStockProduct   INT  NOT NULL AUTO_INCREMENT,
    fkProduct        INT  NOT NULL,
    literProduct     INT  NOT NULL,
    percentProduct   DOUBLE  NOT NULL,
    dateStockProduct DATE NOT NULL DEFAULT (curdate()),
    PRIMARY KEY (idStockProduct),
    CONSTRAINT `FK_PRODUTO_ESTOCADO` FOREIGN KEY (fkProduct)
        REFERENCES tbl_product (idProduct)
);

DROP TABLE IF EXISTS tbl_sample;
CREATE TABLE IF NOT EXISTS tbl_sample
(
    idSample             INT  NOT NULL AUTO_INCREMENT,
    auctionNumber        INT  NOT NULL,
    clientSample         INT  NOT NULL,
    factorySample        INT  NOT NULL,
    fkProvider           INT  NOT NULL,
    petrobrasSample      INT  NOT NULL,
    dateSampleCollection DATE NOT NULL DEFAULT (curdate()),
    PRIMARY KEY (idSample),
    CONSTRAINT `AMOSTRA_CLIENTE` UNIQUE (clientSample),
    CONSTRAINT `AMOSTRA_FABRICA` UNIQUE (factorySample),
    CONSTRAINT `AMOSTRA_PETROBRAS` UNIQUE (petrobrasSample),
    CONSTRAINT `FK_AMOSTRA_CLIENTE` FOREIGN KEY (fkProvider)
        REFERENCES tbl_provider (idProvider)
);

DROP TABLE IF EXISTS `tbl_make_ester`;
CREATE TABLE IF NOT EXISTS tbl_make_ester
(
    idMakeEster           INT  NOT NULL AUTO_INCREMENT,
    amountMatterMakeEster INT  NOT NULL,
    fkTank                INT  NOT NULL,
    producedMakeEster     INT  NOT NULL,
    trashMakeEster        INT  NOT NULL,
    dateMakeEster         DATE NOT NULL,
    PRIMARY KEY (idMakeEster),
    CONSTRAINT `FK_TANQUE_ESTERIFICACAO` FOREIGN KEY (fkTank)
        REFERENCES tbl_tank (idTank)
);

DROP TABLE IF EXISTS `tbl_matter_ester`;
CREATE TABLE IF NOT EXISTS `tbl_matter_ester`
(
    idMatterEster    INT NOT NULL AUTO_INCREMENT,
    fkProduct        INT NOT NULL,
    fkMakeEster      INT NOT NULL,
    literMatterEster INT NOT NULL,
    PRIMARY KEY (idMatterEster),
    CONSTRAINT `FK_PRODUTO_ESTERIFICACAO` FOREIGN KEY (fkProduct)
        REFERENCES tbl_product (idProduct),
    CONSTRAINT `FK_ESTERIFICACAO_MATERIA` FOREIGN KEY (fkMakeEster)
        REFERENCES tbl_make_ester (idMakeEster)
);

DROP TABLE IF EXISTS tbl_reaction_make_ester;
CREATE TABLE IF NOT EXISTS tbl_reaction_make_ester
(
    idReaction        INT  NOT NULL AUTO_INCREMENT,
    fkFinalAnalysis   INT  NOT NULL,
    fkInitialAnalysys INT  NOT NULL,
    fkMakeEster       INT  NOT NULL,
    methanolPure      INT  NOT NULL,
    methanolRecover   INT  NOT NULL,
    sulfuricAcid      INT  NOT NULL,
    dateReaction      DATE NOT NULL,
    timeStart         TIME NOT NULL,
    timeFinal         TIME NOT NULL,
    PRIMARY KEY (idReaction),
    CONSTRAINT `FK_ANALISE_INICIAL_ESTERIFICACAO` FOREIGN KEY (fkInitialAnalysys)
        REFERENCES tbl_analyze_tank (idAnalyzeTank),
    CONSTRAINT `FK_ESTERIFICACAO_REACAO` FOREIGN KEY (fkMakeEster)
        REFERENCES tbl_make_ester (idMakeEster),
    CONSTRAINT `FK_ANALISE_FINAL_ESTERIFICACAO` FOREIGN KEY (fkFinalAnalysis)
        REFERENCES tbl_analyze_tank (idAnalyzeTank)
);

DROP TABLE IF EXISTS `tbl_make_biodiesel`;
CREATE TABLE IF NOT EXISTS tbl_make_biodiesel
(
    idMakeBiodiesel           INT  NOT NULL AUTO_INCREMENT,
    amountMatterMakeBiodiesel INT  NOT NULL,
    fkTank                    INT  NOT NULL,
    trashMakeBiodiesel        INT  NOT NULL,
    producedMakeBiodiesel     INT  NOT NULL,
    dateMakeBiodiesel         DATE NOT NULL,
    PRIMARY KEY (idMakeBiodiesel),
    CONSTRAINT `FK_TANQUE_TRASESTERIFICACAO` FOREIGN KEY (fkTank)
        REFERENCES tbl_tank (idTank)
);

DROP TABLE IF EXISTS `tbl_matter_biodiesel`;
CREATE TABLE IF NOT EXISTS tbl_matter_biodiesel
(
    idMatterBiodiesel    INT NOT NULL AUTO_INCREMENT,
    fkProduct            INT NOT NULL,
    fkMakeBiodiesel      INT NOT NULL,
    literMatterBiodiesel INT NOT NULL,
    PRIMARY KEY (idMatterBiodiesel),
    CONSTRAINT `FK_PRODUTO_TRASESTERIFICACAO` FOREIGN KEY (fkProduct)
        REFERENCES tbl_product (idProduct),
    CONSTRAINT `FK_TRASESTERIFICACAO_MATERIA` FOREIGN KEY (fkMakeBiodiesel)
        REFERENCES tbl_make_biodiesel (idMakeBiodiesel)
);

DROP TABLE IF EXISTS `tbl_reaction_biodiesel`;
CREATE TABLE IF NOT EXISTS tbl_reaction_biodiesel
(
    idReactionMakeBiodiesel   INT  NOT NULL AUTO_INCREMENT,
    fkAnalyzeTank             INT  NOT NULL,
    fkMakeBiodiesel           INT  NOT NULL,
    methanolMakeBiodiesel     INT  NOT NULL,
    methylateMakeBiodiesel    INT  NOT NULL,
    dateReactionMakeBiodiesel DATE NOT NULL,
    timeStart                 TIME NOT NULL,
    timeFinal                 TIME NOT NULL,
    PRIMARY KEY (idReactionMakeBiodiesel),
    CONSTRAINT `FK_ANALISE_TRASESTERIFICACAO` FOREIGN KEY (fkAnalyzeTank)
        REFERENCES tbl_analyze_tank (idAnalyzeTank),
    CONSTRAINT `FK_TRASESTERIFICACAO_REACAO` FOREIGN KEY (fkMakeBiodiesel)
        REFERENCES tbl_make_biodiesel (idMakeBiodiesel)
);

DROP TABLE IF EXISTS `tbl_naoh`;
CREATE TABLE IF NOT EXISTS tbl_naoh
(
    idNaoh            INT    NOT NULL AUTO_INCREMENT,
    concentrationNaoh DOUBLE NOT NULL,
    PRIMARY KEY (idNaoh),
    CONSTRAINT `CONCENTRACAO_NAOH` UNIQUE (concentrationNaoh)
);

DROP TABLE IF EXISTS `tbl_hcl`;
CREATE TABLE IF NOT EXISTS tbl_hcl
(
    idHcl            INT    NOT NULL AUTO_INCREMENT,
    concentrationHcl DOUBLE NOT NULL,
    PRIMARY KEY (idHcl),
    CONSTRAINT `CONCENTRACAO_HCL` UNIQUE (concentrationHcl)
);