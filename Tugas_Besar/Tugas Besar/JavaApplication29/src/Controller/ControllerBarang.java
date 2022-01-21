/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAOBarang;
import DAO.ImplementBarang;
import GUI.Stock_barang;
import Model.Mod_barang;
import Model.Mod_tabel_barang;
import static java.util.Collections.list;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author zaky
 */
public class ControllerBarang {
    
    Stock_barang frame;
    ImplementBarang implBarang;
    List<Mod_barang> lmb;

    public ControllerBarang(Stock_barang frame) {
        this.frame = frame;
        implBarang =  new DAOBarang();
        lmb = implBarang.getAll();
    }
    
    public void reset(){
        frame.getTf_no().setText("");
        frame.getTf_namabarang().setText("");
        frame.getTf_harga().setText("");
        frame.getTf_stock().setText("");
    }
    
    public void isiTabel() {
        lmb = implBarang.getAll();
        Mod_tabel_barang mtb = new Mod_tabel_barang(lmb);
        frame.getTb_barang().setModel(mtb);
    }
    
    public void isitextfield(int row) {
        frame.getTf_no().setText(String.valueOf(lmb.get(row).getNo()));
        frame.getTf_namabarang().setText(lmb.get(row).getNama());
        frame.getTf_harga().setText(String.valueOf(lmb.get(row).getHarga()));
        frame.getTf_stock().setText(String.valueOf(lmb.get(row).getStok()));
    }
    
      public void insertTabel(){
        if(!frame.getTf_namabarang().getText().trim().isEmpty() & !frame.getTf_namabarang().getText().trim().isEmpty()){
            Mod_barang mb = new Mod_barang();
            mb.setNo(Integer.valueOf(frame.getTf_no().getText()));            
            mb.setNama(frame.getTf_namabarang().getText());
            mb.setHarga(Double.valueOf(frame.getTf_harga().getText()));
            mb.setStok(Integer.valueOf(frame.getTf_stock().getText()));
            mb.setNo(Integer.valueOf(frame.getTf_no().getText()));
            
            implBarang.insert(mb);
            JOptionPane.showMessageDialog(null, "data disimpan");
        } else{
            JOptionPane.showMessageDialog(null, "data gagal disimpan");
        }
    }
    
      public void Delete(){
          if(!frame.getTf_no().getText().trim().isEmpty()){
              int id = Integer.parseInt(frame.getTf_no().getText());
              implBarang.delete(id);
              JOptionPane.showMessageDialog(null, "data berhasil dihapus");
        } else{
            JOptionPane.showMessageDialog(null, "data gagal dihapus");
        }
          
      }
      
       public void update(){
        if(!frame.getTf_namabarang().getText().trim().isEmpty()){
            Mod_barang mb = new Mod_barang();
            
            mb.setNo(Integer.valueOf(frame.getTf_no().getText()));
            mb.setNama(frame.getTf_namabarang().getText());
            mb.setHarga(Double.valueOf(frame.getTf_harga().getText()));
            mb.setStok(Integer.valueOf(frame.getTf_stock().getText()));
           
            implBarang.update(mb);
            
            JOptionPane.showMessageDialog(null, "data diperbaharui");
        } else{
            JOptionPane.showMessageDialog(null, "data gagal diperbaharui");
        }
    }
       
       
       public void isitable_cari_supermarket(){
           lmb = implBarang.getCarisupermarket(Integer.valueOf(frame.getTf_cari().getText()));
           Mod_tabel_barang mtb = new Mod_tabel_barang(lmb);
           frame.getTb_barang().setModel(mtb);
       }
       
       public void cari_namabarang(){
           if(!frame.getTf_cari().getText().trim().isEmpty()); {
           implBarang.getCarisupermarket(Integer.valueOf(frame.getTf_cari().getText()));
           isitable_cari_supermarket();
           }
       }
}
