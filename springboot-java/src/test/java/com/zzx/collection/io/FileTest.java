package com.zzx.collection.io;

import cn.hutool.core.io.FileUtil;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.sun.media.jfxmedia.logging.Logger;
import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileTest {

    private static final String dirPath = "E:/myfile";

    /**
     * 创建文件夹
     */
    @Test
    public void testCreateFile() {
        // 新建实体类
        File file = new File(dirPath,"son");
        System.out.println(file.getPath());
        // 创建文件夹
        if (!file.exists()) {
            boolean flag = file.mkdir();
            System.out.println(flag);
        }
    }

    /**
     * 创建父子结构的文件夹类型
     * 1,父文件必须存在，如果不存在，创建不成功
     * 2，可以使用mkdirs进行创建,多级目录的创建
     * 就是父文件创建了再进行创建不太合适，需要进行改进
     * 重复创建使用mkdirs创建的话，会创建不成功
     */
    @Test
    public void testCreateParent() {
        String sonPath = dirPath;
        File sonFile = new File(sonPath);
        System.out.println(sonFile.getPath());
        //boolean isCreate = sonFile.mkdir();
        boolean isCreate = sonFile.mkdirs();
        System.out.println("创建成功的标识:" + isCreate);
    }

    public void createFile(String path) {
        // 盘符
        String pf = path.substring(0, path.indexOf("/"));
        System.out.println(pf);
        // 所有的文件
        String files = path.substring(path.indexOf("/") + 1);
        System.out.println(files);

        String[] fileNames = files.split("/");
        List<String> fileNameList = Arrays.asList(fileNames);

        List<String> createPathList = new ArrayList<>();
        String retuenFileName = "";
        for (String one : fileNameList) {
            retuenFileName = this.getCreateFilePath(retuenFileName + "/" + one, createPathList);
        }
        System.out.println("要创建的文件夹路径 "+createPathList.toString());
        // 开始创建文件夹
        if (createPathList.size() > 0) {
            createPathList.forEach(one -> {
                String createPath = pf + one;
                File createFile = new File(createPath);
                if (!createFile.exists()) {
                    boolean flag = createFile.mkdirs();
                    System.out.println("创建文件夹"+createPath+":"+flag);
                }
            });
        }
    }

    public String getCreateFilePath(String fileName, List<String> paths) {
        paths.add(fileName);
        return fileName;
    }

    /**
     * 目标
     * 给定一个路径进行创建，如果不存在文件夹进行创建，如果存在文件夹不再进行创建，
     * 可以使用递归进行创建,也可以不用
     */
    @Test
    public void testCreateParentV() {
        this.createFile("E:/myfile/son/son1-1");
    }

    /**
     * 测试文件FileWrite类
     * @throws IOException
     */
    @Test
    public void testFileWrite() throws IOException {
        FileWriter fileWriter = new FileWriter("E:/myfile/mynote.txt",true);
       // fileWriter.write("hello word");
        fileWriter.append("hello ").append("word ").append(" java");
        System.out.println(fileWriter.getEncoding());
        fileWriter.close();
    }

    /**
     * 加入了缓存的 BufferedWrite
     */
    @Test
    public void testBufferedWrite() throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("E:/myfile/mynote.txt"));

        bufferedWriter.write("hello BufferedWriter");
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    /**
     * 测试文件删除
     */
    @Test
    public void testDelete(){
        File file = new File("E:\\myfile\\del.txt");
        boolean flag = file.exists();
        boolean deleteFlag = file.delete();
        System.out.println(flag);
        System.out.println(deleteFlag);
    }

    /**
    * @description: 测试删除文件夹
    * @author: zhangzexin
    * @date: 2020/3/13  16:48
    * @return: void
    **/
    @Test
    public void testDeleteFiles(){
        File f = new File("E:\\myfile");
        boolean deleteFlag =  FileUtil.del(f);
        System.out.println(deleteFlag);
    }

    @Test
    public void testParentFilePath(){
        File file = new File("E:/fileParent/fileson");
        System.out.println(file.getParent());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getName());
    }

}
