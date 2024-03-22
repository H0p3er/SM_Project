package storage;


public class StorageDTO {
	private String fileName;
    private long size;
    
	public StorageDTO() {
		super();
	}
	public StorageDTO(String fileName, long size) {
		super();
		this.fileName = fileName;
		this.size = size;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public long getSize() {
		return size;
	}
	public void setSize(long size) {
		this.size = size;
	}
    
	public static int UCLN(int a, int b) {
		if (a==0) { 
			return b;
		} 
		
		if (b==0) { 
			return a;
		}
		

		if (a<b) {
			int c = a;
			a = b;
			b = c;
		}
		
		while (a>0 && b>0) {
			int r = (int) a % b;
			a = b;
			b = r; 	
			System.out.println(a);
			System.out.println(b);
    	}
		
    	return a;
	}	
    public static void main(String[] args) {
    	System.out.print("Test"+ UCLN(6, 8));
	}
}
