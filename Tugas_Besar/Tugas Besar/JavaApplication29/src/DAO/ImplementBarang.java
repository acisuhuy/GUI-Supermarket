/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Model.Mod_barang;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author zaky
 */
public interface ImplementBarang {
   public void insert(Mod_barang mb);
   
   public void delete(int no);
   public void update(Mod_barang mb);
   
   public List<Mod_barang> getAll();
   
   public List<Mod_barang> getCarisupermarket(int no);
   
}
