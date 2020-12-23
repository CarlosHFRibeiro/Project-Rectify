package dev.senzalla.rectify.request;

import dev.senzalla.rectify.entitys.*;
import dev.senzalla.rectify.exception.DataBaseException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class ChargeRequest extends Request<Charge> {

    private List<Charge> charges;
    private String SELECT_QUERY = "SELECT * FROM db_retifica.view_charge";
    private String where = "";

    @Override
    public void insert(Charge charge) {
        connection();
        try {
            final String sql = "INSERT INTO `db_retifica`.`tbl_charge` (`noteCharge`, `ticketCharge`, `burdenCharge`, `literCharge`, `fkTankCharge`, `fkProviderCharge`, `fkProductCharge`, `fkLabCharge`, `fkDriverCharge`, `boardCharge`, `dtOfCharge`, `dtUpCharge`, `hrOfCharge`, `hrUpCharge`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            prepareStatement(sql);
            stmt.setInt(1, charge.getNoteCharge());
            stmt.setInt(2, charge.getTicketCharge());
            stmt.setInt(3, charge.getBurdenCharge());
            stmt.setInt(4, charge.getLiterCharge());
            stmt.setLong(5, charge.getTank().getIdTank());
            stmt.setLong(6, charge.getProvider().getIdProvider());
            stmt.setLong(7, charge.getProduct().getIdProduct());
            stmt.setLong(8, charge.getanalyzeTruck().getIdCar());
            stmt.setLong(9, charge.getDriver().getIdDriver());
            stmt.setString(10, charge.getCarPlateCharge());
            stmt.setDate(11, charge.getDateEntryCharge());
            stmt.setDate(12, charge.getDateExitCharge());
            stmt.setTime(13, charge.getTimeEntryCharge());
            stmt.setTime(14, charge.getTimeExitCharge());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            new DataBaseException().processMsg("Carregamento" + ex.getMessage());
        } finally {
            closeConnection();
        }
    }

    @Override
    public List<Charge> select() {
        return null;
    }

    public Charge select(Charge cod) {
        selectAll(SELECT_QUERY + " WHERE idCharge = ?", cod);
        return charges.get(0);
    }

    @Override
    public List<Charge> select(List<String> query, Charge charge) {
        if (charge != null) {
            query.forEach(s -> where += String.format(" %s ? AND", s));
            SELECT_QUERY += " WHERE " + where.substring(0, where.length() - 3);
        }
        selectAll(SELECT_QUERY, charge);
        return charges;
    }

    private void selectAll(String query, Charge parameter) {
        connection();
        charges = new ArrayList<>();
        try {
            prepareStatement(query);
            if (parameter != null) {
                prepareStatement(parameter);
            }
            resultSet();
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
                analyzeTruck.setAcidCar(rs.getDouble("acidCar"));
                analyzeTruck.setDensityCar(rs.getDouble("densityCar"));
                analyzeTruck.setSoapCar(rs.getDouble("soapCar"));
                analyzeTruck.setTrashCar(rs.getInt("trashCar"));
                charge.setanalyzeTruck(analyzeTruck);

                charges.add(charge);
            }
        } catch (SQLException ex) {
            new DataBaseException().processMsg("Carregamento" + ex.getMessage());
        } finally {
            closeConnectionRs();
        }
    }

    private void prepareStatement(Charge parameter) {
        try {
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
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
