package study.netty;

import jdk.jfr.events.SocketReadEvent;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

/**
 * @Author: yangzhang
 * @Description: 群聊系统服务类
 * @Date: 2020/12/6 6:49 下午
 * @Version: 1.0
 * 服务端
   1  服务器启动并且监听6667端口
   2  接受消息并转发至其他的客户端
 */
public class GroupChatServer {

    private Selector selector = null;

    private ServerSocketChannel listenChannle = null;

    private static  final int PORT = 6667;

    public GroupChatServer() throws IOException {

        selector = Selector.open();

        listenChannle = ServerSocketChannel.open();

        listenChannle.configureBlocking(false);

        listenChannle.bind(new InetSocketAddress(PORT));

        listenChannle.register(selector,SelectionKey.OP_ACCEPT);

    }

    //ServerSocketChannel监听的方法
    private void listen(){
        try {
            int cout = selector.select(2000);
            if(cout > 0){
                //遍历获取channel中的key
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while(iterator.hasNext()){
                    SelectionKey key = iterator.next();
                    if(key.isAcceptable()){
                        SocketChannel accept = listenChannle.accept();
                        accept.register(selector,SelectionKey.OP_READ);
                        System.out.println(accept.getRemoteAddress() + "已经上线啦!");
                    }
                    if(key.isReadable()){//通道发生read事件，即通道是可以读的状态
                        //书写专门的方法读通道中的数据，并且读完之后需要发送给其他的客户端
                        read(key);
                    }
                }
            }
        }catch(Exception e){

        } finally {

        }
    }

    //读取客户端的信息
    private void read(SelectionKey key) throws IOException {
        //取到关联的channel
        SocketChannel socketChannel = null;
        try{
            socketChannel = (SocketChannel)key.channel();
            //创建ByteBuffer读取信息
            ByteBuffer allocate = ByteBuffer.allocate(1024);
            int cout = socketChannel.read(allocate);
            if(cout > 0){
                //输出读取的消息，但是还要广播给其他客户端
                String msg = new String(allocate.array());
                System.out.println("接收到来自客户端的消息" + new String(allocate.array()));
                sendToOtherChannel(msg,socketChannel);
            }
            boolean readable = key.isReadable();
        }catch(Exception e){
            System.out.println("当前客户端断开链接了....." + socketChannel.getRemoteAddress());
            //离线之后需要做相应的处理  取消注册  关闭通道
            key.cancel();
            socketChannel.close();
            e.printStackTrace();
        }finally {

        }


    }

    //消息转发，通知其他的客户端
    private void sendToOtherChannel(String msg,SocketChannel self) throws IOException {
        System.out.println("消息转发中.......");
        //遍历所有注册到selector上的socketchannel，并且排除自己
        for(SelectionKey key : selector.keys()){
            //取出通道，通过key取出，对应的就是我们的socketchannel
            Channel targetChannel = key.channel();
            if(targetChannel instanceof  SocketChannel && targetChannel != self){
                //转型
                SocketChannel socketChannel = (SocketChannel)targetChannel;
                //将msg存储到buffer
                ByteBuffer wrap = ByteBuffer.wrap(msg.getBytes());
                //将buffer的数据写入到通道中
                socketChannel.write(wrap);
            }
        }
    }


    public static void main(String[] args) {

    }

}
