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
    nip character(18),
    password character varying(20) NOT NULL
);


ALTER TABLE dat_login OWNER TO bphtb;

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
    kd_ppat numeric(2,0),
    kd_status numeric(2,0),
    keterangan character varying(250),
    wp_id numeric NOT NULL,
    thn_peralihan character(4) NOT NULL
);


ALTER TABLE data_peralihan OWNER TO bphtb;

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
    kota_wp character varying(30)
);


ALTER TABLE data_wajib_pajak OWNER TO bphtb;

--
-- Name: pbb_dat_objek_pajak; Type: TABLE; Schema: public; Owner: bphtb; Tablespace: 
--

CREATE TABLE pbb_dat_objek_pajak (
    kd_propinsi character(2) NOT NULL,
    kd_dati2 character(2) NOT NULL,
    kd_kecamatan character(3) NOT NULL,
    kd_kelurahan character(3) NOT NULL,
    kd_blok character(3) NOT NULL,
    no_urut character(4) NOT NULL,
    kd_jns_op character(1) NOT NULL,
    subjek_pajak_id character varying(30) NOT NULL,
    no_formulir_spop character(11) NOT NULL,
    no_persil character varying(5),
    jalan_op character varying(30) NOT NULL,
    blok_kav_no_op character varying(15),
    rw_op character(2),
    rt_op character(3),
    kd_status_cabang numeric(1,0) NOT NULL,
    kd_status_wp character(1) NOT NULL,
    total_luas_bumi numeric(12,0) NOT NULL,
    total_luas_bng numeric(12,0) NOT NULL,
    njop_bumi numeric(15,0) NOT NULL,
    njop_bng numeric(15,0) NOT NULL,
    status_peta_op numeric(1,0) NOT NULL,
    jns_transaksi_op character(1) NOT NULL,
    tgl_pendataan_op date NOT NULL,
    nip_pendata character(9) NOT NULL,
    tgl_pemeriksaan_op date NOT NULL,
    nip_pemeriksa_op character(9) NOT NULL,
    tgl_perekaman_op date NOT NULL,
    nip_perekam_op character(9) NOT NULL
);


ALTER TABLE pbb_dat_objek_pajak OWNER TO bphtb;

--
-- Name: pbb_dat_subjek_pajak; Type: TABLE; Schema: public; Owner: bphtb; Tablespace: 
--

CREATE TABLE pbb_dat_subjek_pajak (
    subjek_pajak_id character varying(30) NOT NULL,
    nm_wp character varying(30),
    jalan_wp character varying(30),
    blok_kav_no_wp character varying(15),
    rw_wp character(2),
    rt_wp character(3),
    kelurahan_wp character varying(30),
    kota_wp character varying(30),
    kd_pos_wp character varying(5),
    telp_wp character varying(20),
    npwp character varying(15),
    status_pekerjaan_wp character(1)
);


ALTER TABLE pbb_dat_subjek_pajak OWNER TO bphtb;

--
-- Name: pbb_ref_kecamatan; Type: TABLE; Schema: public; Owner: bphtb; Tablespace: 
--

CREATE TABLE pbb_ref_kecamatan (
    kd_propinsi character(2) NOT NULL,
    kd_dati2 character(2) NOT NULL,
    kd_kecamatan character(3) NOT NULL,
    nm_kecamatan character varying(30) NOT NULL
);


ALTER TABLE pbb_ref_kecamatan OWNER TO bphtb;

--
-- Name: pbb_ref_kelurahan; Type: TABLE; Schema: public; Owner: bphtb; Tablespace: 
--

CREATE TABLE pbb_ref_kelurahan (
    kd_propinsi character(2) NOT NULL,
    kd_dati2 character(2) NOT NULL,
    kd_kecamatan character(3) NOT NULL,
    kd_kelurahan character(3) NOT NULL,
    kd_sektor character(2) NOT NULL,
    nm_kelurahan character varying(30) NOT NULL,
    no_kelurahan numeric(4,0),
    kd_pos_kelurahan character varying(5)
);


ALTER TABLE pbb_ref_kelurahan OWNER TO bphtb;

--
-- Name: pegawai; Type: TABLE; Schema: public; Owner: bphtb; Tablespace: 
--

CREATE TABLE pegawai (
    nip character(18) NOT NULL,
    nama character varying(50) NOT NULL
);


ALTER TABLE pegawai OWNER TO bphtb;

--
-- Name: ppat; Type: TABLE; Schema: public; Owner: bphtb; Tablespace: 
--

CREATE TABLE ppat (
    kd_ppat numeric(2,0) NOT NULL,
    nama_ppat character varying(50) NOT NULL
);


ALTER TABLE ppat OWNER TO bphtb;

--
-- Name: status; Type: TABLE; Schema: public; Owner: bphtb; Tablespace: 
--

CREATE TABLE status (
    kd_status numeric(2,0) NOT NULL,
    status_berkas character varying(30) NOT NULL
);


ALTER TABLE status OWNER TO bphtb;

--
-- Data for Name: dat_login; Type: TABLE DATA; Schema: public; Owner: bphtb
--

COPY dat_login (nm_login, nip, password) FROM stdin;
ADMIN	198404092010011025	AEY�Qؖx
\.


--
-- Data for Name: data_peralihan; Type: TABLE DATA; Schema: public; Owner: bphtb
--

COPY data_peralihan (kd_propinsi, kd_dati2, kd_kecamatan, kd_kelurahan, kd_blok, no_urut, kd_jns_op, no_sspd, tgl_register, kd_ppat, kd_status, keterangan, wp_id, thn_peralihan) FROM stdin;
33	29	070	008	011	0041	0	040320160000466	2016-03-05	\N	\N	\N	1	2016
\.


--
-- Data for Name: data_wajib_pajak; Type: TABLE DATA; Schema: public; Owner: bphtb
--

COPY data_wajib_pajak (wp_id, nama_wp, jalan_wp, blok_kav_no_wp, rt_wp, rw_wp, kelurahan_wp, kota_wp) FROM stdin;
1	TRIMULYO	RANDUSANGA KULON	\N	002	01	RANDUSANGA KULON	BREBES
\.


--
-- Data for Name: pbb_dat_objek_pajak; Type: TABLE DATA; Schema: public; Owner: bphtb
--

COPY pbb_dat_objek_pajak (kd_propinsi, kd_dati2, kd_kecamatan, kd_kelurahan, kd_blok, no_urut, kd_jns_op, subjek_pajak_id, no_formulir_spop, no_persil, jalan_op, blok_kav_no_op, rw_op, rt_op, kd_status_cabang, kd_status_wp, total_luas_bumi, total_luas_bng, njop_bumi, njop_bng, status_peta_op, jns_transaksi_op, tgl_pendataan_op, nip_pendata, tgl_pemeriksaan_op, nip_pemeriksa_op, tgl_perekaman_op, nip_perekam_op) FROM stdin;
33	29	070	008	011	0041	0	332907000801100410	20065120008	\N	KO SAWAH	\N	\N	\N	0	1	1750	0	24500000	0	1	1	2006-04-22	060000000	2006-04-22	060000000	2006-04-22	060000000
33	29	130	019	005	0023	0	332913001900500230	20065062084	\N	TAMBAK I	\N	00	000	0	1	13771	0	68855000	0	1	1	2006-04-06	060000000	2006-04-06	060000000	2006-04-06	060000000
33	29	110	013	033	0097	0	332911001303300970	20041557124	\N	JL. RAYA TANJUNG	\N	03	001	0	1	2000	500	486000000	297500000	1	1	2005-04-25	060000000	2005-05-05	060000000	2005-08-15	060000000
33	29	010	004	012	0129	0	332901000401201290	20081970129	\N	TEGALAN	\N	\N	\N	0	1	1125	0	8043750	0	1	1	2009-02-13	060000000	2009-02-13	060000000	2009-02-13	060000000
33	29	030	010	007	0141	0	332903001000701410	20163001272	\N	KO DARAT	\N	05	002	0	1	138	0	17664000	0	1	2	2016-01-11	060100006	2016-01-11	060000000	2016-01-11	060100006
\.


--
-- Data for Name: pbb_dat_subjek_pajak; Type: TABLE DATA; Schema: public; Owner: bphtb
--

COPY pbb_dat_subjek_pajak (subjek_pajak_id, nm_wp, jalan_wp, blok_kav_no_wp, rw_wp, rt_wp, kelurahan_wp, kota_wp, kd_pos_wp, telp_wp, npwp, status_pekerjaan_wp) FROM stdin;
332907000801100410	WARMID CS TORIPAH	SLATRI UTARA	\N	\N	\N	SLATRI	KAB BREBES	\N	\N	-	5
332913001900500230	HJ TORIYAH H SUPARDI	KP RW 05	\N	05	001	PULOGADING	BREBES	\N	\N	-	5
332911001303300970	SUPRIYANTO, SH	JL. RAYA TANJUNG	\N	03	001	KRAKAHAN	BREBES	\N	\N	-	5
332901000401201290	WIHARMA	KP DK CIKANDANG	\N	\N	\N	BENTARSARI	BREBES	\N	\N	-	5
332903001000701410	NUR ELFI AGIL	KP RW	\N	01	004	DUKUHTURI	BREBES	\N	\N	\N	5
\.


--
-- Data for Name: pbb_ref_kecamatan; Type: TABLE DATA; Schema: public; Owner: bphtb
--

COPY pbb_ref_kecamatan (kd_propinsi, kd_dati2, kd_kecamatan, nm_kecamatan) FROM stdin;
33	29	010	SALEM
33	29	020	BANTARKAWUNG
33	29	030	BUMIAYU
33	29	040	PAGUYANGAN
33	29	050	SIRAMPOG
33	29	060	TONJONG
33	29	070	LARANGAN
33	29	080	KETANGGUNGAN
33	29	090	BANJARHARJO
33	29	100	LOSARI
33	29	110	TANJUNG
33	29	120	KERSANA
33	29	130	BULAKAMBA
33	29	140	WANASARI
33	29	150	JATIBARANG
33	29	160	BREBES
33	29	170	SONGGOM
\.


--
-- Data for Name: pbb_ref_kelurahan; Type: TABLE DATA; Schema: public; Owner: bphtb
--

COPY pbb_ref_kelurahan (kd_propinsi, kd_dati2, kd_kecamatan, kd_kelurahan, kd_sektor, nm_kelurahan, no_kelurahan, kd_pos_kelurahan) FROM stdin;
33	29	010	001	10	GUNUNGJAYA	280	 
33	29	010	002	10	INDRAJAYA	281	 
33	29	010	003	10	BANJARAN	282	 
33	29	010	004	20	SALEM	283	\N
33	29	010	005	10	GUNUNGLARANG	284	\N
33	29	010	006	10	GUNUNGSUGIH	285	\N
33	29	010	007	10	GANGGAWANG	286	\N
33	29	010	008	10	CITIMBANG	287	\N
33	29	010	009	10	KADUMANIS	288	\N
33	29	010	010	10	GENDOWANG	289	\N
33	29	010	011	10	CIPUTIH	290	\N
33	29	010	012	10	BENTARSARI	291	\N
33	29	010	013	10	BENTAR	292	\N
33	29	010	014	20	PABUARAN	293	\N
33	29	010	015	10	TEMBONGRAJA	294	\N
33	29	010	016	10	GUNUNGTAJEM	295	\N
33	29	010	017	10	WINDUSAKTI	296	\N
33	29	010	018	10	WINDUASRI	297	\N
33	29	010	019	10	CAPAR	298	\N
33	29	010	020	10	WANOJA	299	\N
33	29	010	021	10	PASIRPANJANG	300	\N
33	29	020	001	10	CINANAS	301	\N
33	29	020	002	10	BANJARSARI	302	\N
33	29	020	003	10	CIBENTANG	303	\N
33	29	020	004	10	TLAGA	304	\N
33	29	020	005	10	KARANGPARI	305	\N
33	29	020	006	10	WARU	306	\N
33	29	020	007	20	PANGEBATAN	307	\N
33	29	020	008	10	CIOMAS	308	\N
33	29	020	009	10	TAMBAKSERANG	309	\N
33	29	020	010	10	LEGOK	310	\N
33	29	020	011	10	TERLAYA	311	\N
33	29	020	012	10	JIPANG	312	\N
33	29	020	013	20	BANTARKAWUNG	313	\N
33	29	020	014	10	BANGBAYANG	314	\N
33	29	020	015	10	BANTARWARU	315	\N
33	29	020	016	10	SINDANGWANGI	316	\N
33	29	020	017	10	PENGARASAN	317	\N
33	29	020	018	10	KEBANDUNGAN	318	\N
33	29	030	001	10	PRUWATAN	319	\N
33	29	030	002	10	LAREN	320	\N
33	29	030	003	20	JATISAWIT	321	\N
33	29	030	004	20	NEGARADAHA	322	\N
33	29	030	005	20	KALIERANG	323	\N
33	29	030	006	10	LANGKAP	324	\N
33	29	030	007	10	ADISANA	325	\N
33	29	030	008	10	PENGGARUTAN	326	\N
33	29	030	009	20	DUKUHTURI	327	\N
33	29	030	010	20	BUMIAYU	328	\N
33	29	030	011	10	KALIWADAS	329	\N
33	29	030	012	10	PAMIJEN	330	\N
33	29	030	013	10	KALISUMUR	331	\N
33	29	030	014	10	KALILANGKAP	332	\N
33	29	030	015	10	KALINUSU	333	\N
33	29	040	001	10	KEDUNGOLENG	334	\N
33	29	040	002	10	WINDUAJI	335	\N
33	29	040	003	10	WANATIRTA	336	\N
33	29	040	004	20	PAGUYANGAN	337	\N
33	29	040	005	10	PAKUJATI	338	\N
33	29	040	006	20	TARABAN	339	\N
33	29	040	007	10	PAGOJENGAN	340	\N
33	29	040	008	10	KRETEK	341	\N
33	29	040	009	10	RAGATUNJUNG	342	\N
33	29	040	010	10	CILIBUR	343	\N
33	29	040	011	10	CIPETUNG	344	\N
33	29	040	012	10	PANDANSARI	345	\N
33	29	050	001	10	WANAREJA	346	\N
33	29	050	002	10	IGIRKLANCENG	347	\N
33	29	050	003	10	DAWUHAN	348	\N
33	29	050	004	10	BATURSARI	349	\N
33	29	050	005	10	KALIGIRI	350	\N
33	29	050	006	10	SRIDADI	351	\N
33	29	050	007	10	PLOMPONG	352	\N
33	29	050	008	20	BENDA	353	\N
33	29	050	009	10	KALILOKA	354	\N
33	29	050	010	10	MANGGIS	355	\N
33	29	050	011	10	MLAYANG	356	\N
33	29	050	012	10	MENDALA	357	\N
33	29	050	013	10	BUNIWAH	358	\N
33	29	060	001	10	KALIJURANG	359	\N
33	29	060	002	10	GALUHTIMUR	360	\N
33	29	060	003	20	KUTAMENDALA	361	\N
33	29	060	004	10	KARANGJONGKENG	362	\N
33	29	060	005	20	TONJONG	363	\N
33	29	060	006	10	PEPEDAN	364	\N
33	29	060	007	20	LINGGAPURA	365	\N
33	29	060	008	10	NEGARAYU	366	\N
33	29	060	009	10	TANGGERAN	367	\N
33	29	060	010	10	PURWADADI	368	\N
33	29	060	011	10	PURBAYASA	369	\N
33	29	060	012	10	WATUJAYA	370	\N
33	29	060	013	10	KUTAYU	371	\N
33	29	060	014	10	RAJAWETAN	372	\N
33	29	070	001	10	KAMAL	373	\N
33	29	070	002	10	WLAHAR	374	\N
33	29	070	003	10	PAMULIHAN	375	\N
33	29	070	004	10	KEDUNGBOKOR	376	\N
33	29	070	005	20	LARANGAN	377	\N
33	29	070	006	10	KARANGBALE	378	\N
33	29	070	007	10	LUWUNGGEDE	379	\N
33	29	070	008	10	SLATRI	380	\N
33	29	070	009	20	SITANGGAL	381	\N
33	29	070	010	10	RENGASPENDAWA	382	\N
33	29	070	011	20	SIANDONG	647	\N
33	29	080	001	10	JEMASIH	383	\N
33	29	080	002	10	CISEUREUH	384	\N
33	29	080	003	10	SINDANGJAYA	385	\N
33	29	080	004	10	PAMEDARAN	386	\N
33	29	080	005	10	CIKEUSAL KIDUL	387	\N
33	29	080	006	10	CIKEUSAL LOR	388	\N
33	29	080	007	10	BUARA	389	\N
33	29	080	008	10	KARANGBANDUNG	390	\N
33	29	080	009	10	BAROS	391	\N
33	29	080	010	10	KUBANGSARI	392	\N
33	29	080	011	10	KUBANGJATI	393	\N
33	29	080	012	10	TANGGUNGSARI	394	\N
33	29	080	013	10	DUKUHBADAG	395	\N
33	29	080	014	20	KUBANGWUNGU	396	\N
33	29	080	015	20	DUKUHTENGAH	397	\N
33	29	080	016	20	KETANGGUNGAN	398	\N
33	29	080	017	10	CIDUWET	399	\N
33	29	080	018	10	BULAKELOR	400	\N
33	29	080	019	20	PADAKATON	648	24552
33	29	080	020	20	DUKUHTURI	649	24552
33	29	080	021	20	KARANGMALANG	650	24552
33	29	090	001	10	PENANGGAPAN	401	\N
33	29	090	002	10	CIPAJANG	402	\N
33	29	090	003	10	SINDANGHEULA	403	\N
33	29	090	004	10	BANDUNGSARI	404	\N
33	29	090	005	10	BLANDONGAN	405	\N
33	29	090	006	10	KERTASARI	406	\N
33	29	090	007	10	MALAHAYU	407	\N
33	29	090	008	10	CIKUYA	408	\N
33	29	090	009	20	BANJARHARJO	409	\N
33	29	090	010	10	PAREREJA	410	\N
33	29	090	011	10	CIGADUNG	411	\N
33	29	090	012	10	TIWULANDU	412	\N
33	29	090	013	10	CIKAKAK	413	\N
33	29	090	014	10	CIBENDUNG	414	\N
33	29	090	015	10	KARANGMAJA	415	\N
33	29	090	016	10	DUKUHJERUK	416	\N
33	29	090	017	10	PENDE	417	\N
33	29	090	018	10	SUKAREJA	418	\N
33	29	090	019	10	KUBANGJERO	419	\N
33	29	090	020	10	CIBUNIWANGI	420	\N
33	29	090	021	10	CIMUNDING	421	\N
33	29	090	022	10	CIAWI	422	\N
33	29	090	023	10	CIHAUR	423	\N
33	29	090	024	10	TEGALREJA	424	\N
33	29	090	025	10	BANJAR LOR	425	\N
33	29	100	001	10	RANDEGAN	426	\N
33	29	100	002	10	JATISAWIT	427	\N
33	29	100	003	10	KARANGSAMBUNG	428	\N
33	29	100	004	10	NEGLA	429	\N
33	29	100	005	20	BOJONGSARI	430	\N
33	29	100	006	20	KARANGJUNTI	431	\N
33	29	100	007	10	RUNGKANG	432	\N
33	29	100	008	10	DUKUHSALAM	433	\N
33	29	100	009	10	BABAKAN	434	\N
33	29	100	010	10	KALIBUNTU	435	\N
33	29	100	011	10	KEDUNGNENG	436	\N
33	29	100	012	10	RANDUSARI	437	\N
33	29	100	013	10	BLUBUK	438	\N
33	29	100	014	10	PEKAUMAN	439	\N
33	29	100	015	20	LOSARI KIDUL	440	\N
33	29	100	016	20	LOSARI LOR	441	\N
33	29	100	017	10	KECIPIR	442	\N
33	29	100	018	10	PENGABEAN	443	\N
33	29	100	019	10	LIMBANGAN	444	\N
33	29	100	020	10	PRAPAG KIDUL	445	\N
33	29	100	021	10	KARANGDEMPEL	446	\N
33	29	100	022	10	PRAPAG LOR	447	\N
33	29	110	001	10	SARIREJA	448	\N
33	29	110	002	10	KUBANGPUTAT	449	\N
33	29	110	003	20	LUWUNGGEDE	450	\N
33	29	110	004	10	MUNDU	451	\N
33	29	110	005	10	LUWUNGBATA	452	\N
33	29	110	006	10	KARANGREJA	453	\N
33	29	110	007	10	SIDAKATON	454	\N
33	29	110	008	10	SENGON	455	\N
33	29	110	009	10	KEDAWUNG	456	\N
33	29	110	010	10	TEGONGAN	457	\N
33	29	110	011	20	KEMURANG WETAN	458	\N
33	29	110	012	20	KEMURANG KULON	459	\N
33	29	110	013	10	KRAKAHAN	460	\N
33	29	110	014	20	PEJAGAN	461	\N
33	29	110	015	10	PENGARADAN	462	\N
33	29	110	016	20	TANJUNG	463	\N
33	29	110	017	20	LEMAHABANG	464	\N
33	29	110	018	20	TENGGULI	465	\N
33	29	120	001	10	KRADENAN	466	\N
33	29	120	002	10	SINDANGJAYA	467	\N
33	29	120	003	10	PENDE	468	\N
33	29	120	004	10	KUBANGPARI	469	\N
33	29	120	005	10	CIKANDANG	470	\N
33	29	120	006	20	CIGEDOG	471	\N
33	29	120	007	20	CIAMPEL	472	\N
33	29	120	008	10	JAGAPURA	473	\N
33	29	120	009	20	KERSANA	474	\N
33	29	120	010	10	KEMUKTEN	475	\N
33	29	120	011	10	KRAMATSAMPANG	476	\N
33	29	120	012	20	LIMBANGAN	477	\N
33	29	120	013	10	SUTAMAJA	478	\N
33	29	130	001	10	TEGALGLAGAH	479	\N
33	29	130	002	10	PETUNJUNGAN	480	\N
33	29	130	003	10	JUBANG	481	\N
33	29	130	004	10	DUKUHLO	482	\N
33	29	130	005	10	CIPELEM	483	\N
33	29	130	006	20	BANJARATMA	484	\N
33	29	130	007	10	SIWULUH	485	\N
33	29	130	008	10	LUWUNGRAGI	486	\N
33	29	130	009	10	BANGSRI	487	\N
33	29	130	010	10	RANCAWULUH	488	\N
33	29	130	011	20	BULUSARI	489	\N
33	29	130	012	10	KARANGSARI	490	\N
33	29	130	013	10	KLUWUT	491	\N
33	29	130	014	10	BULAKPAREN	492	\N
33	29	130	015	20	CIMOHONG	493	\N
33	29	130	016	10	GRINTING	494	\N
33	29	130	017	20	BULAKAMBA	495	\N
33	29	130	018	10	PAKIJANGAN	496	\N
33	29	130	019	10	PULOGADING	497	\N
33	29	140	001	10	TEGALGANDU	498	\N
33	29	140	002	10	JAGALEMPENI	499	\N
33	29	140	003	10	GLONGGONG	500	\N
33	29	140	004	10	SISALAM	501	\N
33	29	140	005	10	LENGKONG	502	\N
33	29	140	006	10	TANJUNGSARI	503	\N
33	29	140	007	10	SIWUNGKUK	504	\N
33	29	140	008	10	DUKUHWRINGIN	505	\N
33	29	140	009	10	SIGENTONG	506	\N
33	29	140	010	10	SIDAMULYA	507	\N
33	29	140	011	10	WANASARI	508	\N
33	29	140	012	10	SIASEM	509	\N
33	29	140	013	20	KLAMPOK	510	\N
33	29	140	014	20	PEBATAN	511	\N
33	29	140	015	20	PESANTUNAN	512	\N
33	29	140	016	10	KEBOLEDAN	513	\N
33	29	140	017	10	KUPU	514	\N
33	29	140	018	10	DUMELING	515	\N
33	29	140	019	10	KERTABESUKI	516	\N
33	29	140	020	10	SAWOJAJAR	517	\N
33	29	150	008	20	JATIBARANG KIDUL	525	\N
33	29	150	009	20	KARANGLO	526	\N
33	29	150	010	10	TEGALWULUNG	527	\N
33	29	150	011	20	JATIBARANG LOR	528	\N
33	29	150	012	20	KEMIRIAMBA	529	\N
33	29	150	013	10	KLAMPIS	530	\N
33	29	150	014	10	KEBONAGUNG	531	\N
33	29	150	015	10	KEBOGADUNG	532	\N
33	29	150	016	10	BOJONG	533	\N
33	29	150	017	10	KLIKIRAN	534	\N
33	29	150	018	20	JANEGARA	535	\N
33	29	150	019	20	KERTASINDUYASA	536	\N
33	29	150	020	10	PAMENGGER	537	\N
33	29	150	021	10	KENDAWA	538	\N
33	29	150	022	10	BUARAN	539	\N
33	29	150	023	20	KEDUNGTUKANG	540	\N
33	29	150	024	10	RENGASBANDUNG	541	\N
33	29	150	025	10	TEMBELANG	542	\N
33	29	150	026	10	PEDESLOHOR	543	\N
33	29	150	027	10	KALIPUCANG	544	\N
33	29	150	028	10	KALIALANG	545	\N
33	29	150	029	10	KRAMAT	546	\N
33	29	160	001	20	PEMARON	547	\N
33	29	160	002	20	KALIMATI	548	\N
33	29	160	003	20	LEMBARAWA	549	\N
33	29	160	004	20	KRASAK	550	\N
33	29	160	005	20	PADASUGIH	551	\N
33	29	160	006	20	WANGANDALEM	552	\N
33	29	160	007	20	TERLANGU	553	\N
33	29	160	008	20	PULOSARI	554	\N
33	29	160	009	20	BREBES	555	\N
33	29	160	010	20	GANDASULI	556	\N
33	29	160	011	20	BANJARANYAR	557	\N
33	29	160	012	20	KALIGANGSA KULON	558	\N
33	29	160	013	20	KALIGANGSA WETAN	559	\N
33	29	160	014	20	RANDUSANGA WETAN	560	\N
33	29	160	015	20	RANDUSANGA KULON	561	\N
33	29	160	016	20	LIMBANGAN WETAN	562	\N
33	29	160	017	20	LIMBANGAN KULON	563	\N
33	29	160	018	20	PASARBATANG	564	\N
33	29	160	019	20	SIGAMBIR	565	\N
33	29	160	020	20	PAGEJUGAN	566	\N
33	29	160	021	20	KEDUNGUTER	567	\N
33	29	160	022	20	TENGKI	568	\N
33	29	160	023	20	KALIWLINGI	569	\N
33	29	170	001	20	SONGGOM	570	\N
33	29	170	002	20	JATIROKEH	571	\N
33	29	170	003	10	CENANG	572	\N
33	29	170	004	10	WANATAWANG	573	\N
33	29	170	005	10	WANACALA	574	\N
33	29	170	006	20	KARANGSEMBUNG	575	\N
33	29	170	007	20	DUKUHMAJA	576	\N
33	29	170	008	10	SONGGOM LOR	658	\N
33	29	170	009	20	JATIMAKMUR	657	\N
33	29	170	010	10	GEGERKUNCI	656	\N
\.


--
-- Data for Name: pegawai; Type: TABLE DATA; Schema: public; Owner: bphtb
--

COPY pegawai (nip, nama) FROM stdin;
198404092010011025	PRIYANTO TAMAMI, S.KOM
\.


--
-- Data for Name: ppat; Type: TABLE DATA; Schema: public; Owner: bphtb
--

COPY ppat (kd_ppat, nama_ppat) FROM stdin;
\.


--
-- Data for Name: status; Type: TABLE DATA; Schema: public; Owner: bphtb
--

COPY status (kd_status, status_berkas) FROM stdin;
\.


--
-- Name: dat_login_pkey; Type: CONSTRAINT; Schema: public; Owner: bphtb; Tablespace: 
--

ALTER TABLE ONLY dat_login
    ADD CONSTRAINT dat_login_pkey PRIMARY KEY (nm_login);


--
-- Name: data_peralihan_pkey; Type: CONSTRAINT; Schema: public; Owner: bphtb; Tablespace: 
--

ALTER TABLE ONLY data_peralihan
    ADD CONSTRAINT data_peralihan_pkey PRIMARY KEY (kd_propinsi, kd_dati2, kd_kecamatan, kd_kelurahan, kd_blok, no_urut, kd_jns_op, no_sspd);


--
-- Name: data_wajib_pajak_pkey; Type: CONSTRAINT; Schema: public; Owner: bphtb; Tablespace: 
--

ALTER TABLE ONLY data_wajib_pajak
    ADD CONSTRAINT data_wajib_pajak_pkey PRIMARY KEY (wp_id);


--
-- Name: pbb_dat_objek_pajak_pkey; Type: CONSTRAINT; Schema: public; Owner: bphtb; Tablespace: 
--

ALTER TABLE ONLY pbb_dat_objek_pajak
    ADD CONSTRAINT pbb_dat_objek_pajak_pkey PRIMARY KEY (kd_propinsi, kd_dati2, kd_kecamatan, kd_kelurahan, kd_blok, no_urut, kd_jns_op);


--
-- Name: pbb_dat_subjek_pajak_pkey; Type: CONSTRAINT; Schema: public; Owner: bphtb; Tablespace: 
--

ALTER TABLE ONLY pbb_dat_subjek_pajak
    ADD CONSTRAINT pbb_dat_subjek_pajak_pkey PRIMARY KEY (subjek_pajak_id);


--
-- Name: pbb_ref_kecamatan_pkey; Type: CONSTRAINT; Schema: public; Owner: bphtb; Tablespace: 
--

ALTER TABLE ONLY pbb_ref_kecamatan
    ADD CONSTRAINT pbb_ref_kecamatan_pkey PRIMARY KEY (kd_propinsi, kd_dati2, kd_kecamatan);


--
-- Name: pbb_ref_kelurahan_pkey; Type: CONSTRAINT; Schema: public; Owner: bphtb; Tablespace: 
--

ALTER TABLE ONLY pbb_ref_kelurahan
    ADD CONSTRAINT pbb_ref_kelurahan_pkey PRIMARY KEY (kd_propinsi, kd_dati2, kd_kecamatan, kd_kelurahan);


--
-- Name: pegawai_pkey; Type: CONSTRAINT; Schema: public; Owner: bphtb; Tablespace: 
--

ALTER TABLE ONLY pegawai
    ADD CONSTRAINT pegawai_pkey PRIMARY KEY (nip);


--
-- Name: ppat_pkey; Type: CONSTRAINT; Schema: public; Owner: bphtb; Tablespace: 
--

ALTER TABLE ONLY ppat
    ADD CONSTRAINT ppat_pkey PRIMARY KEY (kd_ppat);


--
-- Name: status_pkey; Type: CONSTRAINT; Schema: public; Owner: bphtb; Tablespace: 
--

ALTER TABLE ONLY status
    ADD CONSTRAINT status_pkey PRIMARY KEY (kd_status);


--
-- Name: fk_data_wp; Type: FK CONSTRAINT; Schema: public; Owner: bphtb
--

ALTER TABLE ONLY data_peralihan
    ADD CONSTRAINT fk_data_wp FOREIGN KEY (wp_id) REFERENCES data_wajib_pajak(wp_id) MATCH FULL;


--
-- Name: fk_pbb_dat_subjek_pajak; Type: FK CONSTRAINT; Schema: public; Owner: bphtb
--

ALTER TABLE ONLY pbb_dat_objek_pajak
    ADD CONSTRAINT fk_pbb_dat_subjek_pajak FOREIGN KEY (subjek_pajak_id) REFERENCES pbb_dat_subjek_pajak(subjek_pajak_id) MATCH FULL;


--
-- Name: fk_pbb_ref_kecamatan; Type: FK CONSTRAINT; Schema: public; Owner: bphtb
--

ALTER TABLE ONLY pbb_ref_kelurahan
    ADD CONSTRAINT fk_pbb_ref_kecamatan FOREIGN KEY (kd_propinsi, kd_dati2, kd_kecamatan) REFERENCES pbb_ref_kecamatan(kd_propinsi, kd_dati2, kd_kecamatan);


--
-- Name: fk_ppat; Type: FK CONSTRAINT; Schema: public; Owner: bphtb
--

ALTER TABLE ONLY data_peralihan
    ADD CONSTRAINT fk_ppat FOREIGN KEY (kd_ppat) REFERENCES ppat(kd_ppat) MATCH FULL;


--
-- Name: fk_status; Type: FK CONSTRAINT; Schema: public; Owner: bphtb
--

ALTER TABLE ONLY data_peralihan
    ADD CONSTRAINT fk_status FOREIGN KEY (kd_status) REFERENCES status(kd_status) MATCH FULL;


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

