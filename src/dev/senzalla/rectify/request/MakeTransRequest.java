package dev.senzalla.rectify.request;

import dev.senzalla.rectify.entitys.MakeTrans;
import dev.senzalla.rectify.entitys.ReactTrans;
import dev.senzalla.rectify.entitys.Tank;
import dev.senzalla.rectify.exception.ElementDuplicate;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class MakeTransRequest extends Request<MakeTrans> {

    private List<MakeTrans> maketrans;
    private String SELECT_QUERY = "SELECT * FROM db_retifica.view_maketrans";
    private String where = "";

    @Override
    public void insert(MakeTrans makeester) {
        connection();
        try {
            final String sql = "INSERT INTO `db_retifica`.`tbl_makeester` (`reactTrans`, `fkTankTrans`, `amountTrans`, `foreseenTrans`, `trashTrans`, `producedTrans`) VALUES (?, ?, ?, ?, ?, ?);";
            prepareStatement(sql);
            stmt.setInt(1, makeester.getReactTrans());
            stmt.setLong(2, makeester.getTank().getIdTank());
            stmt.setInt(3, makeester.getAmountTrans());
            stmt.setInt(4, makeester.getForeseenTrans());
            stmt.setInt(5, makeester.getProducedTrans());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            new ElementDuplicate().processMsg(ex.getMessage(), null);
        } finally {
            closeConnection();
        }
    }

    @Override
    public List<MakeTrans> select() {
        selectAll(SELECT_QUERY, null);
        return maketrans;
    }

    @Override
    public List<MakeTrans> select(MakeTrans makeester) {
        String clause = SELECT_QUERY + " WHERE UPPER(nameMakeTrans) LIKE UPPER(?);";
        selectAll(clause, makeester);
        return maketrans;
    }


    @Override
    public List<MakeTrans> select(List<String> clause, MakeTrans makeTrans) {
        clause.forEach(s -> where += String.format(" %s ? AND", s));

        SELECT_QUERY += " WHERE " + where.substring(0, where.length() - 3);
        selectAll(SELECT_QUERY, null);
        return maketrans;
    }

    private void selectAll(String select, MakeTrans clause) {
        connection();
        if (maketrans == null) {
            maketrans = new ArrayList<>();
        }
        try {
            prepareStatement(select);
            if (clause != null) {
                stmt.setLong(1, clause.getIdTrans());
                stmt.setDate(2, clause.getReactTranss().getDtRctTrans());
                stmt.setDate(3, clause.getReactTranss().getDateBetween());
                stmt.setString(4, clause.getMatterTrans().getProduct().getNameProduct());
            }
            resultSet();
            while (rs.next()) {
                MakeTrans makeester = new MakeTrans();
                makeester.setIdTrans(rs.getLong("idTrans"));
                makeester.setReactTrans(rs.getInt("reactTrans"));
                makeester.setProducedTrans(rs.getInt("producedTrans"));
                makeester.setReactTrans(rs.getInt("reactTrans"));
                makeester.setTrashTrans(rs.getInt("trashTrans"));

                Tank tank = new Tank();
                tank.setNameTank(rs.getString("nameTank"));
                makeester.setTank(tank);

                ReactTrans reactTrans = new ReactTrans();
                reactTrans.setDtRctTrans(rs.getDate("dtRctTrans"));
                makeester.setReactTranss(reactTrans);

                maketrans.add(makeester);
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        } finally {
            closeConnectionRs();
        }
    }
}
