package com.example.bai01;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class SoNguyenToActivity extends AppCompatActivity {

    private EditText editTextNumbers;
    private Button btnCheckPrime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_so_nguyen_to); // Layout cho Activity này

        editTextNumbers = findViewById(R.id.editTextNumbers);
        btnCheckPrime = findViewById(R.id.btnCheckPrime);


        btnCheckPrime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String input = editTextNumbers.getText().toString();

                // Kiểm tra nếu người dùng không nhập gì
                if (input.isEmpty()) {
                    Toast.makeText(SoNguyenToActivity.this, "Vui lòng nhập các số", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Tách chuỗi nhập vào thành mảng các số
                List<Integer> numbers = parseNumbers(input);


                for (Integer number : numbers) {
                    if (isPrime(number)) {
                        Log.d("PrimeNumbers", "Số nguyên tố: " + number);
                    } else {
                        Log.d("PrimeNumbers", "Không phải số nguyên tố: " + number);
                    }
                }
            }
        });
    }

    // Hàm tách chuỗi
    private List<Integer> parseNumbers(String input) {
        List<Integer> numbers = new ArrayList<>();
        String[] parts = input.split(","); // Tách theo dấu phẩy
        for (String part : parts) {
            try {
                numbers.add(Integer.parseInt(part.trim())); // Thêm số vào danh sách
            } catch (NumberFormatException e) {
                // Nếu chuỗi không thể chuyển thành số nguyên, bỏ qua
                Log.e("InputError", "Không thể chuyển chuỗi thành số: " + part);
            }
        }
        return numbers;
    }

    // Hàm kiểm tra số nguyên tố
    private boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
