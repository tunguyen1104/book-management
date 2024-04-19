package connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class ConnectHoaDon extends JDBCConnection {
    public DefaultTableModel getAllHoaDonNhap() {
        DefaultTableModel tableHoaDon = new DefaultTableModel();
        Connection conn = getJDBCConnection();
        if (conn != null) {
            PreparedStatement stm = null;
            ResultSet rs = null;
            tableHoaDon.addColumn("Mã HDN");
            tableHoaDon.addColumn("Ngày nhập");
            tableHoaDon.addColumn("Mã NXB");
            tableHoaDon.addColumn("Mã Nhân viên");
            tableHoaDon.setRowCount(0);
            try {
                stm = conn.prepareStatement("SELECT * FROM tHoaDonNhap");
                rs = stm.executeQuery();
                while (rs.next()) {
                    Object[] row = {
                            rs.getString(1),
                            rs.getDate(2),
                            rs.getString(3),
                            rs.getString(4),
                    };
                    tableHoaDon.addRow(row);
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
        return tableHoaDon;
    }

    public DefaultTableModel getAllHoaDonXuat() {
        DefaultTableModel tableHoaDon = new DefaultTableModel();
        Connection conn = getJDBCConnection();
        if (conn != null) {
            PreparedStatement stm = null;
            ResultSet rs = null;
            tableHoaDon.addColumn("Mã HDX");
            tableHoaDon.addColumn("Mã khách hàng");
            tableHoaDon.addColumn("Ngày xuất");
            tableHoaDon.addColumn("Mã Nhân viên");
            tableHoaDon.addColumn("Tổng tiền");
            tableHoaDon.addColumn("Giảm giá còn");
            tableHoaDon.setRowCount(0);
            try {
                stm = conn.prepareStatement("SELECT * FROM tHoaDonxuat");
                rs = stm.executeQuery();
                while (rs.next()) {
                    Object[] row = {
                            rs.getString(1),
                            rs.getString(2),
                            rs.getDate(3),
                            rs.getString(4),
                            rs.getBigDecimal(5),
                            rs.getBigDecimal(6),
                    };
                    tableHoaDon.addRow(row);
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
        return tableHoaDon;
    }

    public DefaultTableModel getHoaDonNhapHomNay() {
        DefaultTableModel tableHoaDon = new DefaultTableModel();
        Connection conn = getJDBCConnection();
        if (conn != null) {
            PreparedStatement stm = null;
            ResultSet rs = null;
            tableHoaDon.addColumn("Mã HDN");
            tableHoaDon.addColumn("Ngày nhập");
            tableHoaDon.addColumn("Mã NXB");
            tableHoaDon.addColumn("Mã Nhân viên");
            tableHoaDon.setRowCount(0);
            try {
                stm = conn.prepareStatement("SELECT * FROM tHoaDonNhap WHERE NgayNhap = GETDATE()");
                rs = stm.executeQuery();
                while (rs.next()) {
                    Object[] row = {
                            rs.getString(1),
                            rs.getDate(2),
                            rs.getString(3),
                            rs.getString(4),
                    };
                    tableHoaDon.addRow(row);
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
        return tableHoaDon;
    }

    public DefaultTableModel getHoaDonNhapTheoThangNam(String month, String year) {
        DefaultTableModel tableHoaDon = new DefaultTableModel();
        Connection conn = getJDBCConnection();
        if (conn != null) {
            PreparedStatement stm = null;
            ResultSet rs = null;
            tableHoaDon.addColumn("Mã HDN");
            tableHoaDon.addColumn("Ngày nhập");
            tableHoaDon.addColumn("Mã NXB");
            tableHoaDon.addColumn("Mã Nhân viên");
            tableHoaDon.setRowCount(0);
            try {
                stm = conn
                        .prepareStatement("SELECT * FROM tHoaDonNhap WHERE YEAR(NgayNhap) = ? AND MONTH(NgayNhap) = ?");
                stm.setInt(1, Integer.parseInt(year));
                stm.setInt(2, Integer.parseInt(month));
                rs = stm.executeQuery();
                while (rs.next()) {
                    Object[] row = {
                            rs.getString(1),
                            rs.getDate(2),
                            rs.getString(3),
                            rs.getString(4),
                    };
                    tableHoaDon.addRow(row);
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
        return tableHoaDon;
    }

    public DefaultTableModel getHoaDonXuatTheoThangNam(String month, String year) {
        DefaultTableModel tableHoaDon = new DefaultTableModel();
        Connection conn = getJDBCConnection();
        if (conn != null) {
            PreparedStatement stm = null;
            ResultSet rs = null;
            tableHoaDon.addColumn("Mã HDX");
            tableHoaDon.addColumn("Mã khách hàng");
            tableHoaDon.addColumn("Ngày xuất");
            tableHoaDon.addColumn("Mã Nhân viên");
            tableHoaDon.addColumn("Tổng tiền");
            tableHoaDon.addColumn("Giảm giá còn");
            tableHoaDon.setRowCount(0);
            try {
                stm = conn
                        .prepareStatement("SELECT * FROM tHoaDonxuat WHERE YEAR(NgayXuat) = ? AND MONTH(NgayXuat) = ?");
                stm.setInt(1, Integer.parseInt(year));
                stm.setInt(2, Integer.parseInt(month));
                rs = stm.executeQuery();
                while (rs.next()) {
                    Object[] row = {
                            rs.getString(1),
                            rs.getString(2),
                            rs.getDate(3),
                            rs.getString(4),
                            rs.getBigDecimal(5),
                            rs.getBigDecimal(6),
                    };
                    tableHoaDon.addRow(row);
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
        return tableHoaDon;
    }

    public DefaultTableModel getHoaDonXuatHomNay() {
        DefaultTableModel tableHoaDon = new DefaultTableModel();
        Connection conn = getJDBCConnection();
        if (conn != null) {
            PreparedStatement stm = null;
            ResultSet rs = null;
            tableHoaDon.addColumn("Mã HDX");
            tableHoaDon.addColumn("Mã khách hàng");
            tableHoaDon.addColumn("Ngày xuất");
            tableHoaDon.addColumn("Mã Nhân viên");
            tableHoaDon.addColumn("Tổng tiền");
            tableHoaDon.addColumn("Giảm giá còn");
            tableHoaDon.setRowCount(0);
            try {
                stm = conn.prepareStatement("SELECT * FROM tHoaDonxuat WHERE NgayXuat = GETDATE()");
                rs = stm.executeQuery();
                while (rs.next()) {
                    Object[] row = {
                            rs.getString(1),
                            rs.getString(2),
                            rs.getDate(3),
                            rs.getString(4),
                            rs.getBigDecimal(5),
                            rs.getBigDecimal(6),
                    };
                    tableHoaDon.addRow(row);
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
        return tableHoaDon;
    }

    public DefaultTableModel getAllChiTietNhap() {
        DefaultTableModel tableHoaDon = new DefaultTableModel();
        Connection conn = getJDBCConnection();
        if (conn != null) {
            PreparedStatement stm = null;
            ResultSet rs = null;
            tableHoaDon.addColumn("Mã sách");
            tableHoaDon.addColumn("Mã HDN");
            tableHoaDon.addColumn("Tên sách");
            tableHoaDon.addColumn("Số lượng");
            tableHoaDon.setRowCount(0);
            try {
                stm = conn.prepareStatement("SELECT * FROM TChitietHDN");
                rs = stm.executeQuery();
                while (rs.next()) {
                    Object[] row = {
                            rs.getString(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getInt(4),
                    };
                    tableHoaDon.addRow(row);
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
        return tableHoaDon;
    }

    public DefaultTableModel getAllChiTietXuat() {
        DefaultTableModel tableHoaDon = new DefaultTableModel();
        Connection conn = getJDBCConnection();
        if (conn != null) {
            PreparedStatement stm = null;
            ResultSet rs = null;
            tableHoaDon.addColumn("Mã sách");
            tableHoaDon.addColumn("Mã HDX");
            tableHoaDon.addColumn("Tên sách");
            tableHoaDon.addColumn("Số lượng");
            tableHoaDon.setRowCount(0);
            try {
                stm = conn.prepareStatement("SELECT * FROM TChitietHDX");
                rs = stm.executeQuery();
                while (rs.next()) {
                    Object[] row = {
                            rs.getString(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getInt(4),
                    };
                    tableHoaDon.addRow(row);
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
        return tableHoaDon;
    }

    public DefaultTableModel getChiTietNhapMaHDN(String maHDN) {
        DefaultTableModel tableHoaDon = new DefaultTableModel();
        Connection conn = getJDBCConnection();
        if (conn != null) {
            PreparedStatement stm = null;
            ResultSet rs = null;
            tableHoaDon.addColumn("Mã sách");
            tableHoaDon.addColumn("Mã HDN");
            tableHoaDon.addColumn("Tên sách");
            tableHoaDon.addColumn("Số lượng");
            tableHoaDon.setRowCount(0);
            try {
                stm = conn.prepareStatement("SELECT * FROM TChitietHDN WHERE MaHDN = ?");
                stm.setString(1, maHDN);
                rs = stm.executeQuery();
                while (rs.next()) {
                    Object[] row = {
                            rs.getString(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getInt(4),
                    };
                    tableHoaDon.addRow(row);
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
        return tableHoaDon;
    }

    public DefaultTableModel getChiTietXuatMaHDX(String maHDX) {
        DefaultTableModel tableHoaDon = new DefaultTableModel();
        Connection conn = getJDBCConnection();
        if (conn != null) {
            PreparedStatement stm = null;
            ResultSet rs = null;
            tableHoaDon.addColumn("Mã sách");
            tableHoaDon.addColumn("Mã HDX");
            tableHoaDon.addColumn("Tên sách");
            tableHoaDon.addColumn("Số lượng");
            tableHoaDon.setRowCount(0);
            try {
                stm = conn.prepareStatement("SELECT * FROM TChitietHDX WHERE MaHDX = ?");
                stm.setString(1, maHDX);
                rs = stm.executeQuery();
                while (rs.next()) {
                    Object[] row = {
                            rs.getString(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getInt(4),
                    };
                    tableHoaDon.addRow(row);
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
        return tableHoaDon;
    }
}
