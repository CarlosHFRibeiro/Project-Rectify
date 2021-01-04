package dev.senzalla.rectify.request;

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
public abstract class Model<T> extends ConectionMySql {

    private List<T> list;
    private String SELECT_QUERY = null;
    private String where = "";

    public  void insert(T t) {
        connection();
        try {
            final String sql = null;
            prepareStatement(sql);
            stmt.executeUpdate();
        } catch (SQLException ex) {
             DataBaseException.MsgErrorDataBase(ex.getMessage(), null);
        } finally {
            super.closeConnection();
        }
    }

    public List<T> select() {
        selectAll(SELECT_QUERY, null);
        return list;
    }

    public List<T> select(T t) {
        String clause = SELECT_QUERY + " WHERE UPPER(nameMakeEster) LIKE UPPER(?);";
        selectAll(clause, null);
        return list;
    }

    public List<T> select(List<String> clause, T t) {

        clause.forEach(s -> where += String.format(" %s ? AND",s));

        SELECT_QUERY += " WHERE " + where.substring(0, where.length() - 3);
        selectAll(SELECT_QUERY,null);
        return list;
    }

    private void selectAll(String query, T parameter) {
        connection();
            list = new ArrayList<>();
        try {
            prepareStatement(query);
            if (parameter != null) {
                stmt.setString(1, '%' + parameter.toString() + '%');
            }
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
    }
}
