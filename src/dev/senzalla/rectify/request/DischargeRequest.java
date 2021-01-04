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
            final String sql = "INSERT INTO `tbl_discharge` (`note`, `ticket`, `burden`, `liter`, `fkTank`, `fkProvider`, `fkProduct`, `fkLab`, `fkDriver`, `board`, `dtOf`, `dtUp`, `hrOf`, `hrUp`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            super.prepareStatement(sql);
            stmt.setInt(1, dcharge.getNote());
            stmt.setInt(2, dcharge.getTicket());
            stmt.setInt(3, dcharge.getBurden());
            stmt.setInt(4, dcharge.getLiter());
            stmt.setLong(5, dcharge.getTank().getIdTank());
            stmt.setLong(6, dcharge.getProvider().getIdProvider());
            stmt.setLong(7, dcharge.getProduct().getIdProduct());
            stmt.setLong(8, dcharge.getAnalyzeTruck().getIdAnalyzeTruck());
            stmt.setLong(9, dcharge.getDriver().getIdDriver());
            stmt.setString(10, dcharge.getCarPlate());
            stmt.setDate(11, dcharge.getDateEntry());
            stmt.setDate(12, dcharge.getDateExit());
            stmt.setTime(13, dcharge.getTimeEntry());
            stmt.setTime(14, dcharge.getTimeExit());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            DataBaseException.MsgErrorDataBase("Discharge: " + ex.getMessage());
        } finally {
            super.closeConnection();
        }
    }

    public Discharge select(Discharge parameter) {
        return selectAll("SELECT * FROM view_dcharge WHERE id = ?", parameter).get(0);
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
                dcharge.setId(rs.getLong("id"));
                dcharge.setTicket(rs.getInt("ticket"));
                dcharge.setLiter(rs.getInt("liter"));
                dcharge.setDateEntry(rs.getDate("dateEntry"));
                dcharge.setNote(rs.getInt("note"));
                dcharge.setCarPlate(rs.getString("carPlate"));
                dcharge.setBurden(rs.getInt("burden"));
                dcharge.setDateExit(rs.getDate("dateExit"));
                dcharge.setTimeEntry(rs.getTime("timeEntry"));
                dcharge.setTimeExit(rs.getTime("timeExit"));
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
            if (parameter.getId() != null) {
                stmt.setLong(i, parameter.getId());
            }
            if (parameter.getDateEntry() != null) {
                stmt.setDate(i++, parameter.getDateEntry());
            }
            if (parameter.getDateBetween() != null) {
                stmt.setDate(i++, parameter.getDateBetween());
            }
            if (parameter.getTicket() > 0) {
                stmt.setInt(i++, parameter.getTicket());
            }
            if (parameter.getNote() > 0) {
                stmt.setInt(i++, parameter.getNote());
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
