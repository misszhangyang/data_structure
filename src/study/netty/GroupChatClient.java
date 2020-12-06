package study.netty;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @Author: yangzhang
 * @Description: 群聊系统客户端
 * @Date: 2020/12/6 8:24 下午
 * @Version: 1.0
 */
public class GroupChatClient {

    //初始化一些基本信息
    private String HOST = "127.0.0.1";
    private int PORT = 6667;
    private SocketChannel socketChannel;
    private Selector selector;
    private String userName;


    //初始化构造器
    GroupChatClient() throws IOException {
        selector = Selector.open();
        socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        socketChannel.bind(new InetSocketAddress(HOST,PORT));
        socketChannel.register(selector, SelectionKey.OP_READ);
    }

    //向服务器发送数据
    public void sendInfo(String info) throws IOException {
        java.lang.String info1 = userName + "说" + info;
        socketChannel.write( ByteBuffer.wrap(info1.getBytes()));
    }

    //从服务器读取数据

    public  void readInfo() throws IOException {
        int select = selector.select();
        if(select > 0){
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while(iterator.hasNext()){
                SelectionKey key = iterator.next();
                if(key.isReadable()){
                    //得到相关的通道
                    SocketChannel channel = (SocketChannel) key.channel();
                    //创建bytebuffer缓冲区
                    ByteBuffer allocate = ByteBuffer.allocate(1024);
                    //将通道中的数据读如缓冲区bytebuffer
                    int read = channel.read(allocate);
                    if(read > 0){
                        String s = new String(allocate.array());
                        //读取bytebuffer的信息到控制台
                        System.out.println("得到服务器相关信息：" + s);
                    }
                }

            }
        }
    }
    public static void main(String[] args) {

    }

}
