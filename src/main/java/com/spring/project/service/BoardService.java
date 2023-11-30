package com.spring.project.service;

import com.spring.project.entity.Board;

import java.util.List;

public interface BoardService {
    List<Board> getBoardList(Board board);

    void insertBoard(Board board);

    Board getBoard(Board board);

    void updateBoard(Board board);

    void deleteBoard(Board board);
}