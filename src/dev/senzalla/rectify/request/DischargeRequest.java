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
public class DischargeRequest extends ConectionMySql {

    public void insert(Discharge dcharge) {
        try {
            super.connection();
            final String sql = "INSERT INTO `tbl_discharge` (`noteDcharge`, `ticketDcharge`, `burdenDcharge`, `literDcharge`, `fkTankDcharge`, `fkProviderDcharge`, `fkProductDcharge`, `fkLabDcharge`, `fkDriverDcharge`, `boardDcharge`, `dtOfDcharge`, `dtUpDcharge`, `hrOfDcharge`, `hrUpDcharge`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            super.prepareStatement(sql);
            stmt.setInt(1, dcharge.getNoteDcharge());
            stmt.setInt(2, dcharge.getTicketDcharge());
            stmt.setInt(3, dcharge.getBurdenDcharge());
            stmt.setInt(4, dcharge.getLiterDcharge());
            stmt.setLong(5, dcharge.getTank().getIdTank());
            stmt.setLong(6, dcharge.getProvider().getIdProvider());
            stmt.setLong(7, dcharge.getProduct().getIdProduct());
            stmt.setLong(8, dcharge.getAnalyzeTruck().getIdAnalyzeTruck());
            stmt.setLong(9, dcharge.getDriver().getIdDriver());
            stmt.setString(10, dcharge.getCarPlateDcharge());
            stmt.setDate(11, dcharge.getDateEntryDcharge());
            stmt.setDate(12, dcharge.getDateExitDcharge());
            stmt.setTime(13, dcharge.getTimeEntryDcharge());
            stmt.setTime(14, dcharge.getTimeExitDcharge());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            DataBaseException.MsgErrorDataBase("Discharge: " + ex.getMessage());
        } finally {
            super.closeConnection();
        }
    }

    public Discharge select(Discharge parameter) {
        return selectAll("SELECT * FROM view_dcharge WHERE idDcharge = ?", parameter).get(0);
    }


    public List<Discharge> select(List<String> query, Discharge parameter) {
        final String SELECT_QUERY = QueryTreatment.createQuery("view_dcharge", query);
        return selectAll(SELECT_QUERY, parameter);
    }

    private List<Discharge> selectAll(String SELECT_QUERY, Discharge parameter) {
        List<Discharge> dcharges = new ArrayList<>();
        try {
            super.connection();
            super.prepareStatement(SELECT_QUERY);
            this.prepareStatement(parameter);
            super.resultSet();
            while (rs.next()) {
                Discharge dcharge = new Discharge();
                dcharge.setIdDcharge(rs.getLong("idDcharge"));
                dcharge.setTicketDcharge(rs.getInt("ticketDcharge"));
                dcharge.setLiterDcharge(rs.getInt("literDcharge"));
                dcharge.setDateEntryDcharge(rs.getDate("dateEntryDcharge"));
                dcharge.setNoteDcharge(rs.getInt("noteDcharge"));
                dcharge.setCarPlateDcharge(rs.getString("carPlateDcharge"));
                dcharge.setBurdenDcharge(rs.getInt("burdenDcharge"));
                dcharge.setDateExitDcharge(rs.getDate("dateExitDcharge"));
                dcharge.setTimeEntryDcharge(rs.getTime("timeEntryDcharge"));
                dcharge.setTimeExitDcharge(rs.getTime("timeExitDcharge"));
                dcharge.setProvider(new Provider(rs.getString("nameProvider")));
                dcharge.setProduct(new Product(rs.getString("nameProduct")));
                dcharge.setTank(new Tank(rs.getString("nameTank")));

                Driver driver = new Driver();
                driver.setNameDriver(rs.getString("nameDriver"));
                driver.setCnhDriver(rs.getString("cnhDriver"));
                dcharge.setDriver(driver);

                AnalyzeTruck analyzeTruck = new AnalyzeTruck();
                analyzeTruck.setAcidityTruck(rs.getDouble("acidityTruck"));
                analyzeTruck.setDensityTruck(rs.getDouble("densityProduct"));
                analyzeTruck.setSaponityTruck(rs.getDouble("saponityTruck"));
                analyzeTruck.setTrashTruck(rs.getInt("trashTruck"));
                dcharge.setAnalyzeTruck(analyzeTruck);

                dcharges.add(dcharge);
            }
        } catch (SQLException ex) {
            DataBaseException.MsgErrorDataBase("Discharge: " + ex.getMessage());
        } finally {
            super.closeConnectionRs();
        }
        return dcharges;
    }

    private void prepareStatement(Discharge parameter) throws SQLException {
        if (parameter != null) {
            int i = 1;
            if (parameter.getIdDcharge() != null) {
                stmt.setLong(i, parameter.getIdDcharge());
            }
            if (parameter.getDateEntryDcharge() != null) {
                stmt.setDate(i++, parameter.getDateEntryDcharge());
            }
            if (parameter.getDateBetween() != null) {
                stmt.setDate(i++, parameter.getDateBetween());
            }
            if (parameter.getTicketDcharge() > 0) {
                stmt.setInt(i++, parameter.getTicketDcharge());
            }
            if (parameter.getNoteDcharge() > 0) {
                stmt.setInt(i++, parameter.getNoteDcharge());
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
