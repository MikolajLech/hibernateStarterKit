package pl.spring.demo.web.jetty;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import pl.spring.demo.dao.impl.BookDaoImpl;
import pl.spring.demo.to.BookTo;

public class SwingApp extends JFrame {

	private JPanel contentPanel;
	private JTextField txtBookList;
	private JButton btnAddBook, btnDeleteBook;
//	private List<BookTo> bookList = new ArrayList<BookTo>();

	// @Autowired
	// @Qualifier("bookServiceImpl")
//	private BookService bookServiceImpl = new BookServiceImpl();
	private Panel bookListPanel;
	private Panel bookDeleted;
	private JTextField BookDeleted;
	private JButton btnGoToBooklist;

	// @Qualifier("bookRepository")
	// private BookRepository bookRepository;\
	 private BookDaoImpl bookDaoImpl = new BookDaoImpl();

//	 List<BookTo> list = Collections.synchronizedList(bookService.findAllBooks());
//	 List<BookTo> list = BookMapper.map2To(bookDaoImpl.findAll());
	 List<BookTo> list = new ArrayList<BookTo>();
	 private JTable bookListTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SwingApp frame = new SwingApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SwingApp() {
//		list.add(BookMapper.map(bookDaoImpl.findOne(1L)));
		
		// open/read the application context file
		// ClassPathXmlApplicationContext context = new
		// ClassPathXmlApplicationContext("classpath*:spring/web-context.xml");
		// instantiate our spring objects from the application context
		// bookService = (BookServiceImpl)context.getBean("bookServiceImpl");
		// bookDaoImpl = (BookDao)context.getBean("bookDaoImpl");
		// // create a FileEventType object from the application context
		// FileEventType fileEventType =
		// (FileEventType)ctx.getBean("fileEventType");
		// // insert the file event with the spring dao

		setName("mainFrame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 596, 480);
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(new CardLayout(0, 0));

//		DefaultTableModel model = new DefaultTableModel(3, 0);
//		model.addRow(obj);
//		model.addColumn("BookId");
//		model.addColumn("title");
//		model.addColumn("authors");
		
		bookListPanel = new Panel();
		contentPanel.add(bookListPanel, "name_3720736775513");
		bookListPanel.setLayout(new BorderLayout(0, 0));
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(16, 203, 362, 266);
		bookListPanel.add(scrollPane, BorderLayout.CENTER);
		
		bookListTable = new JTable();
		Object[] obj = {"oneData", "two", "three"};
		bookListTable.setModel(new DefaultTableModel(
			new Object[][] { obj
			},
			new String[] {
				"Id", "Tytul", "Authors"
			}
		));

		
		bookListTable.setSurrendersFocusOnKeystroke(true);
		scrollPane.setViewportView(bookListTable);
//		bookListPanel.revalidate();
//		bookListPanel.repaint();

		txtBookList = new JTextField();
		bookListPanel.add(txtBookList, BorderLayout.NORTH);
		txtBookList.setEnabled(false);
		txtBookList.setHorizontalAlignment(SwingConstants.CENTER);
		txtBookList.setText("Book List");
		txtBookList.setColumns(10);

		btnAddBook = new JButton("Add Book");
		btnAddBook.setPreferredSize(new Dimension(100, 40));
		bookListPanel.add(btnAddBook, BorderLayout.WEST);
		btnAddBook.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				initTable(bookListTable);
				bookListTable.setModel((DefaultTableModel)bookListTable.getModel());
//				model.fireTableDataChanged();
//				((DefaultTableModel)bookListTable.getModel()).fireTableDataChanged();
//				bookListTable.repaint();
			}
		});

		btnDeleteBook = new JButton("Delete Book");
		btnDeleteBook.setPreferredSize(new Dimension(100, 40));
		bookListPanel.add(btnDeleteBook, BorderLayout.EAST);
		btnDeleteBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeSelectedRows(bookListTable);
				bookDeleted.setVisible(true);
				bookListPanel.setVisible(false);
			}
		});
		
		bookDeleted = new Panel();
		bookDeleted.setEnabled(true);
		contentPanel.add(bookDeleted, "name_4253176806168");
		bookDeleted.setLayout(new BorderLayout(0, 0));
		
		BookDeleted = new JTextField();
		BookDeleted.setHorizontalAlignment(SwingConstants.CENTER);
		BookDeleted.setText("Deleting book");
		bookDeleted.add(BookDeleted, BorderLayout.NORTH);
		BookDeleted.setColumns(10);
		
		btnGoToBooklist = new JButton("go to bookList");
		bookDeleted.add(btnGoToBooklist, BorderLayout.CENTER);
		btnGoToBooklist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookListPanel.setVisible(true);
				BookDeleted.setVisible(false);
			}
		});
	}
	
	private void initTable(JTable table) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		int columnNum = model.getRowCount();
		for (int i = 1; i < 6; i++, columnNum++) {
			model.addRow(new Object[] { columnNum+1, "to", "you" });
		}
	}
	
	public void removeSelectedRows(JTable table) {
	   DefaultTableModel model = (DefaultTableModel) table.getModel();
	   int[] rows = table.getSelectedRows();
	   for(int i=0;i<rows.length;i++){
	     model.removeRow(rows[i]-i);
	   }
	}


}
