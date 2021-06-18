
package sps.live;

import java.net.*;
import java.io.*;
import java.util.Random;

class ServerLive {

    public ServerLive() throws IOException {

        Socket s;
        try (ServerSocket ss = new ServerSocket(6666)) {
            s = ss.accept();
            boolean r = true;
            while(r){
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            DataInputStream dis = new DataInputStream(s.getInputStream());
//            System.out.println("Server is waiting for request input from client");
            String str = (String) dis.readUTF();
            if(str.equalsIgnoreCase("close")){
                break;
            }
            Random rand = new Random();
            int number = rand.nextInt(3);
            String data[] = {"Stone", "Paper", "Scissor"};
            dos.writeUTF(data[number]);
            dos.flush();
//            System.out.println("Server sent the response");
        }
//            System.out.println("Server closed");
        s.close();
       }
        catch(Exception e){
            System.err.print(e.getMessage());
        }

    }
}
