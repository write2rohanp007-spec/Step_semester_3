package encapsulation.assigment_problems;

public class Playlist {
      private final String[] songs;
      private int songCount;

    public Playlist(int maxSize) {
              songs = new String[maxSize];
              songCount = 0;
    }

    public void addSong(String title) {
              if (songCount < songs.length) {
                            songs[songCount++] = title;
              }
    }

    public String[] getSongs() {
              String[] copy = new String[songCount];
              System.arraycopy(songs, 0, copy, 0, songCount);
              return copy;
    }

    public int getSongCount() {
              return songCount;
    }

    public static void main(String[] args) {
              Playlist p = new Playlist(10);
              p.addSong("Song A");
              p.addSong("Song B");
              String[] copy = p.getSongs();
              System.out.println("Songs in playlist: " + p.getSongCount());
              System.out.println("First song: " + copy[0]);
              copy[0] = "Hacked";
              System.out.println("After modifying copy, playlist still has: " + p.getSongs()[0]);
    }
}
