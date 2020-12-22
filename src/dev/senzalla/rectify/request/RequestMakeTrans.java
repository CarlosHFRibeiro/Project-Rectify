package dev.senzalla.rectify.request;

import dev.senzalla.rectify.entitys.MakeTrans;
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
public class RequestMakeTrans extends Request<MakeTrans> {

    private List<MakeTrans> maketranss;
    private String SELECT_QUERY = "SELECT * FROM db_retifica.view_maketrans";
    private String where = "";

    @Override
    public void insert(MakeTrans makeTrans) {
        connection();
        try {
            final String sql = "INSERT INTO `db_retifica`.`tbl_maketrans` (`fkTankTrans`, `amountTrans`, `trashTrans`, `producedTrans`, `dtTrans`) VALUES (?, ?, ?, ?, ?);";
            prepareStatement(sql);
            stmt.setLong(1, makeTrans.getTank().getIdTank());
            stmt.setInt(2, makeTrans.getAmountTrans());
            stmt.setInt(3, makeTrans.getTrashTrans());
            stmt.setInt(4, makeTrans.getProducedTrans());
            stmt.setDate(5, makeTrans.getDtTrans());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            new DataBaseException().processMsg("Make Trans: " + ex.getMessage());
        } finally {
            closeConnection();
        }
    }


    public MakeTrans select(MakeTrans makeTrans) {
        String clause = SELECT_QUERY + " WHERE idTrans = ?";
        selectAll(clause, makeTrans);
        makeTrans = maketranss.get(0);
        makeTrans = new RequestMatterTrans().select(makeTrans);
        makeTrans = new RequestReactTrans().select(makeTrans);
        return makeTrans;
    }

    @Override
    public List<MakeTrans> select() {
        selectAll(SELECT_QUERY, null);
        return maketranss;
    }

    @Override
    public List<MakeTrans> select(List<String> clause, MakeTrans makeTrans) {
        clause.forEach(s -> where += String.format(" %s ? AND", s));
        SELECT_QUERY += " WHERE " + where.substring(0, where.length() - 3);
        selectAll(SELECT_QUERY, null);
        return maketranss;
    }

    private void selectAll(String select, MakeTrans clause) {
        connection();
        maketranss = new ArrayList<>();
        try {
            prepareStatement(select);
            int i = 1;
            if (clause != null) {
                if (clause.getIdTrans() != null) {
                    stmt.setLong(i++, clause.getIdTrans());
                }
                if (clause.getDtTrans() != null) {
                    stmt.setDate(i++, clause.getDtTrans());
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
                MakeTrans makeTrans = new MakeTrans();
                makeTrans.setIdTrans(rs.getLong("idTrans"));
                makeTrans.setAmountTrans(rs.getInt("amountTrans"));
                makeTrans.setTrashTrans(rs.getInt("trashTrans"));
                makeTrans.setProducedTrans(rs.getInt("producedTrans"));
                makeTrans.setDtTrans(rs.getDate("dtTrans"));
                makeTrans.setTank(new Tank(rs.getString("nameTank")));

                maketranss.add(makeTrans);
            }
        } catch (SQLException ex) {
            new DataBaseException().processMsg("Make Trans: " + ex.getMessage());
        } finally {
            closeConnectionRs();
        }
    }


}
