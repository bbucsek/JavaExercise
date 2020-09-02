package com.untitled.untitled;

import com.untitled.untitled.Algorithms.Sorting.BubbleSort;
import com.untitled.untitled.Algorithms.Sorting.InsertionSort;
import com.untitled.untitled.Algorithms.Sorting.SelectionSort;
import com.untitled.untitled.DataStructures.DataBinarySearchTree;
import com.untitled.untitled.DataStructures.DataHashMap;
import com.untitled.untitled.DesignPatterns.Payment;
import com.untitled.untitled.DesignPatterns.PaymentBuilder;

import java.util.stream.Stream;

public class Try {

    public void letsSee() {
        DataHashMap<String, Integer> map = new DataHashMap<>();
        for (int i = 0; i < 50000; i++) {
            map.put(String.valueOf(i), i);
        }
        System.out.println("null arr" + " " + map.getNullArr());
        System.out.println("cap" + " " + map.getCapacity());
        for (int i = 0; i < 20000; i++) {
            map.remove(String.valueOf(i));
        }
        System.out.println("null arr" + " " + map.getNullArr());
        System.out.println("cap" + " " + map.getCapacity());
        for (int i = 0; i < 50000; i++) {
            map.put(String.valueOf(i), i);
        }
        System.out.println("null arr" + " " + map.getNullArr());
        System.out.println("cap" + " " + map.getCapacity());
    }

    public static void main(String[] args) {
        Integer[] array = {5, 4, 3, 1, 2, 10, 6};


        //Payment payment = Payment.builder().loan(200).salary(500).tax(300).build();
        //System.out.println(payment.getLoan() + " " + payment.getSalary() + " " + payment.getTax());

        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort(array);
        for (Integer num : array) {
            System.out.println(num);
        }

    }
}




