public class TestArrayGenerator{
static public void main(String[] args){
	ArrayGenerator a = new ArrayGenerator(5);
	a.generateNewArray();
	System.out.println(a.toString());
	Sorting.mergeSort(a.getArray(), 0, 4);
	System.out.println(a.toString());
	
}

}
