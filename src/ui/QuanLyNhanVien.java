package ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import connect.ConnectNhanVien;
import entity.NhanVien;
import entity.Sach;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class QuanLyNhanVien extends JPanel implements ActionListener {
    private JLabel title;
    private BufferedImage title_image;
    private JPanel panelALl;
    private JPanel themNhanVienPanel;
    private JPanel xoaNhanVienPanel;
    private JPanel suaNhanVienPanel;
    private JPanel hienThiNhanVienPanel;
    private JPanel timKiemPanel;
    private CardLayout cardLayout = new CardLayout();
    private JButton themNhanVien;
    private JButton suaNhanVien;
    private JButton xoaNhanVien;
    private JButton nhapLai;
    private JButton hienThiNhanVien;
    private JButton timKiem;
    private JButton exit;
    private ImageIcon themNhanVienIcon;
    private ImageIcon suaNhanVienIcon;
    private ImageIcon xoaNhanVienIcon;
    private ImageIcon hienThiNhanVienIcon;
    private ImageIcon timKiemIcon;
    private JLabel maNV;
    private JLabel tenNV;
    private JLabel ngayBatDauHopDong;
    private JLabel soNamHopDong;
    private JLabel heSoLuong;
    private JLabel gioiTinh;
    private JLabel tuoi;
    private JLabel luong;
    private JLabel maQuanLy;
    private JTextField maNVField;
    private JTextField tenNVField;
    private JComboBox gioiTinhComboBox;
    private JTextField diaChiField;
    private JTextField ngayBatDauHopDongField;
    private JTextField soNamHopDongField;
    private JTextField heSoLuongField;
    private JTextField tuoiField;
    private JTextField luongField;
    private BufferedImage maNhanVienImage;
    private BufferedImage tenNhanVienImage;
    private BufferedImage maNXBImage;
    private BufferedImage tacGiaImage;
    private BufferedImage giaBanImage;
    private BufferedImage discountImage;
    private JTable table;
    private JLabel diaChi;
    private ConnectNhanVien connectNhanVien;
    private String column_name = "MaNhanVien";

    public QuanLyNhanVien() {
        connectNhanVien = new ConnectNhanVien();
        this.setLayout(null);
        this.setPreferredSize(new Dimension(1050, 700));
        try {
            title_image = ImageIO.read(new File("resources/images/nhanvien.png"));
            themNhanVienIcon = new ImageIcon("resources/images/add_book_25px.png");
            suaNhanVienIcon = new ImageIcon("resources/images/book_and_pencil_25px.png");
            xoaNhanVienIcon = new ImageIcon("resources/images/remove_book_25px.png");
            hienThiNhanVienIcon = new ImageIcon("resources/images/book_reading_25px.png");
            timKiemIcon = new ImageIcon("resources/images/search_25px.png");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        initPanelAll();
        // --------
        title = new JLabel("Quản lý nhân viên");
        title.setFont(new Font("", Font.PLAIN, 20));
        title.setBounds(60, 10, 180, 40);
        this.add(title);
        hienThiNhanVien = new JButton("Cập nhật");
        hienThiNhanVien.setBackground(new Color(75, 184, 158));
        hienThiNhanVien.setIcon(hienThiNhanVienIcon);
        hienThiNhanVien.setFocusPainted(false);
        hienThiNhanVien.setForeground(Color.WHITE);
        hienThiNhanVien.setFont(new Font("", Font.PLAIN, 16));
        hienThiNhanVien.setBounds(630, 20, 140, 30);
        this.add(hienThiNhanVien);
        timKiem = new JButton("Tìm Kiếm");
        timKiem.setBackground(Color.GRAY);
        timKiem.setIcon(timKiemIcon);
        timKiem.setFocusPainted(false);
        timKiem.setForeground(Color.WHITE);
        timKiem.setFont(new Font("", Font.PLAIN, 16));
        timKiem.setBounds(770, 20, 140, 30);
        this.add(timKiem);
        exit = new JButton("Exit");
        exit.setBackground(Color.GRAY);
        exit.setFocusPainted(false);
        exit.setForeground(Color.WHITE);
        exit.setFont(new Font("", Font.PLAIN, 16));
        exit.setBounds(910, 20, 140, 30);
        this.add(exit);
        timKiem.addActionListener(this);
        exit.addActionListener(this);
        hienThiNhanVien.addActionListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        super.paintComponent(g2d);
        g2d.drawImage(title_image, 20, 10, 38, 38, this);
        g2d.setColor(Color.BLACK);
        g2d.drawLine(0, 50, 1050, 70);
        g2d.drawLine(200, 70, 200, 700);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == timKiem) {
            timKiem.setBackground(new Color(75, 184, 158));
            cardLayout.show(panelALl, "timkiem");
            hienThiNhanVien.setBackground(Color.GRAY);
        } else if (e.getSource() == exit) {
            Menu.cardLayout.show(Menu.panelCardLayout, "menu");
        } else if (e.getSource() == hienThiNhanVien) {
            hienThiNhanVien.setBackground(new Color(75, 184, 158));
            cardLayout.show(panelALl, "themNhanVien");
            timKiem.setBackground(Color.GRAY);
        }
    }

    public void initPanelAll() {
        panelALl = new JPanel();
        panelALl.setLayout(cardLayout);
        panelALl.setBounds(0, 50, 1050, 650);
        initPanelThemNhanVien();
        initPanelTimKiemNhanVien();
        panelALl.add(themNhanVienPanel, "themNhanVien");
        panelALl.add(timKiemPanel, "timkiem");
        this.add(panelALl);
    }

    public void initPanelThemNhanVien() {
        try {
            maNhanVienImage = ImageIO.read(new File("resources/images/repository_28px.png"));
            tenNhanVienImage = ImageIO.read(new File("resources/images/cbz_28px.png"));
            maNXBImage = ImageIO.read(new File("resources/images/link_28px.png"));
            tacGiaImage = ImageIO.read(new File("resources/images/customer_28px.png"));
            giaBanImage = ImageIO.read(new File("resources/images/Banknotes_28px.png"));
            discountImage = ImageIO.read(new File("resources/images/discount_28px.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        themNhanVienPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                super.paintComponent(g2d);
                g.drawImage(maNhanVienImage, 10, 10, 25, 25, themNhanVienPanel);
                g.drawImage(tenNhanVienImage, 370, 10, 25, 25, themNhanVienPanel);
                g.drawImage(maNXBImage, 10, 50, 25, 25, themNhanVienPanel);
                g.drawImage(tacGiaImage, 370, 50, 25, 25, themNhanVienPanel);
                g.drawImage(giaBanImage, 700, 10, 25, 25, themNhanVienPanel);
                g.drawImage(discountImage, 700, 90, 25, 25, themNhanVienPanel);
            }
        };
        themNhanVienPanel.setBounds(0, 50, 1050, 650);
        themNhanVienPanel.setBackground(new Color(55, 55, 55));
        themNhanVienPanel.setLayout(null);
        maNV = new JLabel("Mã NV");
        maNV.setForeground(Color.WHITE);
        maNV.setFont(new Font("", Font.PLAIN, 16));
        maNV.setBounds(40, 10, 80, 30);
        themNhanVienPanel.add(maNV);
        maNVField = new JTextField();
        maNVField.setBounds(120, 10, 200, 30);
        themNhanVienPanel.add(maNVField);

        tenNV = new JLabel("Tên NV");
        tenNV.setForeground(Color.WHITE);
        tenNV.setFont(new Font("", Font.PLAIN, 16));
        tenNV.setBounds(400, 10, 80, 30);
        themNhanVienPanel.add(tenNV);
        tenNVField = new JTextField();
        tenNVField.setBounds(460, 10, 200, 30);
        themNhanVienPanel.add(tenNVField);
        ngayBatDauHopDong = new JLabel("Ngày BĐHĐ");
        ngayBatDauHopDong.setForeground(Color.WHITE);
        ngayBatDauHopDong.setFont(new Font("", Font.PLAIN, 15));
        ngayBatDauHopDong.setBounds(40, 50, 80, 30);
        themNhanVienPanel.add(ngayBatDauHopDong);
        ngayBatDauHopDongField = new JTextField();
        ngayBatDauHopDongField.setBounds(120, 50, 200, 30);
        themNhanVienPanel.add(ngayBatDauHopDongField);
        //
        soNamHopDong = new JLabel("Số năm HĐ");
        soNamHopDong.setForeground(Color.WHITE);
        soNamHopDong.setFont(new Font("", Font.PLAIN, 15));
        soNamHopDong.setBounds(40, 90, 80, 30);
        themNhanVienPanel.add(soNamHopDong);
        soNamHopDongField = new JTextField();
        soNamHopDongField.setBounds(120, 90, 200, 30);
        themNhanVienPanel.add(soNamHopDongField);
        //
        tuoi = new JLabel("Tuổi");
        tuoi.setForeground(Color.WHITE);
        tuoi.setFont(new Font("", Font.PLAIN, 16));
        tuoi.setBounds(406, 90, 80, 30);
        themNhanVienPanel.add(tuoi);
        tuoiField = new JTextField();
        tuoiField.setBounds(460, 90, 200, 30);
        themNhanVienPanel.add(tuoiField);
        luong = new JLabel("Lương");
        luong.setForeground(Color.WHITE);
        luong.setFont(new Font("", Font.PLAIN, 16));
        luong.setBounds(730, 10, 80, 30);
        themNhanVienPanel.add(luong);
        luongField = new JTextField();
        luongField.setBounds(820, 10, 200, 30);
        themNhanVienPanel.add(luongField);
        //
        diaChi = new JLabel("Địa chỉ");
        diaChi.setForeground(Color.WHITE);
        diaChi.setFont(new Font("", Font.PLAIN, 16));
        diaChi.setBounds(730, 50, 80, 30);
        themNhanVienPanel.add(diaChi);
        diaChiField = new JTextField();
        diaChiField.setBounds(820, 50, 200, 30);
        themNhanVienPanel.add(diaChiField);
        //
        heSoLuong = new JLabel("Hệ số lương");
        heSoLuong.setForeground(Color.WHITE);
        heSoLuong.setFont(new Font("", Font.PLAIN, 15));
        heSoLuong.setBounds(730, 90, 100, 30);
        themNhanVienPanel.add(heSoLuong);
        heSoLuongField = new JTextField();
        heSoLuongField.setBounds(820, 90, 200, 30);
        themNhanVienPanel.add(heSoLuongField);
        //
        gioiTinh = new JLabel("Giới tính");
        gioiTinh.setForeground(Color.WHITE);
        gioiTinh.setFont(new Font("", Font.PLAIN, 16));
        gioiTinh.setBounds(400, 50, 80, 30);
        themNhanVienPanel.add(gioiTinh);
        String[] options = { "Nam", "Nữ" };
        gioiTinhComboBox = new JComboBox(options);
        gioiTinhComboBox.setBounds(460, 50, 200, 30);
        themNhanVienPanel.add(gioiTinhComboBox);

        JLabel chucVu = new JLabel("Chức vụ");
        chucVu.setForeground(Color.WHITE);
        chucVu.setFont(new Font("", Font.PLAIN, 16));
        chucVu.setBounds(40, 130, 80, 30);
        themNhanVienPanel.add(chucVu);
        String[] optionsv2 = { "Nhân Viên", "Quản Lí" };
        JComboBox chucVuComboBox = new JComboBox(optionsv2);
        chucVuComboBox.setBounds(120, 130, 200, 30);
        themNhanVienPanel.add(chucVuComboBox);

        JLabel soNgayNghiPhep = new JLabel("Nghỉ phép");
        soNgayNghiPhep.setForeground(Color.WHITE);
        soNgayNghiPhep.setFont(new Font("", Font.PLAIN, 15));
        soNgayNghiPhep.setBounds(392, 130, 80, 30);
        themNhanVienPanel.add(soNgayNghiPhep);
        JTextField soNgayNghiPhepField = new JTextField();
        soNgayNghiPhepField.setBounds(460, 130, 200, 30);
        themNhanVienPanel.add(soNgayNghiPhepField);

        JLabel maQuanLi = new JLabel("Mã quản lí");
        maQuanLi.setForeground(Color.WHITE);
        maQuanLi.setFont(new Font("", Font.PLAIN, 15));
        maQuanLi.setBounds(730, 130, 80, 30);
        themNhanVienPanel.add(maQuanLi);
        JTextField maQuanLiField = new JTextField();
        maQuanLiField.setBounds(820, 130, 200, 30);
        themNhanVienPanel.add(maQuanLiField);

        themNhanVien = new JButton("Thêm NV");
        themNhanVien.setBackground(new Color(94, 201, 77));
        themNhanVien.setIcon(themNhanVienIcon);
        themNhanVien.setFocusPainted(false);
        themNhanVien.setForeground(Color.WHITE);
        themNhanVien.setFont(new Font("", Font.PLAIN, 16));
        themNhanVien.setBounds(490, 170, 140, 30);
        themNhanVienPanel.add(themNhanVien);

        suaNhanVien = new JButton("Sửa NV");
        suaNhanVien.setBackground(new Color(197, 192, 60));
        suaNhanVien.setIcon(suaNhanVienIcon);
        suaNhanVien.setFocusPainted(false);
        suaNhanVien.setForeground(Color.WHITE);
        suaNhanVien.setFont(new Font("", Font.PLAIN, 16));
        suaNhanVien.setBounds(630, 170, 140, 30);
        themNhanVienPanel.add(suaNhanVien);
        xoaNhanVien = new JButton("Xoá NV");
        xoaNhanVien.setBackground(new Color(176, 42, 42));
        xoaNhanVien.setIcon(xoaNhanVienIcon);
        xoaNhanVien.setFocusPainted(false);
        xoaNhanVien.setForeground(Color.WHITE);
        xoaNhanVien.setFont(new Font("", Font.PLAIN, 16));
        xoaNhanVien.setBounds(770, 170, 140, 30);
        themNhanVienPanel.add(xoaNhanVien);
        nhapLai = new JButton("Nhập lại");
        nhapLai.setBackground(new Color(44, 117, 161));
        nhapLai.setFocusPainted(false);
        nhapLai.setForeground(Color.WHITE);
        nhapLai.setFont(new Font("", Font.PLAIN, 16));
        nhapLai.setBounds(910, 170, 140, 30);
        themNhanVienPanel.add(nhapLai);
        themNhanVien.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String _maNhanVien = maNVField.getText();
                String _tenNhanVien = tenNVField.getText();
                String _gioitinh = (String) gioiTinhComboBox.getSelectedItem().toString();
                String _tuoi = tuoiField.getText();
                String _ngayBatDauHopDong = ngayBatDauHopDongField.getText();
                String _soNamHopDong = soNamHopDongField.getText();
                String _luong = luongField.getText();
                String _heSoLuong = heSoLuongField.getText();
                String _diachi = diaChiField.getText();
                String _ngaykihopdong = ngayBatDauHopDongField.getText();
                String _chucvu = (String) chucVuComboBox.getSelectedItem().toString();
                String _maQuanLi = (String) maQuanLiField.getText();
                String _soNgayNghiPhep = (String) soNgayNghiPhepField.getText();
                if (_maNhanVien.isEmpty() || _tenNhanVien.isEmpty() || _tuoi.isEmpty() || _ngayBatDauHopDong.isEmpty()
                        || _luong.isEmpty() || _soNamHopDong.isEmpty() || _diachi.isEmpty() || _chucvu.isEmpty()
                        || _ngaykihopdong.isEmpty() || _maQuanLi.isEmpty() || _soNgayNghiPhep.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin!", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    double _luongValue = Double.parseDouble(_luong);
                    double _heSoLuongValue = Double.parseDouble(_heSoLuong);
                    int _soNamHopDongValue = Integer.parseInt(_soNamHopDong);
                    int _tuoiValue = Integer.parseInt(_tuoi);
                    int _songaynghiphep = Integer.parseInt(_soNgayNghiPhep);
                    // luu vao sql
                    if (!connectNhanVien.checkMaNhanVien(_maNhanVien)) {
                        connectNhanVien.themNhanVienMoi(new NhanVien(_maNhanVien, _tenNhanVien,
                                _ngayBatDauHopDong, _soNamHopDongValue, _heSoLuongValue, _gioitinh, _songaynghiphep,
                                "KV01",
                                _tuoiValue, _luongValue, _maQuanLi, _diachi, _chucvu));
                        table.setModel(connectNhanVien.getAllNhanVien());
                        JOptionPane.showMessageDialog(null, "Nhân viên đã được thêm thành công!", "Thông báo",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Mã nhân viên phải khác nhau!", "Thông báo",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Luong, tuoi, he so luong giá phải là số!", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        table = new JTable(connectNhanVien.getAllNhanVien());
        table.setDefaultEditor(Object.class, null);
        table.setAutoCreateRowSorter(true);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 200, 1050, 500);
        themNhanVienPanel.add(scrollPane);
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent ex) {
                super.mouseClicked(ex);
                int row = table.getSelectedRow();
                maNVField.setText(table.getValueAt(row, 0).toString());
                tenNVField.setText(table.getValueAt(row, 1).toString());
                gioiTinhComboBox.setSelectedItem(table.getValueAt(row, 2).toString());
                luongField.setText(table.getValueAt(row, 3).toString());
                if (table.getValueAt(row, 4) != null) {
                    maQuanLiField.setText(table.getValueAt(row, 4).toString());
                } else {
                    maQuanLiField.setText("");
                }
                soNgayNghiPhepField.setText(table.getValueAt(row, 8).toString());
                tuoiField.setText(table.getValueAt(row, 5).toString());
                ngayBatDauHopDongField.setText(table.getValueAt(row, 6).toString());
                soNamHopDongField.setText(table.getValueAt(row, 7).toString());
                diaChiField.setText(table.getValueAt(row, 9).toString());
                heSoLuongField.setText(table.getValueAt(row, 10).toString());
                chucVuComboBox.setSelectedItem(table.getValueAt(row, 11).toString());
            }
        });

        suaNhanVien.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String _maNhanVien = maNVField.getText();
                String _tenNhanVien = tenNVField.getText();
                String _gioitinh = (String) gioiTinhComboBox.getSelectedItem().toString();
                String _tuoi = tuoiField.getText();
                String _ngayBatDauHopDong = ngayBatDauHopDongField.getText();
                String _soNamHopDong = soNamHopDongField.getText();
                String _luong = luongField.getText();
                String _heSoLuong = heSoLuongField.getText();
                String _diachi = diaChiField.getText();
                String _ngaykihopdong = ngayBatDauHopDongField.getText();
                String _chucvu = (String) chucVuComboBox.getSelectedItem().toString();
                String _maQuanLi = (String) maQuanLiField.getText();
                String _soNgayNghiPhep = (String) soNgayNghiPhepField.getText();
                if (_maNhanVien.isEmpty() || _tenNhanVien.isEmpty() || _tuoi.isEmpty() || _ngayBatDauHopDong.isEmpty()
                        || _luong.isEmpty() || _soNamHopDong.isEmpty() || _diachi.isEmpty() || _chucvu.isEmpty()
                        || _ngaykihopdong.isEmpty() || _maQuanLi.isEmpty() || _soNgayNghiPhep.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin!", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try {
                    double _luongValue = Double.parseDouble(_luong);
                    double _heSoLuongValue = Double.parseDouble(_heSoLuong);
                    int _soNamHopDongValue = Integer.parseInt(_soNamHopDong);
                    int _tuoiValue = Integer.parseInt(_tuoi);
                    int _songaynghiphep = Integer.parseInt(_soNgayNghiPhep);
                    // luu vao sql
                    if (connectNhanVien.checkMaNhanVien(_maNhanVien)) {
                        connectNhanVien.suaNhanVien(new NhanVien(_maNhanVien, _tenNhanVien,
                                _ngayBatDauHopDong, _soNamHopDongValue, _heSoLuongValue, _gioitinh, _songaynghiphep,
                                "KV01",
                                _tuoiValue, _luongValue, _maQuanLi, _diachi, _chucvu));
                        table.setModel(connectNhanVien.getAllNhanVien());
                        JOptionPane.showMessageDialog(null, "Nhân viên đã được sửa thành công!", "Thông báo",
                                JOptionPane.INFORMATION_MESSAGE);

                    } else {
                        JOptionPane.showMessageDialog(null, "Nhân viên không tồn tại!", "Thông báo",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Luong, tuoi, he so luong giá phải là số!", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        xoaNhanVien.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String _maNhanVien = maNVField.getText();
                String _tenNhanVien = tenNVField.getText();
                String _gioitinh = (String) gioiTinhComboBox.getSelectedItem().toString();
                String _tuoi = tuoiField.getText();
                String _ngayBatDauHopDong = ngayBatDauHopDongField.getText();
                String _soNamHopDong = soNamHopDongField.getText();
                String _luong = luongField.getText();
                String _heSoLuong = heSoLuongField.getText();
                String _diachi = diaChiField.getText();
                String _ngaykihopdong = ngayBatDauHopDongField.getText();
                String _chucvu = (String) chucVuComboBox.getSelectedItem().toString();
                String _maQuanLi = (String) maQuanLiField.getText();
                String _soNgayNghiPhep = (String) soNgayNghiPhepField.getText();
                if (_maNhanVien.isEmpty() || _tenNhanVien.isEmpty() || _tuoi.isEmpty() || _ngayBatDauHopDong.isEmpty()
                        || _luong.isEmpty() || _soNamHopDong.isEmpty() || _diachi.isEmpty() || _chucvu.isEmpty()
                        || _ngaykihopdong.isEmpty() || _maQuanLi.isEmpty() || _soNgayNghiPhep.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin!", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    double _luongValue = Double.parseDouble(_luong);
                    double _heSoLuongValue = Double.parseDouble(_heSoLuong);
                    int _soNamHopDongValue = Integer.parseInt(_soNamHopDong);
                    int _tuoiValue = Integer.parseInt(_tuoi);
                    int _songaynghiphep = Integer.parseInt(_soNgayNghiPhep);
                    if (connectNhanVien.checkMaNhanVien(_maNhanVien)) {
                        if (connectNhanVien.checkMaNhanVienHoaDonNhap(_maNhanVien)
                                || connectNhanVien.checkMaNhanVienHoaDonXuat(_maNhanVien)) {
                            JOptionPane.showMessageDialog(null,
                                    "Nhân viên có trong bảng hoá đơn nên không xoá được!",
                                    "Thông báo",
                                    JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            connectNhanVien.xoaNhanVien(_maNhanVien);
                            table.setModel(connectNhanVien.getAllNhanVien());
                            JOptionPane.showMessageDialog(null, "Nhân viên đã được xoá thành công!", "Thông báo",
                                    JOptionPane.INFORMATION_MESSAGE);
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Nhân viên không tồn tại!", "Thông báo",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Luong, tuoi, he so luong giá phải là số!", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        nhapLai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                maNVField.setText("");
                tenNVField.setText("");
                gioiTinhComboBox.setSelectedItem(0);
                tuoiField.setText("");
                ngayBatDauHopDongField.setText("");
                soNamHopDongField.setText("");
                luongField.setText("");
                heSoLuongField.setText("");
                diaChiField.setText("");
                soNgayNghiPhepField.setText("");
                ngayBatDauHopDongField.setText("");
                chucVuComboBox.setSelectedItem(0);
                maQuanLiField.setText("");
            }
        });
    }

    public void initPanelTimKiemNhanVien() {
        timKiemPanel = new JPanel();
        timKiemPanel.setLayout(null);
        timKiemPanel.setBounds(210, 80, 850, 630);
        timKiemPanel.setBackground(new Color(55, 55, 55));

        JTable tableTimKiemNhanVien = new JTable(connectNhanVien.getAllNhanVien());
        tableTimKiemNhanVien.setDefaultEditor(Object.class, null);
        JScrollPane scrollPane = new JScrollPane(tableTimKiemNhanVien);
        scrollPane.setBounds(0, 60, 1050, 570);
        timKiemPanel.add(scrollPane);
        String[] options = { "Mã nhân viên",
                "Tên nhân viên",
                "Giới tính",
                "Lương",
                "Mã quản lí",
                "Tuổi",
                "Ngày kí hợp đồng",
                "Số năm hợp đồng",
                "Số ngày nghỉ phép",
                "Địa chỉ",
                "Hệ số lương",
                "Chức vụ" };
        JComboBox<String> selectOptions = new JComboBox<>(options);
        selectOptions.setBounds(220, 20, 100, 30);
        timKiemPanel.add(selectOptions);
        JTextField timNhanVienField = new JTextField();
        timNhanVienField.setBounds(340, 20, 280, 30);
        timKiemPanel.add(timNhanVienField);
        selectOptions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedOption = selectOptions.getSelectedItem().toString();
                switch (selectedOption) {
                    case "Mã nhân viên":
                        column_name = "MaNhanVien";
                        break;
                    case "Tên nhân viên":
                        column_name = "TenNhanVien";
                        break;
                    case "Giới tính":
                        column_name = "GioiTinh";
                        break;
                    case "Lương":
                        column_name = "LuongCoSo";
                        break;
                    case "Mã quản lí":
                        column_name = "MaQuanLi";
                        break;
                    case "Tuổi":
                        column_name = "Tuoi";
                        break;
                    case "Ngày kí hợp đồng":
                        column_name = "NgayKiHopDong";
                        break;
                    case "Số năm hợp đồng":
                        column_name = "SoNamHopDong";
                        break;
                    case "Số ngày nghỉ phép":
                        column_name = "SoNgayNghiPhep";
                        break;
                    case "Địa chỉ":
                        column_name = "DiaChi";
                        break;
                    case "Hệ số lương":
                        column_name = "HeSoLuong";
                        break;
                    case "Chức vụ":
                        column_name = "Chucvu";
                        break;
                }
                String res = timNhanVienField.getText();
                tableTimKiemNhanVien.setModel(connectNhanVien.timKiem(column_name, res));
            }
        });
        timNhanVienField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String res = timNhanVienField.getText();
                tableTimKiemNhanVien.setModel(connectNhanVien.timKiem(column_name, res));
            }
        });
    }
}
