package com.lamda.web.proxy;

import com.lamda.web.movie.Movie;
import com.lamda.web.movie.MovieRepository;
import com.lamda.web.music.Music;
import com.lamda.web.music.MusicRepository;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service("crawler") @Lazy
public class Crawler extends Proxy{
    @Autowired Inventory<Music> inventory;
    @Autowired Box<String> box;
    @Autowired MusicRepository musicRepository;
    @Autowired MovieRepository movieRepository;

    public void bugsMusic(){
        inventory.clear();
        try{
            String url = "https://music.bugs.co.kr/chart";
            Connection.Response homepage = Jsoup.connect(url).method(Connection.Method.GET)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36")
                    .execute();
            Document d = homepage.parse();
            Elements title = d.select("p.title");
            Elements artist = d.select("p.artist");
            Elements thumbnail = d.select("a.thumbnail");
            Music music = null;
            for(int i=0; i<title.size(); i++){
                music = new Music();
                music.setSeq(string(i+1));
                music.setTitle(title.get(i).text());
                music.setArtist(artist.get(i).text());
                music.setThumbnail(thumbnail.get(i).select("img").attr("src"));
                musicRepository.save(music);
            }
        }catch (Exception e) {
            print("에러발생");
        }
    }
    public void naverMovie(){
        inventory.clear();
        try{
            String url = "https://movie.naver.com/movie/sdb/rank/rmovie.nhn";
            Connection.Response homepage = Jsoup.connect(url).method(Connection.Method.GET)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36")
                    .execute();
            Document d = homepage.parse();
            Elements title = d.select("div.tit3");
            Movie movie = null;
            String date = string(new Date());
            for(int i=0; i<title.size(); i++){
                movie = new Movie();
                movie.setRank(string(i+1));
                movie.setTitle(title.get(i).text());
                movie.setRankDate(date);
                movieRepository.save(movie);
            }
        }catch (Exception e){
            print("네이버영화 에러");
        }
    }
}