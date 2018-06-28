SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS Alert;
DROP TABLE IF EXISTS Board;
DROP TABLE IF EXISTS Building;
DROP TABLE IF EXISTS Favorite;
DROP TABLE IF EXISTS Member;
DROP TABLE IF EXISTS Reserve;
DROP TABLE IF EXISTS Room;




/* Create Tables */

CREATE TABLE Alert
(
	-- �˶�����������ȣ
	ANo int NOT NULL COMMENT '�˶�����������ȣ',
	-- ȸ�� ID
	ID varchar(30) COMMENT 'ȸ�� ID',
	-- �˸� ����
	AContent varchar(50) COMMENT '�˸� ����',
	-- �˸��� ��ϵ� �ð�
	RegDate datetime COMMENT '�˸��� ��ϵ� �ð�',
	-- 0 = ��������
	-- 1 = ����
	AStat int COMMENT '0 = ��������
1 = ����',
	PRIMARY KEY (ANo)
);


CREATE TABLE Board
(
	-- Review&��ǰ���� �Խñ� ������ȣ
	BNo int NOT NULL COMMENT 'Review&��ǰ���� �Խñ� ������ȣ',
	-- �ǹ�����������ȣ
	SNo int COMMENT '�ǹ�����������ȣ',
	-- ȸ�� ID
	ID varchar(30) COMMENT 'ȸ�� ID',
	-- ȸ�� Email
	Email varchar(40) COMMENT 'ȸ�� Email',
	-- �Խñ��� ����
	Content varchar(1200) COMMENT '�Խñ��� ����',
	-- ���� ������ ǥ��
	QType varchar(40) COMMENT '���� ������ ǥ��',
	-- �Խñ� �ۼ� �ð�
	RegDate datetime NOT NULL COMMENT '�Խñ� �ۼ� �ð�',
	-- ���� ��� ���п� �Խñۿ���ȣ
	Ref int COMMENT '���� ��� ���п� �Խñۿ���ȣ',
	-- ���� ��� ���п� �Խñ� �ܰ��ȣ
	RefLevel int COMMENT '���� ��� ���п� �Խñ� �ܰ��ȣ',
	-- 1~5�� ����
	Score int COMMENT '1~5�� ����',
	-- ����� ����
	Img1 varchar(50) COMMENT '����� ����',
	-- ����� ����
	Img2 varchar(50) COMMENT '����� ����',
	-- ����� ����
	Img3 varchar(50) COMMENT '����� ����',
	-- ����� ����
	Img4 varchar(50) COMMENT '����� ����',
	-- 0 : Review
	-- 1 : ��ǰ���� (Guest -> Host)
	-- 2 : �����ڹ��� (User -> Admin)
	Kind int COMMENT '0 : Review
1 : ��ǰ���� (Guest -> Host)
2 : �����ڹ��� (User -> Admin)',
	PRIMARY KEY (BNo)
);


CREATE TABLE Building
(
	-- �ǹ�����������ȣ
	SNo int NOT NULL COMMENT '�ǹ�����������ȣ',
	-- ȸ�� ID
	ID varchar(30) NOT NULL COMMENT 'ȸ�� ID',
	-- ������ �̸�
	SName varchar(50) COMMENT '������ �̸�',
	-- ���� �� �� �Ұ�
	SPreview varchar(80) COMMENT '���� �� �� �Ұ�',
	-- ������ ���� ���� ����
	SContent varchar(1200) COMMENT '������ ���� ���� ����',
	-- �����ϴ� ���� ����
	--  ex) ȸ�ǽ�, ���̳���, ������ ���
	SType varchar(1200) COMMENT '�����ϴ� ���� ����
 ex) ȸ�ǽ�, ���̳���, ������ ���',
	-- ���� ����ǥ / �˻��� ���
	STag varchar(30) COMMENT '���� ����ǥ / �˻��� ���',
	-- �߰������� �����ϴ� �ü� �ȳ�
	SInfoSub varchar(1200) COMMENT '�߰������� �����ϴ� �ü� �ȳ�',
	-- ���� �̿� �� ���ǻ��� ����
	SRule varchar(1200) COMMENT '���� �̿� �� ���ǻ��� ����',
	-- ���� ���� � �ð�
	-- ex) 0024 : 00�� ���� 24�ñ���
	SBHour int(4) COMMENT '���� ���� � �ð�
ex) 0024 : 00�� ���� 24�ñ���',
	-- ����� �޹�����
	-- ex) ���Ͽ�
	SHDay varchar(15) COMMENT '����� �޹�����
ex) ���Ͽ�',
	-- ���� ��ǥ Ŀ�� �̹���
	SImg1 varchar(30) COMMENT '���� ��ǥ Ŀ�� �̹���',
	-- \t�� ������ ���
	-- ex ) img.png\timg2.jpg\t
	SImg2 varchar(1200) COMMENT '\t�� ������ ���
ex ) img.png\timg2.jpg\t',
	-- ����(�ǹ�) �ּ�
	SAddress varchar(50) COMMENT '����(�ǹ�) �ּ�',
	-- �̽��� : 0
	-- ���� : 1
	-- �ݷ� : 2
	SStat int NOT NULL COMMENT '�̽��� : 0
���� : 1
�ݷ� : 2',
	PRIMARY KEY (SNo),
	UNIQUE (ID)
);


CREATE TABLE Favorite
(
	-- ȸ�� ID
	ID varchar(30) NOT NULL COMMENT 'ȸ�� ID',
	-- �ǹ�����������ȣ
	SNo int NOT NULL COMMENT '�ǹ�����������ȣ'
);


CREATE TABLE Member
(
	-- Guest ȸ�� ID
	ID varchar(30) NOT NULL COMMENT 'Guest ȸ�� ID',
	-- ȸ�� �н�����
	PW varchar(30) NOT NULL COMMENT 'ȸ�� �н�����',
	-- ȸ�� �̸�
	Name varchar(30) NOT NULL COMMENT 'ȸ�� �̸�',
	-- ȸ�� Email
	Email varchar(40) NOT NULL COMMENT 'ȸ�� Email',
	-- ȸ�� �޴��� ��ȣ
	Mob varchar(20) COMMENT 'ȸ�� �޴��� ��ȣ',
	-- ȸ�� ������ ����
	RegDate datetime NOT NULL COMMENT 'ȸ�� ������ ����',
	-- Guest = 0
	-- Host = 1
	-- Admin = 2
	MemType int COMMENT 'Guest = 0
Host = 1
Admin = 2',
	-- Host���� ��ȯ �� ��� �� ����ָ�
	HostName varchar(20) COMMENT 'Host���� ��ȯ �� ��� �� ����ָ�',
	-- ����ڵ�Ϲ�ȣ
	HostRegNo varchar(30) COMMENT '����ڵ�Ϲ�ȣ',
	-- ����ڵ�� ������
	Address varchar(40) COMMENT '����ڵ�� ������',
	-- Host���� ��ȯ �� ��ǥ��ȣ�� ���
	Tel varchar(30) COMMENT 'Host���� ��ȯ �� ��ǥ��ȣ�� ���',
	-- ����� + \t + ���¹�ȣ + \t + ������
	AccountNo varchar(40) COMMENT '����� + \t + ���¹�ȣ + \t + ������',
	PRIMARY KEY (ID)
);


CREATE TABLE Reserve
(
	-- �� �ŷ��� �߻��ϴ� �ŷ�����������ȣ
	ReNo int NOT NULL COMMENT '�� �ŷ��� �߻��ϴ� �ŷ�����������ȣ',
	-- ȸ�� ID
	ID varchar(30) COMMENT 'ȸ�� ID',
	-- ���ΰ���������ȣ
	SRNo int COMMENT '���ΰ���������ȣ',
	-- ��ǰ�� ���� ��¥
	ReDate datetime NOT NULL COMMENT '��ǰ�� ���� ��¥',
	-- ��ǰ ������ ����� �Ͻ�
	-- 
	RegDate datetime NOT NULL COMMENT '��ǰ ������ ����� �Ͻ�
',
	-- ��ǰ�� ���� * ����
	--  = �� ���� �ؾ� ��(��) �ݾ�
	TotPrice int COMMENT '��ǰ�� ���� * ����
 = �� ���� �ؾ� ��(��) �ݾ�',
	-- ��ǰ�� ����/������ ����
	ReCnt int COMMENT '��ǰ�� ����/������ ����',
	-- 0 = ���� / �������
	-- 1 = �����Ϸ�
	-- 2 = ���/ȯ��
	-- 3 = ȯ�ҿϷ�
	ReStat int COMMENT '0 = ���� / �������
1 = �����Ϸ�
2 = ���/ȯ��
3 = ȯ�ҿϷ�',
	PRIMARY KEY (ReNo)
);


CREATE TABLE Room
(
	-- �ǹ�����������ȣ
	SNo int NOT NULL COMMENT '�ǹ�����������ȣ',
	-- ���ΰ���������ȣ
	SRNo int NOT NULL COMMENT '���ΰ���������ȣ',
	-- ���� ���� �̸�
	SRName varchar(30) COMMENT '���� ���� �̸�',
	-- �����ϴ� ���� ����
	-- ex)���̳���, ȸ�ǽ�, ������ ���
	SRType varchar(50) COMMENT '�����ϴ� ���� ����
ex)���̳���, ȸ�ǽ�, ������ ���',
	-- ���ΰ����� ���� ����
	SRContent varchar(1200) COMMENT '���ΰ����� ���� ����',
	-- ���� ������ �ü� �ȳ�
	SRInfo varchar(1200) COMMENT '���� ������ �ü� �ȳ�',
	-- 0 = �ð� ����
	-- 1 = ���� ����
	SResType int COMMENT '0 = �ð� ����
1 = ���� ����',
	-- ������ �̿��ϴ� �̿밴 ���� ����
	SRPersonLimit varchar(30) COMMENT '������ �̿��ϴ� �̿밴 ���� ����',
	-- ���� ��(�ð�or����) ���� ����
	SPrice int COMMENT '���� ��(�ð�or����) ���� ����',
	-- ���ΰ����� ǥ���ϴ� �̹��� ����
	SRImg varchar(1200) COMMENT '���ΰ����� ǥ���ϴ� �̹��� ����',
	PRIMARY KEY (SNo, SRNo)
);



