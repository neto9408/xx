/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Dao.EquipoDao;
import Vo.Equipo;
import java.util.List;

/**
 *
 * @author Andres Felipe Bernal
 */
public class EquipoServicio {
    private EquipoDao dao= null;
     public EquipoServicio(EquipoDao dao ){
      this.dao = dao;
    }
    
    public List<Equipo> Listar() {
      return this.dao.Listar();
    }
    
    public boolean insert(Equipo t){
      return this.dao.Crear(t);
    }
    
    public boolean update(Equipo t){
       return this.dao.Actualizar(t);
    }
    
    public boolean delete(Equipo t) {
       return this.dao.Borrar(t);
    }
    public Equipo Buscar(String t){
        return this.dao.Buscar(t);
    }

}
