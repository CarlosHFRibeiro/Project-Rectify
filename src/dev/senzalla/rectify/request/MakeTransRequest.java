package dev.senzalla.rectify.request;

import dev.senzalla.rectify.entitys.MakeTrans;
import dev.senzalla.rectify.entitys.Tank;
import dev.senzalla.rectify.exception.DataBaseException;
import dev.senzalla.rectify.setting.ConectionMySql;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class MakeTransRequest extends ConectionMySql {

    private List<MakeTrans> makeTransList;
    private String SELECT_QUERY = "SELECT * FROM db_retifica.view_maketrans";
    private String where = "";

    public void insert(MakeTrans makeTrans) {
        connection();
        try {
            final String sql = "INSERT INTO `db_retifica`.`tbl_maketrans` (`fkTankTrans`, `amountTrans`, `trashTrans`, `producedTrans`, `dtTrans`) VALUES (?, ?, ?, ?, ?);";
            prepareStatement(sql);
            stmt.setLong(1, makeTrans.getTank().getIdTank());
            stmt.setInt(2, makeTrans.getAmountTrans());
            stmt.setInt(3, makeTrans.getTrashTrans());
            stmt.setInt(4, makeTrans.getProducedTrans());
            stmt.setDate(5, makeTrans.getMakeDateTrans());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            DataBaseException.processMsg("Make Trans: " + ex.getMessage());
        } finally {
            closeConnection();
        }
    }


    public MakeTrans select(MakeTrans makeTrans) {
        String clause = SELECT_QUERY + " WHERE idTrans = ?";
        selectAll(clause, makeTrans);
        makeTrans = makeTransList.get(0);
        makeTrans = new MatterTransRequest().select(makeTrans);
        makeTrans = new ReactTransRequest().select(makeTrans);
        return makeTrans;
    }

    public List<MakeTrans> select(List<String> clause, MakeTrans makeTrans) {
        if (makeTrans != null) {
            clause.forEach(s -> where += String.format(" %s ? AND", s));
            SELECT_QUERY += " WHERE " + where.substring(0, where.length() - 3);
        }
        selectAll(SELECT_QUERY, makeTrans);
        return makeTransList;
    }

    private void selectAll(String select, MakeTrans parameter) {
        connection();
        makeTransList = new ArrayList<>();
        try {
            prepareStatement(select);

            if (parameter != null) {
                prepareStatement(parameter);
            }
            resultSet();
            while (rs.next()) {
                MakeTrans makeTrans = new MakeTrans();
                makeTrans.setIdTrans(rs.getLong("idTrans"));
                makeTrans.setAmountTrans(rs.getInt("amountTrans"));
                makeTrans.setTrashTrans(rs.getInt("trashTrans"));
                makeTrans.setProducedTrans(rs.getInt("producedTrans"));
                makeTrans.setMakeDateTrans(rs.getDate("dtTrans"));
                makeTrans.setTank(new Tank(rs.getString("nameTank")));

                makeTransList.add(makeTrans);
            }
        } catch (SQLException ex) {
            DataBaseException.processMsg("Make Trans: " + ex.getMessage());
        } finally {
            closeConnectionRs();
        }
    }

    private void prepareStatement(MakeTrans parameter) {
        try {
            int i = 1;
            if (parameter.getIdTrans() != null) {
                stmt.setLong(i++, parameter.getIdTrans());
            }
            if (parameter.getMakeDateTrans() != null) {
                stmt.setDate(i++, parameter.getMakeDateTrans());
            }
            if (parameter.getDateBetween() != null) {
                stmt.setDate(i++, parameter.getDateBetween());
            }
            if (parameter.getTank() != null) {
                stmt.setString(i, parameter.getTank().getNameTank());
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
