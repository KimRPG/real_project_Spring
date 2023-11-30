package com.spring.project.controller;

import com.spring.project.entity.Board;
import com.spring.project.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;


    @RequestMapping("/testBoardList")
    public String testBoardList(Model model) {
        List<Board> boardList = new ArrayList<Board>();

        // 임시로 게시물 10개를 만들자
        for (int i = 0; i < 9; i++) {
            Board board = new Board();
//            board.setSeq(new Long(i));
            board.setTitle("제목   " + i);
            board.setWriter("작성자 " + i);
            board.setContent("글내용  " + i);
            boardList.add(board);
        }
        model.addAttribute("boardList", boardList);
        return "testBoardList"; // jsp 파일 이름
    }


    @RequestMapping(value = {"/", "/getBoardList"})
    public String getBoardList(Model model, Board board) {
        List<Board> boardList = boardService.getBoardList(board);
        model.addAttribute("boardList", boardList);
        return "getBoardList";

    }


    @RequestMapping("/insertBoardView")
    public String insertBoardView() {
        return "insertBoard";
    }


    @RequestMapping("/insertBoard")
    public String insertBoard(Board board) {
        boardService.insertBoard(board);
        return "redirect:getBoardList";
    }


    @RequestMapping("/getBoard")
    public String getBoard(Board board, Model model) {
        model.addAttribute("board", boardService.getBoard((board)));
        return "getBoard";
    }


    @RequestMapping("/updateBoard")
    public String updateBoard(Board board) {
        boardService.updateBoard(board);
        return "forward:getBoardList";
    }


    @RequestMapping("/deleteBoard")
    public String deleteBoard(Board board) {
        boardService.deleteBoard(board);
        return "forward:getBoardList";
    }

}