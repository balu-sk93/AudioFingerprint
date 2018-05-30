package action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.acrcloud.utils.ACRCloudExtrTool;
import com.acrcloud.utils.ACRCloudRecognizer;
import com.google.gson.Gson;

import response.Resposne;

/**
 * Created by balu.s on 27-Nov-16.
 */
public class AudioRecognizer {
  
    
    private static Logger logger = Logger.getLogger(AudioRecognizer.class);

    public String doRecognize(String filePath) {
        Map<String, Object> config = new HashMap<String, Object>();
        // Replace "xxxxxxxx" below with your project's access_key and access_secret.
        config.put("host", "ap-southeast-1.api.acrcloud.com");
        config.put("access_key", "xxxxxxxx");
        config.put("access_secret", "xxxxxxxx");
        config.put("debug", false);
        config.put("timeout", 10); // seconds

        ACRCloudRecognizer re = new ACRCloudRecognizer(config);


        /**
         *
         *  recognize by file path of (Formatter: Audio/Video)
         *     Audio: mp3, wav, m4a, flac, aac, amr, ape, ogg ...
         *     Video: mp4, mkv, wmv, flv, ts, avi ...
         *
         *
         **/
        // It will skip 0 seconds.
        String result = re.recognizeByFile(filePath, 0);

        int fileDurationMS = ACRCloudExtrTool.getDurationMSByFile(filePath);
        System.out.println("duration_ms = "+fileDurationMS);



        /**
         *
         *  recognize by buffer of (Formatter: Audio/Video)
         *     Audio: mp3, wav, m4a, flac, aac, amr, ape, ogg ...
         *     Video: mp4, mkv, wmv, flv, ts, avi ...
         *
         *
         **/
        File file = new File(filePath);
        byte[] buffer = new byte[(int)file.length()];
        if (!file.exists()) {
            return "Invalid File";
        }
        FileInputStream fin = null;
        int bufferLen = 0;
        try {
            fin = new FileInputStream(file);
            bufferLen = fin.read(buffer, 0, buffer.length);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fin != null) {
                    fin.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        logger.info("bufferLen=" + bufferLen);

        if (bufferLen <= 0)
          return "Invalid File";

        // It will skip 80 seconds from the begginning of (buffer).
        String songName = null;
        result = re.recognizeByFileBuffer(buffer, bufferLen, 0);
        Gson gson  =new Gson();
        Resposne getResponse = gson.fromJson(result, Resposne.class);
        logger.info(result);
        if (getResponse.getStatus().getCode()!=1001) {
          songName=getResponse.getMetadata().getMusic().get(0).getTitle();
          logger.info("Song Name:"+songName);
        }
        if (songName!=null) {
          file.renameTo(new File("C:\\Converted\\"+songName+".mp3"));
          logger.info("File Saved as : "+"C:\\Converted\\"+songName+".mp3");
          return songName;
        }

        return getResponse.getStatus().getMsg();
    }



}
