interface MediaPlayer {
    void playMp4();
}

interface AudioPlayer {
    void playMp3();
}

class Media implements MediaPlayer {
    String video;
    public Media(String video){
        this.video=video;
    }
    public void playMp4(){
        System.out.println("Playing " + video);
    }
}

class Audio implements AudioPlayer {
    String audio;
    public Audio(String audio){
        this.audio=audio;
    }
    public void playMp3(){
        System.out.println("Playing "+audio);
    }
}
class PlayerDevice{
    public void playMp4(MediaPlayer mediaPlayer){
        mediaPlayer.playMp4();
    }
}

class Adapter implements MediaPlayer{
    Audio audio;
    public Adapter(Audio audio){
        this.audio = audio;
    }
    public void playMp4(){
        this.audio.playMp3();
    }
}
public class Problem3_Adapter{
    public static void main(String[] args) {
        Media media=new Media("video");
        Audio audio=new Audio("audio");
        Adapter adapter=new Adapter(audio);
        PlayerDevice device=new PlayerDevice();
        device.playMp4(media);
        adapter.playMp4(adapter);
    }
}
