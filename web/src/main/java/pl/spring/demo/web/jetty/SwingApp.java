package pl.spring.demo.web.jetty;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import pl.spring.demo.to.BookTo;

public class SwingApp extends JFrame {

	private JTextField txtBookList;
	private JButton btnAddBooks, btnDeleteBook;
//	private List<BookTo> bookList = new ArrayList<BookTo>();

	// @Autowired
	// @Qualifier("bookServiceImpl")
//	private BookService bookServiceImpl = new BookServiceImpl();
	
	
	private JPanel contentPanel;
	private JPanel bookListPanel;
	private JPanel bookDeletedPanel;
	private JPanel bookAddOnePanel;
	private CardLayout cLayout;

	// @Qualifier("bookRepository")
	// private BookRepository bookRepository;\
//	 private BookDaoImpl bookDaoImpl = new BookDaoImpl();

//	 List<BookTo> list = Collections.synchronizedList(bookService.findAllBooks());
//	 List<BookTo> list = BookMapper.map2To(bookDaoImpl.findAll());
	 private JTextField BookDeleted;
	 List<BookTo> list = new ArrayList<BookTo>();
	 private JTable bookListTable;
	 private JScrollPane deletedBooksPane;
	 private JTable deletedBooksTable;
	 private JButton btnAddOneBook;
	 private JTextField textBookTitle;
	 private JTextField textBookAuthor;
	 private JButton btnGoToBooklist;
	 private JButton btnAddBookOne;
	 private JTextField txtAddingNewBook;
	 private JTextField txtTitle;
	 private JTextField txtAuthor;

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

		cLayout = new CardLayout(0, 0);
				
		setName("mainFrame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 596, 480);
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(cLayout);
	
		
		bookListPanel = new JPanel();
		bookListPanel.add(new JLabel("bookListPanel"));
		bookListPanel.setLayout(new BorderLayout(0, 0));
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(16, 203, 362, 266);
		bookListPanel.add(scrollPane, BorderLayout.CENTER);
		
		bookListTable = new JTable();
		Object[] obj = {1, "two", "Marian"};
		Object[] obj2 = {"2", "Name", "Kowal"};
		Object[] obj3 = {"3", "two", "three"};
		Object[] obj4 = {"4", "hello", "Brian K."};
		Object[] obj5 = {"5", "two", "Bla"};
		bookListTable.setModel(new DefaultTableModel(
			new Object[][] { obj, obj2, obj3, obj4, obj5
			},
			new String[] {
				"Id", "Tytul", "Authors"
			}
		));

		
		bookListTable.setSurrendersFocusOnKeystroke(true);
		scrollPane.setViewportView(bookListTable);

		txtBookList = new JTextField();
		txtBookList.setEditable(false);
		bookListPanel.add(txtBookList, BorderLayout.NORTH);
		txtBookList.setHorizontalAlignment(SwingConstants.CENTER);
		txtBookList.setText("Book List");
		txtBookList.setColumns(10);

		btnAddBooks = new JButton("Add Book");
		btnAddBooks.setPreferredSize(new Dimension(100, 40));
		bookListPanel.add(btnAddBooks, BorderLayout.WEST);

		btnDeleteBook = new JButton("Delete Book");
		btnDeleteBook.setPreferredSize(new Dimension(100, 40));
		bookListPanel.add(btnDeleteBook, BorderLayout.EAST);
		
		btnAddOneBook = new JButton("Add one book");

		bookDeletedPanel = new JPanel();
		bookDeletedPanel.add(new JLabel("bookDeletedPanel"));
		bookDeletedPanel.setEnabled(true);
		bookDeletedPanel.setLayout(new BorderLayout(0, 0));
		
		BookDeleted = new JTextField();
		BookDeleted.setEditable(false);
		BookDeleted.setHorizontalAlignment(SwingConstants.CENTER);
		BookDeleted.setText("Deleting book");
		bookDeletedPanel.add(BookDeleted, BorderLayout.NORTH);
		BookDeleted.setColumns(10);
		
		btnGoToBooklist = new JButton("go to bookList");
		bookDeletedPanel.add(btnGoToBooklist, BorderLayout.SOUTH);
		
		deletedBooksPane = new JScrollPane();
		bookDeletedPanel.add(deletedBooksPane, BorderLayout.CENTER);
		
		deletedBooksTable = new JTable();
		deletedBooksTable.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] {"Id", "Tytul", "Authors"}
		));
		deletedBooksPane.add(deletedBooksTable);
		deletedBooksPane.setViewportView(deletedBooksTable);
		
		bookAddOnePanel = new JPanel();
		GridBagLayout gbl_addOneBook = new GridBagLayout();
		gbl_addOneBook.columnWidths = new int[]{0, 72, 226, 231, 0};
		gbl_addOneBook.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_addOneBook.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_addOneBook.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		bookAddOnePanel.setLayout(gbl_addOneBook);
		bookAddOnePanel.setFocusable(true);
        
        contentPanel.add(bookListPanel, "bookListPanel");
        contentPanel.add(bookDeletedPanel, "bookDeletedPanel");
        contentPanel.add(bookAddOnePanel, "bookAddOnePanel");
        
		txtAddingNewBook = new JTextField();
		txtAddingNewBook.setEditable(false);
		txtAddingNewBook.setHorizontalAlignment(SwingConstants.CENTER);
		txtAddingNewBook.setText("Adding new book");
		GridBagConstraints gbc_txtAddingNewBook = new GridBagConstraints();
		gbc_txtAddingNewBook.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAddingNewBook.insets = new Insets(0, 0, 5, 5);
		gbc_txtAddingNewBook.gridx = 2;
		gbc_txtAddingNewBook.gridy = 0;
		bookAddOnePanel.add(txtAddingNewBook, gbc_txtAddingNewBook);
		txtAddingNewBook.setColumns(10);
		
		txtTitle = new JTextField();
		txtTitle.setEditable(false);
		txtTitle.setText("title");
		GridBagConstraints gbc_txtTitle = new GridBagConstraints();
		gbc_txtTitle.insets = new Insets(0, 0, 5, 5);
		gbc_txtTitle.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTitle.gridx = 1;
		gbc_txtTitle.gridy = 2;
		bookAddOnePanel.add(txtTitle, gbc_txtTitle);
		txtTitle.setColumns(10);
		
		textBookTitle = new JTextField();
		GridBagConstraints gbc_textBookTitle = new GridBagConstraints();
		gbc_textBookTitle.fill = GridBagConstraints.HORIZONTAL;
		gbc_textBookTitle.insets = new Insets(0, 0, 5, 5);
		gbc_textBookTitle.gridx = 2;
		gbc_textBookTitle.gridy = 2;
		bookAddOnePanel.add(textBookTitle, gbc_textBookTitle);
		textBookTitle.setColumns(10);
		
		txtAuthor = new JTextField();
		txtAuthor.setEditable(false);
		txtAuthor.setText("author");
		GridBagConstraints gbc_txtAuthor = new GridBagConstraints();
		gbc_txtAuthor.insets = new Insets(0, 0, 5, 5);
		gbc_txtAuthor.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAuthor.gridx = 1;
		gbc_txtAuthor.gridy = 3;
		bookAddOnePanel.add(txtAuthor, gbc_txtAuthor);
		txtAuthor.setColumns(10);
		
		textBookAuthor = new JTextField();
		GridBagConstraints gbc_textBookAuthor = new GridBagConstraints();
		gbc_textBookAuthor.fill = GridBagConstraints.HORIZONTAL;
		gbc_textBookAuthor.insets = new Insets(0, 0, 5, 5);
		gbc_textBookAuthor.gridx = 2;
		gbc_textBookAuthor.gridy = 3;
		bookAddOnePanel.add(textBookAuthor, gbc_textBookAuthor);
		textBookAuthor.setColumns(10);
		
		btnAddBookOne = new JButton("Add book");
		GridBagConstraints gbc_btnAddBookOne = new GridBagConstraints();
		gbc_btnAddBookOne.insets = new Insets(0, 0, 0, 5);
		gbc_btnAddBookOne.gridx = 2;
		gbc_btnAddBookOne.gridy = 4;
		bookAddOnePanel.add(btnAddBookOne, gbc_btnAddBookOne);

		btnAddOneBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cLayout.show(contentPanel, "bookAddOnePanel");
			}
		});
		
		KeyListener keyListener = new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					addOneBook();
				}
			}
			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyTyped(KeyEvent e) {}
		};
		
		textBookTitle.addKeyListener(keyListener);
		textBookAuthor.addKeyListener(keyListener);
		
		btnAddBookOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addOneBook();
			}
		});
		
		btnGoToBooklist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				((DefaultTableModel)bookListTable.getModel()).fireTableDataChanged();
				cLayout.show(contentPanel, "bookListPanel");
			}
		});
		
		bookListPanel.add(btnAddOneBook, BorderLayout.SOUTH);
		btnDeleteBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moveDeletedRows(bookListTable, deletedBooksTable);
				removeSelectedRows(bookListTable);
				cLayout.show(contentPanel, "bookDeletedPanel");
				
			}
		});
		
		btnAddBooks.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				initTable(bookListTable);
				((DefaultTableModel)bookListTable.getModel()).fireTableDataChanged();
			}
		});

	}
	
	private void addOneBook() {
		DefaultTableModel model = (DefaultTableModel) bookListTable.getModel();
		model.addRow(new Object[]{model.getRowCount()+1, textBookTitle.getText(), textBookAuthor.getText()});
		textBookTitle.setText("");
		textBookAuthor.setText("");
		cLayout.show(contentPanel, "bookListPanel");
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
	
	public void moveDeletedRows(JTable table, JTable table2) {
	   DefaultTableModel model2 = (DefaultTableModel) table2.getModel();
	   int[] rows = table.getSelectedRows();
		   for(int i=0;i<rows.length;i++){
		     model2.addRow(getRowAt(bookListTable, rows[i]));
		   }
	}

	public Object[] getRowAt(JTable table, int row) {
		int colNumber = table.getColumnCount();
		Object[] result = new Object[colNumber];
		for (int i = 0; i < colNumber; i++) {
			result[i] = table.getModel().getValueAt(row, i);
		}
		return result;
	}
}
