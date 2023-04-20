package Lab02;
public class ArrayBasedSet implements IntSet{

	private int []elements;
	private int size;
	private static int DEFAULT_MAX_SIZE=100;
	private int Max_Size=0;
	
	private void initArray(){
		elements=new int[Max_Size];
	}
	public  ArrayBasedSet() {
		Max_Size=DEFAULT_MAX_SIZE;
		initArray();
	}
	public  ArrayBasedSet(int mxSize) {
		Max_Size=mxSize;
		initArray();
	}
	
	public int getSize() {		
		return size;
	}
	@Override
	public boolean isEmpty() {
		return size==0;
	}
	@Override
	public boolean add(int newEntry) {
		if(size<Max_Size)
			return false;
		if(this.contains(newEntry)==true)
			return false;
		elements[size]=newEntry;
		size++;
		return true;
	}
	@Override
	public boolean remove(int anEntry) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void clear() {
		this.size=0;
		
	}
	@Override
	public boolean contains(int anEntry) {

		for(int i=0;i<size;i++){
			if(anEntry==elements[i])
				return true;
		}
		return false;
	}
	@Override
	public int[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public IntSet union(IntSet arg) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public IntSet intersection(IntSet arg) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public IntSet difference(IntSet arg) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String toString(){
		String str="{";
		for(int i=0;i<size;i++){
			str+=elements[i]+",";
		}
		str+="}";
		return str;
	}
	

}
