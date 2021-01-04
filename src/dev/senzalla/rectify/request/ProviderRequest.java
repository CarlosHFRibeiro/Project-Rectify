package dev.senzalla.rectify.request;

import dev.senzalla.rectify.entitys.Provider;
import dev.senzalla.rectify.exception.DataBaseException;
import dev.senzalla.rectify.setting.ConectionMySql;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class ProviderRequest extends ConectionMySql {


    public void insert(Provider provider) {
        try {
            super.connection();
            final String sql = "INSERT INTO `tbl_provider` (`cnpjProvider`, `phoneProvider`, `nameProvider`) VALUES (?, ?, ?);";
            super.prepareStatement(sql);
            stmt.setString(1, provider.getCnpjProvider());
            stmt.setString(2, provider.getPhoneProvider());
            stmt.setString(3, provider.getNameProvider());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            DataBaseException.MsgErrorDataBase("Provider: " + ex.getMessage(), provider.getNameProvider());
        } finally {
            super.closeConnection();
        }
    }

    public List<Provider> select(Provider provider) {
        String SELECT_QUERY = "SELECT * FROM tbl_provider";
        if (provider != null) {
            SELECT_QUERY += " WHERE UPPER(nameProvider) LIKE UPPER(?);";
        }
        return selectAll(SELECT_QUERY, provider);
    }

    private List<Provider> selectAll(String select, Provider clause) {
        super.connection();
        List<Provider> providerList = new ArrayList<>();
        try {
            super.prepareStatement(select);
            this.prepareStatement(clause);
            super.resultSet();
            while (rs.next()) {
                Provider provider = new Provider();
                provider.setIdProvider(rs.getLong("idProvider"));
                provider.setNameProvider(rs.getString("nameProvider"));
                provider.setCnpjProvider(rs.getString("cnpjProvider"));
                provider.setPhoneProvider(rs.getString("phoneProvider"));
                providerList.add(provider);
            }
        } catch (SQLException ex) {
            DataBaseException.MsgErrorDataBase("Provider: " + ex.getMessage());
        } finally {
            super.closeConnectionRs();
        }
        return providerList;
    }

    private void prepareStatement(Provider clause) throws SQLException {
        if (clause != null) {
            stmt.setString(1, clause.getNameProvider() + '%');
        }
    }
}
