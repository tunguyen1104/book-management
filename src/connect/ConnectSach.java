package connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import entity.Sach;

public class ConnectSach extends JDBCConnection {
    public DefaultTableModel getAllSach() {
        DefaultTableModel tableSach = new DefaultTableModel();
        Connection conn = getJDBCConnection();
        if (conn != null) {
            PreparedStatement stm = null;
            ResultSet rs = null;
            tableSach.addColumn("Mã sách");
            tableSach.addColumn("Tên sách");
            tableSach.addColumn("Giá tiền");
            tableSach.addColumn("Tác giả");
            tableSach.addColumn("Mã NXB");
            tableSach.addColumn("Mã khu vực");
            tableSach.addColumn("Discount");
            tableSach.setRowCount(0);
            try {
                stm = conn.prepareStatement("SELECT * FROM TSACH");
                rs = stm.executeQuery();
                while (rs.next()) {
                    Object[] row = {
                            rs.getString(1),
                            rs.getString(2),
                            rs.getBigDecimal(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getString(6),
                            rs.getBigDecimal(7)
                    };
                    tableSach.addRow(row);
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
        return tableSach;
    }

    public void themSachMoi(Sach s) {
        Connection conn = getJDBCConnection();
        if (conn != null) {
            PreparedStatement stm = null;
            try {
                stm = conn.prepareStatement(
                        "INSERT INTO TSACH(MaSach, TenSach, GiaTien, TacGia, MaNhaXuatBan, MaKhuVuc, Discount) VALUES (?,?,?,?,?,?,?)");
                stm.setString(1, s.getMaSach());
                stm.setString(2, s.getTenSach());
                stm.setDouble(3, s.getGiaBan());
                stm.setString(4, s.getTacGia());
                stm.setString(5, s.getMaNXB());
                stm.setString(6, s.getMaKhuVuc());
                stm.setDouble(7, s.getDiscount());
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

    public void suaSach(Sach s) {
        Connection conn = getJDBCConnection();
        if (conn != null) {
            PreparedStatement stm = null;
            try {
                stm = conn.prepareStatement(
                        "UPDATE TSACH SET TenSach = ?, GiaTien = ?, TacGia = ?, MaNhaXuatBan = ?, MaKhuVuc = ?, Discount = ? WHERE MaSach = ?");
                stm.setString(1, s.getTenSach());
                stm.setDouble(2, s.getGiaBan());
                stm.setString(3, s.getTacGia());
                stm.setString(4, s.getMaNXB());
                stm.setString(5, s.getMaKhuVuc());
                stm.setDouble(6, s.getDiscount());
                stm.setString(7, s.getMaSach());
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

    public void xoaSach(String maSach) {
        Connection conn = getJDBCConnection();
        if (conn != null) {
            PreparedStatement stm = null;
            try {
                stm = conn.prepareStatement(
                        "DELETE FROM TSACH WHERE MaSach = ?");
                stm.setString(1, maSach);
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
            timKiem.addColumn("Mã sách");
            timKiem.addColumn("Tên sách");
            timKiem.addColumn("Giá tiền");
            timKiem.addColumn("Tác giả");
            timKiem.addColumn("Mã NXB");
            timKiem.addColumn("Mã khu vực");
            timKiem.addColumn("Discount");
            timKiem.setRowCount(0);
            try {
                String query = "SELECT * FROM TSACH WHERE " + column_name + " LIKE ?";
                stm = conn.prepareStatement(query);
                stm.setString(1, "%" + res + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    Object[] row = {
                            rs.getString(1),
                            rs.getString(2),
                            rs.getBigDecimal(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getString(6),
                            rs.getBigDecimal(7)
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

    public DefaultTableModel timKiemTheLoai(String res) {
        DefaultTableModel timKiem = new DefaultTableModel();
        Connection conn = getJDBCConnection();
        if (conn != null) {
            PreparedStatement stm = null;
            ResultSet rs = null;
            timKiem.addColumn("Mã sách");
            timKiem.addColumn("Tên sách");
            timKiem.addColumn("Giá tiền");
            timKiem.addColumn("Tác giả");
            timKiem.addColumn("Mã NXB");
            timKiem.addColumn("Mã khu vực");
            timKiem.addColumn("Discount");
            timKiem.addColumn("Thể loại");
            timKiem.setRowCount(0);
            try {
                String query = "SELECT tSACH.*,tKhuVuc.TenKhuVuc FROM tSACH INNER JOIN tKhuVuc ON tSach.MaKhuVuc = tKhuVuc.MaKhuVuc WHERE tKhuVuc.TenKhuVuc LIKE ?";
                stm = conn.prepareStatement(query);
                stm.setString(1, res + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    Object[] row = {
                            rs.getString(1),
                            rs.getString(2),
                            rs.getBigDecimal(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getString(6),
                            rs.getBigDecimal(7),
                            rs.getString(8)
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

    public boolean checkMaSach(String maSach) {
        Connection conn = getJDBCConnection();
        try {
            String sql = "SELECT MaSach FROM TSACH WHERE MaSach = ?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, maSach);
            ResultSet result = pre.executeQuery();
            if (result.next())
                return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean checkMaSachInChiTietNhap(String maSach) {
        Connection conn = getJDBCConnection();
        try {
            String sql = "SELECT MaSach FROM TChitietHDN WHERE MaSach = ?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, maSach);
            ResultSet result = pre.executeQuery();
            if (result.next())
                return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean checkMaSachInChiTietXuat(String maSach) {
        Connection conn = getJDBCConnection();
        try {
            String sql = "SELECT MaSach FROM TChitietHDX WHERE MaSach = ?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, maSach);
            ResultSet result = pre.executeQuery();
            if (result.next())
                return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
