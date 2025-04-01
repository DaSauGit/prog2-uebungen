package aufgabe1;

/**
 *
 * @author oliverbittel
 * @author Oliver Haase
 */
public abstract class AbstractFrequencyTable implements FrequencyTable {
	@Override
	public boolean isEmpty() {
		return this.size() == 0;
	}
	
	@Override
    public void add(String w) {
		add(w, 1);
    }

	@Override
	public void addAll(FrequencyTable fq) {
		// Ihr Code:
		for (int i = 0; i < fq.size(); i++) {
			Word w = fq.get(i);
			boolean vorhanden = false;
			for (int j = 0; j < this.size(); j++) {
				Word w2 = this.get(j);
				if (w.equals(w2)){
					this.add(w2.getWord());
					return;
				}
			}

			this.add(w.getWord(), w.getFrequency());

		}

	}

	@Override
	public void collectNMostFrequent(int n, FrequencyTable fq) {
		// Ihr Code:
		fq.clear();
		if (n > this.size()){
			fq.addAll(this);
		} else{
			for (int i = 0; i < n; i++) {
				//wenn die Tabelle schon sortiert ist
				Word w = this.get(i);
				fq.add(w.getWord(), w.getFrequency());
			}
		}
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder("{");
		// Ihr Code:
		for (int i = 0; i < this.size(); i++) {
			s.append(this.get(i).getWord());
			s.append(":");
			s.append(this.get(i).getFrequency());
			s.append(", ");
		}
		s.append("}");
		s.append(" size = " + size());
		return s.toString();
	}
}
