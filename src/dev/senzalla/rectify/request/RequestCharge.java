package dev.senzalla.rectify.request;

import dev.senzalla.rectify.entitys.Charge;
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
    private String SELECT_QUERY = "SELECT * FROM db_retifica.view_stkproduct";
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
        final String DATE = "dtStkPd = CURDATE()";
        selectAll(SELECT_QUERY + " WHERE " + DATE, null);
        return charges;
    }

    @Override
    public List<Charge> select(Charge charge) {
        throw new UnsupportedOperationException("Not supported yet.");
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
//            if (parameter != null) {
//                int i = 1;
//                if (parameter.getProduct() != null) {
//                    stmt.setString(i++, parameter.getProduct().getNameProduct());
//                }
//                if (parameter.getDtStkPd() != null) {
//                    stmt.setDate(i++, parameter.getDtStkPd());
//                }
//                if (parameter.getDateBetween() != null) {
//                    stmt.setDate(i, parameter.getDateBetween());
//                }
//            }
//            System.out.println(stmt);
//            resultSet();
//            while (rs.next()) {
//                Charge charge = new Charge();
//                charge.setLiterStkPd(rs.getInt("literStkPd"));
//                charge.setPercentStkPd(rs.getInt("percentStkPd"));
//                charge.setDtStkPd(rs.getDate("dtStkPd"));
//
//                Product tank = new Product();
//                tank.setNameProduct(rs.getString("nameProduct"));
//                charge.setProduct(tank);
//
//                charges.add(charge);
//            }
        } catch (SQLException ex) {
            new DataBaseException().processMsg(ex.getMessage());
        } finally {
            closeConnectionRs();
        }
    }
}
