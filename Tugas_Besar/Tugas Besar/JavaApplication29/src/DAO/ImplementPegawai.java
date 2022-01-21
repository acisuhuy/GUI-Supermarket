/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Model.mod_pegawai;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author zaky
 */
public interface ImplementPegawai {
   public void insert(mod_pegawai mp);
   
   public void delete(int no);
   public void update(mod_pegawai mp);
   
   public List<mod_pegawai> getAll();
   
   public List<mod_pegawai> getCaripegawai(int no);
}
