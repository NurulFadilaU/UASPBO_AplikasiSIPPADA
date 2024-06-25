/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author hp
 */
public class tabelModelMahasiswa extends AbstractTableModel{
    List<Mahasiswa> ListMahasiswa;
    
    public tabelModelMahasiswa(List<Mahasiswa> ListMahasiswa){
        this.ListMahasiswa = ListMahasiswa;
    }
    @Override
    public int getRowCount() {
        return ListMahasiswa.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }
    
   
    @Override
    public String getColumnName(int column) {
    return switch (column) {
        case 0 -> "Nim";
        case 1 -> "Jenis Kelamin";
        case 2 -> "Ukuran Atasan";
        case 3 -> "Ukuran Bawahan";
        case 4 -> "Status";
        default -> null;
    };
}
    
    @Override
    public Object getValueAt(int row, int column) {
       return switch (column) {
           case 0 -> ListMahasiswa.get(row).getNim();
           case 1 -> ListMahasiswa.get(row).getJenisKelamin();
           case 2 -> ListMahasiswa.get(row).getUkuranAtasan();
           case 3 -> ListMahasiswa.get(row).getUkuranBawahan();
           case 4 -> ListMahasiswa.get(row).getStatus();
           default -> null;
       }; 
    }
    
    
}
