package test;

import java.io.*;
import java.util.LinkedList;

public class music {

        LinkedList<String>  Lyricslist=new LinkedList<>();

        LinkedList<String>  Lyrics =new LinkedList<>();
        LinkedList<Integer>  Lyricstime =new LinkedList<>();
        String name;
        String songer;
        String time;
        String playFileDirectory;

        music(String na,String ti){
            this.name=na;
            this.time=ti;

        }

        void loadlyrics(String path, String name){
            int n =0;
            String Lyricspath =path+name+".txt";
            File filename = new File(Lyricspath);
            InputStreamReader reader = null;


            try {
                reader = new InputStreamReader(new FileInputStream(filename));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            BufferedReader br = new BufferedReader(reader);
            String line = "";
            String [] split = {"","",""};


            try {
                while((line =br.readLine()) != null){
                    if(n==0){
                        Lyricslist.add(line);
                        n++;
                    }

                    else{
                        split = line.split(" ");
                        Lyricslist.add(split[0]);
                        Lyricslist.add(split[1]);
                        Lyricslist.add(split[2]);
                        n++;
                }

                }
            } catch (IOException e) {
                e.printStackTrace();
            }


            int x =0;
            for (x=0 ;x<(Lyricslist.size() -1) /3 ;x++){

               Lyricstime.add(Integer.parseInt(Lyricslist.get(x*3+1)));
               Lyricstime.add(Integer.parseInt(Lyricslist.get(x*3+2)));
               Lyrics.add(Lyricslist.get(x*3+3)+"\n");




            }
        }

            int timetransform(String s){
                String []t ={"",""};
                t=s.split(":");
                return Integer.parseInt(t[0])+Integer.parseInt(t[1]);
            }
}
