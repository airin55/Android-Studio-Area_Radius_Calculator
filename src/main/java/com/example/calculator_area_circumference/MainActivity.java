package com.example.calculator_area_circumference;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextSide;
    private EditText editTextBase;
    private EditText editTextHeight;
    private EditText editTextRadius;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextSide = findViewById(R.id.editTextSide);
        editTextBase = findViewById(R.id.editTextBase);
        editTextHeight = findViewById(R.id.editTextHeight);
        editTextRadius = findViewById(R.id.editTextRadius);

        Button buttonCalculateSquare = findViewById(R.id.buttonCalculateSquare);
        Button buttonCalculateTriangle = findViewById(R.id.buttonCalculateTriangle);
        Button buttonCalculateCircle = findViewById(R.id.buttonCalculateCircle);
        Button buttonCalculateRectangle = findViewById(R.id.buttonCalculateRectangle);

        buttonCalculateSquare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateSquareArea();
            }
        });

        buttonCalculateTriangle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateTriangleArea();
            }
        });

        buttonCalculateCircle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateCircleArea();
            }
        });

        buttonCalculateRectangle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateRectangleArea();
            }
        });
    }

    private void calculateSquareArea() {
        String sideStr = editTextSide.getText().toString().trim();

        if (sideStr.isEmpty()) {
            showToast("Please enter the side length.");
            return;
        }

        double side = Double.parseDouble(sideStr);
        double area = side * side;
        showResult("Square", area);
    }

    private void calculateTriangleArea() {
        String baseStr = editTextBase.getText().toString().trim();
        String heightStr = editTextHeight.getText().toString().trim();

        if (baseStr.isEmpty() || heightStr.isEmpty()) {
            showToast("Please enter both base length and height.");
            return;
        }

        double base = Double.parseDouble(baseStr);
        double height = Double.parseDouble(heightStr);
        double area = 0.5 * base * height;
        showResult("Triangle", area);
    }

    private void calculateCircleArea() {
        String radiusStr = editTextRadius.getText().toString().trim();

        if (radiusStr.isEmpty()) {
            showToast("Please enter the radius.");
            return;
        }

        double radius = Double.parseDouble(radiusStr);
        double area = Math.PI * radius * radius;
        showResult("Circle", area);
    }

    private void calculateRectangleArea() {
        String lengthStr = editTextSide.getText().toString().trim();
        String widthStr = editTextHeight.getText().toString().trim();

        if (lengthStr.isEmpty() || widthStr.isEmpty()) {
            showToast("Please enter both length and width.");
            return;
        }

        double length = Double.parseDouble(lengthStr);
        double width = Double.parseDouble(widthStr);
        double area = length * width;
        showResult("Rectangle", area);
    }

    private void showResult(String shape, double area) {
        String result = shape + " Area: " + area;
        showToast(result);
        Log.d("AreaCalculator", result);
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
