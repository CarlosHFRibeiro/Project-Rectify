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

    private List<Provider> providerList;
    private String SELECT_QUERY = "SELECT * FROM db_retifica.tbl_provider";

    public void insert(Provider provider) {
        connection();
        try {
            final String sql = "INSERT INTO `db_retifica`.`tbl_provider` (`cnpjProvider`, `phoneProvider`, `nameProvider`) VALUES (?, ?, ?);";
            prepareStatement(sql);
            stmt.setString(1, provider.getCnpjProvider());
            stmt.setString(2, provider.getPhoneProvider());
            stmt.setString(3, provider.getNameProvider());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            new DataBaseException().processMsg("Fornecedor" + ex.getMessage(), provider.getNameProvider());
        } finally {
            closeConnection();
        }
    }

    public List<Provider> select(Provider provider) {
        if (provider != null) {
            SELECT_QUERY += " WHERE UPPER(nameProvider) LIKE UPPER(?);";
        }
        selectAll(SELECT_QUERY, provider);
        return providerList;
    }

    private void selectAll(String select, Provider clause) {
        connection();
        providerList = new ArrayList<>();
        try {
            prepareStatement(select);
            if (clause != null) {
                stmt.setString(1, clause.getNameProvider() + '%');
            }
            resultSet();
            while (rs.next()) {
                Provider provider = new Provider();
                provider.setIdProvider(rs.getLong("idProvider"));
                provider.setNameProvider(rs.getString("nameProvider"));
                provider.setCnpjProvider(rs.getString("cnpjProvider"));
                provider.setPhoneProvider(rs.getString("phoneProvider"));
                providerList.add(provider);
            }
        } catch (SQLException ex) {
            new DataBaseException().processMsg("Fornecedor" + ex.getMessage());
        } finally {
            closeConnectionRs();
        }
    }
}
