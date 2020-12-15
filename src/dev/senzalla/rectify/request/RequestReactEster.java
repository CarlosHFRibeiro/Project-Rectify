package dev.senzalla.rectify.request;

import dev.senzalla.rectify.entitys.LabTank;
import dev.senzalla.rectify.entitys.MakeEster;
import dev.senzalla.rectify.entitys.ReactEster;
import dev.senzalla.rectify.entitys.ReactEster;
import dev.senzalla.rectify.exception.DataBaseException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class RequestReactEster extends Request<ReactEster> {


    @Override
    public void insert(ReactEster reactEster) {
        connection();
        try {
            final String sql = "INSERT INTO `db_retifica`.`tbl_reactester` " +
                    "(`fkLabStartRctEster`, `sulfuricRctEster`, `pureRctEster`, `recoverRctEster`, " +
                    "`fkLabFinalRctEster`, `dtRctEster`, `hrStartRctEster`, `hrFinalRctEster`) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
            prepareStatement(sql);
            stmt.setLong(1, reactEster.getFkLabStartRctEster().getIdTq());
            stmt.setInt(2, reactEster.getSulfuricRctEster());
            stmt.setInt(3, reactEster.getPureRctEster());
            stmt.setInt(4, reactEster.getRecoverRctEster());
            stmt.setLong(5, reactEster.getFkLabFinalRctEster().getIdTq());
            stmt.setDate(6, reactEster.getDtRctEster());
            stmt.setTime(7, reactEster.getHrStartRctEster());
            stmt.setTime(8, reactEster.getHrFinalRctEster());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            new DataBaseException().processMsg(ex.getMessage());
        } finally {
            closeConnection();
        }
    }

    @Override
    public List<ReactEster> select() {
        return null;
    }

    @Override
    public List<ReactEster> select(List<String> clause, ReactEster reactEster) {
        return null;
    }

    public MakeEster select(MakeEster makeester) {
        try {
            connection();
            Set<ReactEster> reactEsters = new HashSet<>();
            final String SELECT_QUERY = "SELECT * FROM db_retifica.view_reactester WHERE fkRctEster = ?";
            prepareStatement(SELECT_QUERY);
            stmt.setLong(1, makeester.getIdEster());
            resultSet();
            while (rs.next()) {
                ReactEster reactEster = new ReactEster();
                reactEster.setDtRctEster(rs.getDate("dtRctEster"));
                reactEster.setSulfuricRctEster(rs.getInt("sulfuricRctEster"));
                reactEster.setRecoverRctEster(rs.getInt("recoverRctEster"));
                reactEster.setPureRctEster(rs.getInt("pureRctEster"));
                reactEster.setHrFinalRctEster(rs.getTime("hrFinalRctEster"));
                reactEster.setHrStartRctEster(rs.getTime("hrStartRctEster"));

                LabTank labTank=new LabTank();
                labTank.setAcidTq(rs.getDouble("acidInitial"));
                labTank.setSoapTq(rs.getDouble("soapInitial"));
                labTank.setTrashTq(rs.getInt("trashInitial"));
                reactEster.setFkLabStartRctEster(labTank);

                labTank=new LabTank();
                labTank.setAcidTq(rs.getDouble("acidFinal"));
                labTank.setSoapTq(rs.getDouble("soapFinal"));
                labTank.setTrashTq(rs.getInt("trashFinal"));
                reactEster.setFkLabFinalRctEster(labTank);

                reactEsters.add(reactEster);
            }
            makeester.setReactEsters(reactEsters);
        } catch (SQLException ex) {
            new DataBaseException().processMsg(ex.getMessage());
        } finally {
            closeConnectionRs();
        }
        return makeester;
    }

}
