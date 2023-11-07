CREATE SEQUENCE order_seq;

CREATE SEQUENCE test_seq;
DROP SEQUENCE test_seq;
CREATE SEQUENCE test_seq
START WITH 11
INCREMENT BY 2
MAXVALUE 30
MINVALUE 0
CYCLE;
--ORA-04013: number to CACHE must be less than one cycle

CREATE SEQUENCE test_seq
START WITH 11
INCREMENT BY 2
MAXVALUE 30
MINVALUE 0
NOCACHE
CYCLE;

--일련번호 발급하기
SELECT test_seq.NEXTVAL FROM dual; --11
SELECT test_seq.NEXTVAL FROM dual; --13
SELECT test_seq.NEXTVAL FROM dual; --15
SELECT test_seq.NEXTVAL FROM dual; --17
SELECT test_seq.NEXTVAL FROM dual; --19
SELECT test_seq.NEXTVAL FROM dual; --21
SELECT test_seq.NEXTVAL FROM dual; --23
SELECT test_seq.NEXTVAL FROM dual; --25
SELECT test_seq.NEXTVAL FROM dual; --27
SELECT test_seq.NEXTVAL FROM dual; --29
SELECT test_seq.NEXTVAL FROM dual; --0


--현재일련번호 확인하기 : NEXTVAL 사용후에만 사용가능
SELECT test_seq.CURRVAL FROM dual; --0

SELECT * FROM order_info;

DROP SEQUENCE order_seq;
CREATE SEQUENCE order_seq
START WITH 4;

--주문기본정보추가
INSERT INTO order_info(order_no, order_id) VALUES (order_seq.NEXTVAL, 'A');

--주문상세정보추가
INSERT INTO order_line(order_line_no, order_prod_no, order_quantity) VALUES (order_seq.CURRVAL, 'C0001', 1);
INSERT INTO order_line(order_line_no, order_prod_no, order_quantity) VALUES (order_seq.CURRVAL, 'F0001', 2);
SELECT * FROM order_line;

ROLLBACK;
SELECT * FROM order_info;
SELECT * FROM order_line;



