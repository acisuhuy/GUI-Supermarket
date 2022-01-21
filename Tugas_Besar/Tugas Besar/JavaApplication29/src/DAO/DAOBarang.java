/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Koneksi.Koneksi_db;
import Model.Mod_barang;
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
public class DAOBarang implements ImplementBarang{
    Connection connection;
    final String insert = "INSERT INTO gudang(no,nama,harga,Stok)VALUES(?,?,?,?)";
    final String delete = "DELETE FROM gudang WHERE no=?";
    final String update = "UPDATE gudang Set nama=?, harga=?, Stok=?  WHERE no=?";
    final String select = "SELECT * FROM gudang";
    final String carisupermarket = "SELECT * FROM gudang WHERE no like ?";

    public DAOBarang() {
        connection = Koneksi_db.connection();
    }
    
     public void insert(Mod_barang mb) {
        PreparedStatement  statement = null;
        try{
            statement = connection.prepareStatement(insert);
            statement.setInt(1, mb.getNo());
            statement.setString(2, mb.getNama());
            statement.setDouble(3, mb.getHarga());
            statement.setInt(4, mb.getStok());
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
   
     
      public void delete(int no) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(delete);
            statement.setInt(1, no);
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
      
  
    public void update(Mod_barang mb) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(update);
            statement.setString(1, mb.getNama());
            statement.setDouble(2, mb.getHarga());
            statement.setInt(3, mb.getStok());
            statement.setInt(4, mb.getNo());
            
           System.out.println("Query: "+statement.toString());
           int result = statement.executeUpdate();
           System.out.println("result: "+result);
        }catch(SQLException ex){
            ex.printStackTrace();
        } 
    }
    
    
    public List<Mod_barang> getAll() {
        List<Mod_barang> lmb = null;
        try{
            lmb = new ArrayList<Mod_barang>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while(rs.next()){
                Mod_barang mb= new Mod_barang();
                mb.setNo(rs.getInt("no"));
                mb.setNama(rs.getString("nama"));
                mb.setHarga(rs.getDouble("harga"));
                mb.setStok(rs.getInt("Stok"));
                
                lmb.add(mb);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lmb;
    }
    
     public List<Mod_barang> getCarisupermarket(int no) {
        List<Mod_barang> lmb = null;
        try{
            lmb = new ArrayList<Mod_barang>();
            PreparedStatement st = connection.prepareStatement(carisupermarket);
            st.setInt(1, no);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Mod_barang mb= new Mod_barang();
                mb.setNo(rs.getInt("no"));
                mb.setNama(rs.getString("nama"));
                mb.setHarga(rs.getDouble("harga"));
                mb.setStok(rs.getInt("stok"));
                
                lmb.add(mb);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lmb;
    }
}
