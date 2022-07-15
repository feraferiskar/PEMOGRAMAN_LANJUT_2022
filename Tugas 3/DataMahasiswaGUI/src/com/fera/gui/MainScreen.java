package com.fera.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class MainScreen extends JFrame{
    private JPanel panelMain;
    private JList jListMahasiswa;
    private JTextField textFieldFilter;
    private JButton filterButton;
    private JTextField textFieldNama;
    private JTextField textFieldNim;
    private JTextField textFieldIpk;
    private JButton saveButton;
    private JButton deleteButton;
    private JButton clearButton;

    List<Mahasiswa> arrayListmahasiswa = new ArrayList<>();

    DefaultListModel defaultListModel = new DefaultListModel();
    class Mahasiswa{
        public String getNama() {
            return nama;
        }

        public void setNama(String nama) {
            this.nama = nama;
        }

        public String getNim() {
            return nim;
        }

        public void setNim(String nim) {
            this.nim = nim;
        }

        public float getIpk() {
            return ipk;
        }

        public void setIpk(float ipk) {
            this.ipk = ipk;
        }

        private String nama;
        private String nim;
        private float ipk;
    }

    public void refreshListmodel(List<String> list){
        defaultListModel.clear();
        defaultListModel.addAll(list);
        jListMahasiswa.setModel(defaultListModel);
    }

    public void fromListMahasiswaToListModel(){
        List<String> listNamaMahasiswa = new ArrayList<>();

        for (int i = 0; i < arrayListmahasiswa.size(); i++) {
            listNamaMahasiswa.add(
                    arrayListmahasiswa.get(i).getNama()
            );
        }

        refreshListmodel(listNamaMahasiswa);
    }

    public void clearForm(){
        textFieldNama.setText("");
        textFieldNim.setText("");
        textFieldIpk.setText("");
    }

    public MainScreen(){
        super("Data Mahasiswa");
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama = textFieldNama.getText();
                String nim = textFieldNim.getText();
                float ipk = Float.parseFloat(textFieldIpk.getText());

                Mahasiswa mahasiswa = new Mahasiswa();

                mahasiswa.setNama(nama);
                mahasiswa.setNim(nim);
                mahasiswa.setIpk(ipk);

                arrayListmahasiswa.add(mahasiswa);
                clearForm();

                fromListMahasiswaToListModel();
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearForm();
            }
        });

        jListMahasiswa.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);

                int index = jListMahasiswa.getSelectedIndex();

                if (index < 0)
                    return;

                String nama = jListMahasiswa.getSelectedValue().toString();

                for (int i = 0; i < arrayListmahasiswa.size(); i++) {
                    if (arrayListmahasiswa.get(i).getNama().equals(nama)){
                        Mahasiswa mahasiswa = arrayListmahasiswa.get(i);

                        textFieldNama.setText(mahasiswa.getNama());
                        textFieldNim.setText(mahasiswa.getNim());
                        textFieldIpk.setText(String.valueOf(mahasiswa.getIpk()));
                        break;
                    }
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = jListMahasiswa.getSelectedIndex();

                if (index < 0){
                    return;
                }

                String nama = jListMahasiswa.getSelectedValue().toString();

                for (int i = 0; i < arrayListmahasiswa.size(); i++) {
                    if (arrayListmahasiswa.get(i).getNama().equals(nama)){
                        arrayListmahasiswa.remove(i);
                    }
                }

                clearForm();
                fromListMahasiswaToListModel();
            }
        });

        filterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String keyWord = textFieldFilter.getText();

                List<String> filter = new ArrayList<>();

                for (int i = 0; i < arrayListmahasiswa.size(); i++) {
                    if (arrayListmahasiswa.get(i).getNama().contains(keyWord)){
                        filter.add(arrayListmahasiswa.get(i).getNama());
                    }
                }

                refreshListmodel(filter);
            }
        });
    }

    public static void main(String[] args) {
        MainScreen mainScreen = new MainScreen();
        mainScreen.setVisible(true);
    }
}
