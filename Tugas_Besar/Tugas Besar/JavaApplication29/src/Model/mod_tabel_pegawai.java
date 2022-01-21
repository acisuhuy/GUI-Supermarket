/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author zaky
 */
public class mod_tabel_pegawai extends AbstractTableModel {
    List <mod_pegawai>lmp;
    
    public mod_tabel_pegawai(List<mod_pegawai> lmp) {
        this.lmp = lmp; 
    }
    
    @Override
    public int getRowCount() {
        return lmp.size();
    }
    @Override
    public  int getColumnCount() {
        return 4;
    }
    @Override
       public Object getValueAt(int row, int column) {
          switch(column){
            case 0:
                return lmp.get(row).getNo();
            case 1:
                return lmp.get(row).getNama();
            case 2:
                return lmp.get(row).getId();
            case 3:
                return lmp.get(row).getKelamin();
            default:
                return null;
        }
          
   
       
    }
    @Override
        public String getColumnName(int column){
        switch(column){
            case 0:
                return "no";
            case 1:
                return "nama";
            case 2:
                return "id";
            case 3:
                return "kelamin";
            default:
                return null;
        }
    }
}
