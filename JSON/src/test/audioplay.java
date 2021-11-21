package test;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.MalformedURLException;
import java.net.URL;

public class audioplay {

    AudioClip adc ;
    URL url;
    boolean adcFlag = false;
    boolean playFlag = false;



    void SerPlayAudioPath(String path){

        try {
            url = new URL(path);
            if(adcFlag==true){
                adc.stop();
                playFlag=false;
            }
            adc = Applet.newAudioClip(url);
            adcFlag=true;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


    }
        void play(){
        adc.play();
        playFlag=true;
        }

        void stop(){
        adc.stop();
        playFlag=false;

        }
}
