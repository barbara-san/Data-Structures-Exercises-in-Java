class Rectangle {
    Point a = new Point();
    Point b = new Point();
    Rectangle(int x1,int y1,int x2,int y2) {
	a.x = x1;
	a.y = y1;
	b.x = x2; 
	b.y = y2;
    }
    Rectangle(Point p1, Point p2) {
	a = p1;
	b = p2;
    }
    public int area() {
	int ar, l, c;
	l = b.x - a.x;
	c = b.y - a.y;
	ar = l * c;
	return ar;
    }
    public int perimeter() {
	int pr, l, c;
	l = b.x - a.x;
	c = b.y - a.y;
	pr = l*2 + c*2;
	return pr;
    }
    public boolean pointInside(Point p) {
	if ((p.x <= b.x) && (p.y <= b.y) && (p.x >= a.x) && (p.y >= a.y))
	    return true;
	return false;
    }
    public boolean rectangleInside(Rectangle r) {
	if ((r.b.x <= b.x) && (r.b.y <= b.y) && (r.a.x >= a.x) && (r.a.y >= a.y))
	    return true;
	return false;
    }
    public String toString() {
	return "(" + a + "," + b + ")";
    }
}