package dev.senzalla.rectify.request;

import dev.senzalla.rectify.entitys.Provider;
import dev.senzalla.rectify.exception.ElementDuplicate;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public class ProviderRequest extends Request<Provider> {

    private List<Provider> providers;
    private final String SELECT_QUERY = "SELECT * FROM db_retifica.tbl_provider";

    @Override
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
            new ElementDuplicate().processMsg(ex.getMessage(), provider.getNameProvider());
        } finally {
            closeConnection();
        }
    }

    @Override
    public List<Provider> select() {
        selectAll(SELECT_QUERY, null);
        return providers;
    }

    @Override
    public List<Provider> select(Provider provider) {
        String clause = SELECT_QUERY + " WHERE UPPER(nameProvider) LIKE UPPER(?);";
        selectAll(clause, provider);
        return providers;
    }

    @Override
    public List<Provider> select(List<String> clause, Provider provider) {
        return null;
    }

    private void selectAll(String select, Provider clause) {
        connection();
        if (providers == null) {
            providers = new ArrayList<>();
        }
        try {
            prepareStatement(select);
            if (clause != null) {
                stmt.setString(1, '%' + clause.getNameProvider() + '%');
            }
            resultSet();
            while (rs.next()) {
                Provider provider = new Provider();
                provider.setIdProvider(rs.getLong("idProvider"));
                provider.setNameProvider(rs.getString("nameProvider"));
                provider.setCnpjProvider(rs.getString("cnpjProvider"));
                provider.setPhoneProvider(rs.getString("phoneProvider"));
                providers.add(provider);
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        } finally {
            closeConnectionRs();
        }
    }
}
