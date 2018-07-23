package com.zucc.demo.modeling.Logistic;

import java.util.ArrayList;

/**
 * @author haolidong
 * @Description: [该类主要用于保存特征信息以及标签值]
 * @parameter labels: [主要保存标签值]
 */
public class CreateDataSet extends Matrix {
    public ArrayList<String> labels;

    public CreateDataSet() {
        // TODO Auto-generated constructor stub
        super();
        labels = new ArrayList<String>();
    }

    /**
     * @author haolidong
     * @Description: [机器学习实战逻辑回归第一个案例的数据]
     */
    public void initTest() {

    }
}