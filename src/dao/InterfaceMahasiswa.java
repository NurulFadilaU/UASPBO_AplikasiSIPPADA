/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;
import model.Mahasiswa;
import java.util.List;
/**
 *
 * @author hp
 */
public interface InterfaceMahasiswa {
    public void insert(Mahasiswa mhs);
    public void update(Mahasiswa mhs);
    public void delete(String nim);
    public List<Mahasiswa> getData();
    public List<Mahasiswa> getDataFull();
}
