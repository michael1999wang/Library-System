import java.applet.*;
import java.awt.*;
import javax.swing.*;

public class LibraryTest extends Applet {

	// Panels
	Panel elements = new Panel();

	// Labels
	Label nameLabel = new Label("                  Name:");
	Label traitLabel = new Label("                  Trait:");

	// TextField
	TextField name = new TextField(10);
	TextField trait = new TextField(10);

	// Buttons
	Button addButton = new Button("Add");
	Button removeButton = new Button("Remove");
	Button checkinButton = new Button("Check in");
	Button checkoutButton = new Button("Check out");
	Button statusButton = new Button("Status");

	// Checkboxes
	CheckboxGroup type = new CheckboxGroup();
	Checkbox bookCheckbox = new Checkbox("Book", true, type);
	Checkbox periodicalCheckbox = new Checkbox("Periodical", false, type);
	Checkbox audioTapeCheckbox = new Checkbox("Audio Tape", false, type);
	Checkbox softwareCheckbox = new Checkbox("Software", false, type);

	// Instances
	Book book = new Book();
	Periodicals periodicals = new Periodicals();
	AudioTapes audiotapes = new AudioTapes();
	Software software = new Software();

	public void init() {
		setSize(450, 100);

		elements.setLayout(new GridLayout(4, 4, 1, 1));
		elements.add(nameLabel);
		elements.add(name);
		elements.add(traitLabel);
		elements.add(trait);
		elements.add(bookCheckbox);
		elements.add(periodicalCheckbox);
		elements.add(audioTapeCheckbox);
		elements.add(softwareCheckbox);
		elements.add(addButton);
		elements.add(removeButton);
		elements.add(checkinButton);
		elements.add(checkoutButton);
		elements.add(statusButton);
		add(elements);

		trait.setText("Author");
	}

	public boolean action(Event e, Object o) {
		if (e.target instanceof Checkbox) {
			if (e.target == bookCheckbox)
				trait.setText("Author");
			else if (e.target == periodicalCheckbox)
				trait.setText("ISSN");
			else if (e.target == audioTapeCheckbox)
				trait.setText("Speaker");
			else if (e.target == softwareCheckbox)
				trait.setText("Platform");
		} else if (e.target instanceof Button) {
			if (e.target == addButton) {
				getItemObject(e, o).add(name.getText(), trait.getText());
			} else if (e.target == removeButton) {
				getItemObject(e, o).remove(name.getText());
			} else if (e.target == checkinButton) {
				getItemObject(e, o).checkin(name.getText());
			} else if (e.target == checkoutButton) {
				getItemObject(e, o).checkout(name.getText());
			} else if (e.target == statusButton) {
				getItemObject(e, o).getstatus(name.getText());
				showStatus(getItemObject(e, o).getCategoryType() + " " + name.getText() + " "
						+ getItemObject(e, o).getstatusmessage(name.getText()));
			}
		}

		return true;
	}

	public Library getItemObject(Event e, Object o) {
		Library library = null;

		if (bookCheckbox.getState() == true) {
			library = book;
		} else if (periodicalCheckbox.getState() == true) {
			library = periodicals;
		} else if (audioTapeCheckbox.getState() == true) {
			library = audiotapes;
		} else if (softwareCheckbox.getState() == true) {
			library = software;
		}

		return library;
	}

}


