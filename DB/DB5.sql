CREATE TABLE customer(
    id VARCHAR2(5),
    pwd VARCHAR2(5) NOT NULL,
    name VARCHAR2(5),
    CONSTRAINT customer_id_pk PRIMARY KEY(id)
);

CREATE TABLE product(
    prod_no VARCHAR2(5),
    prod_name VARCHAR2(50) NOT NULL,
    prod_price NUMBER(6),
    prod_mf_dt DATE,
    prod_detail VARCHAR2(4000),
    CONSTRAINT prod_no_pk PRIMARY KEY(prod_no),
    CONSTRAINT prod_price_ck CHECK (prod_price>=0)
);

CREATE TABLE order_info(
    order_no NUMBER,
    order_id VARCHAR2(5),
    order_dt DATE DEFAULT SYSDATE
);

ALTER TABLE order_info
ADD CONSTRAINT order_info_no_pk PRIMARY KEY(order_no);

ALTER TABLE order_info
ADD CONSTRAINT order_id_fk FOREIGN KEY(order_id) REFERENCES customer(id);

CREATE TABLE order_line(
    order_line_no NUMBER,
    order_prod_no VARCHAR2(5),
    order_quantity NUMBER(3)
);

ALTER TABLE order_line
ADD CONSTRAINT order_line_pk PRIMARY KEY(order_line_no, order_prod_no);

ALTER TABLE order_line
ADD CONSTRAINT order_prod_no_fk FOREIGN KEY(order_prod_no)
REFERENCES product(prod_no);

ALTER TABLE order_line
ADD CONSTRAINT order_line_no_fk FOREIGN KEY(order_line_no)
REFERENCES order_info(order_no);

INSERT INTO customer(id, pwd, name) VALUES ('A', NULL, 'A'); --NULL ����

INSERT INTO customer(id, pwd, name) VALUES ('B', 'b', 'B');

INSERT INTO customer(id, pwd, name) VALUES ('B', 'b11', 'B11'); --PK ����

SELECT * FROM user_constraints;

SELECT * FROM user_constraints WHERE table_name = 'CUSTOMER';

INSERT INTO customer(id, pwd, name) VALUES ('A', 'a', 'A');
INSERT INTO customer(id, pwd, name) VALUES ('C', 'c', 'C');

INSERT INTO product(prod_no, prod_name, prod_price) VALUES ('C0001', '�Ƹ޸�ī��', 1000);
INSERT INTO product(prod_no, prod_name, prod_price) VALUES ('C0002', '���̽��Ƹ޸�ī��', 1000);
INSERT INTO product(prod_no, prod_name, prod_price) VALUES ('C0003', '����', 1500);
INSERT INTO product(prod_no, prod_name, prod_price) VALUES ('C0004', '���̽�����', 1500);
INSERT INTO product(prod_no, prod_name, prod_price) VALUES ('C0005', 'īǪġ��', 1500);

INSERT INTO order_info(order_no, order_id) VALUES (1, 'A'); --OK
INSERT INTO order_info(order_no, order_id) VALUES (1, 'X'); --HR.ORDER_INFO_NO_PK violated
INSERT INTO order_info(order_no, order_id) VALUES (2, 'X'); --HR.ORDER_ID_FK violated - parent key no
INSERT INTO order_info(order_no, order_id) VALUES (2, 'B'); --OK
INSERT INTO order_info(order_no, order_id) VALUES (3, 'A'); --OK

INSERT INTO order_line(order_line_no, order_prod_no, order_quantity) VALUES (0, 'C0001', 1);
--ORA-02291: integrity constraint (HR.ORDER_LINE_NO_FK) violated - parent key not found
INSERT INTO order_line(order_line_no, order_prod_no, order_quantity) VALUES (1, 'X', 1);
--ORA-02291: integrity constraint (HR.ORDER_PROD_NO_FK) violated - parent key not found
INSERT INTO order_line(order_line_no, order_prod_no, order_quantity) VALUES (1, 'C0001', 2); --OK
INSERT INTO order_line(order_line_no, order_prod_no, order_quantity) VALUES (1, 'C0001', 9);
--ORA-00001: unique constraint (HR.ORDER_LINE_PK) violated
INSERT INTO order_line(order_line_no, order_prod_no, order_quantity) VALUES (2, NULL, 9);
--ORA-01400: cannot insert NULL into ("HR"."ORDER_LINE"."ORDER_PROD_NO")
INSERT INTO order_line(order_line_no, order_prod_no, order_quantity) VALUES (NULL, 'C0001', 9);
--ORA-01400: cannot insert NULL into ("HR"."ORDER_LINE"."ORDER_LINE_NO")
INSERT INTO order_line(order_line_no, order_prod_no, order_quantity) VALUES (2, 'C0001', 4); --OK
INSERT INTO order_line(order_line_no, order_prod_no, order_quantity) VALUES (2, 'C0002', 1); --OK
INSERT INTO order_line(order_line_no, order_prod_no, order_quantity) VALUES (2, 'C0005', 1); --OK
INSERT INTO order_line(order_line_no, order_prod_no, order_quantity) VALUES (3, 'C0002', 1); --OK

SELECT * FROM CUSTOMER;

SELECT * FROM order_info;
SELECT * FROM order_line;

--�����ȵ� ��ǰ�� �����Ѵ�
UPDATE product SET prod_no='F0001', prod_name='�ٳ���' WHERE prod_no='C0003'; --OK
SELECT * FROM product;

--������ ��ǰ�� �����Ѵ�
UPDATE product SET prod_no='X' WHERE prod_no='C0001';
--FK������������ - ORA-02292: integrity constraint (HR.ORDER_PROD_NO_FK) violated - child record found
UPDATE product SET prod_price=prod_price+100 WHERE prod_no='C0001'; --OK

--CHECK��������
UPDATE product SET prod_price=-1 WHERE prod_no='F0001';
--CHECK������������ - ORA-02290: check constraint (HR.PROD_PRICE_CK) violated

--�����ȵ� ��ǰ�� �����Ѵ�
DELETE product WHERE prod_no='C0004'; --OK

--������ ��ǰ�� �����Ѵ�
DELETE product WHERE prod_no='C0001';
--ORA-02292: integrity constraint (HR.ORDER_PROD_NO_FK) violated - child record found

SELECT info.order_no, order_id,
	order_prod_no,
	prod_name, prod_price,
    order_quantity,
	order_dt
FROM order_info info JOIN order_line line ON (info.order_no=line.order_line_no)
JOIN product p ON (line.order_prod_no = p.prod_no);

CREATE VIEW vw_order
AS SELECT info.order_no, order_id,
        order_prod_no,
        prod_name, prod_price,
        order_quantity,
        order_dt
FROM order_info info JOIN order_line line ON (info.order_no=line.order_line_no)
JOIN product p ON (line.order_prod_no = p.prod_no);

SELECT * FROM vw_order;

CREATE OR REPLACE VIEW vw_order
AS SELECT info.order_no "�ֹ���ȣ", order_id "�ֹ��ھ��̵�",
        order_prod_no "��ǰ��ȣ",
        prod_name "��ǰ��", prod_price "��ǰ����",
        order_quantity "�ֹ�����",
        order_dt "�ֹ�����"
FROM order_info info JOIN order_line line ON (info.order_no=line.order_line_no)
JOIN product p ON (line.order_prod_no = p.prod_no);

SELECT * FROM vw_order;
SELECT �ֹ���ȣ FROM vw_order; --OK
SELECT order_no FROM vw_order; --ERROR

DROP VIEW vw_order;