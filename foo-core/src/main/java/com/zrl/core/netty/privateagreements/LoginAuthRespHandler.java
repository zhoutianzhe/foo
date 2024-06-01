package com.zrl.core.netty.privateagreements;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * @author riliang.zrl
 * @date 2019/07/21  19:56
 */
public class LoginAuthRespHandler extends ChannelHandlerAdapter{

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)
        throws Exception {
        NettyMessage message = (NettyMessage)msg;
        if(message.getHeader() != null && message.getHeader().getType() == MessageType.LOGIN_REQ.value()){
            System.out.println("Login is OK");
            String body = (String)message.getBody();
            System.out.println("Recevied message body from client is " + body);
            ctx.writeAndFlush(buildLoginResponse(MessageType.LOGIN_RESP.value()));
        } else {
            ctx.fireChannelRead(msg);
        }
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        ctx.close();
    }

    private NettyMessage buildLoginResponse(byte result) {
        NettyMessage message = new NettyMessage();
        Header header = new Header();
        header.setType(MessageType.LOGIN_RESP.value());
        message.setHeader(header);
        message.setBody(result);
        return message;
    }

}
