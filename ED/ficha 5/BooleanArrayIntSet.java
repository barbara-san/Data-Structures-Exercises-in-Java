class BooleanArrayIntSet implements IntSet {
    private int size;   // Numero de elementos do conjunto
    private int sizeM;
    private boolean isElem[];
   
    BooleanArrayIntSet(int maxSize) {
	isElem = new boolean[maxSize+1];
	size = 0;
	sizeM = maxSize+1;
    }

    public boolean add(int x) {
	if (!contains(x)) {        
	    isElem[x] = true;
	    size++;
	    return true;
	}
	return false;
    }

    public boolean remove(int x) {
	if (contains(x)) {        
	    isElem[x] =  false;
	    size--;
	    return true;
	}
	return false;
    }
   
    public boolean contains(int x) {
	if (isElem[x] == true)
	    return true;
	return false;
    }
   
    public void clear() {
	size = 0;
	for (int i = 0; i < sizeM ; i++) {
	    if (contains(i)) {
		isElem[i] = false;
	    }
	}
    }
   
    public int size() {
	return size;
    }

    public boolean equals(IntSet s) {
	if (size != s.size()) {
	    return false;
	}
	for (int i = 0; i < sizeM - 1; i++) {
	    if (!s.contains(i) && contains(i)) {
		return false;
	    }
	    if (s.contains(i) && !contains(i)) {
		return false;
	    }
	}
	return true;
    }
	
    public IntSet intersection(IntSet s) {
	IntSet m = new BooleanArrayIntSet(sizeM);
	for (int i = 0; i < sizeM - 1; i++) {
	    if (s.contains(i) && contains(i)) {
		m.add(i);
	    }
	}
	return m;
    }

    @Override 
    public String toString() {
	String res = "{"; 
	for (int i=0; i < sizeM; i++) {
	    if (isElem[i]) {
		res += ",";
	    	res += i;
	    }
	}
	res += "}";
	return res;
    }
}