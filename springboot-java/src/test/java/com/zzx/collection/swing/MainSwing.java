package com.zzx.collection.swing;

import com.zzx.collection.swing.frame.KeyStoreFrame;

import javax.swing.*;

public class MainSwing {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> createGUI());
    }

    private static void createGUI() {
        //创建一个窗口，创建一个窗口
        KeyStoreFrame frame = new KeyStoreFrame("SwingDemo!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //设置窗口大小
        frame.setSize(600, 400);

        //显示窗口
        frame.setVisible(true);
    }
}
