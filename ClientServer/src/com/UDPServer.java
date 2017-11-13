package com;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {
    public static void main(String[] args) throws Exception{
        DatagramSocket serverSocket = new DatagramSocket(8824);
        byte[] recieveData = new byte[1024];
        int c1=0, c2=0, c3=0;
        float  T;
        Double S;
        String s1, s2, s3;
        byte[] sendData = new byte[1024];
        while (true){
            DatagramPacket recievePAcket = new DatagramPacket(recieveData, recieveData.length);
            serverSocket.receive(recievePAcket);
            String s = new String(recievePAcket.getData());
            System.out.println("the recieved data is:" + s + recievePAcket.getData());
            String params[] = s.split(",");
            InetAddress IP = recievePAcket.getAddress();
            int port = recievePAcket.getPort();
            DatagramPacket sendPacket;
            System.out.println("this is testing" + params[0]);


            /*Client 1 handled*/

            if(params[0].equals("1")){
                s = s.substring(params[0].length()+1);
                System.out.println("inside if:"+s);
                for (int i=0;i<s.length();i++)
                {
                    if(s.charAt(i) == ' ')
                    {
                        c1++;
                    }
                }
                System.out.println("The no.of spaces are" + c1);
                if(c1==2)
                {
                    String[] data = s.split("\\s");
                    S = (Double.parseDouble(data[0])*Double.parseDouble(data[2]) * Double.parseDouble(data[1]))/100;
                    sendPacket =
                            new DatagramPacket(String.valueOf(S).getBytes(), String.valueOf(S).getBytes().length, IP, port);
                    serverSocket.send(sendPacket);
                }
                else if (c1==1)
                {
                    String[] data = s.split("\\s");
                    double x = 0, y = 0;
                    System.out.println(data[0]);
                    if (data[0].equals("sin"))
                    {
                        System.out.println(x);
                        x = Double.parseDouble(data[1]);
                        System.out.println(x);
                        x = Math.toRadians(x);
                        System.out.println(x);
                        y = Math.sin(x);
                        System.out.println("The string is" + data[0]);
                    }
                    else if (data[0].equals("cos"))
                    {
                        x = Double.parseDouble(data[1]);
                        x = Math.toRadians(x);
                        y = Math.cos(x);
                    }
                    else if (data[0].equals("tan"))
                    {
                        x = Double.parseDouble(data[1]);
                        x = Math.toRadians(x);
                        y = Math.tan(x);
                    }
                    sendPacket =
                            new DatagramPacket(String.valueOf(y).getBytes(), String.valueOf(y).getBytes().length, IP, port);
                    serverSocket.send(sendPacket);
                }
            }

            /*Client 1 ended*/


            /*Client 2 handled*/
            else if (params[0].equals("2"))
            {
                s = s.substring(params[0].length()+params[1].length()+2);
                System.out.println("inside Client 2:" + s);
                s=s.replaceAll("\\s+","");
                for (int i=0;i<s.length();i++)
                {
                    if(s.charAt(i) == 'a'||s.charAt(i) == 'A'||
                            s.charAt(i) =='e'||s.charAt(i) =='E'||
                            s.charAt(i) =='o'||s.charAt(i) =='O'||
                            s.charAt(i) =='i'||s.charAt(i) =='I'||
                            s.charAt(i) =='u'||s.charAt(i) =='U')
                    {
                        c2++;
                    }
                    else{
                        c3++;
                    }
                }
                System.out.println("the value of c2 and c3:" + c2 +" "+ c3);
                if(params[1].equals("1")){
                    sendPacket =
                            new DatagramPacket(String.valueOf(c3).getBytes(), String.valueOf(c3).getBytes().length, IP, port);
                    serverSocket.send(sendPacket);
                }
                else if (params[1].equals("2")){
                    sendPacket =
                            new DatagramPacket(String.valueOf(c2).getBytes(), String.valueOf(c2).getBytes().length, IP, port);
                    serverSocket.send(sendPacket);
                }
            }
            /*Client 2 ended*/

            /*Client 4 handled*/
            else if (params[0].equals("4"))
            {
                s = s.substring(params[0].length() + params[1].length()+2);
                System.out.println("inside Client 4:" + s);
                if(params[1].equals("1")){
                    int len = s.length();
                    System.out.println(len);
                    sendPacket =
                            new DatagramPacket(String.valueOf(len).getBytes(), String.valueOf(len).getBytes().length, IP, port);
                    serverSocket.send(sendPacket);
                }
                else if (params[1].equals("2")){
                    String str_U = s.toUpperCase();
                    sendPacket =
                            new DatagramPacket(str_U.getBytes(), str_U.getBytes().length, IP, port);
                    serverSocket.send(sendPacket);
                }
                else if (params[1].equals("3")){
                    String str_L = s.toLowerCase();
                    sendPacket =
                            new DatagramPacket(str_L.getBytes(), str_L.getBytes().length, IP, port);
                    serverSocket.send(sendPacket);
                }
                else if (params[1].equals("4")){
                    String str = params[2].concat(params[3]);
                    sendPacket =
                            new DatagramPacket(str.getBytes(), str.getBytes().length, IP, port);
                    serverSocket.send(sendPacket);
                }
                else if (params[1].equals("5")){
                    boolean x = params[2].equals(params[3]);
                    sendPacket =
                            new DatagramPacket(String.valueOf(x).getBytes(), String.valueOf(x).getBytes().length, IP, port);
                    serverSocket.send(sendPacket);
                }
                else if (params[1].equals("6")){
                    String sub_str = s.substring(s.length());
                    sendPacket =
                            new DatagramPacket(sub_str.getBytes(), sub_str.getBytes().length, IP, port);
                    serverSocket.send(sendPacket);

                }
                else {
                    System.out.println("error");
                }
            }
            /*Client 4 ended*/


        }

    }
}
