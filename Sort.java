import java.util.*;

public class Sort {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean lanjut = true;
        System.out.println("=======  P R O G R A M   S O R T I N G  I P K  =======");

        while (lanjut) { 
            System.out.println("\nMasukkan jumlah mata kuliah yang akan diurutkan: ");
            int jumlahMatkul = input.nextInt();
            input.nextLine(); 
            String[][] nilai = new String[jumlahMatkul][2];
            for (int i = 0; i < jumlahMatkul; i++) {
                System.out.println("Masukkan Mata Kuliah: ");
                nilai[i][0] = input.nextLine();
                System.out.println("Masukkan Nilai Mata Kuliah (gunakan desimal jika diperlukan): ");
                nilai[i][1] = input.nextLine();
            }

            boolean validSort = true;
            while (validSort) {
                System.out.print("\n1. Insertion Sort\n2. Selection Sort\nPilih metode sorting: ");
                int inputPilihan = input.nextInt();
                input.nextLine(); 
                switch (inputPilihan) {
                    case 1: 
                        insertionSort(nilai);
                        validSort = false;
                        break;
                    case 2: 
                        selectionSort(nilai);
                        validSort = false;
                        break;
                    default:
                        System.out.println("Pilihan tidak valid");
                        validSort = true;
                        break;
                }
            }
            
            boolean validLanjut = true;
            while (validLanjut) { 
                System.out.println("\nApakah Anda ingin menggunakan program lagi? (y/n)");
                String lanjutProgram = input.nextLine();
                switch (lanjutProgram) {
                    case "y": 
                        validLanjut = false;
                        lanjut = true;
                        break;
                    case "n": 
                        validLanjut = false;
                        lanjut = false;
                        break;
                    default:
                        System.out.println("Pilihan tidak valid");
                        validLanjut = true;
                        break;
                }
            }
        }
    }

    public static void insertionSort(String[][] input) {
        double totalNilai = 0.0;
        
        System.out.println("\nProses Insertion Sort:");
        printArray(input);
        for (int i = 1; i < input.length; i++) {
            String[] key = input[i];
            double keyValue = Double.parseDouble(key[1]);
            int j = i - 1;

            while (j >= 0 && Double.parseDouble(input[j][1]) > keyValue) {
                input[j + 1] = input[j];
                j--;
            }
            input[j + 1] = key;

            printArray(input);
        }
        
        System.out.println("\nHasil akhir Insertion Sort:");
        for (String[] matkul : input) {
            System.out.println("Mata Kuliah: " + matkul[0] + ", Nilai: " + matkul[1]);
            totalNilai += Double.parseDouble(matkul[1]);
        }
        
        double rataRata = totalNilai / input.length;
        System.out.printf("\n IPK: %.2f\n",rataRata);
    }

    public static void selectionSort(String[][] input) {
        double totalNilai = 0.0;

        
        System.out.println("\nProses Selection Sort:");
        printArray(input);
        for (int i = 0; i < input.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < input.length; j++) {
                if (Double.parseDouble(input[j][1]) < Double.parseDouble(input[minIndex][1])) {
                    minIndex = j;
                }
            }
            
            String[] temp = input[minIndex];
            input[minIndex] = input[i];
            input[i] = temp;

            printArray(input);
        }
        
        System.out.println("\nHasil akhir Selection Sort:");
        for (String[] matkul : input) {
            System.out.println("Mata Kuliah: " + matkul[0] + ", Nilai: " + matkul[1]);
            totalNilai += Double.parseDouble(matkul[1]);
        }
        
        double rataRata = totalNilai / input.length;
        System.out.printf("\n IPK: %.2f\n",rataRata);
    }

    public static void printArray(String[][] array) {
        for (String[] row : array) {
            System.out.print("[" + row[0] + ": " + row[1] + "] ");
        }
        System.out.println();
    }
}
