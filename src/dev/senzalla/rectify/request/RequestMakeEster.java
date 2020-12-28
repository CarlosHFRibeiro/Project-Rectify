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
public class RequestMakeEster extends Request<MakeEster> {

    private List<MakeEster> makeesters;
    private String SELECT_QUERY = "SELECT * FROM db_retifica.view_makeester";
    private String where = "";

    @Override
    public void insert(MakeEster makeester) {
        connection();
        try {
            final String sql = "INSERT INTO `db_retifica`.`tbl_makeester` (`fkTankEster`, `amountEster`, `foreseenEster`, `trashEster`, `producedEster`, `dtEster`) VALUES (?, ?, ?, ?, ?, ?);";
            prepareStatement(sql);
            stmt.setLong(1, makeester.getTank().getIdTank());
            stmt.setInt(2, makeester.getAmountEster());
            stmt.setInt(3, makeester.getTrashEster());
            stmt.setInt(4, makeester.getProducedEster());
            stmt.setDate(5, makeester.getDtEster());
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

    public MakeEster select(MakeEster makeester) {
        String clause = SELECT_QUERY + " WHERE idEster = ?";
        selectAll(clause, makeester);
        makeester = makeesters.get(0);
        makeester = new RequestMatterEster().select(makeester);
        makeester = new RequestReactEster().select(makeester);
        return makeester;
    }

    @Override
    public List<MakeEster> select(List<String> clause, MakeEster makeEster) {
        clause.forEach(s -> where += String.format(" %s ? AND", s));

        SELECT_QUERY += " WHERE " + where.substring(0, where.length() - 3);
        selectAll(SELECT_QUERY, makeEster);
        return makeesters;
    }

    private void selectAll(String select, MakeEster clause) {
        connection();
        makeesters = new ArrayList<>();
        try {
            prepareStatement(select);
            int i = 1;
            if (clause != null) {
                if (clause.getIdEster() != null) {
                    stmt.setLong(i++, clause.getIdEster());
                }
                if (clause.getDtEster() != null) {
                    stmt.setDate(i++, clause.getDtEster());
                }
                if (clause.getDateBetween() != null) {
                    stmt.setDate(i++, clause.getDateBetween());
                }
                if (clause.getTank() != null) {
                    stmt.setString(i, clause.getTank().getNameTank());
                }
            }
            resultSet();
            while (rs.next()) {
                MakeEster makeester = new MakeEster();
                makeester.setIdEster(rs.getLong("idEster"));
                makeester.setAmountEster(rs.getInt("amountEster"));
                makeester.setProducedEster(rs.getInt("producedEster"));
                makeester.setDtEster(rs.getDate("dtEster"));
                makeester.setTrashEster(rs.getInt("trashEster"));
                makeester.setTank(new Tank(rs.getString("nameTank")));
                makeesters.add(makeester);
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        } finally {
            closeConnectionRs();
        }
    }
}
