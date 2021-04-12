package com.bulkprocessing;

import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class ProcessFile {
    static final Logger logger =Logger.getLogger("ProcessFile");
    static final String FILENAME = "test.csv";
    static final String READ_MODE = "r";
    static final String WRITE_MODE = "rw";
    static final String TARGET_FILENAME = "result.csv";
    static final int POSITION = 0;

    public static void main(String[] args)  {
        File file = new File("demo/test.csv");
        file.canRead();
        groupProducts();
    }

    public static void groupProducts()   {
        logger.info("Start grouping process .");
        MappedByteBuffer mappedByteBuffer = getMappedByteBuffer();
        Map<String,StringBuilder> productMap=
                readProductIdMap(mappedByteBuffer);
        File file = new File(TARGET_FILENAME);
        writeOnFile(file, productMap);
        logger.info("Finished grouping process .");

    }
    private static Map<String, StringBuilder> readProductIdMap(MappedByteBuffer mappedByteBuffer){
        Map<String, StringBuilder> productMap =
                new HashMap<>();
        StringBuilder id = new StringBuilder();
        StringBuilder countryCode = new StringBuilder();
        for (int i = 0; i < mappedByteBuffer.limit()-2; i++)
        {
            char current = (char) mappedByteBuffer.get();
            if (Character.isDigit(current)){
                id.append(current);
            }else if (Character.isAlphabetic(current))
            {
                countryCode.append(current);
            } else if (current ==' '){
                countryCode = new StringBuilder((char) mappedByteBuffer.get(i + 1) + "" +
                        (char) mappedByteBuffer.get(i + 2) + "");

                StringBuilder stringBuilder = productMap.get(id.toString());
                if (stringBuilder == null)
                {
                    stringBuilder = new StringBuilder(countryCode);
                } else stringBuilder.append(", ").append(countryCode);


                productMap.put(id.toString(),stringBuilder);

                id = new StringBuilder();
                countryCode = new StringBuilder();
            }
        }
        return productMap;
    }
    private static void writeOnFile(File file,Map<String, StringBuilder> productMap){
      try{
          logger.info("Start writing on "+file.getName());

          RandomAccessFile randomAccessFile =
                  new RandomAccessFile(file.getName(), WRITE_MODE);
          MappedByteBuffer out = randomAccessFile.getChannel()
                  .map(FileChannel.MapMode.READ_WRITE, 0, (long) 7e+8);
                for (String key:
                        productMap.keySet()) {
                    String lineToWrite =
                            key+" -> "+productMap.get(key).toString() +
                                    System.getProperty("line.separator");
                    out.put(lineToWrite.getBytes(StandardCharsets.ISO_8859_1));
                }
            randomAccessFile.getChannel().truncate(out.position());
            out.force();
            randomAccessFile.close();

      } catch (IOException exception){
          logger.warning("IO Error while writing the file with Message" +
                  exception.getMessage());
      }
        logger.info("Finished writing.");

    }
    private static MappedByteBuffer getMappedByteBuffer() {
        logger.info("Get Mapping buffer .");
        MappedByteBuffer mappedByteBuffer = null;
        RandomAccessFile randomAccessFile;
        try {
        randomAccessFile = new RandomAccessFile(FILENAME, READ_MODE);
        FileChannel channel = randomAccessFile.getChannel();
        mappedByteBuffer =
                channel.map(FileChannel.MapMode.READ_ONLY, POSITION, channel.size());

        mappedByteBuffer.load();
        mappedByteBuffer.clear();
        } catch (IOException e) {
            logger.warning("IO Error with message : " + e.getMessage());
        }
        return mappedByteBuffer;
    }
}
