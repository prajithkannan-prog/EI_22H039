interface MediaPlayer {
    void play(String filename);
}

class MP3Player implements MediaPlayer {
    public void play(String filename) {
        System.out.println("Playing MP3 file: " + filename);
    }
}

class MP4Player {
    public void playMP4(String filename) {
        System.out.println("Playing MP4 file: " + filename);
    }
}

class MediaAdapter implements MediaPlayer {
    private MP4Player mp4Player;

    public MediaAdapter(MP4Player mp4Player) {
        this.mp4Player = mp4Player;
    }

    public void play(String filename) {
        mp4Player.playMP4(filename);
    }
}

public class AdapterDemo {
    public static void main(String[] args) {
        MediaPlayer mp3 = new MP3Player();
        mp3.play("song.mp3");

        MediaPlayer mp4 = new MediaAdapter(new MP4Player());
        mp4.play("video.mp4");
    }
}
