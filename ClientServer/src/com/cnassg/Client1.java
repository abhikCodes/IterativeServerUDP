package com.cnassg;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client1 {
    private JButton OKButton;
    private JPanel panel1;
    private JRadioButton simpleInterestRadioButton;
    private JRadioButton trigonometryRadioButton;
    private JTextArea textArea1;
    private int ID;


    public Client1() throws Exception{

        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress IP = InetAddress.getLocalHost();

        simpleInterestRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ID = 1;
                JOptionPane.showMessageDialog(null, "Enter P, R, T in the below textField in the form (1,P R T)");

            }
        });
        trigonometryRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ID = 2;
                JOptionPane.showMessageDialog(null, "Enter data in the form of (1,sin $)");
            }
        });
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(ID == 1)
                {
                    String data = textArea1.getText();
                    DatagramPacket sendPacket1 = new DatagramPacket(data.getBytes(), data.getBytes().length , IP , 8824);
                    System.out.println("data is:" + data + sendPacket1.getData());
                    try {
                        clientSocket.send(sendPacket1);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    byte[] recieveData = new byte[1024];
                    DatagramPacket recievePacket1 = new DatagramPacket(recieveData, recieveData.length);
                    try {
                        clientSocket.receive(recievePacket1);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    String answer = new String(recievePacket1.getData());
                    JOptionPane.showMessageDialog(null, "The simple Interest is:"+answer);
                }
                else if (ID == 2)
                {
                    String data = textArea1.getText();
                    DatagramPacket sendPacket2 = new DatagramPacket(data.getBytes(), data.getBytes().length, IP, 8824);
                    try {
                        clientSocket.send(sendPacket2);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    byte[] recieveData = new byte[1024];
                    DatagramPacket recievePacket2 = new DatagramPacket(recieveData, recieveData.length);
                    try {
                        clientSocket.receive(recievePacket2);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    String answer = new String(recievePacket2.getData());
                    JOptionPane.showMessageDialog(null, "The answer is:"+answer);

                }
            }
        });
//        clientSocket.close();
    }

    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame("Client1");
        frame.setContentPane(new Client1().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
