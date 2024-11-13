import java.util.*;

public class Sort {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Boolean lanjut = true;
        System.out.println("=========  P R O G R A M   S O R T I N G  =========");

        while (lanjut) { 
            System.out.println("\nMasukkan angka yang akan diurutkan: ");
            String inputAngka = input.nextLine();

            boolean validSort = true;
            while (validSort) {
                System.out.print("\n1. Insertion Sort\n2. Selection Sort\nPilih metode sorting:");
                int inputPilihan = input.nextInt();
                switch (inputPilihan) {
                    case 1 : 
                        InsertionSort(inputAngka);
                        validSort=false;
                        break;
                    case 2 : 
                        selectionSort(inputAngka);
                        validSort=false;
                        break;
                    default:
                        System.out.println("Pilihan tidak valid");
                        validSort=true;
                        break;
                }
            }
            
            boolean validLanjut = true;

            while (validLanjut) { 
                System.out.println("\nApakah anda ingin menggunakan program lagi? (y/n)");
                input.nextLine();
                String lanjutProgram = input.nextLine();
                switch (lanjutProgram) {
                    case "y" : 
                        validLanjut = false;
                        lanjut = true;
                        break;
                    case "n" : 
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

    public static void InsertionSort (String input){
        String[] inputStr = input.split(" ");
        
        int[] num = new int[inputStr.length];
        for (int i = 0; i < inputStr.length; i++) {
            num[i] = Integer.parseInt(inputStr[i]);
        }
        System.out.println("\nINSERTION SORT:");

        System.out.println("\nProses sorting:");
        System.out.println(Arrays.toString(num));
        for (int i = 1; i < num.length; i++) {
            int key = num[i];
            int j = i - 1;

            while (j >= 0 && num[j] > key) {
                num[j + 1] = num[j];
                j--;
            }

            num[j + 1] = key;
            System.out.println(Arrays.toString(num));  
        }

        System.out.println("\nHasil akhir: \n" + Arrays.toString(num));
    }

    public static void selectionSort (String input){
        String[] inputStr = input.split(" ");
        
        int[] num = new int[inputStr.length];
        for (int i = 0; i < inputStr.length; i++) {
            num[i] = Integer.parseInt(inputStr[i]);
        }
        System.out.println("\nSELECTION SORT:");

        System.out.println("\nProses sorting:");
        System.out.println(Arrays.toString(num));
        for (int i = 0; i < num.length - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < num.length; j++) {
                if (num[j] < num[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = num[minIndex];
            num[minIndex] = num[i];
            num[i] = temp;

            System.out.println(Arrays.toString(num));
        }

        System.out.println("\nHasil akhir: \n" + Arrays.toString(num));
    }
}
