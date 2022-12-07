package com.music_edu.container;

import static com.music_edu.music.MusicGenre.*;
import com.music_edu.music.Track;
import com.music_edu.music.TrackDuration;
import com.music_edu.music_system.MusicSystem;

import java.util.ArrayList;
import java.util.List;

public class Disk {
    private List<Track> tracks = new ArrayList<>();
    private MusicSystem system = new MusicSystem();

    public Disk() {
        tracks.add(new Track("Нервы - кофе мой друг", 2, 6, HIPHOP));
        tracks.add(new Track("Imagine Dragons - Dream", 2, 49, HIPHOP));
        tracks.add(new Track("Океан Ельзи - Небо", 4,13, ALTERNATIVE_ROCK));
        tracks.add(new Track("The Weeknd - I was never there", 2, 37, ELECTRO));
        tracks.add(new Track("ENLEO - Веди мене в храм", 3, 32, POP_ROCK));
        tracks.add(new Track("KOLA - Листопад", 4, 9, POP_ROCK));
        tracks.add(new Track("KOLA - Чи разом?", 3, 28, ALTERNATIVE_ROCK));
        tracks.add(new Track("KALUSH - Стефанія", 5, 49, ALTERNATIVE_ROCK));

        system.getTracks(tracks);
        system.getTotalDuration(tracks);
        system.sortingByStyle(tracks, ALTERNATIVE_ROCK);
        TrackDuration start = new TrackDuration("startDuration",2,20);
        TrackDuration finish = new TrackDuration("finishDuration",3,3);
        system.findByRange(start, finish, tracks);
    }
}
