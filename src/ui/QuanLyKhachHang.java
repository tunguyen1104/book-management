package ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import connect.ConnectKhachHang;
import entity.KhachHang;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class QuanLyKhachHang extends JPanel {
    private JLabel title;
    private BufferedImage title_image;
    private JPanel panelTimKiem;
    private JPanel panelThemSuaXoa;
    private JTable table;
    private JLabel maKhachHang;
    private JLabel name;
    private JLabel phone;
    private JLabel email;
    private JLabel tichDiem;
    private JLabel diaChi;
    private JTextField maKhachHangField;
    private JTextField nameField;
    private JTextField phoneField;
    private JTextField emailField;
    private JTextField tichDiemField;
    private JTextField diaChiField;
    private JButton exit;
    private ConnectKhachHang connectKhachHang;

    public QuanLyKhachHang() {
        connectKhachHang = new ConnectKhachHang();
        this.setPreferredSize(new Dimension(1050, 700));
        this.setLayout(null);
        try {
            title_image = ImageIO.read(new File("resources/images/customer_40px.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        title = new JLabel("Quản Lý Khách Hàng");
        title.setFont(new Font("", Font.PLAIN, 20));
        title.setBounds(60, 10, 200, 40);
        this.add(title);
        exit = new JButton("Exit");
        exit.setBounds(970, 20, 80, 30);
        exit.setBackground(new Color(44, 140, 102, 153));
        exit.setFocusPainted(false);
        exit.setForeground(Color.WHITE);
        exit.setFont(new Font("", Font.PLAIN, 16));
        this.add(exit);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu.cardLayout.show(Menu.panelCardLayout, "menu");
            }
        });
        table = new JTable(connectKhachHang.getAllKhachHang());
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 300, 1050, 400);
        this.add(scrollPane);
        initPanelThemSuaXoa();
        initPanelTimKiem();

    }

    public void initPanelThemSuaXoa() {
        panelThemSuaXoa = new JPanel();
        panelThemSuaXoa.setLayout(null);
        panelThemSuaXoa.setBounds(360, 50, 690, 250);
        panelThemSuaXoa.setBackground(new Color(39, 96, 131, 231));
        this.add(panelThemSuaXoa);
        maKhachHang = new JLabel("Mã KH");
        maKhachHang.setForeground(Color.WHITE);
        maKhachHang.setFont(new Font("", Font.PLAIN, 16));
        maKhachHang.setBounds(20, 10, 60, 30);
        panelThemSuaXoa.add(maKhachHang);
        maKhachHangField = new JTextField();
        maKhachHangField.setBounds(100, 10, 200, 30);
        panelThemSuaXoa.add(maKhachHangField);

        name = new JLabel("Tên KH");
        name.setForeground(Color.WHITE);
        name.setFont(new Font("", Font.PLAIN, 16));
        name.setBounds(340, 10, 80, 30);
        panelThemSuaXoa.add(name);
        nameField = new JTextField();
        nameField.setBounds(420, 10, 200, 30);
        panelThemSuaXoa.add(nameField);
        phone = new JLabel("SĐT");
        phone.setForeground(Color.WHITE);
        phone.setFont(new Font("", Font.PLAIN, 16));
        phone.setBounds(20, 60, 80, 30);
        panelThemSuaXoa.add(phone);
        phoneField = new JTextField();
        phoneField.setBounds(100, 60, 200, 30);
        panelThemSuaXoa.add(phoneField);
        email = new JLabel("Email");
        email.setForeground(Color.WHITE);
        email.setFont(new Font("", Font.PLAIN, 16));
        email.setBounds(340, 60, 80, 30);
        panelThemSuaXoa.add(email);
        emailField = new JTextField();
        emailField.setBounds(420, 60, 200, 30);
        panelThemSuaXoa.add(emailField);
        //
        tichDiem = new JLabel("Tích điểm");
        tichDiem.setForeground(Color.WHITE);
        tichDiem.setFont(new Font("", Font.PLAIN, 16));
        tichDiem.setBounds(20, 110, 80, 30);
        panelThemSuaXoa.add(tichDiem);
        tichDiemField = new JTextField();
        tichDiemField.setBounds(100, 110, 200, 30);
        panelThemSuaXoa.add(tichDiemField);

        diaChi = new JLabel("Địa chỉ");
        diaChi.setForeground(Color.WHITE);
        diaChi.setFont(new Font("", Font.PLAIN, 16));
        diaChi.setBounds(340, 110, 80, 30);
        panelThemSuaXoa.add(diaChi);
        diaChiField = new JTextField();
        diaChiField.setBounds(420, 110, 200, 30);
        panelThemSuaXoa.add(diaChiField);
        JButton them = new JButton("Thêm");
        them.setBounds(20, 180, 120, 28);
        them.setBackground(new Color(70, 180, 26));
        them.setFocusPainted(false);
        them.setForeground(Color.WHITE);
        them.setFont(new Font("", Font.PLAIN, 16));
        panelThemSuaXoa.add(them);
        JButton sua = new JButton("Sửa");
        sua.setBounds(180, 180, 120, 28);
        sua.setBackground(new Color(197, 192, 60));
        sua.setFocusPainted(false);
        sua.setForeground(Color.WHITE);
        sua.setFont(new Font("", Font.PLAIN, 16));
        panelThemSuaXoa.add(sua);
        JButton xoa = new JButton("Xoá");
        xoa.setBounds(340, 180, 120, 28);
        xoa.setBackground(new Color(176, 42, 42));
        xoa.setFocusPainted(false);
        xoa.setForeground(Color.WHITE);
        xoa.setFont(new Font("", Font.PLAIN, 16));
        panelThemSuaXoa.add(xoa);
        JButton nhapLai = new JButton("Nhập lại");
        nhapLai.setBounds(500, 180, 120, 28);
        nhapLai.setBackground(new Color(40, 144, 189));
        nhapLai.setFocusPainted(false);
        nhapLai.setForeground(Color.WHITE);
        nhapLai.setFont(new Font("", Font.PLAIN, 16));
        panelThemSuaXoa.add(nhapLai);

        // Action Listener
        them.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String _maKhachHang = maKhachHangField.getText();
                String _tenKhachHang = nameField.getText();
                String _phone = phoneField.getText();
                String _email = emailField.getText();
                String _tichDiem = tichDiemField.getText();
                String _diachi = diaChiField.getText();
                if (_maKhachHang.isEmpty() || _tenKhachHang.isEmpty() || _phone.isEmpty() || _email.isEmpty()
                        || _tichDiem.isEmpty() || _diachi.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin!", "Error",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    if (!connectKhachHang.checkMaKhachHang(_maKhachHang)) {
                        connectKhachHang.themKhachHangMoi(new KhachHang(_maKhachHang, _tenKhachHang, _phone,
                                _email, Integer.parseInt(_tichDiem), _diachi));
                        table.setModel(connectKhachHang.getAllKhachHang());
                        JOptionPane.showMessageDialog(null, "Khách hàng đã được thêm thành công!", "Thông báo",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Đã tồn tại mã khách hàng!", "Thông báo",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent ex) {
                int row = table.getSelectedRow();
                maKhachHangField.setText(table.getValueAt(row, 0).toString());
                nameField.setText(table.getValueAt(row, 1).toString());
                phoneField.setText(table.getValueAt(row, 2).toString());
                emailField.setText(table.getValueAt(row, 3).toString());
                tichDiemField.setText(table.getValueAt(row, 4).toString());
                diaChiField.setText(table.getValueAt(row, 5).toString());
            }
        });

        sua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String _maKhachHang = maKhachHangField.getText();
                String _tenKhachHang = nameField.getText();
                String _phone = (String) phoneField.getText();
                String _email = emailField.getText();
                String _tichDiem = tichDiemField.getText();
                String _diachi = diaChiField.getText();
                if (_maKhachHang.isEmpty() || _tenKhachHang.isEmpty() || _phone.isEmpty() || _email.isEmpty()
                        || _tichDiem.isEmpty() || _diachi.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin!", "Error",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    if (connectKhachHang.checkMaKhachHang(_maKhachHang)) {
                        connectKhachHang.suaKhachHang(new KhachHang(_maKhachHang, _tenKhachHang, _phone,
                                _email, Integer.parseInt(_tichDiem), _diachi));
                        table.setModel(connectKhachHang.getAllKhachHang());
                        JOptionPane.showMessageDialog(null, "Khách hàng đã được sửa thành công!", "Thông báo",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Khách hàng không tồn tại!", "Thông báo",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });

        xoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String _maKhachHang = maKhachHangField.getText();
                String _tenKhachHang = nameField.getText();
                String _phone = (String) phoneField.getText();
                String _email = emailField.getText();
                String _tichDiem = tichDiemField.getText();
                String _diachi = diaChiField.getText();
                if (_maKhachHang.isEmpty() || _tenKhachHang.isEmpty() || _phone.isEmpty() || _email.isEmpty()
                        || _tichDiem.isEmpty() || _diachi.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin!", "Error",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    if (connectKhachHang.checkMaKhachHang(_maKhachHang)) {
                        if (connectKhachHang.checkMaKhachHangHoaDonXuat(_maKhachHang)) {
                            JOptionPane.showMessageDialog(null,
                                    "Khách hàng tồn tại trong bảng hoá đơn xuất nên không xoá được!", "Thông báo",
                                    JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            connectKhachHang.xoaKhachHang(_maKhachHang);
                            table.setModel(connectKhachHang.getAllKhachHang());
                            JOptionPane.showMessageDialog(null, "Khách hàng đã được xoá thành công!", "Thông báo",
                                    JOptionPane.INFORMATION_MESSAGE);
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Khách hàng không tồn tại!", "Thông báo",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });
        nhapLai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                maKhachHangField.setText("");
                nameField.setText("");
                phoneField.setText("");
                emailField.setText("");
                tichDiemField.setText("");
                diaChiField.setText("");
            }
        });
    }

    public void initPanelTimKiem() {
        panelTimKiem = new JPanel();
        panelTimKiem.setLayout(null);
        panelTimKiem.setBounds(0, 50, 360, 250);
        panelTimKiem.setBackground(new Color(55, 55, 55));
        this.add(panelTimKiem);
        JLabel nhapTen = new JLabel("Nhập tên or mã khách hàng:");
        nhapTen.setBounds(20, 40, 200, 30);
        nhapTen.setForeground(Color.WHITE);
        nhapTen.setFont(new Font("", Font.PLAIN, 16));
        panelTimKiem.add(nhapTen);
        JTextField field = new JTextField();
        field.setBounds(20, 80, 300, 36);
        panelTimKiem.add(field);
        JButton search = new JButton("Tìm kiếm");
        search.setBounds(20, 160, 120, 28);
        search.setBackground(new Color(75, 184, 158));
        search.setFocusPainted(false);
        search.setForeground(Color.WHITE);
        search.setFont(new Font("", Font.PLAIN, 16));
        panelTimKiem.add(search);
        JButton all = new JButton("Tất cả");
        all.setBounds(200, 160, 120, 28);
        all.setBackground(new Color(75, 184, 158));
        all.setFocusPainted(false);
        all.setForeground(Color.WHITE);
        all.setFont(new Font("", Font.PLAIN, 16));
        panelTimKiem.add(all);

        all.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                table.setModel(connectKhachHang.getAllKhachHang());
            }
        });
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String res = field.getText();
                if (res.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập tên or mã khách hàng!", "Error",
                            JOptionPane.ERROR_MESSAGE);
                } else
                    table.setModel(connectKhachHang.timKiem(res));
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        super.paintComponent(g2d);
        g.drawImage(title_image, 20, 10, 38, 38, this);
        g2d.setColor(Color.BLACK);
    }
}
