package com.cnassg;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client2 {
    private JButton OKButton;
    private JPanel panel1;
    private JRadioButton vowelsRadioButton;
    private JRadioButton consonantsRadioButton;
    private JTextArea textArea1;
    private int ID;


    public Client2() throws Exception{

        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress IP = InetAddress.getLocalHost();

        consonantsRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ID = 1;
                JOptionPane.showMessageDialog(null, "Enter your sentence as:(2,1,sentence)");
            }
        });
        vowelsRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ID = 2;
                JOptionPane.showMessageDialog(null, "Enter your sentence as:(2,2,sentence)");
            }
        });
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String data = textArea1.getText();
                DatagramPacket sendPacket =
                        new DatagramPacket(data.getBytes(), data.getBytes().length , IP, 8824);
                try {
                    clientSocket.send(sendPacket);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                byte[] recieveData = new byte[1024];
                if (ID == 1) {
                    DatagramPacket recievePacket1 = new DatagramPacket(recieveData, recieveData.length);
                    try {
                        clientSocket.receive(recievePacket1);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    String answer = new String(recievePacket1.getData());
                    JOptionPane.showMessageDialog(null, "No.of consonants are: " + answer);
                }
                else if (ID == 2){
                    DatagramPacket recievePacket2 = new DatagramPacket(recieveData, recieveData.length);
                    try {
                        clientSocket.receive(recievePacket2);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    String answer = new String(recievePacket2.getData());
                    JOptionPane.showMessageDialog(null, "No.of vowels are: " + answer);

                }
            }
        });
    }

    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame("Client2");
        frame.setContentPane(new Client2().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
