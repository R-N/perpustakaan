--==============================================================
-- DBMS name:      ANSI Level 2
-- Created on:     12/17/2019 1:05:14 PM
--==============================================================


drop index BUKU_PK;

drop table BUKU cascade;

drop index DIPINJAM_FK;

drop index PEMINJAMAN_PK;

drop table PEMINJAMAN cascade;

drop index USER_PK;

drop table "USER" cascade;

--==============================================================
-- Table: BUKU
--==============================================================
create table BUKU (
KODE_BUKU            CHAR(6)              not null,
JUDUL_BUKU           VARCHAR(50)          not null,
PENULIS_BUKU         VARCHAR(50)          not null,
STATUS_BUKU          INTEGER              not null,
primary key (KODE_BUKU)
);

--==============================================================
-- Index: BUKU_PK
--==============================================================
create unique index BUKU_PK on BUKU (
KODE_BUKU ASC
);

--==============================================================
-- Table: PEMINJAMAN
--==============================================================
create table PEMINJAMAN (
ID_PEMINJAMAN        INTEGER              not null,
KODE_BUKU            CHAR(6),
NAMA_PEMINJAM        VARCHAR(50)          not null,
TELEPON_PEMINJAM     VARCHAR(15)          not null,
ALAMAT_PEMINJAM      VARCHAR(255)         not null,
WAKTU_PINJAM         DATE                 not null,
WAKTU_TENGGANG       DATE                 not null,
WAKTU_KEMBALI        DATE,
primary key (ID_PEMINJAMAN),
foreign key (KODE_BUKU)
      references BUKU (KODE_BUKU)
);

--==============================================================
-- Index: PEMINJAMAN_PK
--==============================================================
create unique index PEMINJAMAN_PK on PEMINJAMAN (
ID_PEMINJAMAN ASC
);

--==============================================================
-- Index: DIPINJAM_FK
--==============================================================
create  index DIPINJAM_FK on PEMINJAMAN (
KODE_BUKU ASC
);

--==============================================================
-- Table: "USER"
--==============================================================
create table "USER" (
USERNAME             VARCHAR(25)          not null,
PASSWORD             CHAR(32)             not null,
primary key (USERNAME)
);

--==============================================================
-- Index: USER_PK
--==============================================================
create unique index USER_PK on "USER" (
USERNAME ASC
);

