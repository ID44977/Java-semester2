package Exp4;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class Test03_Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8888);
        System.out.println("服务端运行开始! ");
        Socket socket = server.accept();
        System.out.println( "一个客户端已连接" );
        BufferedInputStream bis = new BufferedInputStream(
                new FileInputStream(new File("D://test.txt"))
        );
        System.out.println("要传输的文件为D://test.txt");
        OutputStream outputStream = socket.getOutputStream();
        System.out.println("开始传输文件 ");
        byte [] flush = new byte[2048];
        int len = 0;
        while( (len=bis.read(flush)) != -1 ) {
            outputStream.write(flush, 0, len);
        }
        System.out.println("文件传输结束");
        outputStream.close();
    }

}
