/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Vo.Equipo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andres Felipe Bernal
 */
public class EquipoDao implements IbaseDatos<Equipo>{

    @Override
    public List<Equipo> Listar() {
    List<Equipo> equipos = null;
	    String query = "SELECT * FROM equipo";
	    Connection connection = Dao.conexion.getConnection();
	    try {
	    Statement st = connection.createStatement();
	    ResultSet rs = st.executeQuery(query);
	    int id =0;
	    String nombre = null;
            String referencia=null;
            String modelo=null;
            int cantidad=0;
            String categoria=null;
	    while (rs.next()){
	    	if(equipos== null){
	    		equipos= new ArrayList<Equipo>();
	    	}
	      
	        Equipo registro= new Equipo();
                
	        id = rs.getInt("id_Equipo");
	        registro.setId_Equipo(id);
	        
	        nombre= rs.getString("nombre_Equipo");
                registro.setNombre_Equipo(nombre);
                
                modelo=rs.getString("modelo_Equipo");
                registro.setModelo_Equipo(modelo);
                
                referencia= rs.getString("referencia_Equipo");
                registro.setReferencia_Equipo(referencia);
                
               cantidad=rs.getInt("cantidad_Equipo");
                registro.setCantidad_Equipo(cantidad);
                
                categoria= rs.getString("categoria_equipo");
                registro.setPrograma_Equipo(categoria);
            
	       equipos.add(registro);
	    }
	    st.close();
	    
	    } catch (SQLException e) {
			System.out.println("Problemas al obtener la lista de equipos");
			e.printStackTrace();
		}
	    
	    return equipos;
    }

    @Override
    public boolean Crear(Equipo t) {
        boolean result=false;
		Connection connection = Dao.conexion.getConnection();
	    String query = " insert into equipo(nombre_Equipo, modelo_Equipo,referencia_Equipo,cantidad_Equipo, programa_Equipo)"  + " values (?,?,?,?,?)";
        PreparedStatement preparedStmt=null;
	    try {
		preparedStmt = connection.prepareStatement(query);
		preparedStmt.setString (1, t.getNombre_Equipo());
                preparedStmt.setString (3, t.getModelo_Equipo());
                preparedStmt.setString (2, t.getReferencia_Equipo());
                preparedStmt.setInt (4, t.getCantidad_Equipo());
                preparedStmt.setString (5, t.getPrograma_Equipo());
                
		result= preparedStmt.execute();
	    } catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
    }

    @Override
    public boolean Actualizar(Equipo t) {
        boolean result=false;
		Connection connection = Dao.conexion.getConnection();
		String query = "update equipo set nombre_Equipo = ?, modelo_Equipo=?,  referencia_Equipo = ?,cantidad_Equipo=?, categoria_Equipo=? where id_Equipo = ?";
		PreparedStatement preparedStmt=null;
		try {
		    preparedStmt = connection.prepareStatement(query);
		    preparedStmt.setString (1, t.getNombre_Equipo());
                    preparedStmt.setString(3, t.getModelo_Equipo());
                    preparedStmt.setString(2, t.getReferencia_Equipo());
                    preparedStmt.setInt (4, t.getCantidad_Equipo());
                    preparedStmt.setString (5, t.getPrograma_Equipo());
                    preparedStmt.setInt (6, t.getId_Equipo());
                    
                if (preparedStmt.executeUpdate() > 0){
		    	result=true;
		    }
			    
		} catch (SQLException e) {
                    
			System.out.println("Problemas al insertar un equipo");
				e.printStackTrace();
		}
			
		return result;
    }

    @Override
    public boolean Borrar(Equipo t) {
       boolean result=false;
	   Connection connection = Dao.conexion.getConnection();
	   String query = "delete from equipo where id_equipo = ?";
	   PreparedStatement preparedStmt=null;
	   try {
		     preparedStmt = connection.prepareStatement(query);
		     preparedStmt.setInt(1, t.getId_Equipo());
		    result= preparedStmt.execute();
		} catch (SQLException e) {
                    
			System.out.println("Problemas al borrar un equipo");
			e.printStackTrace();
		}
	   
	   return result;
    }

    @Override
    public Equipo Buscar(String s) {
       Equipo equipo=new Equipo();
       
	    String query = "SELECT * FROM equipo where nombre_Equipo="+s+";";
	    Connection connection = Dao.conexion.getConnection();
	    try {
	    Statement st = connection.createStatement();
	    ResultSet rs = st.executeQuery(query);
	    int id;
	    String nombre;
            String referencia;
            String modelo;
            int cantidad;
            String categoria;
	    if (rs.next()){
	    	                    
	        id = rs.getInt("id_Equipo");
	        equipo.setId_Equipo(id);
	        
	        nombre= rs.getString("nombre_Equipo");
                equipo.setNombre_Equipo(nombre);
                
                modelo=rs.getString("modelo_Equipo");
                equipo.setModelo_Equipo(modelo);
                
                referencia= rs.getString("referencia_Equipo");
                equipo.setReferencia_Equipo(referencia);
                
               cantidad=rs.getInt("cantidad_Equipo");
                equipo.setCantidad_Equipo(cantidad);
                
                categoria= rs.getString("categoria_equipo");
                equipo.setPrograma_Equipo(categoria);
         
	    }
	    st.close();
	    
	    } catch (SQLException e) {
			System.out.println("Problemas al buscar un equipo");
			e.printStackTrace();
		}
	    
	    return equipo;
    }
    
}
