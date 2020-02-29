package com.example.mobiledeeplearning;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.nd4j.linalg.api.ndarray.INDArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * Date : 2020.03.01 03:50
 * Copywrite : Cheonsol Lee
 * Contents : Mobile DeepLearning
 *
 * */


public class MainActivity extends AppCompatActivity {
    private String trainState = null;
    private String testState = null;
    private String resultNumber = null;
    private Button btn_start;
    private Button btn_reset;
    private Button btn_train_100;
    private Button btn_train_200;
    private Button btn_train_300;
    private Button btn_train_400;
    private Button btn_train_500;
    private Button btn_train_600;
    private ImageButton btn_num_0;
    private ImageButton btn_num_1;
    private ImageButton btn_num_2;
    private ImageButton btn_num_3;
    private ImageButton btn_num_4;
    private ImageButton btn_num_5;
    private ImageButton btn_num_6;
    private ImageButton btn_num_7;
    private ImageButton btn_num_8;
    private ImageButton btn_num_9;
    private TextView tv_prob_0;
    private TextView tv_prob_1;
    private TextView tv_prob_2;
    private TextView tv_prob_3;
    private TextView tv_prob_4;
    private TextView tv_prob_5;
    private TextView tv_prob_6;
    private TextView tv_prob_7;
    private TextView tv_prob_8;
    private TextView tv_prob_9;
    private TextView tv_result;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_start = (Button) findViewById(R.id.btn_start);
        btn_reset = (Button) findViewById(R.id.btn_reset);
        btn_train_100 = (Button) findViewById(R.id.btn_train_100);
        btn_train_200 = (Button) findViewById(R.id.btn_train_200);
        btn_train_300 = (Button) findViewById(R.id.btn_train_300);
        btn_train_400 = (Button) findViewById(R.id.btn_train_400);
        btn_train_500 = (Button) findViewById(R.id.btn_train_500);
        btn_train_600 = (Button) findViewById(R.id.btn_train_600);
        btn_num_0 = (ImageButton) findViewById(R.id.btn_num_0);
        btn_num_1 = (ImageButton) findViewById(R.id.btn_num_1);
        btn_num_2 = (ImageButton) findViewById(R.id.btn_num_2);
        btn_num_3 = (ImageButton) findViewById(R.id.btn_num_3);
        btn_num_4 = (ImageButton) findViewById(R.id.btn_num_4);
        btn_num_5 = (ImageButton) findViewById(R.id.btn_num_5);
        btn_num_6 = (ImageButton) findViewById(R.id.btn_num_6);
        btn_num_7 = (ImageButton) findViewById(R.id.btn_num_7);
        btn_num_8 = (ImageButton) findViewById(R.id.btn_num_8);
        btn_num_9 = (ImageButton) findViewById(R.id.btn_num_9);
        tv_prob_0 = (TextView) findViewById(R.id.tv_prob_0);
        tv_prob_1 = (TextView) findViewById(R.id.tv_prob_1);
        tv_prob_2 = (TextView) findViewById(R.id.tv_prob_2);
        tv_prob_3 = (TextView) findViewById(R.id.tv_prob_3);
        tv_prob_4 = (TextView) findViewById(R.id.tv_prob_4);
        tv_prob_5 = (TextView) findViewById(R.id.tv_prob_5);
        tv_prob_6 = (TextView) findViewById(R.id.tv_prob_6);
        tv_prob_7 = (TextView) findViewById(R.id.tv_prob_7);
        tv_prob_8 = (TextView) findViewById(R.id.tv_prob_8);
        tv_prob_9 = (TextView) findViewById(R.id.tv_prob_9);
        tv_result = (TextView) findViewById(R.id.tv_result);

        defaultButtonAllColor();

//        clickListener
        btn_start.setOnClickListener(clickListener);
        btn_reset.setOnClickListener(clickListener);
        btn_train_100.setOnClickListener(clickListener);
        btn_train_200.setOnClickListener(clickListener);
        btn_train_300.setOnClickListener(clickListener);
        btn_train_400.setOnClickListener(clickListener);
        btn_train_500.setOnClickListener(clickListener);
        btn_train_600.setOnClickListener(clickListener);
        btn_num_0.setOnClickListener(clickListener);
        btn_num_1.setOnClickListener(clickListener);
        btn_num_2.setOnClickListener(clickListener);
        btn_num_3.setOnClickListener(clickListener);
        btn_num_4.setOnClickListener(clickListener);
        btn_num_5.setOnClickListener(clickListener);
        btn_num_6.setOnClickListener(clickListener);
        btn_num_7.setOnClickListener(clickListener);
        btn_num_8.setOnClickListener(clickListener);
        btn_num_9.setOnClickListener(clickListener);
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                //Training set 버튼 색상
                case R.id.btn_train_100: {
                    defaultTrainButtonColor();
                    btn_train_100.setBackgroundColor(Color.RED);
                    trainState = "100";
                    break;
                }
                case R.id.btn_train_200: {
                    defaultTrainButtonColor();
                    btn_train_200.setBackgroundColor(Color.RED);
                    trainState = "200";
                    break;
                }
                case R.id.btn_train_300: {
                    defaultTrainButtonColor();
                    btn_train_300.setBackgroundColor(Color.RED);
                    trainState = "300";
                    break;
                }
                case R.id.btn_train_400: {
                    defaultTrainButtonColor();
                    btn_train_400.setBackgroundColor(Color.RED);
                    trainState = "400";
                }
                case R.id.btn_train_500: {
                    defaultTrainButtonColor();
                    btn_train_500.setBackgroundColor(Color.RED);
                    trainState = "500";
                    break;
                }
                case R.id.btn_train_600: {
                    defaultTrainButtonColor();
                    btn_train_600.setBackgroundColor(Color.RED);
                    trainState = "600";
                    break;
                }


                //Test버튼
                case R.id.btn_num_0: {
                    defaultTestButtonColor();
                    btn_num_0.setBackgroundColor(Color.RED);
                    testState = "0";
                    break;
                }
                case R.id.btn_num_1: {
                    defaultTestButtonColor();
                    btn_num_1.setBackgroundColor(Color.RED);
                    testState = "1";
                    break;
                }
                case R.id.btn_num_2: {
                    defaultTestButtonColor();
                    btn_num_2.setBackgroundColor(Color.RED);
                    testState = "2";
                    break;
                }
                case R.id.btn_num_3: {
                    defaultTestButtonColor();
                    btn_num_3.setBackgroundColor(Color.RED);
                    testState = "3";
                    break;
                }
                case R.id.btn_num_4: {
                    defaultTestButtonColor();
                    btn_num_4.setBackgroundColor(Color.RED);
                    testState = "4";
                    break;
                }
                case R.id.btn_num_5: {
                    defaultTestButtonColor();
                    btn_num_5.setBackgroundColor(Color.RED);
                    testState = "5";
                    break;
                }
                case R.id.btn_num_6: {
                    defaultTestButtonColor();
                    btn_num_6.setBackgroundColor(Color.RED);
                    testState = "6";
                    break;
                }
                case R.id.btn_num_7: {
                    defaultTestButtonColor();
                    btn_num_7.setBackgroundColor(Color.RED);
                    testState = "7";
                    break;
                }
                case R.id.btn_num_8: {
                    defaultTestButtonColor();
                    btn_num_8.setBackgroundColor(Color.RED);
                    testState = "8";
                    break;
                }
                case R.id.btn_num_9: {
                    defaultTestButtonColor();
                    btn_num_9.setBackgroundColor(Color.RED);
                    testState = "9";
                    break;
                }


                case R.id.btn_reset: {
                    resultNumber = "?";
                    tv_result.setText("?");
                    tv_prob_0.setText("0");
                    tv_prob_1.setText("1");
                    tv_prob_2.setText("2");
                    tv_prob_3.setText("3");
                    tv_prob_4.setText("4");
                    tv_prob_5.setText("5");
                    tv_prob_6.setText("6");
                    tv_prob_7.setText("7");
                    tv_prob_8.setText("8");
                    tv_prob_9.setText("9");
                    defaultButtonAllColor();
                    Toast.makeText(MainActivity.this, "Reset", Toast.LENGTH_SHORT).show();
                    break;
                }

                case R.id.btn_start: {
                    btn_start.setBackgroundColor(Color.RED);
                    btn_reset.setBackgroundColor(Color.GRAY);

                    MLP();

                    break;
                }

            }
        }
    };

    private void defaultTrainButtonColor() {
        btn_train_100.setBackgroundColor(Color.GRAY);
        btn_train_200.setBackgroundColor(Color.GRAY);
        btn_train_300.setBackgroundColor(Color.GRAY);
        btn_train_400.setBackgroundColor(Color.GRAY);
        btn_train_500.setBackgroundColor(Color.GRAY);
        btn_train_600.setBackgroundColor(Color.GRAY);
    }

    private void defaultTestButtonColor() {
        btn_num_0.setBackgroundColor(Color.GRAY);
        btn_num_1.setBackgroundColor(Color.GRAY);
        btn_num_2.setBackgroundColor(Color.GRAY);
        btn_num_3.setBackgroundColor(Color.GRAY);
        btn_num_4.setBackgroundColor(Color.GRAY);
        btn_num_5.setBackgroundColor(Color.GRAY);
        btn_num_6.setBackgroundColor(Color.GRAY);
        btn_num_7.setBackgroundColor(Color.GRAY);
        btn_num_8.setBackgroundColor(Color.GRAY);
        btn_num_9.setBackgroundColor(Color.GRAY);
    }


    // button color default
    private void defaultButtonAllColor() {
        defaultTrainButtonColor();
        defaultTestButtonColor();

        btn_start.setBackgroundColor(Color.GRAY);
        btn_reset.setBackgroundColor(Color.GRAY);
    }

    public void MLP() {
        //딥러닝 소스
        int input_nodes = 784;
        int hidden_nodes = 200;
        int output_nodes = 10;

        double learning_rate = 0.1;

        NeuralNetwork neuralNetwork = new NeuralNetwork(input_nodes, hidden_nodes, output_nodes, learning_rate);

        Log.i("MLP_in", "MLP");
        long learn_start = System.currentTimeMillis();

        // <1. 학습데이터 가져오기>
        List<List<String>> trainData = null;
        String fileName1 = "mnist_train_" + trainState + ".csv";
        try {
            trainData = csvFileReadingFunc(fileName1);
            Log.i("trainData", "success");
        } catch (IOException e) {
            Log.i("testData", "failed");
            e.printStackTrace();
        }
        int epochs = 1;

        // <2. 신경망 학습>
        Toast.makeText(MainActivity.this, "Learning START", Toast.LENGTH_SHORT).show();
        for (int i = 0; i < epochs; i++) {
            for (int j = 0; j < trainData.size(); j++) {
                Log.i("trainSeq", String.valueOf(j));

                List<String> currentRow = trainData.get(j);
                List<Double> inputs = inputRangeSetting(currentRow, 785);
                List<Double> targets;

                // 결과값 one-hot인코딩
                targets = new ArrayList<>(Collections.nCopies(10, 0.01));
                int resultIndex = Integer.parseInt(currentRow.get(0));
                targets.set(resultIndex, 0.99);

                neuralNetwork.train(inputs, targets);

            }
        }

        // <3. 테스트데이터 가져오기>
        List<List<String>> testData = null;
        String fileName2 = "mnist_test_" + testState + ".csv";
        try {
            testData = csvFileReadingFunc(fileName2);
            Log.i("testData", "success");
        } catch (IOException e) {
            Log.i("testData", "failed");
            e.printStackTrace();
        }

        // <4. 신경망 테스트>
        Toast.makeText(MainActivity.this, "Testing START", Toast.LENGTH_SHORT).show();
        List<Integer> scoreCard = new ArrayList<>();

        for (int i = 0; i < testData.size(); i++) {
//            System.out.println("테스트순서:" + i);
            Log.i("testSeq", String.valueOf(i));

            List<String> currentRow = testData.get(i);
            int correctLabel = Integer.parseInt(currentRow.get(0));
            List<Double> inputs = inputRangeSetting(currentRow, 785);
            INDArray outputs = neuralNetwork.query(inputs);

            resultNumber = String.valueOf(argmaxFunc(outputs));

            // <5. 정확도 출력>

            tv_prob_0.setText(String.format("%.2f", outputs.getDouble(0)*100));
            tv_prob_1.setText(String.format("%.2f", outputs.getDouble(1)*100));
            tv_prob_2.setText(String.format("%.2f", outputs.getDouble(2)*100));
            tv_prob_3.setText(String.format("%.2f", outputs.getDouble(3)*100));
            tv_prob_4.setText(String.format("%.2f", outputs.getDouble(4)*100));
            tv_prob_5.setText(String.format("%.2f", outputs.getDouble(5)*100));
            tv_prob_6.setText(String.format("%.2f", outputs.getDouble(6)*100));
            tv_prob_7.setText(String.format("%.2f", outputs.getDouble(7)*100));
            tv_prob_8.setText(String.format("%.2f", outputs.getDouble(8)*100));
            tv_prob_9.setText(String.format("%.2f", outputs.getDouble(9)*100));
        }


        // <6. 결과 출력>
        tv_result.setText(resultNumber);

    }


    //CSV파일 읽기
    private List<List<String>> csvFileReadingFunc(String fileName) throws IOException {
        InputStream is = getAssets().open(fileName);
        InputStreamReader isReader = new InputStreamReader(is);
        BufferedReader reader = new BufferedReader(isReader);

        String line;
        List<List<String>> result = new ArrayList<>();

        while ((line = reader.readLine()) != null) {
            //CSV 1행을 저장하는 리스트
            List<String> tmpList;
            String array[] = line.split(",");

            //배열에서 리스트 반환
            tmpList = Arrays.asList(array);
            result.add(tmpList);
        }

        return result;
    }

    //평균구하기
    public static double averageFunc(List<Integer> array) {
        double sum = 0.0;

        for (int i = 0; i < array.size(); i++)
            sum += array.get(i);

        return sum / array.size();
    }

    public static int argmaxFunc(INDArray array) {
        int index = 0;
        double value = array.getDouble(0);
        for (int i = 1; i < array.length(); i++) {
            if (value < array.getDouble(i)) {
                value = array.getDouble(i);
                index = i;
            }
        }
        return index;
    }

    //입력 범위 조정(0.01~1.00)
    private static List<Double> inputRangeSetting(List<String> values, int num) {
        List<String> tmp = values.subList(1, num);
        List<Double> input = new ArrayList<>();
        for (int i = 0; i < tmp.size(); i++) {
            double value = Double.valueOf(tmp.get(i));
            input.add((value / 255.0 * 0.99) + 0.01);
        }

        return input;
    }

}