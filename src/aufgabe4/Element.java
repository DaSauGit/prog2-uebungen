package aufgabe4;

/**
 * Klasse für Wörter mit ihren Häufigkeiten.
 * @author oliverbittel
 * @author Oliver Haase
 */
public class Element<T> {
	final private T element;
	private int frequency;
	
	/**
	 * Konstruktor.
	 * @param element Element
	 * @param f H&auml;ufgkeit
	 */
	public Element(T element, int f) {
		this.element = element;
		this.frequency = f;
	}

	/**
	 * Liefert Wort zur&uuml;ck.
	 * @return Wort
	 */
	public T getElement() {
		return element;
	}

	/**
	 * Liefert H&auml;ufgkeit zur&uuml;ck.
	 * @return H&auml;ufgkeit
	 */
	public int getFrequency() {
		return frequency;
	}
	
	/**
	 * Addiert zur H&auml;ufgkeit f dazu.
	 * @param f H&auml;ufgkeits&auml;nderung.
	 */
	public void addFrequency(int f) {
		frequency += f;
	}

	@Override
	public String toString() {
		return element.toString() + ":" + frequency;
	}
}
