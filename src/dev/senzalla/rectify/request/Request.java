package dev.senzalla.rectify.request;

import dev.senzalla.rectify.setting.ConectionMySql;

import java.util.List;
import java.util.Map;

/**
 * @author Black Burn Cybernetic
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public abstract class Request<T> extends ConectionMySql {

    public abstract void insert(T t);

    public abstract List<T> select();

    public abstract List<T> select(T t);

    public abstract List<T> select(List<String> clause, T t);
}
