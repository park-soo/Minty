package com.Reboot.Minty.sellBoard.repository;

import com.Reboot.Minty.sellBoard.entity.SellBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellBoardRepository extends JpaRepository<SellBoard,Long> {
}
