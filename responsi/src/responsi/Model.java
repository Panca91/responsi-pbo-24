/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package responsi;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author M S I
 */
public class Model extends Connector{
    
    public int getJumlahData() {
        int jumlah = 0;
        try {
            String query = "SELECT * FROM buku";
            statement = koneksi.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                jumlah++;
            }
            return jumlah;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return jumlah;
        }
    }
    
    public String[][] getDataBuku() {
        String data[][] = new String[getJumlahData()][7];
        try {
            int index = 0;
            String query = "SELECT * FROM buku";
            statement = koneksi.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                data[index][0] = resultSet.getString("judul");
                data[index][1] = resultSet.getString("penulis");
                data[index][2] = resultSet.getString("rating");
                data[index][3] = resultSet.getString("harga");
                data[index][4] = resultSet.getString("id");
                index++;
            }
            return data;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return data;
        }
    }
    
    public void tambahData(String judul, String penulis, float rating, float harga) {
        try {
            String query = "INSERT INTO `buku` (`judul`,`penulis`,`rating`,`harga`) VALUES (?,?,?,?)";
            prepare = koneksi.prepareStatement(query);
            prepare.setString(1, judul);
            prepare.setString(2, penulis);
            prepare.setFloat(3, rating);
            prepare.setFloat(4, harga);

            prepare.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
    
    public void editData(String judul, String penulis, float rating, float harga, String id){
        try {
            String query = "UPDATE `buku` SET "
                    + "`judul` = '" + judul + "',"
                    + "`penulis` = '" + penulis + "' ,"
                    + "`penerbit` = '" + rating + "',"
                    + "`lokasi` = '" + harga + "',"
                    + "WHERE `id` = '" + id + "'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            statement.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil Diedit!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void hapusData(String id){
        try{
            String query =  "DELETE FROM `buku` WHERE `id` = '"+ id +"'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus!");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
