package com.fera;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataMahasiswa {

    public static void main(String[] args) {
        List<Mahasiswa> arrayListMahasiswa = new ArrayList<>();

        Scanner input = new Scanner(System.in);

        int pilihan;

        do {
            showMenu();
            System.out.print("Pilih menu : ");
            pilihan = input.nextInt();

            if (pilihan == 1){
                Mahasiswa mahasiswa = new Mahasiswa();

                System.out.print("Nama : ");
                String NAMA = input.next();
                mahasiswa.getNama();

                System.out.print("NIM : ");
                String NIM = input.next();
                mahasiswa.getNim();

                System.out.print("Alamat : ");
                String ALAMAT = input.next();
                mahasiswa.getAlamat();

                mahasiswa.setNama(NAMA);
                mahasiswa.setNim(NIM);
                mahasiswa.setAlamat(ALAMAT);

                arrayListMahasiswa.add(mahasiswa);
            }

            else if (pilihan == 2){
                System.out.println("\n===Data Mahasiswa===");
                System.out.println("====================");

                for (int i = 0; i < arrayListMahasiswa.size(); i++) {
                    System.out.println(i + 1 + "." + arrayListMahasiswa.get(i).getNim());
                }
            }

            else if (pilihan == 3){
                int cari;

                System.out.println("\n===Data Mahasiswa===");
                System.out.println("====================");

                for (int i = 0; i < arrayListMahasiswa.size(); i++) {
                    System.out.println(i + 1 + "." + arrayListMahasiswa.get(i).getNim());
                }

                System.out.print("\nData nomor berapa yang ingin dicari : ");
                cari = input.nextInt();

                if (cari == 1){
                    System.out.println("\nNama : " + arrayListMahasiswa.get(0).getNama());
                    System.out.println("NIM : " + arrayListMahasiswa.get(0).getNim());
                    System.out.println("Alamat : " + arrayListMahasiswa.get(0).getAlamat());
                }

                else if (cari == 2){
                    System.out.println("\nNama : " + arrayListMahasiswa.get(1).getNama());
                    System.out.println("NIM : " + arrayListMahasiswa.get(1).getNim());
                    System.out.println("Alamat : " + arrayListMahasiswa.get(1).getAlamat());
                }

                else if (cari == 3){
                    System.out.println("\nNama : " + arrayListMahasiswa.get(2).getNama());
                    System.out.println("NIM : " + arrayListMahasiswa.get(2).getNim());
                    System.out.println("Alamat : " + arrayListMahasiswa.get(2).getAlamat());
                }

                else if (cari == 4){
                    System.out.println("\nNama : " + arrayListMahasiswa.get(3).getNama());
                    System.out.println("NIM : " + arrayListMahasiswa.get(3).getNim());
                    System.out.println("Alamat : " + arrayListMahasiswa.get(3).getAlamat());
                }

                else if (cari == 5){
                    System.out.println("\nNama : " + arrayListMahasiswa.get(4).getNama());
                    System.out.println("NIM : " + arrayListMahasiswa.get(4).getNim());
                    System.out.println("Alamat : " + arrayListMahasiswa.get(4).getAlamat());
                }

                else {
                    System.err.println("Data Tidak Ada!");
                }
            }

            else if (pilihan == 4){
                System.out.println("\n===Data Mahasiswa===");
                System.out.println("====================");

                for (int i = 0; i < arrayListMahasiswa.size(); i++) {
                    System.out.println(i + 1 + "." + arrayListMahasiswa.get(i).getNim());
                }

                System.out.print("\nMasukan NIM untuk menghapus : ");
                String NIM = input.next();

                for (int i = 0; i < arrayListMahasiswa.size(); i++) {
                    if (arrayListMahasiswa.get(i).getNim().equals(NIM)){
                        arrayListMahasiswa.remove(i);
                    }
                }
            }

            else if (pilihan == 5){
                System.out.println("Terima Kasih:)");
            }

            else {
                System.err.println("Menu Tidak Tersedia!");
            }
        }

        while (pilihan != 5);
    }

    public static void showMenu(){
        System.out.println("\n=====Aplikasi Data Mahasiswa=====");
        System.out.println("=================================");

        System.out.println("1.Tambahkan Data Mahasiswa");
        System.out.println("2.Tampilkan Data Mahasiswa");
        System.out.println("3.Cari Data Mahasiswa");
        System.out.println("4.Hapus Data Mahasiswa");
        System.out.println("5.Keluar");
        System.out.println();
    }
}
