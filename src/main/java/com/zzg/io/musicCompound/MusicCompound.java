package com.zzg.io.musicCompound;/*
@date 2021/9/11 - 11:36 上午
*/



import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MusicCompound
{
    @Test
    public void test1() {
        FileOutputStream fileOutputStream = null;
        FileInputStream fileInputStream = null;
        //输入.mp3文件的绝对地址
        String fileNames[] = {"src/Aimer - LAST STARDUST.mp3","src/G.E.M.邓紫棋 - 来自天堂的魔鬼.mp3"};
        //设置byte数组，每次往输出流中传入1M的内容
        byte by[] = new byte[1024*1024];
        try
        {
            //填写生成新的.mp3文件的绝对地址
            fileOutputStream = new FileOutputStream("src/示例歌曲/混剪.mp3");
            for(int i=0;i<2;i++)
            {
                int count = 0;
                fileInputStream = new FileInputStream(fileNames[i]);
                //跳过前面2M的歌曲内容
                fileInputStream.skip(1024*1024*2);
                while(fileInputStream.read(by) != -1)
                {
                    fileOutputStream.write(by);
                    count++;
                    System.out.println(count);
                    //要截取中间8MB的内容，每次输入1M的内容，所以输入的次数是8
                    if(count == (8))
                    {
                        break;
                    }
                }
            }
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                //输出完成后关闭输入输出流
                fileInputStream.close();
                fileOutputStream.close();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}