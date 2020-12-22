package dev.senzalla.rectify.request;

import dev.senzalla.rectify.entitys.LabTank;
import dev.senzalla.rectify.entitys.MakeTrans;
import dev.senzalla.rectify.entitys.ReactTrans;
import dev.senzalla.rectify.exception.DataBaseException;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class RequestReactTrans extends Request<ReactTrans> {


    @Override
    public void insert(ReactTrans reactTrans) {
        connection();
        try {
            final String sql = "INSERT INTO `db_retifica`.`tbl_reacttrans` (`fkLabRctTrans`, `methylateRctTrans`, `pureRctTrans`, `dtRctTrans`, `hrStartRctTrans`, `hrFinalRctTrans`) VALUES (?, ?, ?, ?, ?, ?);";
            prepareStatement(sql);
            stmt.setLong(1, reactTrans.getLabTank().getIdTq());
            stmt.setInt(2, reactTrans.getMethylateRctTrans());
            stmt.setInt(3, reactTrans.getPureRctTrans());
            stmt.setDate(4, reactTrans.getDtRctTrans());
            stmt.setTime(5, reactTrans.getHrStartRctTrans());
            stmt.setTime(6, reactTrans.getHrFinalRctTrans());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            new DataBaseException().processMsg(ex.getMessage()+ " react trans");
        } finally {
            closeConnection();
        }
    }

    @Override
    public List<ReactTrans> select() {
        return null;
    }

    @Override
    public List<ReactTrans> select(List<String> clause, ReactTrans reactTrans) {
        return null;
    }

    public MakeTrans select(MakeTrans makeTrans) {
        try {
            connection();
            Set<ReactTrans> reactTranss = new HashSet<>();
            final String SELECT_QUERY = "SELECT * FROM db_retifica.view_reactester WHERE fkRctTrans = ?";
            prepareStatement(SELECT_QUERY);
            stmt.setLong(1, makeTrans.getIdTrans());
            resultSet();
            while (rs.next()) {
                ReactTrans reactTrans = new ReactTrans();
                reactTrans.setDtRctTrans(rs.getDate("dtRctTrans"));
                reactTrans.setMethylateRctTrans(rs.getInt("methylateRctTrans"));
                reactTrans.setPureRctTrans(rs.getInt("pureRctTrans"));
                reactTrans.setHrFinalRctTrans(rs.getTime("hrFinalRctTrans"));
                reactTrans.setHrStartRctTrans(rs.getTime("hrStartRctTrans"));

                LabTank labTank = new LabTank();
                labTank.setAcidTq(rs.getDouble("acidInitial"));
                labTank.setSoapTq(rs.getDouble("soapInitial"));
                labTank.setTrashTq(rs.getInt("trashInitial"));
                reactTrans.setLabTank(labTank);


                reactTranss.add(reactTrans);
            }
            makeTrans.setReactTranss(reactTranss);
        } catch (SQLException ex) {
            new DataBaseException().processMsg(ex.getMessage());
        } finally {
            closeConnectionRs();
        }
        return makeTrans;
    }

}
