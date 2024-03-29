--insert acc
INSERT INTO ACC(acc_id, acc_name, acc_password, acc_role, account_create_at) 
VALUES 
(1001, N'NDTAnh', N'123456', N'supporter', default),
(1002, N'NTHang', N'123456', N'supporter', default),
(1003, N'NTAnh', N'123456', N'supporter', default),
(1004, N'NCLong', N'123456', N'supporter', default),
(1005, N'NBThuan', N'123456', N'supporter', default),
(1006, N'TTQuyen', N'123456', N'supporter', default),
(1007, N'DTHoa', N'123456', N'supporter', default),
(1008, N'PVHung', N'123456', N'supporter', default);
INSERT INTO ACC(acc_id, acc_name, acc_password, acc_role, account_create_at) 
VALUES 
(1101, N'GSChinh', N'123456', N'student', default),
(1102, N'NMTu', N'123456', N'student', default),
(1103, N'NVTrung', N'123456', N'student', default),
(1104, N'NHHoang', N'123456', N'student', default),
(1105, N'PMKhuong', N'123456', N'student', default),
(1106, N'DVVuong', N'123456', N'student', default),
(1107, N'TTQuan', N'123456', N'student', default),
(1108, N'NPXuan', N'123456', N'student', default),
(1109, N'TNTGiang', N'123456', N'student', default),
(1110, N'LDCuong', N'123456', N'student', default),
(1111, N'NDPhong', N'123456', N'student', default),
(1112, N'PDAnh', N'123456', N'student', default),
(1113, N'TDQuan', N'123456', N'student', default),
(1114, N'LNHSon', N'123456', N'student', default),
(1115, N'LDTuong', N'123456', N'student', default),
(1116, N'PDThinh', N'123456', N'student', default),
(1117, N'DXHoang', N'123456', N'student', default),
(1118, N'TMDuc', N'123456', N'student', default),
(1119, N'NMDao', N'123456', N'student', default),
(1120, N'BAQuan', N'123456', N'student', default),
(1121, N'NMQuan', N'123456', N'student', default),
(1122, N'VXHai', N'123456', N'student', default),
(1123, N'LBCho', N'123456', N'student', default),
(1124, N'NTLinh', N'123456', N'student', default),
(1125, N'NMDung', N'123456', N'student', default),
(1126, N'NMHieu', N'123456', N'student', default),
(1127, N'PTTu', N'123456', N'student', default),
(1128, N'TCLoi', N'123456', N'student', default),
(1129, N'NDTrung', N'123456', N'student', default),
(1130, N'NKMinh', N'123456', N'student', default),
(1131, N'NTHieu', N'123456', N'student', default),
(1132, N'VVThanh', N'123456', N'student', default),
(1133, N'TNSang', N'123456', N'student', default),
(1134, N'NTVinh', N'123456', N'student', default),
(1135, N'DDAnh', N'123456', N'student', default),
(1136, N'NVHa', N'123456', N'student', default),
(1137, N'DTThang', N'123456', N'student', default),
(1138, N'PMHung', N'123456', N'student', default),
(1139, N'LVCuong', N'123456', N'student', default),
(1140, N'NVCao', N'123456', N'student', default),
(1141, N'PHDat', N'123456', N'student', default),
(1142, N'NQPhong', N'123456', N'student', default),
(1143, N'HTDung', N'123456', N'student', default),
(1144, N'GLHoang', N'123456', N'student', default),
(1145, N'VHHoang', N'123456', N'student', default),
(1146, N'LNVinh', N'123456', N'student', default),
(1147, N'BDQuan', N'123456', N'student', default);
--insert personalInformation
INSERT INTO PERSONAL_INFOR(person_id, person_name, person_gen, person_handle, person_student_code, person_phone, person_group, person_score, person_avaiable_score, note, acc_id, team_id) 
VALUES 
(1001, N'Nguyễn Duy Tuấn Anh', N'K17', null, null, null, 1, null, null, null, 1001, 0),
(1002, N'Nguyễn Thị Hằng', N'K17', null, null, null, 1, null, null, null, 1002, 0),
(1003, N'Nguyễn Thế Anh', N'K17', null, null, null, 2, null, null, null, 1003, 0),
(1004, N'Nuyễn Công Long', N'K17', null, null, null, 2, null, null, null, 1004, 0),
(1005, N'Nguyễn Bá Thuận', N'K17', null, null, null, 3, null, null, null, 1005, 0),
(1006, N'Trần Thái Quyền', N'K17', null, null, null, 3, null, null, null, 1006, 0),
(1007, N'Đỗ Trung Hòa', N'K17', null, null, null, 4, null, null, null, 1007, 0),
(1008, N'Phạm Văn Hùng', N'K17', null, null, null, 4, null, null, null, 1008, 0);
INSERT INTO PERSONAL_INFOR(person_id, person_name, person_gen, person_handle, person_student_code, person_phone, person_group, person_score, person_avaiable_score, note, acc_id, team_id) 
VALUES 
(1101, N'Giang Seo Chính', N'K18', N'Main_ca', N'2023602847', 0915396167, 1, 11, 11, null, 1101, 0),
(1102, N'Nguyễn Minh Tú', N'K18', N'Tuminh14', N'2023607720', 0357062854, 1, 0, 0, null, 1102, 0),
(1103, N'Nguyễn Văn Trung', N'K18', N'vantrung', N'2023602201', 0965389608, 1, 6, 6, null, 1103, 0),
(1104, N'Nguyễn Huy Hoàng', N'K18', N'hahoang-khmt2', N'2023604008', 0982305205, 1, 0, 0, null, 1104, 0),
(1105, N'Phạm Minh Khương', N'K18', N'khuong18', N'2023600861', 0901243098, 1, 1, 1, null, 1105, 0),
(1106, N'Đinh Văn Vượng', N'K18', N'tdsang1999', null, null, 1, 0, 0, null, 1106, 0),
(1107, N'Trịnh Thanh Quân', N'K18', N'QuanHaui', N'2023600558', null, 1, 0, 0, null, 1107, 0),
(1108, N'Nguyễn Phúc Xuân', N'K18', N'Ng_Phuc_Xuan', N'2023603756', 0946456278, 1, 0, 0, null, 1108, 0),
(1109, N'Trần Nguyễn Trà Giang', N'K18', N'giang121555', N'2023600740', 0966285326, 1, 0, 0, null, 1109, 0),
(1110, N'Lâm Đức Cương', N'K18', N'duccuongnhaoson1', N'2023601728', 0342322899, 1, 0, 0, null, 1110, 0),
(1111, N'Nguyễn Đăng Phong', N'K18', N'phongcntt', N'2023600803', 0399832506, 1, 3, 3, null, 1111, 0),
(1112, N'Phạm Đức Anh', N'K18', N'doremonom', N'2023607547', null, 1, 0, 0, null, 1112, 0),
(1113, N'Trần Đức Quân', N'K18', N'tdquan555', N'2023600940', 0357440172, 2, 0, 0, null, 1113, 0),
(1114, N'Lê Nguyễn Hoàng Sơn', N'K18', N'hsonn2208', N'2023602548', 0356633050, 2, 0, 0, N'cố gắng khắc phục đi đầy đủ', 1114, 0),
(1115, N'Lê Đức Tường', N'K18', N'leductuong29102005', N'2023601068', 0869048808, 2, 0, 0, null, 1115, 0),
(1116, N'Phạm Đức Thịnh', N'K18', N'PhamDucThinh', N'', 0338715287, 2, 0, 0, null, 1116, 0),
(1117, N'Đào Xuân Hoàng', N'K18', N'daohoang89', N'2023604185', 0985770904, 2, 0, 0, N'xin chuyển sang lớp C++', 1117, 0),
(1118, N'Trinh Minh Đức', N'K18', N'duc29122005', N'2023602198', 0375631301, 2, 0, 0, null, 1118, 0),
(1119, N'Nguyễn Minh Đạo', N'K18', N'daonm', N'2023601815', 0338080212, 2, 15, 15, null, 1119, 0),
(1120, N'Bùi Anh Quân', N'K18', N'quanxl2k24', N'2023603357', null, 2, 0, 0, null, 1120, 0),
(1121, N'Nguyễn Mạnh Quân', N'K18', N'nothnguyen', N'2023601866', 0867918951, 2, 0, 0, null, 1121, 0),
(1122, N'Vũ Xuân Hải', N'K18', N'Kim_ri_cha', N'2023600718', 0975350601, 2, 0, 0, null, 1122, 0),
(1123, N'Lầu Bá Chò', N'K18', N'', N'2023607217', null, 2, 0, 0, null, 1123, 0),
(1124, N'Nguyễn Trúc Linh', N'K18', N'nguyentruclinh', N'2023604989', 0396931784, 3, 0, 0, null, 1124, 0),
(1125, N'Nguyễn Mạnh Dũng', N'K18', N'dungvp', N'2023600938', 0984476105, 3, 0, 0, null, 1125, 0),
(1126, N'Nguyễn Minh Hiểu', N'K18', N'minhhieu-k18', N'', 0867534085, 3, 0, 0, null, 1126, 0),
(1127, N'Phạm Tất Tụ', N'K18', N'TatTu_Khmt02', N'', null, 3, 0, 0, null, 1127, 0),
(1128, N'Tạ Công Lợi', N'K18', N'Midari25', N'', null, 3, 0, 0, null, 1128, 0),
(1129, N'Nguyễn Đức Trung', N'K18', N'duktrung', N'2023600531', 0962139206, 3, 0, 0, null, 1129, 0),
(1130, N'Nguyễn Khánh Minh', N'K18', N'minhnhim24122k5', N'2023602111', 0946720996, 3, 0, 0, null, 1130, 0),
(1131, N'Nguyễn Tiến Hiệu', N'K18', N'uiehnguyen', N'2023600802', 0394248471, 3, 0, 0, null, 1131, 0),
(1132, N'Vũ Văn Thanh', N'K18', N'thanhABC', N'2023600730', 0868081278, 3, 0, 0, null, 1132, 0),
(1133, N'Trương Nhất Sang', N'K18', N'truongnhatsang', N'2023600923', null, 3, 0, 0, null, 1133, 0),
(1134, N'Nguyễn Thế Vinh', N'K18', N'TheVinh2205', N'2023601280', 0961114356, 3, 0, 0, null, 1134, 0),
(1135, N'Đỗ Đức Anh', N'K18', N'dda05vy', N'2023600614', 0836882268, 3, 0, 0, null, 1135, 0),
(1136, N'Nguyễn Văn Hà', N'K18', N'HaNguyenK18', N'2023606590', 0988018363, 4, 0, 0, null, 1136, 0),
(1137, N'Dương Trường Thăng', N'K18', N'Duongtruongthang', N'2023601241', null, 4, 0, 0, null, 1137, 0),
(1138, N'Phạm Mạnh Hùng', N'K18', N'hungphammanh0510', N'', 0924154875, 4, 0, 0, null, 1138, 0),
(1139, N'Lã Văn Cường', N'K18', N'Lavancuong2005hn', N'2023602191', 0375194860, 4, 0, 0, N'xin chuyển sang lớp C++', 1139, 0),
(1140, N'Nguyễn Văn Cao', N'K18', N'', N'', null, 4, 0, 0, null, 1140, 0),
(1141, N'Phan Hữu Đạt', N'K18', N'HuuDatK18', N'2023606828', 0359604288, 4, 0, 0, null, 1141, 0),
(1142, N'Nguyễn Quốc Phong', N'K18', N'', N'2023602468', 0382640757, 4, 0, 0, null, 1142, 0),
(1143, N'Hoàng Trung Dũng', N'K18', N'HoangDung05', N'2023605085', 0982717905, 4, 0, 0, N'xin chuyển sang lớp C++', 1143, 0),
(1144, N'Giang Lê Hoàng', N'K18', N'gianglehoang', N'2023601729', 0865328483, 4, 0, 0, N'xin chuyển sang lớp C++', 1144, 0),
(1145, N'Vũ Huy Hoàng', N'K18', N'hoanghoang203205', N'2023603577', 0389583764, 4, 0, 0, N'xin chuyển sang lớp C++', 1145, 0),
(1146, N'Lương Ngọc Vinh', N'K18', N'ngocvinh199', N'2023602389', null, 4, 0, 0, null, 1146, 0),
(1147, N'Bùi Đức Quân', N'K18', N'QuanKane', N'2023604015', null, 4, 0, 0, null, 1147, 0);
--insert team
INSERT INTO TEAM(team_id, team_name, team_create_at) VALUES (0, N'No team', null, default);
--insert class
INSERT INTO CLASS(class_id, class_name, class_content, class_day, class_place) 
VALUES 
(2001, N'Tuần 1', N'Nhập/xuất dữ liệu, kiểu dữ kiệu, câu lệnh điều kiện if else, vòng lặp for, while.', '2023-11-30 09:35:00', N'201-C1'),
(2002, N'Tuần 2', N'Giới thiệu mảng và xâu kí tự.', '2023-12-07 09:35:00', N'101-C1'),
(2003, N'Tuần 3', N'HÀM, ĐỆ QUY, ĐỘ PHỨC TẠP', '2023-12-14 09:35:00', N'102-C1'),
(2004, N'Tuần 4', N'ÔN TẬP', '2023-12-28 09:35:00', N'101-C2'),
(2005, N'Tuần 5', N'QUAY LUI, VÉT CẠN', '2024-01-04 09:35:00', N'102-C2'),
(2006, N'Tuần 6', N'THAM LAM, DÃY HARMONIC', '2024-01-11 09:35:00', N'102-C1'),
(2007, N'Tuần 7', N'CHIA ĐỂ TRỊ + TÌM KIẾM NHỊ PHÂN', '2024-01-18 09:35:00', N'101-C2'),
(2008, N'Tuần 8', N'MẢNG CỘNG DỒN, ĐƯỜNG QUÉT', '2024-01-25 09:35:00', N'202-C1');
--insert attend class
INSERT INTO ATTEND_CLASS(person_id, class_id) 
VALUES 
(1001, 2008),
(1003, 2008),
(1101, 2008),
(1102, 2008),
(1103, 2008),
(1104, 2008),
(1105, 2008),
(1106, 2008),
(1107, 2008),
(1108, 2008),
(1109, 2008),
(1110, 2008),
(1111, 2008),
(1112, 2008),
(1113, 2008),
(1114, 2008),
(1115, 2008),
(1116, 2008),
(1117, 2008),
(1118, 2008),
(1119, 2008),
(1120, 2008),
(1121, 2008),
(1122, 2008),
(1123, 2008),
(1124, 2008),
(1125, 2008),
(1126, 2008),
(1127, 2008),
(1128, 2008),
(1129, 2008),
(1130, 2008),
(1131, 2008),
(1132, 2008),
(1133, 2008),
(1134, 2008),
(1135, 2008),
(1136, 2008),
(1137, 2008),
(1138, 2008),
(1139, 2008),
(1140, 2008),
(1141, 2008),
(1142, 2008),
(1143, 2008),
(1144, 2008),
(1145, 2008),
(1146, 2008),
(1147, 2008)
;
--insert contest
INSERT INTO CONTEST(contest_id, contest_name, contest_target, contest_type, contest_day) 
VALUES 
(3001, N'Contest OI tháng 1', N'Contest định kì', N'OI', '2024-01-02 21:00:00');
--insert person do contest
INSERT INTO PERSON_DO_CONTEST(contest_id, person_id, score) 
VALUES 
(3001, 1127, 330),
(3001, 1106, 321),
(3001, 1105, 311),
(3001, 1119, 307),
(3001, 1101, 213),
(3001, 1103, 200),
(3001, 1110, 200),
(3001, 1111, 196),
(3001, 1120, 150),
(3001, 1132, 105),
(3001, 1102, 102),
(3001, 1125, 54);
INSERT INTO TEAM_DO_CONTEST(contest_id, team_id) VALUES (?, ?);