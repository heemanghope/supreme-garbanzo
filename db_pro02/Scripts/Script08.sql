DROP SEQUENCE SEQ_TEST;
CREATE SEQUENCE SEQ_TEST
           START WITH    300
         INCREMENT BY      5
          MAXVALUE       310
          MINVALUE       290
             CYCLE
           NOCACHE;
            
SELECT SEQ_TEST.CURRVAL FROM DUAL;--현재꺼 가져와라 , 그러나 객체 생성후에는 현재값이 없음.정의되어있지 않다고 뜸.
    
SELECT SEQ_TEST.NEXTVAL FROM DUAL; --제일먼저 설정할것 nextvalue!

SELECT NVL(NULL, '0') FROM DUAL; --테스트

CREATE SEQUENCE SEQ_TEST CACHE 100;