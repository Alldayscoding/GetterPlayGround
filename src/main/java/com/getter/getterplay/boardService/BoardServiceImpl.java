package com.getter.getterplay.boardService;

import com.getter.getterplay.boardDTO.BoardDTO;
import com.getter.getterplay.boardEntity.GetterBoard;
import com.getter.getterplay.boardRepository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor
@Transactional
public class BoardServiceImpl implements BoardService {

 private final BoardRepository boardRepository;

 @Override
 public void insert(BoardDTO boardDTO) {
  GetterBoard board = GetterBoard.builder()
          .title(boardDTO.getTitle())
          .content(boardDTO.getContent())
          .writer(boardDTO.getWriter())
          .build();
  boardRepository.save(board);
 }

 @Override
 public List<GetterBoard> list() {

  List<GetterBoard> listBoard =  boardRepository.findAll();
  return listBoard;

 }

 @Override
 public BoardDTO getOne(Long bno) {

  Optional<GetterBoard> boardDetail = boardRepository.findById(bno);

  GetterBoard board = boardDetail.orElseThrow();

  return entityToDTO(board);
 }
}
