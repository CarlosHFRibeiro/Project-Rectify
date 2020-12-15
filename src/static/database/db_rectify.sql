DROP DATABASE IF EXISTS `db_retifica`;
CREATE SCHEMA IF NOT EXISTS `db_retifica`;
USE `db_retifica`;

DROP TABLE IF EXISTS `tbl_tank`;
CREATE TABLE IF NOT EXISTS `tbl_tank`
(
    idTank       INT         NOT NULL AUTO_INCREMENT,
    capacityTank INT         NOT NULL,
    nameTank     VARCHAR(35) NOT NULL,
    PRIMARY KEY (idTank),
    CONSTRAINT `Nome_Tanque` UNIQUE (nameTank)
);

DROP TABLE IF EXISTS `tbl_provider`;
CREATE TABLE IF NOT EXISTS `tbl_provider`
(
    idProvider    INT         NOT NULL AUTO_INCREMENT,
    cnpjProvider  CHAR(14)    NOT NULL,
    phoneProvider CHAR(11)    NOT NULL,
    nameProvider  VARCHAR(35) NOT NULL,
    PRIMARY KEY (idProvider),
    CONSTRAINT `CNPJ Parceiro` UNIQUE (cnpjProvider)
);
DROP TABLE IF EXISTS `tbl_product`;
CREATE TABLE IF NOT EXISTS `tbl_product`
(
    idProduct      INT         NOT NULL AUTO_INCREMENT,
    densityProduct DOUBLE      NOT NULL,
    nameProduct    VARCHAR(35) NOT NULL,
    PRIMARY KEY (idProduct),
    CONSTRAINT `Nome Produto` UNIQUE (nameProduct)
);

DROP TABLE IF EXISTS `tbl_labSplit`;
CREATE TABLE IF NOT EXISTS `tbl_labSplit`
(
    idSplit       INT  NOT NULL AUTO_INCREMENT,
    oilSplit      INT  NOT NULL DEFAULT 0,
    sludgeSplit   INT  NOT NULL DEFAULT 0,
    glycerinSplit INT  NOT NULL DEFAULT 0,
    trashSplit    INT  NOT NULL DEFAULT 0,
    dtSplit       DATE NOT NULL DEFAULT (CURRENT_DATE()),
    hrSplit       TIME NOT NULL DEFAULT (CURRENT_TIME()),
    PRIMARY KEY (idSplit)
);

DROP TABLE IF EXISTS `tbl_driver`;
CREATE TABLE IF NOT EXISTS `tbl_driver`
(
    idDriver   INT          NOT NULL AUTO_INCREMENT,
    cnhDriver  CHAR(11)     NOT NULL,
    nameDriver VARCHAR(255) NOT NULL,
    PRIMARY KEY (idDriver),
    CONSTRAINT `CNH Motorista` UNIQUE (cnhDriver)
);

DROP TABLE IF EXISTS `tbl_labCar`;
CREATE TABLE IF NOT EXISTS `tbl_labCar`
(
    idCar      INT    NOT NULL AUTO_INCREMENT,
    trashCar   INT    NOT NULL DEFAULT 0,
    collectCar INT    NOT NULL,
    acidCar    DOUBLE NOT NULL DEFAULT 0,
    soapCar    DOUBLE NOT NULL DEFAULT 0,
    densityCar DOUBLE NOT NULL,
    dtCar      DATE   NOT NULL DEFAULT (CURRENT_DATE()),
    hrCar      TIME   NOT NULL DEFAULT (CURRENT_TIME()),
    PRIMARY KEY (idCar)
);

DROP TABLE IF EXISTS `tbl_labCarsplit`;
CREATE TABLE IF NOT EXISTS `tbl_labCarsplit`
(
    idCarSplit INT NOT NULL AUTO_INCREMENT,
    fkLabCar   INT NOT NULL,
    fkLabSplit INT NOT NULL,
    PRIMARY KEY (idCarSplit),
    CONSTRAINT `FK_Analise_Caminhao` FOREIGN KEY (fkLabCar)
        REFERENCES `tbl_labCar` (idCar),
    CONSTRAINT `FK_Tridecante` FOREIGN KEY (fkLabSplit)
        REFERENCES `tbl_labSplit` (idSplit)
);

DROP TABLE IF EXISTS `tbl_labBio`;
CREATE TABLE IF NOT EXISTS `tbl_labBio`
(
    idBio        INT    NOT NULL AUTO_INCREMENT,
    acidBio      DOUBLE NOT NULL DEFAULT 0,
    densityBio   DOUBLE NOT NULL,
    density20Bio DOUBLE NOT NULL,
    tempBio      DOUBLE NOT NULL,
    factorBio    DOUBLE NOT NULL,
    dtBio        DATE   NOT NULL DEFAULT (CURRENT_DATE()),
    hrBio        TIME   NOT NULL DEFAULT (CURRENT_TIME()),
    PRIMARY KEY (idBio)
);

DROP TABLE IF EXISTS `tbl_labTank`;
CREATE TABLE IF NOT EXISTS `tbl_labTank`
(
    idTq     INT    NOT NULL AUTO_INCREMENT,
    trashTq  INT    NOT NULL DEFAULT 0,
    fkTankTq INT    NOT NULL,
    acidTq   DOUBLE NOT NULL DEFAULT 0,
    soapTq   DOUBLE NOT NULL DEFAULT 0,
    dtTq     DATE   NOT NULL DEFAULT (CURRENT_DATE()),
    hrTq     TIME   NOT NULL DEFAULT (CURRENT_TIME()),
    PRIMARY KEY (idTq),
    CONSTRAINT `FK_Tanque_Tanque` FOREIGN KEY (fkTankTq)
        REFERENCES `tbl_Tank` (idTank)
);

DROP TABLE IF EXISTS `tbl_charge`;
CREATE TABLE IF NOT EXISTS `tbl_charge`
(
    idCharge         INT     NOT NULL AUTO_INCREMENT,
    noteCharge       INT     NOT NULL,
    ticketCharge     INT     NOT NULL,
    burdenCharge     INT     NOT NULL,
    literCharge      INT     NOT NULL,
    fkTankCharge     INT     NOT NULL,
    fkProviderCharge INT     NOT NULL,
    fkProductCharge  INT     NOT NULL,
    fkLabCharge      INT     NOT NULL,
    fkDriverCharge   INT     NOT NULL,
    boardCharge      CHAR(7) NOT NULL,
    dtOfCharge       DATE    NOT NULL,
    dtUpCharge       DATE    NOT NULL,
    hrOfCharge       TIME    NOT NULL,
    hrUpCharge       TIME    NOT NULL,
    PRIMARY KEY (idCharge),
    CONSTRAINT `FK_Tanque_Carregamento` FOREIGN KEY (fkTankCharge)
        REFERENCES `tbl_tank` (idTank),
    CONSTRAINT `FK_Fornecedor_Carregamento` FOREIGN KEY (fkProviderCharge)
        REFERENCES `tbl_provider` (idProvider),
    CONSTRAINT `FK_Produto_Carregamento` FOREIGN KEY (fkProductCharge)
        REFERENCES `tbl_product` (idProduct),
    CONSTRAINT `FK_Motorista_Carregamento` FOREIGN KEY (fkDriverCharge)
        REFERENCES tbl_driver (idDriver),
    CONSTRAINT `FK_Analise_Carregamento` FOREIGN KEY (fkLabCharge)
        REFERENCES tbl_labCar (idCar)
);

DROP TABLE IF EXISTS `tbl_discharge`;
CREATE TABLE IF NOT EXISTS `tbl_discharge`
(
    idDcharge         INT     NOT NULL AUTO_INCREMENT,
    noteDcharge       INT     NOT NULL,
    ticketDcharge     INT     NOT NULL,
    burdenDcharge     INT     NOT NULL,
    literDcharge      INT     NOT NULL,
    fkTankDcharge     INT     NOT NULL,
    fkProviderDcharge INT     NOT NULL,
    fkProductDcharge  INT     NOT NULL,
    fkLabDcharge      INT     NOT NULL,
    fkDriverDcharge   INT     NOT NULL,
    boardDcharge      CHAR(7) NOT NULL,
    dtOfDcharge       DATE    NOT NULL,
    dtUpDcharge       DATE    NOT NULL,
    hrOfDcharge       TIME    NOT NULL,
    hrUpDcharge       TIME    NOT NULL,
    PRIMARY KEY (idDcharge),
    CONSTRAINT `FK_Tanque_Descarregamento` FOREIGN KEY (fkTankDcharge)
        REFERENCES `tbl_tank` (idTank),
    CONSTRAINT `FK_Fornecedor_Descarregamento` FOREIGN KEY (fkProviderDcharge)
        REFERENCES `tbl_provider` (idProvider),
    CONSTRAINT `FK_Produto_Descarregamento` FOREIGN KEY (fkProductDcharge)
        REFERENCES `tbl_product` (idProduct),
    CONSTRAINT `FK_Motorista_Descarregamento` FOREIGN KEY (fkDriverDcharge)
        REFERENCES tbl_driver (idDriver),
    CONSTRAINT `FK_Analise_Descarregamento` FOREIGN KEY (fkLabDcharge)
        REFERENCES tbl_labCar (idCar)
);

DROP TABLE IF EXISTS `tbl_stocktank`;
CREATE TABLE IF NOT EXISTS tbl_stocktank
(
    idStkTq        INT  NOT NULL AUTO_INCREMENT,
    literStkTq     INT  NOT NULL,
    fkTankStkTq    INT  NOT NULL,
    fkProductStkTq INT  NOT NULL,
    dtStkTq        DATE NOT NULL DEFAULT (curdate()),
    PRIMARY KEY (idStkTq),
    CONSTRAINT `FK_Tanque_Estoque` FOREIGN KEY (fkTankStkTq)
        REFERENCES tbl_tank (idTank),
    CONSTRAINT `FK_Produto_Estoque_Tanque` FOREIGN KEY (fkProductStkTq)
        REFERENCES tbl_product (idProduct)
);

DROP TABLE IF EXISTS `tbl_stockproduct`;
CREATE TABLE IF NOT EXISTS tbl_stockproduct
(
    idStkPd        INT  NOT NULL AUTO_INCREMENT,
    literStkPd     INT  NOT NULL,
    percentStkPd   INT  NOT NULL,
    fkProductStkPd INT  NOT NULL,
    dtStkPd        DATE NOT NULL DEFAULT (curdate()),
    PRIMARY KEY (idStkPd),
    CONSTRAINT `FK_Produto_Estoque_Produto` FOREIGN KEY (fkProductStkPd)
        REFERENCES tbl_product (idProduct)
);

DROP TABLE IF EXISTS `tbl_seal`;
CREATE TABLE IF NOT EXISTS tbl_seal
(
    idSeal         INT  NOT NULL AUTO_INCREMENT,
    saleSeal       INT  NOT NULL,
    clientSeal     INT  NOT NULL,
    factorySeal    INT  NOT NULL,
    brSeal         INT  NOT NULL,
    fkProviderSeal INT  NOT NULL,
    dtSeal         DATE NOT NULL DEFAULT (curdate()),
    PRIMARY KEY (idSeal),
    CONSTRAINT `Selo_Cliente` UNIQUE (clientSeal),
    CONSTRAINT `Selo_Fabrica` UNIQUE (factorySeal),
    CONSTRAINT `Selo_Petrobras` UNIQUE (brSeal),
    CONSTRAINT `FK_Parceiro_Selo` FOREIGN KEY (fkProviderSeal)
        REFERENCES tbl_provider (idProvider)
);

DROP TABLE IF EXISTS `tbl_makeEster`;
CREATE TABLE IF NOT EXISTS `tbl_makeEster`
(
    idEster       INT  NOT NULL AUTO_INCREMENT,
    reactEster    INT  NOT NULL,
    fkTankEster   INT  NOT NULL,
    amountEster   INT  NOT NULL,
    foreseenEster INT  NOT NULL,
    trashEster    INT  NOT NULL,
    producedEster INT  NOT NULL,
    dtEster       DATE NOT NULL,
    PRIMARY KEY (idEster),
    CONSTRAINT `FK_Tanque_Esterificacao` FOREIGN KEY (fkTankEster)
        REFERENCES tbl_tank (idTank)
);

DROP TABLE IF EXISTS `tbl_matterEster`;
CREATE TABLE IF NOT EXISTS `tbl_matterEster`
(
    idMtEster        INT NOT NULL AUTO_INCREMENT,
    literMtEster     INT NOT NULL,
    fkProductMtEster INT NOT NULL,
    fkMtEster        INT NOT NULL,
    PRIMARY KEY (idMtEster),
    CONSTRAINT `FK_Produto_Esterificacao` FOREIGN KEY (fkProductMtEster)
        REFERENCES tbl_product (idProduct),
    CONSTRAINT `FK_Materia_Esterificacao` FOREIGN KEY (fkMtEster)
        REFERENCES tbl_makeEster (idEster)
);

DROP TABLE IF EXISTS `tbl_reactEster`;
CREATE TABLE IF NOT EXISTS `tbl_reactEster`
(
    idRctEster         INT  NOT NULL AUTO_INCREMENT,
    fkLabStartRctEster INT  NOT NULL,
    fkRctEster         INT  NOT NULL,
    sulfuricRctEster   INT  NOT NULL,
    pureRctEster       INT  NOT NULL,
    recoverRctEster    INT  NOT NULL,
    fkLabFinalRctEster INT  NOT NULL,
    dtRctEster         DATE NOT NULL,
    hrStartRctEster    TIME NOT NULL,
    hrFinalRctEster    TIME NOT NULL,
    PRIMARY KEY (idRctEster),
    CONSTRAINT `FK_Analise_Inicial_Esterificacao` FOREIGN KEY (fkLabStartRctEster)
        REFERENCES tbl_labTank (idTq),
    CONSTRAINT `FK_Reacao_Esterificacao` FOREIGN KEY (fkRctEster)
        REFERENCES tbl_makeEster (idEster),
    CONSTRAINT `FK_Analise_Final_Esterificacao` FOREIGN KEY (fkLabFinalRctEster)
        REFERENCES tbl_labTank (idTq)
);

DROP TABLE IF EXISTS `tbl_makeTrans`;
CREATE TABLE IF NOT EXISTS `tbl_makeTrans`
(
    idTrans       INT NOT NULL AUTO_INCREMENT,
    reactTrans    INT NOT NULL,
    fkTankTrans   INT NOT NULL,
    amountTrans   INT NOT NULL,
    foreseenTrans INT NOT NULL,
    trashTrans    INT NOT NULL,
    producedTrans INT NOT NULL,
    PRIMARY KEY (idTrans),
    CONSTRAINT `FK_Tanque_Transesterificacao` FOREIGN KEY (fkTankTrans)
        REFERENCES tbl_tank (idTank)
);

DROP TABLE IF EXISTS `tbl_matterTrans`;
CREATE TABLE IF NOT EXISTS `tbl_matterTrans`
(
    idMtTrans        INT NOT NULL AUTO_INCREMENT,
    literMtTrans     INT NOT NULL,
    fkProductMtTrans INT NOT NULL,
    fkMtTrans        INT NOT NULL,
    PRIMARY KEY (idMtTrans),
    CONSTRAINT `FK_Produto_Transesterificacao` FOREIGN KEY (fkProductMtTrans)
        REFERENCES tbl_product (idProduct),
    CONSTRAINT `FK_Materia_Transesterificacao` FOREIGN KEY (fkMtTrans)
        REFERENCES tbl_makeTrans (idTrans)
);

DROP TABLE IF EXISTS `tbl_reactTrans`;
CREATE TABLE IF NOT EXISTS `tbl_reactTrans`
(
    idRctTrans        INT  NOT NULL AUTO_INCREMENT,
    fkLabRctTrans     INT  NOT NULL,
    fkRctTrans        INT  NOT NULL,
    methylateRctTrans INT  NOT NULL,
    pureRctTrans      INT  NOT NULL,
    dtRctTrans        DATE NOT NULL,
    hrStartRctTrans   TIME NOT NULL,
    hrFinalRctTrans   TIME NOT NULL,
    PRIMARY KEY (idRctTrans),
    CONSTRAINT `FK_Analise_Inicial_Transesterificacao` FOREIGN KEY (fkLabRctTrans)
        REFERENCES tbl_labTank (idTq),
    CONSTRAINT `FK_Reacao_Transesterificacao` FOREIGN KEY (fkRctTrans)
        REFERENCES tbl_makeTrans (idTrans)
);

DROP TABLE IF EXISTS `tbl_naoh`;
CREATE TABLE IF NOT EXISTS tbl_naoh
(
    idNaoh    INT    NOT NULL AUTO_INCREMENT,
    valueNaoh DOUBLE NOT NULL,
    PRIMARY KEY (idNaoh),
    CONSTRAINT `Concentracao_Solucao_Naoh` UNIQUE (valueNaoh)
);

DROP TABLE IF EXISTS `tbl_hcl`;
CREATE TABLE IF NOT EXISTS tbl_hcl
(
    idHcl    INT    NOT NULL AUTO_INCREMENT,
    valueHcl DOUBLE NOT NULL,
    PRIMARY KEY (idHcl),
    CONSTRAINT `Concentracao_Solucao_HCl` UNIQUE (valueHcl)
);


# ('Boca'),('Sonda'),('Dreno'),('Bomba');