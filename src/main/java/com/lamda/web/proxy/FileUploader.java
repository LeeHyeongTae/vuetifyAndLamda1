package com.lamda.web.proxy;

import com.lamda.web.music.MusicRepository;
import com.lamda.web.soccer.Player;
import com.lamda.web.soccer.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

@Service("uploader") @Lazy
public class FileUploader extends Proxy{
    @Autowired Inventory<String> inventory;
    @Autowired
    PlayerRepository playerRepository;
    @Autowired
    MusicRepository musicRepository;
    public void upload(){
        inventory.clear();
        try{
            BufferedReader reader = new BufferedReader(
                                    new FileReader(
                                    new File("/Users/ihyeongtae/IdeaProjects/web/src/main/resources/static/files/soccer_files/player.csv")));
            String player = "";
            while((player = reader.readLine()) != null){
                inventory.add(player);
            }
            reader.close();
        }catch (Exception e){
            print("파일 리딩 에러");
            e.printStackTrace();
        }
        println("---------------------------------");
        println(inventory.get().get(0));
        Player p = new Player();
        String[] arr = inventory.get().get(0).split(",");
        p.setPlayerId(arr[0]);
        p.setPlayerName(arr[1]);
        p.setePlayerName(arr[3]);
        p.setNickname(arr[4]);
        p.setJoinYyyy(arr[5]);
        p.setPosition(arr[6]);
        p.setBackNo(arr[7]);
        p.setNation(arr[8]);
        p.setBirthDate(arr[9]);
        p.setSolar(arr[10]);
        p.setHeight(arr[11]);
        p.setWeight(arr[12]);
        println("*****************");
        print(p.toString());
        playerRepository.save(p);
    }
}
