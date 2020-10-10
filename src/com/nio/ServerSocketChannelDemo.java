package com.nio;


import java.nio.CharBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

public class ServerSocketChannelDemo {
  public static void main(String[] args) throws Exception{

    CharsetEncoder encoder = Charset.forName("US-ASCII").newEncoder();

    ServerSocketChannel server = ServerSocketChannel.open();
    server.socket().bind(new java.net.InetSocketAddress(8000));

    for (;;) { // This server runs forever
      SocketChannel client = server.accept();
      String response = new java.util.Date().toString() + "\r\n";
      client.write(encoder.encode(CharBuffer.wrap(response)));
      client.close();
    }
  }
}