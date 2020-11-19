package dev.senzalla.rectify.request;

import dev.senzalla.rectify.setting.ConectionMySql;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author Black Burn Cybernetic
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public abstract class Model<T> extends ConectionMySql {

    private List<T> list;
    private String select = null;

    public  void insert(T t) {
        try {
            String sql = null;
            ConectionMySql.prepareStatement(sql);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex);
        } finally {
            closeConnection();
        }
    }

    public List<T> select() {
        selectAll( select);
        return list;
    }

    public List<T> select(Map<String, T> clause) {
        String where = "";
        where = clause.entrySet().stream().map(entry -> 
                String.format(" %s = %s AND", entry.getKey(), entry.getValue())
        ).reduce(where, String::concat);

        select += " WHERE " + where.substring(0, where.length() - 3);
        selectAll(select);
        return list;
    }


    protected List<T> selectAll(String select) {
        try {
            prepareStatement(select);
            resultSet();
            while (rs.next()) {
        T t = null;
                list.add(t);
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        } finally {
            closeConnectionRs();
        }

        return list;
    }
}
