package test;



import com.sun.xml.internal.ws.runtime.config.TubelineFeatureReader;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.nio.channels.NotYetBoundException;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;



public class MyExtendsJFrame extends JFrame implements ActionListener, MouseListener {


    JLabel background;
    JLabel background1;
    JLabel background2;
    JLabel picture;
    JButton aaa;
    JButton buttonPlay;
    JButton buttonStop;
    JButton buttonPlay1;
    JButton buttonPlay2;
    JButton buttonPlay3;
    JButton buttonPlay4;
    JTextPane textLyrics;
    JLabel playTime;
    JList listPlayFile;
    Timer nTimer;
    JTextArea textarea;
    JTextArea textarea1;
    JTextArea runtime;
    JLabel gif;
    audioplay audioPlay;
    LinkedList<music>mylist;
    Vector<String> vt1 = new Vector<>();

    public  MyExtendsJFrame(){
        audioPlay=new audioplay();
        mylist=new LinkedList<music>();
        setTitle("播放器");
        setBounds(100,100,800,537);
        setLayout(null);
        init();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //EXIT_ON_CLOSE



    }

    void init(){
        Icon img = new ImageIcon(".//backGround1.jpg");
        background =new JLabel(img);
        background.setBounds(0,0,800,500);
        getLayeredPane().add(background,new Integer(Integer.MAX_VALUE));
        ((JPanel)getContentPane()).setOpaque(false);

        Icon img3 = new ImageIcon(".//time.jpg");
        background2 = new JLabel(img3);
        background2.setBounds(220,450,300,3);
        getLayeredPane().add(background2,new Integer(Integer.MAX_VALUE+2));
        ((JPanel)getContentPane()).setOpaque(false);

        Icon img1 = new ImageIcon(".//y.gif");
        gif = new JLabel(img1);
        gif.setBounds(230,72,240,240);
        add(gif);

        runtime = new JTextArea("00 : 00");
        runtime.setBounds(540,440,30,30);
        runtime.setForeground(Color.WHITE);
        runtime.setOpaque(false);

        buttonPlay1.setVisible(true); //
        buttonPlay = new JButton();
        buttonPlay.setBounds(350,400,38,38);
        Icon icon  = new ImageIcon(".//3.jpg");
        buttonPlay.setIcon(icon);
        buttonPlay.setBorderPainted(false);;
        buttonPlay.addActionListener(this);
        add(buttonPlay);


        buttonStop = new JButton();
        buttonStop.setBounds(350,400,38,38);
        Icon icon1 = new ImageIcon(".//5.jpg");
        buttonPlay1.setIcon(icon1);
        buttonPlay1.setBorderPainted(false);
        buttonPlay1.addActionListener(this);
        add(buttonPlay1);


        buttonPlay2 = new JButton();
        buttonPlay2.setBounds(308,400,30,30);
        Icon icon2 = new ImageIcon(".//6.jpg");
        buttonPlay2.setIcon(icon2);
        buttonPlay2.setBorderPainted(false);
        buttonPlay2.addActionListener(this);
        add(buttonPlay2);



        buttonPlay3 = new JButton();
        buttonPlay3.setBounds(600,400,30,30);
        Icon icon3 = new ImageIcon(".//6.jpg");
        buttonPlay3.setIcon(icon3);
        buttonPlay3.setBorderPainted(false);
        add(buttonPlay3);


        textarea = new JTextArea("");
        textarea.setBounds(100,405,100,25);
        textarea.setForeground(Color.WHITE);
        textarea.setOpaque(false);
        add(textarea);

        listPlayFile = new JList();
        listPlayFile.setBounds(500,100,150,150);
        listPlayFile.setOpaque(false);
        listPlayFile.setBackground(Color.white);
        add(listPlayFile);
        listPlayFile.addMouseListener(this);


        textLyrics = new JTextPane();
        textLyrics.setBounds(20,20,200,500);
        textLyrics.setForeground(Color.WHITE);
        textLyrics.setOpaque(false);
        add(textLyrics);
        textLyrics.setText("点击播放列表，选择歌曲进行播放 \n");


        Icon img2 = new ImageIcon(".//time.jpg");
        playTime = new JLabel(img2);
        playTime .setBounds(70,500,0,3);
        getLayeredPane().add(playTime,new Integer(Integer.MAX_VALUE+3));



    }

    public String timechange( int second){
        int min = second/60;
        int sec = second - min*60;
        String rt1 = String.format("%02d",min);
        String rt2 = String.format("%02d",sec);
        String rt = rt1+":"+rt2;
        return  rt;

    }

    public  void timerFun(int nPlayTime, music M) throws  Exception{
        if (nTimer!=null){
            nTimer.cancel();
        }
        nTimer = new Timer();
        nTimer.schedule(new TimerTask() {
            int ttt ;
            int eachPlayTime = 710/nPlayTime;
            int starttime=0;
            int minute = 0;
            int second =0;
            int longth = M.Lyrics.size();

            @Override
            public void run() {
                playTime.setBounds(200,450,((starttime+=eachPlayTime)/2),3);
                String rt = timechange(second);
                runtime.setText(rt);
                second = second +1;

                int n  = 0;

                print:for(n=0;n<longth;n++){
                    int m = 0;
                    SimpleAttributeSet set1 ,set2;
                    set1 = new SimpleAttributeSet();
                    set2 = new SimpleAttributeSet();
                    Document doc;

                    doc = textLyrics.getDocument();
                    StyleConstants.setForeground(set1, Color.pink);
                    StyleConstants.setForeground(set2, Color.white);
                    for (m=0;m<longth;m++){
                        if (ttt>=M.Lyricstime.get(m*2) && ttt<=M.Lyricstime.get(m*2+1) && n==m){

                            try {
                                doc.insertString(doc.getLength(),M.Lyrics.get(m),set1);
                            } catch (BadLocationException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    try {
                        doc.insertString(doc.getLength(),M.Lyrics.get(n),set2);
                    } catch (BadLocationException e) {
                        e.printStackTrace();
                    }


                    ttt++;

                }


            }
        },0,1000);

    }

        public  void timeStop(){
        if(nTimer != null){
            nTimer.cancel();

        }
        playTime.setBounds(0,324,0,3);



        }




    @Override
    @SuppressWarnings("unchecked")
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==buttonPlay){
            if (mylist.size()!=0){
                buttonPlay.setVisible(false);
                audioPlay.SerPlayAudioPath("file:"+mylist.get(0).name);
                audioPlay.play();
                music mc = mylist.get(0);
                File file = new File(mc.name+".wav");

                int iMusicTime = (int)file.length();
                audioPlay.SerPlayAudioPath("file:" + mylist.get(0).name+".wav");
                audioPlay.play();
                try {
                    timerFun(iMusicTime,mc);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }


            }

        }
        if (e.getSource()==buttonStop){
            buttonPlay.setVisible(true);
            audioPlay.stop();
            timeStop();
        }

        if(e.getSource()==buttonPlay2){
            int Index = 0;
            int end =mylist.size()-1;
            for (int i=0 ; i<mylist.size();i++){
                if(mylist.get(i).name.equals(textarea.getText())){
                    Index=i;
                    break;

                }
            }
            if (Index == 0){
                Index=end;
            }else
                Index= Index-1;
                audioPlay.SerPlayAudioPath("file:"+mylist.get(Index).name+",wav");
                audioPlay.play();
                music mc = mylist.get(Index);
                textarea.setText(mc.name);
                textarea.setText(mc.Lyricslist.get(0));
                File file = new File(mc.name+"wav");
                int iMusicTime =(int)file.length();
            try {
                timerFun(iMusicTime,mc);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
                buttonPlay.setVisible(false);



        }
            if(e.getSource()==buttonPlay1){
                int Index =0;
                for(int i =0; i<mylist.size();i++){
                    if (mylist.get(i).name.equals(textarea.getText())){
                        Index=i;
                        break;

                    }

                }
                int end =mylist.size()-1;
                if (Index == end ){
                    Index=0;
                }else
                    Index=Index+1;
                audioPlay.SerPlayAudioPath("file:"+mylist.get(Index).name+"wav");
                audioPlay.play();
                music mc = mylist.get(Index);
                textarea.setText(mc.name);
                textarea1.setText(mc.Lyricslist.get(0));
                File file = new File(mc.name+".wav");
                int iMusicTime =(int)file.length()/1024/173;
                try {
                    timerFun(iMusicTime,mc);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                buttonPlay.setVisible(false);


            }

            if (e.getSource()==buttonPlay3){
                FileDialog openFile = new FileDialog(this,"打开文件");
                openFile.setVisible(true);
                String playFileName=openFile.getFile();
                String playName = playFileName.substring(0,playFileName.lastIndexOf("."));
                String playFileDirectory1 = openFile.getDirectory();
                String playFile = playFileDirectory1+playFileName;

                audioPlay.SerPlayAudioPath("file:"+playFile);
                audioPlay.play();


                File file = new File(playFileName);
                int iMusicTime = (int) file.length()/1024/173;


                buttonPlay.setVisible(false);
                music mc = new music(playName,timechange(iMusicTime));
                mc.playFileDirectory=playFileDirectory1;
                mc.loadlyrics(mc.playFileDirectory,playName);
                mylist.addFirst(mc);
                textarea.setText(playName);
                textarea.setText(mc.Lyricslist.get(0));
                int number0=mylist.size();
                try {
                    timerFun(iMusicTime,mc);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                int number=mylist.size();
                for (int i=0; i<number;i++){
                    music mc1 = mylist.get(i);
                    if (playFileName.equals(mc1.name)){
                        mylist.remove(i);
                        break;
                    }
                }
                Vector vt = new Vector();
                Vector vt0= new Vector();
                for(int k=0;k<number0;k++){
                    int j= k+1;
                    vt.add(j+"、"+mylist.get(k).name+mylist.get(k).time);
                    vt0.add(mylist.get(k).name);


                }
                vt1= vt0;
                listPlayFile.setListData(vt);

            }
    }



    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount()==2){
            if (e.getSource()==listPlayFile){
                int index = listPlayFile.getSelectedIndex();
                String str = vt1.get(index);
                music mc = mylist.get(index);

                textarea.setText(str);
                textarea1.setText(mc.Lyricslist.get(0));
                audioPlay.SerPlayAudioPath("file:" +str+".wav");
                audioPlay.play();
                int itime = mc.timetransform(mc.time);
                try {
                    timerFun(itime,mc);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }



}
