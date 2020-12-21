package com.example.demoforkafka;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Test {

    @SuppressWarnings("all")
    public static void main(String[] args) throws Exception {
//        ConcurrentNavigableMap<String, String> concurrentNavigableMap = new ConcurrentSkipListMap<>();
//        concurrentNavigableMap.put("1", "111");
//        concurrentNavigableMap.put("3", "111");
//        System.out.println(concurrentNavigableMap.higherEntry("2"));
//
////        MappedByteBuffer byteBuffer = null;
//
//        String fileName = "/Users/wangjiankai/IdeaProjects/wangjiankai/demo-for-kafka/mmapfile";
//        if (! new File(fileName).exists()) {
//            new File(fileName).createNewFile();
//        }
//
//        RandomAccessFile randomAccessFile = new RandomAccessFile(fileName, "rw");
//        randomAccessFile.setLength(1024L);
//        MappedByteBuffer mappedByteBuffer = randomAccessFile.getChannel().map(FileChannel.MapMode.READ_WRITE,
//                0, randomAccessFile.length());
//        System.out.println(mappedByteBuffer.limit());
////        mappedByteBuffer.putInt(100);
//        System.out.println(mappedByteBuffer.getInt());


        String fileName = "/Users/wangjiankai/IdeaProjects/wangjiankai/demo-for-kafka/okk";
        if (! new File(fileName).exists()) {
            new File(fileName).createNewFile();
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(fileName, "rw");
//        randomAccessFile.setLength(1024);
        FileChannel fileChannel = randomAccessFile.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(100);
        System.out.println(fileChannel.size());
        int read = fileChannel.read(byteBuffer);
        System.out.println(read);
        System.out.println(byteBuffer);
        System.out.println(byteBuffer.hasRemaining());

//        ByteBuffer byteBuffer = ByteBuffer.allocate(4);
//        byteBuffer.putInt(100);
//        byteBuffer.flip();
//        int write = fileChannel.write(byteBuffer);
//        System.out.println("写入的数据量为：" + write);
        fileChannel.close();


    }
}
