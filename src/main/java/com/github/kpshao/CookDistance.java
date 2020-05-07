package com.github.kpshao;

import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.stat.regression.OLSMultipleLinearRegression;

public class CookDistance {
    private double[] y;
    private double[][] x;

    public CookDistance(double[] y, double[][] x) {
        this.y = y;
        this.x = x;
    }

    public double[] calculate() {
        OLSMultipleLinearRegression OLS = new OLSMultipleLinearRegression();
        OLS.newSampleData(y, x);

        RealMatrix hat = OLS.calculateHat();    // 获取线性回归模型的帽子矩阵
        int kVar = OLS.estimateRegressionParameters().length;   // 获取自变量的个数
        double[] residuals = OLS.estimateResiduals();   // 残差（误差向量）
        double MSE = OLS.estimateErrorVariance();

        double[] cookDist = new double[y.length];
        for (int i = 0; i < y.length; i++) {
            double hatDiag = hat.getRow(i)[i];
            cookDist[i] = residuals[i] * residuals[i] * hatDiag / (MSE * kVar * Math.pow(1 - hatDiag, 2));
        }

        return cookDist;
    }
}
