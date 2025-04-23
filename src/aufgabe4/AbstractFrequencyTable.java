package aufgabe4;

/**
 *
 * @author oliverbittel
 * @author Oliver Haase
 */
public abstract class AbstractFrequencyTable<T> implements FrequencyTable<T> {
	@Override
	public boolean isEmpty() {
		return this.size() == 0;
	}
	
	@Override
    public void add(T e) {
		add(e, 1);
    }

	@Override
	public void addAll(FrequencyTable<? extends T> fq) {
		// Ihr Code:
		for (int i = 0; i < fq.size(); i++) {
			Element<? extends T> e = fq.get(i);
			for (int j = 0; j < this.size(); j++) {
				Element<T> e2 = this.get(j);
				if (e.equals(e2)){
					this.add(e.getElement());
					return;
				}
			}

			this.add(e.getElement(), e.getFrequency());

		}

	}

	@Override
	public void collectNMostFrequent(int n, FrequencyTable<? super T> fq) {
		// Ihr Code:
		fq.clear();
		if (n > this.size()){
			fq.addAll(this);
		} else{
			for (int i = 0; i < n; i++) {
				//wenn die Tabelle schon sortiert ist
				Element<T> e = this.get(i);
				fq.add(e.getElement(), e.getFrequency());
			}
		}
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder("{");
		// Ihr Code:
		for (int i = 0; i < this.size(); i++) {
			s.append(this.get(i).getElement());
			s.append(":");
			s.append(this.get(i).getFrequency());
			s.append(", ");
		}
		s.append("}");
		s.append(" size = " + size());
		return s.toString();
	}
}
