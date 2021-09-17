package deneme2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Color;

public class frame extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame frame = new frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1024, 768);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//PC VS HUMAN BUTONU
		JButton btn_com_vs_hum = new JButton("Computer vs. Human");
		btn_com_vs_hum.setFocusPainted(false);
		btn_com_vs_hum.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
		btn_com_vs_hum.setBackground(Color.LIGHT_GRAY);
		btn_com_vs_hum.setForeground(Color.DARK_GRAY);
		btn_com_vs_hum.setBounds(384, 464, 256, 64);
		contentPane.add(btn_com_vs_hum);
		btn_com_vs_hum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				JFrame framehuman = new JFrame();
				framehuman.setSize(1024, 768);
				framehuman.setVisible(true);
				framehuman.setLocationRelativeTo(null);
				HumvsCom panelhvsh = new HumvsCom();
				panelhvsh.setSize(1024, 768);
				panelhvsh.setBackground(Color.DARK_GRAY);
				framehuman.getContentPane().add(panelhvsh);
			}
		});
		
		//PC VS PC BUTONU
		JButton btn_com_vs_com = new JButton("Computer vs. Computer");
		btn_com_vs_com.setFocusPainted(false);
		btn_com_vs_com.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
		btn_com_vs_com.setBackground(Color.LIGHT_GRAY);
		btn_com_vs_com.setForeground(Color.DARK_GRAY);
		btn_com_vs_com.setBounds(384, 364, 256, 64);
		contentPane.add(btn_com_vs_com);
		btn_com_vs_com.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				JFrame framepc = new JFrame();
				framepc.setSize(1024, 768);
				framepc.setVisible(true);
				framepc.setLocationRelativeTo(null);
				ComVsCom panelcvsc = new ComVsCom();
				panelcvsc.setSize(1024, 768);
				panelcvsc.setBackground(Color.DARK_GRAY);
				framepc.getContentPane().add(panelcvsc);
			}
		});
		
		//EXIT BUTONU
		JButton btn_exit = new JButton("Exit");
		btn_exit.setFocusPainted(false);
		btn_exit.setFont(new Font("Bahnschrift", Font.PLAIN, 18));
		btn_exit.setBackground(Color.LIGHT_GRAY);
		btn_exit.setForeground(Color.DARK_GRAY);
		btn_exit.setBounds(384, 564, 256, 64);
		contentPane.add(btn_exit);
		btn_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				System.exit(0);
			}
		});
		
		//OYUN BASLIK LABEL'I
		JLabel lblNewLabel = new JLabel("Pokemon Card Game");
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 64));
		lblNewLabel.setBounds(192, 96, 640, 128);
		contentPane.add(lblNewLabel);
	}
}
