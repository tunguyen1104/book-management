package entity;

public class NhanVien {
    private String maNV;
    private String tenNV;
    private String ngayBatDauHopDong;

    private int soNamHopDong;
    private double heSoLuong;
    private String gioitinh;
    private int soNgayNghiPhep;
    private String maKhuVuc;
    private int tuoi;
    private double luong;
    private String maQuanLy;
    private String diaChi;

    private String chucVu;

    public NhanVien() {
    }

    public NhanVien(String maNV, String tenNV, String ngayBatDauHopDong, int soNamHopDong, double heSoLuong,
            String gioitinh, int soNgayNghiPhep, String maKhuVuc, int tuoi, double luong, String maQuanLy,
            String diaChi, String chucVu) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.ngayBatDauHopDong = ngayBatDauHopDong;
        this.soNamHopDong = soNamHopDong;
        this.heSoLuong = heSoLuong;
        this.gioitinh = gioitinh;
        this.soNgayNghiPhep = soNgayNghiPhep;
        this.maKhuVuc = maKhuVuc;
        this.tuoi = tuoi;
        this.luong = luong;
        this.maQuanLy = maQuanLy;
        this.diaChi = diaChi;
        this.chucVu = chucVu;
    }

    public String getMaKhuVuc() {
        return maKhuVuc;
    }

    public void setMaKhuVuc(String maKhuVuc) {
        this.maKhuVuc = maKhuVuc;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getMaNV() {
        return maNV;
    }

    public String getMaQuanLy() {
        return maQuanLy;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public String getNgayBatDauHopDong() {
        return ngayBatDauHopDong;
    }

    public void setNgayBatDauHopDong(String ngayBatDauHopDong) {
        this.ngayBatDauHopDong = ngayBatDauHopDong;
    }

    public int getSoNamHopDong() {
        return soNamHopDong;
    }

    public void setSoNamHopDong(int soNamHopDong) {
        this.soNamHopDong = soNamHopDong;
    }

    public double getHeSoLuong() {
        return heSoLuong;
    }

    public void setHeSoLuong(double heSoLuong) {
        this.heSoLuong = heSoLuong;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public int getSoNgayPhepConLai() {
        return soNgayNghiPhep;
    }

    public void setSoNgayPhepConLai(int soNgayNghiPhep) {
        this.soNgayNghiPhep = soNgayNghiPhep;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public void setMaQuanLy(String maQuanLy) {
        this.maQuanLy = maQuanLy;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public double getLuong() {
        return this.luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }
}
