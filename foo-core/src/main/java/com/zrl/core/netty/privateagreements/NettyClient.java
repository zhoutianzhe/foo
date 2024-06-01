package com.zrl.core.netty.privateagreements;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author riliang.zrl
 * @date 2019/07/21  19:58
 */
public class NettyClient {

    private ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
    EventLoopGroup workerGroup = new NioEventLoopGroup();

    public void connect(String remoteServer, int port) throws Exception {
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(workerGroup)
                .channel(NioSocketChannel.class)
                .handler(new ChildChannelHandler());

            ChannelFuture f = bootstrap.connect(new InetSocketAddress(remoteServer, port), new InetSocketAddress(NettyConstant.LOCALIP, NettyConstant.LOCAL_PORT)).sync();
            System.out.println("Netty time Client connected at port " + port);
            f.channel().closeFuture().sync();
        } finally {
            // 所有资源释放完成之后，清空资源，再次发起重连操作
            //executor.execute(new Runnable() {
            //    @Override
            //    public void run() {
            //        try {
            //            TimeUnit.SECONDS.sleep(1);
            //            try {
            //                connect(NettyConstant.REMOTEIP, NettyConstant.PORT);   // 发起重连操作
            //            } catch (Exception e) {
            //                e.printStackTrace();
            //            }
            //        } catch (InterruptedException e) {
            //            e.printStackTrace();
            //        }
            //    }
            //});
        }
    }

    public static class ChildChannelHandler extends ChannelInitializer<SocketChannel>{

        @Override
        protected void initChannel(SocketChannel socketChannel) throws Exception {
            socketChannel.pipeline().addLast(new NettyMessageDecoder(1024*1024, 4,4, -8, 0))
                .addLast(new NettyMessageEncoder())
                .addLast(new LoginAuthReqHandler())
                .addLast(new HeartBeatReqHandler());
        }
    }

    public static void main(String[] args){
        try {
            new NettyClient().connect(NettyConstant.REMOTEIP, NettyConstant.PORT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
