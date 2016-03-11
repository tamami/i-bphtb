--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: dat_login; Type: TABLE; Schema: public; Owner: bphtb; Tablespace: 
--

CREATE TABLE dat_login (
    nm_login character varying(20) NOT NULL,
    nip character varying(18),
    password character varying(20) NOT NULL
);


ALTER TABLE public.dat_login OWNER TO bphtb;

--
-- Name: pegawai; Type: TABLE; Schema: public; Owner: bphtb; Tablespace: 
--

CREATE TABLE pegawai (
    nip character(18) NOT NULL,
    nama character varying(50) NOT NULL
);


ALTER TABLE public.pegawai OWNER TO bphtb;

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
-- Data for Name: dat_login; Type: TABLE DATA; Schema: public; Owner: bphtb
--

COPY dat_login (nm_login, nip, password) FROM stdin;
\.


--
-- Data for Name: pegawai; Type: TABLE DATA; Schema: public; Owner: bphtb
--

COPY pegawai (nip, nama) FROM stdin;
198404092010011025	PRIYANTO TAMAMI S.KOM
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
15	PEMBERIAN HAK BARU DILUAR PELEPASAN HAK
\.


--
-- Data for Name: ref_npoptkp; Type: TABLE DATA; Schema: public; Owner: bphtb
--

COPY ref_npoptkp (kd_npoptkp, thn_peralihan, kd_jns_peralihan, npoptkp) FROM stdin;
1	2016	1	60000000
2	2016	2	60000000
3	2016	3	60000000
4	2016	4	300000000
5	2016	5	300000000
6	2016	6	60000000
7	2016	7	60000000
8	2016	8	60000000
9	2016	9	60000000
10	2016	10	60000000
11	2016	11	60000000
12	2016	12	60000000
13	2016	13	60000000
14	2016	14	60000000
15	2016	15	60000000
\.


--
-- Name: dat_login_pkey; Type: CONSTRAINT; Schema: public; Owner: bphtb; Tablespace: 
--

ALTER TABLE ONLY dat_login
    ADD CONSTRAINT dat_login_pkey PRIMARY KEY (nm_login);


--
-- Name: pegawai_pkey; Type: CONSTRAINT; Schema: public; Owner: bphtb; Tablespace: 
--

ALTER TABLE ONLY pegawai
    ADD CONSTRAINT pegawai_pkey PRIMARY KEY (nip);


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
-- Name: fk_pegawai; Type: FK CONSTRAINT; Schema: public; Owner: bphtb
--

ALTER TABLE ONLY dat_login
    ADD CONSTRAINT fk_pegawai FOREIGN KEY (nip) REFERENCES pegawai(nip);


--
-- Name: fk_ref_jns_peralihan; Type: FK CONSTRAINT; Schema: public; Owner: bphtb
--

ALTER TABLE ONLY ref_npoptkp
    ADD CONSTRAINT fk_ref_jns_peralihan FOREIGN KEY (kd_jns_peralihan) REFERENCES ref_jenis_peralihan(kd_jns_peralihan) MATCH FULL;


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

