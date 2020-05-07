# cook_dist_4_java

计算一组用于线性拟合的观测数据的cook距离，以判断是否存在影响拟合结果的强影响点。

## Cook距离
在线性回归中，库克距离(Cook's Distance)描述了**单个样本对整体回归模型的影响程度**。
库克距离越大，说明影响越大。

在理想情况下，每个样本对模型的影响是相等的。如果某个样本的库克距离很大，我么可以视这个样本
点为异常点。通常情况下，若库克距离大于1，我们就认为这个点为异常点。

在线性回归中,

$$
y=X\beta+\varepsilon
$$
$y\in\mathbb{R}^n$, $X\in\mathbb{R}^{n \times p}$, $\beta \in \mathbb{R}^p$, $\varepsilon \in \mathbb{R}^n$。$n$为样本数，$p$为自变量个数，$\varepsilon$是误差向量。

那么第$i$个样本的库克距离
$$
D_i=\frac{\varepsilon^2_i h_i}{s^2 p (1-h_i)^2},
$$
其中$s^2$为模型的均方误差MSE。

