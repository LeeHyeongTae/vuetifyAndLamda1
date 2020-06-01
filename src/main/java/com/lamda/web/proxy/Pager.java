package com.lamda.web.proxy;

import com.lamda.web.mappers.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Pager {
    @Autowired
    MovieMapper movieMapper;
    private int rowCount, startRow, endRow,
                pageCount, pageSize, startPage, endPage, nowPage,
                blockCount, blockSize, prevBlock, nextBlock, nowBlock;
    private boolean existPrev, existNext;
    public void paging() {
        rowCount = movieMapper.countMovies();
        pageSize = 5;
        pageCount = (rowCount % pageSize == 0) ? rowCount / pageSize : (rowCount / pageSize) + 1;
        blockSize = 5;
        blockCount = (pageCount % blockSize == 0) ? pageCount / blockSize: (pageCount / blockSize) + 1;
        nowPage = 1;
//        for(int i=0; i<nowPage; i++){ startRow = nowPage+(pageSize*i); }
        startRow = (nowPage-1)*pageSize+1;
        endRow = (nowPage!=pageCount)? nowPage*pageSize:rowCount;
        nowBlock = (nowPage % blockSize != 0) ? nowPage / blockSize +1 : nowPage / blockSize;
        startPage = (nowBlock-1)*blockSize+1;
        endPage = (nowPage!=blockCount)? startPage+blockSize:pageCount;
        prevBlock = startPage - blockSize;
        nextBlock = startPage + blockSize;
        existPrev = (nowBlock != 1);
        existNext = (nowBlock != blockCount);
    }
}
