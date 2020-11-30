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
public class RequestCharge extends Request<Charge> {

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
            stmt.setLong(8, charge.getLabCar().getIdCar());
            stmt.setLong(9, charge.getDriver().getIdDriver());
            stmt.setString(10, charge.getBoardCharge());
            stmt.setDate(11, charge.getDtOfCharge());
            stmt.setDate(12, charge.getDtUpCharge());
            stmt.setTime(13, charge.getHrOfCharge());
            stmt.setTime(14, charge.getHrUpCharge());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            new DataBaseException().processMsg(ex.getMessage());
        } finally {
            closeConnection();
        }
    }

    @Override
    public List<Charge> select() {
        selectAll(SELECT_QUERY, null);
        return charges;
    }

    public Charge select(Charge cod) {
        selectAll(SELECT_QUERY + " WHERE idCharge = ?", cod);
        return charges.get(0);
    }

    @Override
    public List<Charge> select(List<String> query, Charge parameter) {
        query.forEach(s -> where += String.format(" %s ? AND", s));
        SELECT_QUERY += " WHERE " + where.substring(0, where.length() - 3);
        selectAll(SELECT_QUERY, parameter);
        return charges;
    }

    private void selectAll(String query, Charge parameter) {
        connection();
        charges = new ArrayList<>();
        try {
            prepareStatement(query);
            if (parameter != null) {
                int i = 1;
                if (parameter.getIdCharge() != null) {
                    stmt.setLong(i, parameter.getIdCharge());
                }

                if (parameter.getDtOfCharge() != null) {
                    stmt.setDate(i++, parameter.getDtOfCharge());
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
            System.out.println(stmt);
            resultSet();
            while (rs.next()) {
                Charge charge = new Charge();
                charge.setIdCharge(rs.getLong("idCharge"));
                charge.setTicketCharge(rs.getInt("ticketCharge"));
                charge.setLiterCharge(rs.getInt("literCharge"));
                charge.setDtOfCharge(rs.getDate("dtOfCharge"));

                charge.setNoteCharge(rs.getInt("noteCharge"));
                charge.setBoardCharge(rs.getString("boardCharge"));
                charge.setBurdenCharge(rs.getInt("burdenCharge"));
                charge.setDtUpCharge(rs.getDate("dtUpCharge"));
                charge.setHrOfCharge(rs.getTime("hrOfCharge"));
                charge.setHrUpCharge(rs.getTime("hrUpCharge"));

                charge.setProvider(new Provider(rs.getString("nameProvider")));
                charge.setProduct(new Product(rs.getString("nameProduct")));
                charge.setTank(new Tank(rs.getString("nameTank")));

                Driver driver = new Driver();
                driver.setNameDriver(rs.getString("nameDriver"));
                driver.setCnhDriver(rs.getString("cnhDriver"));
                charge.setDriver(driver);

                LabCar labCar = new LabCar();
                labCar.setAcidCar(rs.getDouble("acidCar"));
                labCar.setDensityCar(rs.getDouble("densityCar"));
                labCar.setSoapCar(rs.getDouble("soapCar"));
                labCar.setTrashCar(rs.getInt("trashCar"));
                charge.setLabCar(labCar);

                charges.add(charge);
            }
        } catch (SQLException ex) {
            new DataBaseException().processMsg(ex.getMessage());
        } finally {
            closeConnectionRs();
        }
    }
}
