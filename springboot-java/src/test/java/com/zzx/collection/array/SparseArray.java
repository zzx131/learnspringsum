package com.zzx.collection.array;

import org.junit.Test;

import java.io.*;

public class SparseArray {
    int sum = 0;

    // 创建一个原始的二维数组
    @Test
    public void creatArray() throws IOException {
        int[][] chessArray = new int[11][11];
        chessArray[1][2] = 1;
        chessArray[3][5] = 2;
        // 输出原始的二维数组
        printArray(chessArray);
        // 将二维数组转换成稀疏数组
        int[][] sparseArray = reSparseArray(chessArray);
        // 将稀疏数组转化成为二维数组
        //reArray(sparseArray);
    }

    /**
     * 将稀疏数组转化成为二维数组
     *
     * @param sparseArray
     */
    public void reArray(int[][] sparseArray) {
        // 将稀疏数组转成二维数组
        int[][] reChessArray = new int[sparseArray[0][0]][sparseArray[0][1]];
        // 将非零的数据添加进去
        for (int i = 1; i < sum + 1; i++) {
            reChessArray[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        // 输出转化完成的
        System.out.println();
        printArray(reChessArray);
    }

    /**
     * 将二维数组转化成为稀疏数组
     *
     * @param chessArray
     * @return
     */
    public int[][] reSparseArray(int[][] chessArray) throws IOException {
        countSum(chessArray);
        // 创建稀疏数组
        int[][] sparseArray = new int[sum + 1][3];
        // 给稀疏数组赋值
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = sum;
        // 将非0的数据存放到稀疏数组中
        int count = 1;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArray[i][j] != 0) {
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArray[i][j];
                    count++;
                }
            }
        }
        // 输出稀疏数组
        printArray(sparseArray);
        this.writeFile(sparseArray);
        return sparseArray;
    }

    /**
     * 存盘
     * @param array
     * @throws IOException
     */
    public void writeFile(int[][] array) throws IOException {
        File file = new File("E:/mep.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        for (int i = 0; i < sum + 1; i++) {
            for (int j = 0; j < 3; j++) {
                bufferedWriter.write(array[i][j] + "\t");
            }
            bufferedWriter.newLine();
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    /**
     * 读盘操作
     * @throws FileNotFoundException
     */
    @Test
    public void readFile() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("E:/mep.txt"));
        String line;
        while ((line = bufferedReader.readLine()) != null){
            System.out.println(line.trim());
        }
        bufferedReader.close();
    }

    /**
     * 计算二维数组中的有效数据
     *
     * @param chessArray
     */
    private void countSum(int[][] chessArray) {
        // 计算元素的个数
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArray[i][j] != 0) {
                    sum++;
                }
            }
        }
        System.out.println("共" + sum + "个元素");
    }

    /**
     * 打印数组
     *
     * @param array
     */
    private void printArray(int[][] array) {
        for (int[] rows : array) {
            for (int row : rows) {
                System.out.printf("%d\t", row);
            }
            System.out.println();
        }
    }

}
