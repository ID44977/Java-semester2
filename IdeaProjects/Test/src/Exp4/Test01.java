package Exp4;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.URL;

public class Test01 {
    public static void main(String[] args) throws Exception{
        InetAddress localAddress = InetAddress.getLocalHost();
        InetAddress[] remoteAddress = InetAddress.getAllByName("www.csdn.net");
        System.out.println("本机的IP地址为:" + localAddress.getHostAddress());
        System.out.println("本机的名称为:" + localAddress.getHostName());
        for (int i = 0; i < remoteAddress.length; i++)
        System.out.println("www.csdn.net的IP地址为:" + remoteAddress[i].getHostAddress());
        URL url = new URL("https://www1.szu.edu.cn");
        InputStream in = url.openStream();
        FileOutputStream fop = new FileOutputStream(new File("szu.html"));
        int cout = 0;
        int a = 0;
        while (a > -1) {
            a = in.read();
            fop.write(a);
            cout++;
        }
        System.out.println("下载得到网页文件的大小:" + cout + "byte");
    }
}
