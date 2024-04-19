package entity;

public class HoaDonXuat {
    private String maHoaDonXuat;
    private String ngayxuat;
    private String maNV;

    public HoaDonXuat() {
    }
    public HoaDonXuat(String maHoaDonXuat, String ngayxuat, String maNV) {
        this.maHoaDonXuat = maHoaDonXuat;
        this.ngayxuat = ngayxuat;
        this.maNV = maNV;
    }

    public String getMaHoaDonXuat() {
        return maHoaDonXuat;
    }

    public void setMaHoaDonXuat(String maHoaDonXuat) {
        this.maHoaDonXuat = maHoaDonXuat;
    }

    public String getNgayxuat() {
        return ngayxuat;
    }

    public void setNgayxuat(String ngayxuat) {
        this.ngayxuat = ngayxuat;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }
}
