package dev.senzalla.rectify.request;

import dev.senzalla.rectify.entitys.MakeEster;
import dev.senzalla.rectify.entitys.Tank;
import dev.senzalla.rectify.exception.DataBaseException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class MakeEsterRequest extends Request<MakeEster> {

    private List<MakeEster> makeesters;
    private String SELECT_QUERY = "SELECT * FROM db_retifica.tbl_makeester";
    private String where = "";

    @Override
    public void insert(MakeEster makeester) {
        connection();
        try {
            final String sql = "INSERT INTO `db_retifica`.`tbl_makeester` (`reactEster`, `fkTankEster`, `amountEster`, `foreseenEster`, `trashEster`, `producedEster`) VALUES (?, ?, ?, ?, ?, ?);";
            prepareStatement(sql);
            stmt.setInt(1, makeester.getReactEster());
            stmt.setLong(2, makeester.getTank().getIdTank());
            stmt.setInt(3, makeester.getAmountEster());
            stmt.setInt(4, makeester.getForeseenEster());
            stmt.setInt(5, makeester.getProducedEster());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            new DataBaseException().processMsg(ex.getMessage());
        } finally {
            closeConnection();
        }
    }

    @Override
    public List<MakeEster> select() {
        selectAll(SELECT_QUERY, null);
        return makeesters;
    }

    @Override
    public List<MakeEster> select(MakeEster makeester) {
        String clause = SELECT_QUERY + " WHERE UPPER(nameMakeEster) LIKE UPPER(?);";
        selectAll(clause, makeester);
        return makeesters;
    }


    @Override
    public List<MakeEster> select(List<String> clause, MakeEster makeEster) {
        clause.forEach(s -> where += String.format(" %s ? AND", s));

        SELECT_QUERY += " WHERE " + where.substring(0, where.length() - 3);
        selectAll(SELECT_QUERY, null);
        return makeesters;
    }

    private void selectAll(String select, MakeEster clause) {
        connection();
        if (makeesters == null) {
            makeesters = new ArrayList<>();
        }
        try {
            prepareStatement(select);
            if (clause != null) {
                stmt.setLong(1, clause.getIdEster());
                stmt.setDate(2, clause.getReactEsters().getDtRctEster());
                stmt.setDate(3, clause.getReactEsters().getDateBetween());
                stmt.setString(4,clause.getMatterEster().getProduct().getNameProduct());
            }
            resultSet();
            while (rs.next()) {
                MakeEster makeester = new MakeEster();
                makeester.setIdEster(rs.getLong("idMakeEster"));
                makeester.setAmountEster(rs.getInt("amountTrans"));
                makeester.setProducedEster(rs.getInt("producedTrans"));
                makeester.setReactEster(rs.getInt("reactTrans"));
                makeester.setTrashEster(rs.getInt("trashTrans"));

                Tank tank = new Tank();
                tank.setNameTank(rs.getString("nameTank"));
                makeester.setTank(tank);
                makeesters.add(makeester);
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        } finally {
            closeConnectionRs();
        }
    }
}
