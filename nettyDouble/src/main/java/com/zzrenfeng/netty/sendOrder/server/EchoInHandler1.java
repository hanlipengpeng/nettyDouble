package com.zzrenfeng.netty.sendOrder.server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.util.Date;


public class EchoInHandler1 extends ChannelHandlerAdapter {
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {
		System.out.println("in1");
		 // 通知执行下一个InboundHandler
        ctx.fireChannelRead(msg);
	}
	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();//刷新后才将数据发出到SocketChannel
	}
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {
		cause.printStackTrace();
		ctx.close();
	}

}
