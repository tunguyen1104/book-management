package entity;

public class HoaDonNhap {
    private String maHoaDonNhap;
    private String maNV ;
    private String ngaynhap ;
    private String maNXB;
    public HoaDonNhap() {}

    public HoaDonNhap(String maHoaDonNhap, String maNV, String ngaynhap, String maNXB) {
        this.maHoaDonNhap = maHoaDonNhap;
        this.maNV = maNV;
        this.ngaynhap = ngaynhap;
        this.maNXB = maNXB;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public void setNgaynhap(String ngaynhap) {
        this.ngaynhap = ngaynhap;
    }


    public void setMaNXB(String maNXB) {
        this.maNXB = maNXB;
    }

    public String getNgaynhap() {
        return ngaynhap;
    }
    public String getMaNXB() {
        return maNXB;
    }
}
