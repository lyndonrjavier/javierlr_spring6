package com.spring.iocdi.app.injectcollections.components;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.iocdi.app.ctxnesting.components.Song;

@Component
public class CollectingBean {
	@Autowired
    List<Song> songList;

    public void printCollections(){
        songList.forEach(s -> System.out.println(s.getTitle()));
    }
}
