package dev.senzalla.rectify.request;

import dev.senzalla.rectify.entitys.Provider;
import dev.senzalla.rectify.entitys.Seal;
import dev.senzalla.rectify.exception.DataBaseException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Black Burn Cybernetic
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class RequestSeal extends Request<Seal> {
    private List<Seal> seals;
    private String SELECT_QUERY = "SELECT * FROM db_retifica.view_seal";
    private String where = "";

    @Override
    public void insert(Seal seal) {
        connection();
        try {
            final String sql = "INSERT INTO `db_retifica`.`tbl_seal` (`saleSeal`, `clientSeal`, `factorySeal`, `brSeal`, `fkProviderSeal`) VALUES (?, ?, ?, ?, ?);";
            prepareStatement(sql);
            stmt.setInt(1, seal.getSaleSeal());
            stmt.setInt(2, seal.getClientSeal());
            stmt.setInt(3, seal.getFactorySeal());
            stmt.setInt(4, seal.getBrSeal());
            stmt.setLong(5, seal.getProvider().getIdProvider());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            new DataBaseException().processMsg(ex.getMessage(), "Uma dessas etiquetas");
        } finally {
            closeConnection();
        }
    }

    @Override
    public List<Seal> select() {
        selectAll(SELECT_QUERY, null);
        return seals;
    }

    public List<Seal> select(List<Integer> seal) {
        seal.forEach(s -> where += String.format(" saleSeal = ? OR", s));
        SELECT_QUERY += " WHERE " + where.substring(0, where.length() - 2);
        selectPrint(SELECT_QUERY, seal);
        return seals;
    }


    @Override
    public List<Seal> select(List<String> clause, Seal seal) {
        clause.forEach(s -> where += String.format(" %s ? AND", s));
        SELECT_QUERY += " WHERE " + where.substring(0, where.length() - 3);
        selectAll(SELECT_QUERY, seal);
        return seals;
    }

    private void selectPrint(String query, List<Integer> seal) {
        connection();
        seals = new ArrayList<>();
        try {
            prepareStatement(query);
            for (int i = 0; i < seal.size(); i++) {
                stmt.setInt(i+1, seal.get(i));
            }
            selectQuery();
        } catch (SQLException ex) {
            new DataBaseException().processMsg(ex.getMessage());
        } finally {
            closeConnectionRs();
        }
    }

    private void selectAll(String query, Seal parameter) {
        connection();
        seals = new ArrayList<>();
        try {
            prepareStatement(query);
            if (parameter != null) {
                int i = 1;
                if (parameter.getSaleSeal() > 0) {
                    stmt.setInt(i++, parameter.getSaleSeal());
                }
                if (parameter.getProvider() != null) {
                    stmt.setString(i++, parameter.getProvider().getNameProvider());
                }
                if (parameter.getDtSeal() != null) {
                    stmt.setDate(i++, parameter.getDtSeal());
                }
                if (parameter.getDateBetween() != null) {
                    stmt.setDate(i, parameter.getDateBetween());
                }
            }
            selectQuery();
        } catch (SQLException ex) {
            new DataBaseException().processMsg(ex.getMessage());
        } finally {
            closeConnectionRs();
        }
    }

    private void selectQuery() {
        try {
            resultSet();
            while (rs.next()) {
                Seal seal = new Seal();
                seal.setIdSeal(rs.getLong("idSeal"));
                seal.setSaleSeal(rs.getInt("saleSeal"));
                seal.setClientSeal(rs.getInt("clientSeal"));
                seal.setFactorySeal(rs.getInt("factorySeal"));
                seal.setBrSeal(rs.getInt("brSeal"));
                seal.setDtSeal(rs.getDate("dtSeal"));

                Provider provider = new Provider();
                provider.setNameProvider(rs.getString("nameProvider"));
                seal.setProvider(provider);

                seals.add(seal);
            }
        } catch (SQLException ex) {
            new DataBaseException().processMsg(ex.getMessage());
        }
    }

    public List<String> sale() {
        final String query = "SELECT * FROM db_retifica.view_sale";
        List<String> list = new ArrayList<>();
        connection();
        try {
            prepareStatement(query);
            resultSet();
            while (rs.next()) {
                Seal seal = new Seal();
                seal.setSaleSeal(rs.getInt("saleSeal"));
                list.add(String.valueOf(seal.getSaleSeal()));
            }
        } catch (SQLException ex) {
            new DataBaseException().processMsg(ex.getMessage());
        } finally {
            closeConnectionRs();
        }
        return list;
    }
}
