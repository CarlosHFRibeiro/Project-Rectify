package dev.senzalla.rectify;

import dev.senzalla.rectify.entitys.*;
import dev.senzalla.rectify.request.*;
import dev.senzalla.rectify.treatments.*;

import java.util.Date;

public class MockFake {
    public MockFake() {
        System.out.println(new Date());
        mockSolutionNaoh();
        mockSolutionChl();
        mockProduct();
        mockTank();
        mockProvider();
        mockAnalyzeTruck();
        mockAnalyzeTank();
        mockDriver();
        mockCharge();
        mockDCharge();
        mockStockTank();
        mockMakeEster();
        mockMakeBio();
        System.out.println(new Date());
    }

    private void mockMakeBio() {
        for (int i = 0; i < 50; i++) {
            new MakeBiodieselTreatment().saveMakeBiodiesel(getTank(i), String.valueOf(i), String.valueOf(i), String.valueOf(i), new Date());
            mockMatterBio(i);
            mockReactionBio(i);
        }
    }

    private void mockReactionBio(int i) {
        for (int j = 0; j < 5; j++) {
            new ReactionBiodieselTreatment().saveReact(String.valueOf(i), String.valueOf(i), new Date(), "12:12:12", "12:12:12", getAnalyzeTank(i));
        }
    }

    private void mockMatterBio(int i) {
        for (int j = 0; j < 5; j++) {
            new MatterBiodieselRequest().insert(getMatter(i));
        }
    }

    private void mockMakeEster() {
        for (int i = 0; i < 50; i++) {
            new MakeEsterTreatment().saveMakeEster(getTank(i), String.valueOf(i), String.valueOf(i), String.valueOf(i), new Date());
            mockMatterEster(i);
            mockReactionEster(i);
        }
    }

    private void mockReactionEster(int i) {
        for (int j = 0; j < 5; j++) {
            new ReactionEsterTreatment().saveReact(String.valueOf(i), String.valueOf(i), String.valueOf(i), "12:12:12", "12:12:12", getAnalyzeTank(i), getAnalyzeTank(i), new Date());
        }
    }

    private void mockMatterEster(int i) {
        for (int j = 0; j < 5; j++) {
            new MatterEsterRequest().insert(getMatter(i));
        }
    }


    private MatterMake getMatter(int i) {
        MatterMake matterMake = new MatterMake();
        matterMake.setProduct(getProuct(i));
        matterMake.setLiterMatterMake(i);
        return matterMake;
    }

    private void mockStockTank() {
        for (int i = 0; i < 50; i++) {
            StockTank stockTank = new StockTank();
            stockTank.setTank(getTank(i));
            stockTank.setProduct(getProuct(i));
            stockTank.setLiterProduct(i);
            new StockTankRequest().insert(stockTank);
        }
    }

    private void mockCharge() {
        for (int i = 0; i < 50; i++) {
            new ChargeTreatment().saveChage(getProvider(i), new Date(), "12:12:12", 1, 1, String.valueOf(i), getDriver(), new Date(), "12:12:12", getProuct(i), getAnalyzeTruck(i), String.valueOf(i), String.valueOf(i), getTank(i));
        }
    }

    private void mockDCharge() {
        for (int i = 0; i < 50; i++) {
            new DischargeTreatment().saveDchage(getProvider(i), new Date(), "12:12:12", 1, 1, String.valueOf(i), getDriver(), new Date(), "12:12:12", getProuct(i), getAnalyzeTruck(i), String.valueOf(i), String.valueOf(i), getTank(i));
        }
    }


    private void mockDriver() {
        new DriverTreatment().saveDriver("Motorista", String.valueOf(123));
    }

    private void mockAnalyzeTank() {
        for (int i = 0; i < 50; i++) {
            new AnalyzeTankTreatment().saveLabTank(getTank(i), String.valueOf(i), String.valueOf(i), String.valueOf(i));
        }
    }

    private void mockAnalyzeTruck() {
        for (int i = 0; i < 50; i++) {
            new AnalyzeTruckTreatment().saveAnalyzeTruck(String.valueOf(i), String.valueOf(i), String.valueOf(i), String.valueOf(i), 1, getProuct(i));
        }
    }


    private void mockProvider() {
        for (int i = 0; i < 50; i++) {
            new ProviderTreatment().saveProvider(String.valueOf(i), String.valueOf(i), String.valueOf(i));
        }
    }

    private void mockTank() {
        for (int i = 0; i < 50; i++) {
            new TankTreatment().saveTanque(String.valueOf(i), String.valueOf(i));
        }
    }

    private void mockProduct() {
        for (int i = 0; i < 50; i++) {
            new ProductTreatment().saveProduct(String.valueOf(i), String.valueOf(i));
        }
    }

    private void mockSolutionChl() {
        for (int i = 0; i < 50; i++) {
            Hcl hcl = new Hcl();
            hcl.setConcentrationHcl(i);
            new HclRequest().insert(hcl);
        }
    }

    private void mockSolutionNaoh() {
        for (int i = 0; i < 50; i++) {
            Naoh naoh = new Naoh();
            naoh.setConcentrationNaoh(i);
            new NaohRequest().insert(naoh);
        }
    }

    private AnalyzeTruck getAnalyzeTruck(int i) {
        AnalyzeTruck analyzeTruck = new AnalyzeTruck();
        analyzeTruck.setIdAnalyzeTruck(i + 1L);
        return analyzeTruck;
    }

    private Driver getDriver() {
        Driver driver = new Driver();
        driver.setIdDriver(1L);
        return driver;
    }

    private Provider getProvider(int i) {
        Provider provider = new Provider();
        provider.setIdProvider(i + 1L);
        return provider;
    }

    private Tank getTank(int i) {
        Tank tank = new Tank();
        tank.setIdTank((long) i + 1);
        return tank;
    }

    private Product getProuct(int i) {
        Product product = new Product();
        product.setIdProduct(i + 1L);
        return product;
    }

    private AnalyzeTank getAnalyzeTank(int i) {
        AnalyzeTank analyzeTank = new AnalyzeTank();
        analyzeTank.setIdAnalyzeTank(i + 1L);
        return analyzeTank;
    }
}
