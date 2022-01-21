/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import DAO.DAOPegawai;
import DAO.ImplementPegawai;
import GUI.EmployeeAdd;
import Model.mod_pegawai;
import Model.mod_tabel_pegawai;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author zaky
 */
public class Controller_employe {
    EmployeeAdd frame;
    ImplementPegawai implPegawai;
    List<mod_pegawai> lmp;
    
    public Controller_employe(EmployeeAdd frame) {
        this.frame = frame;
        implPegawai = new DAOPegawai();
        lmp = implPegawai.getAll();
    }
    
    public void reset(){
        frame.getTf_no().setText("");
        frame.getTf_nama().setText("");
        frame.getTf_id().setText("");
        frame.getTf_kelamin().setText("");
    }
    
    public void isiTabel() {
        lmp = implPegawai.getAll();
        mod_tabel_pegawai mtb = new mod_tabel_pegawai(lmp);
        frame.getTable_pegawai().setModel(mtb);
    }
    
    public void isitextfield(int row) {
        frame.getTf_no().setText(String.valueOf(lmp.get(row).getNo()));
        frame.getTf_nama().setText(lmp.get(row).getNama());
        frame.getTf_id().setText(String.valueOf(lmp.get(row).getId()));
        frame.getTf_kelamin().setText(String.valueOf(lmp.get(row).getKelamin()));  
    }
    
    public void insertTabel(){
        if(!frame.getTf_nama().getText().trim().isEmpty() & !frame.getTf_nama().getText().trim().isEmpty()){
            mod_pegawai mp = new mod_pegawai();
            mp.setNo(Integer.valueOf(frame.getTf_no().getText()));
            mp.setNama(frame.getTf_nama().getText());
            mp.setId(Integer.valueOf(frame.getTf_id().getText()));
            mp.setKelamin(frame.getTf_kelamin().getText());
            
            implPegawai.insert(mp);
            JOptionPane.showMessageDialog(null, "data disimpan");
        } else{
            JOptionPane.showMessageDialog(null, "data gagal disimpan");
        }
    }
    
    public void Delete(){
        if(!frame.getTf_no().getText().trim().isEmpty()){
            int id = Integer.parseInt(frame.getTf_no().getText());
            implPegawai.delete(id);
            JOptionPane.showMessageDialog(null, "data berhasil dihapus");
        }else{
          JOptionPane.showMessageDialog(null, "data gagal dihapus");  
        }
    }
    
    public void update(){
        if(!frame.getTf_nama().getText().trim().isEmpty()){
            mod_pegawai mp = new mod_pegawai();
            
            mp.setNo(Integer.valueOf(frame.getTf_no().getText()));
            mp.setNama(frame.getTf_nama().getText());
            mp.setId(Integer.valueOf(frame.getTf_id().getText()));
            mp.setKelamin(frame.getTf_kelamin().getText());
            
            implPegawai.update(mp);
            JOptionPane.showMessageDialog(null, "data diperbaharui");
        } else{
            JOptionPane.showMessageDialog(null, "data gagal diperbaharui"); 
        }
    }
    
    public void isitable_cari_pegawai(){
        lmp = implPegawai.getCaripegawai(Integer.valueOf(frame.getTf_caripegawai().getText()));
        mod_tabel_pegawai mtb = new mod_tabel_pegawai(lmp);
        frame.getTable_pegawai().setModel(mtb);
    }
    public void getCaripegawai(){
           if(!frame.getTf_caripegawai().getText().trim().isEmpty()); {
           implPegawai.getCaripegawai(Integer.valueOf(frame.getTf_caripegawai().getText()));
           isitable_cari_pegawai();
           }
       }
}
