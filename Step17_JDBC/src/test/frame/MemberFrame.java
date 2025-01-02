package test.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import test.dao.MemberDao;
import test.dto.MemberDto;

public class MemberFrame extends JFrame 
					implements ActionListener, PropertyChangeListener{
	//필요한 필드 정의하기
	JTextField inputName, inputAddr;
	DefaultTableModel model;
	JTable table; // 필드를 정의했으니 66번 줄의 field 선언은 지워줘야한다.
	
	//생성자
	public MemberFrame(String title) {
		super(title);
		//레이아웃 설정(BorderLayout)
		setLayout(new BorderLayout());
		//JLable 2개
		JLabel label2=new JLabel("이름");
		JLabel label3=new JLabel("주소");
		//JTextField 1개
		inputName=new JTextField(10);
		inputAddr=new JTextField(10);
		//JButton
		JButton addBtn=new JButton("추가");
		JButton deleteBtn = new JButton("삭제");
		//페널에 UI 배치
		JPanel panel=new JPanel();
		panel.add(label2);
		panel.add(inputName);
		panel.add(label3);
		panel.add(inputAddr);
		panel.add(addBtn);
		panel.add(deleteBtn);
		//페널의 배경색 설정 
		panel.setBackground(Color.orange);
		
		//페널을 프레임의 위쪽에 배치
		add(panel, BorderLayout.NORTH);
		
		//버튼에 액션 리스너 등록
		addBtn.addActionListener(this);
		deleteBtn.addActionListener(this);
		// 버튼에 액션 command 설정 
		addBtn.setActionCommand("add");
		deleteBtn.setActionCommand("delete");
		
		
		//회원 목록을 출력할 테이블
		table=new JTable();
		//테이블의 칼럼명을 배열로 미리 준비한다.
		String[] colNames= {"번호", "이름", "주소"};
		//테이블에 연결할 모델 객체
		model=new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				// 0 번째 칼럼은 false 를 리턴해서 수정 불가능하게 만들고
				if(column == 0) {
					return false;
				}else {// 그 이외의 경우에는 true 를 리턴해서 수정 가능하게 만든다.
					return true;
				}
			}
		};
	
		model.setColumnIdentifiers(colNames);
		model.setRowCount(0);
		//모델을 테이블에 연결
		table.setModel(model);
		//스크롤이 가능 하도록 테이블을 JScrollPane 에 감싼다.
	    JScrollPane scroll=new JScrollPane(table);
	    //JScrollPane  을 프레임의 가운데에 배치하기 
	    add(scroll, BorderLayout.CENTER);
	    
	    printMember();
	    //칼럼의 제목 글자 조정 
	    table.getTableHeader().setFont(new Font("Sans-serif", Font.BOLD, 18)); 
	    table.setFont(new Font("Sans-serif", Font.PLAIN, 16)); // 데이터 글자 크기 14
	    table.setRowHeight(25); // 각 행의 높이를 조정
	    
	    // 테이블 값이 바뀌었는지 감시할 리스너 등록
	    table.addPropertyChangeListener(this);
	}//생성자 
	
	public static void main(String[] args) {
		MemberFrame f=new MemberFrame("회원정보 관리");
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setBounds(100, 100, 800, 500);
		f.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 눌러진 버튼의 action command 을 읽어온다
		String command = e.getActionCommand();
		// action command 를 이용해서 분기한다.
		if(command.equals("add")) {// java 에서는 문자열 비교를 .equals() 메소드를 이용해서 비교해야한다.
			//입력한 이름과 주소를 읽어온다.
			String name=inputName.getText();
			String addr=inputAddr.getText();
			//입력한 이름과 주소를 MemberDto 객체에 담는다.
			MemberDto dto=new MemberDto();
			dto.setName(name);
			dto.setAddr(addr);
			//MemberDao 객체를 생성해서 
			MemberDao dao=new MemberDao();
			// insert() 메소드를 이용해서 회원정보를 DB 에 저장한다.
			dao.insert(dto);
		}else if(command.equals("delete")) {
			// 선택된 JTable Row 가 있다면 몇 번째 row 가 선택되었는지를 읽어와서 
			int selectedRow = table.getSelectedRow(); 
			if(selectedRow == -1) {
				JOptionPane.showMessageDialog(this, "삭제할 row를 선택하는 게 좋을 걸?");
				return; // 메소드를 여기서 끝내기
			}
			// 삭제할 회원의 번호(primary key)를 읽어온다.
			int num = (int) model.getValueAt(selectedRow, 0);
			new MemberDao().delete(num);
		}
		
	    printMember();
	    
	   
	}
	
	//회원목록을 JTable 에 출력하는 메소드
	public void printMember() {
		//기존에 출력된 내용을 초기화 한후에 
		model.setRowCount(0);
		
	    //테이블에 출력할 회원 목록 얻어오기
	    MemberDao dao=new MemberDao();
	    List<MemberDto> list=dao.getList();
	    //반복문 돌면서
	    for(MemberDto tmp:list) {
	    	//MemberDto 객체에 담긴 회원정보를 이용해서 Object[] 에 담은다음
	    	Object[] rowData= {tmp.getNum(), tmp.getName(), tmp.getAddr()};
	    	//테이블에 연결된 모델에 추가하기
	    	model.addRow(rowData);
	    }
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		/*
		 * 	property name 이 "tableCellEditor" 이고
		 *  table 이 수정 중이 아닐 때
		 *  현재 포커스가 있는 곳의 정보를 모두 읽어와서 DB 에 수정 반영하기
		 */
		if(evt.getPropertyName().equals("tableCellEditor") && !table.isEditing()) {
			// 현재 포커스가 있는 row 의 정보를 DB 에 수정 반영한다.
			// 변화된 값을 읽어와서 DB 에 반영한다.
			// 수정된 칼럼에 있는 row 전체의 값을 읽어온다.
			int selectedIndex=table.getSelectedRow();
			int num=(int)model.getValueAt(selectedIndex, 0);
			String name=(String)model.getValueAt(selectedIndex, 1);
			String addr=(String)model.getValueAt(selectedIndex, 2);
			//수정할 회원의 정보를 MemberDto 객체에 담고 
			MemberDto dto=new MemberDto(num, name, addr);
			dto.setNum(num);
			dto.setName(name);
			dto.setAddr(addr);
			//DB에 저장하기 
			new MemberDao().update(dto);
			//선택된 포커스 clear
			table.clearSelection();
	
		}
	}

}
