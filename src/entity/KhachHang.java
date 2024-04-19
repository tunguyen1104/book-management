package entity;

public class KhachHang {
    private String maKhachHang;
    private String name;
    private String phone;
    private String email;
    private int tichdiem;
    private String diaChi;
    public KhachHang() {
    }
    public KhachHang(String maKhachHang, String name, String phone, String email, int tichdiem, String diaChi) {
        this.maKhachHang = maKhachHang;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.tichdiem = tichdiem;
        this.diaChi = diaChi;
    }

    public String getName() {
        return name;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getTichdiem() {
        return tichdiem;
    }

    public void setTichdiem(int tichdiem) {
        this.tichdiem = tichdiem;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }
}
