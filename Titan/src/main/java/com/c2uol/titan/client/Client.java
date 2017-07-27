package com.c2uol.titan.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.c2uol.titan.client.handler.ClientInitializer;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

public class Client {
	public static void main(String[] args) {
		EventLoopGroup group = new NioEventLoopGroup();
		try {
			Bootstrap client = new Bootstrap();
			client.group(group);
			client.channel(NioSocketChannel.class);
			client.handler(new ClientInitializer());

			Channel ch = client.connect("127.0.0.1", 9090).sync().channel();
			
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			while(true){
				String line = in.readLine();
				if(line == null){
					continue;
				}
				ch.writeAndFlush(line);	
			}						
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			group.shutdownGracefully();
		}
	}
}
