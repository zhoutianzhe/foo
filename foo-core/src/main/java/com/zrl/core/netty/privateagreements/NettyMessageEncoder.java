package com.zrl.core.netty.privateagreements;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.handler.codec.marshalling.DefaultMarshallerProvider;
import io.netty.handler.codec.marshalling.MarshallerProvider;
import io.netty.handler.codec.marshalling.MarshallingEncoder;
import org.jboss.marshalling.MarshallerFactory;
import org.jboss.marshalling.Marshalling;
import org.jboss.marshalling.MarshallingConfiguration;

import java.util.List;
import java.util.Map;

/**
 * @author riliang.zrl
 * @date 2019/07/21  19:54
 */
public final class NettyMessageEncoder extends MessageToMessageEncoder<NettyMessage>{

    NettyMarshallingEncoder marshallingEncoder;

    public NettyMessageEncoder() throws Exception {
        marshallingEncoder = MarshallingCodeCFactory.buildMarshallingEncoder();
    }

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, NettyMessage msg, List out) throws Exception {
        if (msg == null || msg.getHeader() == null) {
            throw new Exception("The Encode message is null");
        }
        ByteBuf sendBuf = Unpooled.buffer();
        sendBuf.writeInt(msg.getHeader().getCrcCode());
        sendBuf.writeInt(msg.getHeader().getLength());
        sendBuf.writeLong(msg.getHeader().getSessionID());
        sendBuf.writeByte(msg.getHeader().getType());
        sendBuf.writeByte(msg.getHeader().getPriority());
        sendBuf.writeInt(msg.getHeader().getAttachment().size());
        String key = null;
        byte[] keyArray = null;
        Object value = null;
        for (Map.Entry<String, Object> param: msg.getHeader().getAttachment().entrySet()) {
            key = param.getKey();
            keyArray = key.getBytes();
            sendBuf.writeInt(keyArray.length);
            sendBuf.writeBytes(keyArray);
            value = param.getValue();
            marshallingEncoder.encode(channelHandlerContext, value, sendBuf);
        }
        key = null;
        keyArray = null;
        value = null;
        if(msg.getBody() != null){
            marshallingEncoder.encode(channelHandlerContext, msg.getBody(), sendBuf);
        } else {
            sendBuf.writeInt(0);
        }
        // 在第4个字节处写入Buffer的长度
        int readableBytes = sendBuf.readableBytes();
        sendBuf.setInt(4, readableBytes);

        // 把Message添加到List传递到下一个Handler
        out.add(sendBuf);
    }
}
