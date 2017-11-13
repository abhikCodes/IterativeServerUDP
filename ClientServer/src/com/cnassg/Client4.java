package com.cnassg;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client4 {
    private JButton OKButton;
    private JPanel panel1;
    private JTextArea textArea1;
    private JRadioButton lengthOfTheStringRadioButton;
    private JRadioButton convertToUppercaseRadioButton;
    private JRadioButton convertToLowercaseRadioButton;
    private JRadioButton concatenateTwoStringsRadioButton;
    private JRadioButton compareTwoStringsRadioButton;
    private JRadioButton findSubstringRadioButton;
    private int ID;

    public Client4() throws Exception{

        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress IP = InetAddress.getLocalHost();

        lengthOfTheStringRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ID = 1;
                JOptionPane.showMessageDialog(null, "Enter string in the format: (4,1,sentence)");
            }
        });
        convertToUppercaseRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ID = 2;
                JOptionPane.showMessageDialog(null, "Enter string in the format: (4,2,sentence)");
            }
        });
        convertToLowercaseRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ID = 3;
                JOptionPane.showMessageDialog(null, "Enter string in the format: (4,3,sentence)");
            }
        });
        concatenateTwoStringsRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ID = 4;
                JOptionPane.showMessageDialog(null, "Enter string in the format: (4,4,sentence1,sentence2)");
            }
        });
        compareTwoStringsRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ID = 5;
                JOptionPane.showMessageDialog(null, "Enter string in the format: (4,5,sentence1,sentence2)");
            }
        });
        findSubstringRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ID = 6;
                JOptionPane.showMessageDialog(null, "Enter string in the format: (4,6,sentence)");
            }
        });
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String data = textArea1.getText();
                DatagramPacket sendPacket =
                        new DatagramPacket(data.getBytes(), data.getBytes().length, IP, 8824);

                switch(ID)
                {

                    case 1:
                        try {
                            clientSocket.send(sendPacket);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        byte[] recieveData1 = new byte[1024];
                        DatagramPacket recievePacket1 = new DatagramPacket(recieveData1, recieveData1.length);
                        try {
                            clientSocket.receive(recievePacket1);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        String answer1 = new String(recievePacket1.getData());
                        JOptionPane.showMessageDialog(null,"The length of the string is:"+answer1);
                        break;

                    case 2:
                        try {
                            clientSocket.send(sendPacket);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        byte[] recieveData2 = new byte[1024];
                        DatagramPacket recievePacket2 = new DatagramPacket(recieveData2, recieveData2.length);
                        try {
                            clientSocket.receive(recievePacket2);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        String answer2 = new String(recievePacket2.getData());
                        JOptionPane.showMessageDialog(null,"The UpperCase string is:"+answer2);
                        break;

                    case 3:
                        try {
                            clientSocket.send(sendPacket);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        byte[] recieveData3 = new byte[1024];
                        DatagramPacket recievePacket3 = new DatagramPacket(recieveData3, recieveData3.length);
                        try {
                            clientSocket.receive(recievePacket3);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        String answer3 = new String(recievePacket3.getData());
                        JOptionPane.showMessageDialog(null,"The LowerCase string is:"+answer3);
                        break;

                    case 4:
                        try {
                            clientSocket.send(sendPacket);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        byte[] recieveData4 = new byte[1024];
                        DatagramPacket recievePacket4 = new DatagramPacket(recieveData4, recieveData4.length);
                        try {
                            clientSocket.receive(recievePacket4);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        String answer4 = new String(recievePacket4.getData());
                        JOptionPane.showMessageDialog(null,"The Concatenated string is:"+answer4);
                        break;

                    case 5:
                        try {
                            clientSocket.send(sendPacket);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        byte[] recieveData5 = new byte[1024];
                        DatagramPacket recievePacket5 = new DatagramPacket(recieveData5, recieveData5.length);
                        try {
                            clientSocket.receive(recievePacket5);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        String answer5 = new String(recievePacket5.getData());
                        JOptionPane.showMessageDialog(null,"The Strings are:"+answer5);
                        break;

                    case 6:
                        try {
                            clientSocket.send(sendPacket);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        byte[] recieveData6 = new byte[1024];
                        DatagramPacket recievePacket6 = new DatagramPacket(recieveData6, recieveData6.length);
                        try {
                            clientSocket.receive(recievePacket6);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        String answer6 = new String(recievePacket6.getData());
                        JOptionPane.showMessageDialog(null,"The SubString is:"+answer6);
                        break;

                    default:
                        System.out.println("Wrong");
                        JOptionPane.showMessageDialog(null, "Something is wrong!!!!!!!!!!!!");
                        break;
                }
            }
        });
    }
    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame("Client4");
        frame.setContentPane(new Client4().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
