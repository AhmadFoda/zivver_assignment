package com.bulkprocessing;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class MakeFile {
    public static void main(String[] args) throws IOException {
       makeFile();

    }
    public static void makeFile() {
        try {
            File file = new File(Configuration.FILE_NAME);
            OutputStream outputStream = new FileOutputStream(file);
            Random random = new Random();
            int productId;
            String countryCode;
            Object[] values = Configuration.COUNTRY_CODE_MAP.values().toArray();
            for (int i = 0; i < 90000000; i++) {
                productId = random.ints(0, 244).findAny().getAsInt();
                countryCode = (String) values[random.ints(0, 243).findAny().getAsInt()];
                outputStream.write((productId + ", " + countryCode).getBytes(StandardCharsets.UTF_8));
                outputStream.write("\n".getBytes(StandardCharsets.UTF_8));
            }
            outputStream.close();
        }catch(IOException exception){
           Configuration.logger.warning("Error while making file with message "+
                   exception.getMessage());
        }
     }

}
