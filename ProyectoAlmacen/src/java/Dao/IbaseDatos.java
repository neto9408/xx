/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.util.List;

/**
 *
 * @author Andres Felipe Bernal
 */
public interface IbaseDatos<T> {
    List<T> Listar();
    boolean Crear(T t);
    boolean Actualizar(T t);
    boolean Borrar(T t);
    T Buscar(String s);
}