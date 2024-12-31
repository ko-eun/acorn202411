package test.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import test.dao.SooniDao;
import test.dto.SooniDto;

public class SooniFrame extends JFrame implements ActionListener {

	JTextField inputName, inputHiredate;
	DefaultTableModel model;
	JTable table;
	

	public SooniFrame(String title) {
		super(title);

		setLayout(new BorderLayout());

		JLabel label2=new JLabel("이름");
		JLabel label3=new JLabel("입사일");

		inputName=new JTextField(10);
		inputHiredate=new JTextField(10);

		JButton addBtn=new JButton("추가");
		JButton deleteBtn = new JButton("삭제");

		JPanel panel=new JPanel();
		panel.add(label2);
		panel.add(inputName);
		panel.add(label3);
		panel.add(inputHiredate);
		panel.add(addBtn);
		panel.add(deleteBtn);

		panel.setBackground(Color.yellow);
		

		add(panel, BorderLayout.NORTH);

		addBtn.addActionListener(this);
		deleteBtn.addActionListener(this);
		
		addBtn.setActionCommand("add");
		deleteBtn.setActionCommand("delete");
		
		

		table=new JTable();

		String[] colNames= {"번호", "이름", "입사일"};

		model=new DefaultTableModel();
		model.setColumnIdentifiers(colNames);
		model.setRowCount(0);

		table.setModel(model);

	    JScrollPane scroll=new JScrollPane(table);
 
	    add(scroll, BorderLayout.CENTER);
	    
	    printSoonigroup();

	    table.getTableHeader().setFont(new Font("Sans-serif", Font.BOLD, 16)); 
	    table.setFont(new Font("Sans-serif", Font.ITALIC, 12)); 
	    table.setRowHeight(25); 
	}
	
	public static void main(String[] args) {
		SooniFrame f = new SooniFrame("멤버 입사일 관리");
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setBounds(100, 100, 800, 500);
		f.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String command = e.getActionCommand();
	
		if(command.equals("add")) {
			
			String name=inputName.getText();
			String hiredate=inputHiredate.getText();
			
			SooniDto dto=new SooniDto();
			dto.setName(name);
			dto.setHiredate(hiredate);
	
			SooniDao dao=new SooniDao();
		
			dao.insert(dto);
		}else if(command.equals("delete")) {
		
			int selectedRow = table.getSelectedRow(); 
			if(selectedRow == -1) {
				JOptionPane.showMessageDialog(this, "삭제할 row를 선택");
				return;
			}

			int num = (int) model.getValueAt(selectedRow, 0);
			new SooniDao().delete(num);
		}
		
	    printSoonigroup();
	    
	   
	}
	

	public void printSoonigroup() {

		model.setRowCount(0);
		

	    SooniDao dao=new SooniDao();
	    List<SooniDto> list=dao.getList();

	    for(SooniDto tmp:list) {

	    	Object[] rowData= {tmp.getNum(), tmp.getName(), tmp.getHiredate()};

	    	model.addRow(rowData);
	    }
	}


}
