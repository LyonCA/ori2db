package com.c2uol.titan.server.handler.impl;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class ServerHandler extends SimpleChannelInboundHandler<String>{

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, String data) throws Exception {
		System.out.println(ctx.channel().remoteAddress() + ":" + data);
		
		ctx.writeAndFlush("copy that!!");
	}
	
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		System.out.println("Server active");
		super.channelActive(ctx);
	}
}
