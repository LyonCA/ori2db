package com.c2uol.titan.server.handler;

import com.c2uol.titan.server.handler.impl.ServerHandler;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;


public class ServerInitializer extends ChannelInitializer<SocketChannel> {
		
	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		ChannelPipeline channelPipeline = ch.pipeline();
		
		channelPipeline.addLast("decoder", new StringDecoder());
		channelPipeline.addLast("encoder", new StringEncoder());
		channelPipeline.addLast("handler", new ServerHandler());
	}

}
