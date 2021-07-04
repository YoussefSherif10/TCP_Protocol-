/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udp_server;
import java.net.* ;
import java.io.* ;
/**
 *
 * @author youssef
 */
public class TCP_Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // register port
            ServerSocket s = new ServerSocket(2000);
            System.out.println("waiting for client on port " 
            +s.getLocalPort() + "...");
            
            int applePrice = 20 ;
            int bananaPrice = 30 ;
            int orangePrice = 10 ;
            
            while(true){
                // waiting and serving
                Socket s1 = s.accept();
                System.out.println("Just connected to " + s1.getRemoteSocketAddress());
            
                // get stream of data through the socket
                DataInputStream in = new DataInputStream(s1.getInputStream());
                int appleQuantity = in.read();
                int bananaQuantity = in.read();
                int orangeQuantity = in.read();
                
                // get the total price
                int totalPrice = (applePrice * appleQuantity) + (orangePrice * orangeQuantity)
                        + (bananaPrice * bananaQuantity);
            
                System.out.println(totalPrice);
            
                // send stream of data through the socket
                DataOutputStream out = new DataOutputStream(s1.getOutputStream());
                out.write(totalPrice);
            }
            
        }
        catch(IOException e){
            System.out.println(e.toString());
        }
    }
        
        
        
        
        
        
        /*try {
            // set the length of the backet
            byte [] recvMSG = new byte[1000];
            
            // register the socket
            DatagramSocket serverSocket = new DatagramSocket(1060);
            
            // create backet to receive data
            DatagramPacket recvPacket = new DatagramPacket(recvMSG, recvMSG.length);
            serverSocket.receive(recvPacket);
            // cast the data into string then print it
            String str = new String(recvPacket.getData());
            //Integer appleQuantity = Integer.parseInt(str);
            
            serverSocket.receive(recvPacket);
            // cast the data into string then print it
            String str1 = new String(recvPacket.getData());
            //Integer bananaQuantity = Integer.parseInt(str1);
            
            serverSocket.receive(recvPacket);
            // cast the data into string then print it
            String str2 = new String(recvPacket.getData());
            //Integer orangeQuantity = Integer.parseInt(str2);
            
            
            System.out.println(str);
            
            //create data to send it
            byte [] sendMSG = ("Welcome").getBytes();
            
            // create the datagram
            DatagramPacket sendPacket = new DatagramPacket(
                    sendMSG,sendMSG.length,recvPacket.getAddress(),recvPacket.getPort()
            );
            
            // send the data
            serverSocket.send(sendPacket);
            
        }
        catch(IOException e){
            System.out.println(e.toString());
        }*/
    }
    
}
