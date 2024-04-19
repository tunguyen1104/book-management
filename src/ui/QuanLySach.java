package ui;

import connect.ConnectSach;
import entity.Sach;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class QuanLySach extends JPanel implements ActionListener {
    private JLabel title;
    private BufferedImage title_image;
    private JPanel panelALl;
    private JPanel themSachPanel;
    private JPanel hienThiSachPanel;
    private JPanel timKiemPanel;
    private CardLayout cardLayout = new CardLayout();
    private JButton themSach;
    private JButton suaSach;
    private JButton xoaSach;
    private JButton nhapLai;
    private JButton timKiem;
    private JButton exit;
    private JButton hienThiSach;
    private ImageIcon themSachIcon;
    private ImageIcon suaSachIcon;
    private ImageIcon xoaSachIcon;
    private ImageIcon hienThiSachIcon;
    public static ImageIcon timKiemIcon;
    private JLabel maSach;
    private JLabel tenSach;
    private JLabel maNXB;
    private JLabel tacGia;
    private JLabel giaBan;
    private JLabel discount;
    private JLabel maKhuVuc;
    private JTextField maSachField;
    private JTextField tenSachField;
    private JComboBox maNXBComboBox;
    private JComboBox maKhuVucComboBox;
    private JTextField tacGiaField;
    private JTextField giaBanField;
    private JTextField discountField;
    private BufferedImage maSachImage;
    private BufferedImage tenSachImage;
    private BufferedImage maNXBImage;
    private BufferedImage tacGiaImage;
    private BufferedImage giaBanImage;
    private BufferedImage discountImage;
    private JTable table;
    private JTable tableCapNhatSach;
    private DefaultTableModel dtmSach;
    private ConnectSach connectSach;
    DefaultTableModel dtmTimkiem;
    private String column_name = "MaSach";// panel Tim Kiem

    public QuanLySach() {
        connectSach = new ConnectSach();
        this.setLayout(null);
        this.setPreferredSize(new Dimension(1050, 700));
        try {
            title_image = ImageIO.read(new File("resources/images/books_40px.png"));
            themSachIcon = new ImageIcon("resources/images/add_book_25px.png");
            suaSachIcon = new ImageIcon("resources/images/book_and_pencil_25px.png");
            xoaSachIcon = new ImageIcon("resources/images/remove_book_25px.png");
            hienThiSachIcon = new ImageIcon("resources/images/book_reading_25px.png");
            timKiemIcon = new ImageIcon("resources/images/search_25px.png");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        initPanelAll();
        // --------
        title = new JLabel("Quản lý sách");
        title.setFont(new Font("", Font.PLAIN, 20));
        title.setBounds(70, 10, 120, 40);
        this.add(title);
        hienThiSach = new JButton("Cập nhật");
        hienThiSach.setBackground(new Color(75, 184, 158));
        hienThiSach.setIcon(hienThiSachIcon);
        hienThiSach.setFocusPainted(false);
        hienThiSach.setForeground(Color.WHITE);
        hienThiSach.setFont(new Font("", Font.PLAIN, 16));
        hienThiSach.setBounds(630, 20, 140, 30);
        this.add(hienThiSach);
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
        hienThiSach.addActionListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        super.paintComponent(g2d);
        g2d.drawImage(title_image, 20, 10, 38, 38, this);
        g2d.setColor(Color.BLACK);
        g2d.drawLine(0, 50, 1050, 50);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == timKiem) {
            timKiem.setBackground(new Color(75, 184, 158));
            cardLayout.show(panelALl, "timkiem");
            hienThiSach.setBackground(Color.GRAY);
        } else if (e.getSource() == exit) {
            Menu.cardLayout.show(Menu.panelCardLayout, "menu");
        } else if (e.getSource() == hienThiSach) {
            hienThiSach.setBackground(new Color(75, 184, 158));
            cardLayout.show(panelALl, "themsach");
            timKiem.setBackground(Color.GRAY);
        }
    }

    public void initPanelAll() {
        panelALl = new JPanel();
        panelALl.setLayout(cardLayout);
        panelALl.setBounds(0, 50, 1050, 650);
        initPanelThemSach();
        initPanelTimKiemSach();
        panelALl.add(themSachPanel, "themsach");
        panelALl.add(timKiemPanel, "timkiem");
        this.add(panelALl);
    }

    public void initPanelThemSach() {
        try {
            maSachImage = ImageIO.read(new File("resources/images/repository_28px.png"));
            tenSachImage = ImageIO.read(new File("resources/images/cbz_28px.png"));
            maNXBImage = ImageIO.read(new File("resources/images/link_28px.png"));
            tacGiaImage = ImageIO.read(new File("resources/images/customer_28px.png"));
            giaBanImage = ImageIO.read(new File("resources/images/Banknotes_28px.png"));
            discountImage = ImageIO.read(new File("resources/images/discount_28px.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        themSachPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                super.paintComponent(g2d);
                g.drawImage(maSachImage, 20, 22, 25, 25, themSachPanel);
                g.drawImage(tenSachImage, 380, 22, 25, 25, themSachPanel);
                g.drawImage(maNXBImage, 20, 72, 25, 25, themSachPanel);
                g.drawImage(tacGiaImage, 380, 72, 25, 25, themSachPanel);
                g.drawImage(giaBanImage, 20, 122, 25, 25, themSachPanel);
                g.drawImage(discountImage, 380, 122, 25, 25, themSachPanel);
            }
        };
        themSachPanel.setBounds(0, 50, 1050, 650);
        themSachPanel.setBackground(new Color(55, 55, 55));
        themSachPanel.setLayout(null);
        maSach = new JLabel("Mã Sách");
        maSach.setForeground(Color.WHITE);
        maSach.setFont(new Font("", Font.PLAIN, 16));
        maSach.setBounds(60, 20, 80, 30);
        themSachPanel.add(maSach);
        maSachField = new JTextField();
        maSachField.setBounds(130, 20, 200, 30);
        themSachPanel.add(maSachField);

        tenSach = new JLabel("Tên Sách");
        tenSach.setForeground(Color.WHITE);
        tenSach.setFont(new Font("", Font.PLAIN, 16));
        tenSach.setBounds(420, 20, 80, 30);
        themSachPanel.add(tenSach);
        tenSachField = new JTextField();
        tenSachField.setBounds(498, 20, 200, 30);
        themSachPanel.add(tenSachField);
        maNXB = new JLabel("Mã NXB");
        maNXB.setForeground(Color.WHITE);
        maNXB.setFont(new Font("", Font.PLAIN, 16));
        maNXB.setBounds(60, 70, 80, 30);
        themSachPanel.add(maNXB);
        String[] optionsv2 = { "NXB01", "NXB02", "NXB03", "NXB04", "NXB05" };
        maNXBComboBox = new JComboBox(optionsv2);
        maNXBComboBox.setBounds(130, 70, 200, 30);
        themSachPanel.add(maNXBComboBox);
        tacGia = new JLabel("Tác giả");
        tacGia.setForeground(Color.WHITE);
        tacGia.setFont(new Font("", Font.PLAIN, 16));
        tacGia.setBounds(422, 70, 80, 30);
        themSachPanel.add(tacGia);
        tacGiaField = new JTextField();
        tacGiaField.setBounds(498, 70, 200, 30);
        themSachPanel.add(tacGiaField);
        //
        giaBan = new JLabel("Giá bán");
        giaBan.setForeground(Color.WHITE);
        giaBan.setFont(new Font("", Font.PLAIN, 16));
        giaBan.setBounds(60, 120, 80, 30);
        themSachPanel.add(giaBan);
        giaBanField = new JTextField();
        giaBanField.setBounds(130, 120, 200, 30);
        themSachPanel.add(giaBanField);
        //
        discount = new JLabel("Giảm giá");
        discount.setForeground(Color.WHITE);
        discount.setFont(new Font("", Font.PLAIN, 16));
        discount.setBounds(416, 120, 80, 30);
        themSachPanel.add(discount);
        discountField = new JTextField();
        discountField.setBounds(498, 120, 200, 30);
        themSachPanel.add(discountField);
        maKhuVuc = new JLabel("Chi nhánh");
        maKhuVuc.setForeground(Color.WHITE);
        maKhuVuc.setFont(new Font("", Font.PLAIN, 16));
        maKhuVuc.setBounds(720, 20, 80, 30);
        themSachPanel.add(maKhuVuc);
        String[] options = { "KV01", "KV02", "KV03", "KV04" };
        maKhuVucComboBox = new JComboBox(options);
        maKhuVucComboBox.setBounds(800, 20, 200, 30);
        themSachPanel.add(maKhuVucComboBox);
        //
        themSach = new JButton("Thêm sách");
        themSach.setBackground(new Color(94, 201, 77));
        themSach.setIcon(themSachIcon);
        themSach.setFocusPainted(false);
        themSach.setForeground(Color.WHITE);
        themSach.setFont(new Font("", Font.PLAIN, 16));
        themSach.setBounds(490, 170, 140, 30);
        themSachPanel.add(themSach);

        suaSach = new JButton("Sửa sách");
        suaSach.setBackground(new Color(197, 192, 60));
        suaSach.setIcon(suaSachIcon);
        suaSach.setFocusPainted(false);
        suaSach.setForeground(Color.WHITE);
        suaSach.setFont(new Font("", Font.PLAIN, 16));
        suaSach.setBounds(630, 170, 140, 30);
        themSachPanel.add(suaSach);
        xoaSach = new JButton("Xoá sách");
        xoaSach.setBackground(new Color(176, 42, 42));
        xoaSach.setIcon(xoaSachIcon);
        xoaSach.setFocusPainted(false);
        xoaSach.setForeground(Color.WHITE);
        xoaSach.setFont(new Font("", Font.PLAIN, 16));
        xoaSach.setBounds(770, 170, 140, 30);
        themSachPanel.add(xoaSach);
        nhapLai = new JButton("Nhập lại");
        nhapLai.setBackground(new Color(44, 117, 161));
        nhapLai.setFocusPainted(false);
        nhapLai.setForeground(Color.WHITE);
        nhapLai.setFont(new Font("", Font.PLAIN, 16));
        nhapLai.setBounds(910, 170, 140, 30);
        themSachPanel.add(nhapLai);
        tableCapNhatSach = new JTable();
        tableCapNhatSach.setDefaultEditor(Object.class, null);
        dtmSach = connectSach.getAllSach();
        tableCapNhatSach.setModel(dtmSach);
        JScrollPane scrollPane = new JScrollPane(tableCapNhatSach);
        scrollPane.setBounds(0, 200, 1050, 450);
        themSachPanel.add(scrollPane);
        tableCapNhatSach.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent ex) {
                super.mouseClicked(ex);
                int row = tableCapNhatSach.getSelectedRow();
                maSachField.setText(tableCapNhatSach.getValueAt(row, 0).toString());
                tenSachField.setText(tableCapNhatSach.getValueAt(row, 1).toString());
                giaBanField.setText(tableCapNhatSach.getValueAt(row, 2).toString());
                tacGiaField.setText(tableCapNhatSach.getValueAt(row, 3).toString());
                maNXBComboBox.setSelectedItem(tableCapNhatSach.getValueAt(row, 4).toString());
                maKhuVucComboBox.setSelectedItem(tableCapNhatSach.getValueAt(row, 5).toString());
                discountField.setText(tableCapNhatSach.getValueAt(row, 6).toString());
            }
        });
        themSach.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String maSach = maSachField.getText();
                String tenSach = tenSachField.getText();
                String maNXB = (String) maNXBComboBox.getSelectedItem();
                String tacGia = tacGiaField.getText();
                String giaBan = giaBanField.getText();
                String discount = discountField.getText();
                String maKV = (String) maKhuVucComboBox.getSelectedItem();
                if (maSach.isEmpty() || tenSach.isEmpty() || maNXB.isEmpty() || tacGia.isEmpty() || giaBan.isEmpty()
                        || discount.isEmpty() || maKV.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin!", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    double giaBanValue = Double.parseDouble(giaBan);
                    double discountValue = Double.parseDouble(discount);
                    if (!connectSach.checkMaSach(maSach)) {
                        connectSach.themSachMoi(
                                new Sach(maSach, tenSach, giaBanValue, tacGia, maNXB, maKV, discountValue));
                        dtmSach = connectSach.getAllSach();
                        tableCapNhatSach.setModel(dtmSach);
                        JOptionPane.showMessageDialog(null, "Sách đã được thêm thành công!", "Thông báo",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Mã sách phải khác nhau!", "Thông báo",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Giá bán và giảm giá phải là số!", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        suaSach.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String maSach = maSachField.getText();
                String tenSach = tenSachField.getText();
                String maNXB = (String) maNXBComboBox.getSelectedItem();
                String tacGia = tacGiaField.getText();
                String giaBan = giaBanField.getText();
                String discount = discountField.getText();
                String maKV = (String) maKhuVucComboBox.getSelectedItem();
                if (maSach.isEmpty() || tenSach.isEmpty() || maNXB.isEmpty() || tacGia.isEmpty() || giaBan.isEmpty()
                        || discount.isEmpty() || maKV.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin!", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    double giaBanValue = Double.parseDouble(giaBan);
                    double discountValue = Double.parseDouble(discount);
                    if (connectSach.checkMaSach(maSach)) {
                        connectSach.suaSach(
                                new Sach(maSach, tenSach, giaBanValue, tacGia, maNXB, maKV, discountValue));
                        dtmSach = connectSach.getAllSach();
                        tableCapNhatSach.setModel(dtmSach);
                        JOptionPane.showMessageDialog(null, "Sách đã được sửa thành công!", "Thông báo",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Sách không tồn tại trong kho không sửa được!", "Thông báo",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Giá bán và giảm giá phải là số!", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        xoaSach.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String maSach = maSachField.getText();
                String tenSach = tenSachField.getText();
                String maNXB = (String) maNXBComboBox.getSelectedItem();
                String tacGia = tacGiaField.getText();
                String giaBan = giaBanField.getText();
                String discount = discountField.getText();
                String maKV = (String) maKhuVucComboBox.getSelectedItem();
                if (maSach.isEmpty() || tenSach.isEmpty() || maNXB.isEmpty() || tacGia.isEmpty() || giaBan.isEmpty()
                        || discount.isEmpty() || maKV.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin!", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    double giaBanValue = Double.parseDouble(giaBan);
                    double discountValue = Double.parseDouble(discount);
                    if (connectSach.checkMaSach(maSach)) {
                        if (connectSach.checkMaSachInChiTietNhap(maSach)
                                || connectSach.checkMaSachInChiTietXuat(maSach)) {
                            JOptionPane.showMessageDialog(null,
                                    "Sách có trong bảng chi tiết hoá đơn nên không xoá được!",
                                    "Thông báo",
                                    JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            connectSach.xoaSach(maSach);
                            dtmSach = connectSach.getAllSach();
                            tableCapNhatSach.setModel(dtmSach);
                            JOptionPane.showMessageDialog(null, "Sách đã được xoá thành công!", "Thông báo",
                                    JOptionPane.INFORMATION_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Sách không tồn tại trong kho không xoá được!", "Thông báo",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Giá bán và giảm giá phải là số!", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        nhapLai.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                maSachField.setText("");
                tenSachField.setText("");
                tacGiaField.setText("");
                giaBanField.setText("");
                discountField.setText("");
                maNXBComboBox.setSelectedIndex(0);
                maKhuVucComboBox.setSelectedIndex(0);
            }

        });

    }

    public void initPanelHienThiSach() {
        hienThiSachPanel = new JPanel();
        hienThiSachPanel.setLayout(null);
        hienThiSachPanel.setBounds(210, 80, 850, 630);
        hienThiSachPanel.setBackground(new Color(55, 55, 55));
        String[] options = { "Hiển thị sách mặc định", "Hiển thị sách sắp xếp theo giá tiền",
                "Hiển thị sách sắp xếp theo số lượng", "Hiển thị các sách đang có chương trình giảm giá > 10%",
                "Hiển thị sách mới được thêm vào kho hàng gần đây" };
        JComboBox<String> selectOptions = new JComboBox<>(options);
        selectOptions.setBounds(20, 20, 300, 30);
        hienThiSachPanel.add(selectOptions);
        String[] optionsv2 = { "ALL", "KV1", "KV2", "KV3", "KV4" };
        JComboBox maKhuVucBox = new JComboBox(optionsv2);
        maKhuVucBox.setBounds(340, 20, 100, 30);
        hienThiSachPanel.add(maKhuVucBox);
        Object[][] row = {
                { "MS001", "Harry Potter và Hòn đá Phù Thủy", "NXB001", "Tiểu Thuyết", "J.K. Rowling", 150000, 1 },
                { "MS002", "Nhà Giả Kim", "NXB002", "Tiểu Thuyết", "Paulo Coelho", 120000, 0.15 },
                { "MS003", "Dấu Chân Trên Cát", "NXB003", "Tự Truyện", "Nelson Mandela", 180000, 5 },
                { "MS004", "Hạt Giống Tâm Hồn", "NXB004", "Tâm Lý - Tự Kỷ", "Jack Canfield", 200000, 2 },
                { "MS005", "Bí Mật", "NXB005", "Phát Triển Bản Thân", "Rhonda Byrne", 130000, 1 },
                { "MS006", "Số Đỏ", "NXB002", "Văn Học", "Nguyễn Ngọc Thạch", 95000, 0.8 },
                { "MS007", "Cây Cam Ngọt của Tôi", "NXB006", "Thiếu Nhi", "Chih-Yuan Chen", 80000, 12 },
                { "MS008", "Sống Đời Bình An", "NXB004", "Tâm Lý - Phát Triển Bản Thân", "Norman Vincent Peale", 175000,
                        25 }
        };
        Object[] col = { "Mã Sách", "Tên Sách", "Mã NXB", "Thể Loại", "Tác Giả", "Giá Bán", "Giảm Giá" };
        table = new JTable(new DefaultTableModel(row, col));
        table.setDefaultEditor(Object.class, null);
        table.setAutoCreateRowSorter(true);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 60, 850, 570);
        hienThiSachPanel.add(scrollPane);
        selectOptions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedOption = (String) selectOptions.getSelectedItem();
                switch (selectedOption) {
                    case "Hiển thị sách mặc định":

                        break;
                    case "Hiển thị sách sắp xếp theo giá tiền":

                        break;
                    case "Hiển thị sách sắp xếp theo số lượng":

                        break;
                    case "Hiển thị các sách đang có chương trình giảm giá > 10%":

                        break;
                    case "Hiển thị sách mới được thêm vào kho hàng gần đây":

                        break;
                }
            }
        });
    }

    public void initPanelTimKiemSach() {
        timKiemPanel = new JPanel();
        timKiemPanel.setLayout(null);
        timKiemPanel.setBounds(210, 80, 850, 630);
        timKiemPanel.setBackground(new Color(55, 55, 55));

        dtmTimkiem = new DefaultTableModel();
        dtmTimkiem = connectSach.getAllSach();
        JTable tableTimKiemSach = new JTable(dtmTimkiem);
        tableTimKiemSach.setDefaultEditor(Object.class, null);
        JScrollPane scrollPane = new JScrollPane(tableTimKiemSach);
        scrollPane.setBounds(0, 60, 1050, 590);
        timKiemPanel.add(scrollPane);
        String[] options = { "Mã Sách", "Tên sách", "Giá bán", "Tác Giả", "NXB", "Thể loại", "Discount" };
        JComboBox<String> selectOptions = new JComboBox<>(options);
        selectOptions.setBounds(220, 20, 100, 30);
        timKiemPanel.add(selectOptions);
        JTextField timSachField = new JTextField();
        timSachField.setBounds(340, 20, 280, 30);
        timKiemPanel.add(timSachField);
        selectOptions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedOption = (String) selectOptions.getSelectedItem().toString();
                switch (selectedOption) {
                    case "Mã Sách":
                        column_name = "MaSach";
                        break;
                    case "Tên sách":
                        column_name = "TenSach";
                        break;
                    case "Giá bán":
                        column_name = "GiaTien";
                        break;
                    case "Tác Giả":
                        column_name = "TacGia";
                        break;
                    case "NXB":
                        column_name = "MaNhaXuatBan";
                        break;
                    case "Thể loại":
                        column_name = "MaKhuVuc";
                        break;
                    case "Discount":
                        column_name = "Discount";
                        break;
                }
                String res = timSachField.getText();
                if (!column_name.equals("MaKhuVuc"))
                    dtmTimkiem = connectSach.timKiem(column_name, res);
                else
                    dtmTimkiem = connectSach.timKiemTheLoai(res);
                tableTimKiemSach.setModel(dtmTimkiem);
            }
        });

        timSachField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String res = timSachField.getText();
                if (!column_name.equals("MaKhuVuc"))
                    dtmTimkiem = connectSach.timKiem(column_name, res);
                else
                    dtmTimkiem = connectSach.timKiemTheLoai(res);
                tableTimKiemSach.setModel(dtmTimkiem);
            }
        });
    }
}
