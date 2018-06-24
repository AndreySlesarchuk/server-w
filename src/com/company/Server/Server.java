/**
сервисы сервера
*/
package com.company.Server;

import java.net.DatagramSocket;
import java.net.SocketException;

public class Server {
  private int port; //Порт не котором будет работать сервер
  private DatagramSocket socket;
  private Thread serverRun; //Поток запускающий сервер
  private boolean running = false;

  public Server(int port) {
    this.port = port;
    try {
      socket = new DatagramSocket(port);
    } catch(SocketException e) {
      e.printStackTrace();
    }
    //Создаю поток с именем serverRun
    serverRun = new Thread(new Runnable() {
      @Override
      public void run(){
        running = true;
        System.out.println("Server started on port: " + port);
        manage(); //Работа с клиентами,проверка на валидность
        receive(); //контроль входящих соединений
      }
    }, "serverRun");
  }

  private void manage() {
    manage = new Thread(new Runnable() {
      @Override
      public void run(){
        while (running) {
          // manage the clients
        }
      }
    });
    manage.start();
  }

  private void receive() {
    receive = new Thread(new Runnable() {
      @Override
      public void run(){
        while (running) {   // receive the clients
          DatagramPacket packet = new DatagramPacket(data, data.length);
          try {
            socket.receive(packet);
          } catch(IOException e) {
            e.printStackTrace();
          }
          String str = new String(packet.getData());
          System.out.println(str);
        }
      }
    }, "receive");
    receive.start();
  }
}
