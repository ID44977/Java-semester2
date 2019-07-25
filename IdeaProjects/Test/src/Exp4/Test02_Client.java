package Exp4;

import java.net.Socket;
import java.io.*;

public class Test02_Client {
    public static void main(String args[]){
        try{
            Socket socket = new Socket("localhost",8889);
            System.out.println("服务器启动完毕");
            System.out.println("创建客户连接");
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));//获取输入流 获得服务器返回的数据
            BufferedReader localMessage = new BufferedReader(new InputStreamReader(System.in));//接受客户端从键盘输入的信息
            PrintWriter os = new PrintWriter(socket.getOutputStream());
            String s = localMessage.readLine();

            while(true){
                os.println(s);
                os.flush();
                System.out.println("客户端:"+s);
                String str = reader.readLine();
                System.out.println("服务器:"+str);
                if(str.equals("Bye")){
                    System.out.println("连接断开！");
                    break;
                }
                s = localMessage.readLine();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
