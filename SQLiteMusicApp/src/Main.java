import model.Artist;
import model.Datasource;
import model.SongArtist;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Datasource datasource = new Datasource();
        if(!datasource.open()) {
            System.out.println("Can't open datasource");
            return;
        }

        List<Artist> artists = datasource.queryArtists(5);
        if(artists == null) {
            System.out.println("No artists..!!");
            return;
        }

        for(Artist artist: artists) {
            System.out.println("ID = " + artist.getId() + ", Name = " + artist.getName());
        }

        List<String> albumsForArtist =
                datasource.queryAlbumsForArtist("Iron Maiden", Datasource.ORDER_BY_ASC);

        for(String album : albumsForArtist) {
            System.out.println(album);
        }

        List<SongArtist> songArtists = datasource.queryArtistsForSong("Go Your Own Way", Datasource.ORDER_BY_ASC);
        if(songArtists == null) {
            System.out.println("Couldn't find the artist for the song");
            return;
        }

        for(SongArtist artist : songArtists) {
            System.out.println("Artist name = " + artist.getArtistName() +
                    " Album name = " + artist.getAlbumName() +
                    " Track = " + artist.getTrack());
        }

        datasource.querySongsMetadata();

        int count = datasource.getCount(Datasource.TABLE_SONGS);
        System.out.println("Number of songs is: " + count);

        datasource.createViewForSongArtists();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a song title: ");
        String title = scanner.nextLine();

        songArtists = datasource.querySongInfoView(title);
        if(songArtists.isEmpty()) {
            System.out.println("Couldn't find the artist for the song");
            return;
        }

        for(SongArtist artist : songArtists) {
            System.out.println("FROM VIEW - Artist name = " + artist.getArtistName() +
                    " Album name = " + artist.getAlbumName() +
                    " Track number = " + artist.getTrack());
        }

        System.out.println("Enter a song title: ");
        title = scanner.nextLine();

        songArtists = datasource.querySongInfoViewPrepStatement2(title);
        if(songArtists.isEmpty()) {
            System.out.println("Couldn't find the artist for the song");
            return;
        }

        for(SongArtist artist : songArtists) {
            System.out.println("FROM VIEW - Artist name = " + artist.getArtistName() +
                    " Album name = " + artist.getAlbumName() +
                    " Track number = " + artist.getTrack());
        }

        datasource.close();

        // NORMAL STATEMENTS
        // SELECT name, album, track FROM artist_list WHERE title = "Go Your Own Way" or 1=1 or ""

        // PREPARED STATEMENT
        // SELECT name, album, track FROM artist_list WHERE title = "Go Your Own Way or 1=1 or ""

        /**
         * PREPARED STATEMENTS
         * 1. Declare constant for SQL statement that contains placeholders.
         * 2. Create PreparedStatement instance using Connection.preparestatement(sqlStmtString)
         * 3. When we are ready to perform the query (insert/update/delete), we call the appropriate setter
         *      methods to set the placeholders o the values  want to use in the statement.
         * 4. We run the statement using PreparedStatement.execute() OR PreparedStatement.executeQuery()
         * 5. We process the results the same way  do when using regular old statement.
         *
         *
         * NOTE:
         * JDBC Connection class auto commits the changes by default every time we call execute()
         * to insert, update, delete, those changes are saved to the database as soon as QL statements completes.
         *
         * TRANSACTIONS:
         * A transaction is a sequence of SQL statements which are treated as  single logical unit.
         * If any of the statements fails, the result of any previous statements in the transaction can be rolled back
         * or just not saved. It is as if they never happened.
         * */
    }
}