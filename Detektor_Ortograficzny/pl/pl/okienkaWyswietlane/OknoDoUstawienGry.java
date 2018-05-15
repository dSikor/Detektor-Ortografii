package pl.okienkaWyswietlane;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pl.glowneKlasyAplikacji.UstawieniaGry;
import pl.innePomocneKlasy.Panel_Z_Tlem;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import java.awt.Color;

import java.awt.Font;


import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerModel;

import java.awt.Dialog.ModalExclusionType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;


public class OknoDoUstawienGry extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane_Okno;
	private JTextField textField_Imie;
	private JSpinner spinner_LiczbaHasel;
	private JSpinner spinner_Regu³yGramatyczne;
	private boolean czyUstawionoWszystkiePola;
	private BufferedImage buforNaGrafike;
	
	
	public OknoDoUstawienGry(UstawieniaGry g) {
		
		setResizable(false);
		setLocationByPlatform(true);
		setLocale(new Locale("pl", "PL"));
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		
		
		setEverythingSet(false);
		setTitle("Ustawienia");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 374, 189);
		
		setLocationRelativeTo(null);
		
		contentPane_Okno = new Panel_Z_Tlem("tloOknaUstawienGry_Wyniku.jpg");	
		contentPane_Okno.setBorder(new EmptyBorder(5, 5, 5, 5));
				
		setContentPane(contentPane_Okno);
		
		
		JLabel lblImieGracza = new JLabel("Imie Gracza");
		lblImieGracza.setFont(lblImieGracza.getFont().deriveFont(lblImieGracza.getFont().getStyle() | Font.BOLD));
		lblImieGracza.setForeground(Color.BLACK);
		lblImieGracza.setHorizontalAlignment(SwingConstants.LEFT);
		
		textField_Imie = new JTextField();
		textField_Imie.setColumns(10);
		
		JLabel lblLiczbaHase = new JLabel("Liczba hase\u0142");
		lblLiczbaHase.setFont(lblLiczbaHase.getFont().deriveFont(lblLiczbaHase.getFont().getStyle() | Font.BOLD));
		
		spinner_LiczbaHasel = new JSpinner();
		spinner_LiczbaHasel.setModel(new SpinnerNumberModel(0, 0, 15, 1));
		
		JLabel lblwiczonaRegula = new JLabel("\u0106wiczona regula");
		lblwiczonaRegula.setFont(lblImieGracza.getFont().deriveFont(lblImieGracza.getFont().getStyle() | Font.BOLD));
		lblwiczonaRegula.setForeground(Color.BLACK);
		lblwiczonaRegula.setHorizontalAlignment(SwingConstants.LEFT);
		
		 String[] znaki = {"rz/¿","ch/h","ó/u"};
		 ArrayList<CharSequence> regulyGramatyczne = new ArrayList<>(Arrays.asList(znaki));
		 
		 SpinnerModel model = new SpinnerListModel(regulyGramatyczne);
		 spinner_Regu³yGramatyczne = new JSpinner(model);
		
			
		JButton btnOk = new JButton("OK");
		btnOk.setBackground(new Color(192, 192, 192));
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
					
					g.setNameOfPlayer(textField_Imie.getText());
					g.setNumberOfPassword((Integer)spinner_LiczbaHasel.getValue());				
					g.setRegulaOrtograficzna_sekfencja((CharSequence)spinner_Regu³yGramatyczne.getValue());
					
					boolean brakImieniaGracza=g.getNameOfPlayer().equals("");
					boolean brakUstawieniaLiczbyHasel=(g.getNumberOfPassword()==0);		
					boolean brakUstawieñGry = (brakImieniaGracza && brakUstawieniaLiczbyHasel);
					
					
					if(brakUstawieñGry)
					{
						JOptionPane.showMessageDialog(null,
							    "Nie poda³eœ swojego imienia i liczby zgadywanych hase³ !!! ",
							    "Ostrze¿enie",
							    JOptionPane.WARNING_MESSAGE);
						setEverythingSet(false);
					}else if(brakImieniaGracza)
					{
						JOptionPane.showMessageDialog(null,
							    "Nie poda³eœ swojego imienia !!! ",
							    "Ostrze¿enie",
							    JOptionPane.WARNING_MESSAGE);
						setEverythingSet(false);
					}else if(brakUstawieniaLiczbyHasel)
					{
						JOptionPane.showMessageDialog(null,
							    "Nie poda³eœ liczby zgadywanych hase³ !!! ",
							    "Ostrze¿enie",
							    JOptionPane.WARNING_MESSAGE);
						setEverythingSet(false);
					}
					else
					{
						setEverythingSet(true);
					}				
			}
		});
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.GRAY);
		panel.setBackground(Color.WHITE);
		
							
		GroupLayout gl_contentPane = new GroupLayout(contentPane_Okno);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap(18, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblLiczbaHase)
								.addComponent(lblImieGracza)
								.addComponent(lblwiczonaRegula))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textField_Imie, GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
								.addComponent(spinner_LiczbaHasel)
								.addComponent(spinner_Regu³yGramatyczne))
							.addGap(18)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(92)
							.addComponent(btnOk)))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblImieGracza)
								.addComponent(textField_Imie, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblLiczbaHase)
								.addComponent(spinner_LiczbaHasel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(17)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblwiczonaRegula)
								.addComponent(spinner_Regu³yGramatyczne, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnOk))
		);
		contentPane_Okno.setLayout(gl_contentPane);
		
		
		setGrafic("grafika_ksiazka.jpg",buforNaGrafike,panel);
		
		
		this.setVisible(true);
				
	}


	public boolean isEverythingSet() {
		return czyUstawionoWszystkiePola;
	}


	public void setEverythingSet(boolean isEverythingSet) {
		this.czyUstawionoWszystkiePola = isEverythingSet;
	}
	
	public void setGrafic(String nazwaGrafiki,BufferedImage img , JPanel p)
	{
		File imageFile = new File(nazwaGrafiki);
		try {
			img = ImageIO.read(imageFile);
		} catch (IOException e) {
			System.err.println("Blad odczytu obrazka");
			e.printStackTrace();
		}
			
		JLabel picLabel = new JLabel(new ImageIcon(img));
		
		p.add(picLabel);
		p.repaint();
					
	}
}
