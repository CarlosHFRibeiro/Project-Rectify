package dev.senzalla.rectify.request;

import dev.senzalla.rectify.entitys.*;
import dev.senzalla.rectify.exception.DataBaseException;
import dev.senzalla.rectify.setting.ConectionMySql;
import dev.senzalla.rectify.treatments.QueryTreatment;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class ChargeRequest extends ConectionMySql {

    public void insert(Charge charge) {
        try {
            super.connection();
            final String sql = "INSERT INTO `tbl_charge` (`noteCharge`, `ticketCharge`, `burdenCharge`, `literCharge`, `fkTankCharge`, `fkProviderCharge`, `fkProductCharge`, `fkLabCharge`, `fkDriverCharge`, `boardCharge`, `dtOfCharge`, `dtUpCharge`, `hrOfCharge`, `hrUpCharge`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            super.prepareStatement(sql);
            stmt.setInt(1, charge.getNoteCharge());
            stmt.setInt(2, charge.getTicketCharge());
            stmt.setInt(3, charge.getBurdenCharge());
            stmt.setInt(4, charge.getLiterCharge());
            stmt.setLong(5, charge.getTank().getIdTank());
            stmt.setLong(6, charge.getProvider().getIdProvider());
            stmt.setLong(7, charge.getProduct().getIdProduct());
            stmt.setLong(8, charge.getAnalyzeTruck().getIdAnalyzeTruck());
            stmt.setLong(9, charge.getDriver().getIdDriver());
            stmt.setString(10, charge.getCarPlateCharge());
            stmt.setDate(11, charge.getDateEntryCharge());
            stmt.setDate(12, charge.getDateExitCharge());
            stmt.setTime(13, charge.getTimeEntryCharge());
            stmt.setTime(14, charge.getTimeExitCharge());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            DataBaseException.MsgErrorDataBase("Carregamento" + ex.getMessage());
        } finally {
            super.closeConnection();
        }
    }

    public Charge select(Charge cod) {
        return selectAll("SELECT * FROM view_charge WHERE idCharge = ?", cod).get(0);
    }


    public List<Charge> select(List<String> query, Charge charge) {
        String SELECT_QUERY = QueryTreatment.createQuery("view_charge", query);
        return selectAll(SELECT_QUERY, charge);
    }

    private List<Charge> selectAll(String query, Charge parameter) {
        super.connection();
        List<Charge> charges = new ArrayList<>();
        try {
            super.prepareStatement(query);
            this.prepareStatement(parameter);
            super.resultSet();
            while (rs.next()) {
                Charge charge = new Charge();
                charge.setIdCharge(rs.getLong("idCharge"));
                charge.setTicketCharge(rs.getInt("ticketCharge"));
                charge.setLiterCharge(rs.getInt("literCharge"));
                charge.setDateEntryCharge(rs.getDate("dtOfCharge"));

                charge.setNoteCharge(rs.getInt("noteCharge"));
                charge.setCarPlateCharge(rs.getString("boardCharge"));
                charge.setBurdenCharge(rs.getInt("burdenCharge"));
                charge.setDateExitCharge(rs.getDate("dtUpCharge"));
                charge.setTimeEntryCharge(rs.getTime("hrOfCharge"));
                charge.setTimeExitCharge(rs.getTime("hrUpCharge"));

                charge.setProvider(new Provider(rs.getString("nameProvider")));
                charge.setProduct(new Product(rs.getString("nameProduct")));
                charge.setTank(new Tank(rs.getString("nameTank")));

                Driver driver = new Driver();
                driver.setNameDriver(rs.getString("nameDriver"));
                driver.setCnhDriver(rs.getString("cnhDriver"));
                charge.setDriver(driver);

                AnalyzeTruck analyzeTruck = new AnalyzeTruck();
                analyzeTruck.setAcidityTruck(rs.getDouble("acidityTruck"));
                analyzeTruck.setDensityTruck(rs.getDouble("densityProduct"));
                analyzeTruck.setSaponityTruck(rs.getDouble("saponityTruck"));
                analyzeTruck.setTrashTruck(rs.getInt("trashTruck"));
                charge.setAnalyzeTruck(analyzeTruck);

                charges.add(charge);
            }
        } catch (SQLException ex) {
            DataBaseException.MsgErrorDataBase("Carregamento" + ex.getMessage());
        } finally {
            super.closeConnectionRs();
        }
        return charges;
    }

    private void prepareStatement(Charge parameter) throws SQLException {
        if (parameter != null) {
            int i = 1;
            if (parameter.getIdCharge() != null) {
                stmt.setLong(i, parameter.getIdCharge());
            }
            if (parameter.getDateEntryCharge() != null) {
                stmt.setDate(i++, parameter.getDateEntryCharge());
            }
            if (parameter.getDateBetween() != null) {
                stmt.setDate(i++, parameter.getDateBetween());
            }
            if (parameter.getTicketCharge() > 0) {
                stmt.setInt(i++, parameter.getTicketCharge());
            }
            if (parameter.getNoteCharge() > 0) {
                stmt.setInt(i++, parameter.getNoteCharge());
            }
            if (parameter.getProvider() != null) {
                stmt.setString(i++, parameter.getProvider().getNameProvider());
            }
            if (parameter.getProduct() != null) {
                stmt.setString(i, parameter.getProduct().getNameProduct());
            }
        }
    }
}
