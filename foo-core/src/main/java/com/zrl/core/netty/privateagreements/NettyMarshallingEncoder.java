package com.zrl.core.netty.privateagreements;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.marshalling.MarshallerProvider;
import io.netty.handler.codec.marshalling.MarshallingEncoder;

/**
 * @author riliang.zrl
 * @date 2019/07/21  21:44
 */
public class NettyMarshallingEncoder extends MarshallingEncoder {
    public NettyMarshallingEncoder(MarshallerProvider provider) {
        super(provider);
    }

    @Override
    public void encode(ChannelHandlerContext ctx, Object msg, ByteBuf out) throws Exception{
        super.encode(ctx, msg, out);
    }
}
