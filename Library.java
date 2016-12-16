public abstract class Library {

	String name[] = new String[100];
	String trait[] = new String[100];
	boolean status[] = new boolean[100];

	int check = 0;

	protected abstract String getCategoryType();

	public Library() {

	}

	public void add(String name, String trait) {
		for (int i = 0; i < 100; i++) {
			if (this.name[i] == null) {
				this.name[i] = name;
				this.trait[i] = trait;
				status[i] = true;
				break;
			}
		}
	}

	public void remove(String name) {
		for (int i = 0; i < 100; i++) {
			if (this.name[i].equalsIgnoreCase(name)) {
				this.name[i] = null;
				this.trait[i] = null;
				status[i] = false;
				break;
			} else
				check = 1;
		}
	}

	public void checkin(String name) {
		setStatus(name, true);
	}

	public void checkout(String name) {
		setStatus(name, false);
	}

	private void setStatus(String name, boolean status) {
		for (int i = 0; i < 100; i++) {
			if (this.name[i].equalsIgnoreCase(name)) {
				this.status[i] = status;
				break;
			}
		}
	}

	public boolean getstatus(String name) {
		for (int i = 0; i < 100; i++) {
			if (this.name[i].equalsIgnoreCase(name)) {
				return status[i];
			}
		}
		return false;
	}

	public String getstatusmessage(String name) {
		for (int i = 0; i < 100; i++) {
			if (this.name[i].equalsIgnoreCase(name)) {
				if (status[i] == true) {
					return "is availible";
				} else {
					return "is unavailible";
				}
			}
		}
		return name;
	}

}
