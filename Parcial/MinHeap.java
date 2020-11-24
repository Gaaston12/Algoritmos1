public class MinHeap { 
    private int[] Heap; 
    private int size; 
    private int maxsize; 
  
    private static final int FRONT = 0; 
  
    public MinHeap(int maxsize){ 
        this.maxsize = maxsize; 
        this.size = 0; 
        Heap = new int[this.maxsize]; 
        Heap[0] = Integer.MIN_VALUE; 
    } 
  
    private int padre(int pos){ 
        return pos / 2; 
    } 
  
    private int hijoIzq(int pos){ 
        return (2 * pos); 
    } 
  
    private int hijoDer(int pos){ 
        return (2 * pos) + 1; 
    } 
  
    private boolean hoja(int pos){ 
        if (pos >= (size / 2) && pos <= size){ 
            return true; 
        } 
        return false; 
    } 
  
    public void insertar(int elem) 
    { 
        if (size >= maxsize) { 
            return; 
        } 
        Heap[++size] = elem; 
        int current = size; 
  
        while (Heap[current] < Heap[padre(current)]) { 
            cambiar(current, padre(current)); 
            current = padre(current); 
        } 
    } 

    private void cambiar(int fpos, int spos){ 
        int tmp; 
        tmp = Heap[fpos]; 
        Heap[fpos] = Heap[spos]; 
        Heap[spos] = tmp; 
    } 
  

	private void ordenar(int pos){ 
        if (!hoja(pos)){ 
            if (Heap[pos] > Heap[hijoIzq(pos)] 
                || Heap[pos] > Heap[hijoDer(pos)]){ 
  
                if (Heap[hijoIzq(pos)] < Heap[hijoDer(pos)]){ 
                    cambiar(pos, hijoIzq(pos)); 
                    ordenar(hijoIzq(pos)); 
                } 
                else{ 
                    cambiar(pos, hijoDer(pos)); 
                    ordenar(hijoDer(pos)); 
                } 
            } 
        } 
    } 
  
    public void mostrar(){ 
        for (int i = 1; i <= size / 2; i++) { 
            System.out.print(" Padre: " + Heap[i]); 
            System.out.println();
            System.out.print(" Hijo Izq: " + Heap[2 * i]);
            System.out.println(); 
            System.out.print( " Hijo Der:" + Heap[2 * i + 1]);
            System.out.println(); 
        } 
        System.out.print("-------------------------------------------------");
        System.out.println(); 
    } 
  
    public void minHeap(){ 
        for (int pos = (size / 2); pos >= 1; pos--) { 
            ordenar(pos); 
        } 
    } 
  
    public int borrar(){ 
        int popped = Heap[FRONT]; 
        Heap[FRONT] = Heap[size--]; 
        ordenar(FRONT); 
        return popped; 
    } 
  

	void resta(int pos, int delta){
        Heap[2 * pos] = Heap[2 * pos] - delta;
        while (pos >= 0){
            int i = (pos - 1) / 2;
            if (delta < Heap[2 * i]){
                cambiar(Heap[pos], Heap[i]);
                Heap[2 * pos] = pos;
                Heap[2 * i + 1] = i;
                pos = i;
            }
            else
            break;
        }
        for (int i = (size / 2); i >= 1; i--) { 
            ordenar(i); 
        } 
    }
	
    public static void main(String[] arg) 
    { 
        System.out.println("The Min Heap is "); 
        MinHeap minHeap = new MinHeap(15); 
        minHeap.insertar(1);
        minHeap.insertar(7);
        minHeap.insertar(3);
        minHeap.insertar(6);
        minHeap.insertar(2);
        minHeap.insertar(5);
        minHeap.insertar(4); 
        minHeap.insertar(8);
        minHeap.mostrar();  

        //ejer1 parcial
        minHeap.resta(3, 4);

        minHeap.mostrar();
    } 
} 