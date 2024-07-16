package GUI.RockPaperScissors; 

import javax.swing.*; 
import javax.swing.border.Border; 
import java.awt.*; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import java.awt.event.ItemEvent; 
import java.awt.event.ItemListener; 
import java.util.Random; 


public class Page1 extends JFrame implements ActionListener, ItemListener {

    
    private int adam = 0, pc = 0, c = 0; 
    private JTextField field1; 
    private JButton btn1, btn2, btn3, btn4, btn5; 
    private JLabel label1, label2, label3, labelemp1, labelemp2, label4, label5; 
    private JPanel panel1, panel2, panel3; 
    private JComboBox comboBox1, comboBox2; 
    private String[] liste1 = {"Chose", "Rock", "Paper", "Sizers"}; 
    private String[] liste2 = {"Rock", "Paper", "Sizers"}; 
    
    private Icon[] icons = {new ImageIcon(getClass().getResource("tas.png")),
            new ImageIcon(getClass().getResource("kagit.png")),
            new ImageIcon(getClass().getResource("makas.png")),
            new ImageIcon(getClass().getResource("leaf.png"))}; 
   
    public Page1() {
        field1 = new JTextField(12); 
        label1 = new JLabel("Username"); 
        btn1 = new JButton("Clicked"); 
        panel1 = new JPanel();
        panel1.setLayout(new FlowLayout()); 
       
      
       
        panel1.add(label1); 
        panel1.add(field1); 
        panel1.add(btn1);
        btn1.addActionListener(this); 
        
        add(panel1); 
        panel1.setBounds(0, 0, 493, 175); 

        setLayout(null); 
        setSize(510, 214); 
        setVisible(true); 
        setLocationRelativeTo(null); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
      
    }

    
    public static void main(String[] args) {
        new Page1(); 
    }

   
    public void Page2() {
        panel2 = new JPanel(); 
        panel2.setLayout(new GridLayout(3, 3));
        panel2.setBounds(0, 250, 650, 400); 
        comboBox1 = new JComboBox(liste1);
        comboBox2 = new JComboBox(liste2); 
        label2 = new JLabel("Player"); 
        label3 = new JLabel("Computer"); 
        labelemp1 = new JLabel(""); 

        labelemp2 = new JLabel(""); 
        btn2 = new JButton(); btn2.setIcon(icons[3]); 
        btn3 = new JButton("Start"); 
        btn4 = new JButton(); btn4.setIcon(icons[3]); 
        panel2.add(label2); 
        panel2.add(labelemp1); 
        panel2.add(label3); 
        panel2.add(comboBox1); 
        panel2.add(labelemp2); 
        panel2.add(comboBox2); 
        panel2.add(btn2); 
        panel2.add(btn3); 
        panel2.add(btn4); 
        btn3.addActionListener(this);
        comboBox1.addItemListener(this); 

        add(panel2); 
    }

    
    public void Page3() {
        panel3 = new JPanel();             
        panel3.setLayout(null); 
       
        btn5 = new JButton("Restart Game"); 
        label4 = new JLabel("Player : " + adam); 
        label5 = new JLabel("System : " + pc); 
        panel3.setBounds(650, 0, 345, 650);
        label4.setBounds(10, 5, 100, 100); 
        label5.setBounds(10, 50, 100, 100); 
        btn5.setBounds(120, 550, 200, 80); 
        panel3.add(label4); 
        panel3.add(label5); 
        panel3.add(btn5); 
        btn5.addActionListener(this); 

        add(panel3);
    }

    
    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == comboBox1) { 
            switch (comboBox1.getSelectedIndex()) { 
                case 1: 
                    btn2.setIcon(icons[0]); 
                    break;
                case 2: 
                    btn2.setIcon(icons[1]); 
                    break;
                case 3: 
                    btn2.setIcon(icons[2]);
                    break;
                default: 
                    btn2.setIcon(icons[3]); 
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1) { 
            if (field1.getText().equals("ali")) { 
                JOptionPane.showMessageDialog(null, "Login Successful."); 
                setSize(670, 690); 
                panel1.setBounds(0, 0, 650, 184); 
               
                setLocationRelativeTo(null); 
                Page2(); 
            } else { 
                this.dispose(); 
            }
        }
        if (e.getSource() == btn3) { 
            if (c == 0) { 
                setSize(1013, 690); 
                setLocationRelativeTo(null); 
                Page3(); 
                c++; 
            }
            Random rnd = new Random();
            int a = rnd.nextInt(3); 
            comboBox2.setSelectedIndex(a); 
            btn4.setIcon(icons[a]); 

          
            switch (yendiMi(comboBox1.getSelectedIndex(), comboBox2.getSelectedIndex())) {
                case 0: 
                    labelemp1.setText("Lost Game");
                    label5.setText("System : " + (pc + 1));
                    pc += 1;
                    break;
                case 1: 
                    labelemp1.setText("You Won");
                    label4.setText("Player : " + (adam + 1));
                    adam += 1;
                    break;
                case 2: 
                    labelemp1.setText("Draw Game");
                    break;
                default: 
                    labelemp1.setText("");
                    break;
            }
        }
        if (e.getSource() == btn5) { 
            adam = 0; pc = 0;
            label4.setText("Player : " + adam); 
            label5.setText("System : " + pc); 
        }
    }

    
    public int yendiMi(int a, int b) { 
        if (a - 1 == b) { 
            return 2;
        } else {
            if (a == 1 && b == 1) { 
                return 0;
            }
            if (a == 1 && b == 2) { 
                return 1;
            }
            if (a == 2 && b == 0) { 
                return 1;
            }
            if (a == 2 && b == 2) { 
                return 0;
            }
            if (a == 3 && b == 0) { 
                return 0;
            }
            if (a == 3 && b == 1) { 
                return 1;
            }
        }
        return 4; 
    }
}
