package ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import connect.ConnectHoaDon;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

import static ui.QuanLySach.timKiemIcon;

public class QuanLyHoaDon extends JPanel implements ActionListener {
    private JLabel title;
    private BufferedImage title_image;
    private JLabel month;
    private JComboBox<String> selectOptionsNhap;
    private JComboBox<String> selectOptionsXuat;
    private JTable tableHoaDonNhap;
    private JTable tableChiTietNhap;
    private JTable tableHoaDonXuat;
    private JTable tableChiTietXuat;
    private JButton hoaDonNhap;
    private JButton hoaDonXuat;
    private JPanel panelHoaDonNhap;
    private JPanel panelHoaDonXuat;
    private CardLayout cardLayout = new CardLayout();
    private JPanel panelCardLayout;
    private ConnectHoaDon connectHoaDon;
    private JPanel panelBarNhap;
    private JPanel panelBarXuat;
    private String monthNhap = "1";
    private String monthXuat = "1";

    public QuanLyHoaDon() {
        connectHoaDon = new ConnectHoaDon();
        this.setPreferredSize(new Dimension(1050, 700));
        this.setLayout(null);
        try {
            title_image = ImageIO.read(new File("resources/images/edit.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        title = new JLabel("Quản Lý Hoá Đơn");
        title.setFont(new Font("", Font.PLAIN, 20));
        title.setBounds(60, 20, 200, 40);
        this.add(title);
        hoaDonNhap = new JButton("Hoá đơn nhập");
        hoaDonNhap.setBackground(Color.GRAY);
        hoaDonNhap.setFocusPainted(false);
        hoaDonNhap.setForeground(Color.WHITE);
        hoaDonNhap.setFont(new Font("", Font.PLAIN, 16));
        hoaDonNhap.setBounds(400, 40, 140, 30);
        this.add(hoaDonNhap);
        hoaDonXuat = new JButton("Hoá đơn xuất");
        hoaDonXuat.setBackground(new Color(75, 184, 158));
        hoaDonXuat.setFocusPainted(false);
        hoaDonXuat.setForeground(Color.WHITE);
        hoaDonXuat.setFont(new Font("", Font.PLAIN, 16));
        hoaDonXuat.setBounds(260, 40, 140, 30);
        this.add(hoaDonXuat);
        hoaDonNhap.addActionListener(this);
        hoaDonXuat.addActionListener(this);
        panelCardLayout = new JPanel();
        panelCardLayout.setLayout(cardLayout);
        panelCardLayout.setBounds(0, 70, 1050, 630);
        initHoaDonNhap();
        initHoaDonXuat();
        panelCardLayout.add(panelHoaDonXuat, "xuat");
        panelCardLayout.add(panelHoaDonNhap, "nhap");
        this.add(panelCardLayout);
    }

    public void initHoaDonNhap() {
        panelHoaDonNhap = new JPanel();
        panelHoaDonNhap.setLayout(null);
        panelHoaDonNhap.setBounds(0, 70, 1050, 580);

        tableHoaDonNhap = new JTable(connectHoaDon.getAllHoaDonNhap());
        JScrollPane scrollPane = new JScrollPane(tableHoaDonNhap);
        scrollPane.setBounds(0, 70, 598, 580);
        panelHoaDonNhap.add(scrollPane);
        Object[][] row = {
        };
        Object[] col = {};
        tableChiTietNhap = new JTable(new DefaultTableModel(row, col));
        JScrollPane scrollPanev2 = new JScrollPane(tableChiTietNhap);
        scrollPanev2.setBounds(600, 70, 450, 580);
        panelHoaDonNhap.add(scrollPanev2);
        JLabel dshd = new JLabel("Danh sách hoá đơn");
        dshd.setForeground(new Color(40, 144, 189, 255));
        dshd.setFont(new Font("", Font.PLAIN, 14));
        dshd.setBounds(10, 50, 300, 20);
        panelHoaDonNhap.add(dshd);
        JLabel chiTietdshd = new JLabel("Chi tiết hoá đơn");
        chiTietdshd.setForeground(new Color(40, 144, 189, 255));
        chiTietdshd.setFont(new Font("", Font.PLAIN, 14));
        chiTietdshd.setBounds(610, 50, 300, 20);
        panelHoaDonNhap.add(chiTietdshd);
        tableHoaDonNhap.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent ex) {
                super.mouseClicked(ex);
                int row = tableHoaDonNhap.getSelectedRow();
                String res = tableHoaDonNhap.getValueAt(row, 0).toString();
                tableChiTietNhap.setModel(connectHoaDon.getChiTietNhapMaHDN(res));
            }
        });
        initpanelBarNhap();
    }

    public void XuatFileExcel(DefaultTableModel dtm) {
        try {
            TableModel model = dtm;
            Workbook workbook = new HSSFWorkbook();
            Sheet sheet = workbook.createSheet("Hoa Don");

            // Ghi tiêu đề cột
            Row headerRow = sheet.createRow(0);
            for (int col = 0; col < model.getColumnCount(); col++) {
                Cell cell = headerRow.createCell(col);
                cell.setCellValue(model.getColumnName(col));
            }

            // Ghi dữ liệu từ JTable vào Sheet
            for (int row = 0; row < model.getRowCount(); row++) {
                Row sheetRow = sheet.createRow(row + 1);
                for (int col = 0; col < model.getColumnCount(); col++) {
                    Object value = model.getValueAt(row, col);
                    Cell cell = sheetRow.createCell(col);

                    // Xác định kiểu dữ liệu của ô dữ liệu
                    if (value instanceof Number)
                        cell.setCellValue(((Number) value).doubleValue());
                    else if (value instanceof String)
                        cell.setCellValue(value.toString());
                    else if (value instanceof java.util.Date) {
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        String formattedDate = sdf.format(value);
                        cell.setCellValue(formattedDate);
                    }
                    else
                        cell.setCellValue(""); // dữ liệu là null
                }
            }

            // Tự động điều chỉnh kích thước các cột trong Excel
            for (int col = 0; col < model.getColumnCount(); col++) {
                sheet.autoSizeColumn(col);
            }
            // tạo file .xls
            FileOutputStream outputStream = new FileOutputStream("C:/Test/hoadon.xls");
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
            // mở file pdf đó ra
            File pdfFile = new File("C:/Test/hoadon.xls");
            if (pdfFile.exists()) {
                if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().open(pdfFile);
                } else {
                    JOptionPane.showMessageDialog(null, "Máy tính không hỗ trợ!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "File không tồn tại!");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void initHoaDonXuat() {
        panelHoaDonXuat = new JPanel();
        panelHoaDonXuat.setLayout(null);
        panelHoaDonXuat.setBounds(0, 70, 1050, 630);

        tableHoaDonXuat = new JTable(connectHoaDon.getAllHoaDonXuat());
        JScrollPane scrollPane = new JScrollPane(tableHoaDonXuat);
        scrollPane.setBounds(0, 70, 598, 580);
        panelHoaDonXuat.add(scrollPane);
        Object[][] row = {
        };
        Object[] col = {};
        tableChiTietXuat = new JTable(new DefaultTableModel(row, col));
        JScrollPane scrollPanev2 = new JScrollPane(tableChiTietXuat);
        scrollPanev2.setBounds(600, 70, 450, 580);
        panelHoaDonXuat.add(scrollPanev2);
        JLabel dshd = new JLabel("Danh sách hoá đơn");
        dshd.setForeground(new Color(40, 144, 189, 255));
        dshd.setFont(new Font("", Font.PLAIN, 14));
        dshd.setBounds(10, 50, 300, 20);
        panelHoaDonXuat.add(dshd);
        JLabel chiTietdshd = new JLabel("Chi tiết hoá đơn");
        chiTietdshd.setForeground(new Color(40, 144, 189, 255));
        chiTietdshd.setFont(new Font("", Font.PLAIN, 14));
        chiTietdshd.setBounds(610, 50, 300, 20);
        panelHoaDonXuat.add(chiTietdshd);
        tableHoaDonXuat.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent ex) {
                super.mouseClicked(ex);
                int row = tableHoaDonXuat.getSelectedRow();
                String res = tableHoaDonXuat.getValueAt(row, 0).toString();
                tableChiTietXuat.setModel(connectHoaDon.getChiTietXuatMaHDX(res));
            }
        });
        initpanelBarXuat();
    }

    public void initpanelBarNhap() {
        panelBarNhap = new JPanel();
        panelBarNhap.setLayout(null);
        panelBarNhap.setBackground(new Color(55, 55, 55));
        panelBarNhap.setBounds(0, 0, 1050, 50);
        panelHoaDonNhap.add(panelBarNhap);
        month = new JLabel("Tháng:");
        month.setForeground(Color.WHITE);
        month.setFont(new Font("", Font.PLAIN, 16));
        month.setBounds(50, 10, 60, 30);
        panelBarNhap.add(month);
        String[] options = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };
        selectOptionsNhap = new JComboBox<>(options);
        selectOptionsNhap.setBounds(100, 10, 60, 30);
        panelBarNhap.add(selectOptionsNhap);

        JLabel year = new JLabel("Năm:");
        year.setForeground(Color.WHITE);
        year.setFont(new Font("", Font.PLAIN, 16));
        year.setBounds(180, 10, 60, 30);
        panelBarNhap.add(year);
        JTextField yearField = new JTextField();
        yearField.setBounds(230, 10, 70, 30);
        panelBarNhap.add(yearField);
        JButton all = new JButton("Tất cả");
        all.setBounds(520, 10, 120, 28);
        all.setBackground(new Color(55, 160, 206));
        all.setFocusPainted(false);
        all.setForeground(Color.WHITE);
        all.setFont(new Font("", Font.PLAIN, 16));
        panelBarNhap.add(all);
        JButton search = new JButton("Tìm kiếm");
        search.setIcon(timKiemIcon);
        search.setBounds(320, 10, 130, 28);
        search.setBackground(new Color(70, 180, 26));
        search.setFocusPainted(false);
        search.setForeground(Color.WHITE);
        search.setFont(new Font("", Font.PLAIN, 15));
        panelBarNhap.add(search);
        JButton today = new JButton("Hôm nay");
        today.setBounds(650, 10, 120, 28);
        today.setBackground(new Color(39, 96, 131, 231));
        today.setFocusPainted(false);
        today.setForeground(Color.WHITE);
        today.setFont(new Font("", Font.PLAIN, 16));
        panelBarNhap.add(today);
        JButton xuatExcel = new JButton("Xuất Excel");
        xuatExcel.setBounds(780, 10, 120, 28);
        xuatExcel.setBackground(new Color(75, 184, 158, 255));
        xuatExcel.setFocusPainted(false);
        xuatExcel.setForeground(Color.WHITE);
        xuatExcel.setFont(new Font("", Font.PLAIN, 16));
        panelBarNhap.add(xuatExcel);
        JButton exit = new JButton("Exit");
        exit.setBounds(970, 10, 80, 28);
        exit.setBackground(new Color(44, 140, 102, 153));
        exit.setFocusPainted(false);
        exit.setForeground(Color.WHITE);
        exit.setFont(new Font("", Font.PLAIN, 16));
        panelBarNhap.add(exit);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu.cardLayout.show(Menu.panelCardLayout, "menu");
            }
        });
        today.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableHoaDonNhap.setModel(connectHoaDon.getHoaDonNhapHomNay());
            }
        });
        all.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableHoaDonNhap.setModel(connectHoaDon.getAllHoaDonNhap());
                tableChiTietNhap.setModel(connectHoaDon.getAllChiTietNhap());
            }
        });
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String year_string = yearField.getText();
                if (year_string.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ!", "Error",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    tableHoaDonNhap.setModel(connectHoaDon.getHoaDonNhapTheoThangNam(monthNhap, year_string));
                }
            }
        });
        selectOptionsNhap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                monthNhap = (String) selectOptionsNhap.getSelectedItem();
            }
        });
        xuatExcel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int dialogResult = JOptionPane.showConfirmDialog(null, "Xuất file excel?", "Warning",
                        JOptionPane.YES_NO_OPTION);
                if (dialogResult == JOptionPane.YES_OPTION) {
                    XuatFileExcel((DefaultTableModel)tableHoaDonNhap.getModel());
                }
            }
        });
    }

    public void initpanelBarXuat() {
        panelBarXuat = new JPanel();
        panelBarXuat.setLayout(null);
        panelBarXuat.setBackground(new Color(55, 55, 55));
        panelBarXuat.setBounds(0, 0, 1050, 50);
        panelHoaDonXuat.add(panelBarXuat);
        month = new JLabel("Tháng:");
        month.setForeground(Color.WHITE);
        month.setFont(new Font("", Font.PLAIN, 16));
        month.setBounds(50, 10, 60, 30);
        panelBarXuat.add(month);
        String[] options = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };
        selectOptionsXuat = new JComboBox<>(options);
        selectOptionsXuat.setBounds(100, 10, 60, 30);
        panelBarXuat.add(selectOptionsXuat);

        JLabel year = new JLabel("Năm:");
        year.setForeground(Color.WHITE);
        year.setFont(new Font("", Font.PLAIN, 16));
        year.setBounds(180, 10, 60, 30);
        panelBarXuat.add(year);
        JTextField yearField = new JTextField();
        yearField.setBounds(230, 10, 70, 30);
        panelBarXuat.add(yearField);
        JButton all = new JButton("Tất cả");
        all.setBounds(520, 10, 120, 28);
        all.setBackground(new Color(55, 160, 206));
        all.setFocusPainted(false);
        all.setForeground(Color.WHITE);
        all.setFont(new Font("", Font.PLAIN, 16));
        panelBarXuat.add(all);
        JButton search = new JButton("Tìm kiếm");
        search.setIcon(timKiemIcon);
        search.setBounds(320, 10, 130, 28);
        search.setBackground(new Color(70, 180, 26));
        search.setFocusPainted(false);
        search.setForeground(Color.WHITE);
        search.setFont(new Font("", Font.PLAIN, 15));
        panelBarXuat.add(search);
        JButton today = new JButton("Hôm nay");
        today.setBounds(650, 10, 120, 28);
        today.setBackground(new Color(39, 96, 131, 231));
        today.setFocusPainted(false);
        today.setForeground(Color.WHITE);
        today.setFont(new Font("", Font.PLAIN, 16));
        panelBarXuat.add(today);
        JButton xuatExcel = new JButton("Xuất Excel");
        xuatExcel.setBounds(780, 10, 120, 28);
        xuatExcel.setBackground(new Color(75, 184, 158, 255));
        xuatExcel.setFocusPainted(false);
        xuatExcel.setForeground(Color.WHITE);
        xuatExcel.setFont(new Font("", Font.PLAIN, 16));
        panelBarXuat.add(xuatExcel);
        JButton exit = new JButton("Exit");
        exit.setBounds(970, 10, 80, 28);
        exit.setBackground(new Color(44, 140, 102, 153));
        exit.setFocusPainted(false);
        exit.setForeground(Color.WHITE);
        exit.setFont(new Font("", Font.PLAIN, 16));
        panelBarXuat.add(exit);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu.cardLayout.show(Menu.panelCardLayout, "menu");
            }
        });
        today.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableHoaDonXuat.setModel(connectHoaDon.getHoaDonXuatHomNay());
            }
        });
        all.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableHoaDonXuat.setModel(connectHoaDon.getAllHoaDonXuat());
                tableChiTietXuat.setModel(connectHoaDon.getAllChiTietXuat());
            }
        });
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String year_string = yearField.getText();
                if (year_string.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ!", "Error",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    tableHoaDonXuat.setModel(connectHoaDon.getHoaDonXuatTheoThangNam(monthXuat, year_string));
                }
            }
        });
        selectOptionsXuat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                monthXuat = (String) selectOptionsXuat.getSelectedItem();
            }
        });
        xuatExcel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int dialogResult = JOptionPane.showConfirmDialog(null, "Xuất file excel?", "Warning",
                        JOptionPane.YES_NO_OPTION);
                if (dialogResult == JOptionPane.YES_OPTION) {
                    XuatFileExcel((DefaultTableModel)tableHoaDonXuat.getModel());
                }

            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        super.paintComponent(g2d);
        g.drawImage(title_image, 20, 20, 38, 38, this);
        g2d.setColor(Color.BLACK);
        g2d.drawLine(0, 70, 1050, 70);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == hoaDonNhap) {
            hoaDonNhap.setBackground(new Color(75, 184, 158));
            hoaDonXuat.setBackground(Color.GRAY);
            cardLayout.show(panelCardLayout, "nhap");
        } else if (e.getSource() == hoaDonXuat) {
            hoaDonXuat.setBackground(new Color(75, 184, 158));
            hoaDonNhap.setBackground(Color.GRAY);
            cardLayout.show(panelCardLayout, "xuat");
        }
    }
}
