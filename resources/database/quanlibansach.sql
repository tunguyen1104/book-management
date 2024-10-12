--CREATE DATABASE QUANLISACH
use QUANLISACH

--tao bang chi tiet hoa don xuat
CREATE TABLE TChitietHDX (
    MaSach NVARCHAR(10) NOT NULL,
    MaHDX NVARCHAR(10) NOT NULL,
    TenSach NVARCHAR(100) NULL,
    SoLuongXuat INT NULL,
    CONSTRAINT [PK_tChiTietHDB] PRIMARY KEY CLUSTERED 
(
	[MaSach] ASC,
	[MaHDX] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

--tao bang chi tiet hoa don nhap
CREATE TABLE TChitietHDN(
    MaSach NVARCHAR(10) NOT NULL,
    MaHDN NVARCHAR(10) NOT NULL,
    DauSach NVARCHAR(100) NULL,
    SoLuongNhap INT NULL,
 CONSTRAINT [PK_tChiTietHDN] PRIMARY KEY CLUSTERED 
(
	[MaSach] ASC,
	[MaHDN] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]  

--tao bang hoa don xuat
CREATE TABLE tHoaDonxuat (
    MaHDX NVARCHAR(10) NOT NULL,
	MaKhachHang NVARCHAR(10) NOT NULL,
    NgayXuat DATE NOT NULL,
    MaNhanVien NVARCHAR(10) NOT NULL,
    TongTien DECIMAL(18, 2) NOT NULL,
    TienThanhToanThuc DECIMAL(18, 2) NOT NULL,
  CONSTRAINT [PK_tHoaDonxuat] PRIMARY KEY CLUSTERED 
(
	[MaHDX] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

--tao bang hoa don nhap
CREATE TABLE tHoaDonNhap (
    MaHDN NVARCHAR(10) NOT NULL,
    NgayNhap DATE NOT NULL,
    MaNhaXuatBan NVARCHAR(10) NOT NULL,
    MaNhanVien NVARCHAR(10) NOT NULL,
   CONSTRAINT [PK_tHoaDonNhap] PRIMARY KEY CLUSTERED 
(
	[MaHDN] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]


--tao bang khach hang
CREATE TABLE tKhachHang (
    MaKhachHang NVARCHAR(10) NOT NULL,
    TenKhachHang NVARCHAR(100) NOT NULL,
    SoDienThoai NVARCHAR(20) NULL,
    Email NVARCHAR(100) NULL,
    TichDiem INT NOT NULL DEFAULT 0,
    DiaChi NVARCHAR(255) NULL,
 
 CONSTRAINT [PK_tKhachHang] PRIMARY KEY CLUSTERED 
(
	[MaKhachHang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]


--tao bang nhan vien
CREATE TABLE tNhanVien (
    MaNhanVien NVARCHAR(10) NOT NULL,    
    TenNhanVien NVARCHAR(100) NOT NULL,
    GioiTinh NVARCHAR(10) NULL,
    LuongCoSo DECIMAL(18, 2) NULL,
    MaQuanLi NVARCHAR(10) NULL,
    NgaySinh DATE NULL,
    NgayKiHopDong DATE NULL,
    SoNamHopDong INT NULL,
    SoNgayNghiPhep INT NULL,
    DiaChi NVARCHAR(255) NULL,
    HeSoLuong DECIMAL(18, 2) NULL,
	Chucvu NVARCHAR(255) NULL,
 CONSTRAINT [PK_tNhanVien] PRIMARY KEY CLUSTERED 
(
	[MaNhanVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

--tao bang nha xuat ban
CREATE TABLE tNhaXuatBan (
    MaNhaXuatBan NVARCHAR(10) NOT NULL,
    TenNhaXuatBan NVARCHAR(100) NOT NULL,
    DiaChi NVARCHAR(255) NULL,
    
 CONSTRAINT [PK_tNhaXuatBan] PRIMARY KEY CLUSTERED 
(
	[MaNhaXuatBan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]


--tao bang sach
CREATE TABLE tSach (
    MaSach NVARCHAR(10) NOT NULL,
    TenSach NVARCHAR(255) NOT NULL,
    GiaTien DECIMAL(18, 2) NULL,
    TacGia NVARCHAR(100) NULL,
    MaNhaXuatBan NVARCHAR(10) NULL,
    MaKhuVuc NVARCHAR(10) NULL,
    MaNhanVien NVARCHAR(10) NULL,   
    Discount DECIMAL(5, 2) NULL,
 
    
CONSTRAINT [PK_tSach] PRIMARY KEY CLUSTERED 
(
	[MaSach] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] 

--tao bang khu vuc
CREATE TABLE tKhuVuc (
    MaKhuVuc NVARCHAR(10) NOT NULL,
    TenKhuVuc NVARCHAR(100) NOT NULL,
    MaNhanVien NVARCHAR(10) NULL,
   CONSTRAINT [PK_tKhuVuc] PRIMARY KEY CLUSTERED 
(
	[MaKhuVuc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] 

--tao bang quan ly


--tao bang chi nhanh
CREATE TABLE tChiNhanh (
    MaChiNhanh NVARCHAR(10) NOT NULL,
    MaNhanVien NVARCHAR(10) NOT NULL,
    
  CONSTRAINT [PK_tChiNhanh] PRIMARY KEY CLUSTERED 
(
	[MaChiNhanh] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]   

--them du lieu vao cac bang:
INSERT INTO tSach (MaSach, TenSach, GiaTien, TacGia, MaNhaXuatBan, MaKhuVuc, MaNhanVien, Discount)
VALUES 
('MS01', N'Cây Cam Ngọt Của Tôi', 200000, N'Vasconcelos', N'NXB01', N'KV01', N'NV01', 0.05),
('MS02', N'Harry Potter Và Hoàng Tử Lai', 100000, N'J.K.Rowling', N'NXB02', N'KV01', N'NV01', 0.06),
('MS03', N'Bí Kíp Luyện Rồng', 50000, N'Cressida Cowell', N'NXB01', N'KV01', N'NV01', 0.03),
('MS04', N'Suối Nguồn', 70000, N'Ayn Rand', N'NXB02', N'KV01', N'NV02', 0.04),
('MS05', N'Phía Nam Biên Giới, Phía Tây Mặt Trời', 65000, N'Haruki Murakami', N'NXB03', N'KV01', N'NV03', 0.08),
('MS06', N'Nhà Giả Kim', 20000, N'Paulo Coelho', N'NXB03', N'KV01', N'NV03', 0.04),
('MS07', N'Bố Già', 60000, N'Mario Puzo', N'NXB04', N'KV01', N'NV04', 0.02),
('MS08', N'Bắt Trẻ Đồng Xanh', 40000, N'J.D.Salinger', N'NXB04', N'KV01', N'NV04', 0.04),
('MS09', N'Nanh Trắng', 30000, N'Jack London', N'NXB03', N'KV01', N'NV02', 0.09),
('MS10', N'Mùa Hè Bất Tận', 60000, N'Lâm Hoàng Trúc', N'NXB05', N'KV02', N'NV05', 0.04),
('MS11', N'Bất Tử Và Bất Hạnh', 32000, N'Totsuka Yoshifumi', N'NXB05', N'KV02', N'NV06', 0.07),
('MS12', N'Naruto Shippuden', 60000, N'Masashi Kishimoto', N'NXB05', N'KV02', N'NV07', 0.04),
('MS13', N'One piece', 40000, N'Eichiro Oda', N'NXB02', N'KV02', N'NV08', 0.02),
('MS14', N'Bleach-Huyết Chiến Ngàn Năm', 12000, N'Kubo Tite', N'NXB01', N'KV02', N'NV02', 0.04),
('MS15', N'Bảy Viên Ngọc Rồng', 34000, N'Akira Toriyama', N'NXB01', N'KV02', N'NV08', 0.08),
('MS16', N'Thám Tử Lừng Danh Conan', 36000, N'Gosho Aoyama', N'NXB05', N'KV02', N'NV09', 0.03),
('MS17', N'Gintama - Linh Hồn Bạc', 80000, N'Hideaki Sorachi', N'NXB02', N'KV02', N'NV10', 0.04),
('MS18', N'Thế Giới Phẳng', 37000, N'Thomas L. Friedman', N'NXB05', N'KV03', N'NV10', 0.02),
('MS19', N'Vũ Trụ Trong Vỏ Hạt Dẻ', 60000, N'Stephen Hawking', N'NXB01', N'KV03', N'NV02', 0.04),
('MS20', N'Về Nguồn Gốc Các Loài', 160000, N'Charles Darwin', N'NXB04', N'KV03', N'NV03', 0.03),
('MS21', N'Những Nhà Khám Phá', 38000, N'Daniel J. Boorstin', N'NXB02', N'KV03', N'NV11', 0.052),
('MS22', N'Đắc Nhân Tâm', 31000, N'Dale Carnegie', N'NXB03', N'KV03', N'NV12', 0.04),
('MS23', N'Súng, Vi Trùng và Thép', 27000, N'Jared Diamond', N'NXB04', N'KV03', N'NV12', 0.04),
('MS24', N'Lược Sử Thời Gian', 56000, N'Stephen Hawking', N'NXB05', N'KV03', N'NV13', 0.09),
('MS25', N'Hành Trình Về Phương Đông', 39000, N'Baird T. Spalding', N'NXB05', N'KV03', N'NV14', 0.043),
('MS26', N'Những Tù Nhân Địa Lý', 31000, N'Tim Marshall', N'NXB05', N'KV03', N'NV15', 0.04);
INSERT INTO tSach (MaSach, TenSach, GiaTien, TacGia, MaNhaXuatBan, MaKhuVuc, MaNhanVien, Discount)
VALUES 
('MS27', N'Tiểu Thuyết Ánh Trăng', 85000, N'Nguyễn Nhật Ánh', 'NXB06', 'KV03', 'NV16', 0.07),
('MS28', N'Cô Gái Đến Từ Hôm Qua', 78000, N'Trung Lê Nguyễn', 'NXB07', 'KV02', 'NV17', 0.05),
('MS29', N'Đại Đồng Giáng Trần', 95000, N'Vũ Trọng Phụng', 'NXB08', 'KV01', 'NV18', 0.06);
INSERT INTO tSach (MaSach, TenSach, GiaTien, TacGia, MaNhaXuatBan, MaKhuVuc, MaNhanVien, Discount)
VALUES 
('MS30', N'Những Bức Thư Bí Ẩn', 72000, N'Agatha Christie', 'NXB09', 'KV02', 'NV19', 0.08);

--them du lieu vao nhan vien
INSERT INTO tNhanVien (MaNhanVien, TenNhanVien, GioiTinh, LuongCoSo, MaQuanLi, NgaySinh, NgayKiHopDong, SoNamHopDong, SoNgayNghiPhep, DiaChi, HeSoLuong, Chucvu)
VALUES 
('NV01', N'Nguyễn Văn Anh', N'Nam', 15000000, NULL, '2002-01-01', '2022-01-01', 2, 5, N'Hà Nội', 1.5, N'Nhân viên'),
('NV02', N'Trần Thị Bắc', N'Nữ', 12000000, 'QL01', '2002-01-01', '2021-03-15', 3, 7, N'Hồ Chí Minh', 1.4, N'Nhân viên'),
('NV03', N'Lê Văn Sơn', N'Nam', 18000000, NULL, '2002-01-01', '2020-05-10', 5, 10, N'Đà Nẵng', 1.6, N'Quản lí'),
('NV04', N'Phạm Thị Dung', N'Nữ', 13000000, 'QL02', '2002-01-01', '2019-07-20', 4, 6, N'Cần Thơ', 1.45, N'Nhân viên'),
('NV05', N'Hồ Văn Nam', N'Nam', 16000000, NULL, '2002-01-01', '2023-02-28', 1, 4, N'Vũng Tàu', 1.55, N'Nhân viên'),
('NV06', N'Vũ Thị Ngọc', N'Nữ', 11000000, 'QL03', '2002-01-01', '2023-01-15', 2, 5, N'Hải Phòng', 1.35, N'Nhân viên'),
('NV07', N'Trần Văn Giang', N'Nam', 17000000, NULL, '2002-01-01', '2018-09-10', 6, 8, N'Đà Lạt', 1.65, N'Quản lí'),
('NV08', N'Lý Thị Mai', N'Nữ', 14000000, 'QL04', '2002-01-01', '2017-06-20', 7, 9, N'Nha Trang', 1.5, N'Nhân viên'),
('NV09', N'Nguyễn Văn Hiếu', N'Nam', 19000000, NULL, '2002-01-01', '2019-08-15', 4, 5, N'Quảng Ninh', 1.7, N'Nhân viên'),
('NV10', N'Huỳnh Thị Trang', N'Nữ', 10000000, 'QL05', '2002-01-01', '2024-03-01', 1, 3, N'Bình Dương', 1.3, N'Nhân viên'),
('NV11', N'Đặng Thị Dương', N'Nữ', 11000000, 'QL06', '2002-01-01', '2023-04-10', 2, 4, N'Hải Dương', 1.35, N'Nhân viên'),
('NV12', N'Vương Văn Thưởng', N'Nam', 16500000, NULL, '2002-01-01', '2022-08-20', 3, 6, N'Đà Nẵng', 1.55, N'Nhân viên'),
('NV13', N'Hoàng Thị Chinh', N'Nữ', 12000000, 'QL07', '2002-01-01', '2021-10-05', 4, 7, N'Hà Nội', 1.4, N'Nhân viên'),
('NV14', N'Lê Văn Bình', N'Nam', 17500000, NULL, '2002-01-01', '2020-12-15', 5, 9, N'Cần Thơ', 1.6, N'Quản lí'),
('NV15', N'Nguyễn Thị Phượng', N'Nữ', 13000000, 'QL08', '2002-01-01', '2022-05-25', 2, 4, N'Vũng Tàu', 1.45, N'Nhân viên');
INSERT INTO tNhanVien (MaNhanVien, TenNhanVien, GioiTinh, LuongCoSo, MaQuanLi, NgaySinh, NgayKiHopDong, SoNamHopDong, SoNgayNghiPhep, DiaChi, HeSoLuong, Chucvu)
VALUES 
('NV16', N'Phạm Đình Chí Kiên', N'Nam', 15000000, 'QL09', '2002-01-01', '2021-03-15', 3, 5, N'Hà Nội', 1.2, N'Nhân viên'),
('NV17', N'Phạm Quốc Nhật Anh', N'Nam', 13000000, 'NULL', '2002-01-01', '2020-05-20', 4, 4, N'Hồ Chí Minh', 1.1, N'Nhân viên'),
('NV18', N'Nguyễn Quang Mạnh', N'Nam', 12000000, 'QL10', '2002-01-01', '2022-01-10', 2, 6, N'Đà Nẵng', 1.0, N'Nhân viên'),
('NV19', N'Nguyễn Thành Nam', N'Nam', 11000000, 'NULL', '2002-01-01', '2019-11-25', 5, 3, N'Cần Thơ', 1.2, N'Quản lý'),
('NV20', N'Lê Trần Trung Đức', N'Nam', 14000000, 'NULL', '2002-01-01', '2020-08-05', 3, 4, N'Bình Dương', 1.1, N'Nhân viên'),
('NV21', N'Nguyễn Thảo Linh', N'Nữ', 12000000, 'NULL', '2002-01-01', '2021-10-12', 2, 5, N'Đồng Nai', 1.0, N'Nhân viên'),
('NV22', N'Đỗ Uyên Vy', N'Nữ', 16000000, 'NULL', '2002-01-01', '2022-02-28', 1, 7, N'Hải Phòng', 1.2, N'Nhân viên'),
('NV23', N'Nguyễn Quỳnh Diệp', N'Nữ', 11000000, 'QL11', '2002-01-01', '2019-07-15', 4, 4, N'Nghệ An', 1.1, N'Quản lý'),
('NV24', N'Nguyễn Thảo Linh', N'Nữ', 13000000, 'NULL', '2002-01-01', '2020-04-10', 3, 5, N'Hà Tĩnh', 1.0, N'Nhân viên'),
('NV25', N'Phạm Ngọc Lan Anh', N'Nữ', 15000000, 'NULL', '2002-01-01', '2021-09-20', 2, 6, N'Hà Giang', 1.2, N'Nhân viên'),
('NV26', N'Trần Thị Thùy Dương', N'Nữ', 14000000, 'NULL', '2002-01-01', '2022-05-15', 1, 7, N'Đắk Lắk', 1.1, N'Nhân viên'),
('NV27', N'Lê Mỹ Huyền', N'Nữ', 12000000, 'NULL', '2002-01-01', '2019-12-10', 4, 4, N'Quảng Ninh', 1.0, N'Quản lý'),
('NV28', N'Bùi Diệp Chi', N'Nữ', 11000000, 'QL12', '2002-01-01', '2020-03-05', 3, 5, N'Thái Nguyên', 1.2, N'Nhân viên'),
('NV29', N'Đặng Quỳnh Anh', N'Nữ', 13000000, 'QL13', '2002-01-01', '2021-08-10', 2, 6, N'Bắc Ninh', 1.1, N'Nhân viên'),
('NV30', N'Đỗ Văn Tráng', N'Nam', 15000000, 'QL14', '2002-01-01', '2022-04-15', 1, 7, N'Lạng Sơn', 1.0, N'Nhân viên');

--them du lieu khach hang
INSERT INTO tKhachHang (MaKhachHang, TenKhachHang, SoDienThoai, Email, TichDiem, DiaChi)
VALUES 
('KH01', N'Nguyễn Văn Hùng', '0987654321', 'nguyenvana@email.com', 100, N'Hà Nội'),
('KH02', N'Trần Thị Thúy', '0981234567', 'tranthib@email.com', 200, N'Hồ Chí Minh'),
('KH03', N'Lê Văn Cường', '0976543210', 'levanc@email.com', 50, N'Đà Nẵng'),
('KH04', N'Phạm Thị Dung', '0965432109', 'phamthid@email.com', 300, N'Cần Thơ'),
('KH05', N'Hồ Văn Nam', '0954321098', 'hovane@email.com', 150, N'Vũng Tàu'),
('KH06', N'Vũ Thị Kiều', '0943210987', 'vuthif@email.com', 250, N'Hải Phòng'),
('KH07', N'Trần Văn Hiếu', '0932109876', 'tranvang@email.com', 80, N'Đà Lạt'),
('KH08', N'Lý Thị Hoa', '0921098765', 'lythih@email.com', 350, N'Nha Trang'),
('KH09', N'Nguyễn Văn Sơn', '0910987654', 'nguyenvani@email.com', 120, N'Quảng Ninh'),
('KH10', N'Huỳnh Thị Trang', '0909876543', 'huynhthik@email.com', 400, N'Bình Dương'),
('KH11', N'Đặng Thị Lan', '0981122334', 'dangthil@email.com', 60, N'Hải Dương'),
('KH12', N'Vương Văn May', '0971122334', 'vuongvanm@email.com', 70, N'Đà Nẵng'),
('KH13', N'Hoàng Thị Nương', '0961122334', 'hoangthin@email.com', 110, N'Hà Nội'),
('KH14', N'Lê Văn Tú', '0951122334', 'levano@email.com', 90, N'Cần Thơ'),
('KH15', N'Nguyễn Thị Phương', '0941122334', 'nguyenthip@email.com', 130, N'Vũng Tàu'),
('KH16', N'Nguyễn Văn Quỳnh', '0931122334', 'nguyenvanq@email.com', 140, N'Hải Phòng'),
('KH17', N'Trần Thị Thảo', '0921122334', 'tranthir@email.com', 160, N'Đà Lạt'),
('KH18', N'Phạm Văn Đồng', '0911122334', 'phamvans@email.com', 180, N'Nha Trang'),
('KH19', N'Hồ Thị Tuyết', '0901122334', 'hothit@email.com', 200, N'Quảng Ninh'),
('KH20', N'Huỳnh Văn Lập', '0989988776', 'huynhvanu@email.com', 220, N'Bình Dương');


--them du lieu khu vực:
INSERT INTO tKhuVuc (MaKhuVuc, TenKhuVuc, MaNhanVien)
VALUES 
('KV01', N'Tiểu thuyết', 'NV01'),
('KV02', N'Truyện tranh ', 'NV02'),
('KV03', N'Khoa Học ', 'NV03');

--them du lieu chi nhanh
INSERT INTO tChiNhanh (MaChiNhanh, MaNhanVien)
VALUES 
('CN01', 'NV01'),
('CN02', 'NV02'),
('CN03', 'NV03');



--them du lieu nha xuat ban:
INSERT INTO tNhaXuatBan (MaNhaXuatBan, TenNhaXuatBan, DiaChi)
VALUES 
('NXB01', N'Nhà Xuất Bản Giáo dục', N'Địa chỉ Hà Nội'),
('NXB02', N'Nhà Xuất Bản Kim đồng', N'Địa chỉ Hà Nội'),
('NXB03', N'Nhà Xuất Bản Trẻ', N'Địa chỉ Hồ Chính Minh'),
('NXB04', N'Nhà Xuất Bản Văn học', N'Địa chỉ Đà Nẵng'),
('NXB05', N'Nhà Xuất Bản Hồng Đức', N'Địa chỉ Hà Nội');

--them hoadonnhap:
INSERT INTO tHoaDonNhap (MaHDN, NgayNhap, MaNhaXuatBan, MaNhanVien)
VALUES 
('HDN01', '2021-04-01', 'NXB01', 'NV01'),
('HDN02', '2022-04-02', 'NXB02', 'NV02'),
('HDN03', '2022-05-03', 'NXB03', 'NV03'),
('HDN04', '2022-06-04', 'NXB04', 'NV04'),
('HDN05', '2022-07-05', 'NXB05', 'NV05'),
('HDN06', '2022-04-06', 'NXB01', 'NV06'),
('HDN07', '2023-01-07', 'NXB02', 'NV07'),
('HDN08', '2023-02-08', 'NXB03', 'NV08'),
('HDN09', '2023-03-09', 'NXB04', 'NV09'),
('HDN10', '2023-04-10', 'NXB05', 'NV10');
INSERT INTO tHoaDonNhap (MaHDN, NgayNhap, MaNhaXuatBan, MaNhanVien)
VALUES 
('HDN11', '2023-05-11', 'NXB05', 'NV11'),
('HDN12', '2023-06-12', 'NXB03', 'NV12'),
('HDN13', '2023-04-13', 'NXB02', 'NV13'),
('HDN14', '2023-02-14', 'NXB01', 'NV14'),
('HDN15', '2023-07-15', 'NXB05', 'NV15'),
('HDN16', '2021-04-16', 'NXB04', 'NV16'),
('HDN17', '2023-04-17', 'NXB02','NV17'),
('HDN18', '2023-04-18', 'NXB04', 'NV18'),
('HDN19', '2023-04-19', 'NXB04', 'NV19'),
('HDN20', '2023-04-20', 'NXB04', 'NV20'),
('HDN21', '2023-05-21', 'NXB01', 'NV21'),
('HDN22', '2023-06-22', 'NXB02', 'NV22'),
('HDN23', '2023-07-23', 'NXB03', 'NV23'),
('HDN24', '2023-08-24', 'NXB04', 'NV24'),
('HDN25', '2023-09-25', 'NXB05', 'NV25'),
('HDN26', '2023-10-26', 'NXB04', 'NV26'),
('HDN27', '2023-11-27', 'NXB04', 'NV27'),
('HDN28', '2023-12-28', 'NXB04', 'NV28'),
('HDN29', '2024-01-29', 'NXB04', 'NV29'),
('HDN30', '2024-04-21', 'NXB04', 'NV30');

--them hoa don xuat
INSERT INTO tHoaDonxuat (MaHDX, MaKhachHang, NgayXuat, MaNhanVien, TongTien, TienThanhToanThuc)
VALUES 
  (N'HDX01', N'KH01', N'2022-04-01' , N'NV01', 700000 , 662000),
  (N'HDX02', N'KH02', N'2022-04-02' , N'NV02', 380000 , 365800 ),
  (N'HDX03', N'KH03', N'2022-04-03' , N'NV03', 125000 , 117400 ),
  (N'HDX04', N'KH04', N'2022-04-04' , N'NV04', 260000 , 253200 ),
  (N'HDX05', N'KH05', N'2022-04-05' , N'NV05', 300000 , 282000 ),
  (N'HDX06', N'KH06', N'2022-04-06' , N'NV06', 280000 , 264000 ),
  (N'HDX07', N'KH07', N'2022-04-07' , N'NV07', 288000 , 281280 ),
  (N'HDX08', N'KH08', N'2022-04-08' , N'NV08', 214000 , 205880 ),
  (N'HDX09', N'KH09', N'2022-04-09' , N'NV09', 388000 , 375440 ),
  (N'HDX10', N'KH10', N'2022-05-10' , N'NV10', 600000 , 580800 ),
  (N'HDX11', N'KH11', N'2022-06-11' , N'NV11', 400000 , 380000 ),
  (N'HDX12', N'KH12', N'2022-07-12' , N'NV12', 300000 , 282000 ),
  (N'HDX13', N'KH13', N'2022-08-13' , N'NV13', 100000 , 97000 ),
  (N'HDX14', N'KH14', N'2022-09-14' , N'NV14', 280000 , 268800 ),
  (N'HDX15', N'KH15', N'2022-10-15' , N'NV15', 65000 , 59800 ),
  (N'HDX16', N'KH16', N'2022-11-16' , N'NV16', 60000 , 57600 ),
  (N'HDX17', N'KH17', N'2022-12-17' , N'NV17', 540000 , 529200 ),
  (N'HDX18', N'KH18', N'2023-01-18' , N'NV18', 320000 , 307200 ),
  (N'HDX19', N'KH19', N'2023-02-19' , N'NV19', 30000 , 27300 ),
  (N'HDX20', N'KH20', N'2023-01-20' , N'NV20', 120000 , 115200 ),
  (N'HDX21', N'KH21', N'2023-03-21' , N'NV21', 224000 , 208320 ),
  (N'HDX22', N'KH22', N'2023-04-22' , N'NV22', 120000 , 115200 ),
  (N'HDX23', N'KH23', N'2023-05-23' , N'NV23', 80000 , 78400 ),
  (N'HDX24', N'KH24', N'2023-06-24' , N'NV24', 40000 , 38400 ),
  (N'HDX25', N'KH25', N'2023-07-25' , N'NV25', 30000 , 27300 ),
  (N'HDX26', N'KH26', N'2023-09-26' , N'NV26', 60000 , 57600 ),
  (N'HDX27', N'KH27', N'2023-10-27' , N'NV27', 32000 , 29760 ),
  (N'HDX28', N'KH28', N'2023-11-28' , N'NV28', 120000 , 115200 ),
  (N'HDX29', N'KH29', N'2023-12-29' , N'NV29', 200000 , 196000 ),
  (N'HDX30', N'KH30', N'2024-01-21' , N'NV30', 40000 , 39200 );

--them vao chitietHDN:
INSERT INTO TChitietHDN (MaSach, MaHDN, DauSach,SoLuongNhap)
VALUES 
('MS01', 'HDN01', N'Cây Cam Ngọt Của Tôi', 13),
('MS02', 'HDN01', N'Harry Potter Và Hoàng Tử Lai', 15),
('MS03', 'HDN02', N'Bí Kíp Luyện Rồng', 6),
('MS04', 'HDN02', N'Suối Nguồn', 6),
('MS05', 'HDN03', N'Phía Nam Biên Giới,Phía Tây Mặt Trời', 1),
('MS06', 'HDN03', N'Nhà Giả Kim', 6),
('MS07', 'HDN04', N'Bố Già', 1),
('MS08', 'HDN04', N'Bắt Trẻ Đồng Xanh', 2),
('MS09', 'HDN05', N'Nanh Trắng', 4),
('MS10', 'HDN05', N'Mùa Hè Bất Tận', 3),
('MS11', 'HDN06', N'Bất Tử Và Bất Hạnh', 5),
('MS12', 'HDN06', N'Naruto Shippuden', 2),
('MS13', 'HDN07', N'One piece', 6),
('MS14', 'HDN07', N'Bleach-Huyết Chiến Ngàn Năm', 4),
('MS15', 'HDN08', N'Bảy Viên Ngọc Rồng', 1),
('MS16', 'HDN08', N'Thám Tử Lừng Danh Conan', 5),
('MS17', 'HDN09', N'Gintama - Linh Hồn Bạc', 3),
('MS18', 'HDN09', N'Thế Giới Phẳng', 9),
('MS19', 'HDN10', N'Vũ Trụ Trong Vỏ Hạt Dẻ', 2),
('MS20', 'HDN10', N'Về Nguồn Gốc Các Loài', 3);

--them du lieu hoa don xuat:
INSERT INTO TChitietHDX (MaSach, MaHDX, TenSach, SoLuongXuat)
VALUES 
('MS01', 'HDX01', N'Cây Cam Ngọt Của Tôi', 2),
('MS02', 'HDX01', N'Harry Potter Và Hoàng Tử Lai', 3),
('MS03', 'HDX02', N'Bí Kíp Luyện Rồng', 2),
('MS04', 'HDX02', N'Suối Nguồn', 4),
('MS05', 'HDX03', N'Phía Nam Biên Giới,Phía Tây Mặt Trời', 1),
('MS06', 'HDX03', N'Nhà Giả Kim', 3),
('MS07', 'HDX04', N'Bố Già', 3),
('MS08', 'HDX04', N'Bắt Trẻ Đồng Xanh', 2),
('MS09', 'HDX05', N'Nanh Trắng', 4),
('MS10', 'HDX05', N'Mùa Hè Bất Tận', 3),
('MS11', 'HDX06', N'Bất Tử Và Bất Hạnh', 5),
('MS12', 'HDX06', N'Naruto Shippuden', 2),
('MS13', 'HDX07', N'One piece', 6),
('MS14', 'HDX07', N'Bleach-Huyết Chiến Ngàn Năm', 4),
('MS15', 'HDX08', N'Bảy Viên Ngọc Rồng', 1),
('MS16', 'HDX08', N'Thám Tử Lừng Danh Conan', 5),
('MS17', 'HDX09', N'Gintama - Linh Hồn Bạc', 3),
('MS18', 'HDX09', N'Thế Giới Phẳng', 4),
('MS19', 'HDX10', N'Vũ Trụ Trong Vỏ Hạt Dẻ', 2),
('MS20', 'HDX10', N'Về Nguồn Gốc Các Loài', 3);



INSERT INTO TChitietHDX (MaSach, MaHDX, TenSach, SoLuongXuat)
VALUES 
('MS01', 'HDX11', N'Cây Cam Ngọt Của Tôi', 2),
('MS02', 'HDX12', N'Harry Potter Và Hoàng Tử Lai', 3),
('MS03', 'HDX13', N'Bí Kíp Luyện Rồng', 2),
('MS04', 'HDX14', N'Suối Nguồn', 4),
('MS05', 'HDX15', N'Phía Nam Biên Giới,Phía Tây Mặt Trời', 1),
('MS06', 'HDX16', N'Nhà Giả Kim', 3),
('MS07', 'HDX17', N'Bố Già', 9),
('MS08', 'HDX18', N'Bắt Trẻ Đồng Xanh', 8),
('MS09', 'HDX19', N'Nanh Trắng', 1),
('MS10', 'HDX20', N'Mùa Hè Bất Tận', 2),
('MS11', 'HDX21', N'Bất Tử Và Bất Hạnh', 7),
('MS12', 'HDX22', N'Naruto Shippuden', 2),
('MS13', 'HDX23', N'One piece', 2),
('MS08', 'HDX24', N'Bắt Trẻ Đồng Xanh', 1),
('MS09', 'HDX25', N'Nanh Trắng', 1),
('MS10', 'HDX26', N'Mùa Hè Bất Tận', 1),
('MS11', 'HDX27', N'Bất Tử Và Bất Hạnh', 1),
('MS12', 'HDX28', N'Naruto Shippuden', 2),
('MS13', 'HDX29', N'One piece', 5),
('MS13', 'HDX30', N'One piece', 1);
















--tao rang buoc giua cac bang voi nhau thong qua khoa ngoai
ALTER TABLE [dbo].[TChitietHDX]  WITH CHECK ADD  CONSTRAINT [FK_TChitietHDX_tHoaDonxuat] FOREIGN KEY([MaHDX])
REFERENCES [dbo].[tHoaDonxuat] ([MaHDX])
ALTER TABLE [dbo].[TChitietHDX] CHECK CONSTRAINT [FK_TChitietHDX_tHoaDonxuat]



ALTER TABLE [dbo].[TChitietHDX]  WITH CHECK ADD  CONSTRAINT [FK_TChitietHDX_tSach] FOREIGN KEY([MaSach])
REFERENCES [dbo].[tSach] ([MaSach])
ALTER TABLE [dbo].[TChitietHDX] CHECK CONSTRAINT [FK_TChitietHDX_tSach]


ALTER TABLE [dbo].[TChitietHDN]  WITH CHECK ADD  CONSTRAINT [FK_TChitietHDN_tHoaDonNhap] FOREIGN KEY([MaHDN])
REFERENCES [dbo].[tHoaDonNhap] ([MaHDN])
ALTER TABLE [dbo].[TChitietHDN] CHECK CONSTRAINT [FK_TChitietHDN_tHoaDonNhap]


ALTER TABLE [dbo].[TChitietHDN]  WITH CHECK ADD  CONSTRAINT [FK_TChitietHDN_tSach] FOREIGN KEY([MaSach])
REFERENCES [dbo].[tSach] ([MaSach])
ALTER TABLE [dbo].[TChitietHDN] CHECK CONSTRAINT [FK_TChitietHDN_tSach]


ALTER TABLE [dbo].[tSach]  WITH CHECK ADD  CONSTRAINT [FK_tSach_tNhaXuatBan] FOREIGN KEY([MaNhaXuatBan])
REFERENCES [dbo].[tNhaXuatBan] ([MaNhaXuatBan])
ALTER TABLE [dbo].[tSach] CHECK CONSTRAINT [FK_tSach_tNhaXuatBan]


ALTER TABLE [dbo].[tSach]  WITH CHECK ADD  CONSTRAINT [FK_tSach_tNhanVien] FOREIGN KEY([MaNhanVien])
REFERENCES [dbo].[tNhanVien] ([MaNhanVien])
ALTER TABLE [dbo].[tSach] CHECK CONSTRAINT [FK_tSach_tNhanVien]


ALTER TABLE [dbo].[tSach]  WITH CHECK ADD  CONSTRAINT [FK_tSach_tKhuVuc] FOREIGN KEY([MaKhuVuc])
REFERENCES [dbo].[tKhuVuc] ([MaKhuVuc])
ALTER TABLE [dbo].[tSach] CHECK CONSTRAINT [FK_tSach_tKhuVuc]


ALTER TABLE [dbo].[tHoaDonNhap]  WITH CHECK ADD  CONSTRAINT [FK_tHoaDonNhap _tNhaXuatBan] FOREIGN KEY([MaNhaXuatBan])
REFERENCES [dbo].[tNhaXuatBan] ([MaNhaXuatBan])
ALTER TABLE [dbo].[tHoaDonNhap ] CHECK CONSTRAINT [FK_tHoaDonNhap _tNhaXuatBan]


ALTER TABLE [dbo].[tHoaDonNhap]  WITH CHECK ADD  CONSTRAINT [FK_tHoaDonNhap _tNhanVien] FOREIGN KEY([MaNhanVien])
REFERENCES [dbo].[tNhanVien] ([MaNhanVien])
ALTER TABLE [dbo].[tHoaDonNhap] CHECK CONSTRAINT [FK_tHoaDonNhap _tNhanVien]








ALTER TABLE [dbo].[tHoaDonxuat]  WITH CHECK ADD  CONSTRAINT [FK_tHoaDonxuat _tKhachHang] FOREIGN KEY([MaKhachHang])
REFERENCES [dbo].[tKhachHang] ([MaKhachHang])
ALTER TABLE [dbo].[tHoaDonxuat] CHECK CONSTRAINT [FK_tHoaDonxuat _tKhachHang]


ALTER TABLE [dbo].[tHoaDonxuat]  WITH CHECK ADD  CONSTRAINT [FK_tHoaDonxuat _tNhanVien] FOREIGN KEY([MaNhanVien])
REFERENCES [dbo].[tNhanVien] ([MaNhanVien])
ALTER TABLE [dbo].[tHoaDonxuat] CHECK CONSTRAINT [FK_tHoaDonxuat _tNhanVien]


ALTER TABLE [dbo].[tKhuVuc]  WITH CHECK ADD  CONSTRAINT [FK_tKhuVuc _tNhanVien] FOREIGN KEY([MaNhanVien])
REFERENCES [dbo].[tNhanVien] ([MaNhanVien])
ALTER TABLE [dbo].[tKhuVuc] CHECK CONSTRAINT [FK_tKhuVuc _tNhanVien]





ALTER TABLE TChiNhanh
ADD CONSTRAINT FK_TChiNhanh_tNhanVien 
FOREIGN KEY (MaNhanVien) 
REFERENCES tNhanVien(MaNhanVien);











