INSERT INTO student (id,
                     email,
                     student_code,
                     username,
                     first_name,
                     middle_name,
                     last_name,
                     profile_image,
                     phone,
                     address,
                     birth_day,
                     id_card,
                     gender,
                     create_at,
                     update_at,
                     status,
                     major_id,
                     campus_id)
VALUES
    (
        UUID_TO_BIN('367511ac-bf97-11ee-bdb8-106530543950'),
        'manhnmhe171616@fpt.edu.vn',
        'he171616',
        'manhnmhe171616',
        'nguyen',
        'minh',
        'manh',
        'https://images.pexels.com/photos/16214084/pexels-photo-16214084/free-photo-of-man-standing-in-bike-helmet-by-motorcycle.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load',
        '0124567893',
        'Hai Phong',
        '2003-01-26',
        '031203004436',
        true,
        CURRENT_TIMESTAMP,
        CURRENT_TIMESTAMP,
        true,
        UUID_TO_BIN('4bb418a0-bf96-11ee-bdb8-106530543950'),
        '1'
    ),

    (
        UUID_TO_BIN('ea855438-bfa1-11ee-bdb8-106530543950'),
        'cuongvvhe170851@fpt.edu.vn',
        'he170851',
        'cuongvvhe170851',
        'vu',
        'van',
        'cuong',
        'https://images.pexels.com/photos/5940278/pexels-photo-5940278.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load',
        '0124567894',
        'Quang Ninh',
        '2003-04-14',
        '031203002231',
        true,
        CURRENT_TIMESTAMP,
        CURRENT_TIMESTAMP,
        true,
        UUID_TO_BIN('4bb418a0-bf96-11ee-bdb8-106530543950'),
        '1'
    ),
    (
        UUID_TO_BIN('3e1f5432-bf97-11ee-bdb8-106530543950'),
        'hoaittvhe171026@fpt.edu.vn',
        'he171026',
        'hoaittvhe171026',
        'trinh',
        'thi',
        'hoa',
        'https://images.pexels.com/photos/7203884/pexels-photo-7203884.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load',
        '0124567895',
        'Vinh Phuc',
        '2003-05-18',
        '031203004235',
        true,
        CURRENT_TIMESTAMP,
        CURRENT_TIMESTAMP,
        true,
        UUID_TO_BIN('4bb418a0-bf96-11ee-bdb8-106530543950'),
        '2'
    ),
    (
        UUID_TO_BIN('4d192c9c-bf97-11ee-bdb8-106530543950'),
        'dungnvhe170688@fpt.edu.vn',
        'he170688',
        'dungnvhe170688',
        'nguyen',
        'van',
        'dung',
        'https://images.pexels.com/photos/7119216/pexels-photo-7119216.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load',
        '0124567896',
        'Nam Dinh',
        '2003-07-22',
        '031203003235',
        true,
        CURRENT_TIMESTAMP,
        CURRENT_TIMESTAMP,
        true,
        UUID_TO_BIN('4bb418a0-bf96-11ee-bdb8-106530543950'),
        '3'
    ),
    (
        UUID_TO_BIN('5c49be7c-bf97-11ee-bdb8-106530543950'),
        'duytnvhe170985@fpt.edu.vn',
        'he170985',
        'duytnvhe170985',
        'trinh',
        'ngoc',
        'duy',
        'https://images.pexels.com/photos/6511684/pexels-photo-6511684.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load',
        '0124567897',
        'Hai Duong',
        '2003-09-30',
        '031203005634',
        true,
        CURRENT_TIMESTAMP,
        CURRENT_TIMESTAMP,
        true,
        UUID_TO_BIN('72e18d9c-bf96-11ee-bdb8-106530543950'),
        '4'
    ),
    (
        UUID_TO_BIN('6d3b1740-bf97-11ee-bdb8-106530543950'),
        'chinhhtvhe170654@fpt.edu.vn',
        'he170654',
        'chinhhtvhe170654',
        'hoang',
        'thanh',
        'chinh',
        'https://images.pexels.com/photos/6783763/pexels-photo-6783763.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load',
        '0124567898',
        'Thai Nguyen',
        '2003-11-14',
        '031203004437',
        true,
        CURRENT_TIMESTAMP,
        CURRENT_TIMESTAMP,
        true,
        UUID_TO_BIN('72e18d9c-bf96-11ee-bdb8-106530543950'),
        '1'
    ),
    (
        UUID_TO_BIN('7c18a222-bf97-11ee-bdb8-106530543950'),
        'quyetltvhe170951@fpt.edu.vn',
        'he170951',
        'quyetltvhe170951',
        'le',
        'dinh',
        'quyet',
        'https://images.pexels.com/photos/5784378/pexels-photo-5784378.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load',
        '0124567899',
        'Bac Giang',
        '2003-12-20',
        '031203001234',
        true,
        CURRENT_TIMESTAMP,
        CURRENT_TIMESTAMP,
        true,
        UUID_TO_BIN('72e18d9c-bf96-11ee-bdb8-106530543950'),
        '2'
    ),
    (
        UUID_TO_BIN('8b694a4a-bf97-11ee-bdb8-106530543950'),
        'huytvhe170764@fpt.edu.vn',
        'he170764',
        'huytvhe170764',
        'tran',
        'van',
        'huy',
        'https://images.pexels.com/photos/7068965/pexels-photo-7068965.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load',
        '0124567900',
        'Dak Lak',
        '2004-02-05',
        '031203005432',
        true,
        CURRENT_TIMESTAMP,
        CURRENT_TIMESTAMP,
        true,
        UUID_TO_BIN('72e18d9c-bf96-11ee-bdb8-106530543950'),
        '3'
    ),
    (
        UUID_TO_BIN('9a9ce3e6-bf97-11ee-bdb8-106530543950'),
        'quyenttvhe170567@fpt.edu.vn',
        'he170567',
        'quyenttvhe170567',
        'tran',
        'thi',
        'quyen',
        'https://images.pexels.com/photos/6065407/pexels-photo-6065407.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load',
        '0124567901',
        'Quang Tri',
        '2004-03-12',
        '031203002233',
        true,
        CURRENT_TIMESTAMP,
        CURRENT_TIMESTAMP,
        true,
        UUID_TO_BIN('72e18d9c-bf96-11ee-bdb8-106530543950'),
        '4'
    ),
    (
        UUID_TO_BIN('ab1d1f84-bf97-11ee-bdb8-106530543950'),
        'namttvhe170358@fpt.edu.vn',
        'he170358',
        'namttvhe170358',
        'tran',
        'van',
        'nam',
        'https://images.pexels.com/photos/4057803/pexels-photo-4057803.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load',
        '0124567902',
        'Binh Phuoc',
        '2004-04-26',
        '031203003132',
        true,
        CURRENT_TIMESTAMP,
        CURRENT_TIMESTAMP,
        true,
        UUID_TO_BIN('72e18d9c-bf96-11ee-bdb8-106530543950'),
        '1'
    ),
    (
        UUID_TO_BIN('b8b1e052-bf97-11ee-bdb8-106530543950'),
        'tungltvhe170789@fpt.edu.vn',
        'he170789',
        'tungltvhe170789',
        'le',
        'thi',
        'tung',
        'https://images.pexels.com/photos/7051766/pexels-photo-7051766.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load',
        '0124567903',
        'Binh Duong',
        '2004-06-08',
        '031203003135',
        true,
        CURRENT_TIMESTAMP,
        CURRENT_TIMESTAMP,
        true,
        UUID_TO_BIN('72e18d9c-bf96-11ee-bdb8-106530543950'),
        '2'
    ),
    (
        UUID_TO_BIN('c5ec0c9a-bf97-11ee-bdb8-106530543950'),
        'phongmtvhe170951@fpt.edu.vn',
        'he170951',
        'phongmtvhe170951',
        'ma',
        'thi',
        'phong',
        'https://images.pexels.com/photos/6547279/pexels-photo-6547279.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load',
        '0124567904',
        'Ha Nam',
        '2004-07-20',
        '031203004223',
        true,
        CURRENT_TIMESTAMP,
        CURRENT_TIMESTAMP,
        true,
        UUID_TO_BIN('72e18d9c-bf96-11ee-bdb8-106530543950'),
        '3'
    ),
    (
        UUID_TO_BIN('d2a7ad6a-bf97-11ee-bdb8-106530543950'),
        'hoanvthe170123@fpt.edu.vn',
        'he170123',
        'hoanvthe170123',
        'van',
        'thanh',
        'hoan',
        'https://images.pexels.com/photos/3965560/pexels-photo-3965560.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load',
        '0124567905',
        'Kien Giang',
        '2004-08-14',
        '031203002212',
        true,
        CURRENT_TIMESTAMP,
        CURRENT_TIMESTAMP,
        true,
        UUID_TO_BIN('72e18d9c-bf96-11ee-bdb8-106530543950'),
        '4'
    ),(
        UUID_TO_BIN('e6c7d9b8-bf97-11ee-bdb8-106530543950'),
        'tuyetltvhe170098@fpt.edu.vn',
        'he170098',
        'tuyetltvhe170098',
        'le',
        'thi',
        'tuyet',
        'https://images.pexels.com/photos/6662355/pexels-photo-6662355.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load',
        '0124567906',
        'Dien Bien',
        '2004-09-15',
        '031203001113',
        true,
        CURRENT_TIMESTAMP,
        CURRENT_TIMESTAMP,
        true,
        UUID_TO_BIN('4bb418a0-bf96-11ee-bdb8-106530543950'),
        '1'
    ),
    (
        UUID_TO_BIN('f5adacf6-bf97-11ee-bdb8-106530543950'),
        'quyenltvhe170009@fpt.edu.vn',
        'he170009',
        'quyenltvhe170009',
        'le',
        'thi',
        'quyen',
        'https://images.pexels.com/photos/4608233/pexels-photo-4608233.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load',
        '0124567907',
        'Da Nang',
        '2004-10-25',
        '031203002211',
        true,
        CURRENT_TIMESTAMP,
        CURRENT_TIMESTAMP,
        true,
        UUID_TO_BIN('4bb418a0-bf96-11ee-bdb8-106530543950'),
        '2'
    ),
    (
        UUID_TO_BIN('01f172cc-bf98-11ee-bdb8-106530543950'),
        'thanhltvhe170753@fpt.edu.vn',
        'he170753',
        'thanhltvhe170753',
        'le',
        'thi',
        'thanh',
        'https://images.pexels.com/photos/4365360/pexels-photo-4365360.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load',
        '0124567908',
        'Gia Lai',
        '2004-11-10',
        '031203003322',
        true,
        CURRENT_TIMESTAMP,
        CURRENT_TIMESTAMP,
        true,
        UUID_TO_BIN('4bb418a0-bf96-11ee-bdb8-106530543950'),
        '3'
    ),
    (
        UUID_TO_BIN('0d74019e-bf98-11ee-bdb8-106530543950'),
        'longlvthe170234@fpt.edu.vn',
        'he170234',
        'longlvthe170234',
        'le',
        'van',
        'long',
        'https://images.pexels.com/photos/6688323/pexels-photo-6688323.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load',
        '0124567909',
        'Bac Lieu',
        '2004-12-20',
        '031203002112',
        true,
        CURRENT_TIMESTAMP,
        CURRENT_TIMESTAMP,
        true,
        UUID_TO_BIN('4bb418a0-bf96-11ee-bdb8-106530543950'),
        '4'
    ),
    (
        UUID_TO_BIN('1892e88c-bf98-11ee-bdb8-106530543950'),
        'duyvthe170456@fpt.edu.vn',
        'he170456',
        'duyvthe170456',
        'vu',
        'van',
        'duy',
        'https://images.pexels.com/photos/6627016/pexels-photo-6627016.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load',
        '0124567910',
        'Ha Noi',
        '2005-01-15',
        '031203001334',
        true,
        CURRENT_TIMESTAMP,
        CURRENT_TIMESTAMP,
        true,
        UUID_TO_BIN('72e18d9c-bf96-11ee-bdb8-106530543950'),
        '1'
    ),
    (
        UUID_TO_BIN('2494e950-bf98-11ee-bdb8-106530543950'),
        'linhntvhe170789@fpt.edu.vn',
        'he170789',
        'linhntvhe170789',
        'nguyen',
        'thi',
        'linh',
        'https://images.pexels.com/photos/3953579/pexels-photo-3953579.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load',
        '0124567911',
        'Ho Chi Minh',
        '2005-02-20',
        '031203003335',
        true,
        CURRENT_TIMESTAMP,
        CURRENT_TIMESTAMP,
        true,
        UUID_TO_BIN('72e18d9c-bf96-11ee-bdb8-106530543950'),
        '2'
    ),
    (
        UUID_TO_BIN('2e555ef2-bf98-11ee-bdb8-106530543950'),
        'phongtvhe170234@fpt.edu.vn',
        'he170234',
        'phongtvhe170234',
        'tran',
        'van',
        'phong',
        'https://images.pexels.com/photos/4407310/pexels-photo-4407310.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load',
        '0124567912',
        'Da Nang',
        '2005-03-30',
        '031203004455',
        true,
        CURRENT_TIMESTAMP,
        CURRENT_TIMESTAMP,
        true,
        UUID_TO_BIN('72e18d9c-bf96-11ee-bdb8-106530543950'),
        '3'
    ),
    (
        UUID_TO_BIN('3b2a6110-bf98-11ee-bdb8-106530543950'),
        'tienttvhe170753@fpt.edu.vn',
        'he170753',
        'tienttvhe170753',
        'tran',
        'thi',
        'tien',
        'https://images.pexels.com/photos/5766653/pexels-photo-5766653.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load',
        '0124567913',
        'Can Tho',
        '2005-04-25',
        '031203005661',
        true,
        CURRENT_TIMESTAMP,
        CURRENT_TIMESTAMP,
        true,
        UUID_TO_BIN('72e18d9c-bf96-11ee-bdb8-106530543950'),
        '4'
    ),
    (
        UUID_TO_BIN('48c0dd20-bf98-11ee-bdb8-106530543950'),
        'tungltvhe170123@fpt.edu.vn',
        'he170123',
        'tungltvhe170123',
        'le',
        'thi',
        'tung',
        'https://images.pexels.com/photos/3682855/pexels-photo-3682855.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load',
        '0124567914',
        'Bac Ninh',
        '2005-05-10',
        '031203002345',
        true,
        CURRENT_TIMESTAMP,
        CURRENT_TIMESTAMP,
        true,
        UUID_TO_BIN('4bb418a0-bf96-11ee-bdb8-106530543950'),
        '1'
    ),
    (
        UUID_TO_BIN('52dc24f2-bf98-11ee-bdb8-106530543950'),
        'khanhttvhe170001@fpt.edu.vn',
        'he170001',
        'khanhttvhe170001',
        'le',
        'thi',
        'khanh',
        'https://images.pexels.com/photos/4726236/pexels-photo-4726236.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load',
        '0124567915',
        'Quang Binh',
        '2005-06-18',
        '031203003332',
        true,
        CURRENT_TIMESTAMP,
        CURRENT_TIMESTAMP,
        true,
        UUID_TO_BIN('4bb418a0-bf96-11ee-bdb8-106530543950'),
        '2'
    ),
    (
        UUID_TO_BIN('58a4b582-bf98-11ee-bdb8-106530543950'),
        'chienltvhe170123@fpt.edu.vn',
        'he170123',
        'chienltvhe170123',
        'le',
        'thanh',
        'chien',
        'https://images.pexels.com/photos/3943880/pexels-photo-3943880.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load',
        '0124567916',
        'Hue',
        '2005-07-25',
        '031203001223',
        true,
        CURRENT_TIMESTAMP,
        CURRENT_TIMESTAMP,
        true,
        UUID_TO_BIN('4bb418a0-bf96-11ee-bdb8-106530543950'),
        '3'
    ),
    (
        UUID_TO_BIN('5da94d0c-bf98-11ee-bdb8-106530543950'),
        'tienttvhe170654@fpt.edu.vn',
        'he170654',
        'tienttvhe170654',
        'nguyen',
        'thi',
        'tien',
        'https://images.pexels.com/photos/6556283/pexels-photo-6556283.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load',
        '0124567917',
        'Khanh Hoa',
        '2005-08-30',
        '031203004112',
        true,
        CURRENT_TIMESTAMP,
        CURRENT_TIMESTAMP,
        true,
        UUID_TO_BIN('4bb418a0-bf96-11ee-bdb8-106530543950'),
        '4'
    ),
    (
        UUID_TO_BIN('60f7b5f2-bf98-11ee-bdb8-106530543950'),
        'vietttvhe170246@fpt.edu.vn',
        'he170246',
        'vietttvhe170246',
        'tran',
        'thanh',
        'viet',
        'https://images.pexels.com/photos/6019694/pexels-photo-6019694.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load',
        '0124567918',
        'Bac Kan',
        '2005-09-25',
        '031203002114',
        true,
        CURRENT_TIMESTAMP,
        CURRENT_TIMESTAMP,
        true,
        UUID_TO_BIN('72e18d9c-bf96-11ee-bdb8-106530543950'),
        '1'
    ),
    (
        UUID_TO_BIN('64b49990-bf98-11ee-bdb8-106530543950'),
        'hongtvhe170035@fpt.edu.vn',
        'he170035',
        'hongtvhe170035',
        'le',
        'thi',
        'hong',
        'https://images.pexels.com/photos/3762180/pexels-photo-3762180.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load',
        '0124567919',
        'Thai Binh',
        '2005-10-30',
        '031203003331',
        true,
        CURRENT_TIMESTAMP,
        CURRENT_TIMESTAMP,
        true,
        UUID_TO_BIN('72e18d9c-bf96-11ee-bdb8-106530543950'),
        '2'
    ),
    (
        UUID_TO_BIN('698e1d10-bf98-11ee-bdb8-106530543950'),
        'tunvthe170758@fpt.edu.vn',
        'he170758',
        'tunvthe170758',
        'nguyen',
        'van',
        'tu',
        'https://images.pexels.com/photos/4569245/pexels-photo-4569245.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load',
        '0124567920',
        'Binh Thuan',
        '2005-11-25',
        '031203004111',
        true,
        CURRENT_TIMESTAMP,
        CURRENT_TIMESTAMP,
        true,
        UUID_TO_BIN('72e18d9c-bf96-11ee-bdb8-106530543950'),
        '3'
    ),
    (
        UUID_TO_BIN('6e00b164-bf98-11ee-bdb8-106530543950'),
        'vutvhe170123@fpt.edu.vn',
        'he170123',
        'vutvhe170123',
        'vu',
        'thi',
        'vu',
        'https://images.pexels.com/photos/4186499/pexels-photo-4186499.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load',
        '0124567921',
        'Bac Giang',
        '2005-12-30',
        '031203001332',
        true,
        CURRENT_TIMESTAMP,
        CURRENT_TIMESTAMP,
        true,
        UUID_TO_BIN('72e18d9c-bf96-11ee-bdb8-106530543950'),
        '4'
    ),
    (
        UUID_TO_BIN('72b07d26-bf98-11ee-bdb8-106530543950'),
        'tungtvhe170124@fpt.edu.vn',
        'he170124',
        'tungtvhe170124',
        'le',
        'thi',
        'tung',
        'https://images.pexels.com/photos/6015712/pexels-photo-6015712.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load',
        '0124567922',
        'Phu Tho',
        '2006-01-15',
        '031203002331',
        true,
        CURRENT_TIMESTAMP,
        CURRENT_TIMESTAMP,
        true,
        UUID_TO_BIN('4bb418a0-bf96-11ee-bdb8-106530543950'),
        '1'
    ),
    (
        UUID_TO_BIN('77f7b154-bf98-11ee-bdb8-106530543950'),
        'thuyntvhe170356@fpt.edu.vn',
        'he170356',
        'thuyntvhe170356',
        'nguyen',
        'thi',
        'thuy',
        'https://images.pexels.com/photos/5547254/pexels-photo-5547254.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load',
        '0124567923',
        'Quang Nam',
        '2006-02-25',
        '031203003122',
        true,
        CURRENT_TIMESTAMP,
        CURRENT_TIMESTAMP,
        true,
        UUID_TO_BIN('4bb418a0-bf96-11ee-bdb8-106530543950'),
        '2'
    ),
    (
        UUID_TO_BIN('7e0a94a4-bf98-11ee-bdb8-106530543950'),
        'haontvhe170780@fpt.edu.vn',
        'he170780',
        'haontvhe170780',
        'nguyen',
        'thi',
        'hao',
        'https://images.pexels.com/photos/5022089/pexels-photo-5022089.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load',
        '0124567924',
        'Ninh Binh',
        '2006-03-30',
        '031203004332',
        true,
        CURRENT_TIMESTAMP,
        CURRENT_TIMESTAMP,
        true,
        UUID_TO_BIN('4bb418a0-bf96-11ee-bdb8-106530543950'),
        '3'
    ),
    (
        UUID_TO_BIN('8316adfc-bf98-11ee-bdb8-106530543950'),
        'nganttvhe170234@fpt.edu.vn',
        'he170234',
        'nganttvhe170234',
        'tran',
        'thi',
        'ngan',
        'https://images.pexels.com/photos/6628677/pexels-photo-6628677.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load',
        '0124567925',
        'Dak Lak',
        '2006-04-25',
        '031203001332',
        true,
        CURRENT_TIMESTAMP,
        CURRENT_TIMESTAMP,
        true,
        UUID_TO_BIN('4bb418a0-bf96-11ee-bdb8-106530543950'),
        '4'
    ),
    (
        UUID_TO_BIN('89f5fd4a-bf98-11ee-bdb8-106530543950'),
        'linhltvhe170999@fpt.edu.vn',
        'he170999',
        'linhltvhe170999',
        'le',
        'thi',
        'linh',
        'https://images.pexels.com/photos/4559927/pexels-photo-4559927.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load',
        '0124567926',
        'Binh Dinh',
        '2006-05-30',
        '031203002112',
        true,
        CURRENT_TIMESTAMP,
        CURRENT_TIMESTAMP,
        true,
        UUID_TO_BIN('72e18d9c-bf96-11ee-bdb8-106530543950'),
        '1'
    ),
    (
        UUID_TO_BIN('8e8c80de-bf98-11ee-bdb8-106530543950'),
        'tuanmtvhe170777@fpt.edu.vn',
        'he170777',
        'tuanmtvhe170777',
        'nguyen',
        'minh',
        'tuan',
        'https://images.pexels.com/photos/7008322/pexels-photo-7008322.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load',
        '0124567927',
        'Phu Yen',
        '2006-06-25',
        '031203003441',
        true,
        CURRENT_TIMESTAMP,
        CURRENT_TIMESTAMP,
        true,
        UUID_TO_BIN('72e18d9c-bf96-11ee-bdb8-106530543950'),
        '2'
    ),
    (
        UUID_TO_BIN('99baa14c-bf98-11ee-bdb8-106530543950'),
        'haivtvhe170014@fpt.edu.vn',
        'he170014',
        'haivtvhe170014',
        'vu',
        'thanh',
        'hai',
        'https://images.pexels.com/photos/6548276/pexels-photo-6548276.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load',
        '0124567928',
        'Dien Bien',
        '2006-07-30',
        '031203004233',
        true,
        CURRENT_TIMESTAMP,
        CURRENT_TIMESTAMP,
        true,
        UUID_TO_BIN('72e18d9c-bf96-11ee-bdb8-106530543950'),
        '3'
    ),
    (
        UUID_TO_BIN('a38dcfa4-bf98-11ee-bdb8-106530543950'),
        'hoanglvthe170654@fpt.edu.vn',
        'he170654',
        'hoanglvthe170654',
        'le',
        'van',
        'hoang',
        'https://images.pexels.com/photos/6608213/pexels-photo-6608213.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load',
        '0124567929',
        'Quang Tri',
        '2006-08-25',
        '031203002332',
        true,
        CURRENT_TIMESTAMP,
        CURRENT_TIMESTAMP,
        true,
        UUID_TO_BIN('72e18d9c-bf96-11ee-bdb8-106530543950'),
        '4'
    ),
    (
        UUID_TO_BIN('aa20d99e-bf98-11ee-bdb8-106530543950'),
        'hieuptvhe170778@fpt.edu.vn',
        'he170778',
        'hieuptvhe170778',
        'pham',
        'thanh',
        'hieu',
        'https://images.pexels.com/photos/5011965/pexels-photo-5011965.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load',
        '0124567930',
        'Hai Duong',
        '2006-09-30',
        '031203001223',
        true,
        CURRENT_TIMESTAMP,
        CURRENT_TIMESTAMP,
        true,
        UUID_TO_BIN('4bb418a0-bf96-11ee-bdb8-106530543950'),
        '1'
    ),
    (
        UUID_TO_BIN('b3b537b0-bf98-11ee-bdb8-106530543950'),
        'phuongltvhe170111@fpt.edu.vn',
        'he170111',
        'phuongltvhe170111',
        'le',
        'thi',
        'phuong',
        'https://images.pexels.com/photos/6632133/pexels-photo-6632133.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load',
        '0124567931',
        'Ha Noi',
        '2006-10-30',
        '031203002222',
        true,
        CURRENT_TIMESTAMP,
        CURRENT_TIMESTAMP,
        true,
        UUID_TO_BIN('4bb418a0-bf96-11ee-bdb8-106530543950'),
        '2'
    ),
    (
        UUID_TO_BIN('b9c37d14-bf98-11ee-bdb8-106530543950'),
        'trangntvhe170444@fpt.edu.vn',
        'he170444',
        'trangntvhe170444',
        'nguyen',
        'thi',
        'trang',
        'https://images.pexels.com/photos/5931242/pexels-photo-5931242.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load',
        '0124567932',
        'Quang Ngai',
        '2006-11-30',
        '031203003334',
        true,
        CURRENT_TIMESTAMP,
        CURRENT_TIMESTAMP,
        true,
        UUID_TO_BIN('4bb418a0-bf96-11ee-bdb8-106530543950'),
        '3'
    ),
    (
        UUID_TO_BIN('bf0fc6c8-bf98-11ee-bdb8-106530543950'),
        'thaontvhe170453@fpt.edu.vn',
        'he170453',
        'thaontvhe170453',
        'nguyen',
        'thi',
        'thao',
        'https://images.pexels.com/photos/5691046/pexels-photo-5691046.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load',
        '0124567933',
        'Dong Nai',
        '2006-12-30',
        '031203004234',
        true,
        CURRENT_TIMESTAMP,
        CURRENT_TIMESTAMP,
        true,
        UUID_TO_BIN('4bb418a0-bf96-11ee-bdb8-106530543950'),
        '4'
    ),
    (
        UUID_TO_BIN('c52f2506-bf98-11ee-bdb8-106530543950'),
        'tuanptvhe170789@fpt.edu.vn',
        'he170789',
        'tuanptvhe170789',
        'pham',
        'thanh',
        'tuan',
        'https://images.pexels.com/photos/4067557/pexels-photo-4067557.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load',
        '0124567934',
        'Hai Phong',
        '2007-01-30',
        '031203001334',
        true,
        CURRENT_TIMESTAMP,
        CURRENT_TIMESTAMP,
        true,
        UUID_TO_BIN('72e18d9c-bf96-11ee-bdb8-106530543950'),
        '1'
    ),
    (
        UUID_TO_BIN('cc03c898-bf98-11ee-bdb8-106530543950'),
        'tienttvhe170678@fpt.edu.vn',
        'he170678',
        'tienttvhe170678',
        'nguyen',
        'thi',
        'tien',
        'https://images.pexels.com/photos/4226803/pexels-photo-4226803.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load',
        '0124567935',
        'Dien Bien',
        '2007-02-28',
        '031203002112',
        true,
        CURRENT_TIMESTAMP,
        CURRENT_TIMESTAMP,
        true,
        UUID_TO_BIN('72e18d9c-bf96-11ee-bdb8-106530543950'),
        '2'
    ),
    (
        UUID_TO_BIN('d17d161e-bf98-11ee-bdb8-106530543950'),
        'hongltvhe170000@fpt.edu.vn',
        'he170000',
        'hongltvhe170000',
        'le',
        'thi',
        'hong',
        'https://images.pexels.com/photos/4255507/pexels-photo-4255507.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load',
        '0124567936',
        'Quang Nam',
        '2007-03-30',
        '031203003334',
        true,
        CURRENT_TIMESTAMP,
        CURRENT_TIMESTAMP,
        true,
        UUID_TO_BIN('72e18d9c-bf96-11ee-bdb8-106530543950'),
        '3'
    ),
    (
        UUID_TO_BIN('d88b5b7a-bf98-11ee-bdb8-106530543950'),
        'namltvhe170999@fpt.edu.vn',
        'he170999',
        'namltvhe170999',
        'le',
        'van',
        'nam',
        'https://images.pexels.com/photos/6408667/pexels-photo-6408667.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load',
        '0124567937',
        'Quang Ninh',
        '2007-04-30',
        '031203001223',
        true,
        CURRENT_TIMESTAMP,
        CURRENT_TIMESTAMP,
        true,
        UUID_TO_BIN('72e18d9c-bf96-11ee-bdb8-106530543950'),
        '4'
    ),
    (
        UUID_TO_BIN('e35ef11c-bf98-11ee-bdb8-106530543950'),
        'trungltvhe170789@fpt.edu.vn',
        'he170789',
        'trungltvhe170789',
        'le',
        'thanh',
        'trung',
        'https://images.pexels.com/photos/1080655/pexels-photo-1080655.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load',
        '0124567938',
        'Ha Noi',
        '2007-05-30',
        '031203002222',
        true,
        CURRENT_TIMESTAMP,
        CURRENT_TIMESTAMP,
        true,
        UUID_TO_BIN('72e18d9c-bf96-11ee-bdb8-106530543950'),
        '1'
    ),
    (
        UUID_TO_BIN('e8e609dc-bf98-11ee-bdb8-106530543950'),
        'huongltvhe170111@fpt.edu.vn',
        'he170111',
        'huongltvhe170111',
        'nguyen',
        'thi',
        'huong',
        'https://images.pexels.com/photos/6610697/pexels-photo-6610697.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load',
        '0124567939',
        'Ho Chi Minh',
        '2007-06-30',
        '031203003333',
        true,
        CURRENT_TIMESTAMP,
        CURRENT_TIMESTAMP,
        true,
        UUID_TO_BIN('72e18d9c-bf96-11ee-bdb8-106530543950'),
        '2'
    ),
    (
        UUID_TO_BIN('f292d7ec-bf98-11ee-bdb8-106530543950'),
        'quyetltvhe170001@fpt.edu.vn',
        'he170001',
        'quyetltvhe170001',
        'nguyen',
        'van',
        'quyet',
        'https://images.pexels.com/photos/5891610/pexels-photo-5891610.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load',
        '0124567940',
        'Dak Nong',
        '2007-07-30',
        '031203004445',
        true,
        CURRENT_TIMESTAMP,
        CURRENT_TIMESTAMP,
        true,
        UUID_TO_BIN('72e18d9c-bf96-11ee-bdb8-106530543950'),
        '3'
    ),
    (
        UUID_TO_BIN('f90d7b9c-bf98-11ee-bdb8-106530543950'),
        'vutvhe170654@fpt.edu.vn',
        'he170654',
        'vutvhe170654',
        'pham',
        'van',
        'vu',
        'https://images.pexels.com/photos/3772647/pexels-photo-3772647.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load',
        '0124567941',
        'Lao Cai',
        '2007-08-30',
        '031203001334',
        true,
        CURRENT_TIMESTAMP,
        CURRENT_TIMESTAMP,
        true,
        UUID_TO_BIN('72e18d9c-bf96-11ee-bdb8-106530543950'),
        '4'
    );
