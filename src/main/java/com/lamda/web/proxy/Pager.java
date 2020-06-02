package com.lamda.web.proxy;

import com.lamda.web.mappers.MovieMapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component @Data
public class Pager {
    @Autowired MovieMapper movieMapper;
    private int rowCount, startRow, endRow,
                pageCount, pageSize, pageStart, pageEnd, nowPage,
                blockCount, blockSize, prevBlock, nextBlock, nowBlock;
    private boolean existPrev, existNext;
    private String searchWord;

    public void paging(){
        rowCount = movieMapper.countMovies();
        nowBlock = nowPage / blockSize;
        pageCount = (rowCount % pageSize != 0)? (rowCount / pageSize) + 1 : rowCount / pageSize;
        blockCount = (pageCount % blockSize != 0)? (pageCount / blockSize) + 1 : pageCount / blockSize;
        startRow = pageSize * nowPage;
        endRow = (nowPage != (pageCount - 1))? startRow + (pageSize - 1) : rowCount - 1;
        pageStart = blockSize * nowBlock;
        pageEnd = (nowBlock != (blockCount - 1))? pageStart + (blockSize - 1) : pageCount - 1;
        prevBlock = pageStart - blockSize;
        nextBlock = pageStart + blockSize;
        nowBlock = nowPage / blockSize;
        existPrev = nowBlock != 0;
        existNext = (nowBlock + 1) != blockCount;
    }
}
