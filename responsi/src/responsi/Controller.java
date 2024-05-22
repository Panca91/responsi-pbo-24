/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package responsi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

/**
 *
 * @author M S I
 */
public class Controller {
    public Controller (View view, Model model) {
        view.getTambahButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    String judul = view.getJudul().getText();
                    String penulis = view.getPenulis().getText();
                    String ratingCheck = view.getRating().getText();
                    String hargaCheck = view.getHarga().getText();
                    float rating = Float.parseFloat(view.getRating().getText());
                    int hargaAwal = Integer.parseInt(view.getHarga().getText());
                    float harga = hargaAwal + 500 + (rating * 100);

                    // Error handling jika inputan ada yang kosong
                    if (judul.equals("") || penulis.equals("") || ratingCheck.equals("") || hargaCheck.equals("")) {
                       JOptionPane.showMessageDialog(null, "Inputan Tidak Boleh Kosong!");
                       return;
                    }

                    model.tambahData(judul, penulis, rating, harga);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                    JOptionPane.showMessageDialog(null, "Input Gagal!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        view.getEditButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String judul = view.getJudul().getText();
                String penulis = view.getPenulis().getText();
                String ratingCheck = view.getRating().getText();
                String hargaCheck = view.getHarga().getText();
                float rating = Float.parseFloat(view.getRating().getText());
                int hargaAwal = Integer.parseInt(view.getHarga().getText());
                float harga = hargaAwal + 500 + (rating * 100);
                String id = view.getId().getText();
                
                if (judul.equals("") || penulis.equals("") || ratingCheck.equals("") || hargaCheck.equals("")) {
                       JOptionPane.showMessageDialog(null, "Inputan Tidak Boleh Kosong!");
                       return;
                    }

                model.editData(judul, penulis, rating, harga, id);
            }
        });
        
        view.getHapusButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String id = view.getId().getText();

                    model.hapusData(id);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());

                }
            }
        });
        
        view.getShowButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String data[][];
                data = model.getDataBuku();

                view.getTabel().setModel(new DefaultTableModel(data, new String[]{
                    "Id", "Judul", "Penulis", "Rating", "Harga"
                }));
            }
        });
        
        view.getTabel().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int row = view.getTabel().getSelectedRow();
                
                String id = view.getTabel().getValueAt(row, 0).toString();
                String judul = view.getTabel().getValueAt(row, 1).toString();
                String penulis = view.getTabel().getValueAt(row, 2).toString();
                String rating = view.getTabel().getValueAt(row, 3).toString();
                String harga = view.getTabel().getValueAt(row, 4).toString();

                view.getId().setText(id);
                view.getJudul().setText(judul);
                view.getPenulis().setText(penulis);
                view.getRating().setText(rating);
                view.getHarga().setText(harga);
            }
        });
    }
    
}
