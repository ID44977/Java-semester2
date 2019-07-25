package Exp4;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;
import java.util.Date;
public class Test02_Server {
    public static void main(String args[]){
        try{
            ServerSocket server = new ServerSocket(8889);
            System.out.println("服务器启动完毕");

            System.out.println("等待客户端连接...");
            Socket socket = server.accept();

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);

            if(socket.isConnected()){
                System.out.println("客户端IP为"+socket.getInetAddress().getHostAddress()+"  连接成功！");
            }
            String s = reader.readLine();
            while(!s.equals("Exit")) {
                if(s.equals("Time")) {
                    Date d = new Date();
                    out.println("服务器当前时间为:"+d);
                    out.flush();
                    System.out.println("服务器当前的时间为:"+d);
                }
                s = reader.readLine();
            }
            out.println("Bye");
            System.out.println("Bye");
            out.close();
            reader.close();
            socket.close();
            server.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
