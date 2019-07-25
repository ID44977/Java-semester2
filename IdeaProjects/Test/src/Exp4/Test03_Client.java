package Exp4;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;


public class Test03_Client {
    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket client = new Socket("127.0.0.1", 8888);
        System.out.println("连接成功! ");
        BufferedInputStream bis = new BufferedInputStream(client.getInputStream());
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("C:\\\\Users\\\\Waterstone\\\\Desktop\\\\test_renamed.txt"));
        byte[] flush = new byte[2048];
        int len = 0;
        while ((len = bis.read(flush)) != -1) {
            bos.write(flush, 0, len);
        }
        bos.flush();
        bos.close();
        bis.close();
        System.out.println("接收完毕！\n保存为C:\\\\Users\\\\Waterstone\\\\Desktop\\\\test_renamed.txt");
    }

}