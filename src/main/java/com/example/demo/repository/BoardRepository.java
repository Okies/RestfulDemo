package com.example.demo.repository;

import com.example.demo.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

    Board findByBid(Long bid);

    void deleteByBidAndPassword(Long bid, String password);

    List<Board> findByBidBetweenOrderByBidDesc(Long from, Long to);

    Page<Board> findByBidBetween(Long from, Long to, Pageable pageable);
}
