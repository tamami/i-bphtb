--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = off;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET escape_string_warning = off;

SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: dat_login; Type: TABLE; Schema: public; Owner: bphtb; Tablespace: 
--

CREATE TABLE dat_login (
    nm_login character varying(20) NOT NULL,
    nip character(18),
    password character varying(20) NOT NULL
);


ALTER TABLE public.dat_login OWNER TO bphtb;

--
-- Name: data_peralihan; Type: TABLE; Schema: public; Owner: bphtb; Tablespace: 
--

CREATE TABLE data_peralihan (
    kd_propinsi character(2) NOT NULL,
    kd_dati2 character(2) NOT NULL,
    kd_kecamatan character(3) NOT NULL,
    kd_kelurahan character(3) NOT NULL,
    kd_blok character(3) NOT NULL,
    no_urut character(4) NOT NULL,
    kd_jns_op character(1) NOT NULL,
    no_sspd character(15) NOT NULL,
    tgl_register date NOT NULL,
    wp_id numeric NOT NULL,
    kd_ppat numeric(2,0),
    kd_status_berkas numeric(2,0),
    keterangan character varying(250),
    kd_jns_peralihan numeric NOT NULL,
    dasar_peralihan character varying(50),
    luas_bumi numeric NOT NULL,
    luas_bng numeric NOT NULL,
    nilai_peralihan numeric NOT NULL,
    njop_bumi numeric NOT NULL,
    njop_bng numeric NOT NULL,
    njop numeric NOT NULL,
    npop numeric,
    kd_npoptkp numeric NOT NULL,
    bphtb numeric NOT NULL
);


ALTER TABLE public.data_peralihan OWNER TO bphtb;

--
-- Name: data_wajib_pajak; Type: TABLE; Schema: public; Owner: bphtb; Tablespace: 
--

CREATE TABLE data_wajib_pajak (
    wp_id numeric NOT NULL,
    nama_wp character varying(30) NOT NULL,
    jalan_wp character varying(30),
    blok_kav_no_wp character varying(15),
    rt_wp character(3),
    rw_wp character(2),
    kelurahan_wp character varying(30),
    kota_wp character varying(30),
    npwp character(15),
    thn_pajak character(4) NOT NULL
);


ALTER TABLE public.data_wajib_pajak OWNER TO bphtb;

--
-- Name: pegawai; Type: TABLE; Schema: public; Owner: bphtb; Tablespace: 
--

CREATE TABLE pegawai (
    nip character(18) NOT NULL,
    nama character varying(50) NOT NULL
);


ALTER TABLE public.pegawai OWNER TO bphtb;

--
-- Name: ppat; Type: TABLE; Schema: public; Owner: bphtb; Tablespace: 
--

CREATE TABLE ppat (
    kd_ppat numeric(2,0) NOT NULL,
    nama_ppat character varying(50) NOT NULL,
    alamat_ppat character varying(200)
);


ALTER TABLE public.ppat OWNER TO bphtb;

--
-- Name: ref_jenis_peralihan; Type: TABLE; Schema: public; Owner: bphtb; Tablespace: 
--

CREATE TABLE ref_jenis_peralihan (
    kd_jns_peralihan numeric NOT NULL,
    jns_peralihan character varying(150) NOT NULL
);


ALTER TABLE public.ref_jenis_peralihan OWNER TO bphtb;

--
-- Name: ref_npoptkp; Type: TABLE; Schema: public; Owner: bphtb; Tablespace: 
--

CREATE TABLE ref_npoptkp (
    kd_npoptkp numeric NOT NULL,
    thn_peralihan character(4) NOT NULL,
    kd_jns_peralihan numeric NOT NULL,
    npoptkp numeric NOT NULL
);


ALTER TABLE public.ref_npoptkp OWNER TO bphtb;

--
-- Name: ref_status_berkas; Type: TABLE; Schema: public; Owner: bphtb; Tablespace: 
--

CREATE TABLE ref_status_berkas (
    kd_status numeric(2,0) NOT NULL,
    status_berkas character varying(30) NOT NULL
);


ALTER TABLE public.ref_status_berkas OWNER TO bphtb;

--
-- Data for Name: dat_login; Type: TABLE DATA; Schema: public; Owner: bphtb
--

COPY dat_login (nm_login, nip, password) FROM stdin;
\.


--
-- Data for Name: data_peralihan; Type: TABLE DATA; Schema: public; Owner: bphtb
--

COPY data_peralihan (kd_propinsi, kd_dati2, kd_kecamatan, kd_kelurahan, kd_blok, no_urut, kd_jns_op, no_sspd, tgl_register, wp_id, kd_ppat, kd_status_berkas, keterangan, kd_jns_peralihan, dasar_peralihan, luas_bumi, luas_bng, nilai_peralihan, njop_bumi, njop_bng, njop, npop, kd_npoptkp, bphtb) FROM stdin;
\.


--
-- Data for Name: data_wajib_pajak; Type: TABLE DATA; Schema: public; Owner: bphtb
--

COPY data_wajib_pajak (wp_id, nama_wp, jalan_wp, blok_kav_no_wp, rt_wp, rw_wp, kelurahan_wp, kota_wp, npwp, thn_pajak) FROM stdin;
\.


--
-- Data for Name: pegawai; Type: TABLE DATA; Schema: public; Owner: bphtb
--

COPY pegawai (nip, nama) FROM stdin;
\.


--
-- Data for Name: ppat; Type: TABLE DATA; Schema: public; Owner: bphtb
--

COPY ppat (kd_ppat, nama_ppat, alamat_ppat) FROM stdin;
1	WIDHYASIH P., S.H., M.Kn	\N
2	RETNO BUDI YUNIASIH, S.H.	\N
3	DEVIYANTI ROSITA, S.H.	\N
4	H. ACHMAD FARIS SULCHAQ, S.H.	\N
5	NUR MUFIDAH, S.H.	\N
6	NUR CHASANAH, S.H.	\N
7	YUNI ANDARYANTI, S.H.	\N
8	NURHALIMAH, S.H.	\N
9	WAHYU RIRIN E., S.H.	\N
10	SIH AMELIA, S.H.	\N
11	PASRI PATURUSI, S.H., M.Kn	\N
12	AGUS SANTOSO, S.H.	\N
13	ANI SRI DURIYATI, S.H., M.Kn	\N
14	NURLAILANI, S.H.	\N
15	IMAM KUSDARMANTO, S.H., M.Kn	\N
16	HIDUPIKO, S.H., M.Kn	\N
17	DIAN OCTAVIANI SARASWATI, S.H., M.Kn	\N
18	TRI SAKTI HANDAYANI, S.H.	\N
19	ANASTASIA IDA EDIATI, S.H.	\N
20	JONI ARIFIN, S.H., M.Kn	\N
21	YUS RIWAYATI, S.H., M.H.	\N
22	FAUZIAH HANUM, S.H., M.Kn	\N
23	ONY SETIAWAN, S.H., M.Kn	\N
24	TITIN MUTINAH, S.H., M.Kn	\N
25	NADA NAZEEB, S.H., M.Kn	\N
26	RISYAD MAHFUZH, S.H., M.Kn	\N
27	FIRRIYANDI NUGROHO, S.H., M.Kn	\N
28	IIN INDRAWATI, S.H.	\N
29	ANI SULISTIYANI, S.H., M.Kn	\N
30	SOLEH, S.H., M.Kn	\N
31	BUDI SUSIANA, S.H., M.Kn	\N
32	CAMAT TONJONG	\N
33	CAMAT SALEM	\N
34	CAMAT SONGGOM	\N
35	CAMAT BREBES	\N
36	CAMAT JATIBARANG	\N
37	CAMAT KETANGGUNGAN	\N
38	CAMAT KERSANA	\N
39	CAMAT WANASARI	\N
40	CAMAT TANJUNG	\N
41	CAMAT BULAKAMBA	\N
42	CAMAT BUMIAYU	\N
43	CAMAT LOSARI	\N
44	CAMAT BANJARHARJO	\N
45	CAMAT BANTARKAWUNG	\N
46	CAMAT PAGUYANGAN	\N
47	CAMAT LARANGAN	\N
48	CAMAT SIRAMPOG	\N
49	KPKNL TEGAL	\N
\.


--
-- Data for Name: ref_jenis_peralihan; Type: TABLE DATA; Schema: public; Owner: bphtb
--

COPY ref_jenis_peralihan (kd_jns_peralihan, jns_peralihan) FROM stdin;
1	JUAL BELI
2	TUKAR MENUKAR
3	HIBAH
4	HIBAH WASIAT
5	WARIS
6	PEMASUKAN DALAM PERSEROAN ATAU BADAN HUKUM LAIN
7	PEMISAHAN HAK YANG MENGAKIBATKAN PERALIHAN
8	PENUNJUKAN PEMBELI DALAM LELANG
9	PELAKSANAAN PUTUSAN HAKIM YANG MEMPUNYAI KEKUATAN HUKUM TETAP
10	PENGGABUNGAN USAHA
11	PELEBURAN USAHA
12	PEMEKARAN USAHA
13	HADIAH
14	PEMBERIAN HAK BARU KARENA KELANJUTAN PELEPASAN HAK
15	PEMBERIAN HAK BARU DI LUAR PELEPASAN HAK
\.


--
-- Data for Name: ref_npoptkp; Type: TABLE DATA; Schema: public; Owner: bphtb
--

COPY ref_npoptkp (kd_npoptkp, thn_peralihan, kd_jns_peralihan, npoptkp) FROM stdin;
\.


--
-- Data for Name: ref_status_berkas; Type: TABLE DATA; Schema: public; Owner: bphtb
--

COPY ref_status_berkas (kd_status, status_berkas) FROM stdin;
2	PENDING
3	CEK LAPANGAN
1	PENDING BERKAS
4	BERKAS SELESAI
\.


--
-- Name: dat_login_pkey; Type: CONSTRAINT; Schema: public; Owner: bphtb; Tablespace: 
--

ALTER TABLE ONLY dat_login
    ADD CONSTRAINT dat_login_pkey PRIMARY KEY (nm_login);


--
-- Name: data_wajib_pajak_pkey; Type: CONSTRAINT; Schema: public; Owner: bphtb; Tablespace: 
--

ALTER TABLE ONLY data_wajib_pajak
    ADD CONSTRAINT data_wajib_pajak_pkey PRIMARY KEY (wp_id);


--
-- Name: pegawai_pkey; Type: CONSTRAINT; Schema: public; Owner: bphtb; Tablespace: 
--

ALTER TABLE ONLY pegawai
    ADD CONSTRAINT pegawai_pkey PRIMARY KEY (nip);


--
-- Name: pk_data_peralihan; Type: CONSTRAINT; Schema: public; Owner: bphtb; Tablespace: 
--

ALTER TABLE ONLY data_peralihan
    ADD CONSTRAINT pk_data_peralihan PRIMARY KEY (kd_propinsi, kd_dati2, kd_kecamatan, kd_kelurahan, kd_blok, no_urut, kd_jns_op, no_sspd);


--
-- Name: ppat_pkey; Type: CONSTRAINT; Schema: public; Owner: bphtb; Tablespace: 
--

ALTER TABLE ONLY ppat
    ADD CONSTRAINT ppat_pkey PRIMARY KEY (kd_ppat);


--
-- Name: ref_jenis_peralihan_pkey; Type: CONSTRAINT; Schema: public; Owner: bphtb; Tablespace: 
--

ALTER TABLE ONLY ref_jenis_peralihan
    ADD CONSTRAINT ref_jenis_peralihan_pkey PRIMARY KEY (kd_jns_peralihan);


--
-- Name: ref_npoptkp_pkey; Type: CONSTRAINT; Schema: public; Owner: bphtb; Tablespace: 
--

ALTER TABLE ONLY ref_npoptkp
    ADD CONSTRAINT ref_npoptkp_pkey PRIMARY KEY (kd_npoptkp);


--
-- Name: ref_status_berkas_pkey; Type: CONSTRAINT; Schema: public; Owner: bphtb; Tablespace: 
--

ALTER TABLE ONLY ref_status_berkas
    ADD CONSTRAINT ref_status_berkas_pkey PRIMARY KEY (kd_status);


--
-- Name: fk_data_wp; Type: FK CONSTRAINT; Schema: public; Owner: bphtb
--

ALTER TABLE ONLY data_peralihan
    ADD CONSTRAINT fk_data_wp FOREIGN KEY (wp_id) REFERENCES data_wajib_pajak(wp_id);


--
-- Name: fk_pegawai; Type: FK CONSTRAINT; Schema: public; Owner: bphtb
--

ALTER TABLE ONLY dat_login
    ADD CONSTRAINT fk_pegawai FOREIGN KEY (nip) REFERENCES pegawai(nip);


--
-- Name: fk_ppat; Type: FK CONSTRAINT; Schema: public; Owner: bphtb
--

ALTER TABLE ONLY data_peralihan
    ADD CONSTRAINT fk_ppat FOREIGN KEY (kd_ppat) REFERENCES ppat(kd_ppat);


--
-- Name: fk_ref_jenis_peralihan; Type: FK CONSTRAINT; Schema: public; Owner: bphtb
--

ALTER TABLE ONLY ref_npoptkp
    ADD CONSTRAINT fk_ref_jenis_peralihan FOREIGN KEY (kd_jns_peralihan) REFERENCES ref_jenis_peralihan(kd_jns_peralihan);


--
-- Name: fk_ref_jns_peralihan; Type: FK CONSTRAINT; Schema: public; Owner: bphtb
--

ALTER TABLE ONLY data_peralihan
    ADD CONSTRAINT fk_ref_jns_peralihan FOREIGN KEY (kd_jns_peralihan) REFERENCES ref_jenis_peralihan(kd_jns_peralihan);


--
-- Name: fk_ref_npoptkp; Type: FK CONSTRAINT; Schema: public; Owner: bphtb
--

ALTER TABLE ONLY data_peralihan
    ADD CONSTRAINT fk_ref_npoptkp FOREIGN KEY (kd_npoptkp) REFERENCES ref_npoptkp(kd_npoptkp);


--
-- Name: fk_ref_status_berkas; Type: FK CONSTRAINT; Schema: public; Owner: bphtb
--

ALTER TABLE ONLY data_peralihan
    ADD CONSTRAINT fk_ref_status_berkas FOREIGN KEY (kd_status_berkas) REFERENCES ref_status_berkas(kd_status);


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

