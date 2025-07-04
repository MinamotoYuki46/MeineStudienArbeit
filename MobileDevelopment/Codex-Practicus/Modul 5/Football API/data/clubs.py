from models.club import Club
import textwrap


CLUBS = [
    # Asia / AFC

    Club(
        id="tokyo_ferdy",
        name="Tokyo Verdy",
        country="Japan",
        confederation="AFC",
        treble_years=["1987"],
        competition_ids=["j1_league", "emperors_cup", "afc_champions_league"],
        logo_url="https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEia3XqyV7Gz8m7lKkI366HxgC2tNu8-ieEdM6KdcasPTpawsQ_9LraKlgYqjSgfTxDSfolaDU0riU8APfX1kjWo409YsFZZ-rvc6M-FlYmTRi51LUIglMydr4q7y6R07ClHlNQRDY75Qpc/s1600/Tokyo+Verdy.png",
        web_url="https://www.verdy.co.jp/",
        description = textwrap.dedent("""
            Yomiuri SC, later known as Tokyo Verdy, asserted their dominance in Japanese football in the 1987 season. Powered by a core of rising domestic stars and a tactically astute midfield, they cruised to the Japan Soccer League title. They complemented it with a triumph in the Emperor’s Cup, defeating Furukawa Electric in a narrow extra-time final. The crowning achievement was their Asian Club Championship victory, where they overcame Al-Sadd of Qatar with their disciplined defence and relentless pressing, completing the first historic treble in Japanese club football.
        """).strip()
    ),

    Club(
        id="al_hilal_sfc",
        name="Al Hilal SFC",
        country="Saudi Arabia",
        confederation="AFC",
        treble_years=["2020"],
        competition_ids=["saudi_pro_league", "kings_cup", "afc_champions_league"],
        logo_url="https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEjJguE-ii-Ekne5b4w2EVlDauqTBG-8sl0JEZgRXEWDNDlbxRfuKVlQLJA-ERGiU-A0cCm7Tdh7tJI4qwKSjy6qq6SBmV3-_xPhXKCL7hTs4yLET9okqTk4XWNQIMg8kmzOI3g_gRr_fTw35Ju6_MOzIz3fK_y_SFwva0D94xU3FiKVMHVhEPhRbZmd/s16000/Al-Hilal%20FC.png",
        web_url="https://www.alhilal.com/",
        description=textwrap.dedent("""
            Al Hilal's 2019 campaign was a season of redemption and glory. After years of near-misses, they stormed to the Saudi Pro League title with their attacking quartet tearing through defences. In the King's Cup, they outlasted domestic rivals Al-Nassr in a pulsating final. Their crowning moment came in the AFC Champions League, where they defeated Urawa Red Diamonds over two legs, exorcising past demons and securing an emphatic treble — the first in their history.
        """).strip()
    ),

    # Africa / CAF 

    Club(
        id="al_ahly_sc",
        name="Al Ahly SC",
        country="Egypt",
        confederation="CAF",
        treble_years=["2006", "2007", "2020"],
        competition_ids=["egyptian_premier_league", "egypt_cup", "caf_champions_league"],
        logo_url="https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEgs5dhTUj0k3gtMKUcADTC2GHLu4uPfgqYVe9_IPiY-MbuQ5kSSrWJuT-cnZIMhsftyJlcC-YXdjT13iZnJ9y_S55cfvv7Qj0Ga_RCg5aFnuJ5LtnOiec78KNdlegYDEh7LPGayVTArBZGsVaI0H16EXkxQhBkNBsjPl3k8Vu6uXhYEHCIFkV69FxqGBMQ/s16000/Al%20Ahly%20SC.png",
        web_url="https://www.alahlyegypt.com/",
        description=textwrap.dedent("""
            Al Ahly's first modern treble came in the 2005–06 season under the legendary Manuel José. Domestically, they were dominant, securing the Egyptian Premier League with a strong unbeaten run. In the Egypt Cup, they showcased depth and resilience, defeating Zamalek 3–0 in the final. Their crowning glory came in the CAF Champions League, where they avenged past defeats and beat CS Sfaxien of Tunisia with a stunning injury-time goal by Mohamed Aboutrika in the second leg of the final, sealing their place among the elite of African football.
            
            Remarkably, Al Ahly repeated the treble feat in the very next season. The Red Devils continued their dominance in the Egyptian Premier League, finishing comfortably ahead of their rivals. They lifted the Egypt Cup once again, edging out Al Zamalek in a dramatic final that ended 4–3 after extra time. In the CAF Champions League, Al Ahly defeated Étoile du Sahel in a tightly contested final, solidifying their reign in African football and confirming the golden era under José.
            
            After more than a decade, Al Ahly returned to treble-winning form in 2019–20, under coach Pitso Mosimane (who joined just before the CAF final). They stormed through the Egyptian Premier League with a huge points gap. In the Egypt Cup, they showed grit, beating Tala'ea El Gaish on penalties in the final. However, the highlight of the season was the historic CAF Champions League final against rivals Zamalek, dubbed the "Final of the Century." Al Ahly triumphed 2–1, with Mohamed Magdy Afsha scoring a memorable late winner to clinch their ninth continental title.
        """).strip()
    ),

    Club(
        id="tp_mazembe",
        name="TP Mazembe",
        country="DR Congo",
        confederation="CAF",
        treble_years=["1966"],
        competition_ids=["linafoot", "coupe_du_congo", "caf_champions_league"],
        logo_url="https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEicM_wfWnwOHHr83xyjKDOQOffCmRyuihVBeQVaAmVOlZTryQFSV0He95dOLCqlyxf45gv5wGLutoVjOiNMElUP0HTgPA23gg5vO66WHbtxe4-wzBJdXmHD8onsX2oORTP0J9nNwMXl1QJ_ifCO3GSNNHGNaFOWga8ULUqX5bZnY0Fy3LkR3sVKbm9J/s16000/TP%20Mazembe.png",
        web_url="https://www.tpmazembe.com/",
        description=textwrap.dedent("""
            The Congolese powerhouse Englebert, now known as TP Mazembe, created history in 1967. They lifted the Linafoot title and the Coupe du Congo before embarking on a legendary run in the African Cup of Champions Clubs, defeating Asante Kotoko in a dramatic final. Their rugged physicality and tactical superiority saw them claim Africa's first recognised continental treble, setting a benchmark for decades to come.
        """).strip()
    ),

    Club(
        id="as_vita_club",
        name="AS Vita Club",
        country="DR Congo",
        confederation="CAF",
        treble_years=["1973"],
        competition_ids=["linafoot", "coupe_du_congo", "caf_champions_league"],
        logo_url="https://upload.wikimedia.org/wikipedia/en/2/22/AS_Vita_Club_%28logo%29.png",
        web_url="https://www.asvitaclub.com/",
        description=textwrap.dedent("""
            In 1973, AS Vita Club reached the pinnacle of African football. After claiming the Congolese league and national cup double, they shocked the continent by winning the African Cup of Champions Clubs, dispatching Ghana's Asante Kotoko in the final. Their style — built on strength, pace, and flair — captured hearts across Africa, and their treble that year remains a cherished memory in Kinshasa.
        """).strip()
    ),

    Club(
        id="mc_alger",
        name="MC Alger",
        country="Algeria",
        confederation="CAF",
        treble_years=["1976"],
        competition_ids=["algerian_championnat_national", "algerian_cup", "caf_champions_league"],
        logo_url="https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEgwpzD_iP-De8w8Z3DTAYo_978d8087paAYLJUc4pdNeZOXXsZUPTDX6u_uWIp519IkWS_bXBuaz2Q8cIfP8S7H4OEa6CAifqM3EMxV9xbFIwqPuT7QP8uIp9YpKWQVO2A4lfp0-U9sNM8npTcZbaRPJTbaqPm7F-insYQpbyrL2pk9m87FZN9wONr5ZjM/s16000/MC%20Alger.png",
        web_url="https://www.mcalger.dz/",
        description=textwrap.dedent("""
            MC Alger blazed through Algerian football in 1976 with a potent mix of youth and experience. They clinched the Algerian Ligue 1 and Algerian Cup, but their biggest triumph came in the African Cup of Champions Clubs, where they beat Hafia FC in the final. The treble was a proud moment for Algerian football, showcasing the nation's rise in the continental scene post-independence.
        """).strip()
    ),

    Club(
        id="accra_hearts_of_oak",
        name="Accra Hearts of Oak SC",
        country="Ghana",
        confederation="CAF",
        treble_years=["2000"],
        competition_ids=["ghana_premier_league", "ghanaian_fa_cup", "caf_champions_league"],
        logo_url="https://upload.wikimedia.org/wikipedia/en/0/01/Accra_hearts_of_oak_sc.png",
        web_url="https://www.heartsofoaksc.com/",
        description=textwrap.dedent("""
            Ghana's Accra Hearts of Oak made history in 2000 with one of the most balanced squads ever seen in African club football. Dominating the Ghana Premier League and FA Cup, they stormed through the CAF Champions League with tactical brilliance, culminating in a famous victory over Esperance in the final. The treble marked Ghana's resurgence in African club football and made household names of Charles Taylor and Emmanuel Osei Kuffour.
        """).strip()
    ),

    Club(
        id="esperance_tunis",
        name="Espérance Sportive de Tunis",
        country="Tunisia",
        confederation="CAF",
        treble_years=["2011"],
        competition_ids=["tunisian_ligue_professionnelle_1", "tunisian_cup", "caf_champions_league"],
        logo_url="https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEgUnmONWiMTFs-EV1yxiZcMJ_YK1z_l6jGvE1vRl3jNh1UMj1cYluN6G4S5C1hxlsIl0WrrmEeJ_KVUJ3U7AOALjBSw4j60k66_Umxw9v244wK-rJzmSy_EaUk5Wk2yENrvIVQ2yCMYcqZlxaIRPXxdLv74MUqrNdXOO5dKokcbbdPumaKmdXv8Zq_4bkg/s16000/Esp%C3%A9rance%20Sportive%20de%20Tunis.png",
        web_url="https://www.est.org.tn/",
        description=textwrap.dedent("""
            Espérance Sportive de Tunis had a golden year in 2011, winning the Tunisian Ligue Professionnelle 1 and Tunisian Cup with flair and consistency. Their crowning moment came in the CAF Champions League, where they outclassed Wydad Casablanca in the final. With a rock-solid defence and vibrant attacking trio, they lifted the treble in front of jubilant home fans in Tunis.
        """).strip()
    ),

    # Oceania and Australia / OFC 

    Club(
        id="auckland_city_fc",
        name="Auckland City FC",
        country="New Zealand",
        confederation="OFC",
        treble_years=["2006", "2014", "2015", "2020"],
        competition_ids=["nzfc_minor_premiership", "nzfc_grand_final", "ofc_champions_league"],
        logo_url="https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEhphxOoA6ML1IkStdKZFLMy1mV4s5UJIWIixJmCDiJrv8iYnEcuhK3lGLS1GIrSiblGAUlIgT_TbfmliJIqwy-73mq8ktTE91lfT5KKR4o9rf3eqgvEHZ2QvmoFezI8AqZ1f6Fe9thf7RHM_p8P9NNZBygOiZq_WAddAEhCpmHXGVSXu9duagxgBIgL/s16000/Auckland%20City%20FC.png",
        web_url="https://www.aucklandcityfc.com/",
        description=textwrap.dedent("""
            In 2006, Auckland City FC claimed their first treble, establishing themselves as the premier football club in New Zealand. They won the New Zealand Football Championship (NZFC), topping the league and winning the Grand Final. In the Chatham Cup, they lifted the trophy with a blend of strong defence and clinical finishing. Their biggest milestone was winning the inaugural OFC Champions League, which qualified them for their first FIFA Club World Cup appearance, a major moment not just for the club but for New Zealand football as a whole.
            
            The 2014 season was a golden chapter in Auckland City's history. They secured the ASB Premiership, dominating the domestic competition with tactical precision under coach Ramon Tribulietx. In the Chatham Cup, they battled through intense fixtures to win the national knockout trophy. They also triumphed in the OFC Champions League, cementing their status as Oceania's finest. This treble-winning squad went on to achieve a historic third-place finish at the FIFA Club World Cup, defeating Mexico's Cruz Azul and taking South American champions San Lorenzo to extra time — an unprecedented feat for an Oceania club.
            
            Auckland City completed back-to-back trebles in 2015, further solidifying their dominance. They retained the ASB Premiership title with consistent performances throughout the season. The team also lifted the Chatham Cup once again, showcasing their ability to manage both league and knockout formats effectively. In the OFC Champions League, they defended their crown, defeating Team Wellington in the final. Though their Club World Cup campaign was less remarkable than the year before, the 2015 treble confirmed the club's continued superiority in both domestic and continental competitions.
            
            Despite the challenges brought by the COVID-19 pandemic, Auckland City secured another treble in 2020. They were declared winners of the New Zealand Premiership after leading the table prior to its cancellation. In the Chatham Cup, which returned that year, they again proved their knockout strength. Most significantly, they were nominated by the OFC as the region's representative for the 2020 FIFA Club World Cup, following the cancellation of the OFC Champions League — a decision based on their status as the top-ranked Oceania club. Although they later withdrew from the Club World Cup due to quarantine regulations, the treble stood as a testament to their continued excellence.
        """).strip()
    ),

    Club(
        id="waitakere_united",
        name="Waitakere United",
        country="New Zealand",
        confederation="OFC",
        treble_years=["2008"],
        competition_ids=["nzfc_minor_premiership", "nzfc_grand_final", "ofc_champions_league"],
        logo_url="https://upload.wikimedia.org/wikipedia/en/thumb/2/2b/Waitakere_United.svg/1200px-Waitakere_United.svg.png",
        web_url="https://www.waitakereunited.co.nz/",
        description=textwrap.dedent("""
            Waitakere United's 2008 season was defined by sharp attacking football and local pride. They clinched both the New Zealand league title and Chatham Cup, and in the OFC Champions League, they edged past Kossa FC with a hard-fought aggregate win. Their treble brought them international attention and established them as serious contenders to Auckland City's dominance.
        """).strip()
    ),

    Club(
        id="hienghene_sport",
        name="Hienghène Sport",
        country="New Caledonia",
        confederation="OFC",
        treble_years=["2019"],
        competition_ids=["new_caledonia_super_ligue", "new_caledonia_cup", "ofc_champions_league"],
        logo_url="https://upload.wikimedia.org/wikipedia/en/e/e2/HlEGHENSPORT_400x400.png",
        web_url="https://www.hienghenesport.nc/",
        description=textwrap.dedent("""
            From the small town of Hienghène, the club made a fairy-tale run in 2019. They won the New Caledonia Super Ligue and New Caledonia Cup, but their crowning glory was the OFC Champions League, where they beat AS Magenta in an all-New Caledonian final. Their historic treble sent shockwaves through the Pacific and earned them a spot at the FIFA Club World Cup.
        """).strip()
    ),

    # North America / CONCACAF 

    Club(
        id="cruz_azul",
        name="Cruz Azul",
        country="Mexico",
        confederation="CONCACAF",
        treble_years=["1969", "1997"],
        competition_ids=["liga_mx", "copa_mx", "concacaf_champions_cup"],
        logo_url="https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEgmjTrQGKdYz_R0XwyVM8h8fYPGy7_SCcu6kRkki9vlw7c16miKiSk1qSbF2EA_b7zcEIAbbxISaqvHffqq7AYgYOAlUDeOmuwo8VO2McX50trV3TSXO3NX1q55gRgxyWGE0OKqI4hKfs_Z5ZRi1-eZZcAD0Nhy0p2sskE6FSbLbrFtN4EwlwAUsXyX/s16000/Club%20de%20Futbol%20Cruz%20Azul.png",
        web_url="https://www.cruzazulfc.com.mx/",
        description=textwrap.dedent("""
            Cruz Azul announced their arrival as a Mexican powerhouse in the 1969 season by completing a stunning domestic treble. They clinched the Primera División title with a blend of physicality and flair, spearheaded by the legendary Eladio Vera and a disciplined backline. Their momentum continued in the Copa México, where they overcame Club América in a tense final. To cap it all off, they secured the Campeón de Campeones trophy, defeating the league's best in a symbolic showdown. This treble — achieved just a few years after their promotion to the top flight — marked the beginning of Cruz Azul's golden era.
            
            Cruz Azul's 1997 Invierno campaign was one of redemption and resurgence. After a 17-year wait since their last league title, they battled their way to the Liga MX championship in dramatic fashion. Led by the iconic Carlos Hermosillo, whose golden goal and famously painful penalty sealed the final against León, Cruz Azul captured the hearts of fans across Mexico. While they didn't secure a full treble that year, the league triumph alone felt monumental — restoring the club's status among Mexico's elite and ending nearly two decades of longing.
        """).strip()
    ),

    Club(
        id="defence_force_fc",
        name="Defence Force FC",
        country="Trinidad and Tobago",
        confederation="CONCACAF",
        treble_years=["1985"],
        competition_ids=["tt_pro_league", "trinidad_tobago_cup", "concacaf_champions_cup"],
        logo_url="https://upload.wikimedia.org/wikipedia/en/1/12/Defence_Force_FC_%28Trinidad_%26_Tobago%29.png",
        web_url="https://www.defenceforcefc.com/",
        description=textwrap.dedent("""
            Trinidad and Tobago's Defence Force were untouchable in 1985. They took the TT Pro League and FA Trophy before making a triumphant run in the CONCACAF Champions' Cup, beating Honduras' Olimpia in the final. Their treble was the Caribbean's proudest club football moment, built on military discipline and community passion.
        """).strip()
    ),

    Club(
        id="monterrey",
        name="Monterrey",
        country="Mexico",
        confederation="CONCACAF",
        treble_years=["2012"],
        competition_ids=["liga_mx", "copa_mx", "concacaf_champions_cup"],
        logo_url="https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEgSvKVXzDsSVCG2caJJ3-MYrYr_H-fVzVlFbJpk8aqKxeDEIfN-IzlT0Jwb0SdCR0nE2SL_lq81tOoMk2g-nKvFDq7-xjs0WyUDTPeIHUk9he_p4rS6MT08TljQXyDRjhhkdOQ75J95-QQ/d/Monterrey.png",
        web_url="https://www.rayados.com/",
        description=textwrap.dedent("""
            In 2012, CF Monterrey were kings of CONCACAF. They won the Apertura Liga MX and Copa MX, but their dominant run in the CONCACAF Champions League, capped by a win over Santos Laguna, was the jewel in their crown. Their squad, featuring Humberto Suazo and Aldo de Nigris, was the perfect blend of flair and efficiency.
        """).strip()
    ),

    # Europe / UEFA 

    Club(
        id="fc_barcelona",
        name="FC Barcelona",
        country="Spain",
        confederation="UEFA",
        treble_years=["2009", "2015"],
        competition_ids=["la_liga", "copa_del_rey", "uefa_champions_league"],
        logo_url="https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEh4xprb5TfHqTe6hCvl4hiV6pdlgPfiG_722ZGkfNOPbK1K7bWrklpdZ2wMR_qvSuCSpXuLKMSGAH7IhB9PY61vG5ctNQ4-R-Je18Uq5-oYEN8pfP0z7c7-EtQE_gjr-iDR2D3t6F26mr8/s16000/FC+Barcelona.png",
        web_url="https://www.fcbarcelona.com",
        description=textwrap.dedent("""
            In 2009, FC Barcelona, under the management of Pep Guardiola, achieved a historic treble, becoming the first Spanish club to do so. The team secured the La Liga title with a blend of attacking flair and defensive solidity. In the Copa del Rey final, Barcelona dominated Athletic Bilbao with a 4–1 victory, showcasing their superiority in domestic competitions. The pinnacle of their season was the UEFA Champions League final, where they faced Manchester United. Barcelona triumphed 2–0, with goals from Samuel Eto'o and Lionel Messi, completing a season that redefined modern football with their tiki-taka style and cohesive team play.
            
            Barcelona replicated their treble success in 2015 under manager Luis Enrique, becoming the first European club to achieve this feat twice. They clinched the La Liga title, demonstrating consistency and resilience throughout the season. In the Copa del Rey final, Barcelona defeated Athletic Bilbao 3–1, with Lionel Messi delivering a standout performance. The UEFA Champions League final saw Barcelona overcome Juventus 3–1, with goals from Ivan Rakitić, Luis Suárez, and Neymar. This treble was marked by the formidable attacking trio of Messi, Suárez, and Neymar, who were instrumental in Barcelona's dominance across all competitions.
        """).strip()
    ),

    Club(
        id="manchester_united_fc",
        name="Manchester United FC",
        country="England",
        confederation="UEFA",
        treble_years=["1999"],
        competition_ids=["premier_league", "fa_cup", "uefa_champions_league"],
        logo_url="https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEi9YExdW3I2rugp21CLvyTvAwStk9JpRkThyphenhyphen4PNO_slhHbvSPj54sTHl69WsUju9f-Z4CIEI28F-3WWU0-LLYSZsA4bpwph3wPGc-D-OLWp7WX3rvW7APlrX1BR9A5M0JUMCJ_IR6maiM1U/s1600/Manchester+United+FC.png",
        web_url="https://www.manutd.com",
        description=textwrap.dedent("""
            Manchester United's 1998–99 season under Sir Alex Ferguson is etched in history as one of the most remarkable in football. They secured the Premier League title on the final day with a comeback victory against Tottenham Hotspur. Four days later, United won the FA Cup, defeating Newcastle United 2–0. The crowning achievement came in the UEFA Champions League final against Bayern Munich. Trailing 1–0 as the match entered injury time, United staged a dramatic comeback with goals from Teddy Sheringham and Ole Gunnar Solskjær, winning 2–1. This victory completed an unprecedented treble, showcasing the team's resilience and never-say-die spirit.
        """).strip()
    ),

    Club(
        id="celtic_fc",
        name="Celtic FC",
        country="Scotland",
        confederation="UEFA",
        treble_years=["1967"],
        competition_ids=["scottish_football_league", "scottish_cup", "uefa_champions_league"],
        logo_url="https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEjFGhj9s_qtfA3qdGLLoz8NdD6iOx9oRvzUQfMZHmhgW_G31e_qKqZmTF5l8zxBjdWn6Bljk2ZQuRIO4XgR2vbLfwNXp8IB6hVEateOj6dkwJUevhq4LCbZ3TUHFDvcmxGaTimgv_TX_VA/s1600/Celtic+FC.png",
        web_url="https://www.celticfc.com",
        description=textwrap.dedent("""
            Celtic FC's 1967 campaign remains legendary. Nicknamed the "Lisbon Lions", they became the first British team to win the European Cup, defeating Inter Milan in the final. They also captured the Scottish League title and Scottish Cup, completing a stunning treble and etching themselves into football history with their all-Scottish-born squad.
        """).strip()
    ),

    Club(
        id="afc_ajax",
        name="AFC Ajax",
        country="Netherlands",
        confederation="UEFA",
        treble_years=["1972"],
        competition_ids=["eredivisie", "knvb_cup", "uefa_champions_league"],
        logo_url="https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEg9PmYDMrBYfeqxJTQ37qqtdDAD5C8DRRmWeBv5jIIAhWt3cZfCwkILEOswo2ynXmCCda9PTU1avR6bClR3hMKHLOwq0MH6qFVNnIi8vlnt7Bjsb2edN4RTVWXTJaMyVUiAVTgtCy56NZT-xCkjPMt4RvjggQNXXSnRtzqXMYLgpjEyCJCODr5CrCnF0Og/s16000/AFC%20Ajax.png",
        web_url="https://english.ajax.nl",
        description=textwrap.dedent("""
            Under Rinus Michels and then Ștefan Kovács, Ajax swept all before them in 1972. They lifted the Eredivisie, KNVB Cup, and defended their European Cup title with a commanding win over Inter. With Johan Cruyff orchestrating "Total Football", Ajax's treble embodied a footballing revolution that reshaped the game forever.
        """).strip()
    ),

    Club(
        id="psv_eindhoven",
        name="PSV Eindhoven",
        country="Netherlands",
        confederation="UEFA",
        treble_years=["1988"],
        competition_ids=["eredivisie", "knvb_cup", "uefa_champions_league"],
        logo_url="https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEi9yjkPz-XRYg7k_7CJd0IeeGBd7y3-4zwNoaf7InYe26zL8DvvtbaGF9V97n3B8dbitB2G0OYet7SAoBEOcPWgOjzAGan2RnW3VBa6vZLFxzetHfCZ0KFCUqIlj7pk-m4kj0_flLuWygs/d/PSV+Eindhoven.png",
        web_url="https://www.psv.nl",
        description=textwrap.dedent("""
            In 1988, PSV Eindhoven produced a miracle season. They clinched the Eredivisie and KNVB Cup, and shocked Europe by winning the European Cup, overcoming Benfica in a tense final. Coached by Guus Hiddink and backed by a golden generation of players, their treble remains one of Dutch football's greatest feats.
        """).strip()
    ),

    Club(
        id="internazionale",
        name="Internazionale",
        country="Italy",
        confederation="UEFA",
        treble_years=["2010"],
        competition_ids=["serie_a", "coppa_italia", "uefa_champions_league"],
        logo_url="https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEgfT_vwHFHyKVnUD4kSDhrm41uMQRm3E9shzp-BfCstC1w94uhcBpNF9dvW4UIOYWNwB8QA6YTFwrgDvUelzqS5HM7YazW2EgbukOckHtEy8jA86xtNihjORwl1TVRoHkj3pHJGs9BDAiA/s16000/FC+Internazionale.png",
        web_url="https://www.inter.it",
        description=textwrap.dedent("""
            Internazionale, under José Mourinho, had a dream 2009–10 season. Anchored by the formidable duo of Sneijder and Milito, they won the Serie A, Coppa Italia, and conquered Europe with a masterful performance against Bayern Munich in the UEFA Champions League final. Their defensive steel and counter-attacking brilliance earned Italy's first ever continental treble.
        """).strip()
    ),

    Club(
        id="fc_bayern_munich",
        name="FC Bayern Munich",
        country="Germany",
        confederation="UEFA",
        treble_years=["2013", "2020"],
        competition_ids=["bundesliga", "dfb_pokal", "uefa_champions_league"],
        logo_url="https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEjtkNLaxAJxYN926xVQtgigAJTpdeeYb4yF9KhKXyhHZhBd7PFI9wH4AExPSTJfs-cyKu83Bfit49Gjwzzot0CiHD11vObVtoXwhCivVk8TQ7185bXvpvska3DXNsfwO6FWsLDleiwX1T94rWwxSKWoKlU3cr9JAOy-E7qd1nJ56gokxnylPDmcINpeLHc/s16000/FC%20Bayern%20Munich.png",
        web_url="https://fcbayern.com",
        description=textwrap.dedent("""
            Bayern Munich were unstoppable in 2013. Under Jupp Heynckes, they stormed to the Bundesliga, DFB-Pokal, and capped it off with a dramatic Champions League win over rivals Borussia Dortmund. With a squad boasting Ribéry, Robben, and Müller, their treble remains one of the most dominant in modern football.
            
            Bayern Munich's 2019–20 season was a masterclass in dominance and resilience. After a shaky start, the club surged under new manager Hansi Flick, eventually clinching the Bundesliga title with weeks to spare. They followed it up with a commanding run in the DFB-Pokal, sweeping past Bayer Leverkusen in the final. But it was in Europe where Bayern truly stunned the world — demolishing Barcelona 8–2 in the quarter-finals, then defeating Lyon and Paris Saint-Germain to claim their sixth UEFA Champions League crown. Powered by a red-hot Robert Lewandowski, a revitalised Thomas Müller, and explosive talents like Alphonso Davies, Bayern completed a flawless continental treble, winning all 11 Champions League matches — a feat never achieved before.
        """).strip()
    ),

    Club(
        id="manchester_city_fc",
        name="Manchester City FC",
        country="England",
        confederation="UEFA",
        treble_years=["2023"],
        competition_ids=["premier_league", "fa_cup", "uefa_champions_league"],
        logo_url="https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEj0su_nv05pM0YMgNg9uU9MTjEhwhG4RslvQLDaAzzCWcUn4GKyJEvML6nupVC6Mpg87RV0FbPQISxIZhYTSfFeYirkrAk158GRZtFka1bNXSEYs1Zt0SzxV-VtLLu8Z1hCgMhvp1mn5W8v/s1600/Manchester+City+FC.png",
        web_url="https://www.mancity.com",
        description=textwrap.dedent("""
            After years of building, Manchester City finally reached the summit in 2023. Pep Guardiola's side played mesmerising football to win the Premier League, FA Cup, and the elusive UEFA Champions League, beating Inter Milan in the final. Led by Haaland and De Bruyne, their treble was the crowning achievement of a footballing dynasty.
        """).strip()
    ),

    Club(
        id="paris_saint-germain_fc",
        name="Paris Saint-Germain FC",
        country="France",
        confederation="UEFA",
        treble_years=["2025"],
        competition_ids=["ligue_1", "coupe_de_france", "uefa_champions_league"],
        logo_url="https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEgMbVmT0vg94b9ZaYZvTxI8NVuD2z4mylTrAwj-1AmK7bqaDwHYVr9hteeLmidE68cmPfGTB_g3vnan4y5IcaK-vqXSPpEV6fczPgJs2mMpVYAT__F7lTAQ3mfgryMCTp6Y-AaVOZ0O0mUf/s1600/Paris+Saint+Germain.png",
        web_url="https://en.psg.fr/",
        description=textwrap.dedent("""
            Paris Saint-Germain’s 2024–25 campaign under Luis Enrique was characterised by domestic dominance and continental ambition: they secured the Ligue 1 title with a commanding performance throughout the season and followed it by lifting the Coupe de France, before embarking on a memorable UEFA Champions League run that culminated in a historic 5–0 victory over Inter Milan in the final—securing the club’s first European Cup and completing a continental treble, a feat no French side had achieved before.
        """).strip()
    )
]
