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
public abstract class Request<T> extends ConectionMySql {

    private List<T> list;
    private String select = null;

    public abstract void insert(T t);

    public abstract List<T> select(T t);

    public abstract List<T> select(Map<String, String> clause, T t);
}
