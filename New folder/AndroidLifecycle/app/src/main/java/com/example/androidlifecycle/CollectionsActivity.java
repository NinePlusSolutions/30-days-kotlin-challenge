package com.example.androidlifecycle;

import static java.sql.DriverManager.println;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class CollectionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collections);



        ArrayList<Integer> numbers = new ArrayList<Integer>();

        // Thêm các số nguyên vào danh sách
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        // Hiển thị danh sách số nguyên
        println("Numbers: " + numbers);
        Log.i("numbers",numbers.toString());

        // Lấy số nguyên tại vị trí 1
        int secondNumber = numbers.get(1);
        String num=String.valueOf(secondNumber);
        println("Second number: " + secondNumber);
        Log.d("second number",num);
        // Xóa số nguyên tại vị trí 2
        numbers.remove(2);

        // Thay thế số nguyên tại vị trí 0 bằng số 4
        numbers.set(0, 4);

        // Hiển thị danh sách số nguyên cập nhật
        println("Update number: "+numbers);
        Log.d("Update nummber",numbers.toString());





///LinkedList

        //
        LinkedList<Integer> numberslinked = new LinkedList<Integer>();

        // Thêm phần tử vào cuối danh sách
        numberslinked.add(1);
        numberslinked.add(2);
        numberslinked.add(3);

        // Thêm phần tử vào vị trí chỉ định trong danh sách
        numberslinked.add(1, 5);

        // Truy cập phần tử trong danh sách
        int second = numberslinked.get(1);

        // Loại bỏ phần tử ở vị trí chỉ định trong danh sách
        numberslinked.remove(0);

        // Hiển thị số lượng phần tử trong danh sách
        System.out.println("Size of list: " + numberslinked.size());

        // Lặp qua danh sách và hiển thị các phần tử
        for (int number : numberslinked) {
            System.out.println(number);
        }




        ///HashSet
        HashSet<String> set = new HashSet<String>();
        set.add("apple");
        set.add("banana");
        set.add("orange");
        set.add("apple"); // Thêm lại "apple", nhưng nó không được thêm vào
        System.out.println(set); // In ra [orange, banana, apple]
    }
}