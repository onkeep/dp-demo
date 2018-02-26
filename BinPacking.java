/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.bpit.service.impl;

import java.util.Scanner;

/**
 * @author lixuemeng
 *         Created in 下午2:53 2018/2/26
 */
public class BinPacking {

    int volume[] = null;
    int max_V = 0;

    // f(i,j)表示前i件物品在给定j体积时所能达到的最大值
    public void binPacking() {
        int[][] maxSumVolume = new int[volume.length][max_V + 1];
        for (int i = 1; i < volume.length; i++) {
            for (int j = 1; j <= max_V; j++) {
                if (j >= volume[i]) {
                    maxSumVolume[i][j] = Math.max(maxSumVolume[i - 1][j],
                            maxSumVolume[i - 1][j - volume[i]] + volume[i]);
                }
            }
        }
        int minSurplus = max_V - maxSumVolume[volume.length - 1][max_V];
        System.out.println("最小剩余：" + minSurplus);
    }

    public void getInput() {// 从键盘输入数据
        Scanner cin = new Scanner(System.in);
        System.out.print("请输入箱子容量：");
        max_V = cin.nextInt();
        System.out.print("请输入物品数：");
        int m = cin.nextInt();
        volume = new int[m + 1];
        System.out.print("依次输入每件物品的重量：");
        for (int i = 1; i < m + 1; i++) {
            volume[i] = cin.nextInt();
        }
        cin.close();
    }

    public static void main(String[] args) {
        BinPacking bp = new BinPacking();
        bp.getInput();
        bp.binPacking();
    }

}
