package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeCtrl {
    @Autowired AlbumRepository albumRepository;

    @Autowired SongRepository songRepository;

    @RequestMapping("/")
    public String index(Model model) {
        // create 2 songs
        Song song1 = new Song();
        song1.setName("Mary Had a Little Lamb");
        Song song2 = new Song();
        song2.setName("Twinkle Twinkle");
        // create songs hashset & add 2 songs
        Set<Song> songs = new HashSet<Song>();
        songs.add(song1);
        songs.add(song2);
        // create album & add songs hashset
        Album album = new Album();
        album.setName("Kidz Bop Volume 1");
        album.setGenre("Bop");
        album.setYear(2000);
        album.setSongs(songs);
        // save album to repo
        albumRepository.save(album);
        // get all albums from db and send to template
        model.addAttribute("albums", albumRepository.findAll());
        return "index";
    }

    @RequestMapping("/addalbum")
}
