import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.filechooser.FileFilter;

public class Main extends JFrame{
	public Main() {
		super("메모장");
		
		
		JPanel pnl = new JPanel();
		
		JFileChooser chooser = new JFileChooser();
		
		FileFilter filter = new FileFilter(){; //파일을 선택할 수 있는 다이어로그 같은 클래스
			@Override
			public String getDescription() {
				return "텍스트 파일";
			}
			
			@Override
			public boolean accept(File f) {
				if (f.isDirectory()) {
					return true;
				}
				return f.getName().endsWith(".txt");
			}
		};
		
		SpringLayout springLayout = new SpringLayout();
		TextArea textArea = new TextArea();
		springLayout.putConstraint(SpringLayout.NORTH, textArea, -409, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, textArea, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, textArea, -10, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, textArea, -10, SpringLayout.EAST, getContentPane());
		getContentPane().add(textArea);
		getContentPane().setLayout(springLayout);
		
		JButton openBtn = new JButton("열기");
		springLayout.putConstraint(SpringLayout.NORTH, openBtn, 10, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, openBtn, 100, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, openBtn, 183, SpringLayout.WEST, getContentPane());
		getContentPane().add(openBtn);
		
		openBtn.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				
				chooser.showOpenDialog(null);	// 버튼이 클릭되면 새 창을 열어라
				StringBuilder sb; 
				BufferedReader bf = null;
				
				File file = chooser.getSelectedFile();
				try {
					bf = new BufferedReader(new FileReader(file));
					String line;
					
					while((line = bf.readLine()) != null) {
						System.out.println(line);
				
						
					}
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				} finally {
					if(bf != null) {
						try {
							bf.close();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				}	
				textArea.setText("");
			}
		});	
		

		
		JButton saveBtn = new JButton("저장");
		springLayout.putConstraint(SpringLayout.NORTH, saveBtn, 10, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, saveBtn, 51, SpringLayout.EAST, openBtn);
		springLayout.putConstraint(SpringLayout.SOUTH, saveBtn, 0, SpringLayout.SOUTH, openBtn);
		springLayout.putConstraint(SpringLayout.EAST, saveBtn, 134, SpringLayout.EAST, openBtn);
		getContentPane().add(saveBtn);
		
	
		
		
		saveBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				BufferedWriter bw = null;
				int result = chooser.showSaveDialog(null); // 저장창을 띄움 .. 열기나 저장 버튼을 누르면 0, 닫기나 취소는 1  
				
				if(result == JFileChooser.APPROVE_OPTION) {
					
					File file = chooser.getSelectedFile();
					try {
						bw = new BufferedWriter(new FileWriter(file));
						
						bw.write(textArea.getText());
						
					} catch (IOException e1) {
						
						e1.printStackTrace();
					}finally {
						if(bw != null) {
							try {
								bw.flush();
								bw.close();
							}catch (IOException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
						}
					}
					
				}
			}
		});
		
	
		chooser.setFileFilter(filter);
		
		
	
		setSize(500,500);
		
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
		
		
	}
	

	
	public static void main(String[] args) {
	
	
		
		new Main();

			
			
			
			
			
		}
	}

