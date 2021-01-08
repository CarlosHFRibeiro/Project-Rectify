package dev.senzalla.rectify.request;

import dev.senzalla.rectify.entitys.Provider;
import dev.senzalla.rectify.entitys.Sample;
import dev.senzalla.rectify.exception.DataBaseException;
import dev.senzalla.rectify.setting.ConectionMySql;
import dev.senzalla.rectify.treatments.QueryTreatment;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Black Burn Cybernetic
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class SampleRequest extends ConectionMySql {

    public void insert(Sample sample) {
        try {
            super.connection();
            final String sql = "INSERT INTO `tbl_sample` (`auctionNumber`, `clientSample`, `factorySample`, `petrobrasSample`, `fkProvider`) VALUES (?, ?, ?, ?, ?);";
            super.prepareStatement(sql);
            stmt.setInt(1, sample.getAuctionNumber());
            stmt.setInt(2, sample.getClientSample());
            stmt.setInt(3, sample.getFactorySample());
            stmt.setInt(4, sample.getPetrobrasSample());
            stmt.setLong(5, sample.getProvider().getIdProvider());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            DataBaseException.MsgErrorDataBase("Sample" + ex.getMessage(), "Uma dessas etiquetas");
        } finally {
            super.closeConnection();
        }
    }

    public List<Sample> select(List<String> clause, Sample parameter) {
        List<Sample> samples = new ArrayList<>();
        try {
            super.connection();
            String selectQuery = QueryTreatment.createQuery("view_sample", clause);
            super.prepareStatement(selectQuery);
            this.prepareStatement(parameter);
            super.resultSet();
            System.out.println(stmt);
            while (rs.next()) {
                Sample sample = new Sample();
                sample.setAuctionNumber(rs.getInt("auctionNumber"));
                sample.setClientSample(rs.getInt("clientSample"));
                sample.setDateSampleCollection(rs.getDate("dateSampleCollection"));
                sample.setFactorySample(rs.getInt("factorySample"));
                sample.setIdSample(rs.getLong("idSample"));
                sample.setProvider(new Provider(rs.getString("nameProvider")));
                sample.setPetrobrasSample(rs.getInt("petrobrasSample"));
                samples.add(sample);
            }
        } catch (SQLException ex) {
            DataBaseException.MsgErrorDataBase("Sample" + ex.getMessage());
        } finally {
            super.closeConnectionRs();
        }
        return samples;
    }

    private void prepareStatement(Sample parameter) throws SQLException {
        if (parameter != null) {
            int i = 1;
            if (parameter.getAuctionNumber() > 0) {
                stmt.setInt(i++, parameter.getAuctionNumber());
            }
            if (parameter.getProvider() != null) {
                stmt.setString(i++, parameter.getProvider().getNameProvider());
            }
            if (parameter.getDateSampleCollection() != null) {
                stmt.setDate(i++, parameter.getDateSampleCollection());
            }
            if (parameter.getDateBetween() != null) {
                stmt.setDate(i, parameter.getDateBetween());
            }
        }
    }


    //    public List<Sample> select(List<Integer> seal) {
//        seal.forEach(s -> where += String.format(" auctionNumber = ? OR", s));
//        SELECT_QUERY += " WHERE " + where.substring(0, where.length() - 2);
//        selectPrint(SELECT_QUERY, seal);
//        return samples;
//    }

//    private void selectPrint(String query, List<Integer> seal) {
//        super.connection();
//        List<Sample> samples = new ArrayList<>();
//        try {
//            super.prepareStatement(query);
//            for (int i = 0; i < seal.size(); i++) {
//                stmt.setInt(i + 1, seal.get(i));
//            }
//            selectQuery();
//        } catch (SQLException ex) {
//            DataBaseException.MsgErrorDataBase("Sample" + ex.getMessage());
//        } finally {
//            closeConnectionRs();
//        }
//    }

}
