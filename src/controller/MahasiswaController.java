/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import javax.swing.JOptionPane;
import dao.daoMahasiswa;
import dao.InterfaceMahasiswa;
import javax.swing.table.DefaultTableModel;
import model.Mahasiswa;
import model.tabelModelMahasiswa;
import view.InputMahasiswa;


/**
 *
 * @author hp
 */
public class MahasiswaController {

    InputMahasiswa frame;
    InterfaceMahasiswa infcMahasiswa;
    List<Mahasiswa> ListMahasiswa;
    List<Mahasiswa> ListMahasiswaFull;

    public MahasiswaController(InputMahasiswa frame) {
        this.frame = frame;
        infcMahasiswa = new daoMahasiswa();
        ListMahasiswa = infcMahasiswa.getData();
        ListMahasiswaFull = infcMahasiswa.getDataFull();
    }
 

    public void tambahData() {
        Mahasiswa mhs_baru = new Mahasiswa();
        mhs_baru.setNim(frame.getTxtNim().getText());
        mhs_baru.setNama(frame.getTxtNama().getText());
        mhs_baru.setKelas(frame.getTxtKelas().getText());
        mhs_baru.setJenisKelamin(frame.getJenisKelamin());
        mhs_baru.setJilbab(frame.getJilbab().getSelectedItem().toString());
        mhs_baru.setUkuranAtasan(frame.getTxtUkuranAtasan().getText());
        mhs_baru.setUkuranBawahan(frame.getTxtUkuranBawahan().getText());
        mhs_baru.setStatus(frame.getStatus().getSelectedItem().toString());
        infcMahasiswa.insert(mhs_baru);
//        load_table();
        JOptionPane.showMessageDialog(frame, "Data berhasil ditambahkan");
    }
    

    
    public void updateData() {
        int selectedRow = frame.getMahasiswaTable().getSelectedRow();
    if (selectedRow != -1) {
        Mahasiswa mhs_baru = new Mahasiswa();
        mhs_baru.setNim(frame.getTxtNim().getText());
        mhs_baru.setNama(frame.getTxtNama().getText());
        mhs_baru.setKelas(frame.getTxtKelas().getText());
        mhs_baru.setJenisKelamin(frame.getJenisKelamin());
        mhs_baru.setJilbab(frame.getJilbab().getSelectedItem().toString());
        mhs_baru.setUkuranAtasan(frame.getTxtUkuranAtasan().getText());
        mhs_baru.setUkuranBawahan(frame.getTxtUkuranBawahan().getText());
        mhs_baru.setStatus(frame.getStatus().getSelectedItem().toString());

        infcMahasiswa.update(mhs_baru);
        JOptionPane.showMessageDialog(frame, "Data Berhasil diupdate");
        load_table();
    } else {
        JOptionPane.showMessageDialog(frame, "Pilih data yang ingin diupdate");
    }
        
}
    public void isiField(int row) {
        frame.getTxtNim().setText(ListMahasiswaFull.get(row).getNim());
        frame.getTxtNama().setText(ListMahasiswaFull.get(row).getNama());
        frame.getTxtKelas().setText(ListMahasiswaFull.get(row).getKelas());
        //Atur jenis kelamin berdasarkan nilai dari database
        String jenisKelamin = ListMahasiswaFull.get(row).getJenisKelamin();
        if (jenisKelamin.equalsIgnoreCase("perempuan")) {
            frame.getPerempuanRadioButton().setSelected(true);
            frame.getLakilakiRadioButton().setSelected(false);   
        }else if (jenisKelamin.equalsIgnoreCase("laki laki")) {
            frame.getPerempuanRadioButton().setSelected(false);
            frame.getLakilakiRadioButton().setSelected(true);
        }
        frame.getJilbab().setSelectedItem(ListMahasiswaFull.get(row).getJilbab());
        frame.getTxtUkuranAtasan().setText(ListMahasiswaFull.get(row).getUkuranAtasan());
        frame.getTxtUkuranBawahan().setText(ListMahasiswaFull.get(row).getUkuranBawahan());
        frame.getStatus().setSelectedItem(ListMahasiswaFull.get(row).getStatus());
    }
    
    public void load_table() {
        ListMahasiswa = infcMahasiswa.getData();
        ListMahasiswaFull = infcMahasiswa.getDataFull(); 
        tabelModelMahasiswa tmm = new tabelModelMahasiswa(ListMahasiswa);
        frame.getMahasiswaTable().setModel(tmm);
    }

    public void empty_form() {
        frame.setTxtNim("");
        frame.setTxtNama("");
        frame.setTxtKelas("");
        frame.setButtonGroup1();
        frame.setJilbabComboBox();
        frame.setTxtUkuranAtasan("");
        frame.setTxtUkuranBawahan("");
        frame.setStatusComboBox();

    }
    
    public void hapusData() {
        int selectedRow = frame.getMahasiswaTable().getSelectedRow();
        if (selectedRow != -1) {
            String nim = frame.getMahasiswaTable().getValueAt(selectedRow, 0).toString();
            int confirm = JOptionPane.showConfirmDialog(frame, "Apakah Anda yakin ingin menghapus data ini?", "Konfirmasi Hapus Data", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                infcMahasiswa.delete(nim);
                JOptionPane.showMessageDialog(frame, "Data berhasil dihapus");
                load_table();
            }
        } else {
            JOptionPane.showMessageDialog(frame, "Pilih data yang ingin dihapus");
        }
    }
}
    
    

