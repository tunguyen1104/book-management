package connect;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

public class ConnectThongKe extends JDBCConnection {
    public DefaultTableModel getSachBanChay() {
        DefaultTableModel tableSachBanChay = new DefaultTableModel();
        Connection conn = getJDBCConnection();
        if (conn != null) {
            PreparedStatement stm = null;
            ResultSet rs = null;
            tableSachBanChay.addColumn("Mã sách");
            tableSachBanChay.addColumn("Tên sách");
            tableSachBanChay.addColumn("Tổng tiền");
            tableSachBanChay.addColumn("Số quyển");
            tableSachBanChay.setRowCount(0);
            try {
                stm = conn.prepareStatement(
                        "SELECT MaSach,TenSach,SUM(TienThanhToanThuc), SUM(SoLuongXuat) FROM TChitietHDX INNER JOIN tHoaDonxuat ON tHoaDonxuat.MaHDX = TChitietHDX.MaHDX GROUP BY TChitietHDX.MaSach,TChitietHDX.TenSach ORDER BY SUM(TChitietHDX.SoLuongXuat) DESC");
                rs = stm.executeQuery();
                while (rs.next()) {
                    Object[] row = {
                            rs.getString(1),
                            rs.getString(2),
                            rs.getBigDecimal(3),
                            rs.getInt(4),
                    };
                    tableSachBanChay.addRow(row);
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
        return tableSachBanChay;
    }

    public DefaultTableModel getSachBanChay(String top, String month, String year) {
        DefaultTableModel tableSachBanChay = new DefaultTableModel();
        Connection conn = getJDBCConnection();
        if (conn != null) {
            PreparedStatement stm = null;
            ResultSet rs = null;
            tableSachBanChay.addColumn("Mã sách");
            tableSachBanChay.addColumn("Tên sách");
            tableSachBanChay.addColumn("Tổng tiền");
            tableSachBanChay.addColumn("Số quyển");
            tableSachBanChay.setRowCount(0);
            try {
                stm = conn.prepareStatement(
                        "SELECT TOP " + Integer.parseInt(top)
                                + " MaSach,TenSach,SUM(TienThanhToanThuc), SUM(SoLuongXuat) FROM TChitietHDX INNER JOIN tHoaDonxuat ON tHoaDonxuat.MaHDX = TChitietHDX.MaHDX WHERE YEAR(NgayXuat) = ? AND MONTH(NgayXuat) = ? GROUP BY TChitietHDX.MaSach,TChitietHDX.TenSach ORDER BY SUM(TChitietHDX.SoLuongXuat) DESC");
                stm.setInt(1, Integer.parseInt(year));
                stm.setInt(2, Integer.parseInt(month));
                rs = stm.executeQuery();
                while (rs.next()) {
                    Object[] row = {
                            rs.getString(1),
                            rs.getString(2),
                            rs.getBigDecimal(3),
                            rs.getInt(4),
                    };
                    tableSachBanChay.addRow(row);
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
        return tableSachBanChay;
    }

    public DefaultTableModel getNhanVienTot() {
        DefaultTableModel tableNhanVienTot = new DefaultTableModel();
        Connection conn = getJDBCConnection();
        if (conn != null) {
            PreparedStatement stm = null;
            ResultSet rs = null;
            tableNhanVienTot.addColumn("Mã nhân viên");
            tableNhanVienTot.addColumn("Tên nhân viên");
            tableNhanVienTot.addColumn("Số sách bán được");
            tableNhanVienTot.setRowCount(0);
            try {
                stm = conn.prepareStatement(
                        "SELECT tNhanVien.MaNhanVien,TenNhanVien,COUNT(*) FROM tNhanVien INNER JOIN tHoaDonxuat ON tHoaDonxuat.MaNhanVien = tNhanVien.MaNhanVien GROUP BY tNhanVien.MaNhanVien,TenNhanVien ORDER BY COUNT(*) DESC");
                rs = stm.executeQuery();
                while (rs.next()) {
                    Object[] row = {
                            rs.getString(1),
                            rs.getString(2),
                            rs.getInt(3),
                    };
                    tableNhanVienTot.addRow(row);
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
        return tableNhanVienTot;
    }

    public BigDecimal getDoanhThuNam() {
        Connection conn = getJDBCConnection();
        if (conn != null) {
            PreparedStatement stm = null;
            ResultSet rs = null;
            try {
                stm = conn.prepareStatement(
                        "SELECT( (SELECT SUM(TongTien) FROM tHoaDonXuat WHERE YEAR(NgayXuat) = YEAR(GETDATE())) - (SELECT SUM(TChitietHDN.SoLuongNhap * (GiaTien - 10000)) FROM TChitietHDN  INNER JOIN tSACH ON TChitietHDN.MaSach = tSACH.MaSach INNER JOIN tHoaDonNhap ON TChitietHDN.MaHDN = tHoaDonNhap.MaHDN WHERE YEAR(tHoaDonNhap.NgayNhap) = YEAR(GETDATE())) );");
                rs = stm.executeQuery();
                while (rs.next()) {
                    return rs.getBigDecimal(1);
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
        return new BigDecimal("0");
    }

    public DefaultTableModel getDoanhThuCacChiNhanh() {
        DefaultTableModel tableDoanhThu = new DefaultTableModel();
        Connection conn = getJDBCConnection();
        if (conn != null) {
            PreparedStatement stm = null;
            ResultSet rs = null;
            tableDoanhThu.addColumn("Mã chi nhánh");
            tableDoanhThu.addColumn("Tổng doanh thu");
            tableDoanhThu.setRowCount(0);
            try {
                stm = conn.prepareStatement(
                        "SELECT tChiNhanh.MaChiNhanh,SUM(tHoaDonxuat.TongTien) FROM tChiNhanh INNER JOIN tNhanVien ON tChiNhanh.MaNhanVien = tNhanVien.MaNhanVien INNER JOIN tHoaDonxuat ON tNhanVien.MaNhanVien = tHoaDonxuat.MaNhanVien INNER JOIN TChitietHDX ON TChitietHDX.MaHDX = tHoaDonxuat.MaHDX WHERE YEAR(tHoaDonXuat.NgayXuat) = 2022 GROUP BY tChiNhanh.MaChiNhanh");
                rs = stm.executeQuery();
                while (rs.next()) {
                    Object[] row = {
                            rs.getString(1),
                            rs.getBigDecimal(2),
                    };
                    tableDoanhThu.addRow(row);
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
        return tableDoanhThu;
    }

    public DefaultTableModel getSoLuongTonKhoTrongThangNay() {
        DefaultTableModel tableDoanhThu = new DefaultTableModel();
        Connection conn = getJDBCConnection();
        if (conn != null) {
            PreparedStatement stm = null;
            ResultSet rs = null;
            tableDoanhThu.addColumn("Mã sách");
            tableDoanhThu.addColumn("Tên sách");
            tableDoanhThu.addColumn("Số lượng tồn kho");
            tableDoanhThu.setRowCount(0);
            try {
                stm = conn.prepareStatement(
                        "SELECT tSach.MaSach,tSach.TenSach,(SUM(ISNULL(TChitietHDN.SoLuongNhap, 0)) - SUM(ISNULL(TChitietHDX.SoLuongXuat, 0))) FROM tSach LEFT JOIN TChitietHDN ON TChitietHDN.MaSach = tSach.MaSach LEFT JOIN TChitietHDX ON TChitietHDX.MaSach = tSach.MaSach  LEFT JOIN tHoaDonNhap ON TChitietHDN.MaHDN = tHoaDonNhap.MaHDN LEFT JOIN tHoaDonxuat ON TChitietHDX.MaHDX = tHoaDonxuat.MaHDX WHERE YEAR(tHoaDonNhap.NgayNhap) = 2022 AND MONTH(tHoaDonNhap.NgayNhap) = MONTH(GETDATE()) AND YEAR(tHoaDonXuat.NgayXuat) = 2022 AND MONTH(tHoaDonxuat.NgayXuat) = MONTH(GETDATE()) GROUP BY tSach.MaSach, tSach.TenSach;");
                rs = stm.executeQuery();
                while (rs.next()) {
                    Object[] row = {
                            rs.getString(1),
                            rs.getString(2),
                            rs.getInt(3)
                    };
                    tableDoanhThu.addRow(row);
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
        return tableDoanhThu;
    }
}
