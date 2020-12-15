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
public class RequestDcharge extends Request<Discharge> {

    private List<Discharge> dcharges;
    private String SELECT_QUERY = "SELECT * FROM db_retifica.view_dcharge";
    private String where = "";

    @Override
    public void insert(Discharge dcharge) {
        connection();
        try {
            final String sql = "INSERT INTO `db_retifica`.`tbl_discharge` (`noteDcharge`, `ticketDcharge`, `burdenDcharge`, `literDcharge`, `fkTankDcharge`, `fkProviderDcharge`, `fkProductDcharge`, `fkLabDcharge`, `fkDriverDcharge`, `boardDcharge`, `dtOfDcharge`, `dtUpDcharge`, `hrOfDcharge`, `hrUpDcharge`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            prepareStatement(sql);
            stmt.setInt(1, dcharge.getNoteDcharge());
            stmt.setInt(2, dcharge.getTicketDcharge());
            stmt.setInt(3, dcharge.getBurdenDcharge());
            stmt.setInt(4, dcharge.getLiterDcharge());
            stmt.setLong(5, dcharge.getTank().getIdTank());
            stmt.setLong(6, dcharge.getProvider().getIdProvider());
            stmt.setLong(7, dcharge.getProduct().getIdProduct());
            stmt.setLong(8, dcharge.getLabCar().getIdCar());
            stmt.setLong(9, dcharge.getDriver().getIdDriver());
            stmt.setString(10, dcharge.getBoardDcharge());
            stmt.setDate(11, dcharge.getDtOfDcharge());
            stmt.setDate(12, dcharge.getDtUpDcharge());
            stmt.setTime(13, dcharge.getHrOfDcharge());
            stmt.setTime(14, dcharge.getHrUpDcharge());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            new DataBaseException().processMsg(ex.getMessage());
        } finally {
            closeConnection();
        }
    }

    @Override
    public List<Discharge> select() {
        selectAll(SELECT_QUERY, null);
        return dcharges;
    }

    public Discharge select(Discharge cod) {
        selectAll(SELECT_QUERY + " WHERE idDcharge = ?", cod);
        return dcharges.get(0);
    }

    @Override
    public List<Discharge> select(List<String> query, Discharge parameter) {
        query.forEach(s -> where += String.format(" %s ? AND", s));
        SELECT_QUERY += " WHERE " + where.substring(0, where.length() - 3);
        selectAll(SELECT_QUERY, parameter);
        return dcharges;
    }

    private void selectAll(String query, Discharge parameter) {
        connection();
        dcharges = new ArrayList<>();
        try {
            prepareStatement(query);
            if (parameter != null) {
                int i = 1;
                if (parameter.getIdDcharge() != null) {
                    stmt.setLong(i, parameter.getIdDcharge());
                }

                if (parameter.getDtOfDcharge() != null) {
                    stmt.setDate(i++, parameter.getDtOfDcharge());
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
            resultSet();
            while (rs.next()) {
                Discharge dcharge = new Discharge();
                dcharge.setIdDcharge(rs.getLong("idDcharge"));
                dcharge.setTicketDcharge(rs.getInt("ticketDcharge"));
                dcharge.setLiterDcharge(rs.getInt("literDcharge"));
                dcharge.setDtOfDcharge(rs.getDate("dtOfDcharge"));

                dcharge.setNoteDcharge(rs.getInt("noteDcharge"));
                dcharge.setBoardDcharge(rs.getString("boardDcharge"));
                dcharge.setBurdenDcharge(rs.getInt("burdenDcharge"));
                dcharge.setDtUpDcharge(rs.getDate("dtUpDcharge"));
                dcharge.setHrOfDcharge(rs.getTime("hrOfDcharge"));
                dcharge.setHrUpDcharge(rs.getTime("hrUpDcharge"));

                dcharge.setProvider(new Provider(rs.getString("nameProvider")));
                dcharge.setProduct(new Product(rs.getString("nameProduct")));
                dcharge.setTank(new Tank(rs.getString("nameTank")));

                Driver driver = new Driver();
                driver.setNameDriver(rs.getString("nameDriver"));
                driver.setCnhDriver(rs.getString("cnhDriver"));
                dcharge.setDriver(driver);

                LabCar labCar = new LabCar();
                labCar.setAcidCar(rs.getDouble("acidCar"));
                labCar.setDensityCar(rs.getDouble("densityCar"));
                labCar.setSoapCar(rs.getDouble("soapCar"));
                labCar.setTrashCar(rs.getInt("trashCar"));
                dcharge.setLabCar(labCar);

                dcharges.add(dcharge);
            }
        } catch (SQLException ex) {
            new DataBaseException().processMsg(ex.getMessage());
        } finally {
            closeConnectionRs();
        }
    }
}
