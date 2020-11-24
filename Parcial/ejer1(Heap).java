public class MinHeap { 
    private int[] Heap; 
    private int size; 
    private int maxsize; 
  
    private static final int FRONT = 1; 
  
    public MinHeap(int maxsize){ 
        this.maxsize = maxsize; 
        this.size = 0; 
        Heap = new int[this.maxsize + 1]; 
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
  
    private boolean isLeaf(int pos){ 
        if (pos >= (size / 2) && pos <= size){ 
            return true; 
        } 
        return false; 
    } 
  

    private void cambiar(int fpos, int spos){ 
        int tmp; 
        tmp = Heap[fpos]; 
        Heap[fpos] = Heap[spos]; 
        Heap[spos] = tmp; 
    } 
  

	private void minHeapify(int pos){ 
        if (!isLeaf(pos)){ 
            if (Heap[pos] > Heap[hijoIzq(pos)] 
                || Heap[pos] > Heap[hijoDer(pos)]){ 
  
                if (Heap[hijoIzq(pos)] < Heap[hijoDer(pos)]){ 
                    cambiar(pos, hijoIzq(pos)); 
                    minHeapify(hijoIzq(pos)); 
                } 
                else{ 
                    cambiar(pos, hijoDer(pos)); 
                    minHeapify(hijoDer(pos)); 
                } 
            } 
        } 
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
  
    public void mostrar(){ 
        for (int i = 1; i <= size / 2; i++) { 
            System.out.print(" Padre: " + Heap[i] + " Hijo Izq: " + Heap[2 * i]  + " Hijo Der:" + Heap[2 * i + 1]); 
            System.out.println(); 
        } 
        System.out.print("-------------------------------------------------");
        System.out.println(); 
    } 
  
    public void minHeap(){ 
        for (int pos = (size / 2); pos >= 1; pos--) { 
            minHeapify(pos); 
        } 
    } 
  
    public int borrar(){ 
        int popped = Heap[FRONT]; 
        Heap[FRONT] = Heap[size--]; 
        minHeapify(FRONT); 
        return popped; 
    } 
  

	void DecreaseKey(int pos, int delta){

		Heap[2 * pos] = Heap[2 * pos] - delta;
        while (pos > 0){
            int iPar = (pos - 1) / 2;
            if (delta < Heap[2 * iPar]){
                cambiar(Heap[pos], Heap[iPar]);
                Heap[2 * pos] = pos;
                Heap[2 * iPar + 1] = iPar;
                pos = iPar;
            }
        }
        for (int i = (size / 2); i >= 1; i--){ 
            minHeapify(i); 
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

        minHeap.mostrar(); 
        minHeap.minHeap(); 
  
        minHeap.mostrar(); 
    } 
} 