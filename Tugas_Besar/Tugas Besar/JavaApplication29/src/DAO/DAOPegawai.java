/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Koneksi.Koneksi_db;
import Model.mod_pegawai;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author zaky
 */
public class DAOPegawai implements ImplementPegawai{
    Connection connection;
    final String insert = "INSERT INTO pegawai(no,nama,id,kelamin)VALUES(?,?,?,?)";
    final String delete = "DELETE FROM pegawai WHERE no=?";
    final String update = "UPDATE pegawai Set nama=?, id=?, kelamin=?  WHERE no=?";
    final String select = "SELECT * FROM pegawai";
    final String caripegawai = "SELECT * FROM pegawai WHERE no like ?";
    
    public DAOPegawai() {
        connection = Koneksi_db.connection();
    }
    
    public void insert(mod_pegawai mp) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(insert);
            statement.setInt(1, mp.getNo());
            statement.setString(2, mp.getNama());
            statement.setInt(3, mp.getId());
            statement.setString(4, mp.getKelamin());
            statement.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        } finally{
            try{
                statement.close();
            }catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    
    public void delete(int no) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(delete);
            statement.setInt(1,no);
            statement.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        } finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }
    
    public void update(mod_pegawai mp) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(update);
            statement.setInt(4, mp.getNo());
            statement.setString(1, mp.getNama());
            statement.setInt(2, mp.getId());
            statement.setString(3, mp.getKelamin());
            
            System.out.print("Query: "+statement.toString());
            int result = statement.executeUpdate();
            System.out.println("result: "+result);
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public List<mod_pegawai> getAll() {
       List<mod_pegawai> lmp = null;
       try{
           lmp = new ArrayList<mod_pegawai>();
           Statement st = connection.createStatement();
           ResultSet rs = st.executeQuery(select);
           while(rs.next()){
               mod_pegawai mp= new mod_pegawai();
               mp.setNo(rs.getInt("no"));
               mp.setNama(rs.getString("nama"));
               mp.setId(rs.getInt("id"));
               mp.setKelamin(rs.getString("kelamin"));
               lmp.add(mp);
           }
       } catch (Exception e) {
           e.printStackTrace();
       }
        return lmp;
    }
    
   
    public List<mod_pegawai> getCaripegawai(int no) {
        List<mod_pegawai> lmp = null;
        try{
            lmp = new ArrayList<mod_pegawai>();
            PreparedStatement st = connection.prepareStatement(caripegawai);
            st.setInt(1, no);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                mod_pegawai mp= new mod_pegawai();
                mp.setNo(rs.getInt("no"));
                mp.setNama(rs.getString("nama"));
                mp.setId(rs.getInt("id"));
                mp.setKelamin(rs.getString("kelamin"));
                
                lmp.add(mp);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }  
        return lmp;
    }
}
