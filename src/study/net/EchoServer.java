package study.net;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @Author: yangzhang
 * @Description: 服务器类
 * @Date: 2020/11/11 11:14 下午
 * @Version: 1.0
 */
public class EchoServer {

    public static void main(String[] args) throws Exception{
        try(ServerSocket s = new ServerSocket(7004)){
            try(Socket incoming = s.accept()){
                //获取客户端的输入流
                InputStream inputStream = incoming.getInputStream();
                //获取服务器端的输出流
                OutputStream outputStream  = incoming.getOutputStream();
                //获取输入数据
                try(Scanner in = new Scanner(inputStream, String.valueOf(StandardCharsets.UTF_8))){
                    //获取输入数据后打印
                    PrintWriter out = new PrintWriter(new OutputStreamWriter(outputStream,StandardCharsets.UTF_8),true);
                    //初始化链接的时候开始打印出的信息
                    out.println("Hello.please enter BYE to exit");
                    //接下来在链接成功后开始接受客户端的输入数据，直到输入BYE，则断开链接
                    boolean done = false;
                    while (!done && in.hasNext()){
                        String line = in.nextLine();
                        out.println("Echo: " + line);
                        if(line.trim().equals("BYE")){
                            done = true;
                        }
                    }
                }
            }
        }
    }
}
