package com.example.mobiledeeplearning;

import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import org.nd4j.linalg.ops.transforms.Transforms;

import java.util.List;

public class NeuralNetwork {
    private static int inodes; // 입력층 노드수
    private static int hnodes; // 은닉층 노드수
    private static int onodes; // 출력층 노드수
    private static double lr;     // 학습률
    private static INDArray wih;    // 가중치1(input-hidden)
    private static INDArray who;    // 가중치2(hidden-output)

    public NeuralNetwork(int inputnodes, int hiddennodes, int outputnodes, double learningrate){
        // 입력, 은닉, 출력 계층의 노드 개수 설정
        this.inodes = inputnodes;
        this.hnodes = hiddennodes;
        this.onodes = outputnodes;

        //편차분의 1
        double wihDeviation = Math.pow(this.hnodes, -0.5);
        double whoDeviation = Math.pow(this.onodes, -0.5);

        // 가중치 행렬 wih, who 초기화
        this.wih = Nd4j.randn(this.hnodes, this.inodes).mul(wihDeviation);
        this.who = Nd4j.randn(this.onodes, this.hnodes).mul(whoDeviation);

        // 학습률
        this.lr = learningrate;
    }

    // 학습
    public void train(List<Double> inputs_list, List<Double> targets_list){
        INDArray inputs, targets, hidden_inputs, hidden_outputs;
        INDArray final_inputs, final_outputs, output_errors, hidden_errors;
        INDArray left, right, leftValue, rightValue, tmp, newWho, newWih;

        //입력리스트를 2차원 행렬로 변환
        inputs  = Nd4j.create(inputs_list.size()  , 1);
        targets = Nd4j.create(targets_list.size() , 1);

        //입력, 출력값 저장
        for(int i=0 ; i<inputs_list.size() ; i++){
            inputs.putScalar(i,0, inputs_list.get(i));
        }

        for(int i=0 ; i<targets_list.size() ; i++){
            targets.putScalar(i,0,targets_list.get(i));
        }

        //은닉계층 연산
        hidden_inputs = (this.wih).mmul(inputs);
        hidden_outputs = Transforms.sigmoid(hidden_inputs);

        //출력계층 연산
        final_inputs = (this.who).mmul(hidden_outputs);
        final_outputs = Transforms.sigmoid(final_inputs);

        //출력 계층의 오차는 (실제값 - 계산값)
        output_errors = targets.sub(final_outputs);
        hidden_errors = ((this.who).transpose()).mmul(output_errors);

        //은닉계층과 출력계층 간의 가중치 업데이트
        left = (output_errors).mul(final_outputs);
        right = (final_outputs.mul(-1.0)).add(1.0);
        leftValue = left.mul(right);
        rightValue = hidden_outputs.transpose();
        tmp = leftValue.mmul(rightValue);
        newWho = tmp.mul(this.lr);
        this.who = (this.who).add(newWho);

        //입력계층과 은닉계층 간의 가중치 업데이트
        left = (hidden_errors).mul(hidden_outputs);
        right = (hidden_outputs.mul(-1.0)).add(1.0);
        leftValue = left.mul(right);
        rightValue = inputs.transpose();
        tmp = leftValue.mmul(rightValue);
        newWih = tmp.mul(this.lr);
        this.wih = (this.wih).add(newWih);

        System.out.println("Train Finish");
    }

    //쿼리
    public INDArray query(List<Double> inputs_list) {
        INDArray inputs, targets, hidden_inputs, hidden_outputs;
        INDArray final_inputs, final_outputs, output_errors, hidden_errors;

        //입력리스트를 2차원 행렬로 변환
        inputs = Nd4j.create(inputs_list.size(), 1);

        //입력, 출력값 저장
        for (int i = 0; i < inputs_list.size(); i++) {
            inputs.putScalar(i, 0, inputs_list.get(i));
        }

        //은닉계층 연산
        hidden_inputs = (this.wih).mmul(inputs);
        hidden_outputs = Transforms.sigmoid(hidden_inputs);

        //출력계층 연산
        final_inputs = (this.who).mmul(hidden_outputs);
        final_outputs = Transforms.sigmoid(final_inputs);

        return final_outputs;
    }

}

