package com.getter.getterplay.boardRepository;

import com.getter.getterplay.boardEntity.GetterBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<GetterBoard, Long> {


}
