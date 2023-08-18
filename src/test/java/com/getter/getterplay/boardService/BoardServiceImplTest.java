package com.getter.getterplay.boardService;

import com.getter.getterplay.boardDTO.BoardDTO;
import com.getter.getterplay.boardEntity.GetterBoard;
import com.getter.getterplay.boardRepository.BoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@Slf4j
public class BoardServiceImplTest {

    @Autowired
    private BoardRepository boardRepository;

@Test
    public void insertTest(){
        GetterBoard board = GetterBoard.builder()
                .bno(3L)
                .title("test title..33")
                .content("content 333")
                .writer("writer33")
                .build();

        log.info("board...{}", board);
        boardRepository.save(board);
    }

    @Test
    public void getListTest(){
    List<GetterBoard> listBoard = boardRepository.findAll();
    listBoard.forEach(board -> log.info("board...{}", board));
    }

    @Test
    public void getOneTest(){


        Optional<GetterBoard> board = boardRepository.findById(2L);
        log.info("board.....>>>>>{}", board);
    }

}