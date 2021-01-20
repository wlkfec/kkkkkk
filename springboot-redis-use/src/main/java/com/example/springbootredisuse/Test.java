package com.example.springbootredisuse;

import java.net.InetAddress;

public class Test {

    public static void main(String[] args) {
        try {
            InetAddress addr = InetAddress.getLocalHost();
            System.out.println(addr.getHostName() + "-" + addr.getHostAddress());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


// iZuf620kp0myovud88psn2Z-172.19.233.214
// iZuf6etbb1qeqgmet3b8y5Z-172.19.78.108
