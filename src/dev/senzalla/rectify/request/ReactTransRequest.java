package dev.senzalla.rectify.request;

import dev.senzalla.rectify.entitys.LabTank;
import dev.senzalla.rectify.entitys.MakeTrans;
import dev.senzalla.rectify.entitys.ReactTrans;
import dev.senzalla.rectify.exception.DataBaseException;
import dev.senzalla.rectify.setting.ConectionMySql;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class ReactTransRequest extends ConectionMySql {


    public void insert(ReactTrans reactTrans) {
        connection();
        try {
            final String sql = "INSERT INTO `db_retifica`.`tbl_reacttrans` (`fkLabRctTrans`, `methylateRctTrans`, `pureRctTrans`, `dtRctTrans`, `hrStartRctTrans`, `hrFinalRctTrans`) VALUES (?, ?, ?, ?, ?, ?);";
            prepareStatement(sql);
            stmt.setLong(1, reactTrans.getLabTank().getIdTq());
            stmt.setInt(2, reactTrans.getMethylateReactTrans());
            stmt.setInt(3, reactTrans.getPureReactTrans());
            stmt.setDate(4, reactTrans.getDateReactTrans());
            stmt.setTime(5, reactTrans.getHourStartReactTrans());
            stmt.setTime(6, reactTrans.getHourFinalReactTrans());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            DataBaseException.processMsg("Reação Transesterificação" + ex.getMessage());
        } finally {
            closeConnection();
        }
    }

    public MakeTrans select(MakeTrans makeTrans) {
        try {
            connection();
            Set<ReactTrans> reactTranss = new HashSet<>();
            final String SELECT_QUERY = "SELECT * FROM db_retifica.view_reactTrans WHERE fkRctTrans = ?";
            prepareStatement(SELECT_QUERY);
            stmt.setLong(1, makeTrans.getIdTrans());
            resultSet();
            while (rs.next()) {
                ReactTrans reactTrans = new ReactTrans();
                reactTrans.setDateReactTrans(rs.getDate("dtRctTrans"));
                reactTrans.setMethylateReactTrans(rs.getInt("methylateRctTrans"));
                reactTrans.setPureReactTrans(rs.getInt("pureRctTrans"));
                reactTrans.setHourFinalReactTrans(rs.getTime("hrFinalRctTrans"));
                reactTrans.setHourStartReactTrans(rs.getTime("hrStartRctTrans"));

                LabTank labTank = new LabTank();
                labTank.setAcidTq(rs.getDouble("acidTq"));
                labTank.setSoapTq(rs.getDouble("soapTq"));
                labTank.setTrashTq(rs.getInt("trashTq"));
                reactTrans.setLabTank(labTank);


                reactTranss.add(reactTrans);
            }
            makeTrans.setReactTrans(reactTranss);
        } catch (SQLException ex) {
            DataBaseException.processMsg("Reação Transesterificação" + ex.getMessage());
        } finally {
            closeConnectionRs();
        }
        return makeTrans;
    }

}
