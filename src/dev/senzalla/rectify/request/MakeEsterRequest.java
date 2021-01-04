package dev.senzalla.rectify.request;

import dev.senzalla.rectify.entitys.MakeEster;
import dev.senzalla.rectify.entitys.Tank;
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
public class MakeEsterRequest extends ConectionMySql {

    public void insert(MakeEster makeester) {
        super.connection();
        try {
            final String sql = "INSERT INTO `tbl_make_ester` (`fkTank`, `amountMatterMakeEster`, `trashMakeEster`, `producedMakeEster`, `dateMakeEster`) VALUES (?, ?, ?, ?, ?);";
            super.prepareStatement(sql);
            stmt.setLong(1, makeester.getTank().getIdTank());
            stmt.setInt(2, makeester.getAmountMatterMakeEster());
            stmt.setInt(3, makeester.getTrashMakeEster());
            stmt.setInt(4, makeester.getProducedMakeEster());
            stmt.setDate(5, makeester.getDateMakeEster());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            DataBaseException.MsgErrorDataBase("Make Ester: " + ex.getMessage());
        } finally {
            super.closeConnection();
        }
    }

    public MakeEster select(MakeEster makeester) {
        makeester = new MatterEsterRequest().select(makeester);
        makeester = new ReactionMakeEsterRequest().select(makeester);
        return makeester;
    }

    public List<MakeEster> select(List<String> clause, MakeEster parameter) {
        List<MakeEster> makeesters = new ArrayList<>();
        try {
            String SELECT_QUERY = QueryTreatment.createQuery("view_make_ester", clause);
            super.connection();
            super.prepareStatement(SELECT_QUERY);
            this.prepareStatement(parameter);
            super.resultSet();
            while (rs.next()) {
                MakeEster makeester = new MakeEster();
                makeester.setIdMakeEster(rs.getLong("idMakeEster"));
                makeester.setAmountMatterMakeEster(rs.getInt("amountMatterMakeEster"));
                makeester.setProducedMakeEster(rs.getInt("producedMakeEster"));
                makeester.setDateMakeEster(rs.getDate("dateMakeEster"));
                makeester.setTrashMakeEster(rs.getInt("trashMakeEster"));
                makeester.setTank(new Tank(rs.getString("nameTank")));
                makeesters.add(makeester);
            }
        } catch (SQLException ex) {
            DataBaseException.MsgErrorDataBase("Make Ester: " + ex.getMessage());
        } finally {
            super.closeConnectionRs();
        }
        return makeesters;
    }

    private void prepareStatement(MakeEster parameter) throws SQLException {
        if (parameter != null) {
            int i = 1;
            if (parameter.getIdMakeEster() != null) {
                stmt.setLong(i++, parameter.getIdMakeEster());
            }
            if (parameter.getDateMakeEster() != null) {
                stmt.setDate(i++, parameter.getDateMakeEster());
            }
            if (parameter.getDateBetween() != null) {
                stmt.setDate(i++, parameter.getDateBetween());
            }
            if (parameter.getTank() != null) {
                stmt.setString(i, parameter.getTank().getNameTank());
            }
        }
    }
}
