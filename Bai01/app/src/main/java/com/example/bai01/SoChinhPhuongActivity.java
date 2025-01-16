package com.example.bai01;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SoChinhPhuongActivity extends AppCompatActivity {

    private EditText editTextSize;
    private Button btnGenerateCheck;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_so_chinh_phuong);

        // Ánh xạ các thành phần UI
        editTextSize = findViewById(R.id.editTextSize);
        btnGenerateCheck = findViewById(R.id.btnGenerateCheck);
        textViewResult = findViewById(R.id.textViewResult);

        // Đặt sự kiện cho Button
        btnGenerateCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy số phần tử mảng nhập vào
                String sizeInput = editTextSize.getText().toString();

                // Kiểm tra nếu người dùng không nhập số phần tử
                if (sizeInput.isEmpty()) {
                    Toast.makeText(SoChinhPhuongActivity.this, "Vui lòng nhập số phần tử mảng", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Chuyển số phần tử nhập vào thành int
                int size = Integer.parseInt(sizeInput);

                // Tạo mảng số ngẫu nhiên
                List<Integer> numbers = generateRandomNumbers(size);

                // Hiển thị mảng số lên TextView
                textViewResult.setText("Mảng số ngẫu nhiên: " + numbers.toString());

                // Kiểm tra và hiển thị các số chính phương
                for (Integer number : numbers) {
                    if (isPerfectSquare(number)) {
                        Toast.makeText(SoChinhPhuongActivity.this, "Số chính phương: " + number, Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    // Hàm kiểm tra số chính phương
    private boolean isPerfectSquare(int num) {
        double sqrt = Math.sqrt(num);
        return sqrt == (int) sqrt; // Kiểm tra nếu căn bậc 2 của số là số nguyên
    }

    // Hàm tạo mảng số ngẫu nhiên
    private List<Integer> generateRandomNumbers(int size) {
        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            numbers.add(random.nextInt(100)); // Sinh số ngẫu nhiên từ 0 đến 99
        }

        return numbers;
    }
}
