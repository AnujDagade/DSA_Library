import lib.sorting.Bubble;
import lib.sorting.Quick;
import lib.sorting.Sortable;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static <T> void display(T[] arr) {
        for (T i : arr) {
            System.out.print(" " + i);
        }
        System.out.println();
    }


    public static void main(String[] args) {
        System.out.println("Hello world!");
        Integer[] arr = {4, 3, 4, 6, 2, 1};
        System.out.println("Original array");
        display(arr);


        Scanner sc = new Scanner(System.in);
        int choice = 0;
        while (true) {

            System.out.println("Please select an option:");
            System.out.println("0. Exit");
            System.out.println("9. Reset array");
            System.out.println("1. Sort using Bubble Sort");
            System.out.println("2. Sort using Quick Sort");

            try {
                choice = sc.nextInt();
            } catch (InputMismatchException e) {
                System.err.println(e.toString());
                System.out.println("Please enter only numbers!");
                sc.nextLine();
                continue;
            } catch (NoSuchElementException e) {
                System.out.println("No more elements");
                System.err.println(e.getMessage());
            }

            switch (choice) {
                case 0:
                    System.out.println("Goodbye");
                    System.exit(0);
                    sc.close();
                    break;
                case 1:
                    Sortable obj = new Bubble<Integer>(arr);
                    obj.sort();
                    display(arr);
                    break;
                case 2:
                    Sortable qk = new Quick<Integer>(arr);
                    qk.sort();
                    display(arr);
                    break;
                case 9:
                    arr = new Random().ints(100, 0, 1000)
                            .mapToObj(Integer::valueOf).toArray(Integer[]::new);
                    display(arr);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }


    }
}