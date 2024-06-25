/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author hp
 */
public class Mahasiswa {
    private String nim;
    private String nama;
    private String kelas;
    private String jenisKelamin;
    private String jilbab;
    private String ukuranAtasan;
    private String ukuranBawahan;
    private String status;
    
    public String getNim()
    {
        return this.nim;
    }
    public String getNama()
    {
        return this.nama;
    }
    public String getKelas()
    {
        return this.kelas;
    }
    public String getJenisKelamin()
    {
        return this.jenisKelamin;
    }
    public String getJilbab()
    {
        return this.jilbab;
    }
    public String getUkuranAtasan()
    {
        return this.ukuranAtasan;
    }
    public String getUkuranBawahan()
    {
        return this.ukuranBawahan;
    }
    public String getStatus()
    {
        return this.status;
    }
    
    public void setNim(String nim)
    {
        this.nim = nim;
    }
    public void setNama(String nama)
    {
        this.nama = nama;
    }
    public void setKelas(String kelas)
    {
        this.kelas = kelas;
    }
    public void setJenisKelamin(String jenisKelamin)
    {
        this.jenisKelamin = jenisKelamin;
    }
    public void setJilbab(String jilbab)
    {
        this.jilbab = jilbab;
    }
    public void setUkuranAtasan(String ukuranAtasan)
    {
        this.ukuranAtasan = ukuranAtasan;
    }
    public void setUkuranBawahan(String ukuranBawahan)
    {
        this.ukuranBawahan = ukuranBawahan;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }
    
}

