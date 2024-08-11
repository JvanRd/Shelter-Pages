package presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;

import dtos.BookDto;
import model.Library;
import model.Book;
import model.IModel;
import model.Section;
import model.User;
import view.Basket;
import view.Button;
import view.EditBalance;
import view.IView;
import view.LogInFrame;
import view.SearchSection;
import view.SectionBase;
import view.SingInFrame;
import view.View;

/**
 * This class represents the Presenter, which is in charge of the communication
 * between the model and the view.
 * @author Juan
 * @version 29/05/2024
 */

public class Presenter implements ActionListener, IPresenter {

	private IView view;
	private IModel model;
	private FileManager fileManager;

	/**
	 * Constructor of the Presenter
	 */

	public Presenter() {
		view = new View(this);
		fileManager = new FileManager();
		model = new Library();
		init();
	}

	/**
	 * This method reads the resources files and sets the data in the model
	 */
	@Override
	public void init() {
		try {
			ArrayList<User> userList = fileManager.getUsers();
			ArrayList<Section> sectionList = fileManager.getSections();
			ArrayList<BookDto> bookList = fileManager.consumeServices();
			addOtherBooks(bookList);
			model.setUsersList(userList);
			model.setSectionList(sectionList);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method adds other books to the model
	 */
	@Override
	public void addOtherBooks(ArrayList<BookDto> bookList) {
		ArrayList<Book> books = new ArrayList<>();
		for (BookDto book : bookList) {
			books.add(BookDto.fromBookDto(book));
		}
		model.addOtherBooks(books);
	}	

	/**
	 * This method is called when an action is performed
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
			case "ingresar" -> login(e.getSource());
			case "crearL" -> createAccount();
			case "crearS" -> createAccount(e.getSource());
			case "door" -> view.showInside();
			case "search" -> view.showSearch();
			case "exclusive" -> view.showExclusive();
			case "fantasy" -> showFantasy();
			case "horror" -> showHorror();
			case "art" -> showArt();
			case "romance" -> showRomance();
			case "addAlicia" -> addAlicia();
			case "addCazadores" -> addCazadores();
			case "addNarnia" -> addNarnia();
			case "addReina" -> addReina();
			case "addChica" -> addChica();
			case "addBazar" -> addBazar();
			case "addGato" -> addGato();
			case "addLady" -> addLady();
			case "addMonet" -> addMonet();
			case "addBarroca" -> addBarroca();
			case "addParaiso" -> addParaiso();
			case "addFealdad" -> addFealdad();
			case "addOrgullo" -> addOrgullo();
			case "addHeart" -> addHeart();
			case "addInvierno" -> addInvierno();
			case "addDyl" -> addDyl();
			case "addMaleducada" -> addMaleducada();
			case "addBlindes" -> addBlindes();
			case "addBoulevard" -> addBoulevard();
			case "backToSection" -> backToSection(e.getSource());
			case "goBasket" -> goBasket();
			case "backOutside" -> backOutSide();
			case "backFromBasket" -> backFromBasket();
			case "backFromSearch" -> backFromSearch();
			case "backFromExclusive" -> backFromExclusive();
			case "backFromEditBalance" -> backFromEditBalance(e.getSource());
			case "buyBasket" -> buyBasket();
			case "searchBooks" -> searchBook(e.getSource());
			case "showEditBalance" -> showEditBalance();
			case "acceptBalance" -> acceptBalance(e.getSource());
			case "deleteBasket" -> deleteBasket(e.getSource());
			case "backLogIn" -> backtoLogIn();
		}
	}

	/**
	 * This method is used to go back to the log in frame
	 */
	@Override
	public void backtoLogIn() {
		view.disguise();
		view.showLogIn();
	}

	/**
	 * This method is used to delete books from the basket
	 * 
	 * @param source
	 */
	@Override
	public void deleteBasket(Object source) {
		JButton btn = (JButton) source;
		Basket basket = (Basket) btn.getTopLevelAncestor();
		ArrayList<String> booksToDelete = basket.getBooksSelected();
		model.deleteBooksUser(booksToDelete, view.getNameUser());
		basket.showBasket(model.getBooks(view.getNameUser()));
		fileManager.persistirUsers(model.getUsers());
	}

	/**
	 * This method is used to accept the edited balance
	 * 
	 * @param source
	 */
	@Override
	public void acceptBalance(Object source) {
		JButton btn = (JButton) source;
		EditBalance eb = (EditBalance) btn.getTopLevelAncestor();
		boolean isAdd = model.addMoney(view.getNameUser(), Integer.parseInt(eb.getEditarSaldo().getText()));
		if (isAdd) {
			fileManager.persistirUsers(model.getUsers());
		}
		eb.setVisible(false);
		view.showBasket(eb.getBasket());
		view.showInfo(view.getNameUser(), model.getMoneyUser(view.getNameUser()));
	}

	/**
	 * This method is used to show the edition of the balance
	 */
	@Override
	public void showEditBalance() {
		view.showEditBalance(model.getBooks(view.getNameUser()), view.getNameUser(),
				model.getMoneyUser(view.getNameUser()));
	}

	/**
	 * This method is used to go back from the edition of the balance
	 * 
	 * @param source
	 */
	@Override
	public void backFromEditBalance(Object source) {
		JButton btn = (JButton) source;
		EditBalance eb = (EditBalance) btn.getTopLevelAncestor();
		eb.setVisible(false);
		eb.restore();
		view.showBasket(eb.getBasket());
	}

	/**
	 * This method is used to search books
	 * 
	 * @param source
	 */
	@Override
	public void searchBook(Object source) {
		JButton btn = (JButton) source;
		SearchSection ss = (SearchSection) btn.getTopLevelAncestor();
		Book book = model.searchBookByTitle(ss.getBusqueda().getText());
		ArrayList<Book> books = model.searchBookByAuthor(ss.getBusqueda().getText());
		if (book != null) {
			Object[][] booksSS = {
					{ book.getName(), book.getAuthor(), book.getPrice() }
			};
			ss.showBooks(booksSS);
		} else {
			Object[][] booksSS = new Object[books.size()][3];
			for (int i = 0; i < books.size(); i++) {
				booksSS[i][0] = books.get(i).getName();
				booksSS[i][1] = books.get(i).getAuthor();
				booksSS[i][2] = books.get(i).getPrice();
			}
			ss.showBooks(booksSS);
			view.showPaneMessage("No tenemos el libro que buscas! :(");
		}
	}

	/**
	 * This method is used to buy the books in the basket
	 */
	@Override
	public void buyBasket() {
		boolean isBuy = model.buyBooksCart(view.getNameUser());
		if (isBuy) {
			view.cleanTable(model.getMoneyUser(view.getNameUser()));
			fileManager.persistirUsers(model.getUsers());
			view.showPaneMessage("Compra exitosa!");
		}
		else{
			view.showPaneMessage("Saldo insuficiente!");
		}
	}

	/**
	 * This method is used to log in
	 * 
	 * @param source
	 */
	@Override
	public void login(Object source) {
		Button btn = (Button) source;
		LogInFrame lif = (LogInFrame) btn.getTopLevelAncestor();
		String user = lif.getTfu().getText();
		String password = lif.getTfp().getText();

		if (model.checkUser(user, password)) {
			view.disguise();
			view.showFacade();
		}else{
			view.showPaneMessage("Usuario o contraseña no válidos, intenta nuevamente!");
		}
	}

	/**
	 * This method is used to show the books of fantasy section
	 */
	@Override
	public void showFantasy() {
		view.disguise();
		view.showFantasy();
	}

	/**
	 * This method is used to show the books of Horror section
	 */
	@Override
	public void showHorror() {
		view.disguise();
		view.showHorror();
	}

	/**
	 * This method is used to show the books of Art section
	 */
	@Override
	public void showArt() {
		view.disguise();
		view.showArt();
	}

	/**
	 * This method is used to show the books of Romance section
	 */
	@Override
	public void showRomance() {
		view.disguise();
		view.showCience();
	}

	/**
	 * This method is used to add the Maleducada book to the basket
	 */
	@Override
	public void addMaleducada(){
		String user = view.getNameUser();
		model.addBookToCart("Maleducada", user);
		fileManager.persistirUsers(model.getUsers());
	}

	/**
	 * This method is used to add the Ensayo sobre la ceguera book to the basket
	 */
	@Override
	public void addBlindes(){
		String user = view.getNameUser();
		model.addBookToCart("Ensayo sobre la ceguera", user);
		fileManager.persistirUsers(model.getUsers());
	}

	/**
	 * This method is used to add the Boulevard book to the basket
	 */
	@Override
	public void addBoulevard(){
		String user = view.getNameUser();
		model.addBookToCart("Boulevard", user);
		fileManager.persistirUsers(model.getUsers());
	}

	/**
	 * This method is used to add the Alicia book to the basket
	 */
	@Override
	public void addAlicia() {
		String user = view.getNameUser();
		model.addBookToCart("Alicia en el pais de las maravillas", user);
		fileManager.persistirUsers(model.getUsers());
	}

	/**
	 * This method is used to add the Cazadores de sombras book to the basket
	 */
	@Override
	public void addCazadores() {
		String user = view.getNameUser();
		model.addBookToCart("Cazadores de sombras", user);
		fileManager.persistirUsers(model.getUsers());

	}

	/**
	 * This method is used to add the Narnia book to the basket
	 */
	@Override
	public void addNarnia() {
		String user = view.getNameUser();
		model.addBookToCart("Narnia", user);
		fileManager.persistirUsers(model.getUsers());
	}

	/**
	 * This method is used to add the La reina roja book to the basket
	 */
	@Override
	public void addReina() {
		String user = view.getNameUser();
		model.addBookToCart("La reina roja", user);
		fileManager.persistirUsers(model.getUsers());
	}

	/**
	 * This method is used to add the La chica gris book to the basket
	 */
	@Override
	public void addChica() {
		String user = view.getNameUser();
		model.addBookToCart("La chica gris", user);
		fileManager.persistirUsers(model.getUsers());

	}

	/**
	 * This method is used to add the El bazar de los malos sueños book to the basket
	 */
	@Override
	public void addBazar() {
		String user = view.getNameUser();
		model.addBookToCart("El bazar de los malos sueños", user);
		fileManager.persistirUsers(model.getUsers());

	}

	/**
	 * This method is used to add the El gato negro book to the basket
	 */
	@Override
	public void addGato() {
		String user = view.getNameUser();
		model.addBookToCart("El gato negro", user);
		fileManager.persistirUsers(model.getUsers());

	}

	/**
	 * This method is used to add the Lady masacre book to the basket
	 */
	@Override
	public void addLady() {
		String user = view.getNameUser();
		model.addBookToCart("Lady Masacre", user);
		fileManager.persistirUsers(model.getUsers());
	}

	/**
	 * This method is used to add the Monet book to the basket
	 */
	@Override
	public void addMonet() {
		String user = view.getNameUser();
		model.addBookToCart("Monet", user);
		fileManager.persistirUsers(model.getUsers());
	}

	/**
	 * This method is used to add the Muerte Barroca book to the basket
	 */
	@Override
	public void addBarroca() {
		String user = view.getNameUser();
		model.addBookToCart("Muerte Barroca", user);
		fileManager.persistirUsers(model.getUsers());
	}

	/**
	 * This method is used to add the El paraiso a pinceladas book to the basket
	 */
	@Override
	public void addParaiso() {
		String user = view.getNameUser();
		model.addBookToCart("El paraiso a pinceladas", user);
		fileManager.persistirUsers(model.getUsers());
	}

	/**
	 * This method is used to add the Historia de la fealdad book to the basket
	 */
	@Override
	public void addFealdad() {
		String user = view.getNameUser();
		model.addBookToCart("Historia de la fealdad", user);
		fileManager.persistirUsers(model.getUsers());
	}

	/**
	 * This method is used to add the Orgullo y prejuicio book to the basket
	 */
	@Override
	public void addOrgullo() {
		String user = view.getNameUser();
		model.addBookToCart("Orgullo y prejuicio", user);
		fileManager.persistirUsers(model.getUsers());
	}

	/**
	 * This method is used to add the Heartstopper book to the basket
	 */
	@Override
	public void addHeart() {
		String user = view.getNameUser();
		model.addBookToCart("Heartstopper", user);
		fileManager.persistirUsers(model.getUsers());
	}

	/**
	 * This method is used to add the Este invierno book to the basket
	 */
	@Override
	public void addInvierno() {
		String user = view.getNameUser();
		model.addBookToCart("Este invierno", user);
		fileManager.persistirUsers(model.getUsers());
	}

	/**
	 * This method is used to add the Dash y Lily book to the basket
	 */
	@Override
	public void addDyl() {
		String user = view.getNameUser();
		model.addBookToCart("Dash y Lily", user);
		fileManager.persistirUsers(model.getUsers());
	}

	/**
	 * This method is used to go back to the sections frame
	 */
	@Override
	public void backToSection(Object source) {
		JButton btnBack = (JButton) source;
		SectionBase sectionBase = (SectionBase) btnBack.getTopLevelAncestor();
		sectionBase.setVisible(false);
		view.showInside();
	}

	/**
	 * This method is used to go to the basket
	 */
	@Override
	public void goBasket() {
		view.disguise();
		Object[][] books = model.getBooks(view.getNameUser());
		view.showBasket(books);
		view.showInfo(view.getNameUser(), model.getMoneyUser(view.getNameUser()));
	}

	/**
	 * This method is used to go back to the outside frame.
	 */
	@Override
	public void backOutSide() {
		view.disguise();
		view.showFacade();
	}

	/**
	 * This method is used to go back to the inside frame.
	 */
	@Override
	public void backFromBasket() {
		view.disguise();
		view.showInside();
	}

	/**
	 * This method is used to go back to the facade frame from the search frame.
	 */
	@Override
	public void backFromSearch() {
		view.showOutsideFromSearch();
		view.showFacade();
	}

	/**
	 * This method is used to go back to the facade frame from the exclusive frame.
	 */
	@Override
	public void backFromExclusive() {
		view.quitExclusive();
		view.showFacade();
	}

	/**
	 * This method is used show the sign up frame to create an account.
	 */
	@Override
	public void createAccount() {
		view.disguise();
		view.showSignUp();
	}

	/**
	 * This method is used to register an account in the system.
	 */
	@Override
	public void createAccount(Object source) {
		Button btnCreate = (Button) source;
		SingInFrame sif = (SingInFrame) btnCreate.getTopLevelAncestor();
		String userName = sif.getTfu().getText();
		String password = sif.getTfp().getText();
		String money = sif.getTfm().getText();
		User newUser = new User(userName, password, Integer.parseInt(money));
		boolean isRegister = model.registerUser(newUser);
		if (isRegister) {
			view.showLogIn();
			fileManager.persistirUsers(model.getUsers());
		}
	}
}