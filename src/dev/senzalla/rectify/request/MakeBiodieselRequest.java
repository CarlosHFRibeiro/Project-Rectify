package dev.senzalla.rectify.request;

import dev.senzalla.rectify.entitys.MakeBiodiesel;
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
public class MakeBiodieselRequest extends ConectionMySql {

    public void insert(MakeBiodiesel makeBiodiesel) {
        try {
            super.connection();
            final String sql = "INSERT INTO `tbl_make_biodiesel` (`fkTank`, `amountMatterMakeBiodiesel`, `trashMakeBiodiesel`, `producedMakeBiodiesel`, `dateMakeBiodiesel`) VALUES (?, ?, ?, ?, ?);";
            super.prepareStatement(sql);
            stmt.setLong(1, makeBiodiesel.getTank().getIdTank());
            stmt.setInt(2, makeBiodiesel.getAmountMatterMakeBiodiesel());
            stmt.setInt(3, makeBiodiesel.getTrashMakeBiodiesel());
            stmt.setInt(4, makeBiodiesel.getProducedMakeBiodiesel());
            stmt.setDate(5, makeBiodiesel.getDateMakeBiodiesel());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            DataBaseException.MsgErrorDataBase("Make Trans: " + ex.getMessage());
        } finally {
            super.closeConnection();
        }
    }

    public MakeBiodiesel select(MakeBiodiesel makeBiodiesel) {
        makeBiodiesel = new MatterTransRequest().select(makeBiodiesel);
        makeBiodiesel = new ReactionMakeBiodieselRequest().select(makeBiodiesel);
        return makeBiodiesel;
    }

    public List<MakeBiodiesel> select(List<String> clause, MakeBiodiesel parameter) {
        List<MakeBiodiesel> makeBiodieselList = new ArrayList<>();
        try {
            String SELECT_QUERY = QueryTreatment.createQuery("view_make_biodiesel", clause);
            super.connection();
            super.prepareStatement(SELECT_QUERY);
            this.prepareStatement(parameter);
            super.resultSet();
            while (rs.next()) {
                MakeBiodiesel makeBiodiesel = new MakeBiodiesel();
                makeBiodiesel.setIdMakeBiodiesel(rs.getLong("idMakeBiodiesel"));
                makeBiodiesel.setAmountMatterMakeBiodiesel(rs.getInt("amountMatterMakeBiodiesel"));
                makeBiodiesel.setTrashMakeBiodiesel(rs.getInt("trashMakeBiodiesel"));
                makeBiodiesel.setProducedMakeBiodiesel(rs.getInt("producedMakeBiodiesel"));
                makeBiodiesel.setDateMakeBiodiesel(rs.getDate("dateMakeBiodiesel"));
                makeBiodiesel.setTank(new Tank(rs.getString("nameTank")));
                makeBiodieselList.add(makeBiodiesel);
            }
        } catch (SQLException ex) {
            DataBaseException.MsgErrorDataBase("Make Trans: " + ex.getMessage());
        } finally {
            super.closeConnectionRs();
        }
        return makeBiodieselList;
    }

    private void prepareStatement(MakeBiodiesel parameter) throws SQLException {
        if (parameter != null) {
            int i = 1;
            if (parameter.getIdMakeBiodiesel() != null) {
                stmt.setLong(i++, parameter.getIdMakeBiodiesel());
            }
            if (parameter.getDateMakeBiodiesel() != null) {
                stmt.setDate(i++, parameter.getDateMakeBiodiesel());
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
