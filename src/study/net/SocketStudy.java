package study.net;

import java.net.InetAddress;

/**
 * @Author: yangzhang
 * @Description: socket学习记录
 * @Date: 2020/11/11 10:42 下午
 * @Version: 1.0
 */
public class SocketStudy {

    public static void main(String[] args) throws Exception{
        if(args.length > 0){
            String host = args[0];
            InetAddress[] addresses = InetAddress.getAllByName(host);
            for(InetAddress a : addresses){
                System.out.println(a);
            }
        }else{
            InetAddress localHostAddress = InetAddress.getLocalHost();
            System.out.println(localHostAddress);
        }
    }

}
