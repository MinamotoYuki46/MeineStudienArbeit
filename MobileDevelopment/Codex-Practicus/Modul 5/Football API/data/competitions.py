from models.competition import Competition

COMPETITIONS = [
    # Asia / AFC 

    Competition(
        id="afc_champions_league",
        name="AFC Champions League",
        country="Asia",
        confederation="AFC",
        logo_url="https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEgqhmdtSs7ndMdG826RBA6Gl3_pfRbNZQSz8QI-VV1V4PVXDypD_MDIizO4reeTUyZo_mkGbXjSkKrFA-3bdMR5fovKA-r58WcJ185CQKi7zmO3NaKLQjDBOI1Q8v6A9haIFDMso26B_ZU/s16000/AFC+Champions+League.png",
        logo_url_dark="https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEjmgaUZuMHIbBvyeX3140h4OwfiTwBfOHSWhN6sLPTRR7KCsw8mccManI2nNQU5iEyJcP5WlABs7Xyws_YlLfG1DTkT9c1-KzzwvRRqWjQGBfFjGWUl7leKSc0racbjd33H2xsWPijzCeo/s512/AFC+Champions+League.png"
    ),

    Competition(
        id="j1_league",
        name="J1 League",
        country="Japan",
        confederation="AFC",
        logo_url="https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEgo-SvnoyEutazo79xQvsSQvvFMoVo-74gX_NkX_8IWYWBsWTf5C4toiRPND1PmOjO5Ezn7EdwRZQ_oYBupXR8Lk-3z3cUG26dd0qp5IuRLlfmbooNdi9gkzzXiC2R7sUg6iB1VmjTbTUk/s1600/JL.png",
        logo_url_dark=""
    ),

    Competition(
        id="emperors_cup",
        name="Emperor's Cup",
        country="Japan",
        confederation="AFC",
        logo_url="https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEigVJ8OJRGSOC8FAgLkYPKCSyqLnOVVQDsmKosgfko-NUWGgVTkzUUvVgwjrkrpAyQLoibkGfEh5Jj0hRGU8odlR7iG8RgAtw5AHHhKHJ4ppnbrovzYZ2QLUmrjj0gEySJLOrQm9rj7_xU/s16000/EmperorsCup.png",
        logo_url_dark=""
    ),

    Competition(
        id="saudi_pro_league",
        name="Saudi Pro League",
        country="Saudi Arabia",
        confederation="AFC",
        logo_url="https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEgpNWEht4PninD9JXl0ahKetFdr_W8mdDFZmfVex4exCARZI3YSwVKO7xgbzCSzpDAJF1zyH_PhWLCU1atfD1jSUlxA8WiKUXg6dmGTM6pvvgjCBCtCn33tofFbv5FM6ffeHRjnm01S8WdlanFTh6S1IJED5NiuLzzo55PhE2ycB6-vsm83tKJbQ5Hs_dQ/s16000/Roshn%20Saudi%20League.png",
        logo_url_dark=""
    ),

    Competition(
        id="kings_cup",
        name="King's Cup",
        country="Saudi Arabia",
        confederation="AFC",
        logo_url="https://upload.wikimedia.org/wikipedia/en/thumb/d/d0/King_Cup.png/250px-King_Cup.png",
        logo_url_dark=""
    ),

    # Africa / CAF 
    Competition(
        id="caf_champions_league",
        name="CAF Champions League",
        country="Africa",
        confederation="CAF",
        logo_url="https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEhXNvwO2DjsyL5neUnM1xGMvr_1Jwkg0txk_sKUka7VlR-De9WWz3g5Oy20U0BU9FDOazMx_bV36WmJ_aMPhJXEDFRRJQkGrGLIOqnNXw6WS9VdimxcbzxFROADAwyDHoW6l1FhWqlVsi0/s16000/CAF+Champions+League.png",
        logo_url_dark=""
    ),

    Competition(
        id="egyptian_premier_league",
        name="Egyptian Premier League",
        country="Egypt",
        confederation="CAF",
        logo_url="https://upload.wikimedia.org/wikipedia/commons/thumb/e/eb/Egyptian_Premier_League_logo_2023.png/250px-Egyptian_Premier_League_logo_2023.png",
        logo_url_dark=""
    ),

    Competition(
        id="egypt_cup",
        name="Egypt Cup",
        country="Egypt",
        confederation="CAF",
        logo_url="https://static.flashscore.com/res/image/data/0S7bYBT1-E50NYguG.png",
        logo_url_dark=""
    ),

    Competition(
        id="linafoot",
        name="Linafoot",
        country="DR Congo",
        confederation="CAF",
        logo_url="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTCX1fBtGcg2KYwjNgOpD0v-eS22U_qRkO7KQ&s",
        logo_url_dark=""
    ),

    Competition(
        id="coupe_du_congo",
        name="Coupe du Congo",
        country="DR Congo",
        confederation="CAF",
        logo_url="https://rdcafrikfoot.com/wp-content/uploads/2025/01/InShot_20250105_154431429-1170x650.jpg",
        logo_url_dark=""
    ),

    Competition(
        id="algerian_championnat_national",
        name="Algerian Championnat National",
        country="Algeria",
        confederation="CAF",
        logo_url="https://upload.wikimedia.org/wikipedia/commons/thumb/7/7d/Ligue_1_Mobilis.png/500px-Ligue_1_Mobilis.png",
        logo_url_dark=""
    ),

    Competition(
        id="algerian_cup",
        name="Algerian Cup",
        country="Algeria",
        confederation="CAF",
        logo_url="https://upload.wikimedia.org/wikipedia/en/f/f9/Algerian_Cup.png",
        logo_url_dark=""
    ),

    Competition(
        id="ghana_premier_league",
        name="Ghana Premier League",
        country="Ghana",
        confederation="CAF",
        logo_url="https://upload.wikimedia.org/wikipedia/en/1/17/Ghana_Premier_League_2022.png",
        logo_url_dark=""
    ),

    Competition(
        id="ghanaian_fa_cup",
        name="Ghanaian FA Cup",
        country="Ghana",
        confederation="CAF",
        logo_url="https://upload.wikimedia.org/wikipedia/en/b/bc/MTN_Ghana_FA_Cup_logo.jpg",
        logo_url_dark=""
    ),

    Competition(
        id="tunisian_ligue_professionnelle_1",
        name="Tunisian Ligue Professionnelle 1",
        country="Tunisia",
        confederation="CAF",
        logo_url="https://upload.wikimedia.org/wikipedia/en/2/20/Tunisian_Ligue_1_%28logo%29.png",
        logo_url_dark=""
    ),

    Competition(
        id="tunisian_cup",
        name="Tunisian Cup",
        country="Tunisia",
        confederation="CAF",
        logo_url="https://upload.wikimedia.org/wikipedia/en/thumb/3/37/Tunisian_Cup_%28logo%29.png/330px-Tunisian_Cup_%28logo%29.png",
        logo_url_dark=""
    ),

    # North America / CONCACAF

    Competition(
        id="concacaf_champions_cup",
        name="CONCACAF Champions' Cup",
        country="North America",
        confederation="CONCACAF",
        logo_url="https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEgRaCn1h8mkj5DgWkY6X_yAM3U74_fpjGAL_1ChtBQAWO7CuNIPh_Cq4TPCspDpcDDGxif6Obm140SwJdnoN7i4EoEgcIxy_YlFnKMjdyrUo2KrlHHhoAzsrkBLyQo72g6gtFtX9ZaUhUW6EOjVMLk-vOFEmn6xhHsBanjKkkurdpwbl57bFpEfJ_jPXoc/s512/CONCACAF%20Champions%20Cup.png",
        logo_url_dark="https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEgAEbgYmIdcnnw1SEfL1tst_1fV_KMIcBoOq7PZSwTCgSzzLf9E47uESes3R6gknnFcwScYvpVKRv-iNJsCDBONe0hZNVglMh2AyhmCjyiqCEvr5XDp7ZAJ_4GR9-FXc4ESiSp4UQkF54PMBPZcQNeTmYhrzvtMzim2pbkUr2WHS4fu9DjCBCYzeBoSbHQ/s512/CONCACAF%20Champions%20Cup.png"
    ),

    Competition(
        id="liga_mx",
        name="Mexican Primera División / Liga MX",
        country="Mexico",
        confederation="CONCACAF",
        logo_url="https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEgAR7KtJrrj5ITz_X92EclwCLUr3mrlas49eqwv0e5wnMy5WsDD-Pb0zxPYIkVenihWKeFxe63Bg55PmceKB0JfjGjmTHqtPE2v8hrZH8isR-sdRBzUQdMz8M38lmjl_w1L5Qjz7AxSDZHU9n-ZW1H1hwGvibu11QeYBCKntOhwsc4H_3ekX4ir_bw5Z-I/s512/Liga%20BBVA%20MX.png",
        logo_url_dark="https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEg8lu6eHg_qDp4XplCU-CVdGquu8yApUehtEsavdqjolef61XqPkmph7y5yHPYtLWmP3FKXNQGndp2sLDYpNwjQvJ7nxOK4fnwSQ0RN6Ix3i0PXrbqHe80DrBPXNO7I8koJWPPFOS2cjUgVLgpGdB1Ris1C_tiMxYtUVWlmJm2JID7llSfCzXmh-5N4/s512/Liga%20BBVA%20MX.png"
    ),

    Competition(
        id="copa_mx",
        name="Copa MX",
        country="Mexico",
        confederation="CONCACAF",
        logo_url="https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEjMPk1G9wX12-ueGmOUclAmjfzzy4LU04t_91Whp9eZ7Ku1Fgwha0YexC6tCxpEmHjgRgwCR5VfuClOssO_VpPi0z1bJzZQiZecwRxp-sU2UfWMqDEId1IwZpC1WyGKGHUMZM4swhhw6PM/s1600/CopaMEX.png",
        logo_url_dark=""
    ),

    Competition(
        id="tt_pro_league",
        name="National League (Trinidad and Tobago)",
        country="Trinidad and Tobago",
        confederation="CONCACAF",
        logo_url="https://thettfa.com/wp-content/uploads/2023/02/PremierLeaguelogo-233x300.jpg",
        logo_url_dark=""
    ),

    Competition(
        id="trinidad_tobago_cup",
        name="Trinidad and Tobago Cup",
        country="Trinidad and Tobago",
        confederation="CONCACAF",
        logo_url="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSmCvdXp0e35SuWDfe8OvEFPDa6-f3bh0M-og&s",
        logo_url_dark=""
    ),

    # Oceeania and Australia / OFC 

    Competition(
        id="ofc_champions_league",
        name="OFC Champions League",
        country="Oceania",
        confederation="OFC",
        logo_url="https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEjmy_-ZJ7Y4ryA713PC5ZvljfUYRfE8tZ4YutLY4N2Ce6rg1MnlElmZECYjG-s0BEMQe1LL2WHjQPhLoJGnstoO4sJxn-7R5p8aGBHLso24OusimnuYEEJHRrVeOn3zPj-IurQIpiXiHNNte2W1vV0lU3ISYZCq_csQEr6iu9Kbz-xqVkJWinLp7qSBWxc/s16000/OFC.png",
        logo_url_dark="https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEjl0WIxw3HxoRnDkMGFhextf_f47Bz3bLYSEYwG059ZmZBlW1OhEXf23bYkwzKjqO06AAm-qyJ-RXYvUhyphenhyphenMt6GyxTVi61M0UIfk5tPmkQNW9KbClTZhltm4Qij3lhUWs4-9gsX9m0Ya2N0FEn8dWJ099eo5UKPmTuTBCFlQKnsCnGsqPwEpGObFoydz_E8/s16000/OFC.png"
    ),

    Competition(
        id="nzfc_minor_premiership",
        name="New Zealand National League",
        country="New Zealand",
        confederation="OFC",
        logo_url="https://upload.wikimedia.org/wikipedia/en/5/5f/New_Zealand_National_League.png",
        logo_url_dark="https://prodcdn.sporty.co.nz/cms/14667/newsarticles/100552_wo.png"
    ),

    Competition(
        id="nzfc_grand_final",
        name="NZFC Grand Final / Chatham Cup",
        country="New Zealand",
        confederation="OFC",
        logo_url="https://upload.wikimedia.org/wikipedia/en/4/4d/Chatham_Cup_logo.png",
        logo_url_dark=""
    ),

    Competition(
        id="new_caledonia_super_ligue",
        name="New Caledonia Super Ligue",
        country="New Caledonia",
        confederation="OFC",
        logo_url="https://cdn.footystats.org/img/competitions/new-caledonia-super-ligue.png",
        logo_url_dark=""
    ),

    Competition(
        id="new_caledonia_cup",
        name="New Caledonia Cup",
        country="New Caledonia",
        confederation="OFC",
        logo_url="https://caledoniacup.com/assets/images/image03.png?v=b280ac7f",
        logo_url_dark=""
    ),

    # Europe / UEFA 

    Competition(
        id="uefa_champions_league",
        name="UEFA Champions League",
        country="Europe",
        confederation="UEFA",
        logo_url="https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEiWR16FIxnI46HJeFwoEVVS7S8D_3XXpHo0LYEPEM-6DFks_dqRDrixc1LC065bDaKrLo9Rbh-AlY67dr7kQrH_zdzetMZ_bGDW686hZJXo1RBsS-X_xOjauC6QyXkKI09euk88wrxphFg/s16000/UEFACL.png",
        logo_url_dark="https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEg7QlZm7AO2tnSmuc3FkayP98OGUbZ2ly2t5idIn9NtmX6r3IphS1ifIASwkMkEJUYfuRofPHC8c3RPQ9xxpcYUnAE8-5dhTPCVOhfn8p6gKG1GHQrHJ59BAUQJYw7uKAZPXt6jpREPDfY/s512/UCL.png"
    ),

    Competition(
        id="la_liga",
        name="La Liga",
        country="Spain",
        confederation="UEFA",
        logo_url="https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEirXlLZ6JGoNTRW4xbsozgyfWK6Px4XVkQ-AOxSeoSOjvB6Uma4rYshen8djk6uIwkgD_KsHJl9d7WD6jCcPvLLPa6DtB25ok9qszZ6EoYPcYL_FiOOjsVQVWrKQsJTy9dT6XGFYOCj1Q412AVMNvXn40SCvw4Q_34Nhu33-XhhlH5P3GMMzle-fBSFg6A/s16000/LaLiga.png",
        logo_url_dark=""
    ),

    Competition(
        id="copa_del_rey",
        name="Copa del Rey",
        country="Spain",
        confederation="UEFA",
        logo_url="https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEi9N_rB47_G30CYJ-LWWWYHxyItMeGOAgzg_Rkkd_ErXbYpa6nVq4Ray8vD7a0Nb4uIT3ECc42P5N1ENyGfGw_4tJZyRFPpbyeMvGqgI3DFHsXTkPsOFYZ6N97tW1MbybOyvxXO4eQ6gHY93HXkTBh-Se9G8dNdnEIli0MpEpwhwSiWOwJwFU_3Ihim/s16000/Copa%20del%20Rey.png",
        logo_url_dark=""
    ),

    Competition(
        id="bundesliga",
        name="Bundesliga",
        country="Germany",
        confederation="UEFA",
        logo_url="https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEjYoD4X1x58XgU0PMsewJXb8HbJ5yofILRBJt4zBDEMi_aC6mj83bzeNZCjevZfHG6DHlMwWX6RGiCdA_rSKmg5ruTgRqPlNUnwS0W10JyjY_SD4dlN34wfqJ5uXVX4r_1if3ncOu3SJdc/s1600/Bundesliga.png",
        logo_url_dark="https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEhmscFmXe1ki5uWEoyhSRPDswEPgIIY43LQqHYugXc6HkuF8lHy1P7eBkQB1386ZKFbTPHo43aaD7mmk5NeDPAE60ISXdJPnKd5BhYKD6b4tyCoZp8R0YcXlj71b3kh9JohPoxivyAu6lE/s1600/Bundesliga.png"
    ),

    Competition(
        id="dfb_pokal",
        name="DFB-Pokal",
        country="Germany",
        confederation="UEFA",
        logo_url="https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEiElKqA7bjLtiI_bQ3Nmh2J8deQ_2MsoNjOgurQ-iak6yi1oVSP1v3bO67B-0muplkoWz4n8nYVPdpkQzXy0L_6uIEQD_keGWlnD7B0WeAri6aaYAtWgixJqxkJr9iuMi_C7EpoNBtmXNCm/s1600/DFB+Pokal.png",
        logo_url_dark="https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEguVhvfbUAA9Dtth9rElS2Ip4-NwLuA0GWtI5VIEad-nAGfCRq7Cof1GmowXeM_uI2tyiVNezuR0c-2c7t9zbJztDkrGhwxibhEXXeS0cyFgHhy6fJVg9sWPwDhLFLPoKn39Zmi3ilFOFB8/s1600/DFB+Pokal+B.png"
    ),

    Competition(
        id="scottish_football_league",
        name="Scottish Premiership",
        country="Scotland",
        confederation="UEFA",
        logo_url="https://assets.b365api.com/images/wp/o/19357a284b7cdd433858b7de2b223b55.png",
        logo_url_dark=""
    ),

    Competition(
        id="scottish_cup",
        name="Scottish Cup",
        country="Scotland",
        confederation="UEFA",
        logo_url="https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEg5oW9PvGaLj-VtNwiAgUSk0yfxl_oYvZanxxEKFznllGcIIF_XGH7XQ6Q-9ogpUTxRgcYQrG1e6Px8YU9vk2HGnJEVQt7y5D0Jld75-UvY3PBQD90e-q68gQ27rOTmCuEZ6L4G9b3Yj40/s16000/The+Scottish+Cup.png",
        logo_url_dark=""
    ),

    Competition(
        id="eredivisie",
        name="Eredivisie",
        country="Netherlands",
        confederation="UEFA",
        logo_url="https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEiRt_5sWfEIFvQfHJnQTjCfn4Lhu1sCNO48p6s-DWIAW6lHcmLD7SmAjD5Xa3hn5r0TCAcfm9pXIl4QUHZ2hY0JFySRG0Ye6tAU8Ztx4jwcsmy2tk5h7OqqfK5MlEaPj7gEv19CirsTwKLH/s1600/Eredivisie+v2.PNG",
        logo_url_dark="https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEhrOXGqeQlnPFnaIcYdvSHBTJSehOD2XH4u0_z6FulKjiTaoPImel88NnQbXzdyD6uC8JWXvszQW4quJX25ALsuEmx7D653witbfLf8QP4rMsCKvsCc-PHWC_vsWEN2Z8o9k4y9tNBdv8kv9NPjI8OxOflJB8vvo1JLvIfMHxD7wQb8xyntk9sxrHLZ/s512/ERE.png"
    ),

    Competition(
        id="knvb_cup",
        name="KNVB Cup",
        country="Netherlands",
        confederation="UEFA",
        logo_url="https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEg3cNdi7CGEZfft85Z7Xb8CGhctXB4TOIJXEMlhizEB4HJASmWwOmt1UiBMBBtAtBLnSzhB8Qa39r5t-bd-Ez4TsAL0OKV1WUr1_c6RH9ZHk9NfCav8DRtNGfTwrm4gTELnWTfbEaCpqlA/s1600/Johan+Cruijff+Schaal.PNG",
        logo_url_dark="https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEhWw6MGRap94Vi9WMjCirTYlj49LRKk5_RsOMI3g26oEZcsgwJTnGugskBhkifLtnZClvkdm4bVVbpKtArK444wzloT27JaDtR-Bgimz2IMFTDdaOzqquug8ZK3dyrOW5_j4FKZJURXnkQ/"
    ),

    Competition(
        id="premier_league",
        name="Premier League",
        country="England",
        confederation="UEFA",
        logo_url="https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEinfbw332e0UzbLOV7XBjJtUA43wR1Lm7cRq1UKVMHwTpK2J49ZE3vbN6zhmGX-72OHQcHZo63GtpH-qT6CBZ409itDt9bqeTARdwkJON1vMQkDLx5MA0HhkuUxmaTrjfQwyrwl-8QSkEESg_Toj_IF2zMxyAYqcA2Buw1Dq2f_5FeKnLpnWkPXfOBD-DI/s512/Premier%20League.png",
        logo_url_dark=""
    ),

    Competition(
        id="fa_cup",
        name="FA Cup",
        country="England",
        confederation="UEFA",
        logo_url="https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEjGQM1b0b1kcu8_hDubwOlnshMgl6H1gK054HOhfR8oylrdVLTMdUrIpAy4FwBKuRwyQnbg93EZowIIc_ZqnXxMmvHMAWfxfRjkieJ8bPdjc9M4kFSKZQ9kDICBOPkBuumU8CwHIbVeapw/s512/The+Emirates+FA+Cup.png",
        logo_url_dark="https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEh7mJexbFKDSfTRvl_HY566_sojE144NOXc4gBJibsPZ1KyNNAJ7xOokrIJ98tQmrutAr0srOjfY51blze0qzNDWveJUEkfMh4oRCkh_yPjmLHuRB68Wiwh6S-MQFmSHCOc1dnngES8JJE/s512/The+Emirates+FA+Cup.png"
    ),

    Competition(
        id="serie_a",
        name="Serie A",
        country="Italy",
        confederation="UEFA",
        logo_url="https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEi-bYQ_NKnIkxVV3picXvDAlA2HbQc5P00fPAiufxTZSzblHCB78kMRZBY8c3vw_6m8ftCCe5um1FxzEON3ecAC6L2fl3bmMaF2_kOFYUAsJQtaBzvxGx6UOSXBghAAfZyzO7QIOTCBb7oVzG1e6Awqec2R6BiRdNtgm3BiS9IsPskLeRxtfnIQVzQZIyE/s16000/Serie%20A%20Enilive.png",
        logo_url_dark=""
    ),

    Competition(
        id="coppa_italia",
        name="Coppa Italia",
        country="Italy",
        confederation="UEFA",
        logo_url="https://blogger.googleusercontent.com/img/a/AVvXsEjarxOMJvogM6bbcWlxCwLiNM01EjglNbr_HiuG0_4IPLOurn2OFz1ADMJy7Dm9kGo3tEZbBDNbJvDBzPNTDelamxtoKCUTJ54JprrEg9GoysMaxykNV_7w4C29I_01RnaaKPHg-7tFGHJkSgWhk87dNsInvLn8IFjumfDJR9ujA0yUxMPcDONf9Z4S=s16000",
        logo_url_dark=""
    ),

    Competition(
        id="ligue_1",
        name="Ligue 1",
        country="France",
        confederation="UEFA",
        logo_url="https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEiU3I0UcpOk2nXpxekhJtd7LlvNZMjrhM3Wr5NeqEzsDbteF-Atz-OT3qKqDk_bRbCELeVbGsD4MTJqb8qjb_pLXNyiXijrcyOT5xGaAVGl-nJM5ExVVdxorBzpKMJo17YT7R412xbU9cTlPeN6DuyCwyt_ycw49P33qgSfJFwPgT6DPysIjdRgFV9Kw7Y/s512/FRA.png",
        logo_url_dark="https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEiu12AwR6MfHy54nNO3BK_dHCx_hyphenhyphenVBI1k-UZJF1s2Ydm1y2KZiOOnl7eeDbF6qt4N55mkGQHPjp4huawQw3YTv6-X8dD4tulyubV4l-eQJYqFm_RblFpjUWmGpn0Q-rYFifY8eT1xzsgnxjHqlcO5ZZUdVetrilcf3sPifE1pUqdW1YbFpi-K2F7blh_k/s16000/Ligue%201%20McDonald's%20.png",
    ),

    Competition(
        id="coupe_de_france",
        name="Coupe de France",
        country="France",
        confederation="UEFA",
        logo_url="https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEiNwHPuw5232suqSlHbxSSPmOTa7kVdgiN_DsqYlXvNcqst5o3hIAEXOWGpnRj2JtLPYnZk2J-ekD1_-fkAP-Cbs0Wgi-9OghpyKUHFFt95hssu0bGERudF0yt0J9kjczSE7eQnOJ9pa2YD5YC9SdzCCFkbXENU2bHtxTqHqTuhI-1R3jC91i7QkfKNvt4/s16000/Coupe%20de%20France.png",
        logo_url_dark=""
    )
]
