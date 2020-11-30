package dev.senzalla.rectify.request;

import dev.senzalla.rectify.setting.ConectionMySql;

import java.util.List;

/**
 * @author Bomsalvez Freitas
 * @e-mail bomsalvez@gmail.com
 * @github github.com/Bomsalvez
 */
public abstract class Request<T> extends ConectionMySql {

    public abstract void insert(T t);

    public abstract List<T> select();

    public abstract List<T> select(List<String> clause, T t);

}
