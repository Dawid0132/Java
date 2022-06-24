import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.IntStream;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class pick_ships {
    CardLayout cardLayout = new CardLayout();
    JFrame frame = new JFrame("Gra_w_statki");
    JPanel mainPanel = new JPanel(cardLayout);
    JPanel panel = new JPanel();
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JButton[][] buttons = new JButton[10][10];
    JButton[][] buttons1 = new JButton[10][10];
    JLabel player1 = new JLabel("Player1", SwingConstants.CENTER);
    JLabel player2 = new JLabel("Player2", SwingConstants.CENTER);
    JLabel polecenie = new JLabel("Wybierz statek czteromasztowy", 0);
    JLabel polecenie1 = new JLabel("Wybierz statek trojmasztowy", 0);
    JLabel polecenie2 = new JLabel("Wybierz drugi statek trojmasztowy", 0);
    JLabel polecenie3 = new JLabel("Wybierz statek dwumasztowy", 0);
    JLabel polecenie4 = new JLabel("Wybierz drugi statek dwumasztowy", 0);
    JLabel polecenie5 = new JLabel("Wybierz trzeci statek dwumasztowy", 0);
    JLabel polecenie6 = new JLabel("Wybierz statek jednomasztowy", 0);
    JLabel polecenie7 = new JLabel("Wybierz drugi statek jednomasztowy", 0);
    JLabel polecenie8 = new JLabel("Wybierz trzeci statek jednomasztowy", 0);
    JLabel polecenie9 = new JLabel("Wybierz czwarty statek jednomasztowy", 0);
    JLabel polecenie10 = new JLabel("Wybierz piąty statek jednomasztowy", 0);
    JLabel trafiony = new JLabel("Trafiony", 0);
    JLabel pudło = new JLabel("Pudło",0);
    JLabel trafiony_zatopiony = new JLabel("Trafiony Zatopiony",0);
    JLabel wygrałeś = new JLabel("Gratulacje , wygrałeś");
    JLabel p1jedno = new JLabel("Zatopiłeś statek Jednomasztowy");
    JLabel p1dwoj2 = new JLabel("Zatopiłeś statek Dwumasztowy");
    JLabel p1troj1 = new JLabel("Zatopiłeś statek trójmasztowy");
    JLabel p1cztero = new JLabel("Zatopiłeś statek czteromasztowy");
    ArrayList<Integer> p1Czteromasztowiec = new ArrayList<>();
    ArrayList<Integer> p1Trojmasztowiec = new ArrayList();
    ArrayList<Integer> p1Trojmasztowiec1 = new ArrayList();
    ArrayList<Integer> p1Dwumasztowiec = new ArrayList();
    ArrayList<Integer> p1Dwumasztowiec1 = new ArrayList();
    ArrayList<Integer> p1Dwumasztowiec2 = new ArrayList();
    ArrayList<Integer> p1Jednomasztowce = new ArrayList();
    /*
    -----------------------------------------------------
    */
    ArrayList<Integer> p2Czteromasztowiec = new ArrayList();
    ArrayList<Integer> p2Trojmasztowiec = new ArrayList();
    ArrayList<Integer> p2Trojmasztowiec1 = new ArrayList();
    ArrayList<Integer> p2Dwumasztowiec = new ArrayList();
    ArrayList<Integer> p2Dwumasztowiec1 = new ArrayList();
    ArrayList<Integer> p2Dwumasztowiec2 = new ArrayList();
    ArrayList<Integer> p2Jednomasztowce = new ArrayList();
    int suma = 0;
    int suma1 = 0;
    int clicked = 0;
    int clicked1 = 0;
    static int min_x = 0;
    static int min_y = 0;
    static int max_x = 9;
    static int max_y = 9;
    static int get_i = 0;
    static int get_j = 0;
    static int get_ii = 0;
    static int get_jj = 0;
    static int startPosX;
    static int startPosY;
    static int endPosX;
    static int endPosY;
    static int position_x = 0;
    static int position_y = 0;
    boolean shoot = true;
    boolean shoot1 = true;
    int get_x=-1;
    int get_y=-1;
    int get_x1=-1;
    int get_y1=-1;
    int get_x2=-1;
    int get_y2=-1;
    int get_x3=-1;
    int get_y3=-1;
    int get_x4=-1;
    int get_y4=-1;
    int get_x5=-1;
    int get_y5=-1;
    int get_x6=-1;
    int get_y6=-1;
    boolean good_shoot=false;
    int help=0;



    pick_ships() {

    }

    void make_board() {
        frame.setLayout(new GridLayout());
        frame.add(panel1);
        panel1.setLayout(new BorderLayout());
        panel1.add(player1, BorderLayout.NORTH);
        polecenie.setFont(new Font(polecenie.getFont().getName(), polecenie.getFont().getStyle(), 20));
        trafiony.setFont(new Font(trafiony.getFont().getName(), polecenie.getFont().getStyle(), 20));
        trafiony_zatopiony.setFont(new Font(trafiony_zatopiony.getFont().getName(), trafiony_zatopiony.getFont().getStyle(), 20));
        pudło.setFont(new Font(pudło.getFont().getName(), pudło.getFont().getStyle(), 20));
        pudło.setVisible(false);
        panel1.add(pudło, SwingConstants.CENTER);
        panel1.add(polecenie, SwingConstants.CENTER);
        frame.add(mainPanel);
        mainPanel.add(panel, "player1");
        mainPanel.add(panel2, "player2");
        cardLayout.show(mainPanel, "player1");
        frame.getContentPane();
        frame.setSize(1000, 500);
        frame.setResizable(false);
        String[] litery = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        String[] liczby = new String[]{" ", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        panel.setLayout(new GridLayout(11, 11));
        panel2.setLayout(new GridLayout(11, 11));
        for (int i = 0; i < 11; ++i) {
            JLabel intlabel = new JLabel(liczby[i]);
            panel.add(intlabel);
        }

        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < 10; ++j) {
                if (j == 0) {
                    JLabel literylabel = new JLabel(litery[i]);
                    panel.add(literylabel);
                }

                JButton button = new JButton();
                buttons[i][j] = button;
                panel.add(button);
            }
        }

        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < 10; ++j) {
                buttons[i][j].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        JButton qq = (JButton) e.getSource();
                        for (int i = 0; i < 10; ++i) {
                            for (int j = 0; j < 10; ++j) {
                                if (qq == buttons[i][j]) {
                                    clicked++;
                                    position_x = qq.getX();
                                    position_y = qq.getY();
                                    get_ii = i;
                                    get_jj = j;
                                    if (clicked == 1) {
                                        qq.setText("*");
                                        suma++;
                                        buttons[i][j].setEnabled(false);
                                        get_i = i;
                                        get_j = j;
                                        startPosX = get_i - 1 < min_x ? get_i : get_i - 1;
                                        startPosY = get_j - 1 < min_y ? get_j : get_j - 1;
                                        endPosX = get_i + 1 > max_x ? get_i : get_i + 1;
                                        endPosY = get_j + 1 > max_y ? get_j : get_j + 1;
                                    }

                                    if (clicked > 1 && clicked < 10) {
                                        if (buttons[i][j] == buttons[get_i][startPosY] || buttons[i][j] == buttons[get_i][endPosY]) {
                                            buttons[i][j].setText("*");
                                            buttons[i][j].setEnabled(false);
                                            suma++;
                                        }

                                        if (buttons[i][j] == buttons[startPosX][get_j] || buttons[i][j] == buttons[endPosX][get_j]) {
                                            buttons[i][j].setText("*");
                                            buttons[i][j].setEnabled(false);
                                            suma++;
                                        }
                                    }
                                    if (clicked >= 10) {
                                        int size1 = p2Czteromasztowiec.size();
                                        int size2 = p2Trojmasztowiec.size();
                                        int size3 = p2Trojmasztowiec1.size();
                                        int size4 = p2Dwumasztowiec.size();
                                        int size5 = p2Dwumasztowiec1.size();
                                        int size6 = p2Dwumasztowiec2.size();
                                        int size7 = p2Jednomasztowce.size();
                                        p1cztero.setVisible(false);
                                        p1troj1.setVisible(false);
                                        p1dwoj2.setVisible(false);
                                        p1jedno.setVisible(false);
                                        trafiony.setVisible(false);
                                        pudło.setVisible(false);
                                        for (int x = 0; x < p2Czteromasztowiec.size(); x++) {
                                            shoot = position_x == p2Czteromasztowiec.get(x);
                                            if (shoot) {
                                                for (int y = 0; y < p2Czteromasztowiec.size(); y++) {
                                                    shoot1 = position_y == p2Czteromasztowiec.get(y);
                                                    if (shoot1) {
                                                        get_x = x;
                                                        get_y = y;
                                                        buttons[i][j].setEnabled(false);
                                                        buttons[i][j].setText("X");
                                                        trafiony.setVisible(true);
                                                        break;
                                                    }
                                                }
                                            }
                                        }
                                        if (get_x >= 0 && get_y >= 0) {
                                            if (get_x > get_y) {
                                                p2Czteromasztowiec.remove(get_x);
                                                p2Czteromasztowiec.remove(get_y);
                                            }
                                            if (get_y > get_x) {
                                                p2Czteromasztowiec.remove(get_y);
                                                p2Czteromasztowiec.remove(get_x);
                                            }
                                            get_y = -1;
                                            get_x = -1;
                                        }
                                        for (int x = 0; x < p2Trojmasztowiec.size(); x++) {
                                            shoot = position_x == p2Trojmasztowiec.get(x);
                                            if (shoot) {
                                                for (int y = 0; y < p2Trojmasztowiec.size(); y++) {
                                                    shoot1 = position_y == p2Trojmasztowiec.get(y);
                                                    if (shoot1) {
                                                        get_x1 = x;
                                                        get_y1 = y;
                                                        buttons[i][j].setEnabled(false);
                                                        buttons[i][j].setText("X");
                                                        trafiony.setVisible(true);
                                                        break;
                                                    }
                                                }
                                            }
                                        }
                                        if (get_x1 >= 0 && get_y1 >= 0) {
                                            if (get_x1 > get_y1) {
                                                p2Trojmasztowiec.remove(get_x1);
                                                p2Trojmasztowiec.remove(get_y1);
                                            }
                                            if (get_y1 > get_x1) {
                                                p2Trojmasztowiec.remove(get_y1);
                                                p2Trojmasztowiec.remove(get_x1);
                                            }
                                            get_y1 = -1;
                                            get_x1 = -1;
                                        }
                                        for (int x = 0; x < p2Trojmasztowiec1.size(); x++) {
                                            shoot = position_x == p2Trojmasztowiec1.get(x);
                                            if (shoot) {
                                                for (int y = 0; y < p2Trojmasztowiec1.size(); y++) {
                                                    shoot1 = position_y == p2Trojmasztowiec1.get(y);
                                                    if (shoot1) {
                                                        get_x2 = x;
                                                        get_y2 = y;
                                                        buttons[i][j].setEnabled(false);
                                                        buttons[i][j].setText("X");
                                                        trafiony.setVisible(true);
                                                        break;
                                                    }
                                                }
                                            }
                                        }
                                        if (get_x2 >= 0 && get_y2 >= 0) {
                                            if (get_x2 > get_y2) {
                                                p2Trojmasztowiec1.remove(get_x2);
                                                p2Trojmasztowiec1.remove(get_y2);
                                            }
                                            if (get_y2 > get_x2) {
                                                p2Trojmasztowiec1.remove(get_y2);
                                                p2Trojmasztowiec1.remove(get_x2);
                                            }
                                            get_y2 = -1;
                                            get_x2 = -1;
                                        }
                                        for (int x = 0; x < p2Dwumasztowiec.size(); x++) {
                                            shoot = position_x == p2Dwumasztowiec.get(x);
                                            if (shoot) {
                                                for (int y = 0; y < p2Dwumasztowiec.size(); y++) {
                                                    shoot1 = position_y == p2Dwumasztowiec.get(y);
                                                    if (shoot1) {
                                                        get_x3 = x;
                                                        get_y3 = y;
                                                        buttons[i][j].setEnabled(false);
                                                        buttons[i][j].setText("X");
                                                        trafiony.setVisible(true);
                                                        break;
                                                    }
                                                }
                                            }
                                        }
                                        if (get_x3 >= 0 && get_y3 >= 0) {
                                            if (get_x3 > get_y3) {
                                                p2Dwumasztowiec.remove(get_x3);
                                                p2Dwumasztowiec.remove(get_y3);
                                            }
                                            if (get_y3 > get_x3) {
                                                p2Dwumasztowiec.remove(get_y3);
                                                p2Dwumasztowiec.remove(get_x3);
                                            }
                                            get_y3 = -1;
                                            get_x3 = -1;
                                        }
                                        for (int x = 0; x < p2Dwumasztowiec1.size(); x++) {
                                            shoot = position_x == p2Dwumasztowiec1.get(x);
                                            if (shoot) {
                                                for (int y = 0; y < p2Dwumasztowiec1.size(); y++) {
                                                    shoot1 = position_y == p2Dwumasztowiec1.get(y);
                                                    if (shoot1) {
                                                        get_x4 = x;
                                                        get_y4 = y;
                                                        buttons[i][j].setEnabled(false);
                                                        buttons[i][j].setText("X");
                                                        trafiony.setVisible(true);
                                                        break;
                                                    }
                                                }
                                            }
                                        }
                                        if (get_x4 >= 0 && get_y4 >= 0) {
                                            if (get_x4 > get_y4) {
                                                p2Dwumasztowiec1.remove(get_x4);
                                                p2Dwumasztowiec1.remove(get_y4);
                                            }
                                            if (get_y4 > get_x4) {
                                                p2Dwumasztowiec1.remove(get_y4);
                                                p2Dwumasztowiec1.remove(get_x4);
                                            }
                                            get_y4 = -1;
                                            get_x4 = -1;
                                        }
                                        for (int x = 0; x < p2Dwumasztowiec2.size(); x++) {
                                            shoot = position_x == p2Dwumasztowiec2.get(x);
                                            if (shoot) {
                                                for (int y = 0; y < p2Dwumasztowiec2.size(); y++) {
                                                    shoot1 = position_y == p2Dwumasztowiec2.get(y);
                                                    if (shoot1) {
                                                        get_x5 = x;
                                                        get_y5 = y;
                                                        buttons[i][j].setEnabled(false);
                                                        buttons[i][j].setText("X");
                                                        trafiony.setVisible(true);
                                                        break;
                                                    }
                                                }
                                            }
                                        }
                                        if (get_x5 >= 0 && get_y5 >= 0) {
                                            if (get_x5 > get_y5) {
                                                p2Dwumasztowiec2.remove(get_x5);
                                                p2Dwumasztowiec2.remove(get_y5);
                                            }
                                            if (get_y5 > get_x5) {
                                                p2Dwumasztowiec1.remove(get_y5);
                                                p2Dwumasztowiec1.remove(get_x5);
                                            }
                                            get_y5 = -1;
                                            get_x5 = -1;
                                        }
                                        for (int x = 0; x < p2Jednomasztowce.size(); x++) {
                                            shoot = position_x == p2Jednomasztowce.get(x);
                                            if (shoot) {
                                                for (int y = 0; y < p2Jednomasztowce.size(); y++) {
                                                    shoot1 = position_y == p2Jednomasztowce.get(y);
                                                    if (shoot1) {
                                                        get_x6 = x;
                                                        get_y6 = y;
                                                        buttons[i][j].setEnabled(false);
                                                        buttons[i][j].setText("X");
                                                        trafiony.setVisible(true);
                                                        break;
                                                    }
                                                }
                                            }
                                        }
                                        if (get_x6 >= 0 && get_y6 >= 0) {
                                            if (get_x6 > get_y6) {
                                                p2Jednomasztowce.remove(get_x6);
                                                p2Jednomasztowce.remove(get_y6);
                                            }
                                            if (get_y6 > get_x6) {
                                                p2Jednomasztowce.remove(get_y6);
                                                p2Jednomasztowce.remove(get_x6);
                                            }
                                            get_y6 = -1;
                                            get_x6 = -1;
                                        }
                                        if (size1 == p2Czteromasztowiec.size() && size2 == p2Trojmasztowiec.size() && size3 == p2Trojmasztowiec1.size() && size4 == p2Dwumasztowiec.size() && size5 == p2Dwumasztowiec1.size() && size6 == p2Dwumasztowiec2.size() && size7 == p2Jednomasztowce.size()) {
                                            buttons[i][j].setText("P");
                                            pudło.setVisible(true);
                                            player1.setVisible(false);
                                            player2.setVisible(true);
                                            cardLayout.show(mainPanel, "player2");
                                        }
                                        if (p2Czteromasztowiec.isEmpty()){
                                            trafiony.setVisible(false);
                                            p1cztero.setFont(new Font(p1cztero.getFont().getName(), p1cztero.getFont().getStyle(), 20));
                                            panel1.add(p1cztero,SwingConstants.CENTER);
                                        }
                                        if (p2Trojmasztowiec.isEmpty()){
                                            p1troj1.setFont(new Font(p1troj1.getFont().getName(), p1troj1.getFont().getStyle(), 20));
                                            panel1.add(p1troj1,SwingConstants.CENTER);
                                        }
                                        if (p2Trojmasztowiec1.isEmpty()){
                                            p1troj1.setFont(new Font(p1troj1.getFont().getName(), p1troj1.getFont().getStyle(), 20));
                                            panel1.add(p1troj1,SwingConstants.CENTER);
                                        }
                                        if (p2Dwumasztowiec.isEmpty()){
                                            p1dwoj2.setFont(new Font(p1dwoj2.getFont().getName(), p1dwoj2.getFont().getStyle(), 20));
                                            panel1.add(p1dwoj2,SwingConstants.CENTER);
                                        }
                                        if (p2Dwumasztowiec1.isEmpty()){
                                            p1dwoj2.setFont(new Font(p1dwoj2.getFont().getName(), p1dwoj2.getFont().getStyle(), 20));
                                            panel1.add(p1dwoj2,SwingConstants.CENTER);
                                        }
                                        if (p2Dwumasztowiec2.isEmpty()){
                                            p1dwoj2.setFont(new Font(p1dwoj2.getFont().getName(), p1dwoj2.getFont().getStyle(), 20));
                                            panel1.add(p1dwoj2,SwingConstants.CENTER);
                                        }
                                        if (p2Jednomasztowce.size() == size7 - 1) {
                                            p1jedno.setFont(new Font(p1jedno.getFont().getName(), p1jedno.getFont().getStyle(), 20));
                                            panel1.add(p1jedno,SwingConstants.CENTER);
                                        }
                                        if (p2Czteromasztowiec.isEmpty() && p2Trojmasztowiec.isEmpty() && p2Trojmasztowiec1.isEmpty() && p2Dwumasztowiec.isEmpty() && p2Dwumasztowiec1.isEmpty() && p2Dwumasztowiec2.isEmpty() && p2Jednomasztowce.isEmpty()){
                                            wygrałeś.setFont(new Font(wygrałeś.getFont().getName(), wygrałeś.getFont().getStyle(), 20));
                                            panel1.add(wygrałeś,SwingConstants.CENTER);
                                        }
                                    }
                                }
                            }
                        }


                        if (suma <= 4) {
                            p1Czteromasztowiec.add(position_x);
                            p1Czteromasztowiec.add(position_y);
                            if (suma == 4) {
                                clicked = 0;
                                polecenie.setVisible(false);
                                polecenie1.setFont(new Font(polecenie.getFont().getName(), polecenie.getFont().getStyle(), 20));
                                panel1.add(polecenie1);
                            }
                        }

                        if (suma > 4 && suma <= 7) {
                            p1Trojmasztowiec.add(position_x);
                            p1Trojmasztowiec.add(position_y);
                            if (suma == 7) {
                                clicked = 0;
                                polecenie1.setVisible(false);
                                polecenie2.setFont(new Font(polecenie.getFont().getName(), polecenie.getFont().getStyle(), 20));
                                panel1.add(polecenie2);
                            }
                        }

                        if (suma > 7 && suma <= 10) {
                            p1Trojmasztowiec1.add(position_x);
                            p1Trojmasztowiec1.add(position_y);
                            if (suma == 10) {
                                clicked = 0;
                                polecenie2.setVisible(false);
                                polecenie3.setFont(new Font(polecenie.getFont().getName(), polecenie.getFont().getStyle(), 20));
                                panel1.add(polecenie3);
                            }
                        }

                        if (suma > 10 && suma <= 12) {
                            p1Dwumasztowiec.add(position_x);
                            p1Dwumasztowiec.add(position_y);
                            if (suma == 12) {
                                clicked = 0;
                                polecenie3.setVisible(false);
                                polecenie4.setFont(new Font(polecenie.getFont().getName(), polecenie.getFont().getStyle(), 20));
                                panel1.add(polecenie4);
                            }
                        }

                        if (suma > 12 && suma <= 14) {
                            p1Dwumasztowiec1.add(position_x);
                            p1Dwumasztowiec1.add(position_y);
                            if (suma == 14) {
                                clicked = 0;
                                polecenie4.setVisible(false);
                                polecenie5.setFont(new Font(polecenie.getFont().getName(), polecenie.getFont().getStyle(), 20));
                                panel1.add(polecenie5);
                            }
                        }

                        if (suma > 14 && suma <= 16) {
                            p1Dwumasztowiec2.add(position_x);
                            p1Dwumasztowiec2.add(position_y);
                            if (suma == 16) {
                                clicked = 0;
                                polecenie5.setVisible(false);
                                polecenie6.setFont(new Font(polecenie.getFont().getName(), polecenie.getFont().getStyle(), 20));
                                panel1.add(polecenie6);
                            }
                        }

                        if (suma == 17) {
                            p1Jednomasztowce.add(position_x);
                            p1Jednomasztowce.add(position_y);
                            clicked = 0;
                            polecenie6.setVisible(false);
                            polecenie7.setFont(new Font(polecenie.getFont().getName(), polecenie.getFont().getStyle(), 20));
                            panel1.add(polecenie7);
                        }

                        if (suma == 18) {
                            p1Jednomasztowce.add(position_x);
                            p1Jednomasztowce.add(position_y);
                            clicked = 0;
                            polecenie7.setVisible(false);
                            polecenie8.setFont(new Font(polecenie.getFont().getName(), polecenie.getFont().getStyle(), 20));
                            panel1.add(polecenie8);
                        }

                        if (suma == 19) {
                            p1Jednomasztowce.add(position_x);
                            p1Jednomasztowce.add(position_y);
                            clicked = 0;
                            polecenie8.setVisible(false);
                            polecenie9.setFont(new Font(polecenie.getFont().getName(), polecenie.getFont().getStyle(), 20));
                            panel1.add(polecenie9);
                        }

                        if (suma == 20) {
                            p1Jednomasztowce.add(position_x);
                            p1Jednomasztowce.add(position_y);
                            clicked = 0;
                            polecenie9.setVisible(false);
                            polecenie10.setFont(new Font(polecenie.getFont().getName(), polecenie.getFont().getStyle(), 20));
                            panel1.add(polecenie10);
                        }

                        if (suma == 21) {
                            help++;
                            if (help==1) {
                                p1Jednomasztowce.add(position_x);
                                p1Jednomasztowce.add(position_y);
                                player1.setVisible(false);
                                panel1.add(player2, BorderLayout.NORTH);
                                clearAllfields(panel);
                                polecenie10.setVisible(false);
                                cardLayout.show(mainPanel, "player2");
                                polecenie.setVisible(true);
                                clicked = 10;
                                for (int i = 0; i < 11; ++i) {
                                    JLabel intlabel = new JLabel(liczby[i]);
                                    panel2.add(intlabel);
                                }
                                for (int i = 0; i < 10; ++i) {
                                    for (int j = 0; j < 10; ++j) {
                                        if (j == 0) {
                                            JLabel literylabel = new JLabel(litery[i]);
                                            panel2.add(literylabel);
                                        }
                                        JButton button = new JButton();
                                        buttons1[i][j] = button;
                                        panel2.add(button);
                                    }
                                }
                            }
                            for (int i = 0; i < 10; ++i) {
                                for (int j = 0; j < 10; ++j) {
                                    buttons1[i][j].addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            JButton qq1 = (JButton) e.getSource();
                                            for (int i = 0; i < 10; ++i) {
                                                for (int j = 0; j < 10; ++j) {
                                                    if (qq1 == buttons1[i][j]) {
                                                        clicked1++;
                                                        position_x = qq1.getX();
                                                        position_y = qq1.getY();
                                                        get_ii = i;
                                                        get_jj = j;
                                                        if (clicked1 == 1) {
                                                            qq1.setText("*");
                                                            suma1++;
                                                            buttons1[i][j].setEnabled(false);
                                                            get_i = i;
                                                            get_j = j;
                                                            startPosX = get_i - 1 < min_x ? get_i : get_i - 1;
                                                            startPosY = get_j - 1 < min_y ? get_j : get_j - 1;
                                                            endPosX = get_i + 1 > max_x ? get_i : get_i + 1;
                                                            endPosY = get_j + 1 > max_y ? get_j : get_j + 1;
                                                        }

                                                        if (clicked1 > 1 && clicked1 < 10) {
                                                            if (buttons1[i][j] == buttons1[get_i][startPosY] || buttons1[i][j] == buttons1[get_i][endPosY]) {
                                                                buttons1[i][j].setEnabled(false);
                                                                buttons1[i][j].setText("*");
                                                                suma1++;
                                                            }

                                                            if (buttons1[i][j] == buttons1[startPosX][get_j] || buttons1[i][j] == buttons1[endPosX][get_j]) {
                                                                buttons1[i][j].setText("*");
                                                                buttons1[i][j].setEnabled(false);
                                                                suma1++;
                                                            }
                                                        }
                                                        if (clicked1 >= 10) {
                                                            int size1 = p1Czteromasztowiec.size();
                                                            int size2 = p1Trojmasztowiec.size();
                                                            int size3 = p1Trojmasztowiec1.size();
                                                            int size4 = p1Dwumasztowiec.size();
                                                            int size5 = p1Dwumasztowiec1.size();
                                                            int size6 = p1Dwumasztowiec2.size();
                                                            int size7 = p1Jednomasztowce.size();
                                                            p1cztero.setVisible(false);
                                                            p1troj1.setVisible(false);
                                                            p1dwoj2.setVisible(false);
                                                            p1jedno.setVisible(false);
                                                            trafiony.setVisible(false);
                                                            pudło.setVisible(false);
                                                            for (int x = 0; x < p1Czteromasztowiec.size(); x++) {
                                                                shoot = position_x == p1Czteromasztowiec.get(x);
                                                                if (shoot) {
                                                                    for (int y = 0; y < p1Czteromasztowiec.size(); y++) {
                                                                        shoot1 = position_y == p1Czteromasztowiec.get(y);
                                                                        if (shoot1) {
                                                                            get_x = x;
                                                                            get_y = y;
                                                                            buttons1[i][j].setEnabled(false);
                                                                            buttons1[i][j].setText("X");
                                                                            trafiony.setVisible(true);
                                                                            break;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            if (get_x >= 0 && get_y >= 0) {
                                                                if (get_x > get_y) {
                                                                    p1Czteromasztowiec.remove(get_x);
                                                                    p1Czteromasztowiec.remove(get_y);
                                                                }
                                                                if (get_y > get_x) {
                                                                    p1Czteromasztowiec.remove(get_y);
                                                                    p1Czteromasztowiec.remove(get_x);
                                                                }
                                                                get_y = -1;
                                                                get_x = -1;
                                                            }
                                                            for (int x = 0; x < p1Trojmasztowiec.size(); x++) {
                                                                shoot = position_x == p1Trojmasztowiec.get(x);
                                                                if (shoot) {
                                                                    for (int y = 0; y < p1Trojmasztowiec.size(); y++) {
                                                                        shoot1 = position_y == p1Trojmasztowiec.get(y);
                                                                        if (shoot1) {
                                                                            get_x1 = x;
                                                                            get_y1 = y;
                                                                            buttons1[i][j].setEnabled(false);
                                                                            buttons1[i][j].setText("X");
                                                                            trafiony.setVisible(true);
                                                                            break;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            if (get_x1 >= 0 && get_y1 >= 0) {
                                                                if (get_x1 > get_y1) {
                                                                    p1Trojmasztowiec.remove(get_x1);
                                                                    p1Trojmasztowiec.remove(get_y1);
                                                                }
                                                                if (get_y1 > get_x1) {
                                                                    p1Trojmasztowiec.remove(get_y1);
                                                                    p1Trojmasztowiec.remove(get_x1);
                                                                }
                                                                get_y1 = -1;
                                                                get_x1 = -1;
                                                            }
                                                            for (int x = 0; x < p1Trojmasztowiec1.size(); x++) {
                                                                shoot = position_x == p1Trojmasztowiec1.get(x);
                                                                if (shoot) {
                                                                    for (int y = 0; y < p1Trojmasztowiec1.size(); y++) {
                                                                        shoot1 = position_y == p1Trojmasztowiec1.get(y);
                                                                        if (shoot1) {
                                                                            get_x2 = x;
                                                                            get_y2 = y;
                                                                            buttons1[i][j].setEnabled(false);
                                                                            buttons1[i][j].setText("X");
                                                                            trafiony.setVisible(true);
                                                                            break;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            if (get_x2 >= 0 && get_y2 >= 0) {
                                                                if (get_x2 > get_y2) {
                                                                    p1Trojmasztowiec1.remove(get_x2);
                                                                    p1Trojmasztowiec1.remove(get_y2);
                                                                }
                                                                if (get_y2 > get_x2) {
                                                                    p1Trojmasztowiec1.remove(get_y2);
                                                                    p1Trojmasztowiec1.remove(get_x2);
                                                                }
                                                                get_y2 = -1;
                                                                get_x2 = -1;
                                                            }
                                                            for (int x = 0; x < p1Dwumasztowiec.size(); x++) {
                                                                shoot = position_x == p1Dwumasztowiec.get(x);
                                                                if (shoot) {
                                                                    for (int y = 0; y < p1Dwumasztowiec.size(); y++) {
                                                                        shoot1 = position_y == p1Dwumasztowiec.get(y);
                                                                        if (shoot1) {
                                                                            get_x3 = x;
                                                                            get_y3 = y;
                                                                            buttons1[i][j].setEnabled(false);
                                                                            buttons1[i][j].setText("X");
                                                                            trafiony.setVisible(true);
                                                                            break;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            if (get_x3 >= 0 && get_y3 >= 0) {
                                                                if (get_x3 > get_y3) {
                                                                    p1Dwumasztowiec.remove(get_x3);
                                                                    p1Dwumasztowiec.remove(get_y3);
                                                                }
                                                                if (get_y3 > get_x3) {
                                                                    p1Dwumasztowiec.remove(get_y3);
                                                                    p1Dwumasztowiec.remove(get_x3);
                                                                }
                                                                get_y3 = -1;
                                                                get_x3 = -1;
                                                            }
                                                            for (int x = 0; x < p1Dwumasztowiec1.size(); x++) {
                                                                shoot = position_x == p1Dwumasztowiec1.get(x);
                                                                if (shoot) {
                                                                    for (int y = 0; y < p1Dwumasztowiec1.size(); y++) {
                                                                        shoot1 = position_y == p1Dwumasztowiec1.get(y);
                                                                        if (shoot1) {
                                                                            get_x4 = x;
                                                                            get_y4 = y;
                                                                            buttons1[i][j].setEnabled(false);
                                                                            buttons1[i][j].setText("X");
                                                                            trafiony.setVisible(true);
                                                                            break;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            if (get_x4 >= 0 && get_y4 >= 0) {
                                                                if (get_x4 > get_y4) {
                                                                    p1Dwumasztowiec1.remove(get_x4);
                                                                    p1Dwumasztowiec1.remove(get_y4);
                                                                }
                                                                if (get_y4 > get_x4) {
                                                                    p1Dwumasztowiec1.remove(get_y4);
                                                                    p1Dwumasztowiec1.remove(get_x4);
                                                                }
                                                                get_y4 = -1;
                                                                get_x4 = -1;
                                                            }
                                                            for (int x = 0; x < p1Dwumasztowiec2.size(); x++) {
                                                                shoot = position_x == p1Dwumasztowiec2.get(x);
                                                                if (shoot) {
                                                                    for (int y = 0; y < p1Dwumasztowiec2.size(); y++) {
                                                                        shoot1 = position_y == p1Dwumasztowiec2.get(y);
                                                                        if (shoot1) {
                                                                            get_x5 = x;
                                                                            get_y5 = y;
                                                                            buttons1[i][j].setEnabled(false);
                                                                            buttons1[i][j].setText("X");
                                                                            trafiony.setVisible(true);
                                                                            break;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            if (get_x5 >= 0 && get_y5 >= 0) {
                                                                if (get_x5 > get_y5) {
                                                                    p1Dwumasztowiec2.remove(get_x5);
                                                                    p1Dwumasztowiec2.remove(get_y5);
                                                                }
                                                                if (get_y5 > get_x5) {
                                                                    p1Dwumasztowiec1.remove(get_y5);
                                                                    p1Dwumasztowiec1.remove(get_x5);
                                                                }
                                                                get_y5 = -1;
                                                                get_x5 = -1;
                                                            }
                                                            for (int x = 0; x < p1Jednomasztowce.size(); x++) {
                                                                shoot = position_x == p1Jednomasztowce.get(x);
                                                                if (shoot) {
                                                                    for (int y = 0; y < p1Jednomasztowce.size(); y++) {
                                                                        shoot1 = position_y == p1Jednomasztowce.get(y);
                                                                        if (shoot1) {
                                                                            get_x6 = x;
                                                                            get_y6 = y;
                                                                            buttons1[i][j].setEnabled(false);
                                                                            buttons1[i][j].setText("X");
                                                                            trafiony.setVisible(true);
                                                                            break;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            if (get_x6 >= 0 && get_y6 >= 0) {
                                                                if (get_x6 > get_y6) {
                                                                    p1Jednomasztowce.remove(get_x6);
                                                                    p1Jednomasztowce.remove(get_y6);
                                                                }
                                                                if (get_y6 > get_x6) {
                                                                    p1Jednomasztowce.remove(get_y6);
                                                                    p1Jednomasztowce.remove(get_x6);
                                                                }
                                                                get_y6 = -1;
                                                                get_x6 = -1;
                                                            }
                                                            if (size1 == p1Czteromasztowiec.size() && size2 == p1Trojmasztowiec.size() && size3 == p1Trojmasztowiec1.size() && size4 == p1Dwumasztowiec.size() && size5 == p1Dwumasztowiec1.size() && size6 == p1Dwumasztowiec2.size() && size7 == p1Jednomasztowce.size()) {
                                                                buttons1[i][j].setText("P");
                                                                buttons[i][j].setEnabled(false);
                                                                player1.setVisible(true);
                                                                player2.setVisible(false);
                                                                pudło.setVisible(true);
                                                                cardLayout.show(mainPanel, "player1");
                                                            }
                                                            if (p1Czteromasztowiec.isEmpty()){
                                                                trafiony.setVisible(false);
                                                                p1cztero.setFont(new Font(p1cztero.getFont().getName(), p1cztero.getFont().getStyle(), 20));
                                                                panel1.add(p1cztero,SwingConstants.CENTER);
                                                            }
                                                            if (p1Trojmasztowiec.isEmpty()){
                                                                p1troj1.setFont(new Font(p1troj1.getFont().getName(), p1troj1.getFont().getStyle(), 20));
                                                                panel1.add(p1troj1,SwingConstants.CENTER);
                                                            }
                                                            if (p1Trojmasztowiec1.isEmpty()){
                                                                p1troj1.setFont(new Font(p1troj1.getFont().getName(), p1troj1.getFont().getStyle(), 20));
                                                                panel1.add(p1troj1,SwingConstants.CENTER);
                                                            }
                                                            if (p1Dwumasztowiec.isEmpty()){
                                                                p1dwoj2.setFont(new Font(p1dwoj2.getFont().getName(), p1dwoj2.getFont().getStyle(), 20));
                                                                panel1.add(p1dwoj2,SwingConstants.CENTER);
                                                            }
                                                            if (p1Dwumasztowiec1.isEmpty()){
                                                                p1dwoj2.setFont(new Font(p1dwoj2.getFont().getName(), p1dwoj2.getFont().getStyle(), 20));
                                                                panel1.add(p1dwoj2,SwingConstants.CENTER);
                                                            }
                                                            if (p1Dwumasztowiec2.isEmpty()){
                                                                p1dwoj2.setFont(new Font(p1dwoj2.getFont().getName(), p1dwoj2.getFont().getStyle(), 20));
                                                                panel1.add(p1dwoj2,SwingConstants.CENTER);
                                                            }
                                                            if (p1Jednomasztowce.size() == size7 - 1) {
                                                                p1jedno.setFont(new Font(p1jedno.getFont().getName(), p1jedno.getFont().getStyle(), 20));
                                                                panel1.add(p1jedno,SwingConstants.CENTER);
                                                            }
                                                            if (p1Czteromasztowiec.isEmpty() && p1Trojmasztowiec.isEmpty() && p1Trojmasztowiec1.isEmpty() && p1Dwumasztowiec.isEmpty() && p1Dwumasztowiec1.isEmpty() && p1Dwumasztowiec2.isEmpty() && p1Jednomasztowce.isEmpty()){
                                                                wygrałeś.setFont(new Font(wygrałeś.getFont().getName(), wygrałeś.getFont().getStyle(), 20));
                                                                panel1.add(wygrałeś,SwingConstants.CENTER);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                            if (suma1 <= 4) {
                                                p2Czteromasztowiec.add(position_x);
                                                p2Czteromasztowiec.add(position_y);
                                                if (suma1 == 4) {
                                                    clicked1 = 0;
                                                    polecenie.setVisible(false);
                                                    polecenie1.setFont(new Font(polecenie.getFont().getName(), polecenie.getFont().getStyle(), 20));
                                                    polecenie1.setVisible(true);
                                                }
                                            }

                                            if (suma1 > 4 && suma1 <= 7) {
                                                p2Trojmasztowiec.add(position_x);
                                                p2Trojmasztowiec.add(position_y);
                                                if (suma1 == 7) {
                                                    clicked1 = 0;
                                                    polecenie1.setVisible(false);
                                                    polecenie2.setFont(new Font(polecenie.getFont().getName(), polecenie.getFont().getStyle(), 20));
                                                    polecenie2.setVisible(true);
                                                }
                                            }

                                            if (suma1 > 7 && suma1 <= 10) {
                                                p2Trojmasztowiec1.add(position_x);
                                                p2Trojmasztowiec1.add(position_y);
                                                if (suma1 == 10) {
                                                    clicked1 = 0;
                                                    polecenie2.setVisible(false);
                                                    polecenie3.setFont(new Font(polecenie.getFont().getName(), polecenie.getFont().getStyle(), 20));
                                                    polecenie3.setVisible(true);
                                                }
                                            }

                                            if (suma1 > 10 && suma1 <= 12) {
                                                p2Dwumasztowiec.add(position_x);
                                                p2Trojmasztowiec.add(position_y);
                                                if (suma1 == 12) {
                                                    clicked1 = 0;
                                                    polecenie3.setVisible(false);
                                                    polecenie4.setFont(new Font(polecenie.getFont().getName(), polecenie.getFont().getStyle(), 20));
                                                    polecenie4.setVisible(true);
                                                }
                                            }

                                            if (suma1 > 12 && suma1 <= 14) {
                                                p2Dwumasztowiec1.add(position_x);
                                                p2Dwumasztowiec1.add(position_y);
                                                if (suma1 == 14) {
                                                    clicked1 = 0;
                                                    polecenie4.setVisible(false);
                                                    polecenie5.setFont(new Font(polecenie.getFont().getName(), polecenie.getFont().getStyle(), 20));
                                                    polecenie5.setVisible(true);
                                                }
                                            }

                                            if (suma1 > 14 && suma1 <= 16) {
                                                p2Dwumasztowiec2.add(position_x);
                                                p2Dwumasztowiec2.add(position_y);
                                                if (suma1 == 16) {
                                                    clicked1 = 0;
                                                    polecenie5.setVisible(false);
                                                    polecenie6.setFont(new Font(polecenie.getFont().getName(), polecenie.getFont().getStyle(), 20));
                                                    polecenie6.setVisible(true);
                                                }
                                            }

                                            if (suma1 == 17) {
                                                p2Jednomasztowce.add(position_x);
                                                p2Jednomasztowce.add(position_y);
                                                clicked1 = 0;
                                                polecenie6.setVisible(false);
                                                polecenie7.setFont(new Font(polecenie.getFont().getName(), polecenie.getFont().getStyle(), 20));
                                                polecenie7.setVisible(true);
                                            }

                                            if (suma1 == 18) {
                                                p2Jednomasztowce.add(position_x);
                                                p2Jednomasztowce.add(position_y);
                                                clicked1 = 0;
                                                polecenie7.setVisible(false);
                                                polecenie8.setFont(new Font(polecenie.getFont().getName(), polecenie.getFont().getStyle(), 20));
                                                polecenie8.setVisible(true);
                                            }

                                            if (suma1 == 19) {
                                                p2Jednomasztowce.add(position_x);
                                                p2Jednomasztowce.add(position_y);
                                                clicked1 = 0;
                                                polecenie8.setVisible(false);
                                                polecenie9.setFont(new Font(polecenie.getFont().getName(), polecenie.getFont().getStyle(), 20));
                                                polecenie9.setVisible(true);
                                            }

                                            if (suma1 == 20) {
                                                p2Jednomasztowce.add(position_x);
                                                p2Jednomasztowce.add(position_y);
                                                clicked1 = 0;
                                                polecenie9.setVisible(false);
                                                polecenie10.setFont(new Font(polecenie.getFont().getName(), polecenie.getFont().getStyle(), 20));
                                                polecenie10.setVisible(true);
                                            }
                                            if (suma1 == 21) {
                                                p1Jednomasztowce.add(position_x);
                                                p1Jednomasztowce.add(position_y);
                                                polecenie10.setVisible(false);
                                                clearAllfields(panel2);
                                                panel1.add(trafiony, SwingConstants.CENTER);
                                                trafiony.setVisible(false);
                                                player2.setVisible(false);
                                                player1.setVisible(true);
                                                cardLayout.show(mainPanel, "player1");
                                                clicked1 = 10;
                                                suma1=22;
                                            }
                                        }
                                    });
                                }
                            }
                        }
                }
            });
            }
        }



        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
    void clearAllfields(JPanel okienko) {
        for (Component C : okienko.getComponents()) {
            if (C instanceof JButton) {
                ((JButton) C).setText("");
                ((JButton) C).setEnabled(true);
            }
        }
    }
}




