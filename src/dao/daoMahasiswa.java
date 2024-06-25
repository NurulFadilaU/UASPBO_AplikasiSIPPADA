/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import controller.Koneksi;
import model.Mahasiswa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author hp
 */
public class daoMahasiswa implements InterfaceMahasiswa {

    Connection connection;
   
    final String insert = "INSERT INTO Input (nim, nama, kelas, jenisKelamin, jilbab, ukuranAtasan, ukuranBawahan, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
    final String update = "UPDATE Input SET nim=?, nama=?, kelas=?, jenisKelamin=?, jilbab=?, ukuranAtasan=?, ukuranBawahan=?, status=? WHERE nim=?;";
    final String delete = "DELETE FROM Input WHERE nim=? ;";
    final String select = "SELECT nim, jenisKelamin, ukuranAtasan, ukuranBawahan, status FROM Input;";
    final String selectFull = "SELECT nama, nim, kelas, jenisKelamin, jilbab, ukuranAtasan, ukuranBawahan, status FROM Input";

    public daoMahasiswa() {
        connection = Koneksi.connection();
    }

    @Override
    public void insert(Mahasiswa mhs) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(insert);
            statement.setString(1, mhs.getNim());
            statement.setString(2, mhs.getNama());
            statement.setString(3, mhs.getKelas());
            statement.setString(4, mhs.getJenisKelamin());
            statement.setString(5, mhs.getJilbab());
            statement.setString(6, mhs.getUkuranAtasan());
            statement.setString(7, mhs.getUkuranBawahan());
            statement.setString(8, mhs.getStatus());
            statement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void update(Mahasiswa mhs) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(update);
            statement.setString(1, mhs.getNim());
            statement.setString(2, mhs.getNama());
            statement.setString(3, mhs.getKelas());
            statement.setString(4, mhs.getJenisKelamin());
            statement.setString(5, mhs.getJilbab());
            statement.setString(6, mhs.getUkuranAtasan());
            statement.setString(7, mhs.getUkuranBawahan());
            statement.setString(8, mhs.getStatus());
            statement.setString(9, mhs.getNim()); // Set the nim for the WHERE clause
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void delete(String nim) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(delete);
            statement.setString(1, nim);
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<Mahasiswa> getData() {
        java.util.List<Mahasiswa> lb = null;
        try {
            lb = new ArrayList<Mahasiswa>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                Mahasiswa b = new Mahasiswa();
                b.setNim(rs.getString("nim"));
                b.setJenisKelamin(rs.getString("jenisKelamin"));
                b.setUkuranAtasan(rs.getString("ukuranAtasan"));
                b.setUkuranBawahan(rs.getString("ukuranBawahan"));
                b.setStatus(rs.getString("status"));
                lb.add(b);
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(daoMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return lb;
    }
    
    @Override
    public List <Mahasiswa> getDataFull() {
        List<Mahasiswa> lb = null;
        try {
            lb = new ArrayList<Mahasiswa>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(selectFull);
            while (rs.next()) {
                Mahasiswa b = new Mahasiswa();
                b.setNama(rs.getString("nama"));
                b.setNim(rs.getString("nim"));
                b.setKelas(rs.getString("kelas"));
                b.setJenisKelamin(rs.getString("jenisKelamin"));
                b.setJilbab(rs.getString("jilbab"));
                b.setUkuranAtasan(rs.getString("ukuranAtasan"));
                b.setUkuranBawahan(rs.getString("ukuranBawahan"));
                b.setStatus(rs.getString("jilbab"));
                lb.add(b);
            }
        }catch (SQLException ex) {
            java.util.logging.Logger.getLogger(daoMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    return lb;
  }
}
