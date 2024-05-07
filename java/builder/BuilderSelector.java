package builder;

public class BuilderSelector {
	
	private SQLBuilder productBuilder;
	
	private void initBuilder(String table_name) {
		switch (table_name) {
		case "":
			this.productBuilder = new ShopBuilder();
		
			break;
		}
	}
	
	
	
	
}
