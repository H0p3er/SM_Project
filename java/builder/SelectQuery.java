package builder;

public interface SelectQuery extends Table{
	public void where(String parameter);
	public void orderby(String column_name);
}
