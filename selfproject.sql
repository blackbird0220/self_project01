alter table traffic add uri varchar2(150);

commit;

select * from qna;

insert into qna values(qesq.nextval, 1, null, '질문1', '질문1내용', default, 0, 'kkt');
update qna set parno=qseq.currval, where no = (select * from ( select no from qna order by no desc) where rownum<=1) ;

-- currval 현재번호, nextval 다음번호

insert into qna values(qesq.nextval, 2, 1, '질문1의 답변', '질문1의 답변의 내용', default, 0, 'admin');   
update qna set title='질문2', content=질문2의 내용' where no=3;
select * from qua ;

-- plevel 오름차순  (질문 1, 답변2) 질문답변순으로
-- parno - 내림차순 (질문 1, 답변1/ 질문2, 답변2) 최신글 순이므로/ parno가 같으면 질문에 해당하는 답변 세트 
--         질문의 경우, no=parno, 답변의 경우,(답변의)parno= 질문의 parno


-- 질문 및 답변 목록 출력: 질문 글번호인 parno의 내림차순으로 하고, 

-- 같은 경우는 질문부터 출력될 수 있도록 plevel의 오름차순으로 정렬하도록 한다.
select * from qua order by parno desc, plevel asc;



-- 질문 등록
insert into qna values(qesq.nextval, 1, null, '질문5', '질문5내용', default, 0, 'kkt');
update qna set parno=qseq.currval, where no = (select * from ( select no from qna order by no desc) where rownum<=1) ;


-- 답변 등록
insert into qna values(qesq.nextval, 2, 5, '질문4의 답변1', '질문4의 답변 내용', default, 0, 'admin');


-- 질문 및 답변 수정
update qna set title-'', content='' where no=1;

-- 질문 및 답변 삭제
delete from qna where no=1;

-- 질문 상세보기 및 행당 질문에 대한 답변보기







select * from traffic;
desc traffic;
alter table traffic modify route varchar2(1000);

insert into traffic values {tseq.nextval, '버스', '금천 03', '몇줄짜리 경로 알아서 검색해서 붙여라', 
'마을버스로 김포운수에서 이용하는 노선으로 왕복 운행거리는 7.2km이다. 1980년에 만들어진 노선이다', '실제 버스경로를 보여주는 url 네이버맵, 구글맵'};

insert into traffic values {tseq.nextval, '버스', '6514', '몇줄짜리 경로 알아서 검색해서 붙여라', 
'마을버스로 김포운수에서 이용하는 노선으로 왕복 운행거리는 7.2km이다. 1980년에 만들어진 노선이다', '실제 버스경로를 보여주는 url 네이버맵, 구글맵'};

insert into traffic values {tseq.nextval, '버스', '652', '몇줄짜리 경로 알아서 검색해서 붙여라', 
'마을버스로 김포운수에서 이용하는 노선으로 왕복 운행거리는 7.2km이다. 1980년에 만들어진 노선이다', '실제 버스경로를 보여주는 url 네이버맵, 구글맵'};


select * from guide;
guide 



