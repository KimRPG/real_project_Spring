package com.spring.project.service;

import com.spring.project.entity.Board;
import com.spring.project.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardRepository boardRepository;


    @Override
    public List<Board> getBoardList(Board board) {
        return (List<Board>) boardRepository.findAll();
    }


    @Override
    public void insertBoard(Board board) {
        boardRepository.save(board);

    }


    @Override
    public Board getBoard(Board board) {

        Board findBoard = boardRepository.findById(board.getSeq()).get();
        boardRepository.save(findBoard);

        return findBoard;
    }

    @Override
    public void updateBoard(Board board) {
        Board findBoard = boardRepository.findById(board.getSeq()).get();

        findBoard.setTitle(board.getTitle());
        findBoard.setContent(board.getContent());

        boardRepository.save(findBoard);
    }

    @Override
    public void deleteBoard(Board board) {
        boardRepository.deleteById(board.getSeq());
    }

}

