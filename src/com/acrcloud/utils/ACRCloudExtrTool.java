package com.acrcloud.utils;

import org.apache.log4j.Logger;

/**
 * Created by balu.s on 27-Nov-16.
 */
public class ACRCloudExtrTool {


    private static Logger logger = Logger.getLogger(ACRCloudExtrTool.class);
    
    static {
        try{
          logger.info("Inside Loader");
            System.loadLibrary("acrcloud_extr_tool");
            native_init();
        } catch (UnsatisfiedLinkError e) {
         logger.error("acrcloud_extr_tool loadLibrary error!");
          e.printStackTrace();
        }catch(Exception e){
          logger.error("acrcloud_extr_tool loadLibrary error!");
        }
    }

    public ACRCloudExtrTool(){
    }

    public static byte[]createFingerprintByFile(String fileName,int startTimeSeconds,int audioLenSeconds,boolean isDB){
        if(fileName==null||"".equals(fileName)){
            return null;
        }
        return native_create_fingerprint_by_file(fileName,startTimeSeconds,audioLenSeconds,isDB);
    }

    public static byte[]createFingerprintByFileBuffer(byte[]dataBuffer,int dataBufferLen,int startTimeSeconds,int audioLenSeconds,boolean isDB){
        if(dataBuffer==null||dataBufferLen<=0){
            return null;
        }
        return native_create_fingerprint_by_filebuffer(dataBuffer,dataBufferLen,startTimeSeconds,audioLenSeconds,isDB);
    }

    public static byte[]createFingerprint(byte[]dataBuffer,int dataBufferLen,boolean isDB){
        if(dataBuffer==null||dataBufferLen<=0){
            return null;
        }
        return native_create_fingerprint(dataBuffer,dataBufferLen,isDB);
    }

    public static byte[]decodeAudioByFile(String fileName,int startTimeSeconds,int audioLenSeconds){
        if(fileName==null||"".equals(fileName)){
            return null;
        }
        return native_decode_audio_by_file(fileName,startTimeSeconds,audioLenSeconds);
    }

    public static byte[]decodeAudioByFileBuffer(byte[]dataBuffer,int dataBufferLen,int startTimeSeconds,int audioLenSeconds){
        if(dataBuffer==null||dataBufferLen<=0){
            return null;
        }
        return native_decode_audio_by_filebuffer(dataBuffer,dataBufferLen,startTimeSeconds,audioLenSeconds);
    }

    public static void setDebug(){
        native_set_debug();
    }

    public static String getDoc(){
        return native_get_doc();
    }

    public static int getDurationMSByFile(String fileName){
        if(fileName==null||"".equals(fileName)){
            return 0;
        }
        return native_get_duration_ms_by_file(fileName);
    }

    private static native void native_init();
    private static native byte[]native_create_fingerprint_by_file(String file_name,int start_time_seconds,int audio_len_seconds,boolean is_db_fingerprint);
    private static native byte[]native_create_fingerprint_by_filebuffer(byte[]data_buffer,int data_buffer_len,int start_time_seconds,int audio_len_seconds,boolean is_db_fingerprint);
    private static native byte[]native_create_fingerprint(byte[]wav_data_buffer,int wav_data_buffer_len,boolean is_db_fingerprint);
    private static native byte[]native_decode_audio_by_file(String file_name,int start_time_seconds,int audio_len_seconds);
    private static native byte[]native_decode_audio_by_filebuffer(byte[]data_buffer,int data_buffer_len,int start_time_seconds,int audio_len_seconds);
    private static native void native_set_debug();
    private static native int native_get_duration_ms_by_file(String file_name);
    private static native String native_get_doc();

}
