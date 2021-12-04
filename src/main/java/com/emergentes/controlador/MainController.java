/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emergentes.controlador;

import com.emergentes.modelo.Cliente;
import com.emergentes.utiles.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PreparedStatement ps;
        Conexion canal = new Conexion();
        Connection conn = canal.conectar();
        ResultSet rs;
        String op;
        int id;
        ArrayList<Cliente> lista = new ArrayList<Cliente>();
        op = (request.getParameter("op") != null) ? request.getParameter("op") : "list";
        if (op.equals("list")) {
            //operacions para listar datos 
            String sql = "select * from clientes";
            try {
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Cliente cln = new Cliente();
                    cln.setId(rs.getInt("id"));
                    cln.setNombre(rs.getString("nombre"));
                    cln.setApellido(rs.getString("apellido"));
                    cln.setCorreo(rs.getString("correo"));
                    cln.setTelefono(rs.getInt("telefono"));
                    cln.setSaldo(rs.getInt("saldo"));
                    lista.add(cln);
                }
                request.setAttribute("lista", lista);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (op.equals("nuevo")) {
            //operaciones para desplegar formulario
            Cliente li = new Cliente();
            request.setAttribute("lib", li);
            request.getRequestDispatcher("editar.jsp").forward(request, response);
        }
        if (op.equals("eliminar")) {
            //operaciones para eliminar un registro 
            id = Integer.parseInt(request.getParameter("id"));
            try {
                ps = conn.prepareStatement("delete from clientes where id=?");
                ps.setInt(1, id);
                ps.executeUpdate();
                response.sendRedirect("MainController");
            } catch (SQLException ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(op.equals("editar")){
           id=Integer.parseInt(request.getParameter("id"));
            try {
                Cliente cln1=new Cliente();
                ps=conn.prepareStatement("select * from clientes where id=?");
                ps.setInt(1, id);
                rs=ps.executeQuery();
                if(rs.next()){
                    cln1.setId(rs.getInt("id"));
                    cln1.setNombre(rs.getString("nombre"));
                    cln1.setApellido(rs.getString("apellido"));
                    cln1.setCorreo(rs.getString("correo"));
                    cln1.setTelefono(rs.getInt("telefono"));
                    cln1.setSaldo(rs.getInt("saldo"));
                    
                }
                request.setAttribute("lib", cln1);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String correo = request.getParameter("correo");
        int telefono=Integer.parseInt(request.getParameter("telefono"));
        int saldo = Integer.parseInt(request.getParameter("saldo"));
        Cliente cln = new Cliente();
        cln.setId(id);
        cln.setNombre(nombre);
        cln.setApellido(apellido);
        cln.setCorreo(correo);
        cln.setTelefono(telefono);
        cln.setSaldo(saldo);
        Conexion canal = new Conexion();
        Connection conn = canal.conectar();
        PreparedStatement ps;
        ResultSet rs;
        if (id == 0) {
            //insertar registros
            String sql = "insert into clientes (nombre,apellido,correo,telefono,saldo) values(?,?,?,?,?)";
            try {
                ps = conn.prepareStatement(sql);
                ps.setString(1, cln.getNombre());
                ps.setString(2,cln.getApellido());
                ps.setString(3, cln.getCorreo());
                ps.setInt(4,cln.getTelefono());
                ps.setInt(5, cln.getSaldo());
                ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            //actualizar registros
            String sql1="update clientes set nombre=?,apellido=?,correo=?,telefono=?,saldo=? where id=?";
            try {
                ps=conn.prepareStatement(sql1);
                ps.setString(1, cln.getNombre());
                ps.setString(2,cln.getApellido());
                ps.setString(3, cln.getCorreo());
                ps.setInt(4,cln.getTelefono());
                ps.setInt(5, cln.getSaldo());
                ps.setInt(6,cln.getId());
                
                ps.executeUpdate();             
            } catch (SQLException ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        response.sendRedirect("MainController");
    

    }

}
