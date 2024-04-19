package connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import entity.KhachHang;

public class ConnectKhachHang extends JDBCConnection {
    public DefaultTableModel getAllKhachHang() {
        DefaultTableModel tableKhachHang = new DefaultTableModel();
        Connection conn = getJDBCConnection();
        if (conn != null) {
            PreparedStatement stm = null;
            ResultSet rs = null;
            tableKhachHang.addColumn("Mã khách hàng");
            tableKhachHang.addColumn("Tên khách hàng");
            tableKhachHang.addColumn("Phone");
            tableKhachHang.addColumn("Email");
            tableKhachHang.addColumn("Tích điểm");
            tableKhachHang.addColumn("Địa chỉ");
            tableKhachHang.setRowCount(0);
            try {
                stm = conn.prepareStatement("SELECT * FROM TKhachHang");
                rs = stm.executeQuery();
                while (rs.next()) {
                    Object[] row = {
                            rs.getString(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getInt(5),
                            rs.getString(6)
                    };
                    tableKhachHang.addRow(row);
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
        return tableKhachHang;
    }

    public void themKhachHangMoi(KhachHang s) {
        Connection conn = getJDBCConnection();
        if (conn != null) {
            PreparedStatement stm = null;
            try {
                stm = conn.prepareStatement(
                        "INSERT INTO TKhachHang(MaKhachHang, TenKhachHang, SoDienThoai, Email, TichDiem, DiaChi) VALUES (?,?,?,?,?,?)");
                stm.setString(1, s.getMaKhachHang());
                stm.setString(2, s.getName());
                stm.setString(3, s.getPhone());
                stm.setString(4, s.getEmail());
                stm.setInt(5, s.getTichdiem());
                stm.setString(6, s.getDiaChi());
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

    public void suaKhachHang(KhachHang s) {
        Connection conn = getJDBCConnection();
        if (conn != null) {
            PreparedStatement stm = null;
            try {
                stm = conn.prepareStatement(
                        "UPDATE TKhachHang SET TenKhachHang = ?, SoDienThoai = ?, Email = ?, TichDiem = ?, DiaChi = ? WHERE MaKhachHang = ?");

                stm.setString(1, s.getName());
                stm.setString(2, s.getPhone());
                stm.setString(3, s.getEmail());
                stm.setInt(4, s.getTichdiem());
                stm.setString(5, s.getDiaChi());
                stm.setString(6, s.getMaKhachHang());
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

    public void xoaKhachHang(String maKhachHang) {
        Connection conn = getJDBCConnection();
        if (conn != null) {
            PreparedStatement stm = null;
            try {
                stm = conn.prepareStatement(
                        "DELETE FROM TKhachHang WHERE MaKhachHang = ?");
                stm.setString(1, maKhachHang);
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

    public DefaultTableModel timKiem(String res) {
        DefaultTableModel timKiem = new DefaultTableModel();
        Connection conn = getJDBCConnection();
        if (conn != null) {
            PreparedStatement stm = null;
            ResultSet rs = null;
            timKiem.addColumn("Mã khách hàng");
            timKiem.addColumn("Tên khách hàng");
            timKiem.addColumn("Phone");
            timKiem.addColumn("Email");
            timKiem.addColumn("Tích điểm");
            timKiem.addColumn("Địa chỉ");
            timKiem.setRowCount(0);
            try {
                String query = "SELECT * FROm tKhachHang WHERE MaKhachHang LIKE ? OR TenKhachHang LIKE ?";
                stm = conn.prepareStatement(query);
                stm.setString(1, res + "%");
                stm.setString(2, res + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    Object[] row = {
                            rs.getString(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getInt(5),
                            rs.getString(6)
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

    public boolean checkMaKhachHang(String maKhachHang) {
        Connection conn = getJDBCConnection();
        try {
            PreparedStatement pre = conn.prepareStatement("SELECT MaKhachHang FROM TKhachHang WHERE MaKhachHang = ?");
            pre.setString(1, maKhachHang);
            ResultSet result = pre.executeQuery();
            if (result.next())
                return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean checkMaKhachHangHoaDonXuat(String maKhachHang) {
        Connection conn = getJDBCConnection();
        try {
            PreparedStatement pre = conn.prepareStatement("SELECT MaKhachHang FROM tHoaDonxuat WHERE MaKhachHang = ?");
            pre.setString(1, maKhachHang);
            ResultSet result = pre.executeQuery();
            if (result.next())
                return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
