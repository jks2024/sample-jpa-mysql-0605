package com.hd.sample_jpa_mysql_0605.service;

import com.hd.sample_jpa_mysql_0605.repository.BoardRepository;
import com.hd.sample_jpa_mysql_0605.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;
    // 게시글 등록 : 반환값 Boolean

    // 게시글 전체 조회 : 반환값 List<Board>

    // 게시글 상세 조회 : 반환값 Board

    // 게시글 수정 : 반환값 Boolean

    // 게시글 삭제 : 반환값 Boolean

    // 게시글 검색 : 반환값 List<Board>

    // 게시글 페이징 처리

    // Entity -> DTO

    // DTO -> Entity
}
