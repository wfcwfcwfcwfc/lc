package io.fengchao.corejava.applets.socket;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class EchoClient {
  public static void main(String[] args) throws UnknownHostException, IOException {
    if (args.length != 2) {
      System.err.println(
          "Usage: java EchoClient <host name> <port number>");
      System.exit(1);
    }
    String hostName = args[0];
    int portNumber = Integer.parseInt(args[1]);
    try (
        Socket echoSocket = new Socket(hostName, portNumber);
        ) {

    }
  }
}
