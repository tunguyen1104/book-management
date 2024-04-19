package connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import entity.NhanVien;

public class ConnectNhanVien extends JDBCConnection {
    public DefaultTableModel getAllNhanVien() {
        DefaultTableModel tableNhanVien = new DefaultTableModel();
        Connection conn = getJDBCConnection();
        if (conn != null) {
            PreparedStatement stm = null;
            ResultSet rs = null;
            tableNhanVien.addColumn("Mã nhân viên");
            tableNhanVien.addColumn("Tên nhân viên");
            tableNhanVien.addColumn("Giới tính");
            tableNhanVien.addColumn("Lương");
            tableNhanVien.addColumn("Mã quản lí");
            tableNhanVien.addColumn("Tuổi");
            tableNhanVien.addColumn("Ngày kí hợp đồng");
            tableNhanVien.addColumn("Số năm hợp đồng");
            tableNhanVien.addColumn("Số ngày nghỉ phép");
            tableNhanVien.addColumn("Địa chỉ");
            tableNhanVien.addColumn("Hệ số lương");
            tableNhanVien.addColumn("Chức vụ");
            tableNhanVien.setRowCount(0);
            try {
                stm = conn.prepareStatement("SELECT * FROM TNHANVIEN");
                rs = stm.executeQuery();
                while (rs.next()) {
                    Object[] row = {
                            rs.getString(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getBigDecimal(4),
                            rs.getString(5),
                            rs.getInt(6),
                            rs.getString(7),
                            rs.getInt(8),
                            rs.getInt(9),
                            rs.getString(10),
                            rs.getBigDecimal(11),
                            rs.getString(12),
                    };
                    tableNhanVien.addRow(row);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    if (stm != null)
                        stm.close();
                    if (rs != null)
                        rs.close();
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return tableNhanVien;
    }

    public void themNhanVienMoi(NhanVien s) {
        Connection conn = getJDBCConnection();
        if (conn != null) {
            PreparedStatement stm = null;
            try {
                stm = conn.prepareStatement(
                        "INSERT INTO TNhanVien(MaNhanVien, TenNhanVien, GioiTinh, LuongCoSo, MaQuanLi, Tuoi, NgayKiHopDong,SoNamHopDong,SoNgayNghiPhep,DiaChi,HeSoLuong,Chucvu) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
                stm.setString(1, s.getMaNV());
                stm.setString(2, s.getTenNV());
                stm.setString(3, s.getGioitinh());
                stm.setDouble(4, s.getLuong());
                stm.setString(5, s.getMaQuanLy());
                stm.setInt(6, s.getTuoi());
                stm.setString(7, s.getNgayBatDauHopDong());
                stm.setInt(8, s.getSoNamHopDong());
                stm.setInt(9, s.getSoNgayPhepConLai());
                stm.setString(10, s.getDiaChi());
                stm.setDouble(11, s.getHeSoLuong());
                stm.setString(12, s.getChucVu());
                stm.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (stm != null)
                        stm.close();
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void suaNhanVien(NhanVien s) {
        Connection conn = getJDBCConnection();
        if (conn != null) {
            PreparedStatement stm = null;
            try {
                stm = conn.prepareStatement(
                        "UPDATE TNhanVien SET TenNhanVien = ?, GioiTinh = ?, LuongCoSo = ?, MaQuanLi = ?, Tuoi = ?, NgayKiHopDong = ?,SoNamHopDong = ?,SoNgayNghiPhep = ?,DiaChi = ?,HeSoLuong = ?,Chucvu = ? WHERE MaNhanVien = ?");
                stm.setString(1, s.getTenNV());
                stm.setString(2, s.getGioitinh());
                stm.setDouble(3, s.getLuong());
                stm.setString(4, s.getMaQuanLy());
                stm.setInt(5, s.getTuoi());
                stm.setString(6, s.getNgayBatDauHopDong());
                stm.setInt(7, s.getSoNamHopDong());
                stm.setInt(8, s.getSoNgayPhepConLai());
                stm.setString(9, s.getDiaChi());
                stm.setDouble(10, s.getHeSoLuong());
                stm.setString(11, s.getChucVu());
                stm.setString(12, s.getMaNV());
                stm.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (stm != null)
                        stm.close();
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void xoaNhanVien(String maNhanVien) {
        Connection conn = getJDBCConnection();
        if (conn != null) {
            PreparedStatement stm = null;
            try {
                stm = conn.prepareStatement(
                        "DELETE FROM TNhanVien WHERE MaNhanVien = ?");
                stm.setString(1, maNhanVien);
                stm.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (stm != null)
                        stm.close();
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public DefaultTableModel timKiem(String column_name, String res) {
        DefaultTableModel timKiem = new DefaultTableModel();
        Connection conn = getJDBCConnection();
        if (conn != null) {
            PreparedStatement stm = null;
            ResultSet rs = null;
            timKiem.addColumn("Mã nhân viên");
            timKiem.addColumn("Tên nhân viên");
            timKiem.addColumn("Lương");
            timKiem.addColumn("Mã quản lí");
            timKiem.addColumn("Tuổi");
            timKiem.addColumn("Ngày kí hợp đồng");
            timKiem.addColumn("Số năm hợp đồng");
            timKiem.addColumn("Số ngày nghỉ phép");
            timKiem.addColumn("Địa chỉ");
            timKiem.addColumn("Hệ số lương");
            timKiem.addColumn("Chức vụ");
            timKiem.setRowCount(0);
            try {
                String query = "SELECT * FROM tNhanVien WHERE " + column_name + " LIKE ?";
                stm = conn.prepareStatement(query);
                stm.setString(1, "%" + res + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    Object[] row = {
                            rs.getString(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getBigDecimal(4),
                            rs.getString(5),
                            rs.getInt(6),
                            rs.getString(7),
                            rs.getInt(8),
                            rs.getInt(9),
                            rs.getString(10),
                            rs.getBigDecimal(11),
                            rs.getString(12),
                    };
                    timKiem.addRow(row);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    if (stm != null)
                        stm.close();
                    if (rs != null)
                        rs.close();
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return timKiem;
    }

    public boolean checkMaNhanVien(String maNhanVien) {
        Connection conn = getJDBCConnection();
        try {
            PreparedStatement pre = conn.prepareStatement("SELECT MaNhanVien FROM TNhanVien WHERE MaNhanVien = ?");
            pre.setString(1, maNhanVien);
            ResultSet result = pre.executeQuery();
            if (result.next())
                return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean checkMaNhanVienHoaDonNhap(String maNhanVien) {
        Connection conn = getJDBCConnection();
        try {
            PreparedStatement pre = conn.prepareStatement("SELECT MaNhanVien FROM tHoaDonNhap WHERE MaNhanVien = ?");
            pre.setString(1, maNhanVien);
            ResultSet result = pre.executeQuery();
            if (result.next())
                return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean checkMaNhanVienHoaDonXuat(String maNhanVien) {
        Connection conn = getJDBCConnection();
        try {
            PreparedStatement pre = conn.prepareStatement("SELECT MaNhanVien FROM tHoaDonxuat WHERE MaNhanVien = ?");
            pre.setString(1, maNhanVien);
            ResultSet result = pre.executeQuery();
            if (result.next())
                return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
