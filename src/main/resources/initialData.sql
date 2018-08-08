insert into BLOG_USER VALUES(1, 'ahmetcan@gmail.com', 'Ahmet Can', '123456', CURRENT_TIMESTAMP());
insert into BLOG_USER VALUES(2, 'burakburuk@gmail.com', 'Burak Buruk', 'abcdef1', CURRENT_TIMESTAMP());
insert into BLOG_USER VALUES(3, 'tkiziloren@havelsan.com.tr', 'Tevfik Kızılören', '123123', CURRENT_TIMESTAMP());

insert into BLOG VALUES(1, CURRENT_TIMESTAMP(), 'Seyahatlerim hakkında her şey', 'Gezi Bloğum', 1);
insert into BLOG VALUES(2, CURRENT_TIMESTAMP(), 'Javascript paylaşımlarım', 'Burak Buruk''un JavaScript Bloğu', 2);

insert into POST VALUES(1, 'Lorem ipsum dolor sit amet, cetero fierent suavitate cum in, pri an impedit phaedrum, ne nec molestie singulis. Vel amet labores omittam cu, ius dicant nullam everti ne, ex vis everti facilisis voluptatum. Sed tation impedit aliquando no. Pro an aperiri abhorreant, sed id elit dictas facilisi. Integre lobortis ne eos, vel quas graecis ex. Nam everti minimum noluisse id, has et legere adipisci constituto. Semper appareat dissentiet sed ei.',
CURRENT_TIMESTAMP (), 'Safranbolu gezisi', 1, 1);

insert into POST VALUES(2, 'Lorem ipsum dolor sit amet, cetero fierent suavitate cum in, pri an impedit phaedrum, ne nec molestie singulis. Vel amet labores omittam cu, ius dicant nullam everti ne, ex vis everti facilisis voluptatum. Sed tation impedit aliquando no. Pro an aperiri abhorreant, sed id elit dictas facilisi. Integre lobortis ne eos, vel quas graecis ex. Nam everti minimum noluisse id, has et legere adipisci constituto. Semper appareat dissentiet sed ei.',
CURRENT_TIMESTAMP (), 'React ve Redux''a Giriş', 2, 2);

insert into COMMENT VALUES(1, 'Aşırı güzel bir yazı', CURRENT_TIMESTAMP (), 'Çok güzel', 1, 1);
insert into COMMENT VALUES(2, 'Ben böyle yazı görmedim', CURRENT_TIMESTAMP (), 'Harika', 1, 2);
