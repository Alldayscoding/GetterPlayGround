package com.getter.getterplay.boardRepository;

import com.getter.getterplay.boardEntity.GetterBoard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<GetterBoard, Long> {


        /*검색기능*/
        Page<GetterBoard> findByTitleContaining(String keyword, Pageable pageable);

}
